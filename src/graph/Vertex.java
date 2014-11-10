package graph;

/**
 * Created by pigneq on 21/10/14.
 */

public class Vertex {
    private int id;
    private int idC;
    private double x;
    private double y;

    public Vertex(int id, int idC, double x, double y) {
        this.id = id;
        this.idC = idC;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public int getIdC() {
        return idC;
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

    public void setIdC(int idC) {
        this.idC = idC;
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
