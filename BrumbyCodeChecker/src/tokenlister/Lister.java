package tokenlister;
import java.util.ArrayList;
import java.io.*;
import sablecc.node.*;
import sablecc.lexer.*;
import sablecc.java_lexer.*;



public class Lister {
	private static sablecc.lexer.Lexer lex;
	private static sablecc.java_lexer.Lexer jlex;
	private static ArrayList<Token> tokens;

	

public static ArrayList<Token> ConvertToList(String a, String lang) {
		//InputStream StrStream = new 	ByteArrayInputStream(a.getBytes(Charset.forName("UTF-8")));
	tokens = new ArrayList<Token>();
	Token T;
	if(lang.contentEquals(".cpp")) {
			lex = new sablecc.lexer.Lexer
					(new PushbackReader
					(new StringReader(a), 1024));
			try {
				T = lex.next();
				while (!(T instanceof EOF)) {
					//System.out.println(T.getClass() + ": " + T.getText());
					tokens.add(T);
					T = lex.next();
				}
			}
			catch (sablecc.lexer.LexerException le)
			{ System.out.println ("Lexer Exception " + le); }
			catch (IOException ioe)
			{ System.out.println ("IO Exception " +ioe); }
		}else if(lang.equals(".java")) {
			jlex = new sablecc.java_lexer.Lexer
					(new PushbackReader
					(new StringReader(a), 1024));
			try {
				T = jlex.next();
				while (!(T instanceof EOF)) {
					//System.out.println(T.getClass() + ": " + T.getText());
					tokens.add(T);
					T = jlex.next();
				}
			}
			catch (sablecc.java_lexer.LexerException le)
			{ System.out.println ("Lexer Exception " + le); }
			catch (IOException ioe)
			{ System.out.println ("IO Exception " +ioe); }
		}
		return tokens;
	} 
	
	
	
}
