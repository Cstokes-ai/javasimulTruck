import java.util.Scanner;

public class Basic extends Container {
    int ID=1;
    double weight =2.50;
    Basic(int ID, double weight) {
        super(ID, weight);

    }

    @Override
    void HeavyCheck() {

    }

    @Override
    void BasicCheck() {
        System.out.println("Basic check\n");
        System.out.println("Check for ID");
        Scanner container1=new Scanner(System.in);
        int identification=container1.nextInt();
        System.out.println(identification);

        if (identification==ID && identification==weight) {
            System.out.println("Vehicle identified");
        }
        else{
            System.out.println("Not a Baisc truck");
        }
    }


}
