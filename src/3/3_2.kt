package `3`

fun ToMorseCode(word : String) : String{
    var result = ""
    val codes = arrayOf<String>(".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", ".-.", "...", "-", "..-", "..-.", "....", "-.-.", "---.", "----",
        "--.-", "--.--", "-.--", "-..-", "..-..", "..--", ".-.-")
    for (symbol in word){
        val symbolCode = symbol.code - 'А'.code
        result += codes[symbolCode] + " "
    }
    return result
}

fun main(){
    print("Введите слово для кодировки в код Морзе: ")
    val word = readln()
    println("Закодированное слово")
    print(ToMorseCode(word))
}