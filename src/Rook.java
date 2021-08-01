public class Rook extends ChessPiece{

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && (line != toLine || column != toColumn)) {
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.color))
                return false;

            if (line == toLine && Math.abs(toColumn - column) > 1) {
                int checkColumn = Math.min(column, toColumn);
                int checkToColumn = Math.max(column, toColumn);
                for (checkColumn++; checkColumn < checkToColumn; checkColumn++){
                    if (chessBoard.board[line][checkColumn] != null)
                        return false;
                }
            }

            if (column == toColumn && Math.abs(toLine - line) > 1) {
                int checkLine = Math.min(line, toLine);
                int checkToLine = Math.max(line, toLine);
                for (checkLine++; checkLine < checkToLine; checkLine++){
                    if (chessBoard.board[checkLine][column] != null)
                        return false;
                }
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
