public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int offsetY = toLine - line;
        int offsetX = toColumn - column;
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn)) {
            //for attack
            if (Math.abs(offsetX) == 1 && Math.abs(offsetY) == 1 && chessBoard.board[toLine][toColumn] != null
                    && !chessBoard.board[toLine][toColumn].getColor().equals(this.color))
                return true;

            //for move
            if (chessBoard.board[toLine][toColumn] == null && offsetY != 0 && Math.abs(offsetY) <= 2 && toColumn == column) {

                if (getColor().equals("White") && offsetY > 0) {
                    return offsetY == 1 || line == 1;
                }

                if (getColor().equals("Black") && offsetY < 0) {
                    return offsetY == -1 || line == 6;
                }
            }
        }
        return false;
    }

    public String getSymbol() {
        return "P";
    }
}
