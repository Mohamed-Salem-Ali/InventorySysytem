package inventorysystem;

import javax.swing.*;
import java.util.*;
import java.io.*;


public class EditItem extends javax.swing.JFrame {
    
    ArrayList<Items> item;
    
    public EditItem() 
    {
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
      public boolean checkID(String s)
    {
        
        int index=0;
        for(int i=0;i<item.size();i++)
        {
            if(item.get(i).getID()==Integer.parseInt(s))
            {
             return true;
            }
        }
        return false;
    }
      public boolean equalID(String s)
     {
         int index=ITEMS.getSelectedIndex();
         if(item.get(index).getID()==Integer.parseInt(s))
         {
                 return true;
            }
         return false;
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
            JOptionPane.showMessageDialog(null,"Successfully Edited");
             new EditItem().setVisible(true);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ITEMS = new javax.swing.JComboBox<>();
        ID = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        PRICE = new javax.swing.JTextField();
        QUANTITY = new javax.swing.JTextField();
        MINIMUM_QUANTITY = new javax.swing.JTextField();
        EDIT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Edit Item data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Choose Item:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Item ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Item Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Item Price:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Item Quantity:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Minimum Quantity:");

        ITEMS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ITEMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                  Select your Item", "Item 1", "Item 2", "Item 3", "Item 4" }));
        ITEMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ITEMSActionPerformed(evt);
            }
        });

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        PRICE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        MINIMUM_QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        EDIT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        EDIT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/edit.png"))); // NOI18N
        EDIT.setText("Edit");
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ITEMS, 0, 314, Short.MAX_VALUE)
                            .addComponent(ID)
                            .addComponent(NAME)
                            .addComponent(PRICE)
                            .addComponent(QUANTITY)
                            .addComponent(MINIMUM_QUANTITY)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel1)))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ITEMS))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MINIMUM_QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ITEMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ITEMSActionPerformed
       
        int selectedIndex=ITEMS.getSelectedIndex();
        
        ID.setText(item.get(selectedIndex).getID()+"");
        NAME.setText(item.get(selectedIndex).getProductName());
        PRICE.setText(item.get(selectedIndex).getPrice()+"");
        QUANTITY.setText(item.get(selectedIndex).getQuantity()+"");
        MINIMUM_QUANTITY.setText(item.get(selectedIndex).getMinimumQuantity()+"");
        
        Items item1 = item.get(selectedIndex);
        int index=0;
        for(int i=0;i<item.size();i++)
        {
            if(item.get(i).equals(item1))
            {
                index =i;
                break;
            }
        }
    }//GEN-LAST:event_ITEMSActionPerformed

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
      
         if(NAME.getText().isEmpty() || ID.getText().isEmpty() ||MINIMUM_QUANTITY.getText().isEmpty()||PRICE.getText().isEmpty()||QUANTITY.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please Enter all Fields First");
        }
            else if(true){ 
           
                    if(equalID(ID.getText()))
                    {
                        int selectedIndex=ITEMS.getSelectedIndex();
                        item.get(selectedIndex).setProductName(NAME.getText().trim());
                        item.get(selectedIndex).setID(Integer.parseInt(ID.getText().trim()));
                        item.get(selectedIndex).setMinimumQuantity(Integer.parseInt(MINIMUM_QUANTITY.getText().trim()));
                        item.get(selectedIndex).setPrice(Double.parseDouble(PRICE.getText().trim()));
                        item.get(selectedIndex).setQuantity(Integer.parseInt(QUANTITY.getText().trim()));
           
                         saveItemsToFile();
                        
                    }
                    else
                    {
                        if(checkID(ID.getText()))
                        {
                            JOptionPane.showMessageDialog(null,"This ID is used,,,Please Enter another ID");
                        } 
                    }
         }
        else  
        {
           int selectedIndex=ITEMS.getSelectedIndex();
           item.get(selectedIndex).setProductName(NAME.getText().trim());
           item.get(selectedIndex).setID(Integer.parseInt(ID.getText().trim()));
           item.get(selectedIndex).setMinimumQuantity(Integer.parseInt(MINIMUM_QUANTITY.getText().trim()));
           item.get(selectedIndex).setPrice(Double.parseDouble(PRICE.getText().trim()));
           item.get(selectedIndex).setQuantity(Integer.parseInt(QUANTITY.getText().trim()));
           
           saveItemsToFile();
        }
         
    }//GEN-LAST:event_EDITActionPerformed


    public static void main(String args[]) {

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EDIT;
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> ITEMS;
    private javax.swing.JTextField MINIMUM_QUANTITY;
    private javax.swing.JTextField NAME;
    private javax.swing.JTextField PRICE;
    private javax.swing.JTextField QUANTITY;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
