package sistema

import sistema.caixadeagua.cadastrarNovaCaixa
import sistema.caixadeagua.editarCaixa
import sistema.caixadeagua.excluirCaixa
import sistema.caixadeagua.listarCaixa

fun menuInicial() {
    do {
        println("[0] Sair")
        println("[1] Cadastrar caixa de água")
        println("[2] Editar caixa de água")
        println("[3] Listar caixas de água")
        println("[4] Excluir caixa de água")
        print("Digite sua Opção: ")

//        //MODELO DE REGEX PARA VALIDAR 1 DIGITO
//        val regex = Regex("\\d")
//
//        //MODELO DE REGEX PARA VALIDAR EMAIL
//        val validaEmail = Regex("""^[a-zA-Z0-9]+.@[a-z]+(.com|.com.br)$""")

        //SE FOR UM VALOR NUMERICO VÁLIDO
        //SERÁ CONVERTIDO, SENÃO SERÁ NULO
        //PORÉM, VALORES NULOS COM O ELVIS OPERATOR
        //TEM UM VALOR PADRÃO
        val op: Int = readln().toIntOrNull() ?: 10
        //validaEmail.find(op) //EXEMPLO MAL FEITO
        //if (regex.matches(op)) {

        when (op) {
            1 -> cadastrarNovaCaixa()
            2 -> editarCaixa()
            3 -> listarCaixa()
            4 -> excluirCaixa()
            0 -> {
                println("Até breve.")
                break
            }

            else -> println("Opção inválida!")
        }//FIM DO WHEN
        //}
    } while (true)//FIM DO DO-WHILE

}//FIM DA FUNÇÃO