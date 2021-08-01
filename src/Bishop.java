public class Bishop extends ChessPiece {

    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (chessBoard.checkPos(toLine) && chessBoard.checkPos(toColumn) && line != toLine && column != toColumn) {
            if (chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(this.color))
                return false;
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {

                if (Math.abs(toLine - line) > 1 && (toLine > line && toColumn > column || toLine < line && toColumn < column)) {
                    int checkLine = Math.min(line, toLine) + 1;
                    int checkToLine = Math.max(line, toLine);
                    int checkColumn = Math.min(column, toColumn);
                    for (checkLine++ ; checkLine < checkToLine; checkLine++) {
                        checkColumn++;
                        if (chessBoard.board[checkLine][checkColumn] != null)
                            return false;
                    }
                }

                if (Math.abs(toLine - line) > 1 && (toLine > line && toColumn < column || toLine < line && toColumn > column)) {
                    int checkLine = Math.min(line, toLine);
                    int checkToLine = Math.max(line, toLine);
                    int checkColumn = Math.max(column, toColumn);
                    for (checkLine++ ; checkLine < checkToLine; checkLine++) {
                        checkColumn--;
                        if (chessBoard.board[checkLine][checkColumn] != null)
                            return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
