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
import static psas.AddComplaint.databaseConnect;

/**
 *
 * @author sanjay
 */
public class EditComplaint extends JFrame {
    private javax.swing.JButton update;
    private javax.swing.JLabel lid;
    private javax.swing.JTextField id;
    private javax.swing.JLabel ltitle;
    private javax.swing.JTextField title;
    private javax.swing.JLabel ldescription;
    private javax.swing.JTextField description;
    private javax.swing.JLabel lcreated_at;
    private javax.swing.JFormattedTextField created_at;
    private javax.swing.JLabel lstatus;
    private javax.swing.JTextField status;
    private javax.swing.JLabel lcustomer_id;
    private javax.swing.JTextField customer_id;
    private javax.swing.JLabel lpriority;
    private javax.swing.JTextField priority;
    
    public EditComplaint() {
        init();
        setSize(430, 350);
    }
    
    public void init() {
        lid = new JLabel("ID: ");
        ltitle = new JLabel("Title: ");
        ldescription = new JLabel("Description: ");
        lcreated_at = new JLabel("Created at: ");
        lstatus = new JLabel("Status: ");
        lcustomer_id = new JLabel("Customer ID: ");
        lpriority = new JLabel("Priority: ");
        id = new JTextField();
        title = new JTextField();
        description = new JTextField();
        created_at = new JFormattedTextField();
        status = new JTextField();
        customer_id = new JTextField();
        priority = new JTextField();
        update = new JButton();
        
        setDefaultCloseOperation(EditComplaint.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);
        
        update.setText("Update");
        
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        
        getContentPane().add(lid);
        lid.setBounds(5, 5, 200, 30);
        getContentPane().add(id);
        id.setBounds(200, 5, 200, 30);
        
        getContentPane().add(ltitle);
        ltitle.setBounds(5, 40, 200, 30);
        getContentPane().add(title);
        title.setBounds(200, 40, 200, 30);
        
        getContentPane().add(ldescription);
        ldescription.setBounds(5, 85, 200, 30);
        getContentPane().add(description);
        description.setBounds(200, 85, 200, 30);
        
        getContentPane().add(lcreated_at);
        lcreated_at.setBounds(5, 120, 200, 30);
        getContentPane().add(created_at);
        created_at.setBounds(200, 120, 200, 30);
        
        getContentPane().add(lstatus);
        lstatus.setBounds(5, 155, 200, 30);
        getContentPane().add(status);
        status.setBounds(200, 155, 200, 30);
        
        getContentPane().add(lcustomer_id);
        lcustomer_id.setBounds(5, 195, 200, 30);
        getContentPane().add(customer_id);
        customer_id.setBounds(200, 195, 200, 30);
        
        getContentPane().add(lpriority);
        lpriority.setBounds(5, 230, 200, 30);
        getContentPane().add(priority);
        priority.setBounds(200, 230, 200, 30);
        
        getContentPane().add(update);
        update.setBounds(5, 265, 400, 30);
            
        setVisible(true);
    }
    
    public void clearAll() {
        id.setText("");
        title.setText("");
        description.setText("");
        created_at.setText("");
        status.setText("");
        customer_id.setText("");
        priority.setText("");
    }
    
    public void update() {
        try {
            Connection con = databaseConnect();
            if(con != null) {
                PreparedStatement ps = con.prepareStatement("update complaints set title = ?, description = ?, created_at = ?, status = ?, customer_id = ?, priority = ? where id = ?");
                ps.setString(1, title.getText());
                ps.setString(2, description.getText());
                ps.setObject(3, created_at.getText());
                ps.setObject(4, status.getText());
                ps.setInt(5, Integer.parseInt(customer_id.getText()));
                ps.setObject(6, priority.getText());
                ps.setInt(7, Integer.parseInt(id.getText()));
                ps.executeUpdate();
            } else {
                System.out.println("error connecting to database.");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        clearAll();
    }
    
    private void updateActionPerformed(java.awt.event.ActionEvent evt) { 
        update();
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
