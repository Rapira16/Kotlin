fun main() {
    data class User(val name: String, val age: Int, val friends: List<String>)

    val userList = object {
        val users = listOf(
            User("Соколов", 18, listOf("Медведев", "Шматко")),
            User("Зубов", 38, listOf("Зубова", "Колобков")),
            User("Шматко", 45, listOf("Данилюк", "Соколов")),
            User("Бородин", 50, listOf("Колобков", "Зубов"))
        )

        fun getOldestUser(): User {
            return users.maxByOrNull { it.age }!!
        }

        fun printAllUsers() {
            for (user in users) {
                println("${user.name}, возраст: ${user.age}, друзья: ${user.friends.joinToString()}")
            }
        }
    }

    println("Список всех")
    userList.printAllUsers()

    val oldest = userList.getOldestUser()
    println("\nСамый старый")
    println("${oldest.name}, возраст: ${oldest.age}")
}
