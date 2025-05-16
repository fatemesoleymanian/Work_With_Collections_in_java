package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {

        try {
            Class<?> documentClass = Class.forName("org.example.Document");
            Class<?> personClass = Class.forName("org.example.Person");
            Document documentObj = (Document) documentClass.getConstructor().newInstance();
            Person personObj = (Person) personClass.getConstructor().newInstance();
            Field publisher = documentClass.getDeclaredField("publisher");
            publisher.setAccessible(true);
            publisher.set(documentObj,personObj);
            System.out.println(publisher.getName());
        } catch (NoSuchMethodException | ClassNotFoundException |InvocationTargetException| NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
       }
    }
}