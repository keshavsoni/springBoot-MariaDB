package com.keshav.hl.springmariaDB.Entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="UserInfo")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class UserEntity extends BaseEntity  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1197005900156558323L;

	@Id
	@Column(name="User_id")
    private UUID id;

    @Column(name="FirstName")
    private String firstName;
    
    @Column(name="LastName")
    private String lastName;
    
    @Column(name="Email",unique=true)
    private String email;
    
    @Column(name="Mobile")
    private Long mobile;
    
    @OneToMany(mappedBy="userEntity",cascade=CascadeType.ALL)
    private List<AddressEntity> listOfAddress;
    
    
}
