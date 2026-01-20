package se.iths.kattis.thymeleaf2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String path = req.getPathInfo();
        
        String name = (path != null && path.length() > 1)
                ? path.substring(1)
                : "vän";

        Context context = new Context();
        context.setVariable("name", name);

        resp.setContentType("text/html;charset=UTF-8");

        ThymeleafConfig.getTemplateEngine()
                .process("hello", context, resp.getWriter());
    }
}
