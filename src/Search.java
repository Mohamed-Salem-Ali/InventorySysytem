
package inventorysystem;

import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class Search extends javax.swing.JFrame {

     ArrayList<Items> item;
    
    public Search() {
        initComponents();
        item = new ArrayList<Items>();
      populateArrayList();
    }
    public void populateArrayList()
    {
        try
        {
            FileInputStream file = new FileInputStream("Items.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            boolean endOfFile=false;
            while(!endOfFile)
            {
                try
                {
                    item.add((Items) inputFile.readObject());
                }
                catch(EOFException e)
                {
                  endOfFile=true;
                }
                catch(Exception f)
                {
                 JOptionPane.showMessageDialog(null, f.getMessage());   
                }
                
            }
            inputFile.close();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
    }
    public void addRowJtable()
    {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Minimum Quantity"
            }
        ));
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[5];
        int x=0;
        for(int i=0;i<item.size();i++)
        {
            if(item.get(i).getProductName().contains(NAME.getText().trim()))
            {
               x++; 
                rowData[0]=item.get(i).getID();
                    rowData[1]=item.get(i).getProductName();
                        rowData[2]=item.get(i).getPrice();
                            rowData[3]=item.get(i).getQuantity();
                                rowData[4]=item.get(i).getMinimumQuantity();
                model.addRow(rowData);
            }
        }
        if(x>0)
        {
             JOptionPane.showMessageDialog(null,"There are ("+x+") items with name ("+NAME.getText().trim()+")");
        }
        else
        {
             JOptionPane.showMessageDialog(null,"No Item with name ("+NAME.getText().trim()+")");
        }
    }
    

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NAME = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search for an Item");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Search");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Enter the Name of Item:");

        NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        NAME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NAMEActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/icons8-search-48.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(0, 153, 153));
        jTable1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity", "Minimum Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NAMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NAMEActionPerformed
       
    }//GEN-LAST:event_NAMEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        if(NAME.getText().isEmpty())
        {
         JOptionPane.showMessageDialog(null,"Please enter the name of item first");
        }
        else
        {
        addRowJtable();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NAME;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
