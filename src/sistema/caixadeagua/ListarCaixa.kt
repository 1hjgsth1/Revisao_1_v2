package sistema.caixadeagua

import repositorio.JPA

fun listarCaixa() {
    val jpa = JPA()
    jpa.listar()
}