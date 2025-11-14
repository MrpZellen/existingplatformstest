package main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

//    static ImageIcon logo = new ImageIcon(Main.class.getClassLoader().
//            getResource("res/chess.png"));

    public static void main(String[] args) {

        JFrame window = new JFrame("Chess Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        JPanel panel = new JPanel();
        JButton mainGame = new JButton("Regular Chess");
        JButton game960 = new JButton("960 Chess");

        GamePanel gp = new GamePanel();
        Game960Panel g960p = new Game960Panel();
        mainGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().removeAll();
                window.add(gp);
                window.pack();
                window.setVisible(true);
            }
        });

        game960.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.getContentPane().removeAll();
                window.add(g960p);
                window.pack();
                window.setVisible(true);
            }
        });


        panel.add(mainGame);
        panel.add(game960);
//        window.getIconImage(logo.getImage());

        //Add Main.Main.GamePanel to the window
        window.add(panel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}