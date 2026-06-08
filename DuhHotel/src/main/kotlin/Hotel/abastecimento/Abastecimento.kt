package Hotel.abastecimento

fun menuAbastecimento() {
    println("[Abastecimento]")

    print("Wayne Oil - Preço do Álcool: ")
    val alcoolWayne = readln().toDoubleOrNull() ?: return

    print("Wayne Oil - Preço da Gasolina: ")
    val gasolinaWayne = readln().toDoubleOrNull() ?: return

    print("Stark Petrol - Preço do Álcool: ")
    val alcoolStark = readln().toDoubleOrNull() ?: return

    print("Stark Petrol - Preço da Gasolina: ")
    val gasolinaStark = readln().toDoubleOrNull() ?: return

    val resultadoWayne = melhorOpcao("Wayne Oil", alcoolWayne, gasolinaWayne)
    val resultadoStark = melhorOpcao("Stark Petrol", alcoolStark, gasolinaStark)

    println(resultadoWayne)
    println(resultadoStark)

    val custoWayne = custoFinal(alcoolWayne, gasolinaWayne)
    val custoStark = custoFinal(alcoolStark, gasolinaStark)

    val melhor = if (custoWayne < custoStark) "Wayne Oil" else "Stark Petrol"

    println("É mais barato abastecer no posto $melhor.")
}

private fun melhorOpcao(
    posto: String,
    alcool: Double,
    gasolina: Double
): String {
    val usarAlcool = alcool <= gasolina * 0.7
    val tipo = if (usarAlcool) "Álcool" else "Gasolina"
    val total = if (usarAlcool) alcool * 42 else gasolina * 42

    return "$posto: melhor opção = $tipo | Total (42L) = R$ %.2f"
        .format(total)
}

private fun custoFinal(alcool: Double, gasolina: Double): Double {
    return if (alcool <= gasolina * 0.7) alcool * 42 else gasolina * 42
}