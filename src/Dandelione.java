public class Dandelione extends Plant{

    public Dandelione(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world, newPosition);
    }

    public Dandelione clone() {
        return Dandelion(this, null, null);
    }


    public Dandelione initParams() {
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 2;
        this.sign = 'D';
    }
}
