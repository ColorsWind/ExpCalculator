package net.colors_wind.expcalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            TokenAnalyzer analyzer = new TokenAnalyzer(scanner.nextLine());
            ExtendParser parser = new ExtendParser(analyzer);
            parser.advance();
            parser.processE();
            if (parser.getToken().getType() != TokenType.END)
                throw new IllegalArgumentException();
        }
    }
}
