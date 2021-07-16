package inventorysystem;
import javax.swing.*;
import java.util.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

public class BuyItem extends javax.swing.JFrame {

    double total=0.0;
    int n=0;
    ArrayList<Double> Total_Price;
    ArrayList<Items> item;
    public BuyItem() {
        initComponents();
        item = new ArrayList<Items>();
        Total_Price =new ArrayList<Double>();
        populateArrayList();
        
         String [] itemsArray = new String[item.size()];
        
        for(int i=0;i<item.size();i++)
        {
            itemsArray[i]="("+item.get(i).getProductName()+","+item.get(i).getPrice()+")";
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
public void totalPrice()
{
    if(total==0)
    {
        for(int i=0;i<Total_Price.size();i++)
        {
            total+=Total_Price.get(i);
        }
    }    
        
}
 public void addRowJtable()
    {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object rowData[] = new Object[4];
        int x=0;
        int selectedIndex=ITEMS.getSelectedIndex();
        double c;
        int q=0,v=0;
        q=item.get(selectedIndex).getQuantity()-Integer.parseInt(QUANTITY.getText().trim());
        v=item.get(selectedIndex).getQuantity()-item.get(selectedIndex).getMinimumQuantity();
            if(item.get(selectedIndex).getMinimumQuantity()>q)
            {
                JOptionPane.showMessageDialog(null,"sorry You can't buy this item \n only "+ v +" item left");
                    
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Successfully Added");
                 rowData[0]=item.get(selectedIndex).getProductName();
                    rowData[1]=item.get(selectedIndex).getPrice();
                    rowData[2]=Integer.parseInt(QUANTITY.getText().trim());
                    rowData[3]=Integer.parseInt(QUANTITY.getText().trim())*item.get(selectedIndex).getPrice();
                    c =Integer.parseInt(QUANTITY.getText().trim())*item.get(selectedIndex).getPrice();
                    Total_Price.add(c);
                    n+=Integer.parseInt(QUANTITY.getText().trim());
                    int q1=Integer.parseInt(QUANTITY.getText().trim());
                    int q2=item.get(selectedIndex).getQuantity();
                    item.get(selectedIndex).setQuantity(q2-q1);
                model.addRow(rowData);
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
            JOptionPane.showMessageDialog(null,"Successfully Done");
           /* new BuyItem().setVisible(true);
            this.dispose();*/
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
        QUANTITY = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        ITEMS = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        BUY = new javax.swing.JButton();
        a = new javax.swing.JLabel();
        a1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Buy Items");

        QUANTITY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText(" Quantity:");

        Add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/add.png"))); // NOI18N
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        ITEMS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ITEMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Choose Item:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "price", "Quantity", "Total.Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        BUY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BUY.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventorysystem/Pics/icons8-buy-48.png"))); // NOI18N
        BUY.setText("Buy");
        BUY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUYActionPerformed(evt);
            }
        });

        a.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a.setForeground(new java.awt.Color(255, 51, 51));
        a.setAlignmentX(4.0F);
        a.setAlignmentY(4.0F);

        a1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        a1.setForeground(new java.awt.Color(255, 51, 51));
        a1.setAlignmentX(4.0F);
        a1.setAlignmentY(4.0F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ITEMS, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(a))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(a1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(BUY)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(QUANTITY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BUY)
                .addGap(29, 29, 29)
                .addComponent(a)
                .addGap(18, 18, 18)
                .addComponent(a1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        
        if(QUANTITY.getText().isEmpty())
        {
         JOptionPane.showMessageDialog(null,"enter number of Selected item that you want");
        }
        else
        {
            addRowJtable();
        }
        
    }//GEN-LAST:event_AddActionPerformed

    private void BUYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUYActionPerformed
        
        if(n==0)
        {
         JOptionPane.showMessageDialog(null,"Please Add Item First");
        }
        else
        {
        totalPrice();
        saveItemsToFile();
        JOptionPane.showMessageDialog(null,"Number of items="+n+"\n Total Price="+total);
         this.dispose();
        }
       
    }//GEN-LAST:event_BUYActionPerformed

   
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BuyItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuyItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuyItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuyItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuyItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton BUY;
    private javax.swing.JComboBox<String> ITEMS;
    private javax.swing.JTextField QUANTITY;
    private javax.swing.JLabel a;
    private javax.swing.JLabel a1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
