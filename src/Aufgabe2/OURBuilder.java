package Aufgabe2;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;


public final class OURBuilder extends OURParserBaseListener {
    private Stack<OUR> stack = new Stack<OUR>();

    public OUR build(ParseTree tree) {
        new ParseTreeWalker().walk(this, tree);
        return this.stack.pop();
    }
// Override exit methods form OURParserListener.java

    @Override
    public void exitSentence(OURParser.SentenceContext ctx) {
        // Sentence -> 2
        // MultSentence -> 3
        if (ctx.getChildCount() == 2) {
            OUR right = this.stack.pop();
            OUR left = this.stack.pop();
            String op = ctx.getChild(1).getText();
            this.stack.push(new Sentence(left, op, right));
        }
    }

    @Override
    public void exitMultSentence(OURParser.MultSentenceContext ctx) {
        if (ctx.getChildCount() == 3) {
            OUR right = this.stack.pop();
            OUR left = this.stack.pop();
            String op = ctx.getChild(1).getText();
            this.stack.push(new Sentence(left, op, right));
        }
    }

    @Override
    public void exitValue(OURParser.ValueContext ctx) {
        String s = switch (ctx.getStart().getType()) {
            case OURLexer.NUMBERS -> ctx.NUMBERS().getText();
            case OURLexer.STRING -> ctx.STRING().getText();
            default -> "";
        };
        this.stack.push(new Value(s));
    }
}