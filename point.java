//scenario 0
public class point {
    private int x;
    private int y;
    public point(int a, int b) {
        x = a;
        y = b;
    }
    public void setX(int a) { x = a; }
    public void setY(int a) { y = a; }
    public int getX() { return x; }
    public int getY() { return y; }
    public double distanceTo(point b) {
        double dx = Math.pow(getX() - b.getX(), 2);
        double dy = Math.pow(getY() - b.getY(), 2);
        return Math.sqrt(dx + dy);
    }
}