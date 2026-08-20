package sistema

import produto.CaixaDaAgua
import repositorio.JPA
import sistema.caixadeagua.cadastrarNovaCaixa
import sistema.caixadeagua.listarCaixa

fun menuInicial() {
    do {
        println("[0] Sair")
        println("[1] Cadastrar caixa de água")
        println("[2] Editar caixa de água")
        println("[3] Listar caixas de água")
        println("[4] Excluir caixa de água")
        print("Digite sua Opção: ")
        val op = readln()

        when (op) {
            "1" -> cadastrarNovaCaixa()
            "2" -> println("")
            "3" -> listarCaixa()
            "4" -> println("")
            "0" -> {
                println("Adeus")
                break
            }

            else -> println("Opção inválida!")
        }//FIM DO WHEN

    } while (true)//FIM DO DO-WHILE

}//FIM DA FUNÇÃO