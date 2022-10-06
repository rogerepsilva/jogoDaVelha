import java.util.Scanner;

public class JogoDaVelha {

    private String jogador1, jogador2, sinal, vez;
    private boolean flag;
    private int jogadas, escolhaLinha, escolhaColuna;

    private String[][] tabuleiro = new String[3][3];
    Scanner scan = new Scanner(System.in);

    public JogoDaVelha(String jogador1, String jogador2) {
        this.setJogador1(jogador1);
        this.setJogador2(jogador2);
        this.setFlag(false);
        this.setJogadas(0);
    }

    public void vez() {
        if (jogadas % 2 == 1) {
            sinal = "X";
        } else {
            sinal = "O";
        }
    }

    public void jogar() {
        for (int l = 0; l < tabuleiro.length; l++) {
            for (int c = 0; c < tabuleiro[l].length; c++) {
                tabuleiro[l][c] = " ";
            }
        }

        while (!flag) {

            for (int l = 0; l < tabuleiro.length; l++) {
                for (int c = 0; c < tabuleiro[l].length; c++) {
                    if (c < 2) {
                        System.out.print(tabuleiro[l][c] + "  | ");
                    }
                }
                System.out.println();
                if (l < 2) {
                    System.out.println("---+----+---");
                }
            }
            if (jogadas % 2 == 0) {
                this.setSinal("X");
                this.setVez(jogador1);

            } else {
                this.setSinal("O");
                this.setVez(jogador2);
            }
            System.out.println("Escolha um lugar jogador: " + this.getVez() + " linha: 1 - 3 e coluna: 1 - 3");
            System.out.print("Linha: ");
            this.setEscolhaLinha(scan.nextInt() - 1);
            System.out.println();
            System.out.print("Coluna: ");
            this.setEscolhaColuna(scan.nextInt() - 1);

            if (tabuleiro[this.getEscolhaLinha()][this.getEscolhaColuna()] == " ") {
                tabuleiro[this.getEscolhaLinha()][this.getEscolhaColuna()] = this.getSinal();
                this.setJogadas(this.getJogadas() + 1);
            } else {
                System.out.println("Jogada inválida, posição já marcada.");
            }

            if ((tabuleiro[0][0] == this.getSinal() && tabuleiro[1][0] == this.getSinal()
                    && tabuleiro[2][0] == this.getSinal()) // Coluna 01
                    || (tabuleiro[0][1] == this.getSinal() && tabuleiro[1][1] == this.getSinal()
                            && tabuleiro[2][1] == this.getSinal()) // Coluna 02
                    || (tabuleiro[0][2] == this.getSinal() && tabuleiro[1][2] == this.getSinal()
                            && tabuleiro[2][2] == this.getSinal())
                    // Coluna 03
                    || (tabuleiro[0][0] == this.getSinal() && tabuleiro[0][1] == this.getSinal()
                            && tabuleiro[0][2] == this.getSinal()) // Linha 01
                    || (tabuleiro[1][0] == this.getSinal() && tabuleiro[1][1] == this.getSinal()
                            && tabuleiro[1][2] == this.getSinal()) // Linha 02
                    || (tabuleiro[2][0] == this.getSinal() && tabuleiro[2][1] == this.getSinal()
                            && tabuleiro[2][2] == this.getSinal()) // Linha 03
                    || (tabuleiro[0][0] == this.getSinal() && tabuleiro[1][1] == this.getSinal()
                            && tabuleiro[2][2] == this.getSinal()) // Diagonal primária
                    || (tabuleiro[0][2] == this.getSinal() && tabuleiro[1][1] == this.getSinal()
                            && tabuleiro[2][0] == this.getSinal())) // Diagonal secundária
            { // VERIFICAR OS SINAIS IGUAIS
                System.out.println("O jogador " + this.getVez() + " ganhou!");
                this.setFlag(true);
            }
        }
    }

    public void setSinal(String sinal) {
        this.sinal = sinal;
    }

    public String getSinal() {
        return this.sinal;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean getFlag() {
        return this.flag;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public String getJogador1() {
        return this.jogador1;
    }

    public String getJogador2() {
        return this.jogador2;
    }

    public String getVez() {
        return this.vez;
    }

    public void setVez(String vez) {
        this.vez = vez;
    }

    public void setJogadas(int jogadas) {
        this.jogadas = jogadas;
    }

    public int getJogadas() {
        return this.jogadas;
    }

    public void setEscolhaLinha(int linha) {
        this.escolhaLinha = linha;
    }

    public int getEscolhaColuna() {
        return this.escolhaColuna;
    }

    public void setEscolhaColuna(int coluna) {
        this.escolhaColuna = coluna;
    }

    public int getEscolhaLinha() {
        return this.escolhaLinha;
    }
}
