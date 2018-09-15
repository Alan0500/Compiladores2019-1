package testmaven;
import java.util.Stack;

public class ControladorAnalisisLexico {
  private Stack<Integer> stackBloques;
    private int identActual;
    public ControladorAnalisisLexico(){
      identActual = 0 ;
      stackBloques = new Stack();
    }

    public Stack<Integer> getStackBloques() {
        return stackBloques;
    }

    public void setStackBloques(Stack<Integer> stackBloques) {
        this.stackBloques = stackBloques;
    }

    public int getIdentActual() {
        return identActual;
    }

    public void setIdentActual(int identActual) {
        this.identActual = identActual;
    }


    /**
     * Metodo que sirve para reconocer la identacion de los parrafos en jflex y
     * conocer de esta manera si es necesario agregar una nueva identacion al
     * codigo. Existen 3 casos posibles
     * <ul>
     * <li>Se agrega un nivel mas de identacion (la sangria de un parafo actual
     * es mayor que el del parrafo anterior)</li>
     * <li>El nivel de identacion se conserva (El nivel de la sangria coincide
     * con la del parrafo anterior)</li>
     * <li>Existe una deidentacion (la sangria del parrafo actual es menor que
     * la del parrafo anterior )</li>
     * </ul>
     *
     * @param numEspacios variable que mide el numero de espacios antes de la
     * identacion del parrafo actual
     */
    public String representa(int numEspacios, int linea) {
      if(numEspacios == identActual){
        return "";
      }
        if (numEspacios > 0) {
            if (numEspacios > identActual) {
                identActual = numEspacios;
                stackBloques.add(numEspacios);
                return "IDENTA";
            }
        }
        if (numEspacios < identActual) {
            while (!stackBloques.isEmpty()) {
                if (stackBloques.peek() == numEspacios) {
                    identActual = numEspacios;
                    return "DEIDENTA";
                }else{
                  stackBloques.pop();
                }
            }
        }

        throw new RuntimeException("Problemas de Identacion en la linea: " + linea);

    }
    public String terminaIdentacion(){
      String finalDeLinea = "";
      
      while(!stackBloques.isEmpty()){
        int s = stackBloques.pop();
        finalDeLinea += "DEIDENTA(" + s+ ")\n";
      }
      return finalDeLinea ;
    }
}
