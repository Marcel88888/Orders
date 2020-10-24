package orders;

        
public class Product {
    
    private int description;
    private float price;
    private int amount;
    private Customer customer;
    private int customerProductId;
    private String customerProductIdentifier;
    private static int productId = 1;
    private String productIdentifier = "";
    public final static int 
            POT = 0, FRYING_PAN = 1, MUG = 2, CUTLERY = 3, PLATE = 4;     
    public final static float PRICES[] = new float[] {10.00f, 10.00f, 5.50f, 15.00f, 6.55f};

    
    public Product(int description, int amount, Customer customer) {
        this.customer = customer;
        this.description = description; 
        this.price = Product.PRICES[description];
        this.amount = amount;
        this.customerProductId = productId;
        if (String.valueOf(productId).length() == 1)
            productIdentifier = "000" + String.valueOf(productId);
        else if (String.valueOf(productId).length() == 2)
            productIdentifier = "00" + String.valueOf(productId);
        else if (String.valueOf(productId).length() == 3)
            productIdentifier = "0" + String.valueOf(productId);
        else if (productId == 10000) {
            System.out.println("Products limit has been reached.");
            System.exit(0);
        }
        else 
            productIdentifier = String.valueOf(productId);
        this.customerProductIdentifier = this.customer.getIdentifier() + productIdentifier;
        productId += 1;
    }

    public float getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public static void setProductId(int productId) {
        Product.productId = productId;
    }
    
    
    @Override
    public String toString() {
        String stringDescription = "";
        switch(description) {
            case 0: stringDescription = "POT"; break;
            case 1: stringDescription = "FRYING PAN"; break;
            case 2: stringDescription = "MUG"; break;
            case 3: stringDescription = "CUTLERY"; break;
            case 4: stringDescription = "PLATE"; break;
        }
        return stringDescription + "\nPrice: " + price + 
                "\nAmount: " + amount + "\nID: " + 
                customerProductIdentifier + "\n";
    }
}
