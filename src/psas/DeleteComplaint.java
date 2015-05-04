/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import static psas.ListComplaints.databaseConnect;

/**
 *
 * @author sanjay
 */
public class DeleteComplaint extends JFrame {
    private javax.swing.JButton delete;
    private javax.swing.JLabel lid;
    private javax.swing.JTextField id;
    
    public DeleteComplaint() {
        init();
        setSize(430, 120);
    }
    
    public void init() {
        lid = new JLabel("ID: ");
        id = new JTextField();
        delete = new JButton();

        setDefaultCloseOperation(DeleteComplaint.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        delete.setText("Delete");
        
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        
        getContentPane().add(lid);
        lid.setBounds(5, 5, 200, 30);
        getContentPane().add(id);
        id.setBounds(200, 5, 200, 30);
        
        getContentPane().add(delete);
        delete.setBounds(5, 40, 400, 30);
            
        setVisible(true);
    }
    
    public void clearAll() {
        id.setText("");
    }
    
    public void delete() {
        try {
            Connection con = databaseConnect();
            if(con != null) {
                PreparedStatement ps = con.prepareStatement("delete from complaints where id = ?");
                ps.setString(1, id.getText());
                ps.executeUpdate();
            } else {
                System.out.println("error connecting to database.");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        clearAll();
    }
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) { 
        delete();
    }
    
    public static Connection databaseConnect() {
        String connectionURL = "jdbc:derby://localhost:1527/psas";
        try {
            Connection con = DriverManager.getConnection(connectionURL, "psas", "psas");
            return con;
        } catch(SQLException e) {
            return null;
        }
    }
}
