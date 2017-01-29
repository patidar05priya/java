
package business;

import java.io.Serializable;

public class Product implements Serializable 
{
    private String imageName;
    private String path;
    private double  price;
    private String color;
    private String discription;
    private String size;
    private String fabric;
    private String made;
    private String gender;
    private String type;
    private String date;
  

    public Product() {
        imageName = "";
        path = "";
        price = 0.0;
        color="";
        discription = "";
        size = "";
        fabric = "";
        made = "";
        gender = "";
        type = "";
        date = "";
       
    }
    public Product(String imageName)
    {
      this.imageName=imageName;
    }

    public Product(String imageName,String path,double price,String color,String dicription, String size, String fabric, String made, String gender,String type, String date)
    
        {
        this.imageName = imageName;
        this.path = path;
        this.price = price;
        this.color = color;
        this.discription = discription;
        this.size = size;
        this.fabric = fabric;
        this.made = made;
        this.gender = gender;
        this.type = type;
        this.date = date;
        
    }

     public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    public String getFabric() {
        return fabric;
    }
public void setFabric(String fabric) {
        this.fabric = fabric;
    }
 public void setMade(String made) {
        this.made = made;
    }
    public String getMade() {
        return made;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }
     public void setType(String type){
        this.type = type;
    }
    public String getType() {
        return type;
    }
     public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
     
}