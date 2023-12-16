import java.util.*;

public class Terminal implements ITerminal {
    double distance;
int ID;
 double X;// terminal 1
    double Y;
    Scanner scanner=new Scanner(System.in);
ArrayList<Container> containers;
ArrayList<Truck> truckHistory;
ArrayList<Truck> initial;

Terminal(int ID, double X, double Y){
    this.ID=ID;
    this.X=X;
    this.Y=Y;

    containers=new ArrayList<>();
    truckHistory=new ArrayList<>();
    initial=new ArrayList<>();




}
    public Truck getTruckById(int truckId) {
        for (Truck truck : initial) {
            if (truck.ID == truckId) {
                return truck;
            }
        }
        return null; // If the truck with the specified ID is not found
    }
public double getDistance(Terminal otherTerminal) {
    double distanceX = otherTerminal.X - this.X;
    double distanceY = otherTerminal.Y - this.Y;
    return Math.sqrt(distanceX * distanceX + distanceY * distanceY);
}



    @Override
    public void Truckin(Truck S) {
    initial.add(S);
    S.initialTerminal=this;

    }

    @Override
    public void Truckout(Truck S) {
    initial.remove(S);
    truckHistory.add(S);


    }


    public ArrayList<Truck> getInitial() {

        return initial;
    }
}