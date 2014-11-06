package graph;

/**
 * Created by pigneq on 21/10/14.
 */

public class Vertex {
    private int id;
    private double x;
    private double y;

    public Vertex(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setX(double x) throws BoundaryException {
        if(x >= 0 && x <= 1) {
            this.x = x;
        } else {
            throw new BoundaryException();
        }
    }

    public void setY(double y) throws BoundaryException {
        if(y >= 0 && y <= 1) {
            this.y = y;
        } else {
            throw new BoundaryException();
        }
    }
}
