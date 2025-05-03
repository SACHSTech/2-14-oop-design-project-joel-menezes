public class Player extends Person {
    private int gamesPlayed;
    private int gamesStarted;
    private double PPG;
    private double RPG;
    private double AST;
    private double STL;
    private double BLK;
    private double TO;
    private double PF;
    private double FG;
    private double TPP;
    private double FT;
    private double ASTTO;
    private double SCEFF;
    private double SHEFF;

    /**
     * Description: This player class specifically deals with the calculation of
     * stats and scores for players on the court.
     * 
     * @param name
     * @param gamesPlayed
     * @param gamesStarted
     * @param PPG
     * @param RPG
     * @param AST
     * @param STL
     * @param BLK
     * @param TO
     * @param PF
     * @param FG
     * @param TPP
     * @param FT
     * @param ASTTO
     * @param SCEFF
     * @param SHEFF
     * @param position
     * @param teamCode
     * @param teamWinPercentage
     * @author Joel
     */
    public Player(String name, int gamesPlayed, int gamesStarted, double PPG, double RPG, double AST, double STL,
            double BLK, double TO, double PF, double FG, double TPP, double FT, double ASTTO, double SCEFF,
            double SHEFF, String position, String teamCode, double teamWinPercentage) {
        super(name, teamWinPercentage, position, teamCode);
        this.gamesPlayed = gamesPlayed;
        this.gamesStarted = gamesStarted;
        this.PPG = PPG;
        this.RPG = RPG;
        this.AST = AST;
        this.STL = STL;
        this.BLK = BLK;
        this.TO = TO;
        this.PF = PF;
        this.FG = FG;
        this.TPP = TPP;
        this.FT = FT;
        this.ASTTO = ASTTO;
        this.SCEFF = SCEFF;
        this.SHEFF = SHEFF;
        this.teamWinPercentage = teamWinPercentage;

    }

    /**
     * Description: Finds the best player all around based on stats
     * 
     * @return int Most Valueable Player score value
     * @author Joel
     */
    public int getMVPScore() {

        return (int) ((0.2 * PPG * gamesPlayed) + (0.15 * AST * gamesPlayed) + (0.12 * RPG * gamesPlayed)
                + (0.08 * STL * gamesPlayed) +
                (0.07 * BLK * gamesPlayed) + (0.07 * FG) + (0.05 * TPP) + (0.05 * FT) + (0.04 * ASTTO) + (0.04 * SCEFF)
                + (0.03 * SHEFF) + (0.1 * teamWinPercentage) - (0.05 * TO * gamesPlayed) - (0.03 * PF * gamesPlayed));
    }

    /**
     * Description: Finds the best on the ball defender based on stats
     * 
     * @return int Defensive Player of the Year score value
     * @author Joel
     */
    public int getDPOYScore() {
        return (int) ((0.25 * STL * gamesPlayed) + (0.25 * BLK * gamesPlayed) + (0.08 * TO * gamesPlayed)
                + (0.05 * PF * gamesPlayed));
    }

    /**
     * Description: Finds the best off the bench player based on stats
     * 
     * @return int 6th Man of the Year score value
     * @author Joel
     */
    public int get6MOYScore() {
        return (int) ((0.25 * PPG * gamesPlayed) + (0.15 * AST * gamesPlayed) + (0.1 * RPG * gamesPlayed)
                + (0.08 * STL * gamesPlayed) + (0.07 * FG) + (0.07 * TPP)
                + (0.05 * FT)
                + (0.05 * SCEFF) + (0.03 * ASTTO) - (0.3 * TO * gamesPlayed));

    }

    /**
     * Description: Calculates a player salary based on personal stats
     * 
     * @return double, players salary
     * @author Joel
     */
    @Override
    public double getSalary() {
        return 10000000 + (100000
                * (PPG * gamesPlayed + 1.2 * RPG * gamesPlayed + AST * gamesPlayed * 1.5 + 2 * STL * gamesPlayed
                        + 2 * BLK * gamesPlayed - 2 * TO * gamesPlayed)
                / gamesPlayed);
    }

    /**
     * Description: Finds and returns if a player is eligible for MVP, DPOY, or 6MOY
     * based on specific requirements
     * 
     * @param award
     * @return boolean, returns if a player is eligible for certain awards
     * @author Joel
     */
    public boolean isEligibleForAwards(String award) {
        switch (award.toLowerCase()) {
            case "mvp":
                if (gamesPlayed >= 65)
                    return true;
                else
                    return false;
            case "dpoy":
                if (gamesPlayed >= 65)
                    return true;
                else
                    return false;
            case "6moy":
                if (gamesPlayed >= 65 && gamesStarted < gamesPlayed / 2.0)
                    return true;
                else
                    return false;

            default:
                return false;
        }

    }

}