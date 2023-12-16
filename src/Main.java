
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Terminal terminal1 = null;
        Terminal terminal2 = null;
        ArrayList<Truck> initial = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("MENU:");
            System.out.println("1. Create Terminal 1");
            System.out.println("2. Create Terminal 2");
            System.out.println("3. Calculate distance between Terminals");
            System.out.println("4. Load/Create Containers into/for Trucks");
            System.out.println("5. Print loaded Containers in Trucks");
            System.out.println("6. Gas Mileage/Unload at Terminal 2");
            System.out.println("7. RefueledExit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter ID for terminal 1:");
                    int id1 = scanner.nextInt();
                    System.out.println("Enter X coordinate for terminal 1:");
                    double x1 = scanner.nextDouble();
                    System.out.println("Enter Y coordinate for terminal 1:");
                    double y1 = scanner.nextDouble();
                    terminal1 = new Terminal(id1, x1, y1);
                    break;

                case 2:
                    System.out.println("Enter ID for terminal 2:");
                    int id2 = scanner.nextInt();
                    System.out.println("Enter X coordinate for terminal 2:");
                    double x2 = scanner.nextDouble();
                    System.out.println("Enter Y coordinate for terminal 2:");
                    double y2 = scanner.nextDouble();
                    terminal2 = new Terminal(id2, x2, y2);
                    break;

                case 3:
                    if (terminal1 != null && terminal2 != null) {
                        System.out.println("The distance between terminals is: " + terminal1.getDistance(terminal2));
                    } else {
                        System.out.println("Please create both terminals first.");
                    }
                    break;

                case 4:
                    if (terminal1 != null) {
                        Truck truck1 = new Truck(1, terminal1, 50, 57);

                        System.out.println("Enter ID for Basic Container:");
                        int basicID = scanner.nextInt();
                        System.out.println("Enter weight for Basic Container:");
                        int basicWeight = scanner.nextInt();

                        System.out.println("Enter ID for Heavy Container:");
                        int heavyID = scanner.nextInt();
                        System.out.println("Enter weight for Heavy Container:");
                        int heavyWeight = scanner.nextInt();

                        System.out.println("Enter ID for Refrigerator Container:");
                        int refrigeratorID = scanner.nextInt();
                        System.out.println("Enter weight for Refrigerator Container:");
                        int refrigeratorWeight = scanner.nextInt();

                        System.out.println("Enter ID for Tanker Container:");
                        int tankerID = scanner.nextInt();
                        System.out.println("Enter weight for Tanker Container:");
                        int tankerWeight = scanner.nextInt();

                        // Determine container type based on ID and weight
                        Container container1;
                        if (basicWeight <= 100) {
                            container1 = new Basic(basicID, basicWeight);
                            System.out.println("Basic");
                        } else if (heavyWeight > 100 && heavyWeight <= 500) {
                            container1 = new Heavy(heavyID, heavyWeight);
                            System.out.println("Heavy");
                        } else if (basicWeight <= 500 && refrigeratorWeight <= 1000) {
                            container1 = new RefrigeratorTruck(refrigeratorID, refrigeratorWeight);
                            System.out.println("RefrigeratorTruck");
                        } else if (tankerWeight > 1000) {
                            container1 = new Tanker(tankerID, tankerWeight);
                            System.out.println("Tanker");
                            truck1.loadUp(container1);
                            truck1.loadUp(container1);
                            truck1.loadUp(container1);
                            truck1.printLoadedContainers();
                        } else {
                            System.out.println("Invalid container specifications.");
                            break;
                        }

                        truck1.loadUp(container1);
                        // Load other containers similarly...

                        System.out.println("Containers loaded into Truck 1.");
                    } else {
                        System.out.println("Please create Terminal 1 first.");
                    }
                    break;

                case 5:
                    if (terminal1 != null) {
                        // Find truck1 from terminal1's initial trucks
                        Truck truck1 = terminal1.getTruckById(1);

                        // Check if truck1 is found and initialize it if not found
                        if (truck1 == null) {
                            truck1 = new Truck(1, terminal1, 50, 57);
                            terminal1.Truckin(truck1); // Assuming adding truck1 to terminal1's initial list
                        }

                        // Load containers into truck1
                        System.out.println("Use the same values for each container type (ID and weight).");
                        int basicID = scanner.nextInt();
                        int basicWeight = scanner.nextInt();
                        int heavyID = scanner.nextInt();
                        int heavyWeight = scanner.nextInt();
                        int refrigeratorID = scanner.nextInt();
                        int refrigeratorWeight = scanner.nextInt();
                        int tankerID = scanner.nextInt();
                        int tankerWeight = scanner.nextInt();

                        Container container1 = new Basic(basicID, basicWeight);
                        Container container2 = new Heavy(heavyID, heavyWeight);
                        Container container3 = new RefrigeratorTruck(refrigeratorID, refrigeratorWeight);
                        Container container4 = new Tanker(tankerID, tankerWeight);

                        truck1.loadUp(container1);
                        truck1.loadUp(container2);
                        truck1.loadUp(container3);
                        truck1.loadUp(container4);

                        if (!truck1.getinitialContainers().isEmpty()) {
                            System.out.println("Containers in Truck 1:");
                            for (Container container : truck1.getinitialContainers()) {
                                System.out.println(container.getDetails());
                            }
                        } else {
                            System.out.println("Truck 1 has not been loaded with containers.");
                        }
                    } else {
                        System.out.println("Please create Terminal 1 first.");
                    }
                    break;

                case 6:
                    System.out.println("Enter Basic Container Fuel Cost$:");
                    double basicFuel = scanner.nextDouble();
                    System.out.println("Enter Heavy Container Fuel Cost$:");
                    double heavyFuel = scanner.nextDouble();
                    System.out.println("Enter Refrigerator Container Fuel Cost$:");
                    double refrigeratorFuel = scanner.nextDouble();
                    System.out.println("Enter Tanker Container Fuel Cost$:");
                    double tankerFuel = scanner.nextDouble();

                    double maxGasDollarAmount = 100.0; // Replace with your desired maximum dollar amount


                    if (terminal1 != null && terminal2 != null) {
                        Truck truck1 = terminal1.getTruckById(1); // Assuming truck1 has ID 1

                        if (truck1 != null) {
                            double initialFuel = truck1.getFuel();
                            boolean moved = truck1.goTo(terminal2);

                            if (initialFuel != truck1.getFuel()) {
                                System.out.println("Get some more fuel into the trucks before takeoff");

                            }

                            if (moved) {
                                System.out.println("Truck 1 moved to Terminal 2.");
                                double finalFuel = truck1.getFuel();
                                double fuelUsed = initialFuel - finalFuel;
                                System.out.println("Gas used by the truck: " + finalFuel + " units");

                                // Calculate fuel cost based on the container types
                                double totalContainerFuelCost = 0.0;

                                ArrayList<Container> containers = new ArrayList<>(truck1.getinitialContainers());
                                for (Container container : containers) {
                                    if (container instanceof Basic) {
                                        totalContainerFuelCost += ((Basic) container).BasicFuelConsumption();
                                    } else if (container instanceof Heavy) {
                                         totalContainerFuelCost += ((Heavy) container).HeavyFuelConsumption();
                                    }
                                }

                                // Calculate total fuel cost including both truck and containers
                                double totalFuelCost = fuelUsed * (basicFuel + totalContainerFuelCost);

                                if (totalFuelCost > maxGasDollarAmount) {
                                    System.out.println("Truck 1 cannot make it to Terminal 2 due to excessive gas cost.");
                                } else {
                                    // Unload containers at Terminal 2
                                    for (Container container : containers) {
                                        boolean unloaded = truck1.loadDown(container);
                                        if (unloaded) {
                                            System.out.println("Container unloaded at Terminal 2 - ID: " + container.getID());
                                        } else {
                                            System.out.println("Unable to unload container at Terminal 2 - ID: " + container.getID());
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Truck 1 couldn't move due to insufficient fuel.");
                            }
                        } else {
                            System.out.println("Truck 1 not found in Terminal 1.");
                        }
                    } else {
                        System.out.println("Please create both terminals first.");
                    }
                    break;

                case 7:
                    System.out.println("Refueling trucks...");
                    for (Truck truck: initial) {
                        double amountOfFuelToRefuel = 1.0; // Change this according to your refueling amount

                        // Call the reFuel method for each truck
                        truck.reFuel(amountOfFuelToRefuel);
                    }



                    exit=true;
                default:
                    System.out.println("Next");
            }
        }
    }
}