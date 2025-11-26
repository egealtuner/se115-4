//scenario 0
public class Circle {
    private point center;
    private float radius;
    public Circle(point c, float r) {
        center = c;
        radius = r;
    }
    public void setCenter(point c) { center = c; }
    public void setRadius(float r) { radius = r; }
    public point getCenter() { return center; }
    public float getRadius() { return radius; }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
