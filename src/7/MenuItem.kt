package `7`
import java.util.UUID

abstract class MenuItem {
    abstract val name: String
    abstract val basePrice: Double
    abstract fun calculateFinalPrice(): Double

    val id: String = UUID.randomUUID().toString()
}