// Generated from C:/Users/Sebastian/IdeaProjects/Sprachkonzepte/src/Aufgabe2\OURParser.g4 by ANTLR 4.10.1
package Aufgabe2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OURParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OURParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OURParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(OURParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link OURParser#sentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentence(OURParser.SentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OURParser#multSentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultSentence(OURParser.MultSentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OURParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(OURParser.ValueContext ctx);
}