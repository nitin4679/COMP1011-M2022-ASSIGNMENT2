package ca.georgiancollege.comp1011m2022assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewSceneController implements Initializable {

    @FXML
    private TableColumn<?, ?> code;

    @FXML
    private TableColumn<?, ?> continent;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> population;

    @FXML
    private TableColumn<?, ?> region;

    @FXML
    private TableView<?> tableView;

    @FXML
    private Button viewGraph;

    @FXML
    void showGraphView(ActionEvent event) throws Exception{
        SceneManager.changeScenes(event,"GraphViewScene.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}


