/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class MainMenu {

    public MainMenu() {
        JFrame frame = new JFrame("Main Menu");
        frame.setSize(680, 500);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 24);
        Font myFont2 = new Font("Serif", Font.BOLD, 18);

        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();

        label.setText("SELAMAT DATANG DI MENU UTAMA");
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

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds(80, 250, 150, 40);

        JButton btnRegis= new JButton("REGISTRASI");
        btnRegis.setBounds(240, 250, 150, 40);

        JButton btnExit = new JButton("EXIT");
        btnExit.setBounds(400, 250, 200, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(btnLogin);
        frame.add(btnRegis);
        frame.add(btnExit);
        frame.setLayout(null);
        frame.setVisible(true);

        btnLogin.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new Login("user");
            }
        });

        btnRegis.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new Registrasi();
            }
        });

        btnExit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                new LihatData();
            }
        });

        btnExit.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {

                System.exit(0);
                btnExit.addActionListener(this);
            }
        });
    }
}
