package `3`

fun PasswordGenerator(len : Int) : String{
    val charArray = charArrayOf(
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
        'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        '_', '*', '-'
    )
    var password = ""

    for (i in 0 until len){
        var symbolIndex = (0 until charArray.size).random()
        password += charArray[symbolIndex]
    }

    return password
}

fun main(){
    print("Введите длину пароля: ")
    var len = readln().toInt()
    while (len < 8){
        println("Пароль с ${len} количеством символов небезопасен")
        print("Введите длину пароля заново: ")
        len = readln().toInt()
    }
    println("Ваш пароль длинной ${len} символов")
    print(PasswordGenerator(len))
}