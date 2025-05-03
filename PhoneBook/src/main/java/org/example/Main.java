package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> phoneBook = loadPhoneBookFile();
        Scanner scanner = new Scanner(System.in);
        String choose;

        System.out.println("This is your phone book.");

        do {
            System.out.println("\nWhat do you want to do?");
            System.out.println("a) Add contact\nb) Find contact\nc) Show all contacts\nd) Update contact");
            System.out.println("e) Delete contact\nf) Backup\ng) Exit");
            System.out.print("Enter your choice: ");
            choose = scanner.nextLine().toLowerCase();

            String key, value;
            switch (choose) {
                case "a":
                    System.out.print("Enter contact name: ");
                    key = scanner.nextLine();
                    System.out.print("Enter contact number: ");
                    value = scanner.nextLine();
                    add(phoneBook, key, value);
                    break;
                case "b":
                    System.out.print("Enter contact name: ");
                    key = scanner.nextLine();
                    search(phoneBook, key);
                    break;
                case "c":
                    all(phoneBook);
                    break;
                case "d":
                    System.out.print("Enter contact name: ");
                    key = scanner.nextLine();
                    System.out.print("Enter new contact number: ");
                    value = scanner.nextLine();
                    update(phoneBook, key, value);
                    break;
                case "e":
                    System.out.print("Enter contact name: ");
                    key = scanner.nextLine();
                    delete(phoneBook, key);
                    break;
                case "f":
                    backup(phoneBook);
                    break;
                case "g":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (!choose.equals("g"));

    }
    public static void add(Map<String,String> phoneBook,String key, String value){
        if (phoneBook.containsKey(key)){
            Scanner scanner = new Scanner(System.in);
            System.out.println("contact exists , do you want to update? y/n");
            String confirm = scanner.nextLine();
            if (!confirm.equalsIgnoreCase("y")) return;

        }
        phoneBook.put(key,value);
        System.out.println("New Contact Added : "+ key + " : " + value);
    }
    public static void search(Map<String,String> phoneBook,String key){
        String number = phoneBook.get(key);
        boolean found = false;
        for (Map.Entry<String,String> entry: phoneBook.entrySet()){
            if (entry.getKey().toLowerCase().contains(key.toLowerCase())){
                System.out.println(" - " + entry.getKey() + " : " + entry.getValue());
                found = true;
            }
        }
        if (!found) System.out.println("No such contact");
    }
    public static void all(Map<String,String> phoneBook){
        if (phoneBook.isEmpty()) {
            System.out.println("Phone book is empty!");
        }else {
            for (Map.Entry<String, String> list : phoneBook.entrySet()) {
                System.out.println(" -" + list.getKey() + " : " + list.getValue());
            }
        }
    }
    public static void update(Map<String,String> phoneBook,String key, String value){
        if (phoneBook.containsKey(key)){
            phoneBook.put(key,value);
            System.out.println("Contact Updated : "+ key + " : " + value);
        }else System.out.println("Contact Not Found!");

    }
    public static void delete(Map<String,String> phoneBook,String key){
        if (phoneBook.containsKey(key)) {
            System.out.println("Deleted contact: " + key + " - " + phoneBook.remove(key));
        } else {
            System.out.println("Contact not found: " + key);
        }    }
    public static void backup(Map<String,String> phoneBook){
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("phonebook.txt"))) {
            output.writeObject(phoneBook);
            System.out.println("Backup was succesful!");
        }catch (IOException e){
            System.out.println("Error in writing in backup");
            e.printStackTrace();
        }
    }
    public static TreeMap<String, String> loadPhoneBookFile() {
        Path filePath = Paths.get("phonebook.txt");
        TreeMap<String, String> list = new TreeMap<>();

        try {
            if (Files.exists(filePath)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("phonebook.txt"))) {
                    list = (TreeMap<String, String>) input.readObject();
                }
            } else {
                // Create new file with empty TreeMap
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("phonebook.txt"))) {
                    output.writeObject(new TreeMap<String, String>());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error initializing phone book. Starting with empty contacts.");
            e.printStackTrace();
        }
        return list;
    }
}