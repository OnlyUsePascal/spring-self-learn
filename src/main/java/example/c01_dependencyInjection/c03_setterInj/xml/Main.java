package example.c01_dependencyInjection.c03_setterInj.xml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String configFile = "classpath:c01_03.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(configFile);
        Controller controller = context.getBean(Controller.class);
        controller.send("send more nudes");
    }
}
