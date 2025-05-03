
public class Coach extends Person {
    private int playoffStatus;

    /**
     * Description: This Coach class specifically deals with Head Coaching staff of
     * teams, judging how good they are, their salaries or if they should be fired
     * 
     * @param name
     * @param teamCode
     * @param teamWinPercentage
     * @param playoffStatus
     * @author Joel
     */
    public Coach(String name, String teamCode, double teamWinPercentage, int playoffStatus) {
        super(name, teamWinPercentage, "Coach", teamCode);
        this.playoffStatus = playoffStatus;
    }

    /**
     * Description: Calculates coachs salary based on how they got their team to
     * perform
     * 
     * @return double, returns the salary of the coach based on team metrics
     * @author Joel
     */
    @Override
    public double getSalary() {
        double salary = 5000000.00 + (super.teamWinPercentage / 100.00 * 5000000.00 * 0.200)
                + (50000.00 * playoffStatus);
        return salary;
    }

    /**
     * Description: Some times coaches are the fault of the team, this method
     * decides if they stay or elave
     * 
     * @return boolean, returns if the coach should be fired based on team stats
     * @author Joel
     */
    public boolean isFireable() {
        double firebilityScore = (-10.0 * teamWinPercentage / 100.0) + (-4 * playoffStatus);

        return firebilityScore > 0.35 ? true : false;
    }

}
