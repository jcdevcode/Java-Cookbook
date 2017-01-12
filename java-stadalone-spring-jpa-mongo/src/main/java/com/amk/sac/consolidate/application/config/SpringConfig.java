package com.amk.sac.consolidate.application.config;

import java.util.Arrays;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages={"com.amk.sac.consolidate.*"})
@EnableMongoRepositories(basePackages={"com.amk.sac.consolidate.data.repos.*"})
@EnableJpaRepositories(basePackages={"com.amk.sac.consolidate.data.dao.*"})
public class SpringConfig extends AbstractMongoConfiguration{
	
	  @Bean
	    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
	        em.setDataSource(dataSource());
	        em.setPackagesToScan(new String[] { "com.amk.sac.consolidate.model" });

	        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	        em.setJpaVendorAdapter(vendorAdapter);
	        em.setJpaProperties(additionalProperties());

	        return em;
	    }

	    @Bean
	    public DataSource dataSource() {
	        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        StringBuilder strUrl = new StringBuilder();
	        strUrl.append("jdbc:mysql://")
	        	.append(ApplicationProperties.getStringValue("sql.db.host"))
	        	.append(":")
	        	.append(ApplicationProperties.getStringValue("sql.db.port"))
	        	.append("/")
	        	.append(ApplicationProperties.getStringValue("sql.db.name"));
	        dataSource.setUrl(strUrl.toString());
	        dataSource.setUsername(ApplicationProperties.getStringValue("sql.db.user"));
	        dataSource.setPassword(ApplicationProperties.getStringValue("sql.db.pass"));

	        return dataSource;
	    }

	    @Bean
	    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
	        final JpaTransactionManager transactionManager = new JpaTransactionManager();
	        transactionManager.setEntityManagerFactory(emf);
	        return transactionManager;
	    }

	    @Bean
	    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
	        return new PersistenceExceptionTranslationPostProcessor();
	    }

	    final Properties additionalProperties() {
	        final Properties hibernateProperties = new Properties();
	        hibernateProperties.setProperty("hibernate.hbm2ddl.auto",ApplicationProperties.getStringValue("hibernate.hbm2ddl.auto"));
	        hibernateProperties.setProperty("hibernate.dialect", ApplicationProperties.getStringValue("hibernate.dialect"));
	        hibernateProperties.setProperty("hibernate.show_sql", ApplicationProperties.getStringValue("jpa.show.query"));
	        return hibernateProperties;
	    }

		@Override
		protected String getDatabaseName() {
			return ApplicationProperties.getStringValue("nosql.db.name");
		}

		@Override
		public Mongo mongo() throws Exception {		
			
			ServerAddress serverAddress = new ServerAddress(
					ApplicationProperties.getStringValue("nosql.db.host"), 
					ApplicationProperties.getIntegerValue("nosql.db.port"));

			MongoCredential credential = MongoCredential.createCredential(
					ApplicationProperties.getStringValue("nosql.db.user"),
			                getDatabaseName(),
			                ApplicationProperties.getStringValue("nosql.db.pass").toCharArray());
		
			MongoClient client =  new MongoClient(serverAddress, Arrays.asList(credential));		
			
			return client;

		}
				
	    protected String getMappingBasePackage() {
	        return "com.amk.sac.consolidate.data";
	    }
	    
	    
}
