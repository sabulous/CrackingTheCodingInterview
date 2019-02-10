/*
    Muhammed Sabri Sahin
    07-Jan-19
    FreeTraining
*/
package Chapter_1.FreeTraining;

public class StringBuilderTraining {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder("sab");
        sb.append("ri");
        System.out.println(sb);
        sb.setLength(10);
        System.out.println(sb + "%");
    }
}
