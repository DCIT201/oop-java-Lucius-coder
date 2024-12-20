
package org.example;
class Motorcycle extends Vehicle implements Rentable {
    private boolean hasHelmetIncluded;

    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean hasHelmetIncluded) {
        super(vehicleId, model, baseRentalRate);
        this.hasHelmetIncluded = hasHelmetIncluded;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * (hasHelmetIncluded ? 1.1 : 1.0);
    }

    @Override
    public boolean isAvailableForRental() {
        return isAvailable();
    }

    @Override
    public void rent(Customer customer, int days) {
        if (isAvailableForRental()) {
            setAvailable(false);
            System.out.println("Motorcycle rented to: " + customer.getName());
        } else {
            System.out.println("Motorcycle not available.");
        }
    }

    @Override
    public void returnVehicle() {
        setAvailable(true);
        System.out.println("Motorcycle returned.");
    }
}