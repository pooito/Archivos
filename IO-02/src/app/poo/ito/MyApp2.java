package app.poo.ito;

import clases.poo.ito.Libro;
import clases.poo.ito.EscritorObjetos;
import clases.poo.ito.LectorObjetos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MyApp2 {
	static EscritorObjetos outputFile;
	static LectorObjetos inputFile=null;
	static ArrayList<Libro> libros=null;
	
	
	static void leerLibros() throws FileNotFoundException {
		try {
		      inputFile = new LectorObjetos("libros.dat");
		      libros = new ArrayList<Libro>();
		      while(true) {
			      libros.add((Libro)inputFile.readObject());
		      }
		}catch(IOException e) {
			System.err.println(e.getMessage());
			try {
				inputFile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		catch(ClassNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
	
	static void escribeLibros() {
		try {
			outputFile = new EscritorObjetos("libros.dat");
		    for(int i=0;i<libros.size();i++)
		    	outputFile.writeObject(libros.get(i));
		    outputFile.close();
		}catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	static void run() {
		
		Libro l= new Libro(10,"TRY77383","Aprenda a programar en Java",450,true);
		libros = new ArrayList<Libro>();
		libros.add(l);
		libros.add(new Libro(20,"TRY77383","Como programar en Java",950,true));
		libros.add(new Libro(30,"TRY77383","Aprenda a programar",850,true));
		libros.add(new Libro(40,"TRY77383","Sea experto en Java",950,true));
		escribeLibros();
		
	}
	
	static void run2() throws FileNotFoundException {
		leerLibros();
		System.out.println(libros);
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
        run2();
	}

}
