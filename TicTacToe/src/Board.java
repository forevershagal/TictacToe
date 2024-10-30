public class Board
{
    public char [][] board;

    public Board()
    {
        board = new char[3][3];
        for (int i= 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = '-';
            }
        }
    }

    public void display()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    public boolean isCellAvailable(int row, int col)
    {
        return board[row][col] == '-';
    }

    public void updateCell(int row, int col, char symbol)
    {
        board[row][col] = symbol;
    }

    public boolean checkWin(char symbol)
    {
        for (int i = 0; i < 3; i++)
        {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol)
            {
                return true;
            }
        }

        for (int i =0; i < 3; i++)
        {
            if(board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)
            {
                return true;
            }
        }

        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
        {
            return true;
        }

        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)
        {
            return true;
        }
        return false;
    }

    public boolean isBoardFull()
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] == '-')
                {
                    return false;
                }
            }
        }
        return true;
    }
}
