import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class GameMain {
    
    static String s = "public class StayWithUs { \n\n\tstatic Player p; \n\n\t static WinCondition win; \n\n\tpublic static void run(String useless) { \n\t\tsetup();\n\t\taction(p);\n\t\t checkWin(); \n\t}\n\n\t"
            + "public static void setup() {\n\t\t";
    static String middle = "\n\t}\n\n\tpublic static void action(Player p) {\n";
    
    static String end = "\t\n}\n\t public static void checkWin() {\n\t\t System.out.println(win.result());\n\t }\n}";
    
    static CodeRunner runner;
    static Map<String, String> setupCommands;
    
    static Set<Pair<String, Integer>> MEDIEVAL;
    
    public static void main(String[] args) {
        runner = new CodeRunner();
        setupCommands = new HashMap<String, String>();
        Scanner input = new Scanner(System.in);
        initialPreparation("player1", input);
        // initialPreparation("player2", input);
        
        String playerCode = s + readPlayerInputText("player1");
        
        playerCode += middle;
        
        System.out.println("Write some lines");
        playerCode += writeLines(5);
        playerCode += end;
        runner.runCode(playerCode);
    }
    
    public static void writeToFile(BufferedWriter writer, String line) {
            try {
                writer.write(line);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Error writing to file");
                System.exit(1);
            }
    }
    
    public static String writeLines(int maxLines) {
        Scanner input = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int i = 0;
        int indents = 0;
        while (i < maxLines) {
            for (int j = 0; j < indents; j++) {
                System.out.print("\t");
            }
            String nextLine = input.nextLine();
            result.append(nextLine);
            
            if (nextLine.endsWith("{")) {
                indents++;
            }
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
    
    public static boolean initialPreparation(String player, Scanner input) {
        
        String playerClass = classSelection(input);
        
        List<String> selecterinos;
        
        if (playerClass.equals("MEDIEVAL")) {
            selecterinos = selections(input, MEDIEVAL);
            
        } else if (playerClass.equals("Debug")) {
            selecterinos = new ArrayList<String>();
            for (int i = 0; i < 0; i++) {
                selecterinos.add("Debug");
            }
        } else {
            selecterinos = new ArrayList<String>();
        }
        
        updatePlayerTextFile(player, selecterinos);
        
        return true;
    }
    
    public static void updatePlayerTextFile(String player, List<String> selections) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(new File(player + ".txt")));
        } catch (IOException e) {
            System.err.println("Unable to create player text file");
            System.exit(1);
            return;
        }
        
        writeToFile(writer, "WinCondition winner = new WinCondition();");
        writeToFile(writer, "win = winner;");
        writeToFile(writer, "Encryption var0 = winner;");
        
        int i = 1;
        while (i <= selections.size()) {
            
            StringBuilder build = new StringBuilder();
            build.append("Encryption var");
            build.append(i);
            build.append(" = new ");
            build.append(selections.get(i - 1));
            build.append("(var");
            build.append(i - 1);
            build.append(");");
            
            writeToFile(writer, build.toString());
            i++;
        }
        
        writeToFile(writer, "p = new Player(var" + (i - 1) + ");");
        
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Writer unable to close");
            System.exit(1);
            return;
        }
    }
    
    public static String classSelection(Scanner input) {
        System.out.println("Choose your class: ");
        System.out.println("PUT CLASSES HERE");
        return input.nextLine();
    }
    
    public static String addSetupLine(String script, String lock) {
        String[] segment = script.split("%i%");
        
        if (segment.length > 2) {
            throw new IllegalArgumentException("Script must have only one %i% identifier");
        } else if (segment.length == 2 && lock != null) {
            return segment[0] + lock + segment[1];
        } else {
            return script;
        }
    }
    
    public static String promptForEncryption(Scanner input, Set<Pair<String, Integer>> availableEncryptions, int costRemaining) {
        Set<Pair<String, Integer>> validEncryptions = new TreeSet<Pair<String, Integer>>();
        for (Pair<String, Integer> encryption : availableEncryptions) {
            if (encryption.value <= costRemaining) {
                validEncryptions.add(encryption);
            }
        }
        
        String choice = "";
        
        while (!validEncryptions.contains(choice)) {
            System.out.println("Select Encryption: ");
            
            for (Pair<String, Integer> encryption : validEncryptions) {
                System.out.println(encryption.key);
            }
            
            // choice = input.nextLine().toUpperCase(); 
        }
        
        return choice;
    }
    
    public static List<String> selections(Scanner input, Set<Pair<String, Integer>> encryptions) {
        int encryptionCost = 30;
        List<String> selectedEncryptions = new ArrayList<String>();
        
        while (encryptionChoosable(encryptions, encryptionCost)) {
            String encryption = promptForEncryption(input, encryptions, encryptionCost);
            
            encryptionCost = updateEncryption(encryptions, encryption, encryptionCost);
            selectedEncryptions.add(encryption);
        }
        
        return selectedEncryptions;
    }
    
    public static boolean encryptionChoosable(Set<Pair<String, Integer>> encryptions, int costRemaining) {
        for (Pair<String, Integer> encryption : encryptions) {
            if (encryption.value < costRemaining) {
                return true;
            }
        }
        return false;
    }
    
    public static int updateEncryption(Set<Pair<String, Integer>> encryptions, String encryptionInput, int costRemaining) {
        for (Pair<String, Integer> encryption : encryptions) {
            if (encryption.equals(encryptionInput)) {
                return costRemaining - encryption.value;
            }
        }
        return costRemaining;
    }
}
