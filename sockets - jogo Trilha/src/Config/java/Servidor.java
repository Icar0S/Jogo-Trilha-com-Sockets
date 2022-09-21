package src.Config.java;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    private ServerSocket serverSocketJogo;
    private ServerSocket serverSocketChat;
    private int qtdJogadores;
    private ConexaoServidorJogo jogador1;
    private ConexaoServidorJogo jogador2;
    private ConexaoServidorChat chat1;
    private ConexaoServidorChat chat2;
    private int movimentoJ1;
    private int movimentoJ2;
    private boolean fimJogo;

    public Servidor(){
        System.out.println("----- Servidor -----");
        qtdJogadores = 0;

        try {
            serverSocketJogo = new ServerSocket(51734);
            serverSocketChat = new ServerSocket(51738);
        } catch (IOException ex) {
            System.out.println("Erro no construtor do servidor");
        }
    }

    public void permiteConexoes(){
        try{
            System.out.println("Aguardando conexões...");
            while(qtdJogadores < 2){
                //Aguarda jogador se conectar ao jogo
                Socket socketJogo = serverSocketJogo.accept();
                qtdJogadores++;
                System.out.println("Jogador #" + qtdJogadores + " se conectou");

                //Define thread jogador que ficará executando
                ConexaoServidorJogo jogador = new ConexaoServidorJogo(socketJogo, qtdJogadores);

                Thread threadJogo = new Thread(jogador);
                threadJogo.start();

                //Aguarda jogador se conectar ao chat
                Socket socketChat = serverSocketChat.accept();
                //Define thread chat do jogador que ficará executando
                ConexaoServidorChat chat = new ConexaoServidorChat(socketChat, qtdJogadores);

                //Armazena nos atributos locais onde está cada conexão
                if(qtdJogadores == 1){
                    jogador1 = jogador;
                    chat1 = chat;
                    //qtdJogadores++;
                }else{
                    jogador2 = jogador;
                    chat2 = chat;
                }

                Thread threadChat = new Thread(chat);
                threadChat.start();
            }
            //Não aceita mais conexões
            System.out.println("Os 2 jogadores já se conectaram.");
            /* Após os dois jogadores se conectarem, o primeiro jogador a se conectar
              recebe uma mensagem "/i" que permite o início do jogo*/
            chat1.enviaMsgAdversario("/i");
        } catch (IOException ex) {
            System.out.println("Erro em permiteConexoes()");
        }
    }

    private class ConexaoServidorJogo implements Runnable {

        private Socket socket;
        private DataInputStream entrada;
        private DataOutputStream saida;
        private int idJogador;

        public ConexaoServidorJogo(Socket socket, int idJogador){
            this.socket = socket;
            this.idJogador = idJogador;

            try {
                entrada = new DataInputStream(socket.getInputStream());
                saida = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Erro no run do jogador");
            }
        }

        public void run(){
            try{
                //Envia ao jogador o seu id
                saida.writeInt(idJogador);
                saida.flush();
                //Execução da thread
                while(true){
                    if(idJogador == 1){
                        //Recebe o clique do botão feito pelo jogador e envia para o adversário
                        movimentoJ1 = entrada.readInt();
                        System.out.println("Jogador 1 clicou o botão #" + movimentoJ1);
                        jogador2.enviaJogadaAdversario(movimentoJ1);
                    }else{
                        movimentoJ2 = entrada.readInt();
                        System.out.println("Jogador 2 clicou o botão #" + movimentoJ2);
                        jogador1.enviaJogadaAdversario(movimentoJ2);
                    }

                    if(fimJogo == true){
                        System.out.println("Fim de jogo.");
                        break;
                    }
                }
                jogador1.fechaConexao();
                jogador2.fechaConexao();
            } catch (IOException ex) {
                System.out.println("Erro no run do jogador");
                System.exit(0);
            }
        }

        public void enviaJogadaAdversario(int botao){
            try{
                saida.writeInt(botao);
                saida.flush();
            } catch (IOException ex) {
                System.out.println("Erro no enviaJogadaAdversario() do Servidor");
            }
        }

        public void fechaConexao(){
            try{
                socket.close();
                System.out.println("-----CONEXÃO ENCERRADA-----");
            } catch (IOException ex) {
                System.out.println("Erro no fechaConexao() do Servidor");
            }
        }

    }

    private class ConexaoServidorChat implements Runnable {

        private Socket socket;
        private DataInputStream entrada;
        private DataOutputStream saida;
        private int idJogador;

        public ConexaoServidorChat(Socket socket, int idJogador){
            this.socket = socket;
            this.idJogador = idJogador;

            try {
                entrada = new DataInputStream(socket.getInputStream());
                saida = new DataOutputStream(socket.getOutputStream());
            } catch (IOException ex) {
                System.out.println("Erro no run do jogador");
            }

        }

        public void run(){
            try{

                String msgRecebida = "";
                //Execução da thread do chat
                while(!msgRecebida.equals("exit")){
                    //Aguarda jogador digitar mensagem no campo de texto
                    msgRecebida = entrada.readUTF();
                    //Só estabelece conexão entre os chats quando os dois jogadores se conectam
                    if(jogador2 != null){
                        if(idJogador == 1){
                            //Jogador1 envia mensagem via chat2 para o adversário
                            chat2.enviaMsgAdversario(msgRecebida);
                        }else{
                            //Jogador2 envia mensagem via chat1 para o adversário
                            chat1.enviaMsgAdversario(msgRecebida);
                        }
                    }
                }

                chat1.fechaConexao();
                chat2.fechaConexao();
            } catch (IOException ex) {
                System.out.println("Erro no run do ConexaoChat");
            }
        }

        public void enviaMsgAdversario(String msg){
            try{
                saida.writeUTF(msg);
                saida.flush();
            } catch (IOException ex) {
                System.out.println("Erro no enviaMsgAdversario() do Servidor");
            }
        }

        public void fechaConexao(){
            try{
                socket.close();
                System.out.println("-----CONEXÃO ENCERRADA-----");
            } catch (IOException ex) {
                System.out.println("Erro no fechaConexao() do Servidor");
            }
        }

    }

    public static void main(String[] args){
        Servidor servidor = new Servidor();
        servidor.permiteConexoes();
    }
}
