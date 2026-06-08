package Hotel.reservas

import Hotel.utils.formatarMoeda

data class Reserva(
    val hospede: String,
    val quarto: Int,
    val dias: Int,
    val total: Double
)

/* =====================
   ESTADO DO HOTEL
   ===================== */
val quartos = Array(20) { false }
val reservas = mutableListOf<Reserva>()

fun menuReservas() {
    println("[Reservas de Quartos]")

    print("Valor da diária: ")
    val diaria = readln().toDoubleOrNull()

    print("Quantidade de diárias (1-30): ")
    val dias = readln().toIntOrNull()

    if (diaria == null || diaria <= 0 || dias == null || dias !in 1..30) {
        println("Valor inválido")
        return
    }

    print("Nome do hóspede: ")
    val hospede = readln()

    print("Tipo de quarto (S/E/L): ")
    val tipo = readln().uppercase()

    val fator = when (tipo) {
        "S" -> 1.0
        "E" -> 1.35
        "L" -> 1.65
        else -> {
            println("Tipo inválido")
            return
        }
    }

    var quarto: Int
    while (true) {
        print("Escolha um quarto (1-20): ")
        quarto = readln().toIntOrNull() ?: continue

        if (quarto !in 1..20) {
            println("Quarto inválido.")
            continue
        }

        if (quartos[quarto - 1]) {
            println("Quarto já está ocupado.")
            listarQuartosLivres()
        } else {
            break  // ✅ SAÍDA CORRETA DO LOOP
        }
    }

    val subtotal = diaria * dias * fator
    val taxa = subtotal * 0.10
    val total = subtotal + taxa

    println("""
        Resumo:
        Hóspede: $hospede
        Quarto: $quarto
        Subtotal: ${formatarMoeda(subtotal)}
        Taxa de serviço (10%): ${formatarMoeda(taxa)}
        Total: ${formatarMoeda(total)}
    """.trimIndent())

    print("Confirma a reserva? (S/N): ")
    if (readln().uppercase() == "S") {
        quartos[quarto - 1] = true
        reservas.add(Reserva(hospede, quarto, dias, total))
        println("Reserva efetuada com sucesso.")
        exibirMapaQuartos()
    } else {
        println("Reserva não efetuada.")
    }
}

private fun listarQuartosLivres() {
    print("Quartos livres: ")
    quartos.forEachIndexed { index, ocupado ->
        if (!ocupado) print("${index + 1} ")
    }
    println()
}

private fun exibirMapaQuartos() {
    println("\nMapa de Quartos:")
    for (i in 0 until 20) {
        print(if (quartos[i]) "O " else "L ")
        if ((i + 1) % 5 == 0) println()
    }
}