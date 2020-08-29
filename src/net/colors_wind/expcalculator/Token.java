package net.colors_wind.expcalculator;

public final class Token {

    private final TokenType type;
    private final Object obj;

    public Token(TokenType type, Object obj) {
        this.type = type;
        this.obj = obj;
    }

    public TokenType getType() {
        return type;
    }

    public Object getObj() {
        return obj;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", obj=" + obj +
                '}';
    }
}
