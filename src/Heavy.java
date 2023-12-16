import java.util.*;
public class Heavy extends Container {
    int ID = 2;
    double weight = 3.00;
    int identification;
    String Truck;

    Heavy(int ID, double weight) {
        super(ID, weight);
    }

    @Override
    void HeavyCheck() {
        System.out.println("Heavy Check\n");
        System.out.println("Check for ID");
        Scanner container1 = new Scanner(System.in);
        int identification = container1.nextInt();

        if (identification == ID && identification == weight) {
            System.out.println("Vehicle identified");
        } else {
            System.out.println("Not a heavy truck");
        }
    }

    @Override
    void BasicCheck() {

    }

}
