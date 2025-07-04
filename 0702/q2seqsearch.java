import java.util.Scanner;

public class q2seqsearch {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();

        
        int[] arr = new int[n];

        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        int key = sc.nextInt();

        
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (arr[i] == key) {
                found = true;
                break; 
            }
        }

        
        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        sc.close(); 
    }
}
    

