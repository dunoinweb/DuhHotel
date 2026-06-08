package Hotel.menu

import Hotel.auth.usuarioLogado
import Hotel.reservas.menuReservas
import Hotel.hospedes.menuHospedes
import Hotel.abastecimento.menuAbastecimento

fun menuPrincipal() {
    while (true) {
        println("""
            ===== MENU PRINCIPAL =====
            1 - Reservas de Quartos
            2 - Cadastro de Hóspedes
            3 - Abastecimento
            4 - Sair
        """.trimIndent())

        when (readln()) {
            "1" -> menuReservas()
            "2" -> menuHospedes()
            "3" -> menuAbastecimento()
            "4" -> {
                println("Muito obrigado e até logo, $usuarioLogado.")
                return
            }
            else -> println("Opção inválida.")
        }
    }
}