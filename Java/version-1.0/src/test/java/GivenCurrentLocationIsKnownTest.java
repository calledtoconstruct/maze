import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GivenCurrentLocationIsKnownTest {
    private char[][] board = null ;
    private Follower follower = null;
    private Location expectedLocation = new Location();

    @BeforeEach
    public void whenEvaluatingBoard() throws Exception {
        // Establish any pre-conditions
    }
 
    @Test
    public void thenAdjacentEmptyLocationIsReturned() throws Exception {
        board = new char[][] {
            {'W', 'W', ' ', 'S'},
            {'W', 'W', 'E', 'W'}
        };
        this.follower = new Follower(this.board);
        this.follower.takeNextStep();
        expectedLocation.setX(2);
        expectedLocation.setY(0);
        assertEquals(this.follower.getCurrentLocation(), expectedLocation);
    }
}