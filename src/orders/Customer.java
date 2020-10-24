package orders;

import java.util.HashSet;


public class Customer {
    
   private String identifier = "";
   private String name;
   private String address;
   private boolean vipDelivery;
   private HashSet<Product> products;
   private static int id = 1;

    public Customer(String name, String address, boolean vipDelivery) {
        products = new HashSet<>();
        this.name = name;
        this.address = address;
        this.vipDelivery = vipDelivery;
        if (String.valueOf(id).length() == 1)
            identifier = "00" + String.valueOf(id);
        else if (String.valueOf(id).length() == 2)
            identifier = "0" + String.valueOf(id);
        else if (id == 1000) {
            System.out.println("Customer limit has been reached.");
            System.exit(0);
        }
        else 
            identifier = String.valueOf(id);
        id += 1;
    }
    
    public String getIdentifier() {
        return identifier;  
    }
    
    public float calculateTotalPrice() {
        float totalPrice = 0.00f;
        for (Product product: products) 
            totalPrice += (product.getPrice() * product.getAmount());
        return totalPrice;
    }
    
    public void addProduct(Product newProduct) {
        products.add(newProduct);
    }
    
    @Override
    public String toString() {
        String result = "ID: " + identifier + "\nName: " + name + "\nAddress: " + 
                address + "\nVIP Delivery: " + vipDelivery + "\n\nPRODUCTS:\n\n";
        for(Product p: products)
            result += p.toString() + ("\n");
        result += "Total price: " + String.format("%.2f", calculateTotalPrice()) + "\n";
        return result;
    }
    
    
    
   
   
}
