package `1`

import kotlin.text.iterator

fun main() {
    var dna: String = readln()
    var cA: Int = 0
    var cT: Int = 0
    var cG: Int = 0
    var cC: Int = 0

    for (c in dna) {
        when (c) {
            'A' -> cA++
            'T' -> cT++
            'G' -> cG++
            'C' -> cC++
        }
    }

    println("${cA} ${cT} ${cG} ${cC}")
}