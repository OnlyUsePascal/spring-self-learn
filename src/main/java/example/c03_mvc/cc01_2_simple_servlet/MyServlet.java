package example.c03_mvc.cc01_2_simple_servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class MyServlet extends HttpServlet {
    static String MAPPING_URI = "/greeting";

    public void welcome(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().print("<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p></body></html>");
    }

    public void getStudent(HttpServletResponse resp, int sid) throws IOException {
        resp.setContentType("application/json");
        // fake id or some shit
        resp.getWriter().print("{\n" +
                "  \"id\":" + sid + ",\n" +
                "  \"age\": 55,\n" +
                "  \"name\" : \"John Doe\"\n" +
                "}");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.equals(Main.CONTEXT_PATH + MAPPING_URI)) {
            welcome(resp);
//        } else if (uri.startsWith(Main.CONTEXT_PATH + MAPPING_URI + "/student/")) {
//            getStudent(resp, (int) (Math.random() * 100));
        } else {
            throw new IllegalStateException("Help, I don't know what to do with this url");
        }
    }
}
