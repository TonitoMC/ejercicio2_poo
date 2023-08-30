import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program is an invetory-keeping tool for stores
 * that keeps track of objects, prices and their profitability
 * @author Jose Merida
 * @version 1.0
 * @since 29-08-2023
 */
public class Main {
    /**
     * This is the main method that uses an ArrayList of the Product class to keep track
     * of an inventory
     * @param args unused
     */
    public static void main(String[] args) {
        /**
         * Creates ArrayList, starts a first menu loop requesting the user to input
         * 10 different products before the main program starts
         */
        ArrayList<Product> productList = new ArrayList<Product>();
        Scanner scanner = new Scanner(System.in);
        boolean inFirstMenu = true;
        while(inFirstMenu) {
            System.out.println("Antes de acceder al programa debe ingresar los datos de mínimo 10 productos");
            System.out.println("Ingrese la cantidad de productos que desea ingresar");
            int productQuantity = scanner.nextInt();
            scanner.nextLine();
            if (productQuantity >= 10) {
                for (int i = 0; i < productQuantity; i++) {
                    System.out.println("Ingrese el nombre del producto");
                    String currentName = scanner.nextLine();
                    System.out.println("Ingrese el precio del producto");
                    int currentPrice = scanner.nextInt();
                    System.out.println("Ingrese la disponibilidad inicial del producto");
                    int currentAvailability = scanner.nextInt();
                    productList.add(new Product(currentName, currentPrice, currentAvailability, 0));
                    scanner.nextLine();
                }
                inFirstMenu = false;
            } else {
                System.out.println("Número inválido");
            }
        }
        /**
         * Main menu, prints out the options and uses a switch case to access each one
         * with an int entered by the user
         */
        while(true){
            System.out.println("Ingrese el número de la opción a la que desea ingresar");
            System.out.println("1. Agregar un nuevo producto");
            System.out.println("2. Mostrar inventario actual");
            System.out.println("3. Vender un producto");
            System.out.println("4. Salir del programa y generar reporte de ventas");
            int mainSelection = scanner.nextInt();
            scanner.nextLine();
            switch (mainSelection){
                /**
                 * Adding a new product, user has to input the name, price and availability for each product.
                 * Creates a new product with user input and adds it to the list
                 */
                case 1:
                    System.out.println("Ingrese el nombre del producto");
                    String currentName = scanner.nextLine();
                    System.out.println("Ingrese el precio del producto");
                    int currentPrice = scanner.nextInt();
                    System.out.println("Ingrese la disponibilidad inicial del producto");
                    int currentAvailability = scanner.nextInt();
                    productList.add(new Product(currentName, currentPrice, currentAvailability, 0));
                    break;
                case 2:
                    /**
                     * Prints out details for each of the products currently in inventory
                     */
                    for(int i=0; i < productList.size(); i++){
                        Product currentProduct = productList.get(i);
                        int listCount = i+1;
                        System.out.println(listCount + ". " + currentProduct.getDetails());
                    }
                    break;
                case 3:
                    /**
                     * Prints out details for each product currently in inventory
                     */
                    System.out.println("Estos son los productos disponibles");
                    for(int i=0; i < productList.size(); i++){
                        Product currentProduct = productList.get(i);
                        int listCount = i+1;
                        System.out.println(listCount + ". " + currentProduct.getDetails());
                    }
                    /**
                     * Requests user input to find product to sell and quantity of the product
                     */
                    System.out.println("Ingrese el número del producto que desea vender");
                    int productInput = scanner.nextInt();
                    int productSelection = productInput - 1;
                    System.out.println("Ingrese la cantidad de productos que desea vender");
                    int productQuantity = scanner.nextInt();
                    Product sellProduct = productList.get(productSelection);
                    System.out.println("Se vendieron " + sellProduct.sell(productQuantity) + " productos");
                    break;
                case 4:
                    /**
                     * Goes through ArrayList adding profitabilities of every Product in Arraylist and
                     * prints out total result at the end, exits the program afterwards.
                     */
                    int totalProfitability = 0;
                    for(int i=0; i<productList.size(); i++){
                        Product currentProduct = productList.get(i);
                        int listCount = i+1;
                        System.out.println(listCount + ". " + currentProduct.getDetails());
                        totalProfitability = totalProfitability + currentProduct.getProfitability();
                    }
                    System.out.println("El total de ventas realizadas es de " + totalProfitability);
                    System.exit(0);
                    break;
            }
        }
    }
}