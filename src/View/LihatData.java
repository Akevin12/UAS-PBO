package View;

import Database.DatabaseHandler;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author kevin
 */
public class LihatData {

    static DatabaseHandler conn = new DatabaseHandler();

    public LihatData() {

        JFrame frame = new JFrame("Lihat Data");
        Font myFont = new Font("Serif", Font.BOLD, 24);
        Font myFont2 = new Font("Serif", Font.BOLD, 18);

        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        label.setText("SELAMAT DATANG DI MENU LIHAT DATA");
        label.setBounds(80, 60, 500, 30);
        label.setFont(myFont);

        label2.setText("||");
        label2.setBounds(310, 100, 500, 30);
        label2.setFont(myFont);

        label3.setText(":||:");
        label3.setBounds(302, 110, 500, 30);
        label3.setFont(myFont);

        label4.setText("||");
        label4.setBounds(310, 120, 500, 30);
        label4.setFont(myFont);

        label5.setText("SILAHKAN MEMILIH MENU");
        label5.setBounds(200, 160, 300, 30);
        label5.setFont(myFont2);

        JButton buttonPrivate = new JButton("PRIVATE ACCOUNT");
        buttonPrivate.setBounds(80, 250, 150, 40);

        JButton buttonCreator = new JButton("CREATOR ACCOUNT");
        buttonCreator.setBounds(240, 250, 150, 40);

        JButton buttonBus = new JButton("BUSINESS ACCOUNT");
        buttonBus.setBounds(400, 250, 200, 40);

        JButton buttonBack = new JButton("BACK");
        buttonBack.setBounds(240, 310, 150, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(buttonPrivate);
        frame.add(buttonCreator);
        frame.add(buttonBus);
        frame.add(buttonBack);
        frame.setSize(680, 500);
        frame.setLayout(null);
        frame.setVisible(true);

        buttonPrivate.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new UserPrivate();
            }
        });

        buttonCreator.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new UserCreator();
            }
        });

        buttonBus.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new UserBus();
            }
        });

        buttonBack.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new MainMenu();
            }
        });
    }
}
