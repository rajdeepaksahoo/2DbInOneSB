package com.example.demo.db2.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactory1",
		basePackages = {
				"com.example.demo.repo2"
			}
		)
public class Db2Config {
	@Primary
	@Bean(name = "dataSource1")
	@ConfigurationProperties(prefix = "spring.db2.datasource")
	DataSource dataSource () {
		return DataSourceBuilder.create().build();
	}
	
	@Primary
	@Bean(name = "entityManagerFactory1")
	LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean (org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder builder,
			@Qualifier(value = "dataSource1") DataSource dataSource) {
				
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("hibernate.hbm2ddl.auto", "update");
		
		return builder.dataSource(dataSource)
				.properties(hashMap)
				.packages("com.example.demo.entity2")
				.persistenceUnit("db2")
				.build();
		
	}
	@Primary
	@Bean(name = "transactionManager1")
	PlatformTransactionManager manager (@Qualifier(value = "entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}
}
