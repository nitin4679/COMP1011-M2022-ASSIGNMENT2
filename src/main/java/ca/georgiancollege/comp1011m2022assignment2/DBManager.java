package ca.georgiancollege.comp1011m2022assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    private static String user = "student";
    private static String password = "123456";
    private static String connectionURL = "jdbc:mysql://localhost:3306/world";

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
}
