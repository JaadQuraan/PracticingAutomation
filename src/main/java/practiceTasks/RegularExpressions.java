package practiceTasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    public static void main(String[] args) {
        Pattern patternex = Pattern.compile("^[a|A]gent (\\d{3,4})$"); // syntax for a digit
        Matcher matcherex = patternex.matcher("agent 007");
 //12

        String cardNumber = "1234-2222-3333-4343";
        // "XXXX-XXXX-XXXX-4343"
        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-");
        Matcher matcher = pattern.matcher(cardNumber);

        String maskedCardNumber = matcher.replaceAll("XXXX-XXXX-XXXX-");
       // System.out.println(maskedCardNumber);

        Pattern pattern1 = Pattern.compile("^(\\d+) divided by (\\d+)$");
        Matcher matcher1 = pattern1.matcher("10 divided by 2");

        if(matcher1.find()){
            String simplified = "result = " + matcher1.replaceFirst("$1/$2");
            System.out.println(simplified);
            int result = Integer.valueOf(matcher1.group(1)) / Integer.valueOf(matcher1.group(2));
            System.out.println("result = " + result);
        }

//        if(matcher.find()){
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(1));
//        }



        //  Pattern pattern2 = Pattern.compile("^agent \\d{3,4}$"); // syntax for a beginning and end
        //Matcher matcher2 = pattern2.matcher("agent 0057");
        //boolean found2 = matcher2.find();
        //  System.out.println("found2: " + found2);

        //   ^agent [0-9]{3,4}$
        //   .   any single character
        // ^(a|A|aa)gent [0-8]{3,4}$   works like or
        // * zero or more occurences


    }
}
