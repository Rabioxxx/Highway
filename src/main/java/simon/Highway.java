package simon;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Highway {
    private final double costPerSecond = 0.05; // in $
    private final double truckMultiplier = 2.0;
    private final ArrayList<VehicleInfo> vehicles = new ArrayList<>();

    public void vehicleEntry(String numberPlates, CarType type) {
        vehicles.add(new VehicleInfo(numberPlates, type, LocalDateTime.now()));
        System.out.println("Added vehicle " + numberPlates + " to a highway.");
    }

    public void searchVehicle(String numberPlates) {
        numberPlates = numberPlates.toUpperCase();
        for (VehicleInfo vehicle : vehicles) {
            if (vehicle.getNumberPlates().equals(numberPlates)) {
                System.out.println(vehicle.getNumberPlates() + " -> vehicle type: " + vehicle.getCarType() + "\nEntry time: " + vehicle.getEntryTime());
                return;
            }
        }
        System.out.println("Vehicle " + numberPlates + " is not on the highway.");
    }

    public void vehicleLeave(String numberPlates) {
        for (VehicleInfo vehicle : vehicles) {
            if (vehicle.getNumberPlates().equals(numberPlates)) {
                Duration duration = Duration.between(vehicle.getEntryTime(), LocalDateTime.now());
                double totalCost = costPerSecond * duration.getSeconds();

                if (vehicle.getCarType().equals(CarType.TRUCK)) {
                    totalCost *= truckMultiplier;
                }

                vehicles.remove(vehicle);

                System.out.println("Vehicle " + vehicle.getNumberPlates() + " left highway.\n" +
                        "Paid: $" + Math.round(totalCost));
                return;
            }
        }
    }
}