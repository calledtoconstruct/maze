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
                current.setX(indexX);
                current.setY(indexY);
            }
        }
    }
}

    public boolean hasBoard() {
        return true;
    }

    public Location getCurrentLocation() {
        return current;
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
                    current.setX(indexX);
                    current.setY(indexY);
                    return current;
                }
            }
        }
        throw new Exception();
    }
}