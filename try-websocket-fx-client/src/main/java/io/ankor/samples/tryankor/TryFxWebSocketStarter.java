package io.ankor.samples.tryankor;

import at.irian.ankor.system.AnkorClient;
import at.irian.ankor.system.WebSocketFxClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TryFxWebSocketStarter extends Application {

    private final AnkorClient ankorClient;

    public static void main(String[] args) {
        launch(args);
    }
    
    public TryFxWebSocketStarter() {
        ankorClient = WebSocketFxClient.builder()
                .withApplicationName("Try Ankor JavaFX")
                .withModelName("root")
                .withServer("ws://localhost:8080/websocket/ankor")
                .build();
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        ankorClient.start();

        Pane pane = FXMLLoader.load(getClass().getClassLoader().getResource("try-ankor.fxml"));
        Scene scene = new Scene(pane);
        
        stage.setTitle("Try Ankor JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}
