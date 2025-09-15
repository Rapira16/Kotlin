package `3`

fun game(){
    var computerGuess = (0..1000).random()
    print("\nВведите число: ")
    var cur = readln().toInt()
    while (cur >= 0){
        if (cur > computerGuess) println("Это число больше загаданного")
        else if (cur < computerGuess) println("Это число меньше загаданного")
        else {
            println("Победа")
            return
        }
        print("Введите число: ")
        cur = readln().toInt()
    }
    println("Вы вышли из игры без победы")
}

fun main(){
    println("Игра в угадай число")
    println("Правила:")
    println("Компьютер загадывает число от 0 до 1000")
    println("Вы должны отгадать число")
    println("Если угадали, то выводится Победа")
    println("Если ваше число меньше - Это число меньше загаданного")
    println("Если ваше число больше - Это число больше загаданного")
    println("Для выхода вбейте отрицательное число")
    game()
}