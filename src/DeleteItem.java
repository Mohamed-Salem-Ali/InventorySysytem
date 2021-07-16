
package inventorysystem;
import javax.swing.*;
import java.util.*;
import java.io.*;


public class DeleteItem extends javax.swing.JFrame {

    ArrayList<Items> item;
    
    public DeleteItem() {
        initComponents();
        item = new ArrayList<Items>();
        populateArrayList();
     String [] itemsArray = new String[item.size()];
        
        for(int i=0;i<item.size();i++)
        {
            itemsArray[i]="("+item.get(i).getID()+","+item.get(i).getProductName()+")";
        }
        ITEMS.setModel(new javax.swing.DefaultComboBoxModel<>(itemsArray));
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
      public void saveItemsToFile()
    {
        try
        {
            FileOutputStream file = new FileOutputStream("Items.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            for (int i=0;i<item.size();i++)
            {
                outputFile.writeObject(item.get(i));
            }
            outputFile.close();
            JOptionPane.showMessageDialog(null,"Successfully Deleted");
            new DeleteItem().setVisible(true);
            this.dispose();
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ITEMS = new javax.swing.JComboBox<>();
        DELETE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Delete Item");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Choose Item:");

        ITEMS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ITEMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                  Select your Item", "Item 1", "Item 2", "Item 3", "Item 4" }));
        ITEMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITEMSActionPerformed(evt);
            }
        });

        DELETE.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DELETE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/exit.png"))); // NOI18N
        DELETE.setText("Delete");
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DELETE)
                            .addComponent(ITEMS, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(87, 87, 87))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ITEMS, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        int selectedIndex=ITEMS.getSelectedIndex();
        
        item.remove(selectedIndex);
        
        saveItemsToFile();
        
    }//GEN-LAST:event_DELETEActionPerformed

    private void ITEMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEMSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ITEMSActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DELETE;
    private javax.swing.JComboBox<String> ITEMS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
