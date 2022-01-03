import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class TestAirport {
    private final List<Plane> testPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12500, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 550, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @Test
    public void testGetPassengerPlanes() {
        Airport airport = new Airport(testPlanes);
        List<PassengerPlane> testPassengerPlanes = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196)
        );
        Assert.assertEquals(testPassengerPlanes.hashCode(), airport.getPassengerPlanes().hashCode(), "Passenger planes got incorrectly");
    }

    @Test
    public void testGetMilitaryPlanes() {
        Airport airport = new Airport(testPlanes);
        List<MilitaryPlane> testMilitaryPlanes = Arrays.asList(
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("F-15", 1500, 12500, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(testMilitaryPlanes.toString(), airport.getMilitaryPlanes().toString(), "Military planes got incorrectly");
    }

    @Test
    public void testGetExperimentalPlanes() {
        Airport airport = new Airport(testPlanes);
        List<ExperimentalPlane> testExperimentalPlanes = Arrays.asList(
                new ExperimentalPlane("Bell X-14", 277, 482, 550, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
        );
        Assert.assertEquals(testExperimentalPlanes.toString(), airport.getExperimentalPlanes().toString(), "Experimental planes got incorrectly");
    }

    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        Airport airport = new Airport(testPlanes);
        PassengerPlane passengerPlaneWithMaxPassengerCapacity = new PassengerPlane("Airbus A330", 990, 14800, 80500, 222);
        Assert.assertEquals(passengerPlaneWithMaxPassengerCapacity.toString(), airport.getPassengerPlaneWithMaxPassengersCapacity().toString(), "Passenger plane with maximal passenger capacity got incorrectly");
    }

    @Test
    public void testGetMilitaryPlanesByType() {
        Airport airport = new Airport(testPlanes);
        List<MilitaryPlane> transportMilitaryPlanes = Arrays.asList(
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(transportMilitaryPlanes.toString(), airport.getMilitaryPlanesByType(MilitaryType.TRANSPORT).toString(), "Transport military planes got incorrectly");
    }

    @Test
    public void testSortByMaxFlightDistance() {
        Airport airport = new Airport(testPlanes);
        List<Plane> sortedByMaxFlightDistancePlanes = Arrays.asList(
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET),
                new ExperimentalPlane("Bell X-14", 277, 482, 550, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new MilitaryPlane("F-15", 1500, 12500, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
                new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER)
        );
        Airport airportSorted = new Airport(sortedByMaxFlightDistancePlanes);

        Assert.assertEquals(airportSorted.toString(), airport.sortByMaxFlightDistance().toString(), "Planes sorted by maximal flight distance incorrectly");
    }


//    @Test
//    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
//        Airport airport = new Airport(testPlanes);
//        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
//        boolean hasUnclassifiedPlanes = false;
//        for (ExperimentalPlane experimentalPlane : ExperimentalPlanes) {
//            if (experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED) {
//                hasUnclassifiedPlanes = true;
//                break;
//            }
//        }
//        Assert.assertFalse(hasUnclassifiedPlanes);
//    }
}
