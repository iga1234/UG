public class Grass extends Plant {

    public Grass(Organism grass, Position position, World world) {
        super(grass, position, world);

    }

    public Grass clone() {
        return new Grass(this, null, null);
    }


    public void initParams() {
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(6);
        this.setPowerToReproduce(3);
        this.setSign("G");
    }
}
