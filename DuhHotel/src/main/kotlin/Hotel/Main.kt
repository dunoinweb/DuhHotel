package Hotel

import Hotel.auth.login
import Hotel.menu.menuPrincipal

const val NOME_HOTEL = "DuhHotel"

fun main() {
    if (login()) {
        menuPrincipal()
    }
}