import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        World pyWorld = new World(8, 8);

        Organism newOrg = new Grass(null, new Position(4, 0), pyWorld);
        newOrg.initParams();
        pyWorld.addOrganism(newOrg);

        newOrg = new Sheep(null, new Position(0, 0), pyWorld);
        newOrg.initParams();
        pyWorld.addOrganism(newOrg);

        newOrg = new Dandelion(null, new Position(0, 4), pyWorld);
        newOrg.initParams();
        pyWorld.addOrganism(newOrg);

        newOrg = new Wolf(null, new Position(7, 7), pyWorld);
        newOrg.initParams();
        pyWorld.addOrganism(newOrg);

        newOrg = new Toadstool(null, new Position(4, 4), pyWorld);
        newOrg.initParams();
        pyWorld.addOrganism(newOrg);

        System.out.print(pyWorld);

        for (int i = 0; i < 100; i++){

            System.in.read();
//            Runtime.getRuntime().exec("cls");
            System.out.print("\033[H\033[2J ");
            System.out.flush();
            pyWorld.makeTurn();
            System.out.print(pyWorld.toString());
        }
    }
}
