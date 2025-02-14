package br.com.talquinho.pablogames.model

class GameInfo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}