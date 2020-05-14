package el.arn.opencheckers.checkers_game.game_core.implementations;

import el.arn.opencheckers.checkers_game.game_core.configurations.GameStartConfig;

public class GameStartConfigImpl implements GameStartConfig {

    private StartingPlayerOptions startingPlayer = startingPlayerDefaultValue;


    public GameStartConfigImpl() { }
    public GameStartConfigImpl(StartingPlayerOptions startingPlayer) {
        setStartingPlayer(startingPlayer);
    }

    @Override public StartingPlayerOptions getStartingPlayer() {
        return startingPlayer;
    }
    @Override public void setStartingPlayer(StartingPlayerOptions value) {
        startingPlayer = value;
    }
}