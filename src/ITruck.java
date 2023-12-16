public interface ITruck {

    public boolean goTo(Terminal p); // meant to return true if the truck made it to the destination.

    void reFuel(double newFuel);

    boolean loadUp(Container load);//load up

    boolean loadDown(Container load);
}