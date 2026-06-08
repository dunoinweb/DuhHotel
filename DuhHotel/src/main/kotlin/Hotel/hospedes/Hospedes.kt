package Hotel.hospedes

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Hospede(
    var nome: String,
    val dataCadastro: LocalDateTime
)

private const val LIMITE_HOSPEDES = 15
private val hospedes = mutableListOf<Hospede>()

fun menuHospedes() {
    while (true) {
        println("""
            [Cadastro de Hóspedes]
            1 - Cadastrar
            2 - Pesquisar por nome exato
            3 - Pesquisar por prefixo
            4 - Listar ordenado (A-Z)
            5 - Atualizar cadastro
            6 - Remover cadastro
            7 - Voltar
        """.trimIndent())

        when (readln()) {
            "1" -> cadastrarHospede()
            "2" -> pesquisarExato()
            "3" -> pesquisarPrefixo()
            "4" -> listarHospedes()
            "5" -> atualizarHospede()
            "6" -> removerHospede()
            "7" -> return
            else -> println("Opção inválida.")
        }
    }
}

private fun cadastrarHospede() {
    if (hospedes.size >= LIMITE_HOSPEDES) {
        println("Máximo de cadastros atingido")
        return
    }

    print("Nome do hóspede: ")
    val nome = readln()

    if (hospedes.any { it.nome.equals(nome, ignoreCase = true) }) {
        println("Hóspede já cadastrado")
        return
    }

    hospedes.add(Hospede(nome, LocalDateTime.now()))
    println("Operação realizada com sucesso")
}

private fun pesquisarExato() {
    print("Nome completo: ")
    val nome = readln()

    val encontrado = hospedes.find {
        it.nome.equals(nome, ignoreCase = true)
    }

    if (encontrado != null) {
        println("Hóspede ${encontrado.nome} foi encontrado")
    } else {
        println("Hóspede não encontrado")
    }
}

private fun pesquisarPrefixo() {
    print("Prefixo: ")
    val prefixo = readln()

    val resultados = hospedes.filter {
        it.nome.startsWith(prefixo, ignoreCase = true)
    }

    if (resultados.isEmpty()) {
        println("Hóspede não encontrado")
    } else {
        println("Resultados:")
        resultados.forEachIndexed { index, hospede ->
            println("[${index + 1}] ${hospede.nome}")
        }
    }
}

private fun listarHospedes() {
    if (hospedes.isEmpty()) {
        println("Nenhum hóspede cadastrado.")
        return
    }

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")

    hospedes
        .sortedBy { it.nome.lowercase() }
        .forEachIndexed { index, hospede ->
            println(
                "[${index + 1}] ${hospede.nome} - ${hospede.dataCadastro.format(formatter)}"
            )
        }
}

private fun atualizarHospede() {
    listarHospedes()
    if (hospedes.isEmpty()) return

    print("Informe o índice para atualizar: ")
    val indice = readln().toIntOrNull()

    if (indice == null || indice !in 1..hospedes.size) {
        println("Índice inválido")
        return
    }

    print("Novo nome: ")
    val novoNome = readln()

    hospedes[indice - 1].nome = novoNome
    println("Operação realizada com sucesso")
}

private fun removerHospede() {
    listarHospedes()
    if (hospedes.isEmpty()) return

    print("Informe o índice para remover: ")
    val indice = readln().toIntOrNull()

    if (indice == null || indice !in 1..hospedes.size) {
        println("Índice inválido")
        return
    }

    hospedes.removeAt(indice - 1)
    println("Operação realizada com sucesso")
}

fun getQuantidadeHospedes(): Int {
    return hospedes.size
}