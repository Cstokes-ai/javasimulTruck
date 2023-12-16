import java.util.ArrayList;

public class Truck implements ITruck{
double ID;
double fuel;
Terminal initialTerminal;
    ArrayList<Container> getinitialContainers;// this will return all the current containers within the truck
    double fuelConsumptionPerKMS;


public Truck(double ID, Terminal p, int totalloadCapacity,double fuelConsumptionPerKMS){
    this.ID=ID;
    this.fuel=totalloadCapacity;
    this.initialTerminal=p;
    p.Truckin(this);
    this.getinitialContainers=new ArrayList<>();



}


    @Override
    public boolean goTo(Terminal p) {
        double distanceToTravel = initialTerminal.getDistance(p);
        double fuelRequired = distanceToTravel * fuelConsumptionPerKMS;
        double maxGasDollarAmount = 100.0;

        double costPerUnitFuel = 2.3;
        double costOfFuel = fuelRequired * costPerUnitFuel;

        if (costOfFuel > maxGasDollarAmount) {
            System.out.println("Cost of fuel exceeds the maximum allowed amount. Truck cannot make it to Terminal 2.");
            return false;
        }

        if (fuel >= fuelRequired) {
            fuel -= fuelRequired;
            initialTerminal.Truckout(this);
            this.initialTerminal = p;
            p.Truckin(this);
            return true;
        } else {
            System.out.println("Insufficient fuel to reach the destination terminal");
            return false;
        }
    }

    @Override
    public void reFuel(double newFuel) {
        fuel += newFuel;

        System.out.println("Truck refueled with " + newFuel + " units.");
    }
    @Override
    public boolean loadUp(Container load) {
    if(load != null && load.weight > 0 && load.ID !=0){
        System.out.println("The trucks are now loaded");
        getinitialContainers.add(load);
       return true;
    }
    else {
        System.out.println("Make sure the trucks are loaded.");
        return false;
    }
    }

    @Override
    public boolean loadDown(Container load) {
        if (load != null && getinitialContainers.contains(load)) {
            getinitialContainers.remove(load);
            System.out.println("Container unloaded successfully.");
            return true;
        } else {
            System.out.println("Container not found or already unloaded.");
            return false;
        }
    }
    public void printLoadedContainers() {
        System.out.println("Loaded containers in Truck " + ID + ":");
        for (Container container : getinitialContainers) {
            System.out.println("Container ID: " + container.getID());

        }
    }

    public double getFuel() {
        return fuel;
    }



    public ArrayList<Container> getinitialContainers() {
    System.out.println(getinitialContainers);
    return getinitialContainers;

    }
    public String toString() {
        return "Truck ID: " + ID + ", Fuel: " + fuel + ", Loaded Containers: " + getinitialContainers.size();
    }
}
