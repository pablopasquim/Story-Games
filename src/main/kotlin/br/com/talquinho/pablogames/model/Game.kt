package br.com.talquinho.pablogames.model

data class Game(
    val title: String,
    val thumb: String
) {
    var description: String? = null

    override fun toString(): String {
        return "Info: \n" +
                "Title: $title \n" +
                "Cover: $thumb \n" +
                "Description: $description \n"
    }
}
