package `7`

class AudioBook(
    override val title: String,
    fileSizeInBytes: Long,
    val duration: Int
) : DigitalResource(fileSizeInBytes) {

    override val isDownloadable: Boolean
        get() = false

    override fun getDescription(): String {
        return "Аудиокнига: $title. Время прослушивания: $duration мин."
    }
}