import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal extends Organism {

    public Animal(Organism organism, Integer position, World world) {
        super(organism, position, world);
    }

    @property
    public void lastPosition() {
        return this.__lastPosition;
    }


    @lastPosition.setter {
        public void lastPosition(Integer value){
            this.__lastPosition = value;
        }
    }
    public List<Action> move() {
        List<Action> result = new ArrayList<Action>();
        pomPositions = this.getNeighboringPositions();
        newPosition = null;

        if (pomPositions) {
            newPosition = random.choice(pomPositions);
            result.add(new Action(ActionEnum.A_MOVE, new Position, 0, this));
            this.lastPosition = this.getPosition();
            metOrganism = this.getWorld().getOrganismFromPosition(new Position);
            if(metOrganism is == null) {
                result.extend(metOrganism.consequences(this));
            }
        }
        return result;
    }

    public  List<Action> action() {
        List<Action> result = new ArrayList<Action>();
        newAnimal = null;
        birthPositions = this.getNeighboringBirthPositions();

        if (this.ifReproduce() && birthPositions) {
            newAnimalPosition = random.choice(birthPositions);
            newAnimal = this.clone() newAnimal.initParams();
            newAnimal.position = newAnimalPosition;
            this.power = setPower(getPower() / 2);
            result.add(new Action(ActionEnum.A_ADD, newAnimalPosition, 0, newAnimal))
        }
        return result;
    }

    public ? getNeighboringPositions() {
        return this.getWorld().getNeighboringPositions(this.getPosition());
    }
    public ? getNeighboringBirthPositions() {
        return getWorld().filterFreePositions(this.getWorld().getNeighboringPositions(this.getPosition()));
    }
}
