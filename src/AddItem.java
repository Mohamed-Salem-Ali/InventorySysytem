
package inventorysystem;

import javax.swing.*;
import java.util.*;
import java.io.*;

public class AddItem extends javax.swing.JFrame {

    ArrayList<Items> item;
    
    public AddItem() {
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
            JOptionPane.showMessageDialog(null,"Successfully Added");
            new AddItem().setVisible(true);
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

        ITEMS = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        QUANTITY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        EDIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ITEMS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ITEMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Choose Item:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add Item");

        QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Item Quantity:");

        EDIT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/add.png"))); // NOI18N
        EDIT.setText("Add");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ITEMS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QUANTITY))
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1)))
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ITEMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed

        if(QUANTITY.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please Enter the quantity you want to add First");
        }
        
        else
        {
            int selectedIndex=ITEMS.getSelectedIndex();
            int q1=Integer.parseInt(QUANTITY.getText().trim());
            int q2=item.get(selectedIndex).getQuantity();
            item.get(selectedIndex).setQuantity(q1+q2);

            saveItemsToFile();
        }

    }//GEN-LAST:event_EDITActionPerformed

   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EDIT;
    private javax.swing.JComboBox<String> ITEMS;
    private javax.swing.JTextField QUANTITY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
