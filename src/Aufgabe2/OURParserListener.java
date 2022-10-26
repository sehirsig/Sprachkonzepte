// Generated from C:/Users/Sebastian/IdeaProjects/Sprachkonzepte/src/Aufgabe2\OURParser.g4 by ANTLR 4.10.1
package Aufgabe2;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link OURParser}.
 */
public interface OURParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link OURParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(OURParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link OURParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(OURParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link OURParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(OURParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OURParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(OURParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OURParser#multSentence}.
	 * @param ctx the parse tree
	 */
	void enterMultSentence(OURParser.MultSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link OURParser#multSentence}.
	 * @param ctx the parse tree
	 */
	void exitMultSentence(OURParser.MultSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link OURParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(OURParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link OURParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(OURParser.ValueContext ctx);
}