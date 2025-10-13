package `7`

fun main() {
    val ebook1 = EBook("Цветы для элджернона", 2048000L, 500)
    ebook1.metadata = ResourceMetadata("Дэниел Киз", "1957-04-07")

    val ebook2 = EBook("Понедельник начинается в субботу", 300)

    val audiobook = AudioBook("Метро 2033", 5120000L, 480)
    audiobook.metadata = ResourceMetadata("Дмитрий Глуховский", "1979-06-12")

    val audiobook2 = AudioBook("Пикник на обочине", 3072000L, 360)

    println(ebook1.getDescription())
    println(ebook1.pageCount)
    println(ebook1.isDownloadable)
    println(ebook1.metadata?.author)

    println(ebook2.getDescription())
    println(ebook2.pageCount)
    println(ebook2.isDownloadable)

    println(audiobook.getDescription())
    println(audiobook.isDownloadable)
    println(audiobook.metadata?.author)

    println(audiobook2.getDescription())
    println(audiobook2.isDownloadable)
}