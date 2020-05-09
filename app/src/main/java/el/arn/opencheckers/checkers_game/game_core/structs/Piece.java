package el.arn.opencheckers.checkers_game.game_core.structs;

public enum Piece {
    WhitePawn(Player.White, Type.Pawn),
    BlackPawn(Player.Black, Type.Pawn),
    WhiteKing(Player.White, Type.King),
    BlackKing(Player.Black, Type.King);

    public enum Type { Pawn, King }

    private Player team;
    private Type type;

    public Player getTeam() {
        return team;
    }

    public Type getType() {
        return type;
    }

    public static Piece get(Player team, Type type) {
        if (team == Player.White && type == Type.Pawn) {
            return WhitePawn;
        } else if (team == Player.White && type == Type.King) {
            return WhiteKing;
        } else if (team == Player.Black && type == Type.Pawn) {
            return BlackPawn;
        } else if (team == Player.Black && type == Type.King) {
            return BlackKing;
        } else {
            throw new InternalError();
        }
    }

    private Piece(Player team, Type type) {
        this.team = team;
        this.type = type;
    }

}
