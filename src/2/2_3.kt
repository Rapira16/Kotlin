package `2`

fun duplicates(nums: Array<String>) : String{
    var res = arrayOf<String>()

    for (n in nums){
        if (n !in res){
            res += n
        } else {
            return n
        }
    }
    return ""
}

fun main(){
    var inp = arrayOf<String>()
    var n: Int = readln().toInt()
    for (i in 1..n){
        var temp : String = readln()
        inp += temp
    }

    println(duplicates(inp))
}