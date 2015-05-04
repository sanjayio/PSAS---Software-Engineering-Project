/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author sanjay
 */
public class ListComplaints extends JFrame{
    
    private javax.swing.JButton refresh;
    private javax.swing.JTextArea jTextArea;  
    private javax.swing.JScrollPane jScrollPane;
    
    public ListComplaints() {
        init();
        setSize(800, 500);
    }
    
    public void insert() {
        jTextArea.setText("");
        try {
            Connection con = databaseConnect();
            if(con != null) {
                PreparedStatement ps = con.prepareStatement("select * from complaints");
                ResultSet rs = ps.executeQuery();
                while(rs.next()) {
                    jTextArea.append("\nID: " + rs.getInt(1) + "\nTitle: " + rs.getString(2) + "\nDescription: " + rs.getString(3) + "\nCreated at: " + rs.getDate(4) + "\nStatus: " + rs.getString(5) + "\nCustomer ID: " + rs.getInt(6) + "\nPriority: " + rs.getString(7) + "\n");
                }
            } else {
                System.out.println("error connecting to database.");
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void init() {
        jTextArea = new JTextArea();
        refresh = new JButton();
        jScrollPane = new JScrollPane();
        
        setDefaultCloseOperation(ListComplaints.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        refresh.setText("Refresh");

        /* Whenever button is pressed this action happens */

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        
        getContentPane().add(refresh);
        refresh.setBounds(5, 425, 205, 30);

        jTextArea.setColumns(20);
        jTextArea.setEditable(false);
        jTextArea.setRows(50);
        jScrollPane.setViewportView(jTextArea);

        getContentPane().add(jScrollPane);
        jScrollPane.setBounds(5, 5, 775, 420);

        insert();
        setVisible(true);
    }
    
    private void refreshActionPerformed(java.awt.event.ActionEvent evt) { 
        insert();
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
