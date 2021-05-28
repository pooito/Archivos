package ito.poo.clases;

import java.io.RandomAccessFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Persistencia {

	private RandomAccessFile archivo;
	
	public Persistencia(String archivo) throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
		this.archivo= new RandomAccessFile(archivo,"rw");
	}
	
	public void addProducto(Producto p) throws IOException {
		archivo.seek(archivo.length());
		archivo.writeInt(p.getId());
		archivo.writeUTF(p.getDescripcion());
		archivo.writeFloat(p.getPrecio());
		archivo.writeInt(p.getExistencias());
		archivo.writeUTF(p.getActualizacion().toString());
	}
	
	public void close() throws IOException {
		archivo.close();
	}
	
	public Producto getProducto() throws IOException {
		Producto p= null;
		if(archivo.getFilePointer()!=archivo.length()) {
			p = new Producto();
			p.setId(archivo.readInt());
			p.setDescripcion(archivo.readUTF());
			p.setPrecio(archivo.readFloat());
			p.setExistencias(archivo.readInt());
			String fecha=archivo.readUTF();
			Scanner s= new Scanner(fecha);
			s.useDelimiter("-"); 
			p.setActualizacion(LocalDate.of(s.nextInt(),s.nextInt(),s.nextInt()));
		}	
		return p;
	}
	
	public boolean isEOF() throws IOException {
		boolean prueba=false;
		if(archivo.length()==archivo.getFilePointer())
			prueba=true;
		return prueba;
	}
	
	public Producto getProducto(int i) throws IOException {
		Producto p = null;
		archivo.seek(0);
		for(int j=1;j<=i;j++) {
			p=getProducto();
			if(j!=i && isEOF()) {
				p=null;
				break;
			}
		}
		return p;
	}
	
	
	

}
