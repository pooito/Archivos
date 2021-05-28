package ito.poo.app;

import ito.poo.clases.Persistencia;
import ito.poo.clases.Producto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class MyApp {
	
	static Persistencia archivo;
	static Scanner inputTeclado= new Scanner(System.in);
	
	static void abreArchivo() throws FileNotFoundException {
	      archivo=new Persistencia("items.dat");
	}
	
	static void leerProductoTeclado() throws IOException {
		Producto p= new Producto();
		System.out.print("Proporciona id:");
		p.setId(inputTeclado.nextInt()); inputTeclado.nextLine();
		System.out.print("Proporciona Descripcion:");
		p.setDescripcion(inputTeclado.nextLine());
		System.out.print("Existencias:");
		p.setExistencias(inputTeclado.nextInt());
		System.out.print("Precio:");
		p.setPrecio(inputTeclado.nextFloat());
		p.setActualizacion(LocalDate.now());
		archivo.addProducto(p);
	}
	
	static void agregaProducto() {
		try {
		     leerProductoTeclado();
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	static void despliegaTodos() {
		try {
			int i=1;
			do {
		       Producto p=archivo.getProducto(i++);
			   System.out.println(p);
		     }while(!archivo.isEOF());
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	static void run() throws IOException  {
		abreArchivo();   // Falto esta línea
		agregaProducto();
		despliegaTodos();
		archivo.close();
	}
	
	public static void main(String [] args) throws IOException {
		run();
	}

}
