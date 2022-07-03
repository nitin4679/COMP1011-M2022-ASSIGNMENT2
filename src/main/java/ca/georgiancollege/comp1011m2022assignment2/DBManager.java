package ca.georgiancollege.comp1011m2022assignment2;

import javafx.scene.chart.XYChart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

// singleton

public class DBManager {
    /********************** SINGLETON SECTION **************************/
    //step 1- private static instance member variable
    private static DBManager m_instance = null;
    //step2 - make the default constructor private
    private DBManager(){}
    //step3 - create a public static entry point / instance method
    public static DBManager Instance()
    {
        //step4 - check if the private instance member variable is null
        if(m_instance == null)
        {
            //step5 - Instantiate a new DBManager instance
            m_instance = new DBManager();
        }
        return m_instance;
    }
    /********************************************************************* */

    // private instance member variables
    private static String user = "student";
    private static String password = "123456";
    private static String connectionURL = "jdbc:mysql://localhost:3306/world";

    // this method will retrieve data for top ten countries and population...for countryGraph View scene
    public  static ArrayList<PopulationData> getPopulationFromDb(){
        ArrayList<PopulationData> pop = new ArrayList<PopulationData>();
        String sql = "select code, name, continent, region, population from country order by population desc limit 10;";

        try (Connection connection = DriverManager.getConnection(connectionURL, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()){
                String code = resultSet.getString("CODE");
                String name = resultSet.getString("NAME");
                String continent = resultSet.getString("CONTINENT");
                String region = resultSet.getString("REGION");
                int population = resultSet.getInt("POPULATION");

                PopulationData newPopulationData = new PopulationData(code,name,continent,region,population);

                pop.add(newPopulationData);
            }


        } catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return pop;
    }

    // this method will retrieve data for top continents and population...for continentGraph View scene
    public  static ArrayList<PopulationData> getPopulationForContinent(){
        ArrayList<PopulationData> pop = new ArrayList<PopulationData>();
        String sql = "select continent, sum(population) population from country group by continent order by population desc;";

        try (Connection connection = DriverManager.getConnection(connectionURL, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()){

                String continent = resultSet.getString("CONTINENT");

                Double populationContinent = resultSet.getDouble("POPULATION");

                PopulationData newPopulationData = new PopulationData(continent,populationContinent);

                pop.add(newPopulationData);
            }


        } catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return pop;
    }

    // this method will retrieve data for top region and population...for regionGraph View scene

    public  static ArrayList<PopulationData> getPopulationForRegion(){
        ArrayList<PopulationData> pop = new ArrayList<PopulationData>();
        String sql = "select region, sum(population) population from country group by region order by population desc limit 10;";

        try (Connection connection = DriverManager.getConnection(connectionURL, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);)
        {
            while (resultSet.next()){

                String region = resultSet.getString("REGION");

                Double regionPopulation = resultSet.getDouble("POPULATION");

                PopulationData newPopulationData = new PopulationData(region,regionPopulation);

                pop.add(newPopulationData);
            }


        } catch(Exception exception)
        {
            exception.printStackTrace();
        }

        return pop;
    }

    // this method is to return country bar chart data
    public static XYChart.Series<String, Integer> getCountryPopulation() {
        XYChart.Series<String,Integer> countryPopulation = new XYChart.Series<>();
        countryPopulation.setName("Country");
        ArrayList<PopulationData> result = getPopulationFromDb();
        for(PopulationData finalResult : result){
            countryPopulation.getData().add(new XYChart.Data<>(finalResult.getName(), finalResult.getPopulation()));
        }
        return countryPopulation;
    }


    // this method is to return continent bar chart data
    public static XYChart.Series<String, Double> getContinentPopulation() {
        XYChart.Series<String,Double> continentPopulation = new XYChart.Series<>();
        continentPopulation.setName("Continent");
        ArrayList<PopulationData> result = getPopulationForContinent();
        for(PopulationData finalResult : result){
            continentPopulation.getData().add(new XYChart.Data<>(finalResult.getContinent(), finalResult.getPopulationContinent()));
        }
        return continentPopulation;
    }

    // this method is to return region bar chart data
    public static XYChart.Series<String, Double> getRegionPopulation() {
        XYChart.Series<String,Double> regionPopulation = new XYChart.Series<>();
        regionPopulation.setName("Region");
        ArrayList<PopulationData> result = getPopulationForRegion();
        for(PopulationData finalResult : result){
            regionPopulation.getData().add(new XYChart.Data<>(finalResult.getContinent(), finalResult.getPopulationContinent()));
        }
        return regionPopulation;
    }
}
