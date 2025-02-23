/* Вариант 5
Разработать класс для хранения информации о футбольных командах :
Название, город, место_в_лиге, количество_побед
и реализовать алгоритм работы с массивом данных объектов, в котором
требуется:
– определить команду с самым большим количеством побед;
– определить команды с количеством побед больше среднего;
– упорядочить массив по убыванию мест в лиге;
– организовать поиск по названию команды
Общий алгоритм
1. Ввести количество команд.  "Ввести количество команд : " 3
2. Ввести название команды.  "Введите название первой команды : " Spartak
3. Ввести город каждой команды.  "Введите город первой команды : " Moscow
4. Ввести количество побед у каждой команды. "Введите количество побед у первой команды : " 10
5. Определить команду с самым большим количеством побед.
6. Вывести команду с самым большим количеством побед. "Команда с самым большим количеством побед : " 1. Spartak 10 побед
7. Определить общее количество побед со всех команд
8. Определить среднее количество побед со всех команд (общее количество побед / количество команд)
9. Вывести команды с количеством побед больше среднего.
"Команды с количеством побед больше среднего : "
 Spartak
 Zenit
10. Сделать сортировку команд по убыванию мест в лиге (по количеству побед).
10.1 Вывести команды по убыванию мест в лиге (по количеству побед).
" Команды по убыванию мест в лиге (по количеству побед) : "
1 Spartak
2 Zenit
3 Dinamo
11. Вывести поиск по названию команды исправление одного из полей
и вывод полной информации о команде после редактирования.
12. Закончить. */


        import java.sql.ResultSetMetaData;
        import java.util.ArrayList;
        import java.util.Scanner;
        class Team {
        String nameTeam, cityTeam; // класс в виде структуры с полями
         int kolWin, teamNumber;
}
        public class FootballTeam {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in, "cp1251");
           
            

            // ВВОД ИНФОРМАЦИИ О КОМАНДАХ
            System.out.print("Введите количество команд => ");
            int n = sc.nextInt(); // количество команд
            Team[] tm = new Team[n]; // получена ссылка на массив команд n

            // Создаем массив фиксированной длины
            int[] numbersArray = new int[n];
            // Заполняем массив цифрами
            for (int i = 0; i < numbersArray.length; i++) {
                numbersArray[i] = i + 1; // заполняем от 1 до n
            }
            // Выводим значения массива
            System.out.println("Мест в лиге : ");
            for (int number : numbersArray) {
                System.out.println(number);

            }


        /* Выводим значения списка
            System.out.println("Мест в лиге : " + n);

            /*for ( tm[i].teamNumber : numbersList) {
                System.out.println(tm[i].teamNumber);
            /* for (int i = 0; i < numbersList.size(); i++) {
                tm[i].teamNumber = numbersList.get(i); */

                /* System.out.println("Команда #" + (i + 1) + ": " + teams.get(i)); */



        System.out.println("Введите информацию о командах : ");
        for (int i = 0; i < tm.length; i++) {
            sc.nextLine(); // очистка буфера
            tm[i] = new Team();
            System.out.print("Название " + (i + 1) + "-й команды => ");
            tm[i].nameTeam = sc.nextLine();
            System.out.print("Город " + (i + 1) + "-й команды => ");
            tm[i].cityTeam = sc.nextLine();
            System.out.print("Количество побед " + (i + 1) + "-й команды => ");
            tm[i].kolWin = sc.nextInt();
            /*tm[i].teamNumber = sc.nextInt();
            sc.nextLine();*/

        }
            // ВЫВОД ПОЛУЧЕННОЙ ИНФОРМАЦИИ
            System.out.println("\n Турнирная таблица : ");
            for (int i = 0; i < tm.length; i++) {
                /*tm[i].teamNumber = sc.nextInt(); */
                System.out.println(" " + tm[i].teamNumber + (i + 1) + " " + tm[i].nameTeam + " " + tm[i].cityTeam + " " + tm[i].kolWin);
            }
            // Команда с самым большим количеством побед
            int kolWinmax = 0; // номер элемента для команды с самым большим количеством побед (начальное значение)
            double max = tm[kolWinmax].kolWin; // максимальное количество побед (начальное значение)
            for (int i = 0; i < tm.length; i++)
            if (tm[i].kolWin > max) {
                max = tm[i].kolWin;
                kolWinmax = i;

            }
            System.out.println("\nКоманда с самым большим количеством побед : ");
            System.out.println(" " + tm[kolWinmax].nameTeam + " " + tm[kolWinmax].cityTeam + " " + tm[kolWinmax].kolWin);

            // Количество побед больше среднего
            double s = 0; // суммарное количество побед
            for (int i = 0; i < tm.length; i++)
                s += tm[i].kolWin;
            double sr = s/tm.length; ; // среднее количество побед
            System.out.println("Среднее количество побед = " + sr);
            System.out.println("\nКоманды, с количеством побед больше среднего");
            for (int i = 0; i < tm.length; i++) {
                if (tm[i].kolWin > sr)
                    System.out.println(tm[i].nameTeam + " " + tm[i].cityTeam + " " + tm[i].kolWin);
            }
            // Сортировка команд по убыванию мест в лиге (по количеству побед)
            for (int i = 0; i < tm.length-1; i++)
                for (int j = 0; j < tm.length-1-i; j++)
                    if (tm[j].kolWin < tm[j+1].kolWin) {
                        Team rab = tm[j]; // rab – рабочая переменная для перестановки
                        tm[j] = tm[j+1];
                        tm[j+1]=rab;

                    }
            System.out.println("\nОтсортированный список команд по количеству побед : ");
            for (int i = 0; i < tm.length; i++) {
                System.out.println(" " + tm[i].teamNumber + (i + 1) + " " + tm[i].nameTeam + " " + tm[i].cityTeam + " " + tm[i].kolWin);
                }

            // Поиск по названию команды
            sc.nextLine(); // очистка буфера
            System.out.println("Введите название искомой команды => ");
            String name=sc.nextLine();
            int nm = -1; // -1 – команда с искомым названием отсутствует

            for (int i = 0; i < tm.length; i++)
                if (name.equalsIgnoreCase(tm[i].nameTeam))
                    nm=i;
            if (nm!= -1) {
                System.out.println("Такая команда есть в списке. Это " + tm[nm].nameTeam + " " + tm[nm].cityTeam + " " + tm[nm].kolWin);
            } else System.out.println("Такой команды нет в списке");


            }


        }


