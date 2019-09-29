package com.memorize.conf;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class JPAConfig {

	@Autowired
	private Environment env;

	private DataSourceWrapper dataSourceWrapper = new DataSourceWrapper("local");

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

		factoryBean.setDataSource(this.getDataSource());
		factoryBean.setJpaProperties(this.getJpaProperties());
		factoryBean.setPackagesToScan("com.memorize.modules");
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

		return factoryBean;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	private DriverManagerDataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUsername(
			env.getProperty( dataSourceWrapper.getStringUserValue() )
		);
		dataSource.setDriverClassName(
			env.getProperty( dataSourceWrapper.getStringDriverValue() )
		);
		dataSource.setPassword(
			env.getProperty( dataSourceWrapper.getStringPasswordValue() )
		);
		dataSource.setUrl(
			env.getProperty( dataSourceWrapper.getStringUrlValue() )
		);

		return dataSource;
	}

	private Properties getJpaProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", env.getProperty(dataSourceWrapper.getStringDialectValue()) );
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");

		return properties;
	}

}
