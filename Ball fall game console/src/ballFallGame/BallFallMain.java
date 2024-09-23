package ballFallGame;

import java.util.Scanner;


public class BallFallMain {
    private char[][] box;
    Scanner scan;
    int size;

    public static void main(String[] args) {
        BallFallMain ballFallMain = new BallFallMain();
        ballFallMain.start();
    }

    public void start() {
        scan = new Scanner(System.in);
        System.out.println("Enter the box size. N*N based and Odd value only");
        size = scan.nextInt();
        prepareBox(size);
        System.out.println("\n\nEnter The Balls Falling index...");
        int input = 0;
        while(true) {
            try {
                input = scan.nextInt();
            } catch(Exception e) {
                System.out.println("Enter Integer Values only");
                continue;
            }
            placeBall(input);
            printBox();
        }
    }

    public void placeBall(int index) {
        int row = size - 1 ;
        int col = index + (size / 2);

        while(box[row][col] == '0') {
            row--;
        }
        int leftRow = row;
        int leftCol = col;
        int rightRow = row;
        int rightCol = col;
        boolean left = false , right = false;
        while((rightRow + 1 < size && rightCol + 1 < size ) && box[rightRow + 1][rightCol + 1] != '0') {
            right = true; rightRow++; rightCol++;
        }
        if(rightRow < size && rightCol < size && right) {
            box[rightRow][rightCol] = '0';
            return;
        }
        while((leftRow + 1 < size && leftCol - 1 >= 0 ) && box[leftRow + 1][leftCol - 1] != '0') {
            left = true; leftRow++ ; leftCol--;
        }
        if(leftRow < size && leftCol >= 0 && left) {
            box[leftRow][leftCol] = '0';
            return;
        }
        box[row][col] = '0';
    }

    public void prepareBox(int size) {
        box = new char[size][size];
        box[size - 1][size / 2] = '0';
        System.out.println("Initital Box");
        printBox();
    }

    public void printBox() {
        for(int i = 0 ; i < box.length ; i++) {
            for(int j = 0 ; j < box.length ;j++) {
                System.out.format("%4S", box[i][j]) ;
            }
            System.out.println();
        }
        int start =  (box.length / 2) - ((box.length / 2) * 2);
        for(int i = start ; i < start + box.length ; i++) {
            System.out.format("%4S",i);
        }
    }
}
