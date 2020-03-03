import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void testDirection() throws Exception{

        Rover r = new Rover();
        r.setX(1);
        r.setY(1);
        r.setDirection("N");
        // assert statements
        assertEquals("N", r.getDirection("N","M"));
    }

    @Test
    public void testPosition() throws Exception{

        Rover r = new Rover();
        r.setX(1);
        r.setY(1);
        r.setDirection("N");
        // assert statements
        assertEquals("1 2 N", r.getPosition("N",5,5));
    }


}