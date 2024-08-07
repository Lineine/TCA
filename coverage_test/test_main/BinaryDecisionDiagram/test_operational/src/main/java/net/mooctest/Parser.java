package net.mooctest;

/*
 * A simple parser for boolean expressions.
 */


import java.util.ArrayList;
import java.util.HashSet;

public final class Parser {
  private Lexer lexer;
  private ArrayList<String> variables;
  private HashSet<String> seenVars;

  public Parser(Lexer lexer) {
    this.lexer = lexer;
    variables = new ArrayList<String>();
    seenVars = new HashSet<String>();
  }

  public ExpressionTree buildExprTree() {
    return readExpr(0);
  }

  public ArrayList<String> getVariables() {
    return variables;
  }

  private ExpressionTree readExpr(int precedence) {
    ExpressionTree expr = readTerm();
    while (true) {
      Token token = lexer.nextToken();
      int newPrecedence = getPrecedence(token);
      if (newPrecedence <= precedence) break;
      ExpressionTree rightSide = readExpr(newPrecedence);
      expr = (token == Token.AND) ? new AndExpression(expr, rightSide) : new OrExpression(expr, rightSide);
    }

    lexer.saveToken();

    return expr;
  }

  private ExpressionTree readTerm() {
    Token token = lexer.nextToken();
    if (token == Token.TRUE || token == Token.FALSE) return new LiteralExpression(token);
    
    if (token == Token.VARIABLE) {
      String varName = lexer.getVariable();
      if(!seenVars.contains(varName)) {
        variables.add(varName);
        seenVars.add(varName);
      }
      return new VariableExpression(varName);
    }

    if (token == Token.NOT) return new NotExpression(readTerm());
    if (token != Token.LEFT_PAREN) throw new RuntimeException("Illegally formatted expression");
    ExpressionTree expr = readExpr(0);
    if (lexer.nextToken() != Token.RIGHT_PAREN) {
      throw new RuntimeException("Unbalanced parantheses in expression");
    }
    return expr;
  }

  /*
   * Returns the precedence value for the given token.
   */
  private int getPrecedence(Token token) {
    switch (token) {
      case OR: return 1;
      case AND: return 2;
      case NOT: return 3; // Shouldn't be needed, NOTs handled in readTerm
    }
    return -1;
  }
}
