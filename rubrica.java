/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.testmex;
import java.sql.*;
/**
 *
 * @author marman
 */
public class rubrica extends javax.swing.JFrame {
    public String nomeUtente;
    /**
     * Creates new form rubrica
     */
    public rubrica(String uname) {
        nomeUtente = uname;
        initComponents();
        
        
        }
    
    
    
    public String[] lstUtn(){
    String[] utenti = new String[20];
    
    try{  
            // create the mysql insert preparedstatement
            String query = "SELECT userName FROM utenti";
            PreparedStatement ps = MyConnection.getConnection().prepareStatement(query);          
            ResultSet rs=ps.executeQuery();
            int i = 0;
            while(rs.next()){
            String nome = rs.getString("userName");
            if(!nome.equals(nomeUtente)) {utenti[i] = nome;}
            i++;
            
            }
            }
        catch(Exception e){ System.out.println(e);} 
    
    return utenti;
    
    }
        
              
          
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = lstUtn();
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(505, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
            // TODO add your handling code here:
          
            if (evt.getClickCount() == 2) {
            int index = jList1.locationToIndex(evt.getPoint());
            if (index >= 0) {
            Object o = jList1.getModel().getElementAt(index);
            System.out.println("Double-clicked on: " + o.toString());
          }
        }
    }//GEN-LAST:event_jList1MouseClicked

                                       

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
