package wilbert.jr11.recetario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var countries : MutableList<Recetario> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fab_new)
        initData()

        val adapter = RecetarioAdapter(countries)

        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )



        //Variables para el elemento nuevo
        var _id : Int = 0
        var _name : String
        var _capital : String
        var _continent : String
        var _flag : String
        var _image : String

        fab.setOnClickListener {


            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_recetas, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_country_id)
            val newName = parentView.findViewById<EditText>(R.id.bsd_country_name)
            val newCapital = parentView.findViewById<EditText>(R.id.bsd_country_capital)
            val newFlag = parentView.findViewById<EditText>(R.id.bsd_country_flag)
            val newImage = parentView.findViewById<EditText>(R.id.bsd_country_image)
            val newContinent = parentView.findViewById<EditText>(R.id.bsd_country_continent)

            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _name = newName.text.toString()
                _capital = newCapital.text.toString()
                _flag = newFlag.text.toString()
                _image = newImage.text.toString()
                _continent = newContinent.text.toString()

                val newProductAdd = Recetario(
                    _id,
                    _name,
                    _capital,
                    _continent,
                    _flag,
                    _image
                )

                countries.add(newProductAdd)

                recyclerView.adapter?.notifyDataSetChanged()

                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        countries = mutableListOf(
            Recetario(1, "amburgesa", "carne", "comida deliciozav;khbvojenk;vnwerknvpkernovkberjobjoebrpvbepkrv", "lkjenvl", "https://s3.abcstatics.com/media/gurmesevilla/2012/01/comida-rapida-casera.jpg"),
            Recetario(2, "tacos", "carne", "comida sabroza", "eevevve", "https://img.freepik.com/vector-premium/ilustracion-comida-chatarra-dibujos-animados-lindo_403370-23.jpg?w=2000"),
            Recetario(3,"burros","carne y verduras","ni yo se","veve", "https://images.ctfassets.net/n7hs0hadu6ro/2kXdxxIdkuOGj872zosdw8/d5bb142e2182bebfcfc1d5dd1afd8c2a/comida-tipica-de-puebla-una-aventura-de-sabor.jpg?w=1257&h=835&fl=progressive&q=50&fm=jp"),
            Recetario(4, "gancotos", "chocolate", "cacao", "eveeve", "https://www.recetasnestle.com.mx/sites/default/files/2022-06/ingredientes-comida-de-mar-parrilla.jpg"),
            Recetario(5, "huevito", "huevo", "huevo crudo", "veve", "https://media.gq.com.mx/photos/5fd14d41df344f5681dd7813/16:9/w_2560%2Cc_limit/GettyImages-1255074395.jpg"),
            Recetario(6, "gancito", "mas chocolate", "cacao", "veveeve", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQMbo3O34gECO2lbq7667UyuIW0Kw--ofR5dw&usqp=CAU"),
            Recetario(7,"sushi", "algas", "cocinar arroz", "vevev", "https://www.tuhogar.com/content/dam/cp-sites/home-care/tu-hogar-redesign/recetas/general/comida-para-llevar-al-trabajo.jpg"),
            Recetario(8, "arroz", "agua", "hervir en agua", "veve", "https://www.recetasnestlecam.com/sites/default/files/2022-04/que-es-la-comida-internacional.jpg")
        )
    }
}