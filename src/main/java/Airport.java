import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private final List<? extends Plane> planes;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) plane);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> experimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                experimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return experimentalPlanes;
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPassengerPlanes();
        PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
                planeWithMaxCapacity = passengerPlane;
            }
        }
        return planeWithMaxCapacity;
    }

    public List<MilitaryPlane> getMilitaryPlanesByType(MilitaryType militaryType) {
        List<MilitaryPlane> militaryPlanesSpecificType = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == militaryType) {
                militaryPlanesSpecificType.add(plane);
            }
        }
        return militaryPlanesSpecificType;
    }

    public List<ExperimentalPlane> getExperimentalPlanesByClassificationLevel(ClassificationLevel classificationLevel) {
        List<ExperimentalPlane> experimentalPlanesSpecificClassificationLevel = new ArrayList<>();
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        for (ExperimentalPlane plane : experimentalPlanes) {
            if (plane.getClassificationLevel() == classificationLevel) {
                experimentalPlanesSpecificClassificationLevel.add(plane);
            }
        }
        return experimentalPlanesSpecificClassificationLevel;
    }

    public List<ExperimentalPlane> getExperimentalPlanesByType(ExperimentalType experimentalType) {
        List<ExperimentalPlane> experimentalPlanesSpecificExperimentalType = new ArrayList<>();
        List<ExperimentalPlane> experimentalPlanes = getExperimentalPlanes();
        for (ExperimentalPlane plane : experimentalPlanes) {
            if (plane.getExperimentalType() == experimentalType) {
                experimentalPlanesSpecificExperimentalType.add(plane);
            }
        }
        return experimentalPlanesSpecificExperimentalType;
    }

    public Airport sortByMaxFlightDistance() {
        planes.sort(Comparator.comparing(Plane::getMaxFlightDistance));
        return this;
    }

    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparing(Plane::getMaxSpeed));
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparing(Plane::getMaxLoadCapacity));
        return this;
    }

    @Override
    public String toString() {
        return "Airport{Planes=" + planes.toString() + '}';
    }

}
