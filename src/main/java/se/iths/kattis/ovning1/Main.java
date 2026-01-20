package se.iths.kattis.ovning1;


public class Main {
    public static void main(String[] args) throws Exception {
        var server = new org.eclipse.jetty.server.Server(8080);
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
