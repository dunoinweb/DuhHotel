package Hotel.eventos

import kotlin.math.ceil
import kotlin.math.floor

data class Evento(
    val empresa: String,
    val convidados: Int,
    val auditorio: String,
    val dia: String,
    val horaInicio: Int,
    val horaFim: Int,
    val total: Double
)

/* =========================
   USADO PELOS RELATÓRIOS
   ========================= */
val eventosConfirmados = mutableListOf<Evento>()

fun menuEventos() {
    println("[Eventos]")

    /* ========= PARTE A — AUDITÓRIO ========= */

    print("Convidados: ")
    val convidados = readln().toIntOrNull()

    if (convidados == null || convidados < 0 || convidados > 350) {
        println("Número de convidados inválido")
        return
    }

    val auditorio: String
    val cadeirasExtras: Int

    if (convidados <= 220) {
        auditorio = "Laranja"
        cadeirasExtras = if (convidados > 150) convidados - 150 else 0
    } else {
        auditorio = "Colorado"
        cadeirasExtras = 0
    }

    if (cadeirasExtras > 0) {
        println("Auditório selecionado: $auditorio ($cadeirasExtras cadeiras adicionais)")
    } else {
        println("Auditório selecionado: $auditorio")
    }

    /* ========= PARTE B — AGENDA ========= */

    print("Dia da semana: ")
    val dia = readln().lowercase()

    print("Hora inicial: ")
    val horaInicio = readln().toIntOrNull() ?: return

    print("Duração (horas): ")
    val duracao = readln().toIntOrNull()

    if (duracao == null || duracao !in 1..12) {
        println("Duração inválida")
        return
    }

    val horaFim = horaInicio + duracao

    val limite = when (dia) {
        "segunda", "terca", "quarta", "quinta", "sexta" -> 23
        "sabado", "domingo" -> 15
        else -> {
            println("Dia inválido")
            return
        }
    }

    if (horaInicio < 7 || horaFim > limite) {
        println("Auditório indisponível")
        return
    }

    print("Empresa: ")
    val empresa = readln()

    println("Status: Auditório reservado.")

    /* ========= PARTE C — GARÇONS ========= */

    val baseGarcons = ceil(convidados / 12.0).toInt()
    val reforcoGarcons = floor(duracao / 2.0).toInt()
    val totalGarcons = baseGarcons + reforcoGarcons

    val custoGarcons = totalGarcons * duracao * 10.50

    println("Garçons necessários: $totalGarcons")
    println("Custo com garçons: R$ %.2f".format(custoGarcons))

    /* ========= PARTE D — BUFFET ========= */

    val cafe = convidados * 0.2
    val agua = convidados * 0.5
    val salgados = convidados * 7

    val custoBuffet =
        (cafe * 0.80) +
                (agua * 0.40) +
                ((salgados / 100.0) * 34.0)

    println("""
        Buffet:
        Café: %.1f L
        Água: %.1f L
        Salgados: %d un
        Custo buffet: R$ %.2f
    """.trimIndent().format(cafe, agua, salgados, custoBuffet))

    /* ========= PARTE E — RELATÓRIO ========= */

    val totalEvento = custoGarcons + custoBuffet

    println("Total do evento: R$ %.2f".format(totalEvento))
    print("Confirmar reserva? (S/N): ")

    if (readln().uppercase() == "S") {
        eventosConfirmados.add(
            Evento(
                empresa = empresa,
                convidados = convidados,
                auditorio = auditorio,
                dia = dia,
                horaInicio = horaInicio,
                horaFim = horaFim,
                total = totalEvento
            )
        )
        println("Reserva efetuada com sucesso.")
    } else {
        println("Reserva não efetuada.")
    }
}