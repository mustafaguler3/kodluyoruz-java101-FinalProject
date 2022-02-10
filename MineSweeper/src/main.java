import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a row :");
        int row = scanner.nextInt();
        System.out.println("Enter a col :");
        int col = scanner.nextInt();
        MineSweeper mayin=new MineSweeper(row,col);
        mayin.run();


    }
}












