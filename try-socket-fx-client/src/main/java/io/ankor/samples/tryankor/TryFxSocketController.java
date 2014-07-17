package io.ankor.samples.tryankor;

import at.irian.ankor.action.Action;
import at.irian.ankor.annotation.ChangeListener;
import at.irian.ankor.fx.binding.fxref.FxRef;
import at.irian.ankor.fx.binding.fxref.FxRefs;
import at.irian.ankor.fx.controller.FXControllerSupport;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class TryFxSocketController implements Initializable {

    private FxRef rootRef;

    @FXML
    public TextField helloWorld;

    @FXML
    public Text count;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rootRef = FxRefs.refFactory().ref("root");
        FXControllerSupport.init(this, rootRef);
    }

    @ChangeListener(pattern = "root")
    public void initialize() {
        helloWorld.textProperty().bindBidirectional(
                rootRef.appendPath("helloWorld").<String>fxProperty());

        count.textProperty().bindBidirectional(
                rootRef.appendPath("count").<Number>fxProperty(),
                new NumberStringConverter());
        
        rootRef.fire(new Action("init"));
    }

    public void onAction(ActionEvent actionEvent) {
        // HACK: Change events is not firing without this???
    }
}
