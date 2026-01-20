package se.iths.kattis.thymeleaf2;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;

import java.io.IOException;

@WebServlet("/")
public class RootServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        Context context = new Context();
        context.setVariable("message", "Välkommen till startsidan");

        resp.setContentType("text/html;charset=UTF-8");

        ThymeleafConfig.getTemplateEngine()
                .process("index2", context, resp.getWriter());
    }
}
