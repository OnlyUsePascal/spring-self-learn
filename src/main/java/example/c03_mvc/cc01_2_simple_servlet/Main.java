package example.c03_mvc.cc01_2_simple_servlet;

import org.eclipse.jetty.ee10.servlet.ServletContextHandler;
import org.eclipse.jetty.server.Server;

public class Main {
    static int PORT = 8080;
    static String CONTEXT_PATH = "/self-learn";

    public void exec() throws Exception{
        // servlet container
        ServletContextHandler contextHandler = new ServletContextHandler();
        contextHandler.setErrorHandler(null);
        contextHandler.setContextPath(CONTEXT_PATH);
        contextHandler.addServlet(MyServlet.class, MyServlet.MAPPING_URI);

        Server server = new Server(PORT);
        server.setHandler(contextHandler);
        server.start();
        System.out.println("Listening at port: " + PORT);
        server.join();
    }
    public static void main(String[] args) throws Exception{
        System.out.println("Hello world!");
        new Main().exec();
    }
}