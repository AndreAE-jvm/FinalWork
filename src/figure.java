import java.util.ArrayList;

public class figure {
    public static void main(String[] args) {
        // Создаем массив фиксированной длины
        int[] numbersArray = new int[5];

        // Заполняем массив цифрами
        for (int i = 0; i < numbersArray.length; i++) {
            numbersArray[i] = i + 1; // например, заполняем от 1 до 5
        }

        // Выводим значения массива
        System.out.println("Массив чисел:");

        for (int number : numbersArray) {
            System.out.println(number);
        }
    }}
/*
// Или используем ArrayList для динамического размера
        ArrayList<Integer> numbersList = new ArrayList<>();

        // Добавляем цифры в ArrayList
        for (int i = 0; i < 5; i++) {
            numbersList.add(i + 1); // добавляем от 1 до 5
        }

        // Выводим значения списка
        System.out.println("Список чисел:");
        for (int number : numbersList) {
            System.out.println(number);
        }
    }
} */

