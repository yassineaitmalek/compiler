package test;

import java.io.FileNotFoundException;

import compiler.al.AnalyseurLexical;
import compiler.as.AnalyseurSyntaxique;
import compiler.exception.SemantiqueExecption;
import compiler.exception.SyntaxeException;

public class Main {
  public static void main(String[] args) throws FileNotFoundException, SyntaxeException, SemantiqueExecption {

    AnalyseurLexical al = new AnalyseurLexical("src/main/resources/test.txt");
    String cond = "";
    do {
      cond = al.uniteSuivante();

    } while (!cond.equals(AnalyseurLexical.ENDFILE));

    AnalyseurSyntaxique analyseurSyntaxique = new AnalyseurSyntaxique();

    analyseurSyntaxique.runAnalyseSyntaxique();

    // new Interpreter("src/main/resources/VIC.txt");

  }
}
