// package example.c04_data.c02_spring_data;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// // import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
// // import org.springframework.boot.context.properties.ConfigurationProperties;
// // import org.springframework.boot.context.properties.EnableConfigurationProperties;
// // import org.springframework.boot.jdbc.DataSourceBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.core.env.Environment;
// import org.springframework.data.jdbc.repository.config.AbstractJdbcConfiguration;
// import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.jdbc.datasource.DriverManagerDataSource;
// import org.springframework.transaction.TransactionManager;
//
// import javax.sql.DataSource;
//
//
// @Configuration
// @EnableJdbcRepositories
// @ComponentScan("example.c04_data.c01_jdbc.c02_spring_data")
// @PropertySource("classpath:c04_01_02.properties")
// // bonus spring boot
// // @EnableConfigurationProperties(DataSourceProperties.class)
// // @ConfigurationProperties(prefix = "spring.datasource")
// public class AppConfig extends AbstractJdbcConfiguration {
//     String propPrefix = "mysql.";
//     final String dataSourceQualifier = "dataSourceSpringData";
//
//     // bonus spring boot
//     // @Autowired
//     // DataSourceProperties properties;
//     // @Bean("dataSourceSpringBoot")
//     // DataSource dataSource2() {
//     //     // data source by spring boot :)
//     //     DataSourceBuilder builder = DataSourceBuilder
//     //             .create()
//     //             .url(properties.getUrl())
//     //             .username(properties.getUsername())
//     //             .password(properties.getPassword())
//     //             .driverClassName(properties.getDriverClassName());
//     //     // System.out.println(properties.getUsername());
//     //     return builder.build();
//     // }
//
//     @Autowired
//     Environment env;
//
//     @Bean("dataSourceSpringData")
//     DataSource dataSource() {
//         // data source by spring data
//         String url = "jdbc:mysql://" + env.getProperty(propPrefix + "host")
//                 + ":" + env.getProperty(propPrefix + "port")
//                 + "/" + env.getProperty(propPrefix + "db");
//
//         DriverManagerDataSource dataSource = new DriverManagerDataSource();
//         dataSource.setUrl(url);
//         dataSource.setUsername(env.getProperty(propPrefix + "user"));
//         dataSource.setPassword(env.getProperty(propPrefix + "pwd"));
//
//         return dataSource;
//     }
//
//     @Bean
//     TransactionManager transactionManager(@Qualifier(dataSourceQualifier)
//                                           DataSource dataSource) {
//         return new DataSourceTransactionManager(dataSource);
//     }
//
//     @Bean
//     NamedParameterJdbcOperations namedParameterJdbcOperations(@Qualifier(dataSourceQualifier)
//                                                               DataSource dataSource) {
//         return new NamedParameterJdbcTemplate(dataSource);
//     }
// }
