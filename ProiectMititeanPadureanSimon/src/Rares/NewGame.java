package Rares;

import Ionut.GUI.MeniuPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame{
    private JPanel panelNewGame;
    private JLabel label;
    private JButton butonNext;
    private JFrame jFrame;
    Image image;
    public NewGame()
    {
        prepareframe();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
    }
    private void prepareframe()
    {
        jFrame = new JFrame("NewGame");
        jFrame.setContentPane(panelNewGame);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setSize(getMaximumSize());
        jFrame.setLocation(650, 250);
        jFrame.setVisible(false);
        jFrame.setResizable(false);
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        String s = "Tocmai ai terminat liceul, iar visul tau \neste de a ajunge FullStackDeveloper.";
        label.setBounds(980,55,800,80);
        label.setForeground(Color.blue);
        label.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        image=new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/graduation.png").getImage().getScaledInstance(2000,1000, Image.SCALE_DEFAULT);
        jFrame.setContentPane(new JLabel(new ImageIcon(image)));
        jFrame.add(butonNext,gbc);
        jFrame.add(label,gbc);
        butonNext.setBounds(1400,700,130,40);
        butonNext.setText("Next");
        butonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                NewGame1  n1 = new NewGame1();
                n1.getjFrame().setVisible(true);
                jFrame.setVisible(false);
            }
        });
    }
    public JFrame getjFrame()
    {
        return jFrame;
    }
}
