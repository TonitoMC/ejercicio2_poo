/**
 * This class stores and updates information on a Product for inventory-keeping
 * @author Jose Merida
 * @version 1.0
 * @since 29-08-2023
 */public class Product {
    final String name;
    final int price;
    private int availability;
    private int profitability;

    /**
     * Constructor for Product class, creates a new product & assigns initial values to the instance
     * @param name This sets the name attribute for a new product
     * @param price This sets the price attribute for a new product
     * @param availability This sets the initial availability attribute for a new product
     * @param profitability This sets the initial profitability attribute for a new product
     */
    public Product(String name, int price, int availability, int profitability){
        this.name = name;
        this.price = price;
        this.availability = availability;
        this.profitability = profitability;
    }

    /**
     * The Sell method updates the availability and profitability of a product as its sold.
     * @param quantity The quantity of products we are trying to sell
     * @return The quantity of products that was able to be sold, taking availability into account
     */
    public int sell(int quantity){
        int productCounter = 0;
        for(int i=0; i< quantity; i++) {
            if (this.availability > 0) {
                this.profitability = this.profitability + this.price;
                this.availability--;
                productCounter++;
            }
        }
        return productCounter;
    }
    /**
     * The getDetails method returns a string with the name and availability for each product
     * @return String with name and availability of each product
     */
    public String getDetails(){
        return this.name + " - " + this.availability;
    }
    /**
     * The getProfitability method returns a products profitability
     * @return Int with the profitability of a product
     */
    public int getProfitability(){
        return this.profitability;
    }
}
