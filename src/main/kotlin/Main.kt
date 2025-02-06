package org.example
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


fun main() {
    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146"))
        .build()
    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())
    val json = response.body()
    println(json)

    val meuJogo = Jogo()
    meuJogo.titulo = "Counter-Strike 2"
    meuJogo.capa = "https://shared.fastly.steamstatic.com/store_item_assets/steam/apps/730/ss_0f8cf82d019c614760fd20801f2bb4001da7ea77.1920x1080.jpg?t=1729703045"
    meuJogo.descricao = "Ao longo de mais de duas décadas, o Counter‑Strike ofereceu uma experiência competitiva de elite, moldada por milhões de jogadores de todo o mundo. Agora, o próximo capítulo da história do CS está prestes a começar: Counter‑Strike 2."
    println(meuJogo)

}

