package example.c05_secure.cc02_data.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
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
@EnableJpaRepositories(
        basePackages = "example.c05_secure.cc02_data.repo",
        entityManagerFactoryRef = "entityManagerFactoryBean")
@EnableTransactionManagement
@ComponentScan({"example.c05_secure.cc02_data"})
public class DataConfig {
    String host = "localhost";
    String db = "test_spring_security";
    String port = "3306";
    String user = "root";
    String pwd = "root";
    String conUrl = "jdbc:mysql://" + host + ":" + port + "/" + db;

    @Bean
    DataSource dataSource(){
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
    PlatformTransactionManager transactionManager(
            LocalContainerEntityManagerFactoryBean emfBean
    ) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emfBean.getObject());

        return transactionManager;
    }

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource,
            JpaVendorAdapter jpaVendorAdapter,
            Properties properties
    ) {
        LocalContainerEntityManagerFactoryBean bean =
                new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("example.c05_secure.cc02_data");
        bean.setPersistenceUnitName("persistence_secure"); // careful, not to clash with other unit
        bean.setJpaVendorAdapter(jpaVendorAdapter);
        bean.setDataSource(dataSource);
        bean.setJpaProperties(properties);
        return bean;
    }
}
