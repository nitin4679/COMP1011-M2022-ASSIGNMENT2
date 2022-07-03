package ca.georgiancollege.comp1011m2022assignment2;

public class PopulationData
{

    // Private Instance Members
    private String code;
    private String name;
    private String continent;
    private String region;
    private int population;

    // Constructors

    public PopulationData(String code, String name, String continent, String region, int population)
    {
        setCode(code);
        setName(name);
        setContinent(continent);
        setRegion(region);
        setPopulation(population);
    }


 // Setter Getters

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getContinent()
    {
        return continent;
    }

    public void setContinent(String continent)
    {
        this.continent = continent;
    }

    public String getRegion()
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }


}
