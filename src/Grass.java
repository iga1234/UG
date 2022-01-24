public class Grass extends Plant{

    public Grass(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world, newPosition);

    }

    public Grass clone() {
        return Grass(this, null, null);
    }


    public Grass initParams() {
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 6;
        this.powerToReproduce = 3;
        this.sign = 'G';
        }
}
