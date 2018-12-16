public class Follower {

    char[] board = null;
    boolean hasBoard = false;
    int countE = 0;
    int countS = 0;

    Follower(char[] board) throws Exception {
        this.board = board;
        for (int index = 0; index < this.board.length; index++) {
            if (this.board[index] == 'S') {
                ++this.countS;
            } else if (this.board[index] == 'E') {
                ++this.countE;
            }
        }

        if (this.countS != 1 || this.countE != 1) {
            throw new Exception();
        }
    }

    public boolean hasBoard() {
        // return this.hasBoard;
        return true;
    }
}