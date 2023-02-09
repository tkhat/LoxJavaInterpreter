package scanner;


import org.testng.annotations.Test;
import token.Token;
import token.TokenType;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ScannerTest {

    @Test
    public void testScanTokensForSimpleExpression() {
        String source = "1 + 2";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        // because they are different object and without overriding hashcode and equals it is impossible to be equals
        // but toString method is same both of them, so it is handy to compare Tokens as Strings
        assertEquals(new Token(TokenType.NUMBER, "1", 1.0, 1).toString(), tokens.get(0).toString());
        assertEquals(new Token(TokenType.PLUS, "+", null, 2).toString(), tokens.get(1).toString());
        assertEquals(new Token(TokenType.NUMBER, "2", 2.0, 3).toString(), tokens.get(2).toString());
    }

    @Test
    public void testScanTokensForAllKindOfTokenType() {
        String source = "1 + 2; 2 - 5; 7 > 2; 6 < 5; 5 >= 5; var <=;   (); {}; print class if else true fun for if nil  ";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        assertEquals(tokens.get(0).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(1).getType(), TokenType.PLUS);
        assertEquals(tokens.get(2).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(3).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(4).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(5).getType(), TokenType.MINUS);
        assertEquals(tokens.get(6).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(7).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(8).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(9).getType(), TokenType.GREATER);
        assertEquals(tokens.get(10).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(11).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(12).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(13).getType(), TokenType.LESS);
        assertEquals(tokens.get(14).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(15).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(16).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(17).getType(), TokenType.GREATER_EQUAL);
        assertEquals(tokens.get(18).getType(), TokenType.NUMBER);
        assertEquals(tokens.get(19).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(20).getType(), TokenType.VAR);
        assertEquals(tokens.get(21).getType(), TokenType.LESS_EQUAL);
        assertEquals(tokens.get(22).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(23).getType(), TokenType.LEFT_PAREN);
        assertEquals(tokens.get(24).getType(), TokenType.RIGHT_PAREN);
        assertEquals(tokens.get(25).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(26).getType(), TokenType.LEFT_BRACE);
        assertEquals(tokens.get(27).getType(), TokenType.RIGHT_BRACE);
        assertEquals(tokens.get(28).getType(), TokenType.SEMICOLON);
        assertEquals(tokens.get(29).getType(), TokenType.PRINT);
        assertEquals(tokens.get(30).getType(), TokenType.CLASS);
        assertEquals(tokens.get(31).getType(), TokenType.IF);
        assertEquals(tokens.get(32).getType(), TokenType.ELSE);
        assertEquals(tokens.get(33).getType(), TokenType.TRUE);
        assertEquals(tokens.get(34).getType(), TokenType.FUN);
        assertEquals(tokens.get(35).getType(), TokenType.FOR);
        assertEquals(tokens.get(36).getType(), TokenType.IF);
        assertEquals(tokens.get(37).getType(), TokenType.NIL);
        assertEquals(tokens.get(38).getType(), TokenType.EOF);
    }
}