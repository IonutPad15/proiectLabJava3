package Rares;

import Ionut.GUI.MeniuPrincipal;
import Ionut.classes.CitireFisier;
import Ionut.classes.ScriereFisier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewGame2 extends JFrame{
    private JPanel panelNewGame;
    private JLabel label;
    private JButton butonNext;
    private JFrame jFrame;
    Image image;
    public NewGame2()
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
        String s = "Te-ai angajat ca vanzator la Kaufland.\n Nu e chiar ce visai, dar pune painea\n pe masa pentru inceput";
        label.setBounds(0,0,800,120);
        label.setForeground(Color.black);
        label.setText(("<html>" + s.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));
        image=new ImageIcon("ProiectMititeanPadureanSimon/src/Ionut/resources/primul-job.png").getImage().getScaledInstance(2000,1000, Image.SCALE_DEFAULT);
        jFrame.setContentPane(new JLabel(new ImageIcon(image)));
        jFrame.add(butonNext,gbc);
        jFrame.add(label,gbc);
        butonNext.setBounds(1400,700,130,40);
        butonNext.setText("Start");
        butonNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jFrame.setVisible(false);
                MeniuPrincipal.start();
            }
        });
    }
    public JFrame getjFrame()
    {
        return jFrame;
    }
}
