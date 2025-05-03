import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.List;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static BufferedReader fr;
    public static BufferedReader br;
    public static String line;
    public static boolean isFirstLine;
    public static String[] csvValues;
    public static HashMap<String, Team> teams;
    public static List<Player> MVPCandidates;
    public static Player bestPlayer;

    public static void main(String[] args) throws Exception {
        isFirstLine = true;
        teams = new HashMap<>();

        fr = new BufferedReader(new FileReader("src\\Teams.csv"));
        br = new BufferedReader(new InputStreamReader(System.in));
        while ((line = fr.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
            } else {
                csvValues = line.split(",");
                teams.put(csvValues[0],
                        new Team(csvValues[0], Integer.parseInt(csvValues[1]), Integer.parseInt(csvValues[2]),
                                csvValues[4],
                                Integer.parseInt(csvValues[3])));
            }
        }
        mainMenu();
    }

    /**
     * Description: Helper method in order to print and manage the main menu
     * 
     * @throws Exception
     * @author Joel
     */
    public static void mainMenu() throws Exception {
        System.out.println("Hello Commissioner");
        System.out.println("What would like to find?");
        System.out.println("1. Most Valuable Player Winner");
        System.out.println("2. Defensive Player Of the Year Winner");
        System.out.println("3. 6th Man Of the Year Winner");
        System.out.println("4. Bad Coaches");
        System.out.println("5. Good Coaches");
        System.out.println("6. Coaches Salary");
        System.out.println("7. Teams Best Player");
        String choice = br.readLine();

        switch (choice) {
            case "1":
                MVPCandidates = new ArrayList<>();
                for (Team team : teams.values())
                    MVPCandidates.addAll(team.getMVPEligiblePlayers());
                bestPlayer = null;
                for (Player player : MVPCandidates) {
                    if (bestPlayer == null) {
                        bestPlayer = player;
                    } else {
                        if (player.getMVPScore() > bestPlayer.getMVPScore()) {
                            bestPlayer = player;
                        }
                    }
                }
                System.out.println("Most Valuable Player: " + bestPlayer.getInfo());
                break;
            case "2":
                List<Player> DPOYCandidates = new ArrayList<>();
                for (Team team : teams.values())
                    DPOYCandidates.addAll(team.getDPOYEligiblePlayers());

                bestPlayer = null;
                for (Player player : DPOYCandidates) {
                    if (bestPlayer == null) {
                        bestPlayer = player;
                    } else {
                        if (player.getDPOYScore() > bestPlayer.getDPOYScore()) {
                            bestPlayer = player;
                        }
                    }
                }
                System.out.println("Defensive Player Of the Year: " + bestPlayer.getInfo());
                break;
            case "3":
                List<Player> SixMOYCandidates = new ArrayList<>();
                for (Team team : teams.values())
                    SixMOYCandidates.addAll(team.get6MOYEligiblePlayers());

                bestPlayer = null;
                for (Player player : SixMOYCandidates) {
                    if (bestPlayer == null) {
                        bestPlayer = player;
                    } else {
                        if (player.get6MOYScore() > bestPlayer.get6MOYScore()) {
                            bestPlayer = player;
                        }
                    }
                }
                System.out.println("6th Man of the Year: " + bestPlayer.getInfo());
                break;
            case "4":
                System.out.println("Coaches To Fire");

                for (Team team : teams.values()) {
                    if (team.getCoach().isFireable()) {
                        System.out.println(team.getCoach());
                    }
                }
                break;
            case "5":
                System.out.println("Coaches To Keep");
                for (Team team : teams.values()) {
                    if (!team.getCoach().isFireable()) {
                        System.out.println(team.getCoach());
                    }
                }
                break;
            case "6":
                while (true) {
                    System.out.println("What's the Coaches Team Code?");

                    choice = br.readLine();
                    try {
                        System.out.println(teams.get(choice.toUpperCase()).getCoach());
                        break;
                    } catch (NullPointerException e) {
                        System.out.println("atl, bos, bkn, cha, chi, cle, dal, den, det, gs, " +
                                "hou, ind, lac, lal, mem, mia, mil, min, no, ny, " +
                                "okc, orl, phi, phx, por, sac, sa, tor, utah, wsh");
                        continue;
                    }
                }
                break;

            case "7":
                while (true) {
                    System.out.println("What's The Team Code?");

                    choice = br.readLine().toUpperCase();
                    try {
                        System.out.println(
                                "Best Player on " + choice + ": " + teams.get(choice.toUpperCase()).getBestPlayer());
                        break;
                    } catch (NullPointerException e) {
                        System.out.println("Select on of these: ");
                        System.out.println("atl, bos, bkn, cha, chi, cle, dal, den, det, gs, " +
                                "hou, ind, lac, lal, mem, mia, mil, min, no, ny, " +
                                "okc, orl, phi, phx, por, sac, sa, tor, utah, wsh");
                        continue;
                    }
                }
                break;
            default:
                break;
        }
    }
}
