
public class Pair<T1, T2> {

    public final T1 key;
    public final T2 value;
    
    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }
    
    @Override
    public String toString() {
        return key.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair<?, ?>)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return this.key.equals(p.key);
    }
    
    @Override
    public int hashCode() {
        return key.hashCode();
    }
}
