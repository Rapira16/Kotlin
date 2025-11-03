package `9`

interface RepairService {
    fun canRepair(device: String): Boolean
}

class Chinilka : RepairService {
    override fun canRepair(device: String): Boolean {
        return device == "computer" || device == "phone"
    }
}

fun main() {
    val shop = Chinilka()

    println("Компьютер: ${shop.canRepair("computer")}")
    println("Телефон: ${shop.canRepair("phone")}")
    println("Планшет: ${shop.canRepair("tablet")}")
    println("Часы: ${shop.canRepair("watch")}")
}