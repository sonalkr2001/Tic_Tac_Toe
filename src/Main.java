import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        char[][] board=new char[3][3];
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                board[i][j]=' ';
            }
        }
        char player='x';
        boolean gameover=false;
        Scanner sc=new Scanner(System.in);
        while(!gameover)
        {
            printBoard(board);
            System.out.println("please enter row and col value batween 0 to 2");
            System.out.println("Player"+" "+player+" "+"enter");
            int i=sc.nextInt();
            int j=sc.nextInt();
            if(board[i][j]== ' ')
            {
                board[i][j]=player;
                gameover=won(board,player);
                if(gameover)
                {
                    printBoard(board);
                    System.out.println("player"+" "+player+" "+"has won the match");
                }
                else
                {
                    if(player =='x')
                    {
                        player='o';
                    }
                    else
                    {
                        player='x';
                    }
                }
            }
            else
            {
                System.out.println("Invalid move Try again");
            }
        }

    }
    public static boolean won(char board[][], char player)
    {
        // check for rows
        for(int i=0;i<board.length;i++)
        {
            if(board[i][0] == player && board[i][1] == player && board[i][2]== player)
            {
                return true;
            }
        }
        // check for colomn
        for(int j=0;j<board[0].length;j++)
        {
            if(board[0][j] == player && board[1][j] == player && board[2][j]== player)
            {
                return true;
            }
        }
        // check Daigonally
        if(board[0][0] == player && board[1][1]==player && board[2][2]==player)
        {
            return true;
        }
        if(board[0][2] == player && board[1][1]==player && board[2][0]==player)
        {
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j] +" | ");
            }
            System.out.println( );
        }
    }
}