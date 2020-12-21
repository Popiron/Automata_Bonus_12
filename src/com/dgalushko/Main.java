package com.dgalushko;

public class Main {

    public static void main(String[] args) {
	Helpers.processData("S->S+T|S-T|T T->T*E|T/E|E E->(s)|a|b");
	Grammar.DeleteCircleRules();
    }
}
