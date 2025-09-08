package `2`

fun countNums(nums: Array<Int>) : Map<Int, Int>{
    var res = mutableMapOf<Int, Int>()

    for (n in nums){
        res[n] = 0
    }

    for (m in nums){
        res[m] = res[m]!! + 1
    }

    return res
}

fun main(){
    var inp = arrayOf<Int>()
    var n: Int = readln().toInt()
    for (i in 1..n){
        var temp : Int = readln().toInt()
        inp += temp
    }
    var res : Map<Int, Int> = countNums(inp)

    println(res)
}