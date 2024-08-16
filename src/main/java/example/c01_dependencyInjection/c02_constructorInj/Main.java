package example.c01_dependencyInjection.c02_constructorInj;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.Parameter;
import org.picocontainer.parameters.ConstantParameter;

public class Main {
    public static void main(String[] args) {
        MutablePicoContainer picoContainer = new DefaultPicoContainer();
        Parameter[] params = {new ConstantParameter("Joun Pham")};
        picoContainer.addComponent(MailService.class, MailServiceGmail.class, params);
        picoContainer.addComponent(Controller.class);

        Controller controller = picoContainer.getComponent(Controller.class);
        controller.send("send nude");
    }
}
