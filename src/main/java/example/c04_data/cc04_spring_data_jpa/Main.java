package example.c04_data.cc04_spring_data_jpa;

import example.c04_data.cc04_spring_data_jpa.hibernate_style.AppContextConfigHibernate;
import example.c04_data.cc04_spring_data_jpa.jpa_style.AppContextConfigJpa;
import example.c04_data.cc04_spring_data_jpa.jpa_style.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppContextConfigJpa.class);
        StudentService studentService = context.getBean(StudentService.class);
        // studentService.execBasic();
        // studentService.execTransaction();

        context =
                new AnnotationConfigApplicationContext(AppContextConfigHibernate.class);
        example.c04_data.cc04_spring_data_jpa.hibernate_style.StudentService studentService2 =
                context.getBean(example.c04_data.cc04_spring_data_jpa.hibernate_style.StudentService.class);
        // studentService2.execBasic();
        // studentService2.execTransaction();

    }
}