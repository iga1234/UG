import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WorldTests {

    @Test (expected = IllegalStateException.class)
    public void worldIsSingleton(){
        new World(8,8);
        new World(10,10);
    }

    @Test
    public void consequencesPositionTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Position expected = new Position(-1,-1);
        Position actual = result.get(0).getPosition();

        assertEquals(expected, actual);
    }

    @Test
    public void consequencesAnimalTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }

    @Test
    public void consequencesAnimalTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }

    @Test
    public void consequencesAnimalTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }
    @Test
    public void consequencesAnimalTest(){
        World world = new World(8,8);
        Sheep sheep = new Sheep(null,new Position(5,5), world);
        Wolf wolf = new Wolf(null, new Position(5,5), world);
        List<Action> result = wolf.consequences(sheep);
        Organism expected = new Wolf(null, new Position(5,5), world);
        Organism actual = result.get(0).getOrganism();

        assertEquals(expected, actual);
    }
}
