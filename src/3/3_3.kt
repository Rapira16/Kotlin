package `3`

fun PasswordGenerator(len: Int): String {
    val up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val low = "abcdefghijklmnopqrstuvwxyz"
    val num = "0123456789"
    val special = "_*-"

    val allChars = up + low + num + special

    var pass = arrayOf<Char>()
    pass += up.random()
    pass += low.random()
    pass += num.random()
    pass += special.random()
    for (i in 4 until len) {
        pass += allChars.random()
    }
    pass.shuffle()

    return pass.joinToString("")
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