/*******************************************************
 * Copyright (C) 2020-2021 ArealApps areal.apps@gmail.com
 *
 * This file and project cannot be copied and/or distributed without the explicit
 * permission of ArealApps. All Rights Reserved.
 *******************************************************/

package el.arn.ultimatecheckers.game.game_core.checkers_game;

import el.arn.ultimatecheckers.game.game_core.checkers_game.structs.Move;
import el.arn.ultimatecheckers.game.game_core.checkers_game.structs.Tile;

import java.util.Set;

public interface ReadableBoardWithAvailableMoves extends ReadableBoard {
    Set<Tile> getAvailablePieces();
    Set<Move> getAvailableMovesForPiece(int x, int y);
    void reloadAvailableMoves();
}
