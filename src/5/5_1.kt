package `5`

import kotlin.random.Random

class Cat {
    private fun rest(){
        println("Sleep")
    }

    private fun voice(){
        println("Meow")
    }

    private fun feed(){
        println("Eat")
    }

    fun randomAction() {
        when (Random.nextInt(0, 3)) {
            0 -> rest()
            1 -> voice()
            2 -> feed()
        }
    }
}

fun main(){
    val cat = Cat()
    cat.randomAction()
    cat.randomAction()
    cat.randomAction()
}