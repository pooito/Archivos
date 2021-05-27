package clases.poo.ito;

public class Libro {
	
	private int id;
	private String isbn;
	private String titulo;
	private int paginas;
	private boolean disponible;
	
	public Libro() {
		super();
	}
	
	public Libro(int id, String isbn, String titulo, int paginas, boolean disponible) {
		super();
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.paginas = paginas;
		this.disponible = disponible;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", isbn=" + isbn + ", titulo=" + titulo + ", paginas=" + paginas + ", disponible="
				+ disponible + "]";
	}
	

}
