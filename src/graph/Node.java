package graph;

/**
 * Created by pigneq on 21/10/14.
 */

public class Node {
    private double x;
    private double y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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
