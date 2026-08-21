package sistema.caixadeagua

import repositorio.JPA
import java.text.NumberFormat
import java.util.*

fun listarCaixa() {
val jpa = JPA()
    jpa.listar()
}