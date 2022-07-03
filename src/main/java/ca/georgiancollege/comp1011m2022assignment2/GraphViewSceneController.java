package ca.georgiancollege.comp1011m2022assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class GraphViewSceneController implements Initializable {

    @FXML
    private NumberAxis NumberAxis;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private RadioButton continentRadio;

    @FXML
    private RadioButton countryRadio;

    @FXML
    private RadioButton regionRadio;

    @FXML
    private Button viewTable;

    @FXML
    void showTableView(ActionEvent event) throws Exception{
        SceneManager.changeScenes(event,"TableViewScene.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
