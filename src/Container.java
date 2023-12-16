abstract class Container {
int ID;
double weight;
double consumption;



Container(int ID, double weight){
    this.ID=ID;
    this.weight=weight;
}

    public boolean equals(Container other) {
    // be sure to check the type of container, ID, and weight of the containers to see if they match;
        // Check if the object is of type Container
        if (this == other) {
            return true; // Same object reference
        }
        if (other == null || getClass() != other.getClass()) {
            return false; // Not the same class or null
        }
        // Check type, ID, and weight
        return this.ID == other.ID && Double.compare(this.weight, other.weight) == 0;
    }
    public double getID() {
        return ID;
    }
    public String getDetails(){
        return "Truck ID: " + ID;
    }
    public String toString() {
        return "Container ID: " + ID + ", Weight: " + weight;
    }
    abstract void HeavyCheck();
abstract void BasicCheck();
    public double BasicFuelConsumption() {
        return 2.50*weight;
    }
    public double HeavyFuelConsumption() {
        return 3.00*weight;

    }

    public double RefrigeratorTruckFuelConsumption() {
        return 5.00*weight;

    }
    public double TankerFuelConsumption() {
        return 4.00*weight;


    }
}




