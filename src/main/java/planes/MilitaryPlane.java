package planes;

import models.MilitaryType;

import java.util.Objects;

public class MilitaryPlane extends Plane {

    private final MilitaryType militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                         MilitaryType militaryType) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    public MilitaryType getType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                String.format(", militaryType=%s}", militaryType));
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof MilitaryPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
