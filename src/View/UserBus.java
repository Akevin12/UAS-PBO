
package View;

import Database.DatabaseHandler;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author kevin
 */
public class UserBus {
    static DatabaseHandler conn = new DatabaseHandler();

    public UserBus() {

        String columns[] = {"Nama", "Email", "Kategori"};
        DefaultTableModel model = new DefaultTableModel(null, columns);
        JTable table = new JTable(model);
        table.setShowGrid(true);
        TableColumn eventColumn = table.getColumnModel().getColumn(2);
        eventColumn.setPreferredWidth(100);
        JScrollPane pane = new JScrollPane(table);

        conn.connect();
        String query = "SELECT * FROM user WHERE Category='Private Account'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String nama = rs.getString("name");
                String email = rs.getString("email");
                String kategori = rs.getString("Category");

                String[] baris = {nama, email, kategori};
                model.addRow(baris);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("User Business Account");
        JPanel panel = new JPanel();

        JButton buttonBack = new JButton("BACK");
        buttonBack.setBounds(60, 440, 100, 40);

        panel.add(pane);
        frame.add(buttonBack);
        frame.add(panel);
        frame.add(panel);
        frame.setSize(600, 700);
        frame.setVisible(true);

        buttonBack.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                new LihatData();
            }
        });
    }
}
