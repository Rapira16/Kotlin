package `6`

public class TimeMeasure{
    private var hour : Int
    private var min : Int
    private var sec : Int

    fun validate(){
        if (hour !in (0..23)) throw Exception("Час неправильный")
        if (min !in (0..59)) throw Exception("Минуты неправильные")
        if (sec !in (0..59)) throw Exception("Секунды неправильные")
    }

    constructor(h : Int, m : Int, s : Int){
        this.hour = h
        this.min = m
        this.sec = s
        validate()
    }

    constructor(h : Int, m : Int) : this(h, m, 0)

    constructor(h : Int) : this(h, 0, 0)

    fun printTimeIn24(){
        println("${hour.toString().padStart(2, '0')}:" +
                "${min.toString().padStart(2, '0')}:" +
                "${sec.toString().padStart(2, '0')}")
    }

    fun printTimeIn12(){
        if (hour < 13){
            println("${hour.toString().padStart(2, '0')}:" +
                    "${min.toString().padStart(2, '0')}:" +
                    "${sec.toString().padStart(2, '0')} am")
        } else{
            hour -= 12
            println("${hour.toString().padStart(2, '0')}:" +
                    "${min.toString().padStart(2, '0')}:" +
                    "${sec.toString().padStart(2, '0')} pm")
        }
    }

    fun addTime(h : Int, m : Int, s : Int){
        sec += s
        min += m
        hour += h

        if (sec > 59){
            sec %= 60
            min += 1
        }

        if (min > 59){
            min %= 60
            hour += 1
        }

        if (hour > 23){
            hour %= 24
        }
    }
}

fun main(){
    val time1 = TimeMeasure(13, 24, 5)
    val time2 = TimeMeasure(14, 34)

    time1.addTime(11, 16, 8)

    time1.printTimeIn24()
    time2.printTimeIn12()
}