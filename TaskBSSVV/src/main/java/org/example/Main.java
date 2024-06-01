package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println("Hello world!");

        List<Integer> animals = new ArrayList<>(List.of(1, 2, 3, 4, 3, 2, 1, 1, 2, 3, 1));
        System.out.println(animals);
        Friends.beFriends( animals);
        System.out.println(animals);
    }
}