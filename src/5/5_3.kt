class StudentService {
    fun findBestStudent(students: Array<Student>): Student? {
        if (students.isEmpty()) return null

        var bestStudent = students[0]
        for (i in 1 until students.size) {
            if (students[i].getAverageScore() > bestStudent.getAverageScore()) {
                bestStudent = students[i]
            }
        }
        return bestStudent
    }

    fun sortStudentsByLastName(students: Array<Student>): Array<Student> {
        for (i in 0 until students.size - 1) {
            for (j in 0 until students.size - i - 1) {
                if (students[j].getLastName() > students[j + 1].getLastName()) {
                    val temp = students[j]
                    students[j] = students[j + 1]
                    students[j + 1] = temp
                }
            }
        }
        return students
    }
}

fun main() {
    val studentService = StudentService()

    val student1 = Student().apply {
        setFirstName("john")
        setLastName("smith")
        setScores(intArrayOf(5, 5, 5, 5, 5, 5, 5, 5, 5, 5))
    }

    val student2 = Student().apply {
        setFirstName("jane")
        setLastName("adams")
        setScores(intArrayOf(4, 4, 4, 4, 4, 4, 4, 4, 4, 4))
    }

    val student3 = Student().apply {
        setFirstName("bob")
        setLastName("wilson")
        setScores(intArrayOf(5, 4, 5, 4, 5, 4, 5, 4, 5, 4))
    }

    val students = arrayOf(student1, student2, student3)

    val bestStudent = studentService.findBestStudent(students)
    println("${bestStudent?.getFirstName()} ${bestStudent?.getLastName()}: ${bestStudent?.getAverageScore()}")

    val sortedStudents = studentService.sortStudentsByLastName(students)
    sortedStudents.forEach {
        println("${it.getLastName()} ${it.getFirstName()}: ${it.getAverageScore()}")
    }
}