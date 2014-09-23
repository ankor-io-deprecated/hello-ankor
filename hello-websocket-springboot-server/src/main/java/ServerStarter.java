import at.irian.ankor.application.Application;
import at.irian.ankor.application.GenericApplication;
import at.irian.ankor.system.WebSocketSpringBootServer;
import io.ankor.samples.helloankor.HelloAnkorRootModel;
import org.springframework.boot.SpringApplication;

public class ServerStarter extends WebSocketSpringBootServer {

    @Override
    protected Application createApplication() {
        GenericApplication application = new GenericApplication();
        application.setName("Hello Ankor (via Spring Boot)");
        application.setDefaultModelType(HelloAnkorRootModel.class);
        return application;
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerStarter.class, args);
    }
}
