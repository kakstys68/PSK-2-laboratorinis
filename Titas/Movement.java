public class Movement {
    private Board board;
    private Renderer renderer;
    public Movement(Board board, Renderer renderer) {
        this.board = board;
        this.renderer = renderer;
    }

    public Movement() {
    }

    private void moveUp(Board board){
        int border;
        for(int i = 0; i < board.getMatrix().length; i++) {
            border = 0;
            for (int j = 0; j < board.getMatrix().length; j++) {
                if(board.getMatrix()[j][i].getValue() != 0){
                    verticalMove(j, i, "up", border);
                }
            }
        }
        board.addTile();
    }

    private void moveDown(Board board){
        int border;
        for(int i = 0; i < board.getMatrix().length; i++){
            border = board.getMatrix().length - 1;
            for(int j = board.getMatrix().length - 1; j>=0; j--) {
                if ( board.getMatrix()[j][i].getValue() != 0 && ( border >= j )) {
                        verticalMove(j, i, "down", border);

                }
            }
        }
        board.addTile();
    }

    private void moveLeft(Board board){
        int border;
        for ( int i = 0; i < board.getMatrix().length; i++ ) {
            border = 0;
            for ( int j = 0; j < board.getMatrix().length; j++ ) {
                if ( board.getMatrix()[i][j].getValue() != 0 ) {
                    horizontalMove( i, j, "left", border );
                }
            }
        }
        board.addTile();
    }

    private void moveRight(Board board){
        int border;
        for (int i = 0; i < board.getMatrix().length; i++) {
            border = (board.getMatrix().length - 1);
            for (int j = (board.getMatrix().length - 1 ); j >= 0; j--) {
                if (board.getMatrix()[i][j].getValue() != 0) {
                    if (border >= j) {
                        horizontalMove(i, j, "right", border);
                    }
                }
            }
        }
        board.addTile();
    }


    public void move(char input) {
        switch (input) {
            case 'w' -> moveUp(board);
            case 'a' -> moveLeft(board);
            case 's' -> moveDown(board);
            case 'd' -> moveRight(board);
            case 'q' -> renderer.quitting();
            default -> renderer.badInput();
        }
    }
}
