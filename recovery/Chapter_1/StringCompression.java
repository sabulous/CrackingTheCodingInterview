/*
    Muhammed Sabri Sahin
    09-Jan-19
    Chapter_1

    Cracking the Coding Interview - Question 1.6
*/
package Chapter_1;

import java.util.Scanner;

public class StringCompression {
    public static void main(String args[]) {
        String input = readInput();
        if(input.length() > 0) {
            StringBuilder sb = new StringBuilder();
            Integer repeatCount = 1;
            for(int i = 0; i < input.length(); i++) {
                if (i == 0 || input.charAt(i-1) != input.charAt(i)) {
                    sb.append(input.charAt(i));
                } else {
                    repeatCount++;
                }

                if(i == input.length()-1 || input.charAt(i+1) != input.charAt(i)) {
                    sb.append(repeatCount);
                    repeatCount = 1;
                }
            }
            sb.append("\n");
            if(sb.length() < input.length()) {
                System.out.print(sb);
            } else {
                System.out.println("String has not been compressed. The original string was " + input);
            }
        }
    }

    private static String readInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
