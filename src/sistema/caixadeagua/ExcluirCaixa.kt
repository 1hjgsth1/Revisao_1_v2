package sistema.caixadeagua

import repositorio.CRUDCaixaDaAgua

fun excluirCaixa() {
    val crudCaixaDaAgua = CRUDCaixaDaAgua()
    crudCaixaDaAgua.listar()

    println("Digite o ID que deseja excluir: ")
    val id = readln().toInt()

    crudCaixaDaAgua.excluir(id)
}