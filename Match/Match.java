import java.io.*;
import java.util.*;
import java.util.List;
import java.util.LinkedList;

public class Match {
    public static void main(String[] args) throws IOException {

        File file = new File("./Triangle.java");
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(0);
        }

        LinkedList<String> braces = new LinkedList<>();

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                String chr = String.valueOf(line.charAt(i));
                if (chr.equals("(") || chr.equals("{") || chr.equals("[")) {
                    braces.addLast(chr);
                } else if (chr.equals(")") || chr.equals("}") || chr.equals("]")) {
                    checkBraces(braces, chr);
                }
            }
        }
        System.out.println("The code " +
                ((braces.size() == 0) ? "has" : "does not have") + " matching braces");
    }

    private static void checkBraces(LinkedList<String> linkedList, String chr) {

        if ((linkedList.peekLast().equals("(") && chr.equals(")")) ||
                (linkedList.peekLast().equals("[") && chr.equals("]")) ||
                (linkedList.peekLast().equals("{") && chr.equals("}"))) {
            linkedList.removeLast();
        } else if ((!linkedList.peekLast().equals("(") && chr.equals(")")) ||
                (!linkedList.peekLast().equals("[") && chr.equals("]")) ||
                (!linkedList.peekLast().equals("{") && chr.equals("}"))) {
            System.out.println("Java source code has mis-matching brace pairs.");
            System.exit(0);
        }
    }
}
