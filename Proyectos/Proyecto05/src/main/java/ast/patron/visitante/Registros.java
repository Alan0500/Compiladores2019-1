package ast.patron.visitante;

import java.util.ArrayList;
import java.util.Arrays;

public class Registros {

    int objetivoEntero;
    int objetivoDouble;
    int stringTemporal;
    int igualesTemporal; 
    int menorTemporal; 
    int mayorTemporal; 
    int menorigualTemporal; 
    int mayorigualTemporal; 
    public String archivo;
    public Registros(){
        archivo = "\n .data\n"+
                    "True : .word 1\n"+
                    "False : .word 1\n"+
                    ".text\n"
                    +"main : \n"; 
    }
    ArrayList<String> stringsTemporales = new ArrayList<String>(); 
    // Todos los registros enteros disponibles
    // String[] E_registros = {"$$t0", ... ,"$t9"};
    String[] E_registros = { "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$t8", "$t9" };
    String[] D_registros = { "$f0", "$f2", "$f4", "$f6", "$f8", "$f10" };

    public void setObjetivo(int o) {
        objetivoEntero = o % E_registros.length;
    }

    public void setObjetivoD(int o) {
        objetivoEntero = o % D_registros.length;
    }

    public void setObjetivoD(String o) {
        int nvo_objetivo = Arrays.asList(D_registros).indexOf(o);
        setObjetivo(nvo_objetivo);
    }

    public void setObjetivo(String o) {
        int nvo_objetivo = Arrays.asList(E_registros).indexOf(o);
        setObjetivo(nvo_objetivo);
    }

    public int getObjetivo() {
        return objetivoEntero;
    }

    public int getObjetivoD() {
        return objetivoDouble;
    }
    public String getObjetivoREGISTRODouble() {
        return D_registros[objetivoDouble];
    }
    public String getObjetivoREGISTRO() {
        return E_registros[objetivoEntero];
    }

    /* Regresa los n registos siguientes "disponibles" */
    public String[] getNsiguientes(int n) {
        String[] siguientes = new String[n];

        for (int i = 0; i < n; i++) {
            siguientes[i] = E_registros[(objetivoEntero + i) % E_registros.length];
        }
        return siguientes;
    }
    /* Regresa los n registos Double siguientes "disponibles" */
    public String[] getNsiguientesD(int n) {
        String[] siguientes = new String[n];

        for (int i = 0; i < n; i++) {
            siguientes[i] = D_registros[(objetivoDouble + i) % D_registros.length];
        }
        return siguientes;
    }

	public String siguienteCadenaTemporal() {
        String aux = "temp"+stringTemporal;
        stringsTemporales.add(aux); 
        stringTemporal++ ; 
        return aux;
	}

	public String siguienteEtiquetaIguales() {
        String aux = "iguales"+igualesTemporal; 
        return aux;
	}

	public String siguienteEtiquetaIgualesTRUE() {
        String aux = "igualesTRUE"+igualesTemporal; 
        return aux;
	}

	public String siguienteEtiquetaIgualesFALSE() {
		String aux = "igualesFALSE"+igualesTemporal; 
        return aux;
	}

	public String siguienteEtiquetaIgualesFIN() {
		String aux = "igualesFIN"+igualesTemporal;        
        return aux;
	}
}
