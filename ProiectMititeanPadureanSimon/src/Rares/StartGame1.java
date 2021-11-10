package Rares;

import Ionut.GUI.MeniuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame1 extends JFrame{
    private JPanel panelStart;
    private JButton butonStart;
    private JButton butonLoad;
    private JFrame jFrame;
    private JLabel backround;
    Image image;
    Graphics g;
    public StartGame1()
    {
        prepareframe();
    }
    private void prepareframe()
    {
        jFrame = new JFrame("StartGame");
        jFrame.setContentPane(panelStart);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(getMaximumSize());
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        image=new ImageIcon("ProiectMititeanPadureanSimon/src/Rares/441133-12.jpg").getImage().getScaledInstance(2000,1000, Image.SCALE_DEFAULT);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        jFrame.setContentPane(new JLabel(new ImageIcon(image)));
        jFrame.add(butonStart,gbc);
        jFrame.add(butonLoad,gbc);
        butonStart.setFocusable(false);
        butonLoad.setFocusable(false);
        butonStart.setBackground(Color.pink);
        butonLoad.setBackground(Color.pink);
        butonStart.setBounds(650,350,200,40);
        butonLoad.setBounds(650,400,200,40);
        butonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int answer=JOptionPane.showConfirmDialog(null,"Daca selectezi aceasta varianta ,tot prograsul va fi sters","esti sigur?",JOptionPane.YES_NO_OPTION);

                if(answer==0)
                {
                    Login l = new Login();
                    jFrame.dispose();
                }
            }
        });
        butonLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MeniuPrincipal.start();
                jFrame.dispose();
            }
        });
    }

    public static void main(String[] args) {
        StartGame1 game = new StartGame1();
        game.jFrame.setVisible(true);
    }
}
