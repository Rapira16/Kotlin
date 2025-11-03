import java.time.LocalDate
import java.time.format.DateTimeFormatter

enum class Gender {
    Male, Female
}

class FormValidator {

    fun validateName(name: String) {
        if (name.length !in 2..20) {
            throw IllegalArgumentException("длина должна быть от 2 до 20")
        }
        if (!name[0].isUpperCase()) {
            throw IllegalArgumentException("имя с заглавной буквы.")
        }
    }

    fun validateBirthDate(date: String) {
        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
        val birthDate = try {
            LocalDate.parse(date, formatter)
        } catch (e: Exception) {
            throw IllegalArgumentException("Ошибка: неверный формат даты. Используйте dd.MM.yyyy.")
        }

        val minDate = LocalDate.of(1900, 1, 1)
        val now = LocalDate.now()
        if (birthDate.isBefore(minDate) || birthDate.isAfter(now)) {
            throw IllegalArgumentException("дата от 01.01.1900")
        }
    }


    fun validateGender(gender: String) {
        try {
            Gender.valueOf(gender)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Male или Female")
        }
    }

    fun validateWeight(weight: String) {
        try {
            val w = weight.toDouble()
            if (w <= 0) {
                throw IllegalArgumentException("вес больше 0")
            }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("вес - число")
        }
    }

    fun validateForm(name: String, date: String, gender: String, weight: String) {
        validateName(name)
        validateBirthDate(date)
        validateGender(gender)
        validateWeight(weight)
    }
}

fun main() {
    val validator = FormValidator()

    println("Введите имя:")
    val name = readln()

    println("Введите дату рождения:")
    val birthDate = readln()

    println("Введите пол")
    val gender = readln()

    println("Введите веc")
    val weight = readln()

    try {
        validator.validateForm(name, birthDate, gender, weight)
        println("\nВсе харащё")
    } catch (e: IllegalArgumentException) {
        println("\n${e.message}")
    }
}
