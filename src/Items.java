package inventorysystem;
import java.io.*;
public class Items implements Serializable 
{
    private int ID;
    private String ProductName;
    private double Price;
    private int Quantity;
    private int MinimumQuantity;
    public Items(int ID, String ProductName, double Price,int Quantity, int MinimumQuantity) 
    {
        this.ID = ID;
        this.Quantity = Quantity;
        this.MinimumQuantity = MinimumQuantity;
        this.ProductName = ProductName;
        this.Price = Price;
    }

    public int getID() 
    {
        return ID;
    }

    public void setID(int ID) 
    {
        this.ID = ID;
    }

    public int getQuantity() 
    {
        return Quantity;
    }

    public void setQuantity(int Quantity) 
    {
        this.Quantity = Quantity;
    }

    public int getMinimumQuantity() 
    {
        return MinimumQuantity;
    }

    public void setMinimumQuantity(int MinimumQuantity) 
    {
        this.MinimumQuantity = MinimumQuantity;
    }

    public String getProductName() 
    {
        return ProductName;
    }

    public void setProductName(String ProductName) 
    {
        this.ProductName = ProductName;
    }

    public double getPrice() 
    {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
    
    
}
