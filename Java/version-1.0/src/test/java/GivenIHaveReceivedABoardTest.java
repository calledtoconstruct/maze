import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class InvalidBoard {
    private final char[][] board;

    public InvalidBoard(final char[][] board) {
        this.board = board;
    }

    char[][] getBoard() { 
        return this.board;
    }
}

public class GivenIHaveReceivedABoardTest {

    private Exception thrown;

    public static Stream<InvalidBoard> getParameters() {
        return Stream.of(
            new InvalidBoard(new char[][] {{ 'W', 'W' }}),
            new InvalidBoard(new char[][] {{ 'W', 'S' }}),
            new InvalidBoard(new char[][] {{ 'W', 'E' }}),
            new InvalidBoard(new char[0][0]),
            new InvalidBoard(null)
        );
    }

    @ParameterizedTest
    @MethodSource("getParameters")
    public void thenThrowAnException(InvalidBoard invalidBoard) {
        try {
            final Follower follower = new Follower(invalidBoard.getBoard());
        } catch (Exception ex) {
            thrown = ex;
        }
        assertNotEquals(thrown, null);
    }

}