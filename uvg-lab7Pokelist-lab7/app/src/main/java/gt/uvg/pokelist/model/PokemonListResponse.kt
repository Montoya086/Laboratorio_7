package gt.uvg.pokelist.model

data class PokemonListResponse(
    val count: Int,
    val next: String,
    val results: List<Result>
)