package Aufgabe2;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Stack;

public final class OURBuilder extends OURParserBaseListener {
    private Stack<OUR> stack = new Stack<OUR>();
    int multcounter = 1;

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
            System.out.println("Stack at Sentence: " + stack.toString());
            OUR right = this.stack.pop();
            String value = ctx.getChild(0).getText();
            this.stack.push(new StartSentence(value, right));
        }
    }

    @Override
    public void exitMultSentence(OURParser.MultSentenceContext ctx) {
        if (ctx.getChildCount() == 3) {
            System.out.println("Stack at MultSentence " + multcounter++ + ": " + stack.toString());
            if(ctx.getChild(2).getText().length() == 1) {
                String right = ctx.getChild(2).getText();
                OUR value = this.stack.pop();
                String separator = ctx.getChild(0).getText();
                this.stack.push(new Sentence(separator, value, right));
            } else {
                OUR right = this.stack.pop();
                OUR value = this.stack.pop();
                String separator = ctx.getChild(0).getText();
                this.stack.push(new Sentence(separator, value, right));
            }
            //SEPERATOR  value  (Multi/EOL)
        }
    }

    @Override
    public void exitValue(OURParser.ValueContext ctx) {
        String s = "";
        switch (ctx.getStart().getType()) {
            case OURLexer.NUMBERS -> s =  ctx.NUMBERS().getText();
            case OURLexer.STRING -> s = ctx.STRING().getText();
        };
        System.out.println("Value to add to stack: " + s);
        this.stack.push(new Value(s));
    }
}