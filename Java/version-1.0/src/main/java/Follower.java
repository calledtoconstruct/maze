public class Follower {

    private final char[] board;

    Follower(char[] board) throws Exception {
        if (board == null || board.length == 0) {
            throw new Exception("Missing required Maze");
        }

        this.board = board;

        int countE = 0;
        int countS = 0;
        for (int index = 0; index < this.board.length; index++) {
            if (this.board[index] == 'S') {
                ++countS;
            } else if (this.board[index] == 'E') {
                ++countE;
            }
        }

        if (countS != 1 || countE != 1) {
            throw new Exception("Missing required Start or End location");
        }
    }

    public boolean hasBoard() {
        return true;
    }
}