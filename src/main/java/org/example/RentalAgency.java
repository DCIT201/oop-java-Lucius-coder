package org.example;

import java.util.ArrayList;
import java.util.List;

class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public void processRental(String vehicleId, Customer customer, int days) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && vehicle.isAvailableForRental()) {
                if (vehicle instanceof Rentable rentable) {
                    rentable.rent(customer, days);
                    System.out.println("Rental processed: " + vehicle.getModel());
                    return;
                }
            }
        }
        System.out.println("Rental failed: Vehicle not available or invalid ID.");
    }

    public void returnVehicle(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equals(vehicleId) && !vehicle.isAvailable()) {
                if (vehicle instanceof Rentable rentable) {
                    rentable.returnVehicle();
                    System.out.println("Vehicle returned: " + vehicle.getModel());
                    return;
                }
            }
        }
        System.out.println("Return failed: Vehicle not found or already available.");
    }
}

