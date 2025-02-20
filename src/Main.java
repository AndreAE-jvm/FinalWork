import java.util.ArrayList;
import java.util.List;

class BasketballTeam {
    String name;
    String city;

    public BasketballTeam(String name, String city) {
        this.name = name;
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " из " + city;
    }
}

public class Main {
    public static void main(String[] args) {
        List<BasketballTeam> teams = new ArrayList<>();
        teams.add(new BasketballTeam("Лейкерс", "Лос-Анджелес"));
        teams.add(new BasketballTeam("Бостон", "Бостон"));
        teams.add(new BasketballTeam("Майами", "Майами"));

        // Нумерация и вывод
        for (int i = 0; i < teams.size(); i++) {
            System.out.println("Команда #" + (i + 1) + ": " + teams.get(i));
        }
    }
}