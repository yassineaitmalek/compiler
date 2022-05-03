package compiler.as;

//package de l'annalyseur syntaxique

import compiler.al.AnalyseurLexical;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.*;
import compiler.generation.*;

public class genererCode {

  public List<String> a = new ArrayList<String>();

  public String k = "";

  public List<String> c = new ArrayList<String>();

  public int nbrInstructionCible;
  // DECLARATION DE LA GENERATION
  private List<InstruCible> vic = new ArrayList<InstruCible>();

  public List<Variable> table_var = new ArrayList<Variable>();
  // L'etiquete c'est le nombre

  public void mamethode() throws FileNotFoundException {
    AnalyseurLexical al = new AnalyseurLexical("src/Texte.txt");
    String cond = "";
    do {
      cond = al.uniteSuivante();
      // System.out.println("<" + AnalyseurLexical.UNITECOURANT + " , " + cond + ">");
      a.add(AnalyseurLexical.UNITECOURANT);
    } while (!cond.equals(AnalyseurLexical.ENDFILE));
    // System.out.println(a);
    int i = 1;
    do {
      if (a.get(i).equals(";")) {
        c.add(k);
        k = "";
      }
      k = k + " " + a.get(i);
      i++;
    } while (i < a.size() - 1);
    // System.out.println(c.size());

    for (i = 0; i < c.size(); i++) {
      System.out.println("(" + i + ")" + c.get(i));
    }
    {

    }
  }

  public static String var = "" + 0;

  public void expression() {
    int y;
    for (y = 1; y < a.size(); y++) {
      if (a.get(y).equals("int")) {
        if (this.contains((String) a.get(y + 1)) == null) {
          table_var.add(new Variable("entier", (String) a.get(y + 1), var, "0", null));
          var = "0" + var + 1;
        }
        if (a.get(y + 2).equals(",")) {
          if (this.contains((String) a.get(y + 3)) == null) {
            table_var.add(new Variable("entier", (String) a.get(y + 3), var, "0", null));
            var = "0" + var + 1;
          }
        }
      }
      if (a.get(y).equals("string")) {
        if (this.contains((String) a.get(y + 1)) == null) {
          table_var.add(new Variable("chaine", (String) a.get(y + 1), var, "0", null));
          var = "0" + var + 1;
        }
        if (a.get(y + 2).equals(",")) {
          if (this.contains((String) a.get(y + 3)) == null) {
            table_var.add(new Variable("chaine", (String) a.get(y + 3), var, "0", null));
            var = "0" + var + 1;
          }

        }

      }
      if (a.get(y).equals("=")) {
        if (this.contains((String) a.get(y - 1)) != null) {
          table_var.get((Integer) this.contains((String) a.get(y - 1))).modifiervaleur((String) a.get(y + 1));
        }

      }

      if (a.get(y).equals("+")) {
        if (this.contains((String) a.get(y - 1)) != null) {
          table_var.get((Integer) this.contains((String) a.get(y - 1))).modifiervaleur((String) a.get(y + 1));
        }
      }
    }
  }

  public Object contains(String lexeme) {
    int i = 0;
    for (Variable descVariable : table_var) {
      if (descVariable.getIdent().equals(lexeme)) {
        return i;
      }
      i++;
    }
    return null;
  }

  public void methode_variable() {
    for (Variable descVariable : table_var) {

      System.out.println(descVariable);
    }

  }

  public void methode_variablevic() {
    for (InstruCible descVariable : vic) {

      System.out.println(descVariable);
    }
  }

}