package `4`

import `3`.game

val wordsForHangman = listOf(
    "КОТ", "ДОМ", "СОН", "ЛЕС", "МЯЧ", "СЫР", "НОС", "РОТ", "ДУБ", "МАК",
    "ЯБЛОКО", "СОЛНЦЕ", "КНИГА", "ШКОЛА", "РЕКА", "СТОЛ", "ОКНО", "ДВЕРЬ", "КОШКА", "СОБАКА",
    "ТЕЛЕФОН", "МАШИНА", "УЧЕНИК", "СТОЛИЦА", "ПОГОДА", "МОРОЖЕНОЕ", "ТЕЛЕВИЗОР", "КОМПЬЮТЕР",
    "ЭЛЕКТРИЧЕСТВО", "ДОСТОПРИМЕЧАТЕЛЬНОСТЬ", "ПАРАЛЛЕЛЕПИПЕД", "ТРАНСПОРТ"
)

fun tries(count : Int){
    when(count){
        0 -> println("""
            -------
            |
            |
            |
            __
        """.trimIndent())
        1 -> println("""
            -------
            |     0
            |
            |
            __
        """.trimIndent())
        2 -> println("""
            -------
            |     0
            |     |
            |
            __
        """.trimIndent())
        3 -> println("""
            -------
            |     0
            |    -|
            |
            __
        """.trimIndent())
        4 -> println("""
            -------
            |     0
            |    -|-
            |
            __
        """.trimIndent())
        5 -> println("""
            -------
            |     0
            |    -|-
            |    /
            __
        """.trimIndent())
        6 -> println("""
            -------
            |     0
            |    -|-
            |    / \
            __
        """.trimIndent())
    }
}

fun Hangman(){
    var comWord = wordsForHangman.random().toCharArray()
    var cur = CharArray(comWord.size){ '_' }
    var tries = 0
    tries(tries)

    while (!cur.contentEquals(comWord)){
        for (c in cur){
            print(c)
        }
        println("\nБуква: ")
        var curLet = readln()
        if (curLet[0] in comWord){
            for(i in comWord.indices)
            if (comWord[i] == curLet[0]){
                cur[i] = comWord[i]
            }
            tries(tries)
        } else {
            tries++
            if (tries > 5) {
                tries(6)
                println("Ты проиграл. Было слово")
                for (l in comWord) {
                    print(l)
                }
                return
            }
            tries(tries)
        }
    }
    println("Вы победил дон!")
}

fun main(){
    println("""
        Это игра в виселицу
        Компьютер загадал слово
        Напишите любую букву из русского алфавита
        У вас 6 попыток для выйгрыша
    """.trimIndent())
    Hangman()
}