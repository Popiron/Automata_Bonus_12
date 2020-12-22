package com.dgalushko;

import java.util.*;

public class Grammar {
    static ArrayList<String> nonTerminals = new ArrayList<>();
    static ArrayList<String> terminals = new ArrayList<>();
    static HashMap<String,ArrayList<String>> production = new HashMap<>();

    private static HashMap<String,ArrayList<String>> t_production = new HashMap<>();

    public static void DeleteCircleRules() {
        t_production = Helpers.copy(production);
        for (var p: production.entrySet())
        {
            for (var e :p.getValue())
            {
                if (nonTerminals.contains(e))
                {
                    t_production.get(p.getKey()).remove(e);
                    removeChains(p.getKey(),e);
                }
            }
        }
    }

    private static void removeChains(String mainKey, String addKey)
    {
        for (var e: t_production.get(addKey)) {
            if (nonTerminals.contains(e))
            {
                removeChains(mainKey,e);
            } else
            {
                t_production.get(mainKey).add(e);
            }
        }
    }

    public static void printResults()
    {
        System.out.println("Перед применением алгоритма:");
        for (var p: production.entrySet())
        {
            System.out.print(p.getKey()+"->");
            StringBuilder s = new StringBuilder();
            for (var e :p.getValue())
            {
                s.append(e).append('|');
            }
            if (s.toString().endsWith("|")) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append(" ");
            System.out.print(s);
        }

        System.out.println();

        System.out.println("Результат применения алгоритма:");
        for (var p: t_production.entrySet())
        {
            System.out.print(p.getKey()+"->");
            StringBuilder s = new StringBuilder();
            for (var e :p.getValue())
            {
                s.append(e).append('|');
            }
            if (s.toString().endsWith("|")) {
                s.deleteCharAt(s.length() - 1);
            }
            s.append(" ");
            System.out.print(s);
        }
    }

}
