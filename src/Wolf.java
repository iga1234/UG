public class Wolf extends Animal {

    public Wolf(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world, newPosition);

    }

    public Wolf clone() {
        return Wolf(this, null, null);
    }


    public initParams() {
        this.power = 6;
        this.initiative = 5;
        this.liveLength = 15;
        this.powerToReproduce = 12;
        this.sign = 'W';
    }

    public getNeighboringPositions() {
        return this.getWorld().filterPositionsWithOtherSpecies(this.getWorld().getNeighboringPositions(this.position), Wolf);
    }
}
