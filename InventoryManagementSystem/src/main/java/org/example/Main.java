package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Product> products = loadProducts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to do in this inventory?");
        String choose;
        do {
            System.out.println("a) Add product\nb) Find product\nc) Show all products\nd) Update product");
            System.out.println("e) Delete product\nf) Sort\ng) " +
                    "Filter by quantity\nh) Grouping by category\ni) Exit");
            System.out.print("Enter your choice: ");
            choose = scanner.nextLine().toLowerCase();

            switch (choose){
                case "a":
                     add(products,scanner);
                     break;
                case "b":
                    Product found = search(products,scanner);
                    if (found != null){
                        System.out.println(found);
                    }else System.out.println("Nothing match found!");
                    break;
                case "c":
                    showAll(products);
                    break;
                case "d":
                    update(products,scanner);
                    break;
                case "e":
                    delete(products,scanner);
                    break;
                case "f":
                    sortByPrice(products);
                    break;
                case "g":
                    filterByLowStock(products,scanner);
                    break;
                case "h":
                    groupByCategory(products);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

        }while (!choose.equals("i"));
        showAll(products);
        backup(products);
    }
    public static Product askForProduct(Scanner scanner){
        System.out.println("enter product fields:");
        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Price: ");
        double cost = scanner.nextInt();
        scanner.nextLine();

        String category = scanner.nextLine();
        Product product = new Product(id,name,quantity,cost,category);
        return product;
    }
    public static void add(List<Product> products,Scanner scanner){
        Product product = askForProduct(scanner);

        for (Product productt: products) {
                if(productt.getId().equalsIgnoreCase(product.getId())){
                    System.out.println("product exists");
                    return;
                }
            }
            products.add(product);
            System.out.println("product added");
    }
    public static Product search(List<Product> products,Scanner scanner,String id ){
        String idd = id;
        if (id == null) {
            System.out.println(products);
            System.out.println("Looking for a product? give me the id");
            idd = scanner.nextLine();
        }
        for (Product productt: products) {
            if (productt.getId().equalsIgnoreCase(idd)){
                return productt;
            }
        }
        return null;
    }
    public static Product search(List<Product> products, Scanner scanner) {
        return search(products, scanner, null); // Call the original method with 'id' as null
    }
    public static List<Product> loadProducts(){
        Path productsFile = Paths.get("products.txt");
        List<Product> products = new ArrayList<>();

        try {
            if (Files.exists(productsFile)){
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("products.txt"))){
                    products = (List<Product>) input.readObject();
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }else {
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("products.txt"))){
                    output.writeObject(new ArrayList<>());
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return products;
    }
    public static void backup(List<Product> products){
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("products.txt"))){
            output.writeObject(products);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void showAll(List<Product> products){
        if (products.isEmpty()){
            System.out.println("Inventory is empty!");
        }else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
    public static void update(List<Product> products,Scanner scanner){
        Product product = askForProduct(scanner);
        Product searchedProduct = search(products,scanner,product.getId());
        if (searchedProduct != null){
            searchedProduct.setName(product.getName());
            searchedProduct.setQty(product.getQty());
            searchedProduct.setCost(product.getCost());
            System.out.println(searchedProduct);
        }else System.out.println("No such product");
    }
    public static void delete(List<Product> products,Scanner scanner) {
        System.out.print("ID for delete: ");
        String id = scanner.nextLine();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()){
            Product p = iterator.next();
            if (p.getId().equalsIgnoreCase(id)){
                iterator.remove();
                System.out.println("product was deleted");
                return;
            }
        }
        System.out.println("Product not found");
    }

    public static void sortByPrice(List<Product> products){
        if (products.isEmpty()) {
            System.out.println("Products is empty");
            return;
        }
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort(Comparator.comparing(Product::getCost).reversed());
        System.out.println("sorted products by price");
        System.out.println(sortedList);
    }
    public static void filterByLowStock(List<Product> products,Scanner scanner){
        System.out.println("enter the threshold:");
        int threshold = scanner.nextInt();
        scanner.nextLine();
        if (products.isEmpty()){
            System.out.println("Products is empty");
            return;
        }
        boolean found = false;
        System.out.println("Products with quantity less than :"+threshold);
        for (Product product: products){
            if (product.getQty() < threshold){
                System.out.println(product);
                found = true;
            }
        }
        if (!found) System.out.println("No product found with low stock");

    }

    public static void groupByCategory(List<Product> products) {
        Map<String,List<Product>> grouped = new TreeMap<>();
        for (Product product : products){
            grouped.computeIfAbsent(product.getCategory(), p -> new ArrayList<>()).add(product);
        }
        for (Map.Entry<String,List<Product>> entry : grouped.entrySet()){
            System.out.println("Category: "+ entry.getKey());
            for (Product p : entry.getValue()){
                System.out.println(p);
            }
        }
    }
}