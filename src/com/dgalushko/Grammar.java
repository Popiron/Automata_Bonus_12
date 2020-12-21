package com.dgalushko;

import java.util.*;

public class Grammar {
    //static String grammarSign;
    static ArrayList<String> norTerminals = new ArrayList<>();
    static ArrayList<String> signature = new ArrayList<>();
    static HashMap<String,ArrayList<String>> production = new HashMap<>();
   // static String startingSign;

    private static HashMap<String,ArrayList<String>> t_production = new HashMap<>();

    public static void DeleteCircleRules() {
        t_production = Helpers.copy(production);
        for (var p: production.entrySet())
        {
            for (var e :p.getValue())
            {
                if (norTerminals.contains(e))
                {
                    t_production.get(p.getKey()).remove(e);
                    f(p.getKey(),e);
                }
            }
        }
    }

    private static void f(String mainKey,String addKey)
    {
        for (var e: t_production.get(addKey)) {
            if (norTerminals.contains(e))
            {
                f(mainKey,e);
            } else
            {
                t_production.get(mainKey).add(e);
            }
        }
    }
}
