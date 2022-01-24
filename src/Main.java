import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        World pyWorld = new World(8, 8);

        Organism newOrg = new Grass(null, new Position(4, 0), pyWorld);
        pyWorld.addOrganism(newOrg);

        newOrg = new Sheep(null, new Position(0, 0), pyWorld);
        pyWorld.addOrganism(newOrg);

        newOrg = new Dandelion(null, new Position(0, 4), pyWorld);
        pyWorld.addOrganism(newOrg);

        newOrg = new Wolf(null, new Position(7, 7), pyWorld);
        pyWorld.addOrganism(newOrg);

        newOrg = new Toadstool(null, new Position(4, 4), pyWorld);
        pyWorld.addOrganism(newOrg);

        System.out.print(pyWorld.toString());

        for (int i = 0; i < 100; i++) {
            System.in.read();
            Runtime.getRuntime().exec("cls");
            pyWorld.makeTurn();
            System.out.print(pyWorld.toString());
        }
    }
}
