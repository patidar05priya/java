
package business;

import java.io.Serializable;

public class Cart implements Serializable {
    private String imageName;
    private double price;
    private String size;
    private int qty;
  
    
    public Cart()
    {
        imageName = "";
        price = 0.0;
        size = "";
        qty = 0;
        
    }
    public Cart(String imageName,Double price, String size, int qty,int total)
    {
        this.imageName=imageName;
        this.price = price;
        this.qty = qty;
        this.size = size;
        
    }
    public String getImageName()
    { 
        return imageName;
    }
    public void setImagename(String imageName)
    {
        this.imageName = imageName;
    }
     public double getPrice()
    { 
        return price;
    }
    public void setPrice(Double price)
    {
        this.price = price;
    }
     public String getSize()
    { 
        return size;
    }
    public void setSize(String size)
    {
        this.size = size;
    }
     public int getQty()
    { 
        return qty;
    }
    public void setQty(int qty)
    {
        this.qty = qty;
    }
    
}
