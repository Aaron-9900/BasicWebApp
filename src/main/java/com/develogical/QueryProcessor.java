package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.toLowerCase().contains("imperial")) {
            return "Imperial College is a university in London";
        }

        if (query.toLowerCase().contains("your name")) {
            return "MyTeam";
        }
        if(query.toLowerCase().contains("britain")) {
            return "2016";
        }
        if(query.toLowerCase().contains("minus")) {
            int idx = query.indexOf("minus");
            int founds = 1;
            int num1 = 0;
            int num2 = 0;
            for(int i = idx - 2; i > 0; i--) {
                try {
                    int val = Integer.parseInt("" + query.charAt(i));
                    num1 += val * founds;
                    founds *= 10;
                } catch(NumberFormatException nfe) {
                    break;
                }
            }
            for(int i = idx + 6; i < query.length(); i++) {
                try {
                    System.out.println("TESTTTTTT: " +  query.charAt(i));
                    int val = Integer.parseInt("" + query.charAt(i));
                    num2 += val * founds;
                    founds *= 10;
                } catch(NumberFormatException nfe) {
                    break;
                }
            }
            System.out.println("num1:" + num1 + "num2" + num2);
            return "" + (num1 - num2);
        }
        return "";
    }
}
