import java.util.*;

public class JogoDaVelha {
    public static Scanner entrada = new Scanner (System.in);

    public static void main(String[] args) {
        //Jogo jogo = new Jogo();
       
        int jogada=0, jogador;
        int linha, coluna;
        int soma;
        int ganhou = 0;
        int board[][] ={ {0,0,0}, {0,0,0}, {0,0,0} }; 
        
        //int board[][]= new int[3][3];      
        // for (int i = 0; i < board.length; i++) {
        //     for (int j = 0; j < board[0].length; j++){
        //         board[i][j]=0;
        //     }
        // }

        while (ganhou == 0){
            if (jogada%2 == 0){
                jogador = 1;
            } else {
                jogador = 2;
            }
            System.out.println("\nJogador "+ jogador);
            mostrar_tabuleiro(board);

            while (true){
                System.out.print("\nLinha: ");
                linha  = entrada.nextInt();
                System.out.print("Coluna: ");
                coluna  = entrada.nextInt();
                if (linha < 4 && coluna < 4){
                    break;
                }
                else{
                    System.out.println("Opção inválida, so tem 3 linhas e 3 colunas");
                }
            }
            
            if (board[linha-1][coluna-1] == 0){
                if(jogador==1){
                    board[linha-1][coluna-1]=1;
                } else{
                    board[linha-1][coluna-1]=-1;
                }
            }
            else{
                System.out.println("Nao esta vazio. Jogue novamente Jogador "+ jogador);
                jogada --;
            }

            //checando linhas
            for (int i=0; i<3; i++){
                soma = board[i][0]+board[i][1]+board[i][2];
                if (soma==3 || soma ==-3){
                    ganhou = 1;
                }
            }
            //checando colunas
            for (int i=0; i<3; i++){
                soma = board[0][i]+board[1][i]+board[2][i];
                if (soma==3 || soma ==-3){
                    ganhou = 1;
                }
            }
            //checando diagonais
            int diagonal1 = board[0][0]+board[1][1]+board[2][2];
            int diagonal2 = board[0][2]+board[1][1]+board[2][0];
            if (diagonal1==3 || diagonal1==-3 || diagonal2==3 || diagonal2==-3){
                ganhou = 1;
            }

            if (ganhou==1){
                System.out.println("Jogador "+jogador+" ganhou apos "+ (jogada+1)+" rodadas");
                mostrar_tabuleiro(board);
                System.out.println("Até a próxima! Bye Bye");
            }
            
            if(completo(board)==true){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                mostrar_tabuleiro(board);
                break;
            }
            jogada ++;
            
        }//fim do loop para verificar se ganhou (ganhou==0)
    } //fim da função main

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

     public static boolean completo(int board[][]) {
        for(int i=0 ; i<3 ; i++){
            for(int j=0 ; j<3 ; j++){
                if(board[i][j]==0 ){
                    return false;
                }
            }
        }
        return true;
     }
}