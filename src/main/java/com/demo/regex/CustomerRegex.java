package com.demo.regex;

public enum CustomerRegex {
    NAME("[a-z|0-9]+"),
    EMAIl("[a-z|0-9]+");

    public final String label;

    CustomerRegex(String label) {
        this.label = label;
    }

   public static String NAME(){
        return NAME.label;
   }
    public static String EMAIL(){
        return EMAIl.label;
    }
}
