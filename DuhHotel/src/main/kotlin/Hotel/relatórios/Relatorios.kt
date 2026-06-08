package Hotel.relatorios

import Hotel.reservas.reservas
import Hotel.reservas.quartos
import Hotel.eventos.eventosConfirmados
import Hotel.hospedes.getQuantidadeHospedes

fun menuRelatorios() {
    println("\n[Relatórios Operacionais]\n")

    val totalReservas = reservas.size
    val quartosOcupados = quartos.count { it }
    val taxaOcupacao = (quartosOcupados / 20.0) * 100

    val totalHospedes = getQuantidadeHospedes()
    val totalEventos = eventosConfirmados.size

    val receitaHospedagem = reservas.sumOf { it.total }
    val receitaEventos = eventosConfirmados.sumOf { it.total }
    val receitaTotal = receitaHospedagem + receitaEventos

    println("""
        +-------------------------------------------+
        |           RELATÓRIO OPERACIONAL           |
        +-------------------------------------------+
        | Reservas de quartos confirmadas | %5d |
        | Taxa de ocupação atual          | %5.1f%% |
        | Hóspedes cadastrados            | %5d |
        | Eventos confirmados             | %5d |
        +-------------------------------------------+
        | Receita hospedagem              | R$ %8.2f |
        | Receita eventos                 | R$ %8.2f |
        +-------------------------------------------+
        | RECEITA TOTAL                   | R$ %8.2f |
        +-------------------------------------------+
    """.trimIndent().format(
        totalReservas,
        taxaOcupacao,
        totalHospedes,
        totalEventos,
        receitaHospedagem,
        receitaEventos,
        receitaTotal
    ))
}