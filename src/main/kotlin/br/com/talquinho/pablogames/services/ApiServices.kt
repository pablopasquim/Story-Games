package br.com.talquinho.pablogames.services
import com.google.gson.Gson
import br.com.talquinho.pablogames.model.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ApiServices {

    fun getGame(id: String): GameInfo {
        val endpoint = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endpoint))
            .build()
        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        val json = response.body()

        val gson = Gson()

        val gameInfo = gson.fromJson(json, GameInfo::class.java)

        return gameInfo
    }
}
