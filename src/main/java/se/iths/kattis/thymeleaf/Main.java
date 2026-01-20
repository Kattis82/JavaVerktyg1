package se.iths.kattis.thymeleaf;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.IOException;

// http://localhost:8080/

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Test test 123");

        // 1. Konfigurera Thymeleaf
        ClassLoaderTemplateResolver resolver =
                new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        // 2. Starta webbserver
        Server server = new Server(8080);

        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        // 3. Servlet som renderar HTML
        context.addServlet(new ServletHolder(new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req,
                                 HttpServletResponse resp) throws IOException {

                Context thymeleafContext = new Context();
                thymeleafContext.setVariable("message",
                        "Hej från Thymeleaf utan Spring!");

                resp.setContentType("text/html;charset=UTF-8");
                templateEngine.process("index",
                        thymeleafContext,
                        resp.getWriter());
            }
        }), "/");

        server.setHandler(context);
        server.start();
        server.join();
    }
}

