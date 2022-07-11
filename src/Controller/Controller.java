package Controller;

import Database.DatabaseHandler;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author kevin
 */
public class Controller {

    public static String LoginController(String tipe, String email, String pass) {

        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();

        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pass = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            java.sql.Statement stat = conn.con.createStatement();
            ResultSet result = stat.executeQuery("select * from " + tipe + " where email='" + email + "'");
            if (result.next()) {
                if (pass.equals(result.getString("password"))) {
                    return "Login Berhasil!";
                } else {
                    return "Password Salah!";
                }
            } else {
                return "User tidak ditemukan!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error";
        }
    }
    
    public static void register(String nama, String email, String pass, String foto, String kategori) {
        DatabaseHandler conn = new DatabaseHandler();
        conn.connect();
        String query = "INSERT INTO user(name, email, password, photo_path, Category) VALUES(?,?,?,?,?)";
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pass = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, pass);
            stmt.setString(4, foto);
            stmt.setString(5, kategori);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil melakukan registrasi");
            
        } catch (SQLException e) {
            if (e.getMessage().contains("'email'")) {
                JOptionPane.showMessageDialog(null, "email sudah digunakan");
            } else if (e.getMessage().contains("'password'")) {
                JOptionPane.showMessageDialog(null, "password sudah digunakan");
            } else {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error fatal pusing!");
            }
        }
    }

    public void tampil_combobox() {
        JComboBox kategori = new JComboBox();
        Statement stmn = null;
        try {
            DatabaseHandler conn = new DatabaseHandler();
            conn.connect();
            String sql = "select * from kategori";
            ResultSet res = stmn.executeQuery(sql);
            kategori.addItem("-Pilih Kategori-");
            while (res.next()) {
                kategori.addItem(res.getString("Category"));
            }
        } catch (Exception ex) {

        }
    }
}
