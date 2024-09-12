import java.util.HashSet;
import java.util.Set;

public class MinRFinder {
    // Константы
    private static final int MAX_VALUE = 10000;
    private static final int TARGET_MULTIPLIER = 21;
    private static final int SEQUENCE_SIZE = 1000;

    public static void main(String[] args) {
        int[] sequence = generateSequence(SEQUENCE_SIZE);
        int result = findMinR(sequence);

        if (result == -1) {
            System.out.println("Подходящее число R не найдено.");
        } else {
            System.out.println("Минимальное R: " + result);
        }
    }

    private static int[] generateSequence(int size) {
        // Генерация случайной последовательности
        int[] sequence = new int[size];
        for (int i = 0; i < size; i++) {
            sequence[i] = (int) (Math.random() * (MAX_VALUE + 1));
        }
        return sequence;
    }
    private static int findMinR(int[] sequence) {
        Set<Integer> uniqueElements = new HashSet<>();
        int minR = Integer.MAX_VALUE;

        // Собираем уникальные элементы
        for (int num : sequence) {
            uniqueElements.add(num);
        }

        Integer[] uniqueArray = uniqueElements.toArray(new Integer[0]);

        // Проходим по всем парам уникальных элементов
        for (int i = 0; i < uniqueArray.length; i++) {
            for (int j = i + 1; j < uniqueArray.length; j++) {
                int product = uniqueArray[i] * uniqueArray[j];

                // Проверяем условия
                if (product <= MAX_VALUE && product % TARGET_MULTIPLIER == 0) {
                    minR = Math.min(minR, product);
                }
            }
        }

        // Если minR остался максимальным значением, значит подходящего числа не найдено
        return minR == Integer.MAX_VALUE ? -1 : minR;
    }
}