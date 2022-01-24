public class Sheep extends Animal{
    public Sheep(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world, newPosition);

    }

    public Sheep clone() {
        return Sheep(this, null, null);
    }


    public initParams() {
        this.power = 3;
        this.initiative = 3;
        this.liveLength = 10;
        this.powerToReproduce = 6;
        this.sign = 'S';
    }

    public getNeighboringPositions() {
        return this.getWorld().filterPositionsWithOtherSpecies(this.getWorld().getNeighboringPositions(this.position), Sheep);
    }
}
}
