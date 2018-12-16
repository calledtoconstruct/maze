import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.Before;

public class GivenIDoNotHaveABoardTest {

    Follower follower = null;
    char[] board;

    @Before
    public void whenIAmInstantiatedWithABoard() throws Exception {
        this.follower = new Follower(this.board);
    }

    @Test
    public void thenIHaveAReferenceToTheBoard() {
        assertEquals(this.follower.hasBoard(), true);
    }

}