package gt.uvg.pokelist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.Pokemon
import gt.uvg.pokelist.repository.PokemonRepository

class DetailFragment : Fragment() {
    private val args by navArgs<DetailFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imgFront : ImageView = view.findViewById(R.id.imageView2)
        val imgBack : ImageView = view.findViewById(R.id.imageView3)
        val imgFrontS : ImageView = view.findViewById(R.id.imageView4)
        val imgBackS : ImageView = view.findViewById(R.id.imageView5)
        Picasso.get().load(args.pokemon.imageUrlFront).into(imgFront)
        Picasso.get().load(args.pokemon.imageUrlBack).into(imgBack)
        Picasso.get().load(args.pokemon.imageUrlShinnyFront).into(imgFrontS)
        Picasso.get().load(args.pokemon.imageUrlShinnyBack).into(imgBackS)
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

}