package com.caihong.net.rpc.server;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

public class HttpServer {
    String servletName = "dispatcher";

    public void start(String ipAddr, int port) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(port);
        StandardEngine engine = new StandardEngine();
        engine.setDefaultHost(ipAddr);
        StandardHost host = new StandardHost();
        host.setName(ipAddr);

        StandardContext context = new StandardContext();
        context.setPath("");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);
        service.addConnector(connector);
        service.setContainer(engine);

        String servletName = "dispatcher";
        tomcat.addServlet("", servletName, new DispatcherServlet());
        context.addServletMappingDecoded("/*", servletName);
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
