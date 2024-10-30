import java.util.Scanner;
public class Game
{
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game()
    {
        board = new Board();
        player1 = new Player("Игрок 1", 'X');
        player2 = new Player("Игрок 2",'O');
        currentPlayer = player1;
    }

    public void start()
    {
        while(true)
        {
            board.display();
            System.out.println(currentPlayer.getName() + ", ваш ход. Введите строку и столбец(0, 1, или 2): ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(board.isCellAvailable(row, col))
            {
                board.updateCell(row, col, currentPlayer.getSymbol());
                if (board.checkWin(currentPlayer.getSymbol()))
                {
                    board.display();
                    System.out.println(currentPlayer.getName() + " выиграл");
                    break;
                }
                if (board.isBoardFull())
                {
                    board.display();
                    System.out.println("Ничья");
                    break;
                }
                if (currentPlayer == player1)
                {
                    currentPlayer = player2;
                }
                else 
                {
                    currentPlayer = player1;
                }
            }
            else
            {
                System.out.println("Эта клетка занята, выберите другую.");
            }

        }
    }
}
