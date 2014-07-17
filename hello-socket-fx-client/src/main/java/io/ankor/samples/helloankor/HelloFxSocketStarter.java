package io.ankor.samples.helloankor;

import at.irian.ankor.system.AnkorClient;
import at.irian.ankor.system.SocketFxClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloFxSocketStarter extends Application {

    private final AnkorClient ankorClient;

    public static void main(String[] args) {
        launch(args);
    }
    
    public HelloFxSocketStarter() {
        ankorClient = SocketFxClient.builder()
                .withApplicationName("Hello Ankor JavaFX")
                .withModelName("root")
                .build();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        ankorClient.start();

        Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("hello-ankor.fxml"));
        Scene scene = new Scene(pane);
        
        stage.setTitle("Hello Ankor JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}
