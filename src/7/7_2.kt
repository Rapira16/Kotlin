package `7`

fun main() {
    val ingredients = listOf(
        Ingredient("Помидор", false),
        Ingredient("Сыр", true),
        Ingredient("Базилик", false)
    )

    val pizza = Food("Пицца Маргарита", 500.0, ingredients)

    val coffeeSmall = Drink("Кофе", 100.0, Drink.Size.SMALL)
    val coffeeMedium = Drink("Кофе", 100.0, Drink.Size.MEDIUM)
    val coffeeLarge = Drink("Кофе", 100.0, Drink.Size.LARGE)

    println("${pizza.id} - ${pizza.name} - ${pizza.basePrice} - ${pizza.calculateFinalPrice()} - ${pizza.isVegetarian}")

    val drinks = listOf(coffeeSmall, coffeeMedium, coffeeLarge)
    println("${drinks[0].id} - ${drinks[0].name} - ${drinks[0].size} - ${drinks[0].basePrice} - ${drinks[0].calculateFinalPrice()}")
    println("${drinks[1].id} - ${drinks[1].name} - ${drinks[1].size} - ${drinks[1].basePrice} - ${drinks[1].calculateFinalPrice()}")
    println("${drinks[2].id} - ${drinks[2].name} - ${drinks[2].size} - ${drinks[2].basePrice} - ${drinks[2].calculateFinalPrice()}")
}