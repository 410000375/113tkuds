
public class BasicArrayOperations {public static void main(String[] args) {
        int[] numbers = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        System.out.println("陣列長度: " + numbers.length);

        numbers[2] = 99;
        numbers[numbers.length - 1] = 100;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("索引 " + i + ": " + numbers[i]);
        }
    }
}
    

