package testmaven;
import java.io.*;

public class Test {

    public static void main (String[] args){
      AnalizadorLexico al ;

      System.out.println("/********************************************************************************"
      +"+++++++++++++++++++++++++Caso todo va bien"+
      "/********************************************************************************");
      try{
        al = new AnalizadorLexico("src/main/resources/FizzBuzz.p","src/out/FizzBuzz.plx");
        al.analiza();
      }catch (RuntimeException e) {
        System.out.println("\n"+e);
      }
      System.out.println();
      System.out.println("/********************************************************************************"
      +"+++++++++++++++++++++++++Caso Error cadena"+
      "/********************************************************************************");


      try{
        al = new AnalizadorLexico("src/main/resources/fz_error_cadena.p","src/out/fz_error_cadena.plx");
        al.analiza();
      }catch (RuntimeException e) {
        System.out.println("\n"+e);
      }
        System.out.println();
      System.out.println("/********************************************************************************"
      +"+++++++++++++++++++++++++CAso Error lexema"+
      "/********************************************************************************");
      try {
        al = new AnalizadorLexico("src/main/resources/fz_error_lexema.p","src/out/fz_error_lexema.plx");
        al.analiza();
      }catch (RuntimeException e) {
        System.out.print("\n"+e);
      }
        System.out.println();
      System.out.println("/********************************************************************************"
      +"+++++++++++++++++++++++++CAso Error identacion"+
      "/********************************************************************************");
      try{
        al = new AnalizadorLexico("src/main/resources/fz_error_identacion.p","src/out/fz_error_identacion.plx");
        al.analiza();
      }catch (RuntimeException e) {
        System.out.println("\n"+e);
  }

    }
}
