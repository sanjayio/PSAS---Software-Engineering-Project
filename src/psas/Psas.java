/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psas;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author sanjay
 * Created on: 3/5/2015
 */
public class Psas extends JFrame{
    
    private static javax.swing.JButton add;
    private static javax.swing.JButton view;
    private static javax.swing.JButton delete;
    private static javax.swing.JButton edit;
    
    public static void main(String[] args) {
        add = new JButton();
        view = new JButton();
        delete = new JButton();
        edit = new JButton();
        
        new Psas().setVisible(true);
    }
    
    public Psas() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        add.setText("Add");
        view.setText("View");
        delete.setText("Delete");
        edit.setText("Edit");
        
        getContentPane().add(add);
        add.setBounds(5, 5, 200, 50);
        
        getContentPane().add(view);
        view.setBounds(5, 60, 200, 50);
        
        getContentPane().add(edit);
        edit.setBounds(5, 115, 200, 50);
        
        getContentPane().add(delete);
        delete.setBounds(5, 170, 200, 50);
        
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });
        
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        
        setSize(230, 270);
    }
    
    private void viewActionPerformed(java.awt.event.ActionEvent evt) { 
        ListComplaints ch = new ListComplaints();
    }
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) { 
        AddComplaint ac = new AddComplaint();
    }
    
    private void editActionPerformed(java.awt.event.ActionEvent evt) { 
        EditComplaint ec = new EditComplaint();
    }
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) { 
        DeleteComplaint dc = new DeleteComplaint();
    }

}
