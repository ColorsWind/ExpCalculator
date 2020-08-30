package net.colors_wind.expcalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            TokenAnalyzer analyzer = new TokenAnalyzer(scanner.nextLine());
            Parser parser = new Parser(analyzer);
            parser.advance();
            parser.processE();
        }
    }
}
