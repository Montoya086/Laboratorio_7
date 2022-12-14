package gt.uvg.pokelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import gt.uvg.pokelist.databinding.ItemPokemonViewBinding
import gt.uvg.pokelist.model.PokemonResponse
import gt.uvg.pokelist.model.Result

class PokemonListAdapter(private val pokemonList: List<Result>) : RecyclerView.Adapter<PokemonListAdapter.PokemonListHolder>() {

    inner class PokemonListHolder(val binding: ItemPokemonViewBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListHolder {
        val binding = ItemPokemonViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonListHolder(binding)
    }

    override fun onBindViewHolder(holder: PokemonListHolder, position: Int) {

        val item = pokemonList[position]
        holder.binding.pokemonName.text = item.name;
        val id=position+1
        Picasso.get().load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png").into(holder.binding.pokemonPhoto)
        holder.itemView.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToDetailFragment(id)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount()=pokemonList.size
}