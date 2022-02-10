import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    int roww, coll, size;
    int map[][];
    int board[][];
    boolean isGame = true;

    public MineSweeper(int roww, int coll) {
        this.roww = roww;
        this.coll = coll;
        this.map = new int[roww][coll];
        this.board = new int[roww][coll];
        this.size = roww * coll;

    }

    public void run() {
        int row, col,succes=0;
        prepareGame();
        print(map);
        System.out.println("==Game has started==");
        while (isGame == true) {
            print(board);
            System.out.println("value of the row :");
            row = scanner.nextInt();
            System.out.println("value of the col :");
            col = scanner.nextInt();
            if(row<0 || row>roww)
            {
                System.out.println("Not valid coordinate");
                continue;
            }
            if(col < 0 || col > coll)
            {
                System.out.println("==Not valid coordinate==");
                continue;
            }
            if (map[row][col] == -1) {
                System.out.println("==you lost==");
                isGame = false;

            } else if (map[row][col] != -1) {
                succes++;
                if(succes==size-(size/4))
                {
                    System.out.println("==you won==");
                    break;
                }
                check(row, col);
            }

        }
    }

    public void prepareGame() {
        int colRand, rowRand, count = 0;
        while (count != (size / 4)) {
            rowRand = rand.nextInt(roww);
            colRand = rand.nextInt(coll);
            if (map[rowRand][colRand] != -1) {
                map[rowRand][colRand] = -1;
                count++;
            }
        }

    }

    public void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void check(int r, int c) {
        if(map[r][c]==0){
            if ( c>0 && map[r][c - 1] == -1) {
                board[r][c]++;
            }
            if ( c<roww -1 && map[r][c + 1] == -1) {
                board[r][c]++;
            }
            if (r>0&& map[r - 1][c] == -1) {
                board[r][c]++;
            }

            if (r<roww -1 && map[r + 1][c] == -1) {
                board[r][c]++;
            }

            if(board[r][c]==0)
            {
                board[r][c]=-2;
            }
        }

    }
}
