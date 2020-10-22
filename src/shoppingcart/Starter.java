package shoppingcart;

import java.util.HashSet;
import javax.swing.JOptionPane;



public class Starter {
    public static void main(String[] args) {
        String name, address;
        boolean vipDelivery;
        int description, amount, vd, contin1, contin2;
        HashSet<Customer> customers = new HashSet<>();
        Customer customer;
        Product product;
        String[] descriptions = {"Pot" , "Frying pan" , "Mug" , "Cutlery" , 
            "Plate"};
        do {
            name = JOptionPane.showInputDialog(null, "Type customer's name");
            address = JOptionPane.showInputDialog(null, "Type customer's address");
            vipDelivery = false;
            vd = JOptionPane.showConfirmDialog(null, 
                    "Does the customer have VIP delivery?", "Select the option", 
                    JOptionPane.YES_NO_OPTION);
            if (vd == 0)
                vipDelivery = true;
            Product.setProductId(1);
            customer = new Customer(name, address, vipDelivery);
            customers.add(customer);
            do {
                description = JOptionPane.showOptionDialog(null, "Which product"
                    + "do you want to add?", "Product", 
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, 
                    null, descriptions, descriptions[0]);
                try {
                amount = Integer.parseInt(JOptionPane.showInputDialog(null, 
                        "Amount"));
                } catch (NumberFormatException e) {amount = 1;}
                product = new Product(description, amount, customer);
                customer.addProduct(product);
                contin1 = JOptionPane.showConfirmDialog(null, 
                    "Do you want to add another product?", "Select the option", 
                    JOptionPane.YES_NO_OPTION);
            } while (contin1 == 0);
        contin2 = JOptionPane.showConfirmDialog(null, 
                    "Do you want to add another customer?", "Select the option", 
                    JOptionPane.YES_NO_OPTION);
        } while (contin2 == 0);
        for (Customer customerr: customers) {
            JOptionPane.showMessageDialog(null, customerr);
        }
    }
}
