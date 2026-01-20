package se.iths.kattis.thymeleaf2;

import se.iths.kattis.ovning1.HelloServlet;
import se.iths.kattis.ovning1.RootServlet;

// http://localhost:8081/
//  http://localhost:8081/hello/Kattis

public class Main {
    public static void main(String[] args) throws Exception {
        
        var server = new org.eclipse.jetty.server.Server(8081);
        //i denna context kan man registrera servlets
        var context = new org.eclipse.jetty.servlet.ServletContextHandler();
        server.setHandler(context);
        context.addServlet(RootServlet.class, "/");
        context.addServlet(HelloServlet.class, "/hello/*");

        //starta servern
        server.start();
        server.join();


    }

}

