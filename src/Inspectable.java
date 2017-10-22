import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Inspectable {
    
    private int lines = 2;
    
    
    public void inspect(String source) {
        Scanner self;
        try {
            self = new Scanner(new File(source));
        } catch (IOException e) {
            System.err.println("Game files incomplete");
            System.exit(1);
            return;
        }
        
        int i = 0;
        while (i < lines && self.hasNextLine()) {
            System.out.println(self.nextLine());
            i++;
        }
    }
    
    public void researchInspect() {
        lines *= 2;
    }
    
    public void inspect() {
        return;
    }
}
