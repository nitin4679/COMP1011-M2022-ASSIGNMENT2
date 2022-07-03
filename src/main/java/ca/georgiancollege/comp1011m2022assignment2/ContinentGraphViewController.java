package ca.georgiancollege.comp1011m2022assignment2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import java.net.URL;
import java.util.ResourceBundle;


public class ContinentGraphViewController implements Initializable {

    @FXML
    private javafx.scene.chart.NumberAxis NumberAxis;

    @FXML
    private BarChart<String, Double> barChart;

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
    private void showTableView(ActionEvent event) throws Exception{
        SceneManager.changeScenes(event,"TableViewScene.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}