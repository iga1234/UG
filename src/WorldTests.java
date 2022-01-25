import org.junit.Test;

public class WorldTests {

    @Test (expected = IllegalStateException.class)
    public void worldIsSingleton(){
        new World(8,8);
        new World(10,10);
    }
}
