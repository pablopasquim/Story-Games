package br.com.talquinho.pablogames.main
import br.com.talquinho.pablogames.services.ApiServices
import br.com.talquinho.pablogames.model.Game
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    println("Enter the code to search for:")
    val search = scanner.nextLine()

    val apiService = ApiServices()

    val result = runCatching {
        val gameInfo = apiService.getGame(search)
        Game(gameInfo.info.title, gameInfo.info.thumb)
    }

    result.onFailure {
        println("An error occurred while fetching the game. Please try another ID!")
        return
    }

    val myGame = result.getOrNull()

    result.onSuccess {
        println("Would you like to add a description? Y/N")
        val option = scanner.nextLine()
        if (option.equals("y", true)) {
            print("Enter a description: ")
            myGame?.description = scanner.nextLine()
        } else {
            myGame?.description = myGame?.title

        }
        println(myGame)
    }
}
