import java.util.ArrayList;
import java.util.List;

public class Toadstool extends Plant{

    public Grass(Organism organism, Integer position, World world, None newPosition) {
        super(organism, position, world, newPosition);
    }

    public Grass clone() {
        return Dandelion(this, null, null);
    }
    public Grass initParams() {
        this.power = 0;
        this.initiative = 0;
        this.liveLength = 10;
        this.powerToReproduce = 5;
        this.sign = 'T';
    }
    public List<Action> consequences(Organism attackingOrganism) {

        List<Action> result = new ArrayList<Action>();

        if (this.power > attackingOrganism.getPower()) {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, attackingOrganism));
        } else {
            result.add(new Action(ActionEnum.A_REMOVE, new Position(-1, -1), 0, this));

        }
        return result;
    }


}
