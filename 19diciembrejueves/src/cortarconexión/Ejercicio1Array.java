package cortarconexión;

import java.util.ArrayList;

public class Ejercicio1Array {
	public static void main(String[] args) {
		
	Facturarepository repo=new Facturarepository();
	
	ArrayList<Factura> lista= repo.buscarTodos();
	
	for(Factura f: lista) {
		System.out.println(f.getNumero());
		System.out.println(f.getConcepto());
		System.out.println(f.getImporte());
	}
}
}
