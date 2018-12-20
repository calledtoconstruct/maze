import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class GivenIDoNotHaveABoardTest {

    private final char[] board = new char[] { 'S', 'E' };
    private Follower follower = null;

    @BeforeEach
    public void whenIAmInstantiatedWithABoard() throws Exception {
        this.follower = new Follower(this.board);
    }

    @Test
    public void thenIHaveAReferenceToTheBoard() {
        assertEquals(this.follower.hasBoard(), true);
    }

}