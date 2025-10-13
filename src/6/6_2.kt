package `6`

class UniqueString {
    private var syms : CharArray

    constructor(syms : CharArray){
        this.syms = syms
    }

    constructor(syms : String){
        this.syms = syms.toCharArray()
    }

    fun elementIndex(i : Int) : Char{
        if (i < 0 || i >= syms.size) throw Exception("Не попал")
        else return  syms[i]
    }

    fun size() : Int{
        return syms.size
    }

    fun print(){
        println(String(syms))
    }

    fun checkIfSubstringCharArray(sub : CharArray) : Boolean{
        if (String(syms) in String(syms)) return true
        else return false
    }

    fun checkIfSubstringString(sub : String) : Boolean{
        if (sub in String(syms)) return true
        else return false
    }

    fun deleteSpaces() : String{
        return String(syms).trim()
    }

    fun reverse() : String{
        return String(syms).reversed()
    }
}

fun main(){
    val unique1 = UniqueString(charArrayOf('H', 'e', 'l', 'l', 'o'))

    println(unique1.elementIndex(3))
    println(unique1.size())
    unique1.print()

    println(unique1.checkIfSubstringCharArray(charArrayOf('e', 'l', 'h')))
    println(unique1.checkIfSubstringString("ell"))
    println(unique1.deleteSpaces())
    println(unique1.reverse())

    val unique2 = UniqueString("   Test   ")
    println(unique2.deleteSpaces())
}