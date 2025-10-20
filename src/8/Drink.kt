package `8`

enum class Drink(
    private val volume: Int,
    private  val temperature: Int
) {
    SODA(500, 10){
        override fun getName(): String {
            return "Газировка"
        }
    },
    COFFEE(100, 80){
        override fun getName(): String {
            return "Кофе"
        }
    },
    TEA(200, 80){
        override fun getName(): String {
            return "Чай"
        }
    },
    JUICE(1000, 20){
        override fun getName(): String {
            return "Сок"
        }
    },
    ALCO(500, 15){
        override fun getName(): String {
            return "Алкоголь"
        }
    };

    abstract fun getName() : String

    fun getVolume() : Int{
        return volume
    }

    fun isHot() : Boolean{
        return temperature > 60
    }

    fun printInfo(){
        print("Название: ${getName()}, Объем: ${getVolume()}, Горячий: ${isHot()}\n")
    }
}

fun main(){
    Drink.ALCO.printInfo()
    Drink.COFFEE.printInfo()
    Drink.JUICE.printInfo()
    Drink.TEA.printInfo()
    Drink.SODA.printInfo()
}