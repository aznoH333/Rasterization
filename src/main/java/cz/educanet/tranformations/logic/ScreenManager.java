package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;
import cz.educanet.tranformations.logic.models.Line;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) {

        if (selectedPoints.size() >= 3) {
            Object[] bruhMoment = selectedPoints.toArray();
            ;

            Line line1 = new Line((Coordinate) bruhMoment[0], (Coordinate) bruhMoment[1]);
            Line line2 = new Line((Coordinate) bruhMoment[1], (Coordinate) bruhMoment[2]);
            Line line3 = new Line((Coordinate) bruhMoment[2], (Coordinate) bruhMoment[0]);

            //decide direction
            line1.setDirection(!line1.isInside((Coordinate) bruhMoment[2]));
            line2.setDirection(!line2.isInside((Coordinate) bruhMoment[0]));
            line3.setDirection(!line3.isInside((Coordinate) bruhMoment[1]));

            if (line1.isInside(coordinate) && line2.isInside(coordinate) && line3.isInside(coordinate)) {
                return true;
            }
        }
        return false;
    }
}
