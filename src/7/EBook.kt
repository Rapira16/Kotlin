package `7`

class EBook(override val title: String,
            fileSizeInBytes: Long,
            val pageCount: Int
) : DigitalResource(fileSizeInBytes) {

    constructor(title: String, pageCount: Int) : this(
        title = title,
        fileSizeInBytes = pageCount * 1024L,
        pageCount = pageCount
    )

    override fun getDescription(): String {
        return "Электронная книга: $title"
    }
}