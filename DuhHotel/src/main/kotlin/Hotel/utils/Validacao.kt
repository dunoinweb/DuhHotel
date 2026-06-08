package Hotel.utils

fun lerIntPositivo(): Int? {
    val valor = readln().toIntOrNull()
    return if (valor != null && valor > 0) valor else null
}

fun lerDoublePositivo(): Double? {
    val valor = readln().toDoubleOrNull()
    return if (valor != null && valor > 0) valor else null
}