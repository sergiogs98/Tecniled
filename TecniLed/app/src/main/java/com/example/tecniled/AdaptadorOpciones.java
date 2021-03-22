package com.example.tecniled;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


//Definimos el Adaptador que dibuja la opciones del listado de la ListActivity
class AdaptadorOpciones extends RecyclerView.Adapter<OpcionViewHolder> implements View.OnClickListener
{
	// Vector para guardar los datos
	private Opcion[] datos = new Opcion[6];

	//Variable para guardar la referencia al metodo onClick para llamarlo cuando sea necesario
	private View.OnClickListener listener;

	// Contructor del adaptador usando el vector de datos de tipo Opcion
	AdaptadorOpciones(Opcion[] datos){
		// No es necesario llamar al constructor de la clase superior

		// Guardamos estas variables de la aplicación principal para usarlas luego
		this.datos = datos;
	}


	// Metodo para establecer el evento onClick de la lista
	public void setOnClickListener(View.OnClickListener listener){
		this.listener = listener;
	}

	@Override
	// Metodo que se ejecuta cuando se invoca el evento onClick
	public void onClick(View v) {
		// Solo se invoca si es establecido previamente
		if (listener != null){
			listener.onClick(v);
		}
	}

	@NonNull
	@Override
	// Evento que se lanza cuando ya es necesario dibujar una opcion del listado
	public com.example.tecniled.OpcionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		// Inflamos la opción con el layout correspondiente
		View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.opcion, parent, false);

		// Establecemos el evento onClick de la opción
		itemView.setOnClickListener(this);

		// Definimos la nueva opción a partir del elemento anterior
		com.example.tecniled.OpcionViewHolder ovh = new com.example.tecniled.OpcionViewHolder(itemView);

		// Devolvemos ya la opción dentro la clase OpcionViewHolder
		return ovh;
	}

	@Override
	// Metodo que se lanza cada vez que android debe dibujar una opcion en una determinada posicion
	public void onBindViewHolder(@NonNull com.example.tecniled.OpcionViewHolder holder, int position) {
		// Simplemente optenemos los datos en esa posición
		Opcion item = datos[position];

		// Añadimos (bind=ligamos) al ViewHolder los datos
		holder.bindOpcion(item);
	}

	@Override
	// Devuelve el nº de elementos de la lista
	public int getItemCount() {
		return datos.length;
	}
} // end class AdaptadorOpciones

// Clase que se usa para almacenar el titulo, un icono de tipo ImageView de una opción y la opcion check
class OpcionViewHolder extends RecyclerView.ViewHolder {
	private TextView titulo;
	private ImageView icono;
	private CheckBox check;

	public OpcionViewHolder(View itemView){
		super(itemView);

		titulo = (TextView)itemView.findViewById(R.id.LblTitulo);
		check = (CheckBox)itemView.findViewById(R.id.check);
	}

	public void bindOpcion(Opcion t)
	{
		titulo.setText(t.getTitulo());
		check.setChecked(t.isCheck());
	}
}

