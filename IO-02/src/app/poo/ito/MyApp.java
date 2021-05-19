package app.poo.ito;

import java.io.FileNotFoundException;

import clases.poo.ito.EscritorArchivoTXT;
import clases.poo.ito.LectorArchivoTXT;

public class MyApp {
	
	
	static void run() throws FileNotFoundException {
		EscritorArchivoTXT archivo= new EscritorArchivoTXT("item.txt");
		archivo.writeInt(643);
		archivo.writeString("Guillermo");
		archivo.writeString("Fernandez");
		archivo.writeInt(20);
		archivo.writeFloat(1500.40F);
		archivo.writeBooleanLn(false);
		archivo.writeInt(642);
		archivo.writeString("Laura");
		archivo.writeString("Lopez");
		archivo.writeInt(30);
		archivo.writeFloat(12500.40F);
		archivo.writeBooleanLn(true);
		
		archivo.close();
		LectorArchivoTXT archivo1= new LectorArchivoTXT("item.txt");
		while(!archivo1.isEOF()) {
		   System.out.println(archivo1.readInt());
		   System.out.println(archivo1.readString());
		   System.out.println(archivo1.readString());
		   System.out.println(archivo1.readInt());
		   System.out.println(archivo1.readFloat());
		   System.out.println(archivo1.readBoolean());
		   archivo1.isFinLinea();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
            run();
	}

}
