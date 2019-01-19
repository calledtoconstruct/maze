import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class GivenCurrentLocationIsKnownTest {
    private char[][] board = null ;
    private Follower follower = null;
    private Location expectedLocation = new Location();
 
    @Test
    public void whenEvaluatingBoardThenAdjacentEmptyLocationToTheLeftIsReturned() throws Exception {
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
 
    @Test
    public void whenEvaluatingBoardThenAdjacentEmptyLocationBelowIsReturned() throws Exception {
        board = new char[][] {
            {'W', 'W', 'W', 'S'},
            {'W', 'W', 'E', ' '}
        };
        this.follower = new Follower(this.board);
        this.follower.takeNextStep();
        expectedLocation.setX(3);
        expectedLocation.setY(1);
        assertEquals(this.follower.getCurrentLocation(), expectedLocation);
    }
 
    @Test
    public void whenEvaluatingBoardThenOnlyTheFirstAdjacentEmptyLocationIsReturned() throws Exception {
        board = new char[][] {
            {'S', ' ', ' ', 'E'},
            {'W', 'W', 'W', 'W'}
        };
        this.follower = new Follower(this.board);
        this.follower.takeNextStep();
        expectedLocation.setX(1);
        expectedLocation.setY(0);
        assertEquals(this.follower.getCurrentLocation(), expectedLocation);
    }
    
    @Test
    public void whenEvaluatingBoardPositionWithNoAdjacentEmptyLocationsThenAnExceptionIsThrown() {
        Exception thrown = null;
        try {
            board = new char[][] {
                {'S', ' ', 'W', 'W'},
                {'W', 'W', 'W', 'E'}
            };
            this.follower = new Follower(this.board);
            this.follower.takeNextStep();
            this.follower.takeNextStep();
        } catch (Exception ex) {
            thrown = ex;
        }
        assertNotEquals(thrown, null);
    }


    // Before
        // board = new char[][] {
        //     {'S', ' ', ' ', 'E'},
        //     {'W', 'W', 'W', 'W'}
        // };
    // After
        // board = new char[][] {
        //     {'*', 'C', ' ', 'E'},
        //     {'W', 'W', 'W', 'W'}
        // };
    // After another step
        // board = new char[][] {
        //     {'*', '*', 'C', 'E'},
        //     {'W', 'W', 'W', 'W'}
        // };

    @Test
    public void whenMovingToTheNextSpaceThenBreadcrumbIsLeftBehind() throws Exception {
        board = new char[][] {
            {'S', ' ', ' ', 'E'},
            {'W', 'W', 'W', 'W'}
        };
        this.follower = new Follower(this.board);
        final Location previous = this.follower.getCurrentLocation();
        this.follower.takeNextStep();
        final Character leftBehind = this.follower.getValueAtPreviousLocation(previous);
        assertEquals(leftBehind, '*');
    }

    @Test
    public void whenMovingToTheNextSpaceThenMyCurrentPositionIsMarked() throws Exception {
        board = new char[][] {
            {'S', ' ', ' ', 'E'},
            {'W', 'W', 'W', 'W'}
        };
        this.follower = new Follower(this.board);
        this.follower.takeNextStep();
        final Location current = this.follower.getCurrentLocation();
        // TODO: Ask for the value at a specific location
        // TODO: Verify that the letter 'C' exists at
        // the appropriate location
        final Character currentValue = this.follower.???();
        assertEquals(currentValue, 'C');
    }

}