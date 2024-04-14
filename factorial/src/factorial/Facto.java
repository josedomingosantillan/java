package factorial;

public class Facto {
public int numero;
private int resultado=1;


public int calcular() {
	for(int i=1; i<= numero; i++) {
		resultado= resultado *i;
	}
	return resultado;
}
}
