public class Location {
    private int x = 0;
    private int y = 0;
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

    @Override
    public boolean equals(Object obj) {
        Location other = (Location) obj;
        return other.x == this.x && other.y == this.y;
    }
}