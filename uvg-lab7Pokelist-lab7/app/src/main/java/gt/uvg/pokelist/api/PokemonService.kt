package gt.uvg.pokelist.api
import gt.uvg.pokelist.model.PokemonListResponse
import gt.uvg.pokelist.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path

interface PokemonService {

    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id")id:Int): Call<PokemonResponse>

    @GET("pokemon?limit=100")
    fun getPokemonList(): Call<PokemonListResponse>

}