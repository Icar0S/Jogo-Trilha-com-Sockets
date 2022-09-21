package src.Config.java;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;

public class Jogador1 extends javax.swing.JFrame{

    private int idJogador;
    private int outroJogador;
    private int[] posicoes;
    private int qtdPecas;
    private int qtdPecasAdv;
    private boolean ativaBotoes;
    private boolean solicitouEmpate;
    private boolean fimJogo;
    private int posicaoVazia;

    private int[] possibilidadesCasa0 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa1 = {0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa2 = {0, 1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa3 = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa4 = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa5 = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa6 = {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa7 = {0, 1, 2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa8 = {0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa9 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa10 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa11 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa12 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa13 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa14 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa15 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa16 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa17 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 18, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa18 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 19, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa19 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 20, 21, 22, 23, 24};
    private int[] possibilidadesCasa20 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 21, 22, 23, 24};
    private int[] possibilidadesCasa21 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 23, 24};
    private int[] possibilidadesCasa22 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23, 24};
    private int[] possibilidadesCasa23 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 24};
    private int[] possibilidadesCasa24 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};


    private int[][] jogadasPossiveis = {possibilidadesCasa0, possibilidadesCasa1, possibilidadesCasa2,
            possibilidadesCasa3, possibilidadesCasa4, possibilidadesCasa5, possibilidadesCasa6, possibilidadesCasa7,
            possibilidadesCasa8, possibilidadesCasa9, possibilidadesCasa10, possibilidadesCasa11, possibilidadesCasa12,
            possibilidadesCasa13, possibilidadesCasa14, possibilidadesCasa15, possibilidadesCasa16, possibilidadesCasa17,
            possibilidadesCasa18, possibilidadesCasa19, possibilidadesCasa20, possibilidadesCasa21, possibilidadesCasa22,
            possibilidadesCasa23, possibilidadesCasa24};

    private int[] vitoria1 = {0, 1, 2};
    private int[] vitoria2 = {3, 4, 5};
    private int[] vitoria3 = {6, 7, 8};
    private int[] vitoria4 = {9, 10, 11};
    private int[] vitoria5 = {12, 13, 14};
    private int[] vitoria6 = {15, 16, 17};
    private int[] vitoria7 = {18, 19, 20};
    private int[] vitoria8 = {21, 22, 23};

    private int[] vitoria9 = {0, 9, 21};
    private int[] vitoria10 = {3, 10, 18};
    private int[] vitoria11 = {6, 11, 15};

    private int[] vitoria12 = {1, 4, 7};
    private int[] vitoria13 = {16, 19, 22};

    private int[] vitoria14 = {8, 12, 17};
    private int[] vitoria15 = {5, 13, 20};
    private int[] vitoria16 = {2, 14, 23};

    private int[][] vitoriasPossiveis = {
                    vitoria1, vitoria2, vitoria3, vitoria4, vitoria5, vitoria6, vitoria7, vitoria8,
                    vitoria9, vitoria10, vitoria11, vitoria12, vitoria13, vitoria14, vitoria15, vitoria16};
    private ConexaoChat clienteChat;
    private ConexaoJogo clienteJogo;

    public Jogador1() {
        posicoes = new int[24];
        qtdPecas = 0;
        qtdPecasAdv = 0;
        solicitouEmpate = false;
        fimJogo = false;

        //Conexão para o jogo e para o chat
        this.connect();

        initComponents();

        Thread threadChat = new Thread(new Runnable(){
            public void run(){
                executaChat();;
            }
        });
        threadChat.start();

        this.setTitle("Jogador #" + idJogador + " - Nine Mens Morris");

        if(idJogador == 1){
            titulo.setText("Jogador #1. Aguarde o Jogador #2 se conectar.");
            Color vermelho = new Color(0xdb3c30);
            titulo.setBackground(vermelho);
            outroJogador = 2;
            ativaBotoes = false;
        }else{
            titulo.setText("Jogador #2. Aguarde seu turno.");
            Color azul = new Color(0x3394e8);
            titulo.setBackground(azul);
            outroJogador = 1;
            ativaBotoes = false;

            Thread t = new Thread(new Runnable(){
                public void run(){
                    controlaTurno();;
                }
            });
            t.start();
        }

        atualizaEstadoBotoes();
    }

    private void connect() {
        clienteJogo = new ConexaoJogo();
        clienteChat = new ConexaoChat();
    }

    public void atualizaEstadoBotoes() {//Habilita os botões de acordo com seu turno
        b1.setEnabled(ativaBotoes);
        b2.setEnabled(ativaBotoes);
        b3.setEnabled(ativaBotoes);
        b4.setEnabled(ativaBotoes);
        b5.setEnabled(ativaBotoes);
        b6.setEnabled(ativaBotoes);
        b8.setEnabled(ativaBotoes);
        b9.setEnabled(ativaBotoes);
        b10.setEnabled(ativaBotoes);
        b11.setEnabled(ativaBotoes);
        b12.setEnabled(ativaBotoes);
        b13.setEnabled(ativaBotoes);
        b14.setEnabled(ativaBotoes);
        b15.setEnabled(ativaBotoes);
        b16.setEnabled(ativaBotoes);
        b17.setEnabled(ativaBotoes);
        b18.setEnabled(ativaBotoes);
        b19.setEnabled(ativaBotoes);
        b20.setEnabled(ativaBotoes);
        b21.setEnabled(ativaBotoes);
        b22.setEnabled(ativaBotoes);
        b23.setEnabled(ativaBotoes);
        b24.setEnabled(ativaBotoes);


        atualizaImagensBotoes();
        //Desabilita todas os botões que não são vazios
        if(posicoes[0] > 0){
            b1.setEnabled(false);
        }
        if(posicoes[1] > 0){
            b2.setEnabled(false);
        }
        if(posicoes[2] > 0){
            b3.setEnabled(false);
        }
        if(posicoes[3] > 0){
            b4.setEnabled(false);
        }
        if(posicoes[4] > 0){
            b5.setEnabled(false);
        }
        if(posicoes[5] > 0){
            b6.setEnabled(false);
        }
        if(posicoes[6] > 0){
            b7.setEnabled(false);
        }
        if(posicoes[7] > 0){
            b8.setEnabled(false);
        }
        if(posicoes[8] > 0){
            b9.setEnabled(false);
        }
        if(posicoes[9] > 0){
            b10.setEnabled(false);
        }
        if(posicoes[10] > 0){
            b11.setEnabled(false);
        }
        if(posicoes[11] > 0){
            b12.setEnabled(false);
        }
        if(posicoes[12] > 0){
            b13.setEnabled(false);
        }
        if(posicoes[13] > 0){
            b14.setEnabled(false);
        }
        if(posicoes[14] > 0){
            b15.setEnabled(false);
        }
        if(posicoes[15] > 0){
            b16.setEnabled(false);
        }
        if(posicoes[16] > 0){
            b17.setEnabled(false);
        }
        if(posicoes[17] > 0){
            b18.setEnabled(false);
        }
        if(posicoes[18] > 0){
            b19.setEnabled(false);
        }
        if(posicoes[19] > 0){
            b20.setEnabled(false);
        }
        if(posicoes[20] > 0){
            b21.setEnabled(false);
        }
        if(posicoes[21] > 0){
            b22.setEnabled(false);
        }
        if(posicoes[22] > 0){
            b23.setEnabled(false);
        }
        if(posicoes[23] > 0){
            b24.setEnabled(false);
        }
        //Após a disposição de peças, desabilita o espaço vazio para clique
        if(qtdPecas == 3 && qtdPecasAdv == 3){
            alteraEstadoBotoes(0, false);
        }

    }

    public void atualizaImagensBotoes(){

        switch (posicoes[0]) {
            case 1:
                b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b1.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[1]) {
            case 1:
                b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b2.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[2]) {
            case 1:
                b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b3.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[3]) {
            case 1:
                b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b4.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[4]) {
            case 1:
                b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b5.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[5]) {
            case 1:
                b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b6.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[6]) {
            case 1:
                b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b7.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[7]) {
            case 1:
                b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b8.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[8]) {
            case 1:
                b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b9.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[9]) {
            case 1:
                b10.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b10.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b10.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b10.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[10]) {
            case 1:
                b11.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b11.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b11.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b11.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[11]) {
            case 1:
                b12.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b12.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b12.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b12.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[12]) {
            case 1:
                b13.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b13.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b13.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b13.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[13]) {
            case 1:
                b14.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b14.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b14.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b14.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[14]) {
            case 1:
                b15.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b15.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b15.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b15.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[15]) {
            case 1:
                b16.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b16.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b16.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b16.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[16]) {
            case 1:
                b17.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b17.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b17.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b17.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[17]) {
            case 1:
                b18.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b18.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b18.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b18.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[18]) {
            case 1:
                b19.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b19.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b19.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b19.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[19]) {
            case 1:
                b20.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b20.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b20.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b20.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[20]) {
            case 1:
                b21.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b21.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b21.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b21.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[21]) {
            case 1:
                b22.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b22.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b22.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b22.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[22]) {
            case 1:
                b23.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b23.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b23.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b23.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

        switch (posicoes[23]) {
            case 1:
                b24.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
                b24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelhaBloqueada.png")));
                break;
            case 2:
                b24.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
                b24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzulBloqueada.png")));
                break;
            default:
                b24.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                b24.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
                break;
        }

    }

    public void alteraEstadoBotoes(int valorComparacao, boolean estado){
        if(posicoes[0] == valorComparacao){
            b1.setEnabled(estado);
        }
        if(posicoes[1] == valorComparacao){
            b2.setEnabled(estado);
        }
        if(posicoes[2] == valorComparacao){
            b3.setEnabled(estado);
        }
        if(posicoes[3] == valorComparacao){
            b4.setEnabled(estado);
        }
        if(posicoes[4] == valorComparacao){
            b5.setEnabled(estado);
        }
        if(posicoes[5] == valorComparacao){
            b6.setEnabled(estado);
        }
        if(posicoes[6] == valorComparacao){
            b7.setEnabled(estado);
        }
        if(posicoes[7] == valorComparacao){
            b8.setEnabled(estado);
        }
        if(posicoes[8] == valorComparacao){
            b9.setEnabled(estado);
        }
        if(posicoes[9] == valorComparacao){
            b10.setEnabled(estado);
        }
        if(posicoes[10] == valorComparacao){
            b11.setEnabled(estado);
        }
        if(posicoes[11] == valorComparacao){
            b12.setEnabled(estado);
        }
        if(posicoes[12] == valorComparacao){
            b13.setEnabled(estado);
        }
        if(posicoes[13] == valorComparacao){
            b14.setEnabled(estado);
        }
        if(posicoes[14] == valorComparacao){
            b15.setEnabled(estado);
        }
        if(posicoes[15] == valorComparacao){
            b16.setEnabled(estado);
        }
        if(posicoes[16] == valorComparacao){
            b17.setEnabled(estado);
        }
        if(posicoes[17] == valorComparacao){
            b18.setEnabled(estado);
        }
        if(posicoes[18] == valorComparacao){
            b19.setEnabled(estado);
        }
        if(posicoes[19] == valorComparacao){
            b20.setEnabled(estado);
        }
        if(posicoes[20] == valorComparacao){
            b21.setEnabled(estado);
        }
        if(posicoes[21] == valorComparacao){
            b22.setEnabled(estado);
        }
        if(posicoes[22] == valorComparacao){
            b23.setEnabled(estado);
        }
        if(posicoes[23] == valorComparacao){
            b24.setEnabled(estado);
        }
    }

    public void desabilitaTodosBotoes(){
        for(int i = 0; i < 3; i++){
            alteraEstadoBotoes(i, false);
        }
    }

    public void controlaTurno(){
        //Aguarda seu turno enquanto recebe uma jogada válida do adversário
        int n = clienteJogo.recebeJogada();
        titulo.setText("Seu adversário clicou o botão #" + n + ". Sua vez");
        //No início do jogo apenas dispões as peças no tabuleiro
        if(qtdPecasAdv < 3){
            //Atualiza o vetor com a jogada recebida do adversário
            if(idJogador == 1){
                posicoes[n-1] = 2;
            }else{
                posicoes[n-1] = 1;
            }
            qtdPecasAdv++;
        }else{//Desenvolvimento do jogo após peças dispostas
            //Procura qual posicao não possui nenhuma peça
            posicaoVazia = posicaoVaziaTabuleiro();
            //Atualiza o vetor trocando a jogada do advserário com a posição vazia
            if(idJogador == 1){//n-1 é a posição do botão na interface
                posicoes[posicaoVazia] = 2;
                posicoes[n-1] = 0;
            }else{
                posicoes[posicaoVazia] = 1;
                posicoes[n-1] = 0;
            }
        }
        //Só habilita a movimentação de peças após as 6 estiverem dispostas no tabuleiro
        if(qtdPecas == 3 && qtdPecasAdv == 3){
            //Habilita somente as peças do jogador correspondente ao turno
            if(idJogador == 1){
                alteraEstadoBotoes(1, true);
                alteraEstadoBotoes(2, false);
            }else{
                alteraEstadoBotoes(2, true);
                alteraEstadoBotoes(1, false);
            }

            atualizaImagensBotoes();
        }else{//No início do jogo apenas atualiza o tabuleiro de acordo com as peças colocadas
            ativaBotoes = true;
            atualizaEstadoBotoes();
        }

    }

    public int posicaoVaziaTabuleiro(){
        int posicao = 0;
        for (int i = 0; i < posicoes.length; i++) {
            if(posicoes[i] == 0){
                posicao = i;
            }
        }
        return posicao;
    }

    private void verificaVencedor(){
        ativaBotoes = false;

        for (int[] vitoria : vitoriasPossiveis) {
            if(posicoes[vitoria[0]] != 0 && posicoes[vitoria[0]] == posicoes[vitoria[1]] &&
                    posicoes[vitoria[1]] == posicoes[vitoria[2]]){
                //Verifica em cada possibilidade se não existe uma posição vazia e se as três possuem o mesmo valor
                titulo.setText("Parabéns você venceu!");
                desabilitaTodosBotoes();
                fimJogo = true;
                //Comunica o outro jogador que ele foi derrotado
                clienteChat.enviaMensagem("/f");
            }
        }

    }

    public void cliqueBotao(int n){
        int casaTroca = 0;
        boolean jogadaValida;
        //No início do jogo, apenas marca a posição com a cor de sua peça
        if(qtdPecas < 3){
            jogadaValida = true;
            if(idJogador == 1){
                posicoes[n-1] = 1;
            }else{
                posicoes[n-1] = 2;
            }
            qtdPecas++;
        }else{//Movimentação de peças
            jogadaValida = validaJogada(n);

            if(jogadaValida){
                casaTroca = posicaoVaziaTabuleiro();
                if(idJogador == 1){
                    posicoes[casaTroca] = 1;
                    posicoes[n-1] = 0;
                }else{
                    posicoes[casaTroca] = 2;
                    posicoes[n-1] = 0;
                }
            }
        }
        //Só troca o turno quando a jogada é válida, no início todas serão válidas
        if(jogadaValida){
            titulo.setText("Você clicou o botão #" + n + ". Agora a vez do jogador #" + outroJogador);

            ativaBotoes = false;
            atualizaEstadoBotoes();
            clienteJogo.enviaJogada(n);

            Thread t = new Thread(new Runnable(){
                public void run(){
                    controlaTurno();;
                }
            });
            t.start();
            //Toda jogada verifica se alguem venceu
            verificaVencedor();
        }

    }

    public void mudaBotaoParaVazio(javax.swing.JButton botao){
        if(qtdPecas < 3){
            botao.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png")));
        }
    }

    public void mudaCorBotao(javax.swing.JButton botao){
        if(qtdPecas < 3){
            if(idJogador == 1){
                botao.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaVermelha.png")));
            }else{
                botao.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/pecaAzul.png")));
            }
        }
    }

    public boolean validaJogada(int n){
        boolean ehValido = false;
        int[] possibilidades = jogadasPossiveis[n-1];
        //Verifica se existe uma casa vazia possível de cada peça para que possa se deslocar
        for (int elemento : possibilidades) {
            if(posicoes[elemento] == 0){
                ehValido = true;
                break;
            }
        }
        return ehValido;
    }

    public void executaChat(){
        String msgRecebida = "";
        //Execução da thread chat
        while(!msgRecebida.equals("exit")){
            msgRecebida = clienteChat.recebeMensagem();

            if(msgRecebida.equals("/d") && !fimJogo){
                chatArea.setText(chatArea.getText() + "\n Você venceu! Seu adversario desistiu.");
                titulo.setText("Você venceu! Seu adversario desistiu.");
                desabilitaTodosBotoes();
                fimJogo = true;
            }else if(msgRecebida.equals("/e") && !fimJogo){
                if(solicitouEmpate){
                    chatArea.setText(chatArea.getText() + "\n Jogadores concordaram com empate.\n Fim de jogo.");
                    titulo.setText("Fim de jogo! Jogadores concordaram com empate. ");
                    desabilitaTodosBotoes();
                    clienteChat.enviaMensagem("/e");
                    solicitouEmpate = false;
                    fimJogo = true;
                }else {
                    chatArea.setText(chatArea.getText() + "\n Seu adversário solicitou empate\n Envie /e para aceitar.");
                }
            }else if(msgRecebida.equals("/f")){
                chatArea.setText(chatArea.getText() + "\n Fim de jogo. Você perdeu!");
                titulo.setText("Fim de jogo! Você perdeu.");
                desabilitaTodosBotoes();
                fimJogo = true;
            }else if(msgRecebida.equals("/i")){//Quando os dois se conectam o jogador 1 pode jogar
                if(idJogador == 1){
                    ativaBotoes = true;
                    atualizaEstadoBotoes();
                    titulo.setText("Jogador #1. Inicie a partida!");
                    chatArea.setText("Jogador #2 se conectou.");
                }
            }else if(!msgRecebida.isEmpty()){
                chatArea.setText(chatArea.getText() + "\n Adversario: " + msgRecebida);
            }
            chatArea.setCaretPosition(chatArea.getText().length());
        }

    }


    public void enviarMensagemChat(){
        String msg = "";
        msg = mensagem.getText();

        if(msg.equals("/d") && !fimJogo){
            chatArea.setText(chatArea.getText() + "\n Você desistiu! Seu adversario venceu.");
            titulo.setText("Você desistiu! Seu adversario venceu.");
            desabilitaTodosBotoes();
            fimJogo = true;
        }else if(msg.equals("/e") && !fimJogo){
            if(solicitouEmpate){
                chatArea.setText(chatArea.getText() + "\n Aguarde o adversário concordar com empate.");
            }else if(!fimJogo){
                solicitouEmpate = true;
                chatArea.setText(chatArea.getText() + "\n Você solicitou empate ao adversário.");
            }
        }else if(!msg.isEmpty()){
            chatArea.setText(chatArea.getText() + "\n Eu: " + msg);
        }
        clienteChat.enviaMensagem(msg);
        mensagem.setText("");
    }

    private class ConexaoJogo {

        private Socket socket;
        private DataInputStream entrada;
        private DataOutputStream saida;

        public ConexaoJogo(){
            System.out.println("----- Cliente -----");

            try{
                //Se conecta via socket ao jogo do servidor
                socket = new Socket("localhost", 51734);
                entrada = new DataInputStream(socket.getInputStream());
                saida = new DataOutputStream(socket.getOutputStream());
                //Recebe seu id de conexão
                idJogador = entrada.readInt();
                System.out.println("Conectado ao servidor como Jogador #" + idJogador + ".");
            } catch (IOException ex) {
                System.out.println("Erro no construtor do ConexaoJogo");
            }
        }

        public void enviaJogada(int n){
            try{
                saida.writeInt(n);
                saida.flush();
            } catch (IOException ex) {
                System.out.println("Erro no enviaJogada() do Jogador");
            }
        }

        public int recebeJogada(){
            int n = -1;
            try{
                n = entrada.readInt();
                System.out.println("Jogador #" + outroJogador + " clicou o botão #" + n);
            } catch (IOException ex) {
                System.out.println("Erro no recebeJogada() do Jogador");
            }

            return n;
        }

        public void fechaConexao(){
            try{
                socket.close();
                System.out.println("-----CONEXÃO ENCERRADA-----");
            } catch (IOException ex) {
                System.out.println("Erro no fechaConexao() do Cliente");
            }
        }

    }


    private class ConexaoChat {

        private Socket socket;
        private DataInputStream entrada;
        private DataOutputStream saida;

        public ConexaoChat(){
            try{
                //Se conecta via socket ao chat do servidor
                socket = new Socket("localhost", 51738);
                entrada = new DataInputStream(socket.getInputStream());
                saida = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Erro no construtor do chat");
            }
        }

        public void enviaMensagem(String msg){
            try{
                saida.writeUTF(msg);
                saida.flush();
            } catch (IOException ex) {
                System.out.println("Erro no enviaMensagem() do Cliente");
            }
        }

        public String recebeMensagem(){
            String msg = "";
            try{
                msg = entrada.readUTF();
            } catch (IOException ex) {
                System.out.println("Erro no recebeMensagem() do Cliente");
                System.exit(0);
            }

            return msg;
        }

        public void fechaConexao(){
            try{
                socket.close();
                System.out.println("-----CONEXÃO ENCERRADA-----");
            } catch (IOException ex) {
                System.out.println("Erro no fechaConexao() do ConexaoChat");
            }
        }

    }

    private void initComponents() {

        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        b11 = new javax.swing.JButton();
        b12 = new javax.swing.JButton();
        b13 = new javax.swing.JButton();
        b14 = new javax.swing.JButton();
        b15 = new javax.swing.JButton();
        b16 = new javax.swing.JButton();
        b17 = new javax.swing.JButton();
        b18 = new javax.swing.JButton();
        b19 = new javax.swing.JButton();
        b20 = new javax.swing.JButton();
        b21 = new javax.swing.JButton();
        b22 = new javax.swing.JButton();
        b23 = new javax.swing.JButton();
        b24 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        mensagem = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        titulo = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nine Mens Morris");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        b1.setBackground(new java.awt.Color(204, 204, 204));
        b1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b1.setBorderPainted(false);
        b1.setContentAreaFilled(false);
        b1.setFocusPainted(false);
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b1MouseExited(evt);
            }
        });
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });
        getContentPane().add(b1);
        b1.setBounds(-10, 30, 50, 50);

        b2.setBackground(new java.awt.Color(204, 204, 204));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b2.setBorderPainted(false);
        b2.setContentAreaFilled(false);
        b2.setFocusPainted(false);
        b2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b2MouseExited(evt);
            }
        });
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });
        getContentPane().add(b2);
        b2.setBounds(130, 30, 50, 50);

        b3.setBackground(new java.awt.Color(204, 204, 204));
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b3.setBorderPainted(false);
        b3.setContentAreaFilled(false);
        b3.setFocusPainted(false);
        b3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b3MouseExited(evt);
            }
        });
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });
        getContentPane().add(b3);
        b3.setBounds(270, 30, 50, 50);

        b4.setBackground(new java.awt.Color(204, 204, 204));
        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b4.setBorderPainted(false);
        b4.setContentAreaFilled(false);
        b4.setFocusPainted(false);
        b4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b4MouseExited(evt);
            }
        });
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });
        getContentPane().add(b4);
        b4.setBounds(30, 70, 50, 50);

        b5.setBackground(new java.awt.Color(204, 204, 204));
        b5.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b5.setBorderPainted(false);
        b5.setContentAreaFilled(false);
        b5.setFocusPainted(false);
        b5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b5MouseExited(evt);
            }
        });
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });
        getContentPane().add(b5);
        b5.setBounds(130, 75, 50, 50);

        b6.setBackground(new java.awt.Color(204, 204, 204));
        b6.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b6.setBorderPainted(false);
        b6.setContentAreaFilled(false);
        b6.setFocusPainted(false);
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b6MouseExited(evt);
            }
        });
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });
        getContentPane().add(b6);
        b6.setBounds(225, 70, 50, 50);

        b7.setBackground(new java.awt.Color(204, 204, 204));
        b7.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b7.setBorderPainted(false);
        b7.setContentAreaFilled(false);
        b7.setFocusPainted(false);
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b7MouseExited(evt);
            }
        });
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });
        getContentPane().add(b7);
        b7.setBounds(90, 125, 50, 50);

        b8.setBackground(new java.awt.Color(204, 204, 204));
        b8.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b8.setBorderPainted(false);
        b8.setContentAreaFilled(false);
        b8.setFocusPainted(false);
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b8MouseExited(evt);
            }
        });
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });
        getContentPane().add(b8);
        b8.setBounds(130, 125, 50, 50);

        b9.setBackground(new java.awt.Color(204, 204, 204));
        b9.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b9.setBorderPainted(false);
        b9.setContentAreaFilled(false);
        b9.setFocusPainted(false);
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b9MouseExited(evt);
            }
        });
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });
        getContentPane().add(b9);
        b9.setBounds(170, 125, 50, 50);

        b10.setBackground(new java.awt.Color(204, 204, 204));
        b10.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b10.setBorderPainted(false);
        b10.setContentAreaFilled(false);
        b10.setFocusPainted(false);
        b10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b10MouseExited(evt);
            }
        });
        b10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b10ActionPerformed(evt);
            }
        });
        getContentPane().add(b10);
        b10.setBounds(-10, 165, 50, 50);

        b11.setBackground(new java.awt.Color(204, 204, 204));
        b11.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b11.setBorderPainted(false);
        b11.setContentAreaFilled(false);
        b11.setFocusPainted(false);
        b11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b11MouseExited(evt);
            }
        });
        b11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b11ActionPerformed(evt);
            }
        });
        getContentPane().add(b11);
        b11.setBounds(30, 165, 50, 50);

        b12.setBackground(new java.awt.Color(204, 204, 204));
        b12.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b12.setBorderPainted(false);
        b12.setContentAreaFilled(false);
        b12.setFocusPainted(false);
        b12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b12MouseExited(evt);
            }
        });
        b12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b12ActionPerformed(evt);
            }
        });
        getContentPane().add(b12);
        b12.setBounds(90, 165, 50, 50);

        b13.setBackground(new java.awt.Color(204, 204, 204));
        b13.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b13.setBorderPainted(false);
        b13.setContentAreaFilled(false);
        b13.setFocusPainted(false);
        b13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b13MouseExited(evt);
            }
        });
        b13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b13ActionPerformed(evt);
            }
        });
        getContentPane().add(b13);
        b13.setBounds(170, 165, 50, 50);

        b14.setBackground(new java.awt.Color(204, 204, 204));
        b14.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b14.setBorderPainted(false);
        b14.setContentAreaFilled(false);
        b14.setFocusPainted(false);
        b14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b14MouseExited(evt);
            }
        });
        b14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b14ActionPerformed(evt);
            }
        });
        getContentPane().add(b14);
        b14.setBounds(225, 165, 50, 50);

        b15.setBackground(new java.awt.Color(204, 204, 204));
        b15.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b15.setBorderPainted(false);
        b15.setContentAreaFilled(false);
        b15.setFocusPainted(false);
        b15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b15MouseExited(evt);
            }
        });
        b15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b15ActionPerformed(evt);
            }
        });
        getContentPane().add(b15);
        b15.setBounds(270, 165, 50, 50);

        b16.setBackground(new java.awt.Color(204, 204, 204));
        b16.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b16.setBorderPainted(false);
        b16.setContentAreaFilled(false);
        b16.setFocusPainted(false);
        b16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b16MouseExited(evt);
            }
        });
        b16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b16ActionPerformed(evt);
            }
        });
        getContentPane().add(b16);
        b16.setBounds(90, 205, 50, 50);

        b17.setBackground(new java.awt.Color(204, 204, 204));
        b17.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b17.setBorderPainted(false);
        b17.setContentAreaFilled(false);
        b17.setFocusPainted(false);
        b17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b17MouseExited(evt);
            }
        });
        b17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b17ActionPerformed(evt);
            }
        });
        getContentPane().add(b17);
        b17.setBounds(130, 205, 50, 50);

        b18.setBackground(new java.awt.Color(204, 204, 204));
        b18.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b18.setBorderPainted(false);
        b18.setContentAreaFilled(false);
        b18.setFocusPainted(false);
        b18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b18MouseExited(evt);
            }
        });
        b18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b18ActionPerformed(evt);
            }
        });
        getContentPane().add(b18);
        b18.setBounds(170, 205, 50, 50);

        b19.setBackground(new java.awt.Color(204, 204, 204));
        b19.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b19.setBorderPainted(false);
        b19.setContentAreaFilled(false);
        b19.setFocusPainted(false);
        b19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b19MouseExited(evt);
            }
        });
        b19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b19ActionPerformed(evt);
            }
        });
        getContentPane().add(b19);
        b19.setBounds(30, 260, 50, 50);

        b20.setBackground(new java.awt.Color(204, 204, 204));
        b20.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b20.setBorderPainted(false);
        b20.setContentAreaFilled(false);
        b20.setFocusPainted(false);
        b20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b20MouseExited(evt);
            }
        });
        b20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b20ActionPerformed(evt);
            }
        });
        getContentPane().add(b20);
        b20.setBounds(130, 260, 50, 50);

        b21.setBackground(new java.awt.Color(204, 204, 204));
        b21.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b21.setBorderPainted(false);
        b21.setContentAreaFilled(false);
        b21.setFocusPainted(false);
        b21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b21MouseExited(evt);
            }
        });
        b21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b21ActionPerformed(evt);
            }
        });
        getContentPane().add(b21);
        b21.setBounds(225, 260, 50, 50);

        b22.setBackground(new java.awt.Color(204, 204, 204));
        b22.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b22.setBorderPainted(false);
        b22.setContentAreaFilled(false);
        b22.setFocusPainted(false);
        b22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b22MouseExited(evt);
            }
        });
        b22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b22ActionPerformed(evt);
            }
        });
        getContentPane().add(b22);
        b22.setBounds(-10, 310, 50, 50);

        b23.setBackground(new java.awt.Color(204, 204, 204));
        b23.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b23.setBorderPainted(false);
        b23.setContentAreaFilled(false);
        b23.setFocusPainted(false);
        b23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b23MouseExited(evt);
            }
        });
        b23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b23ActionPerformed(evt);
            }
        });
        getContentPane().add(b23);
        b23.setBounds(130, 310, 50, 50);

        b24.setBackground(new java.awt.Color(204, 204, 204));
        b24.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/espacoVazio.png"))); // NOI18N
        b24.setBorderPainted(false);
        b24.setContentAreaFilled(false);
        b24.setFocusPainted(false);
        b24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { b24MouseEntered(evt); }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b24MouseExited(evt);
            }
        });
        b24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b24ActionPerformed(evt);
            }
        });
        getContentPane().add(b24);
        b24.setBounds(270, 310, 50, 50);


        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../resources/board.png"))); // NOI18N
        jLabel1.setText("");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(5, 30, 330, 330);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane2.setViewportView(chatArea);

        mensagem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mensagemKeyPressed(evt);
            }
        });

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        jLabel2.setText("Comandos para o chat:");

        jLabel3.setText("/d - Desitir da partida");

        jLabel4.setText("/e - Solicitar ou concordar empate");

        titulo.setEditable(false);
        titulo.setBackground(new java.awt.Color(0, 0, 0));
        titulo.setColumns(20);
        titulo.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setLineWrap(true);
        titulo.setRows(1);
        titulo.setText("Nine Mens Morris");
        titulo.setWrapStyleWord(true);
        jScrollPane1.setViewportView(titulo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(enviar))
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(341, 341, 341)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enviar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addContainerGap(52, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 620, 380);

        setBounds(0, 0, 635, 419);
    }// </editor-fold>//GEN-END:initComponents

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(1);
    }//GEN-LAST:event_b1ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(2);
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(3);
    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(4);
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(5);
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(6);
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(7);
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        // TODO add your handling code here:
        cliqueBotao(8);
    }//GEN-LAST:event_b8ActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(9);
    }

    private void b10ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(10);
    }

    private void b11ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(11);
    }

    private void b12ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(12);
    }

    private void b13ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(13);
    }

    private void b14ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(14);
    }

    private void b15ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(15);
    }

    private void b16ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(16);
    }

    private void b17ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(17);
    }

    private void b18ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(18);
    }

    private void b19ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(19);
    }

    private void b20ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(20);
    }

    private void b21ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(21);
    }

    private void b22ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(22);
    }

    private void b23ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(23);
    }

    private void b24ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        cliqueBotao(24);
    }


    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        enviarMensagemChat();
    }//GEN-LAST:event_enviarActionPerformed

    private void mensagemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensagemKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            enviarMensagemChat();
        }
    }//GEN-LAST:event_mensagemKeyPressed

    private void b1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b1);
    }//GEN-LAST:event_b1MouseEntered

    private void b1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b1);
    }//GEN-LAST:event_b1MouseExited

    private void b2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b2);
    }//GEN-LAST:event_b2MouseEntered

    private void b2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b2MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b2);
    }//GEN-LAST:event_b2MouseExited

    private void b3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b3);
    }//GEN-LAST:event_b3MouseEntered

    private void b3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b3MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b3);
    }//GEN-LAST:event_b3MouseExited

    private void b4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b4);
    }//GEN-LAST:event_b4MouseEntered

    private void b4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b4MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b4);
    }//GEN-LAST:event_b4MouseExited

    private void b5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b5);
    }//GEN-LAST:event_b5MouseEntered

    private void b5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b5MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b5);
    }//GEN-LAST:event_b5MouseExited

    private void b6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b6);
    }//GEN-LAST:event_b6MouseEntered

    private void b6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b6);
    }//GEN-LAST:event_b6MouseExited

    private void b7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b7);
    }//GEN-LAST:event_b7MouseEntered

    private void b7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b7);
    }//GEN-LAST:event_b7MouseExited

    private void b8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b8);
    }//GEN-LAST:event_b8MouseEntered

    private void b8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b8);
    }//GEN-LAST:event_b8MouseExited

    private void b9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b9);
    }//GEN-LAST:event_b9MouseEntered

    private void b9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b9);
    }//GEN-LAST:event_b9MouseExited

    private void b10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b10);
    }//GEN-LAST:event_b10MouseEntered

    private void b10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b10MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b10);
    }//GEN-LAST:event_b10MouseExited

    private void b11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b11);
    }//GEN-LAST:event_b11MouseEntered

    private void b11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b11MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b11);
    }//GEN-LAST:event_b11MouseExited

    private void b12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseEntered
        // TODO add your handling code here:
        mudaCorBotao(b12);
    }//GEN-LAST:event_b12MouseEntered

    private void b12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b12MouseExited
        // TODO add your handling code here:
        mudaBotaoParaVazio(b12);
    }//GEN-LAST:event_b12MouseExited

    private void b13MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b13);
    }

    private void b13MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b13);
    }

    private void b14MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b14);
    }

    private void b14MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b14);
    }

    private void b15MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b15);
    }

    private void b15MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b15);
    }

    private void b16MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b16);
    }

    private void b16MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b16);
    }

    private void b17MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b17);
    }

    private void b17MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b17);
    }

    private void b18MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b18);
    }

    private void b18MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b18);
    }

    private void b19MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b19);
    }

    private void b19MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b19);
    }

    private void b20MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b20);
    }

    private void b20MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b20);
    }

    private void b21MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b21);
    }

    private void b21MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b21);
    }

    private void b22MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b22);
    }

    private void b22MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b22);
    }

    private void b23MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b23);
    }

    private void b23MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b23);
    }

    private void b24MouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaCorBotao(b24);
    }

    private void b24MouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        mudaBotaoParaVazio(b24);
    }




    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jogador1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jogador1().setVisible(true);
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton b10;
    private javax.swing.JButton b11;
    private javax.swing.JButton b12;
    private javax.swing.JButton b13;
    private javax.swing.JButton b14;
    private javax.swing.JButton b15;
    private javax.swing.JButton b16;
    private javax.swing.JButton b17;
    private javax.swing.JButton b18;
    private javax.swing.JButton b19;
    private javax.swing.JButton b20;
    private javax.swing.JButton b21;
    private javax.swing.JButton b22;
    private javax.swing.JButton b23;
    private javax.swing.JButton b24;

    private static javax.swing.JTextArea chatArea;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField mensagem;
    private javax.swing.JTextArea titulo;

}
