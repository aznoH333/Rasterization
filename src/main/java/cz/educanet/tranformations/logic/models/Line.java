package cz.educanet.tranformations.logic.models;

public class Line {


    private double multiplier;
    private double addition;
    private boolean direction = false;
    private boolean infinityWorkAround = false;

    public Line(Coordinate cord1, Coordinate cord2) {


        if ((cord2.getX() - cord1.getX()) == 0) {
            infinityWorkAround = true;
            addition = cord1.getX();
        } else {
            multiplier = (double) (cord2.getY() - cord1.getY()) / (double) (cord2.getX() - cord1.getX());
            addition = cord1.getY() - (multiplier * cord1.getX());
        }



    }

    public double getMultiplier() {
        return multiplier;
    }

    public double getAddition() {
        return addition;
    }

    public boolean isInside(Coordinate coordinate) {
        if(!infinityWorkAround){
            //normal operation
            if (direction) {
                return coordinate.getY() >= multiplier * coordinate.getX() + addition;
            } else {
                return coordinate.getY() <= multiplier * coordinate.getX() + addition;
            }
        }else {
            //working with infinity
            if (direction) {
                return coordinate.getX() >= addition;
            } else {
                return coordinate.getX() <= addition;
            }

        }

    }

    public void setDirection(boolean value) {
        direction = value;
    }

}
