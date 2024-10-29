package example.c05_secure.cc02_data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Dispatcher Servlet
@Configuration
@EnableWebMvc
@ComponentScan({"example.c05_secure.cc02_data"})
public class MvcConfig implements WebMvcConfigurer {
    @Bean
    public InternalResourceViewResolver viewResolver () {
//        System.out.println("> view resolver");
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/resources/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}
