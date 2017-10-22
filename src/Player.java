
public class Player extends Inspectable {

    public Encryption next;
    
    public Player(Encryption encryption) {
        next = encryption;
    }
    
    @Override
    public void inspect() {
        super.inspect("src/Player.java");
    }
}
