package com.company;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();
    public static void getBoard(char[][] gameBoard){
        for (char[] row : gameBoard){
            for (char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void makePlacement(char[][] gameBoard, String user, int pos){
        char mode = ' ';
        if (user.equals("player")){
            mode = 'X';
            playerPosition.add(pos);
        }else if(user.equals("cpu")){
            cpuPosition.add(pos);
            mode = 'O';
        }
        switch (pos){
            case 1:
                gameBoard[0][0] = mode;
                break;
            case 2:
                gameBoard[0][2] = mode;
                break;
            case 3:
                gameBoard[0][4] = mode;
                break;
            case 4:
                gameBoard[2][0] = mode;
                break;
            case 5:
                gameBoard[2][2] = mode;
                break;
            case 6:
                gameBoard[2][4] = mode;
                break;
            case 7:
                gameBoard[4][0] = mode;
                break;
            case 8:
                gameBoard[4][2] = mode;
                break;
            case 9:
                gameBoard[4][4] = mode;
                break;

        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);

        List leftCol = Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rigCol = Arrays.asList(3,6,9);

        List dia1 = Arrays.asList(1,5,9);
        List dia2 = Arrays.asList(7,5,3);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);

        win.add(leftCol);
        win.add(midCol);
        win.add(rigCol);

        win.add(dia1);
        win.add(dia2);
        for (List l : win){
            if (playerPosition.containsAll(l)){
                return "Congrats, You won.....";
            }else if (cpuPosition.containsAll(l)){
                return "Ooops, Computer Won.....! :(";
            }else if (playerPosition.size() + cpuPosition.size() == 6){
                return "CAT....!";
            }
        }
        return "";
    }
    public static void main(String[] args) {
        char[] [] gameBoard = {{' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ', '|', ' '},
                            {'-', '+', '-', '+', '-'},
                            {' ', '|', ' ', '|', ' '}
        };
       while (true){
           System.out.print("Enter the placement: ");
           Scanner in = new Scanner(System.in);
           int pos = in.nextInt();
           while (playerPosition.contains(pos) || cpuPosition.contains(pos)){
               System.out.print("Position taken..!, Enter the correct position: ");
               pos = in.nextInt();
           }
           String result = checkWinner();
           if(result.length() > 0){
               System.out.println(result);
               break;
           }
           makePlacement(gameBoard,"player", pos);
           Random r = new Random();
           int cPos = r.nextInt(9) + 1;
           while (playerPosition.contains(cPos) || cpuPosition.contains(cPos)){
               cPos = r.nextInt(9) + 1;
           }
           makePlacement(gameBoard,"cpu", cPos);
           getBoard(gameBoard);
           result = checkWinner();
           if(result.length() > 0){
                System.out.println(result);
                break;
           }
       }
    }
}
