package br.com.talquinho.pablogames.main
import br.com.talquinho.pablogames.model.Gamer
import kotlin.random.Random

fun main(){

    val gamer1 = Gamer("Pablo", "pablo.pasquim@gmail.com")
    println(gamer1)

    gamer1.let {
        it.dateOfBirth = "10/09/1998"
        it.user = "fazzer"
    }.also {
        println(gamer1.internalId)
    }

    println(gamer1)
    gamer1.user = "sub12"
    println(gamer1)
}