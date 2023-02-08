package scanner;


import org.testng.annotations.Test;
import token.Token;
import token.TokenType;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ScannerTest {

    @Test
    public void testScanTokensForSimpleExpression(){
        String source = "1 + 2";
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();
        // because they are different object and without overriding hashcode and equals it is impossible to be equals
        // but toString method is same both of them so it is handy to compare Tokens as Strings
        assertEquals(new Token(TokenType.NUMBER,"1",1.0, 1).toString(), tokens.get(0).toString());
        assertEquals(new Token(TokenType.PLUS,"+",null, 2).toString(), tokens.get(1).toString());
        assertEquals(new Token(TokenType.NUMBER,"2",2.0, 3).toString(), tokens.get(2).toString());
    }


}