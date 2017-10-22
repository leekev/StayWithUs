import java.util.*;

public class BestBand extends Encryption {

    Map<String, Boolean> bands;
    
    public BestBand() {
        bands = new HashMap<String, Boolean>();
        bands.put("Beatles", false);
        bands.put("Aerosmith", false);
        bands.put("Nirvana", false);
        bands.put("BROCKHAMPTON", false);
        bands.put("Green Day", false);
        bands.put("Seoul", false);
        bands.put("Radiohead", false);
        bands.put("Sum 41", false);
        bands.put("Queen", false);
        bands.put("Led Zeppelin", false);
        bands.put("Rolling Stones", false);
        bands.put("Black Sabbath", false);
        bands.put("Pearl Jam", false);
        bands.put("Metallica", false);
        bands.put("AC/DC", false);
        bands.put("Slayer", false);
        bands.put("Weezer", false);
        bands.put("Linkin Park", false);
        bands.put("Cameo", false);
        bands.put("Kanye West", false);
    }
    
    public boolean answer(String answer) {
        return bands.get(answer);
    }
}
