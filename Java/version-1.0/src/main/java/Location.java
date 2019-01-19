public class Location {
    private int x = 0;
    private int y = 0;

    public Location() {

    }

    public Location(final Location other) {
        clone(other);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
   
    public void setY(int y) {
        this.y = y;
    }

    public void clone(final Location other) {
        this.x = other.x;
        this.y = other.y;
    }

    @Override
    public boolean equals(Object obj) {
        Location other = (Location) obj;
        return other.x == this.x && other.y == this.y;
    }
}