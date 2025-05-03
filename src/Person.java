public abstract class Person {
    protected String name;
    protected double teamWinPercentage;
    private String position;
    protected String teamCode;

    /**
     * Description: This class is an abstract class for players on a team. Holding
     * basic data and general functions all people on the team need.
     * 
     * @param name
     * @param teamWinPercentage
     * @param position
     * @param teamCode
     * @author Joel
     */
    public Person(String name, double teamWinPercentage, String position, String teamCode) {
        this.name = name;
        this.teamWinPercentage = teamWinPercentage;
        this.teamCode = teamCode;
        this.position = position;
    }

    /**
     * Description: Returns info like Name, Position, Salary, Team and WIN
     * percentage
     * 
     * @return String, basic ifno of the person
     * @author Joel
     */
    public String getInfo() {
        return name + " " + position + String.format(" - Salary: $%.2f ", getSalary()) + " - " + teamCode
                + " - W%" + String.format(" %.2f", teamWinPercentage) + "%";
    }

    /**
     * Description: Abstract method, Coaches and Players have a different salary
     * formula.
     * 
     * @return double, returns the Person's salary
     * @author Joel
     */
    public abstract double getSalary();

    /**
     * Description: Returns the info of the person, calling the getInfo method, so
     * if item is printed it will print the Person's info.
     * 
     * @return String returns info of the person
     * @author Joel
     */
    public String toString() {
        return getInfo();
    }

}
