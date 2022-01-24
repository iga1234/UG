public class Action {

    private Integer value;
    private ActionEnum action;
    private Position position;
    private Organism organism;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Organism getOrganism() {
        return organism;
    }

    public void setOrganism(Organism organism) {
        this.organism = organism;
    }

    public Action(ActionEnum action, Position position, Integer value, Organism organism) {
        this.value = value;
        this.action = action;
        this.position = position;
        this.organism = organism;
    }

    @Override
    public String toString() {
        return "Action{" +
                "action=" + action +
                ", organism=" + organism +
                '}';
    }
}
