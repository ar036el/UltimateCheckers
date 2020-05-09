package el.arn.opencheckers.checkers_game.game_core.implementations;

import el.arn.opencheckers.checkers_game.game_core.configurations.BoardConfig;
import el.arn.opencheckers.checkers_game.game_core.exceptions.ConfigurationException;

public class BoardConfigImpl implements BoardConfig {

    private int boardSize = boardSizeDefaultValue;
    private int startingRowsForEachPlayer = startingRowsForEachPlayerDefaultValue;


    public BoardConfigImpl() { }
    public BoardConfigImpl(int boardSize, int startingRowsForEachPlayer) throws ConfigurationException {
        setBoardSize(boardSize);
        setStartingRowsForEachPlayer(startingRowsForEachPlayer);
    }

    @Override public int getBoardSize() {
        return boardSize;
    }
    @Override public void setBoardSize(int value) throws ConfigurationException {
        if (value < minBoardSize || value > maxBoardSize || value % 2 == 1) {
            throw new ConfigurationException();
        }
        boardSize = value;
    }


    @Override public int getStartingRowsForEachPlayer() {
        return startingRowsForEachPlayer;
    }
    @Override public void setStartingRowsForEachPlayer(int value) throws ConfigurationException {
        if (value < minStartingRowsForEachPlayer || value > maxStartingRowsForEachPlayer(boardSize)) {
            throw new ConfigurationException();
        }
        startingRowsForEachPlayer = value;
    }
    @Override
    public int maxStartingRowsForEachPlayer(int boardSize) throws ConfigurationException {
        if (boardSize < minBoardSize || boardSize > maxBoardSize) {
            throw new ConfigurationException();
        }
        return (int) Math.ceil((double) boardSize / 2.0) - 1;
    }
}
