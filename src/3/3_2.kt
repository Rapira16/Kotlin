package `3`

fun ToMorseCode(word : String) : String{
    var result = ""
    var codes = arrayOf<String>(".-", "-...", ".--", "--.", "-..", ".", "...-", "--..", "..", ".---",
        "-.-", ".-..", "--", "-.", "---", ".--.", ".-.", "...", "-", "..-", "..-.", "....", "-.-.", "---.", "----",
        "--.-", "--.--", "-.--", "-..-", "..-..", "..--", ".-.-")
    for (symbol in word){
        var symbolCode = symbol.code - 'А'.code
        result += codes[symbolCode] + " "
    }
    return result
}

fun main(){
    print("Введите слово для кодировки в код Морзе: ")
    var word = readln()
    println("Закодированное слово")
    print(ToMorseCode(word))
}