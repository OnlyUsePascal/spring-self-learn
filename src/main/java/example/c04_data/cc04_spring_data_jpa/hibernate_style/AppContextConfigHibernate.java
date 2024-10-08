package example.c04_data.cc04_spring_data_jpa.hibernate_style;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryBean") // TAKE NOTICE
@ComponentScan
public class AppContextConfigHibernate {
    String host = "localhost";
    String db = "test_spring_data_jpa";
    String port = "3306";
    String user = "root";
    String pwd = "root";
    String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;

    @Bean
    DataSource dataSource() {
        MysqlDataSource datasource = new MysqlDataSource();
        datasource.setURL(conUrl);
        datasource.setUser(user);
        datasource.setPassword(pwd);
        return datasource;
    }

    @Bean
    @Primary
    Properties properties() {
        Properties properties = new Properties();
        properties.setProperty(
                "hibernate.physical_naming_strategy",
                "org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl");
        properties.setProperty(
                "hibernate.implicit_naming_strategy",
                "org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl");
        properties.setProperty("hibernate.current_session_context_class", "thread");
        properties.setProperty("hibernate.show_sql", "true");
        // properties.setProperty("hibernate.hbm2ddl.auto", "create"); // enable this will drop & re-create table
        return properties;
    }

    @Bean
    PlatformTransactionManager transactionManager(
            SessionFactory sf
    ) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sf);
        return transactionManager;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
    }

    // this bean can also generate SessionFactory wtf
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter adapter,
            Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean bean =
                new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("example.c04_data.cc04_spring_data_jpa.hibernate_style");
        bean.setPersistenceUnitName("persistence_hibernate_style");
        bean.setJpaVendorAdapter(adapter);
        bean.setDataSource(dataSource);
        bean.setJpaProperties(properties);
        return bean;
    }
}



















