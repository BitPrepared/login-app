package it.bitprepared.loginapp

const val RED = "rosso"
const val BLUE = "blu"
const val ORANGE = "arancio"
const val GOLD = "oro"

data class Scout(var name: String, var surname: String, var sq: String) {

    fun isTheSamePerson(otherName: String, otherSurname: String): Boolean {
        if (surname.ignoreAccents().lowercase().trim()
                != otherSurname.ignoreAccents().lowercase().trim()) return false
        if (name.ignoreAccents().lowercase().trim()
                != otherName.ignoreAccents().lowercase().trim()) return false
        return true
    }
}

fun String.ignoreAccents() = this.replace("à", "a", true)
            .replace("á", "a", true)
            .replace("ä", "a", true)
            .replace("â", "a", true)
            .replace("é", "e", true)
            .replace("è", "e", true)
            .replace("ë", "e", true)
            .replace("ê", "e", true)
            .replace("í", "i", true)
            .replace("î", "i", true)
            .replace("ï", "i", true)
            .replace("ì", "i", true)
            .replace("ô", "o", true)
            .replace("ö", "o", true)
            .replace("ò", "o", true)
            .replace("ó", "o", true)
            .replace("û", "u", true)
            .replace("ü", "u", true)
            .replace("ù", "u", true)
            .replace("ú", "u", true)