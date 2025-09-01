fun main() {
    var n: Int = readln().toInt()
    var c8 = n / 8
    n %= 8
    var c4 = n / 4
    n %= 4
    var c2 = n / 2
    n %= 2
    var c1 = n

    println("${c8} ${c4} ${c2} ${c1}")
}