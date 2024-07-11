import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the rows");
        int row = sc.nextInt();
        System.out.println("Enter the coloums");
        int col = sc.nextInt();
        int food = 0;
        Snake s = new Snake(row,col,food = row>col?row:col);
        Random random = new Random();
        int r = random.nextInt(row);
        int c = random.nextInt(col);
        s.snakegame(r, c);
        
    }
}
