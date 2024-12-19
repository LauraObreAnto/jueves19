package cortarconexión;

import java.util.Scanner;



public class Scannerfactura {

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in);

			Facturarepository repositorio = new Facturarepository();
				try {
				System.out.println("Introduzca los parámetros correspondientes");
				System.out.println("Numero");
				int numero = sc.nextInt();
				System.out.println("Concepto");
				String concepto = sc.next();
				System.out.println("Importe");
				double importe = sc.nextDouble();
				repositorio.insertar(numero, concepto, importe);
			
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
