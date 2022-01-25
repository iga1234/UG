import java.util.List;

public class Alien extends Organism{

    public Alien(Organism organism, Position position, World world) {
        super(organism, position, world);
    }

    @Override
    public List<Action> move() {
        return null;
    }

    @Override
    public List<Action> action() {
        return null;
    }

    @Override
    public Organism clone() {
        return null;
    }

    @Override
    public void initParams() {
        this.setPower(1);
        this.setInitiative(1);
        java.util.Random random = new java.util.Random();
        int live = random.nextInt(5);
        this.setLiveLength(live);
        this.setPowerToReproduce(0);
        this.setSign("A");
    }

    public List<Position> getNeighboringPositions() {
        return this.getWorld().filterPositionsWithoutAnimals(this.getWorld().getNeighboringPositions(this.getPosition()));
    }
}
