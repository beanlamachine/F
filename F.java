//Ben Nguyen
/*Reads specified text file and tokenizes each lexeme and checks to see 
if it is in Test 2 grammar. It will return false or null if it is not in the grammar
and True if it is in the grammer.
This code cannot check lexems for this --> 2x=2
Code will be able to check lexemes for this tho --> 2 x = 2 (Spaces required between lexemes)*/

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.lang.System;

public class F {

   static int i = 0; 
   static String currentToken;
   static String tOf;

   public static String[] getTokenlist(String[] Lexems){   
     
      String[] TokenList = new String[Lexems.length];
     
      for(int i = 0; i < Lexems.length; i++){
      //System.out.println(lexArray[i]); 
         try{ 
            int Value = Integer.parseInt(Lexems[i]);
            TokenList[i]= "INT_LIT";
            //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: INT_LIT.");
         } catch(Exception e){
            try{
               float Value = Float.parseFloat(Lexems[i]);
               TokenList[i]= "FLOAT_LIT";
              // System.out.println("Current lex: " + Lexems[i] + " \tToken Type: FLOAT_LIT.");
            
            } catch(Exception f){
               switch(Lexems[i]){
                  case ",":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: ,");
                     TokenList[i]= ",";
                     break;
                  case "=":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: =");
                     TokenList[i]= "=";
                     break;
                  case ";":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: ;");
                     TokenList[i]= ";";
                     break;
                  case "if":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: if.");
                     TokenList[i]= "if";
                     break;
                  case "DataType":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: DataType.");
                     TokenList[i]= "DataType";
                     break;   
                  case "while":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: while.");
                     TokenList[i]= "while";
                     break;
                  case "else":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: else.");
                     TokenList[i]= "else";
                     break;
                  case "|":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: |.");
                     TokenList[i]= "|";
                     break;
                  case "+":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: ADD_OP.");
                     TokenList[i]= "ADD_OP";
                     break;
                  case "-":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: SUB_OP.");
                     TokenList[i]= "SUB_OP";
                     break;
                  case "*":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: MULT_OP.");
                     TokenList[i]= "MUlT_OP";
                     break;
                  case "/":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: DIV_OP.");
                     TokenList[i]= "DIV_OP";
                     break;
                  case "(":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: LEFT_PAREN.");
                     TokenList[i]= "LEFT_PAREN";
                     break;
                  case ")":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: RIGHT_PAREN.");
                     TokenList[i]= "RIGHT_PAREN";
                     break;
                  case "{":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: {.");
                     TokenList[i]= "{";
                     break;
                  case "}":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: }.");
                     TokenList[i]= "}";
                     break;
                  case "%":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: MOD_OP.");
                     TokenList[i]= "MOD_OP";
                     break;
                  case "==":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: EQUAL_OP.");
                     TokenList[i]= "EQUAL_OP";
                     break;
                  case "<":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: LESSTHAN_OP.");
                     TokenList[i]= "LESSTHAN_OP";
                     break;   
                  case "<=":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: LESSTHANEQUAL_OP.");
                     TokenList[i]= "LESSTHANEQUAL_OP";
                     break;
                  case ">":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: GREATERTHAN_OP.");
                     TokenList[i]= "GREATERTHAN_OP";
                     break;
                  case ">=":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: GREATERTHANEQUAL_OP.");
                     TokenList[i]= "GREATERTHANEQUAL_OP";
                     break;
                  case "!=":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: !=.");
                     TokenList[i]= "!=";
                     break;
                  case "&&":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: AND_OP.");
                     TokenList[i]= "AND_OP";
                     break;
                  case "||":
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: OR_OP.");
                     TokenList[i]= "OR_OP";
                     break;   
                  default:
                     //System.out.println("Current lex: " + Lexems[i] + " \tToken Type: IDENT.");
                     TokenList[i]= "IDENT";
                     break;                                        
               }
            }
         }
      }
      return TokenList;
   }
   
   
   
   public static void RDA(String[] Tokens){
   
      F.i = 0; 
      F.currentToken = Tokens[0];
      stmtlist(Tokens);
   }
   
   public static String getNextToke(String[] Tokes, int i){
      i = F.i;
      if(F.i < Tokes.length - 1){
         F.i++;
         F.currentToken = Tokes[F.i];
      }
      else if(F.i == Tokes.length -1){
         F.currentToken = null; 
        // System.out.println("True");
         // System.exit(0) ;
      } 
      return F.currentToken;
   }
   
   public static void stmtlist(String[] Tokens){
      stmt(Tokens);
      while(F.currentToken == ";"){
         if (F.currentToken == ";"){
            getNextToke(Tokens, F.i);
            stmt(Tokens);
         }
         else{
            System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: ;");
            F.tOf = "False";
         } 
      }
   } 
   public static void stmt(String[] Tokens){
      if (F.currentToken == "if"){
         ifstmt(Tokens);
      }
      else if (F.currentToken == "{"){
         block(Tokens);
      }
      else if (F.currentToken == "while"){
         while_loop(Tokens);
      }
      else if (F.currentToken == "DataType"){
         declare(Tokens);
      }
      else if (F.currentToken == "IDENT"){
         ass(Tokens);
      } 
   }
   
   
   
   public static void ifstmt(String[] Tokens){
      if (F.currentToken == "if"){
         getNextToke(Tokens, F.i);
      }
      if (F.currentToken != "LEFT_PAREN"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: LEFT_PAREN");
         F.tOf = "False";
         getNextToke(Tokens, F.i);
      } else getNextToke(Tokens, F.i);
      boolExpr(Tokens);
      if (F.currentToken != "RIGHT_PAREN"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: RIGHT_PAREN");
         F.tOf = "False";   
         getNextToke(Tokens, F.i); 
      }else getNextToke(Tokens, F.i);
      block(Tokens);
      
      if (F.currentToken == "else"){
         getNextToke(Tokens, F.i);
         block(Tokens);
      }
   }
   public static void while_loop(String[] Tokens){
      if (F.currentToken == "while"){
         getNextToke(Tokens, F.i);
      }
      if (F.currentToken != "LEFT_PAREN"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: LEFT_PAREN");
         F.tOf = "False";
         getNextToke(Tokens, F.i);
      } else getNextToke(Tokens, F.i);
      boolExpr(Tokens);
      if (F.currentToken != "RIGHT_PAREN"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: RIGHT_PAREN");
         F.tOf = "False";   
         getNextToke(Tokens, F.i); 
      }else getNextToke(Tokens, F.i);
      block(Tokens);
   }
   
   
   
   public static void block(String[] Tokens){
      if (F.currentToken == "{"){
         getNextToke(Tokens, F.i);
      }else{
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: {");
         F.tOf = "False";    
         getNextToke(Tokens, F.i);   
      } stmtlist(Tokens);
      if (F.currentToken != "}"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: }");
         F.tOf = "False";    
         getNextToke(Tokens, F.i);
      }else getNextToke(Tokens, F.i);
   }
   
   
   

   public static void declare(String[] Tokens){
      if (F.currentToken == "DataType"){
         getNextToke(Tokens, F.i);
      }
      if (F.currentToken != "IDENT"){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: IDENT");
         F.tOf = "False";
         getNextToke(Tokens, F.i);
      }else getNextToke(Tokens, F.i);
      while (F.currentToken == ","){
         if (F.currentToken == ","){
            getNextToke(Tokens, F.i);
            if (F.currentToken != "IDENT"){
               System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: IDENT");
               F.tOf = "False";
               getNextToke(Tokens, F.i);
            }else getNextToke(Tokens, F.i);
         }
      }
   }
   
   
   
   public static void ass(String[] Tokens){
      if (F.currentToken == "IDENT"){
         getNextToke(Tokens, F.i);
      }
      if (F.currentToken != "="){
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: =");
         F.tOf = "False";
         getNextToke(Tokens, F.i);
      }else{
         getNextToke(Tokens, F.i);
         expre(Tokens);
      }     
   }
   
   
    
   public static void expre(String[] Tokens){
      term(Tokens);
      while(F.currentToken == "ADD_OP" || F.currentToken == "SUB_OP"){
         if (F.currentToken == "ADD_OP" || F.currentToken == "SUB_OP"){
            getNextToke(Tokens, F.i);
            term(Tokens);
         }else{
            System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: SUB_OP or ADD_OP");
            F.tOf = "False";
            getNextToke(Tokens, F.i);
         }
      }
   }
   public static void term(String[] Tokens){
      fact(Tokens);
      while(F.currentToken == "MUlT_OP" || F.currentToken == "DIV_OP" || F.currentToken == "MOD_OP"){
         if (F.currentToken == "MUlT_OP" || F.currentToken == "DIV_OP" || F.currentToken == "MOD_OP"){
            getNextToke(Tokens, F.i);
            fact(Tokens);
         }else{
            System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: MUlT_OP or MOD_OP or DIV_OP");
            F.tOf = "False";
            getNextToke(Tokens, F.i);
         }
      }
   }
   public static void fact(String[] Tokens){
      if (F.currentToken == "IDENT" || F.currentToken == "INT_LIT" || F.currentToken == "FLOAT_LIT"){
         getNextToke(Tokens, F.i);
      /*  if(!(F.currentToken.equals("MUlT_OP") || F.currentToken.equals("DIV_OP") || F.currentToken.equals("MOD_OP") || F.currentToken.equals("ADD_OP") || F.currentToken.equals("SUB_OP"))){
            System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: MUlT_OP or DIV_OP or MOD_OP or ADD_OP or SUB_OP");
                           F.tOf = "False";
         } */
      }
      else if (F.currentToken == "LEFT_PAREN") {
         getNextToke(Tokens, F.i);
         expre(Tokens); 
         if(F.currentToken != "RIGHT_PAREN"){
            System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: RIGHT_PAREN");
            F.tOf = "False";
            getNextToke(Tokens, F.i);
         }else getNextToke(Tokens, F.i);
      } else {
         System.out.println("Error, Current token is: " +F.currentToken+ " at index " +F.i+  " Expected: RIGHT_PAREN or FLOAT_LIT or INT_LIT or IDENT");
         F.tOf = "False";
         getNextToke(Tokens, F.i);
      }
   }



   public static void boolExpr(String[] Tokens){
      bterm(Tokens);
      while(F.currentToken == "GREATERTHAN_OP" || F.currentToken == "LESSTHAN_OP" || F.currentToken == "GREATERTHANEQUAL_OP" || F.currentToken == "LESSTHANEQUAL_OP"){
         if (F.currentToken == "GREATERTHAN_OP" || F.currentToken == "LESSTHAN_OP" || F.currentToken == "GREATERTHANEQUAL_OP" || F.currentToken == "LESSTHANEQUAL_OP"){
            getNextToke(Tokens, F.i);
            bterm(Tokens);
         }
      } 
   }
   public static void bterm(String[] Tokens){
      band(Tokens);
      while(F.currentToken == "EQUAL_OP" || F.currentToken == "!="){
         if (F.currentToken == "EQUAL_OP" || F.currentToken == "!="){
            getNextToke(Tokens, F.i);
            band(Tokens);
         }
      } 
   }
   public static void band(String[] Tokens){
      bOr(Tokens);
      while(F.currentToken == "AND_OP"){
         if (F.currentToken == "AND_OP"){
            getNextToke(Tokens, F.i);
            bOr(Tokens);
         }
      } 
   }
   public static void bOr(String[] Tokens){
      expre(Tokens);
      while(F.currentToken == "OR_OP"){
         if (F.currentToken == "OR_OP"){
            getNextToke(Tokens, F.i);
            expre(Tokens);
         }
      } 
   }




   public static void main (String[] args) throws IOException {
   /* Start code for reading file and storing into an array */
      List<String> listOfStrings = new ArrayList<String>();
   
      FileReader fr = new FileReader("C:\\Users\\benng\\OneDrive\\Desktop\\Exam2PLC\\Tester");
   
      String s = new String();
      char ch;
      
      Scanner read = new Scanner(fr);
      while(read.hasNextLine()){
         String expr = read.nextLine();
         String [] lexArray = expr.split(" ");
      
      
         System.out.print("The strings in file are: ");
         for (String str : lexArray) {
            System.out.print(str);
            System.out.print(" ");   
         } //end of reading file and storing into an array
         System.out.print("\n");  
      
         String[] tokenReturn = getTokenlist(lexArray);
      
         RDA(tokenReturn);
         if (F.currentToken != null) tOf = "false";
         if (F.currentToken == null) tOf = "true";
      
         System.out.println(tOf);
      }
   }
}



