/*******************************************************
 * Copyright (C) 2020-2021 ArealApps areal.apps@gmail.com
 *
 * This file and project cannot be copied and/or distributed without the explicit
 * permission of ArealApps. All Rights Reserved.
 *******************************************************/

package com.arealapps.ultimatecheckers.game.game_core.checkers_game;

import com.arealapps.ultimatecheckers.game.game_core.checkers_game.configurations.GameLogicConfig;
import com.arealapps.ultimatecheckers.game.game_core.checkers_game.exceptions.CannotPassTurn;
import com.arealapps.ultimatecheckers.game.game_core.checkers_game.exceptions.GameException;
import com.arealapps.ultimatecheckers.game.game_core.checkers_game.structs.Player;
import com.arealapps.ultimatecheckers.game.game_core.checkers_game.structs.Tile;

public interface GameLogic {
    /** @return {@code Tile} of the captured piece if happened, {@code null} otherwise **/
    Tile makeAMove(int xFrom, int yFrom, int xTo, int yTo) throws GameException;

    void passTurn() throws CannotPassTurn;
    boolean isExtraTurn();
    boolean canPassExtraTurn();

    Player getCurrentPlayer();

    void refreshGame();

    GameLogicConfig getConfig();

    /** @return {@code null} if game has not yet ended **/
    Player getWinner();

    void setListener(GameLogicListener Listener);

}