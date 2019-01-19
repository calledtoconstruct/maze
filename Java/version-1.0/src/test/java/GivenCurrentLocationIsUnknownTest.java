import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GivenCurrentLocationIsUnknownTest {
    private char[][] board = null ;
    private Follower follower = null;
    private Location expectedLocation = new Location();

    @BeforeEach
    public void whenSearchingForStartLocation() throws Exception {
    }
 
    @Test
    public void thenMyCurrentLocationIsKnown() throws Exception {
        board = new char[][] {{'W', 'W', 'W', 'S'}, {'W', 'W', 'W', 'E'}};
        this.follower = new Follower(this.board);
        expectedLocation.setX(3);
        expectedLocation.setY(0);
        assertEquals(this.follower.getCurrentLocation(), expectedLocation);
        
        board = new char[][] {{'W', 'W', 'S', 'W'}, {'W', 'W', 'W', 'E'}};
        this.follower = new Follower(this.board);
        expectedLocation.setX(2);
        expectedLocation.setY(0);
        System.out.println(this.follower.getCurrentLocation());
        assertEquals(this.follower.getCurrentLocation(), expectedLocation);
    }
}

