package `7`

class Food(
    override val name: String,
    override val basePrice: Double,
    val ingredients: List<Ingredient>
) : MenuItem() {

    val isVegetarian: Boolean
        get() = ingredients.none { it.isAllergen }

    override fun calculateFinalPrice(): Double = basePrice
}