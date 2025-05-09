/* Пример 1.1. Ввести информацию о сотрудниках фирмы (фамилия, имя, отчество, должность, оклад).
Вывести на экран информацию в табличном виде.
        Ниже приведен код реализации.*/

// package firma;
import java.util.Scanner;
class Sotrudnik {
    String fam, im, otch, doljnost; // класс в виде структуры с полями fam, im, otch, doljnost, oklad
    int oklad;
}

public class Firma {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251"); /* создаёт объект класса Scanner и
        связывает его с клавиатурой для ввода данных с клавиатуры. В скобках указывается,
        что это будет System Input и русская кодировка, чтоб ввод был распознан как
        русский текст (System.in, "cp1251") */

        System.out.println("Введите количество сотрудников => ");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера после ввода числа

        Sotrudnik[] sotr = new Sotrudnik[kol]; // получена ссылка на массив сотрудников

        System.out.println("Введите информацию о каждом сотруднике: ");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i] = new Sotrudnik(); // получена ссылка на i-тый элемент
            // Присвоение значений полям
            System.out.print("Введите фамилию " + (i + 1) + " сотрудника => ");
            sotr[i].fam = sc.nextLine();

            System.out.print("Введите его имя => ");
            sotr[i].im = sc.nextLine();

            System.out.print("Введите его отчество => ");
            sotr[i].otch = sc.nextLine();

            System.out.print("Введите его должность => ");
            sotr[i].doljnost = sc.nextLine();

            System.out.print("Введите его оклад => ");
            sotr[i].oklad = sc.nextInt();
            sc.nextLine(); //очистка буфера
        } // end for
        // Вывод информации о сотрудниках

        for (Sotrudnik s : sotr) {

            System.out.print(s.fam + "\t" + s.im + "\t" + s.otch + "\t " + s.doljnost + "\t\t" + s.oklad + "\n");
        }
    }
}