import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

class InvalidBoard {
    private final char[] board;

    public InvalidBoard(final char[] board) {
        this.board = board;
    }

    char[] GetBoard() { 
        return this.board;
    }
}

@RunWith(Parameterized.class)
public class GivenIHaveReceivedABoardTest {

    private final char[] board;
    
    private Exception thrown;

    @Parameterized.Parameters()
    public static InvalidBoard[] GetParameters() {
        return new InvalidBoard[] {
            new InvalidBoard(new char[] { 'W', 'W' }),
            new InvalidBoard(new char[] { 'W', 'S' }),
            new InvalidBoard(new char[] { 'W', 'E' }),
            new InvalidBoard(new char[0])
        };
    }

    public GivenIHaveReceivedABoardTest(final InvalidBoard invalidBoard) {
        this.board = invalidBoard.GetBoard();
    }

    @Before
    public void whenIAmInstantiatedWithAInvalidBoard() {
        try {
            final Follower follower = new Follower(this.board);
        } catch (Exception ex) {
            thrown = ex;
        }
    }

    @Test
    public void thenThrowAnException() {
        assertNotEquals(thrown, null);
    }

}