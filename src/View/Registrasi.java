package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author kevin
 */
public class Registrasi {

    public Registrasi() {
        
        JFrame frame = new JFrame("Registrasi");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        Font myFont = new Font("Serif", Font.BOLD, 24);
        Font myFont2 = new Font("Serif", Font.BOLD, 18);

        JLabel label = new JLabel();
        JLabel label2 = new JLabel();
        JLabel label3 = new JLabel();
        JLabel label4 = new JLabel();
        JLabel label5 = new JLabel();
        JLabel infoFoto = new JLabel();

        label.setText("SELAMAT DATANG DI MENU REGISTRASI");
        label.setBounds(80, 60, 500, 30);
        label.setFont(myFont);
        
        label5.setText("Nama");
        label5.setBounds(80, 100, 200, 30);
        label5.setFont(myFont2);
        
        JTextField nama = new JTextField();
        nama.setBounds(170, 100, 200, 30);
        
        label2.setText("Email");
        label2.setBounds(80, 150, 200, 30);
        label2.setFont(myFont2);

        JTextField email = new JTextField();
        email.setBounds(170, 150, 200, 30);

        label3.setText("Password");
        label3.setBounds(80, 200, 200, 30);
        label3.setFont(myFont2);
        JPasswordField pass = new JPasswordField();
        pass.setBounds(170, 200, 200, 30);
        
        label4.setText("Photo Path");
        label4.setBounds(80, 250, 200, 30);
        label4.setFont(myFont2);
        
        JButton btnFoto = new JButton("Pilih");
        btnFoto.setBounds(170, 250, 100, 30);
        
        infoFoto.setText("File");
        infoFoto.setBounds(280, 250, 200, 30);
        
        String user[] = {"Private Account", "Creator Account", "Business Account"};
        JComboBox kategori = new JComboBox(user);
        kategori.setBounds(80, 300, 200, 30);

        JButton btnRegis = new JButton("REGISTRASI");
        btnRegis.setBounds(80, 350, 150, 40);
        
        JButton btnBack = new JButton("Back");
        btnBack.setBounds(250, 350, 150, 40);

        frame.add(label);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(nama);
        frame.add(kategori);
        frame.add(btnRegis);
        frame.add(btnFoto);
        frame.add(btnBack);
        frame.add(infoFoto);
        frame.add(email);
        frame.add(pass);
        frame.setLayout(null);
        frame.setVisible(true);
        
        btnFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
                j.addChoosableFileFilter(filter);
                int r = j.showSaveDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File f = j.getSelectedFile();
                    infoFoto.setText(j.getSelectedFile().getAbsolutePath());

                }
            }
        });
        
        btnRegis.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(nama.getText().isEmpty()||email.getText().isEmpty()||pass.getPassword().equals("")){
                    JOptionPane.showMessageDialog(null, "Semua kolom wajib diisi!");
                }else{
                    Controller.Controller.register(nama.getText(), email.getText(),pass.getText(),infoFoto.getText(),(String) kategori.getSelectedItem());
                }
            }  
        });
        
        btnBack.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
               new MainMenu();
            }  
        });
    }
}
