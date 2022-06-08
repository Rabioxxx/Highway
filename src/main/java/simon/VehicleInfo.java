package simon;

import java.time.LocalDateTime;

public class VehicleInfo {
    private final String numberPlates;
    private final CarType carType;
    private final LocalDateTime entryTime;

    public VehicleInfo(String numberPlates, CarType carType, LocalDateTime entryTime) {
        this.numberPlates = numberPlates.toUpperCase();
        this.carType = carType;
        this.entryTime = entryTime;
    }

    public String getNumberPlates() {
        return numberPlates;
    }

    public CarType getCarType() {
        return carType;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
