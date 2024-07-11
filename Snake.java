import java.util.*;

public class Snake{
    char[][] snakeboard = null;
    Queue<Node> queue = new LinkedList<Node>() ;
    Random random = new Random();
    Snake(int row,int col,int food){
        this.snakeboard = new char[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                snakeboard[i][j] = '0';
            }
        }
        this.queue.add(new Node(0,0));
        for(int i=0;i<food;i++){
            placerandom(row,col);
        }
        
    }
    public void placerandom(int row,int col){
        int r,c;
        do{
            r = random.nextInt(row);
            c = random.nextInt(col);
        }while(snakeboard[r][c]!='0');
        snakeboard[r][c] = 'X';
    }
    
    public void snakegame(int row,int col){
        if((row>=0 && row<snakeboard.length) && (col>=0 && col<snakeboard[0].length)){
            if(snakeboard[row][col]=='.'){
                System.out.println("Game Over! Snake strikes itself");
                System.exit(0);
            }
            queue.add(new Node(row,col));
            if (snakeboard[row][col] == 'X') {
                placerandom(snakeboard.length, snakeboard[0].length);
            } else {
                Node node = queue.poll();
                int r = node.getrow();
                int c = node.getcol();
                snakeboard[r][c] = '0';
            }
            snakeboard[row][col] = '.';
            while(!queue.isEmpty()){
                printsnakeboard();
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter your position to move");
                char pos = sc.next().charAt(0);
                if(pos=='L'){
                    snakegame(row,--col);
                }
                else if(pos=='R'){
                    snakegame(row,++col);
                }
                else if(pos=='U'){
                    snakegame(--row,col);
                }
                else if(pos=='D'){
                    snakegame(++row,col);
                }
                else{
                    System.out.println("Invalid Move!");
                }
            }
        }
        else{
            System.out.println("Invalid Move!");
            System.exit(0);
        }
    }
    public void printsnakeboard(){
        for(char[] c : snakeboard){
            for(int i=0;i<snakeboard[0].length;i++){
                System.out.print(c[i]+" ");
            }
            System.out.println();
        }      
    }
}