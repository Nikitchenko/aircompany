package planes;

import java.util.Objects;

public abstract class Plane {
    private final int maxSpeed;
    private final int maxFlightDistance;
    private final int maxLoadCapacity;
    private final String model;

    protected Plane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getMaxFlightDistance() {
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {
        return maxLoadCapacity;
    }

    @Override
    public String toString() {
        return String.format("Plane{model=%s, maxSpeed=%s, maxFlightDistance=%s, maxLoadCapacity=%s}",
                model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Plane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
