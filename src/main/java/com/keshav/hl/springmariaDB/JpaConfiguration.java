package com.keshav.hl.springmariaDB;

import javax.sql.DataSource;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
/*@EnableJpaRepositories(basePackages = "com.keshav.hl.springmariaDB.Repository",
entityManagerFactoryRef = "entityManagerFactory",
transactionManagerRef = "transactionManager")*/
@EnableSpringConfigured
public class JpaConfiguration {
		    
	   /* @Bean
		 @ConfigurationProperties(prefix="keshav.learning")
		 public HikariDataSourceConfig hikariDataSourceConfig() {
			 return hikariDataSourceConfig();
		 }*/
	    
	    @Bean(name = "keshavLearningDataSource")
	    public DataSource keshavLearningDataSource() {
	    	HikariDataSourceConfig hikariCfg = new HikariDataSourceConfig();
	    	hikariCfg.setJdbcUrl("jdbc:mariadb://localhost:3306/springbootdb");
	    	hikariCfg.setUsername("root");
	    	hikariCfg.setPassword("admin");
	    	hikariCfg.setDriverClassName("org.mariadb.jdbc.Driver");
	        return createDataSource(hikariCfg);
	    }
	    
	 
	 private static DataSource createDataSource(HikariDataSourceConfig hikariCfg) {
	        HikariConfig config = new HikariConfig();
	        BeanUtils.copyProperties(hikariCfg, config);
	        return new HikariDataSource(config);
	    }
	    
	    
	     
	 
}