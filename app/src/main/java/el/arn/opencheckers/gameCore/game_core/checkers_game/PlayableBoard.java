/*******************************************************
 * Copyright (C) 2020-2021 ArealApps areal.apps@gmail.com
 *
 * This file and project cannot be copied and/or distributed without the explicit
 * permission of ArealApps. All Rights Reserved.
 *******************************************************/

package el.arn.opencheckers.gameCore.game_core.checkers_game;

import org.jetbrains.annotations.NotNull;

import el.arn.opencheckers.gameCore.game_core.checkers_game.exceptions.PieceWasNotSelectedException;
import el.arn.opencheckers.gameCore.game_core.checkers_game.exceptions.PointIsOutOfBoardBoundsException;
import el.arn.opencheckers.gameCore.game_core.checkers_game.exceptions.TileIsAlreadyOccupiedException;
import el.arn.opencheckers.gameCore.game_core.checkers_game.exceptions.TileIsNotPlayableException;
import el.arn.opencheckers.gameCore.game_core.checkers_game.structs.Piece;

public interface PlayableBoard extends ReadableBoard, Cloneable {
    void addPiece(int x, int y, Piece piece) throws TileIsAlreadyOccupiedException, PointIsOutOfBoardBoundsException, TileIsNotPlayableException;
    void movePiece(int xFrom, int yFrom, int xTo, int yTo) throws PointIsOutOfBoardBoundsException, TileIsNotPlayableException, TileIsAlreadyOccupiedException, PieceWasNotSelectedException;
    void changePiece(int x, int y, Piece piece) throws PointIsOutOfBoardBoundsException, TileIsNotPlayableException, PieceWasNotSelectedException;
    void setListener(BoardListener Listener);

    @NotNull
    PlayableBoard clone();

    /** @return the removed piece type **/
    Piece removePiece(int x, int y) throws PointIsOutOfBoardBoundsException, TileIsNotPlayableException, PieceWasNotSelectedException;

}
