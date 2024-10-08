package example.c04_data.cc04_spring_data_jpa.jpa_style;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryBean") // TAKE NOTICE
@EnableTransactionManagement
@ComponentScan
public class AppContextConfigJpa {
    String host = "localhost";
    String db = "test_spring_data_jpa";
    String port = "3306";
    String user = "root";
    String pwd = "root";
    String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;

    @Bean
    @Scope(scopeName = "singleton")
    DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(conUrl);
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        return dataSource;
    }

    @Bean
    JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        return adapter;
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
        return properties;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter,
            Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean bean =
                new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("example.c04_data.cc04_spring_data_jpa.jpa_style");
        bean.setPersistenceUnitName("persistence_jpa_style"); // careful, not to clash with other unit
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setDataSource(dataSource);
        bean.setJpaProperties(properties);
        return bean;
    }

    @Bean
    PlatformTransactionManager transactionManager(
            LocalContainerEntityManagerFactoryBean emfBean
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emfBean.getObject());
        return transactionManager;
    }
}



















