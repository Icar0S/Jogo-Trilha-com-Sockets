package src.Entity;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Display extends JFrame {

    private JFrame frame;
    private final int WIDTH = 510;
    private final int HEIGHT = 527;
    private BufferedImage board;
    private Display.Painter painter;

    JButton button= new JButton();

    private static Display display = new Display();

    /*private void render(Graphics g) {
        g.drawImage(board, 0, 0, null);

    }*/

    public void loadImages() {
        try {
            board = ImageIO.read(getClass().getResourceAsStream("../src.Config.res/board2.png"));
            //redCircle = getClass().getResource("/" + combo.getSelectedItem() + ".gif")
            //blueCircle = ImageIO.read(getClass().getResourceAsStream("../src.Config.res/blueDama.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Display(){
        painter = new Display.Painter();
        this.setTitle("Jogo-Trilha - Play 1");
        this.setVisible(true);
        this.setBounds(0, 0, WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        ImageIcon boardIcon = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("../src.Config.res/board2.png")));
        JLabel Tab = new JLabel("Full Name :", boardIcon, JLabel.LEFT);
        getContentPane().add(Tab);
        Tab.setIcon(boardIcon);

    }

    public static Display getInstance(){
        return display;
    }

    public void update() {

        Board b = Board.getInstance();
       // System.out.println("" + b.getHouses().get(0).getId() + b.getHouses().get(0).getMan().getToken() + " -------------- " + b.getHouses().get(1).getId() + b.getHouses().get(1).getMan().getToken() + " --------------- " + b.getHouses().get(2).getId() + b.getHouses().get(2).getMan().getToken());

    }


    private class Painter extends JPanel implements MouseListener {
        private static final long serialVersionUID = 1L;

        public Painter(){
            /*setFocusable(true);
            requestFocus();
            setBackground(java.awt.Color.WHITE);
            addMouseListener(this);*/
        }

        @Override
        public void paintComponent(Graphics g) {
            //super.paintComponent(g);
            //render(g);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }




}


