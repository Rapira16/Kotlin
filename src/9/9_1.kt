package `9`

import kotlin.concurrent.thread

interface Birthable {
    fun giveBirth()
}

interface Flying {
    fun fly()
}

interface Swimming {
    fun swim()
}

abstract class Animal(val name: String) {
    var hunger = 50
    var energy = 80
    var happiness = 60

    fun eat() {
        println("$name ест")
        hunger -= 30
        if (hunger < 0) hunger = 0
        energy += 10
        if (energy > 100) energy = 100
    }

    fun sleep() {
        println("$name спит")
        energy = 100
        hunger += 20
        if (hunger > 100) hunger = 100
    }

    fun play() {
        println("$name играет")
        happiness += 20
        if (happiness > 100) happiness = 100
        energy -= 10
        if (energy < 0) energy = 0
    }

    fun showStatus() {
        println("$name: голод $hunger%, энергия $energy%, счастье $happiness%")
    }

    fun update() {
        hunger += 5
        if (hunger > 100) hunger = 100
        energy -= 3
        if (energy < 0) energy = 0

        when {
            hunger > 70 -> happiness -= 10
            energy < 30 -> happiness -= 5
            else -> happiness += 2
        }
        happiness = happiness.coerceIn(0, 100)
    }
}

class Bat : Animal("Летучая мышь"), Birthable, Flying {
    override fun giveBirth() {
        println("Летучая мышь рожает детеныша!")
    }

    override fun fly() {
        println("Летучая мышь летает медленно")
        energy -= 5
    }
}

class Dolphin : Animal("Дельфин"), Birthable, Swimming {
    override fun giveBirth() {
        println("Дельфин рожает детеныша!")
    }

    override fun swim() {
        println("Дельфин плавает быстро")
        energy -= 8
    }
}

class GoldFish : Animal("Золотая рыбка"), Birthable, Swimming {
    override fun giveBirth() {
        println("Золотая рыбка мечет икру!")
    }

    override fun swim() {
        println("Золотая рыбка плавает медленно")
        energy -= 3
    }
}

class Eagle : Animal("Орел"), Birthable, Flying {
    override fun giveBirth() {
        println("Орел откладывает яйца!")
    }

    override fun fly() {
        println("Орел летает быстро")
        energy -= 10
    }
}

fun animalMenu(animal: Animal) {
    while (true) {
        println("\n=== ${animal.name.uppercase()} ===")
        animal.showStatus()
        println("1. Покормить")
        println("2. Уложить спать")
        println("3. Поиграть")

        when (animal) {
            is Flying -> println("4. Летать")
            is Swimming -> println("4. Плавать")
            else -> println("4. Двигаться")
        }

        println("5. Рождение")
        println("0. Назад")
        print("Выберите: ")

        when (readln()) {
            "1" -> animal.eat()
            "2" -> animal.sleep()
            "3" -> animal.play()
            "4" -> {
                when (animal) {
                    is Flying -> animal.fly()
                    is Swimming -> animal.swim()
                    else -> println("${animal.name} двигается")
                }
            }
            "5" -> {
                if (animal is Birthable) {
                    animal.giveBirth()
                } else {
                    println("Это животное не имеет особого способа рождения")
                }
            }
            "0" -> break
            else -> println("Неверный выбор!")
        }
        animal.update()
    }
}

fun main() {
    val animals = listOf(
        Bat(),
        Dolphin(),
        GoldFish(),
        Eagle()
    )

    thread(isDaemon = true) {
        while (true) {
            Thread.sleep(5000)
            animals.forEach { it.update() }
        }
    }

    while (true) {
        println("\n=== ЗООПАРК ===")
        println("1. Показать всех животных")
        println("2. Выбрать животное")
        println("3. Выйти")
        print("Выберите: ")

        when (readln()) {
            "1" -> {
                println("\n=== ЖИВОТНЫЕ ===")
                animals.forEach { it.showStatus() }
            }
            "2" -> {
                println("\nВыберите животное:")
                animals.forEachIndexed { index, animal ->
                    println("${index + 1}. ${animal.name}")
                }
                print("Ваш выбор: ")
                val choice = readlnOrNull()?.toInt()

                if (choice != null && choice in 1..animals.size) {
                    val animal = animals[choice - 1]
                    animalMenu(animal)
                } else {
                    println("Неверный выбор!")
                }
            }
            "3" -> {
                println("Чао")
                break
            }
            else -> println("Неверный выбор!")
        }
    }
}