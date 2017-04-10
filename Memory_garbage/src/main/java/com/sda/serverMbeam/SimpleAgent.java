package com.sda.serverMbeam;



import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class SimpleAgent {

    private MBeanServer mbs = null;

    public SimpleAgent() {

        mbs = ManagementFactory.getPlatformMBeanServer();

        Server serverBean = new Server();
        ObjectName serverName = null;

        try {
            serverName = new ObjectName("FOO:name=aaa");
            mbs.registerMBean(serverBean, serverName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForEnterPressed() {
        try {
            System.out.println("Press  to continue...");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
