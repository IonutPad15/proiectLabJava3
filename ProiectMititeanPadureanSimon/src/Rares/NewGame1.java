package Rares;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame1 extends JFrame{
    private JPanel panelNewGame;
    private JLabel label;
    private JButton butonNext;
    private JFrame jFrame;
    Image image;
    public NewGame1()
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
        jFrame = new JFrame("Health&Happiness");
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
        String s = "Ai gasit chirie intr-o mica garsoniera la periferie. \nNu e cine stie ce, dar e un loc bun pentru inceput";
        label.setBounds(800,10,800,80);
        label.setForeground(Color.black);
        label.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        image=new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/primacasa.png").getImage().getScaledInstance(2000,1000, Image.SCALE_DEFAULT);
        jFrame.setContentPane(new JLabel(new ImageIcon(image)));
        jFrame.add(butonNext,gbc);
        jFrame.add(label,gbc);
        butonNext.setBounds(1400,700,130,40);
        butonNext.setText("Next");
        butonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                NewGame2  n2 = new NewGame2();
                n2.getjFrame().setVisible(true);
            }
        });
    }
    public JFrame getjFrame()
    {
        return jFrame;
    }
}
