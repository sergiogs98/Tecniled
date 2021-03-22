package com.example.tecniled;

// Clase que se usa para definir las opciones del listado del ListActivity
public class Opcion {
	// Cada opción tiene un título y un icono
	private String titulo;
	private boolean check;

	public Opcion(String titulo, boolean check) {
		this.titulo = titulo;
		this.check = check;
	}

	// Definimos los getters y setters de la clase
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}
}


