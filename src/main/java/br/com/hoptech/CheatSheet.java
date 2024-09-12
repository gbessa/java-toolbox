package br.com.hoptech;

public class CheatSheet {

    // Main Method
    public static void main(String[] args) {
        primitiveDataTypes();
        iterativeStatements();
        decisiveStatements();
        dataTypeConversions();
        stringMethods();
    }

    private static void primitiveDataTypes() {
        byte fooByte = 127; // 8 bits
        short fooShort = 32767; // 16 bits
        int fooInt = 2147483647; // 32 bits
        long fooLong = 9223372036854775807L; // 64 bits
        float fooFloat = 3.4F; // 16 bits
        double fooDouble = Math.pow(1.7D, 308); // 64 bits

        System.out.println(fooByte);
        System.out.println(fooShort);
        System.out.println(fooInt);
        System.out.println(fooLong);
        System.out.println(fooFloat);
        System.out.println(fooDouble);
    }

    private static void iterativeStatements() {
        // FOR LOOP
        for (int i=0; i<6; i++) System.out.println(i);
        // FOREACH LOOP
        for (int i : new int[] {55, 66, 77}) System.out.println(i);
        // WHILE LOOP
        int i = 3;
        while (i>=0) {
            System.out.println(i);
            i--;
        }
        // DO WHILE LOOP
        int j = 3;
        do {
            System.out.println(j);
            j--;
        } while (j>=0);
    }

    private static void decisiveStatements() {
        if (true) System.out.println("true");

        if (false) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        int z = 2;
        switch (z) {
            case 1:
                System.out.println("One");
                break;
            case 2:
                System.out.println("Two");
                break;
            default:
                System.out.println("default");
                break;
        }
    }

    private static void dataTypeConversions() {
        // Numeric to String
        String str = String.valueOf(10);
        str = String.valueOf(5.5);

        // String to Numeric
        int i = Integer.parseInt("10");
        System.out.println(i);
        double d = Double.parseDouble("10.5");
        System.out.println(d);
    }

    private static void stringMethods() {
        String str1 = "casa";
        String str2 = "casa";

        //Compare Addresses
        System.out.println(str1==str2);

        //Compare the values
        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        // Length
        System.out.println(str1.length());

        // Chart at
        System.out.println(str1.charAt(1));

        // To UpperCase
        System.out.println(str1.toUpperCase());

        // Replace substring
        System.out.println(str1.replace("ca", "mas"));

        // Contains
        System.out.println(str1.contains("as"));

        // Ends with
        System.out.println(str1.endsWith("sa"));
    }
}
