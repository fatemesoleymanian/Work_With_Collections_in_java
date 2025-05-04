package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Product> products = loadProducts();
        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter product fields:");
//        System.out.print("ID: ");
//        String id = scanner.nextLine();
//        System.out.print("Name: ");
//        String name = scanner.nextLine();
//        System.out.print("Quantity: ");
//        int quantity = scanner.nextInt();
//        System.out.print("Price: ");
//        double cost = scanner.nextInt();
//        scanner.nextLine();
//        Product product = new Product(id,name,quantity,cost);
//        add(products,product);
//        System.out.println("hi");
        System.out.println(products);
        System.out.println("Looking for a product? give me the id");
        String idd = scanner.nextLine();
        Product found = search(products,idd);
        if (found != null){
            System.out.println(found);
        }else System.out.println("Nothing match found!");

        backup(products);
    }
    public static void add(List<Product> products,Product product){

            for (Product productt: products) {
                if(productt.getId().equalsIgnoreCase(product.getId())){
                    System.out.println("product exists");
                    return;
                }
            }
            products.add(product);
            System.out.println("product added");
    }
    public static Product search(List<Product> products,String id){
        for (Product productt: products) {
            if (productt.getId().equalsIgnoreCase(id)){
                return productt;
            }
        }
        return null;
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
}