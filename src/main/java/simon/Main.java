package simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        Highway hw = new Highway();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String commandLine;
        do {
            commandLine = br.readLine();
            String[] cmdWords = commandLine.split(" ");

            switch (cmdWords[0].toUpperCase()) {
                case "ENTER":
                    if (cmdWords.length >= 3) {
                        switch (cmdWords[2].toUpperCase()) {
                            case "TRUCK" -> hw.vehicleEntry(cmdWords[1], CarType.TRUCK);
                            case "CAR" -> hw.vehicleEntry(cmdWords[1], CarType.CAR);
                            case "MOTORCYCLE" -> hw.vehicleEntry(cmdWords[1], CarType.MOTORCYCLE);
                            default -> System.out.println("Not a valid vehicle type.");
                        }
                    } else {
                        System.out.println("Missing arguments.");
                    }
                    break;
                case "EXIT":
                    if (cmdWords.length >= 2) {
                        hw.vehicleLeave(cmdWords[1]);
                    } else {
                        System.out.println("Missing arguments.");
                    }
                    break;
                case "CHECK":
                    if (cmdWords.length >= 2) {
                        hw.searchVehicle(cmdWords[1]);
                    } else {
                        System.out.println("Missing arguments.");
                    }
                    break;
                case "TERMINATE":
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Not a valid command.");
                    break;
            }
        } while (!Objects.equals(commandLine.toUpperCase(), "TERMINATE"));
    }
}
