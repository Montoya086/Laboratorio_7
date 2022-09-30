package gt.uvg.pokelist.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gt.uvg.pokelist.R
import gt.uvg.pokelist.model.PokemonResponse
import gt.uvg.pokelist.api.PokemonService
import gt.uvg.pokelist.api.RetrofitInstance
import gt.uvg.pokelist.model.PokemonListResponse
import gt.uvg.pokelist.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainFragment: Fragment(/*R.layout.fragment_main*/) {

    var bandera = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //api
        var pokemonList: List<Result>
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        RetrofitInstance.api.getPokemonList().enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    pokemonList=response.body()!!.results
                    recyclerView.layoutManager = LinearLayoutManager(view.context);
                    recyclerView.adapter = PokemonListAdapter(pokemonList)
                    recyclerView.setHasFixedSize(true)
                }

            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                Log.i("RESPONSE FAILURE", t.message.toString())
            }
        })


        //super.onViewCreated(view, savedInstanceState)

        //val pokemonList = PokemonRepository().getPokemonList()

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}