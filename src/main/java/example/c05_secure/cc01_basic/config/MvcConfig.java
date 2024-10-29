package example.c05_secure.cc01_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Dispatcher Servlet
@Configuration
@EnableWebMvc
@ComponentScan({"example.c05_secure.cc01_basic"})
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver () {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/resources/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
