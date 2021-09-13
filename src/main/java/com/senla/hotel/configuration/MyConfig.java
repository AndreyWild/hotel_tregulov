package com.senla.hotel.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

@Configuration
@ComponentScan("com.senla.hotel")
@EnableWebMvc
@EnableTransactionManagement
public class MyConfig {

    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource(); // подключение к БД
        try {
            dataSource.setDriverClass("com.mysql.cj.jdbc.Driver"); // драйвер
            dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/hotel?autoReconnect=true&useSSL=false&serverTimezone=UTC");
            dataSource.setUser("root");
            dataSource.setPassword("root");

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.senla.hotel.model.entities");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        hibernateProperties.setProperty("hibernate.show_sql", "true");

        sessionFactory.setHibernateProperties(hibernateProperties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());

        return transactionManager;
    }

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }


}
