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
    private static final List<Plane> testPlanes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
    );


    @Test
    public void testGetPassengerPlanes() {
        Airport airport = new Airport(testPlanes);
        List<PassengerPlane> testPassengerPlanes = Arrays.asList(
                new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
                new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
                new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
                new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
                new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
                new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
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
                new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
                new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(testMilitaryPlanes.hashCode(), airport.getMilitaryPlanes().hashCode(), "Military planes got incorrectly");
    }

    @Test
    public void testGetExperimentalPlanes() {
        Airport airport = new Airport(testPlanes);
        List<ExperimentalPlane> testExperimentalPlanes = Arrays.asList(
                new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGH_ALTITUDE, ClassificationLevel.SECRET),
                new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOP_SECRET)
        );
        Assert.assertEquals(testExperimentalPlanes.hashCode(), airport.getExperimentalPlanes().hashCode(), "Experimental planes got incorrectly");
    }


    @Test
    public void testGetPassengerPlaneWithMaxPassengerCapacity() {
        Airport airport = new Airport(testPlanes);
        PassengerPlane passengerPlaneWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);

        Assert.assertEquals(passengerPlaneWithMaxPassengerCapacity.toString(), airport.getPassengerPlaneWithMaxPassengersCapacity().toString(), "Passenger plane with maximal passenger capacity got incorrectly");
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(testPlanes);
        List<MilitaryPlane> transportMilitaryPlane = Arrays.asList(
                new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT)
        );
        Assert.assertEquals(transportMilitaryPlane.toString(), airport.getTransportMilitaryPlanes().toString(), "Transport planes got incorrectly");
    }

//    @Test
//    public void test3() {
//        Airport airport = new Airport(testPlanes);
//        airport.sortByMaxLoadCapacity();
//        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
//
//        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
//        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
//            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
//            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
//            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
//                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
//                break;
//            }
//        }
//        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
//    }

//    @Test
//    public void testHasAtLeastOneBomberInMilitaryPlanes() {
//        Airport airport = new Airport(testPlanes);
//        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
//        boolean flag = false;
//        for (MilitaryPlane militaryPlane : bomberMilitaryPlanes) {
//            if ((militaryPlane.getType() == MilitaryType.BOMBER)) {
//                flag = true;
//            } else {
//                Assert.fail("Test failed!");
//            }
//        }
//        // if not failed
//    }

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
