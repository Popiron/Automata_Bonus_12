package com.dgalushko;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            System.out.println("Укажите путь к текстовому файлу!");
            Scanner in = new Scanner(System.in);
            var path = in.nextLine();
            var data = Helpers.openFileAndReadData(path);
            Helpers.processData(data);
            Grammar.DeleteCircleRules();
            Grammar.printResults();
    }
}
