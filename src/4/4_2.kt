package `4`

fun countFreq(words : Array<String>, k : Int){
    var uniq = arrayOf<String>()
    var counts = arrayOf<Int>()

    for (w in words) {
        var found = false
        for (i in uniq.indices) {
            if (uniq[i] == w) {
                counts[i] = counts[i] + 1
                found = true
                break
            }
        }
        if (!found) {
            uniq = uniq + w
            counts = counts + 1
        }
    }

    for (i in uniq.indices) {
        for (j in 0 until uniq.size - 1) {
            if (counts[j] < counts[j + 1] ||
                (counts[j] == counts[j + 1] && uniq[j].lowercase() > uniq[j + 1].lowercase())) {
                val tmpC = counts[j]
                counts[j] = counts[j + 1]
                counts[j + 1] = tmpC
                val tmpW = uniq[j]
                uniq[j] = uniq[j + 1]
                uniq[j + 1] = tmpW
            }
        }
    }
    for (i in 0 until k) {
        print(uniq[i] + " ")
    }
    println()
}

fun main(){
    println("Введите количество слов")
    var words = arrayOf<String>()
    val len = readln().toInt()
    println("Введите сами слова: ")
    for (i in 0 until len){
        var word = readln()
        words += word
    }
    println("Сколько слов вывести: ")
    val k = readln().toInt()
    countFreq(words, k)
}