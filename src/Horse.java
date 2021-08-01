public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.color))
                return false;
            int offsetY = Math.abs(line - toLine);
            int offsetX = Math.abs(column - toColumn);
            return (offsetY == 1 && offsetX == 2) || (offsetY == 2 && offsetX == 1);
        }
        return false;
    }

    public String getSymbol() {
        return "H";
    }
}
