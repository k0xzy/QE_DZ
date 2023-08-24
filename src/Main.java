import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println(SumFactorialsOfPrimes(5));

        // Задание 2
        var change = Vending(41, 88);
        change.forEach((key, value) -> System.out.println(key + " " + value));

        // Задание 3
        System.out.println(Lenses(new int[]{1, -1, 2, 3, -3}));
    }

    // <summary> Задание 1 Сумма факториалов всех простых чисел, не превышающих X </summary>
    // <param name="primeX"> Число Х </param>
    // <returns> Сумма </returns>
    public static int SumFactorialsOfPrimes(int primeX) {
        int sum = 0;
        for (int num = 2; num <= primeX; num++) {
            if (isPrime(num)) {
                sum += factorial(num);
            }
        }
        return sum;
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }


    // <summary> Задание 2 ПО для вендингового аппарата </summary>
    // <param name="orderSum"> Сумма заказа </param>
    // <param name="clientSum"> Внесенная сумма клиентом </param>
    // <returns> Сдача в виде словаря { номинал : количество }</returns>
    public static HashMap<Integer, Integer> Vending(int orderSum, int clientSum) {
        int[] denominations = {5000, 2000, 1000, 500, 200, 100, 50, 10, 5, 2, 1};
        HashMap<Integer, Integer> change = new HashMap<>();
        int remainingChange = clientSum - orderSum;

        for (int denomination : denominations) {
            if (remainingChange >= denomination) {
                int count = remainingChange / denomination;
                change.put(denomination, count);
                remainingChange -= denomination * count;
            }
        }

        return change;
    }

    // <summary> Задание 3 Заказы на линзы для Инопланетян </summary>
    // <param name="dioptries"> Значения диоптрий каждого Инопланетянина </param>
    // <returns> Количество пар линз </returns>
    public static int Lenses(int[] dioptries) {
        Arrays.sort(dioptries); // Сортируем диоптрии для оптимизации

        int count = 1; // Счетчик начинается с 1, так как первая линза уже формирует пару
        int n = dioptries.length;

        for (int i = 1; i < n; i++) {
            if (dioptries[i] - dioptries[i - 1] > 1) {
                count++; // Добавляем новую пару линз
            }
        }

        return count;
    }
}