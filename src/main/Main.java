package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import servlet.ServletStudy;

/**
 * Created by voldem on 02.11.2015.
 */
public class Main {
    public static void main(String []args) throws Exception {
        Server server = new Server(8080);
        ServletHandler handler = new ServletHandler();
        server.setHandler(handler);
        handler.addServletWithMapping(ServletStudy.class, "/*");
        server.start();
        server.join();
    }
}
