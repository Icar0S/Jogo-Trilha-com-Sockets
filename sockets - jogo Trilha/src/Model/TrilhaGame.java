package src.Model;

import src.Entity.*;

import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class TrilhaGame implements Runnable{

    public int numberOfMen=9;
    String ip = "localhost";
    private int port = 1024;
    private Scanner scanner = new Scanner(System.in);

    private Thread thread;

    //private TrilhaGame.Painter painter;
    private Socket socket;
    private DataOutputStream dos;
    private DataInputStream dis;

    private ServerSocket serverSocket;


    private BufferedImage redCircle;
    private BufferedImage blueCircle;

    private String[] spaces = new String[24];

    private static TrilhaGame game = new TrilhaGame();
    public TrilhaGame(){
        System.out.println("Please input the IP: ");
        ip = scanner.nextLine();
        System.out.println("Please input the port: ");
        port = scanner.nextInt();
        while(port<1 || port>65535){
            System.out.println("The port you entered was invalid");
            port = scanner.nextInt();
        }
        if (!connect()) initializeServer();
    }
    public static TrilhaGame getInstance(){return game;}

    /*private Display() {

        //Display.Painter painter = new Display.Painter();

        painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        painter.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        frame = new JFrame();
        frame.setTitle("Jogo-Trilha - Play 1");
        frame.setContentPane(painter);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        thread = new Thread(this, "Display");
        thread.start();
    }

    public static Display getInstance() {
        return display;
    }/*/



    @Override
    public void run() {
        listenForServerRequest();
    }

    public enum Color {White, Black};
    public static boolean win=false;
    public AbstractPlayer currentTurn;
    AbstractPlayer p1;
    AbstractPlayer p2;
    int phase = 0;
    //int numberOfMen = 9;
    //number of men left that can allow a man to jump
    public final static int MINMEN = 3;

    private void PhaseTwo(){
        int endCounter = 150;
        while (win!=true) {
            endCounter --;
            if(Mills.canMove(Board.getInstance().red)==true){
                currentTurn = p1;
                new Turn(Board.getInstance().red);
                Display.getInstance().update();
                Board.getInstance().howManyMen(Board.getInstance().red);

                System.out.println("Are you sure about this move? [Y/N]");
                if(p1.readYN()){
                    History.getInstance().undo();
                    Display.getInstance().update();
                }

            }
            else
                win=true;
            if(Mills.canMove(Board.getInstance().blue)){
                currentTurn = p2;
                new Turn(Board.getInstance().blue);
                Display.getInstance().update();
                Board.getInstance().howManyMen(Board.getInstance().blue);

                System.out.println("Are you sure about this move? [Y/N]");
                if(p2.readYN()){
                    History.getInstance().undo();
                    Display.getInstance().update();
                }

            }
            else
                win=true;
            if (endCounter <=0)
                System.out.println("Draw.");
        }
        if (currentTurn == p1)
            System.out.println("Game finished! Player "+Color.values()[1]+" won!");
        else
            System.out.println("Game finished! Player "+Color.values()[0]+" won!");
    }

        private void PhaseOne(){
            System.out.println("Each Player gets "+numberOfMen+" Men.");
            int redIndex = 0;
            int blueIndex = 0;
            for(int i = 0; i<(2*numberOfMen); i++){
                if(i%2==0){
                    currentTurn = p1;
                    new Turn(Board.getInstance().red.get(redIndex));
                    Display.getInstance().update();

                    System.out.println("Are you sure about this move? [Y/N]");
                    if(!p1.readYN()){
                        History.getInstance().undo();
                        Display.getInstance().update();
                        i--;
                        continue;
                    }

                    redIndex++;

                }
                else{
                    currentTurn = p2;
                    new Turn(Board.getInstance().blue.get(blueIndex));
                    Display.getInstance().update();

                    System.out.println("Are you sure about this move? [Y/N]");
                    if(!p2.readYN()){
                        History.getInstance().undo();
                        Display.getInstance().update();
                        i--;
                        continue;
                    }

                    blueIndex++;

                }
            }
            //testAfterPhaseOne();//DEBUG
            return;
        }

        private void setUp(){
            p1 = new Human(Color.values()[0]);
            p2 = new Human(Color.values()[1]);
            Board.getInstance().setUp();
            Display.getInstance().update();

        }

        public void play(){
            setUp();
            phase = 1;
            PhaseOne();
            phase = 2;
            PhaseTwo();
        }


    private void listenForServerRequest() {
        Socket socket = null;
        try {
            socket = serverSocket.accept();
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());

            System.out.println("CLIENT HAS REQUESTED TO JOIN, AND WE HAVE ACCEPTED");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean connect() {
        try {
            socket = new Socket(ip, port);
            dos = new DataOutputStream(socket.getOutputStream());
            dis = new DataInputStream(socket.getInputStream());
            //accepted = true;
        } catch (IOException e) {
            System.out.println("Unable to connect to the address: " + ip + ":" + port + " | Starting a server");
            return false;
        }
        System.out.println("Successfully connected to the server.");
        return true;
    }

    private void initializeServer() {
        try {
            serverSocket = new ServerSocket(port, 8, InetAddress.getByName(ip));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static void main(String[] args) {
            System.out.println("Welcome to L's Nine Men's Morris!");
            Display board = new Display();
            TrilhaGame trilha = new TrilhaGame();

            try {
                // Define um endereco de destino (IP e porta)
                InetAddress servidor = InetAddress.getByName("localhost");
                int porta = 1024;
                // Cria o socket
                DatagramSocket socket = new DatagramSocket();
                // Laco para ler linhas do teclado e envia-las ao endereco de destino
                Scanner input = new Scanner(System.in);
                String linha = input.nextLine();


                while (!linha.equals(".")) {
                    // Cria um pacote com os dados da linha
                    byte[] dados = linha.getBytes();
                    DatagramPacket pacote = new DatagramPacket(dados, dados.length, servidor, porta);
                    // Envia o pacote ao endereco de destino
                    socket.send(pacote);
                    // Ler a proxima linha
                    linha = input.nextLine();
                }
            } catch (Exception e) {}

            TrilhaGame.getInstance().play();
            System.out.println("End of Game. Bye!");
        }



}

