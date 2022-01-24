public class Dandelion extends Plant{

    public Dandelion(Organism dandelion, Position position, World world) {
        super(dandelion, position, world);
        System.out.println("dandelion");

    }

    public Dandelion clone() {
        return new Dandelion(this, null, null);
    }


    public void initParams() {
        this.setPower(0);
        this.setInitiative(0);
        this.setLiveLength(6);
        this.setPowerToReproduce(2);
        this.setSign("D");
    }
}
