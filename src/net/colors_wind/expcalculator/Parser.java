package net.colors_wind.expcalculator;

/**
 * E  -> TE'
 * E' -> +TE' | ε
 * T  -> FT'
 * T' -> *FT' | ε
 * F  -> (E) | N
 */
public class Parser {
    private final TokenAnalyzer analyzer;
    private Token token;

    void advance() {
        token = analyzer.next();
        System.out.println(token);
    }

    public Token getToken() {
        return token;
    }

    public Parser(TokenAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void processE() {
        processT();
        processE2();

    }

    public void processE2() {
        if (token.isTokenEquals('+')) {
            this.advance();
            this.processT();
            this.processE2();
        } else if (token.isTokenEquals(')') || token.getType() == TokenType.END) {
            // 这里可以优化: 并不一定要检查FOLLOW集合
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void processF() {
        if (token.getType() == TokenType.NUMBER) {
            this.advance();
        } else if (token.isTokenEquals('(')) {
            this.advance();
            this.processE();
            if (token.isTokenEquals(')')) this.advance();
            else throw new IllegalArgumentException();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void processT() {
        this.processF();
        this.processT2();
    }

    public void processT2() {
        if (token.isTokenEquals('*')) {
            this.advance();
            this.processF();
            this.processT2();
        } else if (token.isTokenEquals('+') || token.isTokenEquals(')') || token.getType() == TokenType.END) {
            // 这里可以优化: 并不一定要检查FOLLOW集合
        } else {
            throw new IllegalArgumentException();
        }
    }

}
