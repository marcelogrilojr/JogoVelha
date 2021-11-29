public class board {
    public static void main(String[] args) {
        int board[][] ={ {0,0,0}, {0,1,0}, {0,0,0} }; 
        mostrar_tabuleiro(board);
    }

    public static void mostrar_tabuleiro(int board[][]) {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[i][j] == 0){
                    System.out.print(" _ "+" ");
                } else if (board[i][j] == 1){
                    System.out.print(" X "+" ");
                } else if (board[i][j] == -1){
                    System.out.print(" O "+" ");
                }
            }
            System.out.println();
        }
     }
}