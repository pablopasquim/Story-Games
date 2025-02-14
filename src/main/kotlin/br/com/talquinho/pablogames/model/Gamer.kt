package br.com.talquinho.pablogames.model
import kotlin.random.Random

data class Gamer(var name: String, var email: String){

    var user: String? = null
        set(value) {
            field = value
            if (internalId.isNullOrBlank()){
                makeInternalId()
            }
        }
    var dateOfBirth: String? = null
    var internalId: String? = null
        private set

    constructor(name: String,email: String, user: String, dateOfBirth: String):
            this(name,email){
                this.user = user
                this.dateOfBirth = dateOfBirth
                makeInternalId()
            }

    init {
        if(name.isNullOrBlank()){
            throw IllegalArgumentException("Name is blank")
        }
        this.email = emailValidation()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', user=$user, dateOfBirth=$dateOfBirth, internalId=$internalId)"
    }

    private fun makeInternalId(){

        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internalId = "$user#$number"
    }

    fun emailValidation(): String{

        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)) {
            return email
        } else{
            throw IllegalArgumentException("Error, invalid e-mail")
        }
    }
}
