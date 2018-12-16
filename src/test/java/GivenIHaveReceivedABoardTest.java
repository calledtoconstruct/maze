import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

class InvalidBoard {
    private char[] board;

    public InvalidBoard(char[] board) {
        this.board = board;
    }

    char[] GetBoard() { 
        return this.board;
    }
}

@RunWith(Parameterized.class)
public class GivenIHaveReceivedABoardTest {

    Follower follower = null;
    char[] board;

    Exception thrown = null;

    @Parameterized.Parameters()
    public static InvalidBoard[] GetParameters() {
        return new InvalidBoard[] {
            new InvalidBoard(new char[] { 'W', 'W' }),
            new InvalidBoard(new char[] { 'W', 'S' }),
            new InvalidBoard(new char[] { 'W', 'E' })
        };
    }

    public GivenIHaveReceivedABoardTest(char[] board) {
        this.board = board;
    }

    @Before
    public void whenIAmInstantiatedWithAInvalidBoard() {
        try {
            this.follower = new Follower(this.board);
        } catch (Exception ex) {
            thrown = ex;
        }
    }

    @Test
    public void thenThrowAnException() {
        assertNotEquals(thrown, null);
    }

}