import java.util.ArrayList;
import java.util.List;

public class Plant extends Organism {

    public Plant(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world);
        this.newPosition = newPosition;
    }

    public List<Action> move() {
        List<Action> result = new ArrayList<Action>();
        return result;
    }

    public List<Action> action() {
        List<Action> result = new ArrayList<Action>();
        newPlant = null;
        newPosition = null;
        if (this.ifReproduce()) {
            pomPositions = this.getFreeNeighboringPosition(this.position)
            if (pomPositions) {
                newPosition = random.choice(pomPositions);
                newPlant = this.clone();
                newPlant.initParams();
                newPlant.position = newPosition;
                this.power = this.getPower()/ 2;
                result.add(new Action(ActionEnum.A_ADD, newPosition, 0, newPlant));
            }
        }
        return result;
    }
    
    public getFreeNeighboringPosition(position) {
        return this.getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(position));
    }

}
