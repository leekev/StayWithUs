import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameMain {
    
    static String s = "public class StayWithUs { \n\n\tstatic Player p; \n\n\tpublic static void run(String useless) { \n\t\tsetup();\n\t\taction(p);\n\t}\n\n\t"
            + "public static void setup() {\n\t\t";
    static String end = "\n\t}\n\n\tpublic static void action(Player p) {\n";
    
    static String realEnd = "\t}\n}";
    
    static CodeRunner runner;
    
    static Map<String, String> setupCommands;
    
    public static void main(String[] args) {
        runner = new CodeRunner();
        setupCommands = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        initialPreparation("player1");
        initialPreparation("player2");
        
        setupCommands.put("create", "p = new Player(\"hey\");");
        
        System.out.println("Type some bullshit");
        setup("player1", setupCommands.get(input.next()));
        
        String playerCode = s + readPlayerInputText("player1");
        
        playerCode += end;
        
        System.out.println("Write some lines");
        playerCode += writeLines(5);
        playerCode += realEnd;
        runner.runCode(playerCode);
    }
    
    public static boolean setup(String player, String line) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(player + ".txt")));
            writer.flush();
            writer.write(line);
            writer.newLine();
            writer.close();
            return true;
        } catch (IOException e) {
            System.err.println("Game files incomplete");
            return false;
        }
    }
    
    public static String writeLines(int maxLines) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < maxLines) {
            String nextLine = input.nextLine();
            result.append(nextLine);
            i++;
        }
        return result.toString();
    }
    
    public static String readPlayerInputText(String fileName) {
        File inputFile = new File(fileName + ".txt");
        Scanner scan;
        String result = "";
        try {
            scan = new Scanner(inputFile);
        } catch (IOException e) {
            System.err.println("Game files incomplete");
            return result;
        }
        String line;
        String fline;
        while (scan.hasNext()) {
                line = scan.next();
                fline = result + line + "\n\t\t";
                result = fline; 
        }
        
        return result;
    }
    
    public static boolean initialPreparation(String player) {
        return false;
    }
}
