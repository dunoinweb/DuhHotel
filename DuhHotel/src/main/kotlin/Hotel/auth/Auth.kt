package Hotel.auth

import Hotel.NOME_HOTEL

var usuarioLogado = ""

fun login(): Boolean {
    println("Bem-vindo ao $NOME_HOTEL")

    print("Nome do usuário: ")
    usuarioLogado = readln()

    var tentativas = 0
    while (tentativas < 3) {
        print("Senha: ")
        val senha = readln()

        if (senha == "2678") {
            println("Bem-vindo ao Hotel $NOME_HOTEL, $usuarioLogado. É um imenso prazer ter você por aqui!")
            return true
        } else {
            tentativas++
            println("Senha incorreta.")
        }
    }

    println("Sistema bloqueado. Tentativas excedidas.")
    return false
}