import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

class FootballTeam1 {
    private String name;
    private String city;
    private int leaguePosition;
    private int wins;

    public FootballTeam1(String name, String city, int leaguePosition, int wins) {
        this.name = name;
        this.city = city;
        this.leaguePosition = leaguePosition;
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public int getWins() {
        return wins;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Команда: " + name + ", Город: " + city + ", Место в лиге: " + leaguePosition + ", Победы: " + wins;
    }
}

public class FootballLeagueManager {
    private List<FootballTeam1> teams;

    public FootballLeagueManager() {
        teams = new ArrayList<>();
    }

    public void addTeam(FootballTeam1 team) {
        teams.add(team);
    }

    public FootballTeam1 getTeamWithMostWins() {
        return teams.stream().max(Comparator.comparingInt(FootballTeam1::getWins)).orElse(null);
    }

    public List<FootballTeam1> getTeamsWithMoreWinsThanAverage() {
        OptionalDouble averageWins = teams.stream().mapToInt(FootballTeam1::getWins).average();
        return teams.stream().filter(team -> team.getWins() > averageWins.orElse(0)).toList();
    }

    public void sortTeamsByLeaguePosition() {
        teams.sort(Comparator.comparingInt(FootballTeam1::getLeaguePosition));
    }

    public void editTeam(String name) {
        for (FootballTeam1 team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите новый город:");
                team.setCity(scanner.nextLine());
                System.out.println("Введите новое место в лиге:");
                team.setLeaguePosition(scanner.nextInt());
                System.out.println("Введите новое количество побед:");
                team.setWins(scanner.nextInt());
                System.out.println("Информация о команде обновлена: " + team);
                return;
            }
        }
        System.out.println("Команда не найдена.");
    }

    public static void main(String[] args) {
        FootballLeagueManager manager = new FootballLeagueManager();
        manager.addTeam(new FootballTeam1("Team A", "City A", 1, 10));
        manager.addTeam(new FootballTeam1("Team B", "City B", 2, 8));
        manager.addTeam(new FootballTeam1("Team C", "City C", 3, 12));

        // Определение команды с самым большим количеством побед
        FootballTeam1 bestTeam = manager.getTeamWithMostWins();
        System.out.println("Команда с самым большим количеством побед: " + bestTeam);

        // Команды с количеством побед больше среднего
        List<FootballTeam1> aboveAverageTeams = manager.getTeamsWithMoreWinsThanAverage();
        System.out.println("Команды с количеством побед больше среднего:");
        aboveAverageTeams.forEach(System.out::println);

        // Упорядочивание массива по убыванию мест в лиге
        manager.sortTeamsByLeaguePosition();
        System.out.println("Команды упорядоченные по местам в лиге:");
        manager.teams.forEach(System.out::println);

        // Поиск и редактирование команды
        manager.editTeam("Team A");
    }
}
