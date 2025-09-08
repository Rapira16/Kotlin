package `2`

fun average(s: Int, nums: Array<Double>) : Double{
    var sum = 0.0
    for (n in nums){
        sum += n
    }
    return sum / s
}

fun main() {
    var inp = arrayOf<Double>()
    var n: Int = readln().toInt()
    for (i in 1..n){
        var temp : Double = readln().toDouble()
        inp += temp
    }

    println(average(n, inp))
}