class Student {
    private var firstName: String = ""
    private var lastName: String = ""
    private var scores: IntArray = IntArray(10) { 0 }

    fun getFirstName(): String {
        return if (firstName.isNotEmpty()) {
            firstName[0].uppercase() + firstName.substring(1)
        } else {
            firstName
        }
    }

    fun setFirstName(value: String) {
        firstName = value.trim()
    }

    fun getLastName(): String {
        return if (lastName.isNotEmpty()) {
            lastName[0].uppercase() + lastName.substring(1)
        } else {
            lastName
        }
    }

    fun setLastName(value: String) {
        lastName = value.trim()
    }

    fun getScores(): IntArray {
        val copy = IntArray(scores.size)
        for (i in scores.indices) {
            copy[i] = scores[i]
        }
        return copy
    }

    fun setScores(scores: IntArray) {
        val copy = IntArray(scores.size)
        for (i in scores.indices) {
            copy[i] = scores[i]
        }
        this.scores = copy
    }

    fun addScore(newScore: Int) {
        for (i in 0 until scores.size - 1) {
            scores[i] = scores[i + 1]
        }
        scores[scores.size - 1] = newScore
    }

    fun getAverageScore(): Double {
        if (scores.isEmpty()) return 0.0
        var sum = 0.0
        for (score in scores) {
            sum += score
        }
        return sum / scores.size
    }
}

fun main() {
    val student = Student()

    student.setFirstName("  john  ")
    student.setLastName("  doe  ")

    student.setScores(intArrayOf(5, 4, 3, 5, 4, 3, 5, 4, 3, 5))

    println("Студент: ${student.getFirstName()} ${student.getLastName()}")
    println("Текущие оценки: ${student.getScores().joinToString()}")
    println("Средний балл: ${student.getAverageScore()}")

    student.addScore(4)
    println("После добавления оценки: ${student.getScores().joinToString()}")
    println("Новый средний балл: ${student.getAverageScore()}")
}