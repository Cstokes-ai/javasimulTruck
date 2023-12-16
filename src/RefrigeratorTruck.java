public class RefrigeratorTruck extends Heavy{
    int ID=3;
    double weightperUnit;
    double RefrigeratorTruck=5.00;
    double fuelConsumption= RefrigeratorTruck/weightperUnit;


    RefrigeratorTruck(int ID, double weight) {
        super(ID, weight);
    }
}
