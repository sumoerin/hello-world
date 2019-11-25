import java.util.Scanner;

public class Karatsuba {

    public static long multiply(long x, long y) {
        // If either x or y is a single digit, simply multiply.
        if(x<10 || x<10)
            return x*y;

        // Find the length of the longest number by taking the log of each number
        // and finding the max between the two, and converting the value to an int
        // (therefore taking the floor of the double) and adding 1.
        int maxLength = (int) Math.max(Math.log10(x), Math.log10(y)) + 1;
        System.out.println("Max length: " + maxLength);

        // Take half of the maxLength found.
        int halfMaxLength = (int) Math.round(maxLength/2);

        // Calculate a, b, c, d.
        long a = x / (int) Math.pow(10, halfMaxLength); //
        long b = x % (int) Math.pow(10, halfMaxLength);
        long c = y / (int) Math.pow(10, halfMaxLength);
        long d = y % (int) Math.pow(10, halfMaxLength);
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);

        System.out.println("----\nCalculate ac = " + a + "*" + c);
        System.out.println("Calculate bd = " + b + "*" + d + "\n----");

        long ac = multiply(a, c);
        System.out.println("ac = " + ac);
        System.out.println("----");
        long bd = multiply(b, d);
        System.out.println("bd = " + bd);
        System.out.println("----");

        System.out.println("(a+b) = " + a + "+" + b + " = " + (a+b));
        System.out.println("(c+d) = " + c + "+" + d + " = " + (c+d));
        System.out.println("----\nCalculate (a+b)(c+d) = " + (a+b) + "*" + (c+d) + "\n----");

        long abcd = multiply((a+b), (c+d));
        System.out.println("(a+b)(c+d)\t= " + (a+b) + "*" + (c+d) + " = " + abcd);

        long bcad = abcd - (ac + bd);
        System.out.println("(bc+ad)\t\t= (a+b)(c+d)-(ac+bd) = " + abcd + "-(" + ac + "+" + bd + ") = " + bcad);

        long product = (long)
                (bd +
                (ac * Math.pow(10, (2 * halfMaxLength))) +
                (bcad * Math.pow(10, halfMaxLength)));

        System.out.println("\nProduct: bd + ac*z^2 + (bc+ad)z = " +
                bd + " + " + ac + "*" + (long)Math.pow(10, (2 * halfMaxLength)) + " + " +
                bcad + "*" + (long)Math.pow(10, halfMaxLength) + " = " + product);
        System.out.println("----");

        return product;
    }

    public static void main(String args[])
    {
        Scanner kb = new Scanner(System.in);

        System.out.print("Multiplier: ");
        long x = kb.nextLong();
        System.out.print("Multiplicand: ");
        long y = kb.nextLong();

        System.out.println();

        System.out.println("\nProduct: " + multiply(x,y));
    }
}
