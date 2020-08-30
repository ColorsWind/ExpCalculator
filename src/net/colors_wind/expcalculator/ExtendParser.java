package net.colors_wind.expcalculator;

/**
 * 扩充巴科斯范式
 * E -> T{+T}
 * T -> F{*F}
 * F -> (E) | N
 */
public class ExtendParser {
    private final TokenAnalyzer analyzer;
    private Token token;

    void advance() {
        token = analyzer.next();
        System.out.println(token);
    }

    public Token getToken() {
        return token;
    }

    public ExtendParser(TokenAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public void processE() {
        processT();
        while(token.isTokenEquals('+')) {
            this.advance();
            processT();
        }
    }

    public void processT() {
        processF();
        while(token.isTokenEquals('*')) {
            this.advance();
            processT();
        }
    }

    public void processF() {
        if (token.isTokenEquals('(')) {
            this.advance();
            processE();
            if (token.isTokenEquals(')')) this.advance();
            else throw new IllegalArgumentException();
        } else if (token.getType() == TokenType.NUMBER) {
            this.advance();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
