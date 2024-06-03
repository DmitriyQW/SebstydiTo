import com.sebstydi.sebstydi.domain.models.resume.values.validation

data class LastName(val value:String) {
    init {
        validation(value)
    }
}