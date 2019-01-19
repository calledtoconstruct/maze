public class Follower {

    private final char[][] board;
    private final Location current = new Location();

    Follower(char[][] board) throws Exception {
        if (board == null || board.length == 0) {
            throw new Exception("Missing required Maze");
        }

        this.board = board;

        int countE = 0;
        int countS = 0;
        for (int indexY = 0; indexY < this.board.length; indexY++) {
            for (int indexX = 0; indexX < this.board[indexY].length; indexX++) {
                if (this.board[indexY][indexX] == 'S') {
                    ++countS;
                } else if (this.board[indexY][indexX] == 'E') {
                    ++countE;
                }
            }
        }

        if (countS != 1 || countE != 1) {
            throw new Exception("Missing required Start or End location");
        }

        for (int indexY = 0; indexY < this.board.length; indexY++) {
            for (int indexX = 0; indexX < this.board[indexY].length; indexX++) {
                if (this.board[indexY][indexX] == 'S') {
                    moveTo(indexX, indexY);
                }
            }
        }
    }

    public boolean hasBoard() {
        return true;
    }

    public Location getCurrentLocation() {
        return new Location(current);
    }

    public Location takeNextStep() throws Exception {
        for (int indexY = 0; indexY < this.board.length; indexY++) {
            for (int indexX = 0; indexX < this.board[indexY].length; indexX++) {
                boolean isAdjacent = (
                    (current.getX() == indexX && (
                        current.getY() == indexY - 1 || current.getY() == indexY + 1
                    )) || (current.getY() == indexY && (
                        current.getX() == indexX - 1 || current.getX() == indexX + 1
                    ))
                );
                if (this.board[indexY][indexX] == ' ' && isAdjacent) {
                    update(current, '*');
                    moveTo(indexX, indexY);
                    update(current, 'C');
                    return getCurrentLocation();
                }
            }
        }
        throw new Exception();
    }

    private void update(final Location at, final Character with) {
        this.board[at.getY()][at.getX()] = with;
    }

    private void moveTo(final int x, final int y) {
        this.current.setX(x);
        this.current.setY(y);
    }

	public Character getValueAtLocation(Location previous) {
        final Character value = this.board[previous.getY()][previous.getX()];
        return value;
	}
}