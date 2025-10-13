package `7`

abstract class DigitalResource(val fileSizeInBytes: Long) {

    abstract val title: String

    abstract fun getDescription(): String

    open val isDownloadable: Boolean
        get() = true

    var metadata: ResourceMetadata? = null
}