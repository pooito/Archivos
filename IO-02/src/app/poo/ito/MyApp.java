package app.poo.ito;

import java.io.FileNotFoundException;

import clases.poo.ito.EscritorArchivoTXT;
import clases.poo.ito.LectorArchivoTXT;
import clases.poo.ito.Libro;

import java.util.ArrayList;

public class MyApp {

	static EscritorArchivoTXT archivo;
	static LectorArchivoTXT archivo2;
	static ArrayList<Libro> libro= new ArrayList<Libro>();
	
	static void crearArchivo() throws FileNotFoundException {
		archivo = new EscritorArchivoTXT("libros.txt");
	}
	
	static void grabaRegistro(Libro l) {
		archivo.writeInt(l.getId());
		archivo.writeString(l.getIsbn());
		archivo.writeString(l.getTitulo());
		archivo.writeInt(l.getPaginas());
		archivo.writeBooleanLn(l.isDisponible());
	}
	
	static void grabeRegistros() {
		Libro l;
		l= new Libro(10,"TDR8282","Java",7300,true);
		grabaRegistro(l);
		l= new Libro(20,"YR63772","Fundamentos de Java",919,false);
		grabaRegistro(l);
		l= new Libro(30,"TDR8211","Introduccion a Java",7300,true);
		grabaRegistro(l);
		l= new Libro(40,"YR63778","Fundamentos de POO",919,true);
		grabaRegistro(l);
		l= new Libro(50,"ADR8211","Introduccion a los lenguajes de programacion",7300,true);
		grabaRegistro(l);
		l= new Libro(60,"PR63778","Fundamentos de POO en Java",919,true);
		grabaRegistro(l);
	}
	
	static void run() {
		try {
		   crearArchivo();
		   grabeRegistros();
		   archivo.close();
		}catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	static void abrirArchivo() throws FileNotFoundException{
		archivo2= new LectorArchivoTXT("libros.txt");
	}
	
	static void leerArchivo() {
		Libro l = new Libro();
		while(!archivo2.isEOF()) {
			l.setId(archivo2.readInt());
			l.setIsbn(archivo2.readString());
			String tmp=archivo2.readString();
			int aux=0;
			while((aux=archivo2.readInt())==0)
				tmp+=" "+archivo2.readString();
			l.setTitulo(tmp);
			l.setPaginas(aux);
			l.setDisponible(archivo2.readBoolean());
			archivo2.isFinLinea();
			libro.add(l);
			//System.out.println(l);
		}
	}
	
	static void run2() {
		try {
		    abrirArchivo();
		    leerArchivo();
		    System.out.println(libro);
		}catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        run2();
	}

}
