import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class server {

    public static void main(String[] args) {
        Tomcat theserver = new Tomcat();
        theserver.setBaseDir("java.io tmpdir");
        theserver.setPort(8080);
        theserver.getConnector();
        theserver.addContext("", null);

        theserver.addServlet("", "main", new MainServlet()).addMapping("/*");
        theserver.addServlet("", "tv", new tvServlet()).addMapping("/tv");
        theserver.addServlet("", "search", new tvServlet()).addMapping("/tvsearch");

        try {
            theserver.start();
            theserver.getServer().await();
            } catch (LifecycleException e) {
                e.printStackTrace();
        }
    }
}
