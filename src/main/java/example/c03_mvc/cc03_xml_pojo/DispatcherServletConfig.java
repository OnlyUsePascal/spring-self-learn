package example.c03_mvc.cc03_xml_pojo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"example.c03_mvc.cc03_xml_pojo"})
public class DispatcherServletConfig implements WebMvcConfigurer {
      @Bean
      public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/resources/");
        internalResourceViewResolver.setSuffix(".jsp");

        return internalResourceViewResolver;
      }

}
