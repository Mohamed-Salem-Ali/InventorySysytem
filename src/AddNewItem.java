package inventorysystem;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class AddNewItem extends javax.swing.JFrame {
    
    ArrayList<Items> item;
    
    
    public AddNewItem() {
        initComponents();
        item =new ArrayList<Items>();
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
            JOptionPane.showMessageDialog(null,"Successfully Saved");
            new AddNewItem().setVisible(true);
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
        ID = new javax.swing.JTextField();
        NAME = new javax.swing.JTextField();
        PRICE = new javax.swing.JTextField();
        QUANTITY = new javax.swing.JTextField();
        MINIMUM_QUANTITY = new javax.swing.JTextField();
        SAVE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Add a new Item ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Item ID:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Item Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Item Price:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Item Quantity:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Minimum Quantity:");

        ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        PRICE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PRICE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRICEActionPerformed(evt);
            }
        });

        QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        MINIMUM_QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        SAVE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SAVE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/icons8-save-64.png"))); // NOI18N
        SAVE.setText("Save");
        SAVE.setToolTipText("");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(QUANTITY, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                            .addComponent(PRICE, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NAME, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MINIMUM_QUANTITY)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(SAVE)))
                .addGap(0, 78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(PRICE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(MINIMUM_QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(SAVE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

    private void PRICEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRICEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRICEActionPerformed

    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
       
        if(NAME.getText().isEmpty() || ID.getText().isEmpty() ||MINIMUM_QUANTITY.getText().isEmpty()||PRICE.getText().isEmpty()||QUANTITY.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Please Enter all Fields First");
        }
       else if (checkID(ID.getText()))
        {
            JOptionPane.showMessageDialog(null,"Please Enter New ID");
        }
        else  
        {
            String name =NAME.getText().trim();
            double price=Double.parseDouble(PRICE.getText().trim());
            int id=Integer.parseInt(ID.getText().trim());
            int quantity=Integer.parseInt(QUANTITY.getText().trim());
            int min_quantity=Integer.parseInt(MINIMUM_QUANTITY.getText().trim());
            Items Item = new Items(id,name,price,quantity,min_quantity);
            item.add(Item);
            saveItemsToFile();
        }
    }//GEN-LAST:event_SAVEActionPerformed

    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNewItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ID;
    private javax.swing.JTextField MINIMUM_QUANTITY;
    private javax.swing.JTextField NAME;
    private javax.swing.JTextField PRICE;
    private javax.swing.JTextField QUANTITY;
    private javax.swing.JButton SAVE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables

    private void Items(int i, int i0, int i1, String string, double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
