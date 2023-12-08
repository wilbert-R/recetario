package wilbert.jr11.recetario

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecetarioAdapter(private var countries: MutableList<Recetario>): RecyclerView.Adapter<RecetarioAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_recetas, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.render(country)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    fun addNewItem(item: Recetario) {
        countries.add(item)
        notifyItemInserted(countries.size - 1)
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.receta_name)
        val capital: TextView = view.findViewById(R.id.recta_descripcion)
        val continent: TextView = view.findViewById(R.id.receta_materiales)
        val flag: ImageView = view.findViewById(R.id.receta_cantidadM)
        val image: ImageView = view.findViewById(R.id.receta_image)

        fun render(recetario: Recetario) {
            name.text = recetario.titulo + ", "
            capital.text = recetario.materiales
            continent.text = recetario.descripcion
            Picasso.get().load(recetario.cantidaM).into(flag)
            Picasso.get().load(recetario.image).into(image)
        }
    }
}