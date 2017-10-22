import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Input {

    static String s = "public class StayWithUs { \n\n\tPlayer p; \n\n\tpublic static void run(String useless) { \n\t\tsetup();\n\t\taction(p);\n\t}\n\n\t"
             + "public static void setup() {\n\t\t";
    static String end = "\n\t}\n\n\tpublic static void action(Player p) {\n\t}\n}";
    
    public static void main(String[] args) throws FileNotFoundException {
        test();
        s = s + end;
        System.out.println(s);
    }
    
    public static void test() throws FileNotFoundException {
        File inputFile = new File("player.txt");
        Scanner scan = new Scanner(inputFile);
        String line;
        String fline;
        while (scan.hasNext()) {
                line = scan.next();
                fline = s + line + "\n\t\t";
                s = fline; 
        }
    }
}


