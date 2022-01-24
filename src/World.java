import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    private List<Organism> organisms;
    private Integer worldX;
    private Integer worldY;
    private Integer turn;
    private List<Organism> newOrganisms;
    private String separator;


    public World(Integer worldX, Integer worldY) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.turn = 0;
        this.organisms = new ArrayList<Organism>();
        this.newOrganisms = new ArrayList<Organism>();
        this.separator = " ";
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

    public void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }

    public Integer getWorldX() {
        return worldX;
    }

    public void setWorldX(Integer worldX) {
        this.worldX = worldX;
    }

    public Integer getWorldY() {
        return worldY;
    }

    public void setWorldY(Integer worldY) {
        this.worldY = worldY;
    }

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public List<Organism> getNewOrganisms() {
        return newOrganisms;
    }

    public void setNewOrganisms(List<Organism> newOrganisms) {
        this.newOrganisms = newOrganisms;
    }

    public String getSeparator() {
        return separator;
    }

    public void setSeparator(String separator) {
        this.separator = separator;
    }

    public void makeTurn() {
        List<Action> actions = new ArrayList<Action>();

        for (int i = 0; i < this.organisms.size(); i++) {
            if (this.positionOnBoard(this.organisms.get(i).getPosition())) {
                actions = this.organisms.get(i).move();

                for (int j = 0; j < actions.size(); j++) {
                    this.makeMove(actions.get(j));
                }
                actions.clear();
                if (this.positionOnBoard(this.organisms.get(i).getPosition())) {
                    actions = this.organisms.get(i).action();

                    for (int k = 0; k < actions.size(); k++) {
                        this.makeMove(actions.get(k));
                    }
                }
            }
            actions.clear();
        }

        this.organisms = this.organisms.stream().filter(o -> this.positionOnBoard(o.getPosition())).collect(Collectors.toList());
        for (int o = 0; o < this.organisms.size(); o++) {
            this.organisms.get(o).setLiveLength(this.organisms.get(o).getLiveLength() - 1);
            this.organisms.get(o).setPower(this.organisms.get(o).getPower() + 1);
            if (this.organisms.get(o).getLiveLength() < 1) {
                System.out.println(this.organisms.get(o).toString() + "{ died of old age at{ " + this.organisms.get(o).getPosition());
            }
        }
        this.organisms = this.organisms.stream().filter(o -> o.getLiveLength() > 0).collect(Collectors.toList());

        this.newOrganisms = this.newOrganisms.stream().filter(o -> this.positionOnBoard(o.getPosition())).collect(Collectors.toList());
        this.organisms.addAll(this.newOrganisms);
        this.organisms.sort(Comparator.comparing(Organism::getInitiative, Comparator.reverseOrder()));
        this.newOrganisms.clear();

        this.turn += 1;

    }

    public void makeMove(Action action) {
            System.out.println(action);
        if (action.getAction().equals(ActionEnum.A_ADD)) {
            this.newOrganisms.add(action.getOrganism());
        }
        else if(action.getAction().equals(ActionEnum.A_INCREASEPOWER)) {
            action.getOrganism().setPower(action.getOrganism().getPower() + action.getValue());
            }
        else if(action.getAction().equals(ActionEnum.A_MOVE)) {
            action.getOrganism().setPosition(action.getPosition());
            }
        else if(action.getAction().equals(ActionEnum.A_REMOVE)) {
            action.getOrganism().setPosition(new Position(-1, -1));
            }
        }

        public boolean addOrganism(Organism newOrganism){
            Position newOrgPosition = new Position(newOrganism.getPosition().getX(), newOrganism.getPosition().getY());

            if(this.positionOnBoard(newOrgPosition)){
                this.organisms.add(newOrganism);
                this.organisms.sort(Comparator.comparing(Organism::getInitiative, Comparator.reverseOrder()));
                return true;
                }
            return false;
        }


    public boolean positionOnBoard(Position position) {
            return position.getX() >= 0 && position.getY() >= 0 && position.getX()< this.worldX && position.getY()< this.worldY;
        }

    public Organism getOrganismFromPosition(Position position) {
            Organism pomOrganism = null;


        for (int i = 0; i < this.organisms.size(); i++) {
            if(this.organisms.get(i).getPosition().equals(position)) {
                pomOrganism = this.organisms.get(i);
                break;
            }
        }
        if(pomOrganism == null) {
            for(int i = 0; i < this.newOrganisms.size(); i++) {
                if(newOrganisms.get(i).getPosition().equals(position)) {
                    pomOrganism = newOrganisms.get(i);
                    break;
                }
            }
        }
        return pomOrganism;
        }

    public List<Position> getNeighboringPositions(Position position) {
            List<Position> result = new ArrayList<Position>();
            Position pomPosition;

            for (int y = -1; y < 2; y++) {
                for (int x = -1; x < 2; x++) {
                    pomPosition = new Position(position.getX() + x, position.getY() + y);
                    if(this.positionOnBoard(pomPosition) && !(y == 0 && x == 0)){
                        result.add(pomPosition);
                    }
                }
            }
            return result;
        }

    public List<Position> filterFreePositions(List<Position> fields) {
        List <Position> result = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            if (this.getOrganismFromPosition(fields.get(i)) == null) {
                result.add(fields.get(i));
            }
        }
        return result;
    }


    public List<Position> filterPositionsWithoutAnimals(List<Position> fields) {
        List<Position> result = new ArrayList<>();
        Organism pomOrg = null;

        for (int i = 0; i < fields.size(); i++) {
            pomOrg = this.getOrganismFromPosition(fields.get(i));
            if (pomOrg == null || pomOrg instanceof Plant) {
                result.add(fields.get(i));
            }
        }
        return result;
        }

    public List<Position> filterPositionsWithOtherSpecies(List<Position> fields, Class<?>  clazz){
        List<Position> result = new ArrayList<>();
        Organism pomOrg;

        for (int i = 0; i < fields.size(); i++) {
            pomOrg = this.getOrganismFromPosition(fields.get(i));
            if (!clazz.isInstance(pomOrg)) {
                result.add(fields.get(i));
            }
        }
        return result;
    }

    public String toString() {
        String result = "\nturn{ " + this.turn.toString() + "\n";
        for (int wY = 0; wY < this.worldY; wY++) {
            for (int wX = 0; wX < this.worldX; wX++) {
                Organism org = this.getOrganismFromPosition(new Position(wX, wY));
                if (org != null) {
                    result += org.getSign();
                } else {
                    result += this.separator;
                }
            }
            result += "\n";
        }
        return result;
    }
}


