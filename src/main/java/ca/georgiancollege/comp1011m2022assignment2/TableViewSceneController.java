package ca.georgiancollege.comp1011m2022assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class TableViewSceneController implements Initializable {

    @FXML
    private TableColumn<PopulationData, String> code;

    @FXML
    private TableColumn<PopulationData, String> continent;

    @FXML
    private TableColumn<PopulationData, String> name;

    @FXML
    private TableColumn<PopulationData, Integer> population;

    @FXML
    private TableColumn<PopulationData, String> region;

    @FXML
    private TableView<PopulationData> tableView;

    @FXML
    private Button viewGraph;

    @FXML
    void showGraphView(ActionEvent event) throws Exception{
        SceneManager.changeScenes(event,"GraphViewScene.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        code.setCellValueFactory(new PropertyValueFactory<>("code"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        continent.setCellValueFactory(new PropertyValueFactory<>("continent"));
        region.setCellValueFactory(new PropertyValueFactory<>("region"));
        population.setCellValueFactory(new PropertyValueFactory<>("population"));
        tableView.getItems().addAll(DBManager.getPopulationFromDb());
    }
}


