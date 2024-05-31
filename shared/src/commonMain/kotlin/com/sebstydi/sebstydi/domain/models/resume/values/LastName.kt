import com.sebstudi.sebstudy.domain.models.resume.values.validation

data class LastName(val value:String) {
    init {
        validation(value)
    }
}