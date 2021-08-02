public class King extends ChessPiece{

    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn) || (line == toLine && column == toColumn))
            return false;
        return Math.abs(toLine - line) <= 1 && Math.abs(toColumn - column) <=1;
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack (ChessBoard chessBoard, int line, int column) {

        for (int findLine = 0; findLine <= 7; findLine++) {
            for (int findColumn = 0; findColumn <= 7; findColumn++) {
                if (chessBoard.board[findLine][findColumn] != null &&
                        !chessBoard.board[findLine][findColumn].getColor().equals(this.color) &&
                        chessBoard.board[findLine][findColumn].canMoveToPosition(chessBoard, findLine, findColumn, line, column)) {
                    return true;
                }
            }
        }
        return false;
    }
}
