import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players;
    public static BufferedReader fr;
    public String line;
    public boolean isFirstLine;
    public String[] csvValues;
    private Coach coach;
    private int wins;
    private int loses;
    private double teamWinPercentage;

    /**
     * Description: This class takes the person class and the coach class and makes
     * them one. Creating a team.
     * 
     * @param teamCode
     * @param wins
     * @param loses
     * @param coachName
     * @param playoffStatus
     * @throws Exception
     * @author Joel Menezes
     */
    public Team(String teamCode, int wins, int loses, String coachName, int playoffStatus) throws Exception {
        this.wins = wins;
        this.loses = loses;
        this.teamWinPercentage = getTeamWinPercentage();
        coach = new Coach(coachName, teamCode, teamWinPercentage, playoffStatus);
        players = new ArrayList<>();
        fr = new BufferedReader(new FileReader("src\\all_player_stats.csv"));
        while ((line = fr.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
            } else {
                csvValues = line.split(",");
                if (csvValues[0].equals(teamCode))
                    players.add(new Player(csvValues[1], Integer.parseInt(csvValues[3]), Integer.parseInt(csvValues[4]),
                            Double.parseDouble(csvValues[6]), Double.parseDouble(csvValues[9]),
                            Double.parseDouble(csvValues[10]),
                            Double.parseDouble(csvValues[11]), Double.parseDouble(csvValues[12]),
                            Double.parseDouble(csvValues[13]),
                            Double.parseDouble(csvValues[14]), Double.parseDouble(csvValues[18]),
                            Double.parseDouble(csvValues[19]),
                            Double.parseDouble(csvValues[24]), Double.parseDouble(csvValues[15]),
                            Double.parseDouble(csvValues[28]),
                            Double.parseDouble(csvValues[29]), csvValues[2], csvValues[0], teamWinPercentage));
            }
        }
    }

    /**
     * Description: This method is used to calculate win percentage from wins and
     * loses
     * 
     * @return double win percentage
     * @author Joel
     */
    public double getTeamWinPercentage() {
        return (double) wins / (loses + wins) * 100.0;
    }

    /**
     * Description: Returns a list of players on a team that are eligible for MVP
     * 
     * @return List<Player> list of MVP eligible players
     * @author Joel
     */
    public List<Player> getMVPEligiblePlayers() {
        List<Player> MVPCandidates = new ArrayList<>();
        for (Player player : players)

            if (player.isEligibleForAwards("mvp"))
                MVPCandidates.add(player);

        return MVPCandidates;
    }

    /**
     * Description: Returns a list of players on a team that are eligible for 6MOY
     * 
     * @return List<Player> list of 6MOY eligible players
     * @author Joel
     */
    public List<Player> get6MOYEligiblePlayers() {
        List<Player> SixMOYCandidates = new ArrayList<>();
        for (Player player : players)
            if (player.isEligibleForAwards("6moy"))
                SixMOYCandidates.add(player);
        return SixMOYCandidates;
    }

    /**
     * Description: Returns a list of players on a team that are eligible for DPOY
     * 
     * @return List<Player> list of DPOY eligible players
     * @author Joel
     */
    public List<Player> getDPOYEligiblePlayers() {
        List<Player> DPOYCandidates = new ArrayList<>();
        for (Player player : players)
            if (player.isEligibleForAwards("dpoy"))
                DPOYCandidates.add(player);
        return DPOYCandidates;
    }

    /**
     * Description: returns the heart of the team, the coach.
     * 
     * @return Coach returns the coach of the team
     * @author Joel
     */
    public Coach getCoach() {
        return coach;
    }

    /**
     * Description: Finds the best player on the team using the MVP score
     * 
     * @return Player returns best player from the team
     * @author Joel
     */
    public Player getBestPlayer() {
        Player bestPlayer = null;

        for (Player player : players) {
            if (bestPlayer == null) {
                bestPlayer = player;
            } else {
                if (player.getMVPScore() > bestPlayer.getMVPScore()) {
                    bestPlayer = player;
                }
            }
        }
        return bestPlayer;
    }
}
