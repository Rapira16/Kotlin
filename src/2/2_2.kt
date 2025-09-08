package `2`

fun countNums(nums: Array<Int>, n : Int) {
    var count = 1
    var cur = nums[0]

    for (i in 1..n-1) {
        if (nums[i] == cur) {
            count++
        } else {
            println("$count $cur")
            count = 1
            cur = nums[i]
        }
    }

    // Выводим последний элемент
    println("${count} ${cur}")
}

fun main(){
    var inp = arrayOf<Int>()
    var n: Int = readln().toInt()
    for (i in 1..n){
        var temp : Int = readln().toInt()
        inp += temp
    }
    countNums(inp, n)
}