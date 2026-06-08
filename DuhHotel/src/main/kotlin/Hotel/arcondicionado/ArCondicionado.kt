package Hotel.arcondicionado

data class OrcamentoAr(
    val empresa: String,
    val total: Double
)

fun menuArCondicionado() {
    println("[Ar-Condicionado]")

    val orcamentos = mutableListOf<OrcamentoAr>()

    var continuar: String

    do {
        print("Nome da empresa: ")
        val empresa = readln()

        print("Valor por aparelho: ")
        val valorPorAparelho = readln().toDoubleOrNull()
        if (valorPorAparelho == null || valorPorAparelho <= 0) {
            println("Valor inválido.")
            return
        }

        print("Quantidade de aparelhos: ")
        val quantidade = readln().toIntOrNull()
        if (quantidade == null || quantidade <= 0) {
            println("Quantidade inválida.")
            return
        }

        print("Percentual de desconto (%): ")
        val percentualDesconto = readln().toDoubleOrNull()
        if (percentualDesconto == null || percentualDesconto < 0) {
            println("Desconto inválido.")
            return
        }

        print("Quantidade mínima para desconto: ")
        val minimoParaDesconto = readln().toIntOrNull()
        if (minimoParaDesconto == null || minimoParaDesconto < 0) {
            println("Quantidade mínima inválida.")
            return
        }

        print("Valor fixo de deslocamento: ")
        val deslocamento = readln().toDoubleOrNull()
        if (deslocamento == null || deslocamento < 0) {
            println("Deslocamento inválido.")
            return
        }

        val total = calcularTotalServico(
            valorPorAparelho,
            quantidade,
            percentualDesconto,
            minimoParaDesconto,
            deslocamento
        )

        println("O serviço de $empresa custará R$ %.2f".format(total))

        orcamentos.add(
            OrcamentoAr(empresa, total)
        )

        print("Deseja informar novos dados? (S/N): ")
        continuar = readln().uppercase()

    } while (continuar == "S")

    if (orcamentos.size >= 2) {
        exibirResumo(orcamentos)
    }
}

private fun calcularTotalServico(
    valorPorAparelho: Double,
    quantidade: Int,
    percentualDesconto: Double,
    minimo: Int,
    deslocamento: Double
): Double {

    val bruto = valorPorAparelho * quantidade

    val desconto = if (quantidade >= minimo) {
        bruto * (percentualDesconto / 100)
    } else {
        0.0
    }

    return bruto - desconto + deslocamento
}

private fun exibirResumo(orcamentos: List<OrcamentoAr>) {
    val menor = orcamentos.minBy { it.total }
    val maior = orcamentos.maxBy { it.total }

    val diferencaPercentual =
        ((maior.total - menor.total) / maior.total) * 100

    println("\nResumo final:")
    println("Menor orçamento: ${menor.empresa} — R$ %.2f".format(menor.total))
    println("Maior orçamento: ${maior.empresa} — R$ %.2f".format(maior.total))
    println("Diferença percentual: %.2f%%".format(diferencaPercentual))
}