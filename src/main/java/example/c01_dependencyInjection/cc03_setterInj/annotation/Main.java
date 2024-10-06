package example.c01_dependencyInjection.cc03_setterInj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Controller controller = context.getBean(Controller.class);
        controller.send("send nude");
    }
}
