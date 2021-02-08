package cz.educanet.tranformations.logic.models;

public class Line {


    private double multiplier;
    private double addition;
    private boolean direction = false;

    public Line(Coordinate cord1, Coordinate cord2) {


        if ((cord2.getX() - cord1.getX()) == 0) {
            multiplier = 0; //temporary fix
        } else {
            multiplier = (double) (cord2.getY() - cord1.getY()) / (double) (cord2.getX() - cord1.getX());
        }

        addition = cord1.getY() - (multiplier * cord1.getX());

    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getAddition() {
        return addition;
    }

    public boolean isInside(Coordinate coordinate) {
        if (direction) {
            return coordinate.getY() >= multiplier * coordinate.getX() + addition;
        } else {
            return coordinate.getY() <= multiplier * coordinate.getX() + addition;
        }

    }

    public void setDirection(boolean value) {
        direction = value;
    }

}
