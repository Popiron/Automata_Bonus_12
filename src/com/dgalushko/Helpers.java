package com.dgalushko;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Helpers {
    public static String openFileAndReadData(String path)
    {
        String result = "";
        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            String data = myReader.nextLine();
            result = data;
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }

    //S->S+T|S-T|T T->T*E|T/E|E E->(s)|a|b

    public static void processData(String string) {
        var str = string.replaceAll("->","").replaceAll("\\|", "").replaceAll("\\e","").replaceAll(" ", "");
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (c >= 'A' && c<='Z') {
                if (!Grammar.norTerminals.contains(Character.toString(c)))
                    Grammar.norTerminals.add(Character.toString(c));
            }
            else {
                if (!Grammar.signature.contains(Character.toString(c)))
                    Grammar.signature.add(Character.toString(c));
            }
        }

        var l1 = string.split(" ");
//        Grammar.grammarSign = l1[0].replace("=","");
////        l1 = l1[1].split("},");
//        Collections.addAll(Grammar.norTerminals, l1[0].replace("{","").split(","));
//        Collections.addAll(Grammar.signature,l1[1].replace("{","").split(","));
//        Grammar.startingSign = l1[3].replace(")","");
//        l1 = l1[2].replace("{","").split(",");
        for (String s : l1) {
            var l2 = s.split("->");
            String sign = l2[0];
            ArrayList<String> stringArrayList = new ArrayList<>();
            Collections.addAll(stringArrayList,l2[1].split("\\|"));
            Grammar.production.put(sign,stringArrayList);
        }
    }

    public static HashMap<String, ArrayList<String>> copy(
            HashMap<String, ArrayList<String>> original)
    {
        HashMap<String, ArrayList<String>> copy = new HashMap<String, ArrayList<String>>();
        for (Map.Entry<String, ArrayList<String>> entry : original.entrySet())
        {
            copy.put(entry.getKey(),
                    // Or whatever List implementation you'd like here.
                    new ArrayList<String>(entry.getValue()));
        }
        return copy;
    }

}
