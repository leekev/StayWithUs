
public class Castle extends Encryption{
    
    Royalty currentRuler;

    public class Royalty {
        
        String position;
        Royalty previousInheritance;
        Royalty nextInheritance;
        String password; 
        
        public Royalty (String position, Royalty previousInheritance, Royalty nextInheritance, String password) {
            this.position = position;
            this.previousInheritance = previousInheritance;
            this.nextInheritance = nextInheritance;
            this.password = password;
        }
    }
    
    public boolean password(String password) {
        return password.equals(currentRuler.password);
    }
    
    public void createKing() {
        currentRuler = new Royalty("King", null, null, "Password");
    }
    
    public void newMembers() {
        currentRuler.nextInheritance = new Royalty("Queen", currentRuler, null, "Is this the password");
        currentRuler.nextInheritance.nextInheritance = new Royalty("Prince", currentRuler.nextInheritance, null, "Come on now");
        currentRuler.nextInheritance.nextInheritance.nextInheritance = new Royalty("Princess", currentRuler.nextInheritance.nextInheritance, null, "Bride");
        currentRuler.nextInheritance.nextInheritance.nextInheritance.nextInheritance = new Royalty("Royal Dog", currentRuler.nextInheritance.nextInheritance.nextInheritance, null, "Pupper");
        currentRuler.nextInheritance.nextInheritance.nextInheritance.nextInheritance.nextInheritance = new Royalty("Jester", currentRuler.nextInheritance.nextInheritance.nextInheritance.nextInheritance, null, "Jack");        
    }
    
    public void killRuler() {
        currentRuler = currentRuler.nextInheritance;       
    }
    
    
    
}
