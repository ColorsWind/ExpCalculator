package net.colors_wind.expcalculator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TokenAnalyzer implements Iterator<Token> {
    private final String input;
    private int ip;
    private boolean end;

    public TokenAnalyzer(String input) {
        this.input = input;
        this.ip = 0;
        this.end = false;
    }

    @Override
    public boolean hasNext() {
        return !end;
    }

    @Override
    public Token next() {
        while(ip < input.length() && input.charAt(ip) == ' ') {
            ip++;
        }
        if (ip == input.length()) {
            end = true;
            return new Token(TokenType.END, null);
        }
        char c = input.charAt(ip);
        if (c == '*' || c == '+') {
            ip++;
            return new Token(TokenType.OPERATOR, Character.valueOf(c));
        } else if (c == '(' || c == ')') {
            ip++;
            return new Token(TokenType.DELIMITER, Character.valueOf(c));
        } else if (Character.isDigit(c)) {
            return readNumber();
        }
        throw new IllegalArgumentException();
    }

    private Token readNumber() {
        int last = ip;
        while (++last < input.length()) {
            char c = input.charAt(last);
            if (!(c >= '0' && c <= '9' || c == '.' )) break;
        }
        double d = Double.parseDouble(input.substring(ip, last));
        ip = last;
        return new Token(TokenType.NUMBER, d);
    }

}
