package biz.nellemann.mdexpl.model;

public class Device {

    private String name;
    private String abbr;
    private String capital;
    private int population;
    private int area; /* km^2 */
    private String flag;

    public Device(String name, String abbr, String capital, int population, int area, String flag) {
        this.name = name;
        this.abbr = abbr;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * Population density
     * @return population density (pop. per km^2)
     */
    public double getDensity() {
        if (area > 0) {
            return (double) population / (double) area;
        }
        return 0;
    }

    @Override
    public String toString() {
        return name + " (" + abbr + "), capital=" + capital + ", population=" + population + ", area=" + area;
    }

}


