package planes;

import models.ClassificationLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private final ExperimentalType experimentalType;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalType experimentalType,
                             ClassificationLevel classificationLevel) {

        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                String.format(", experimentalType=%s, classificationLevel=%s}", experimentalType, classificationLevel));
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ExperimentalPlane;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }
}
