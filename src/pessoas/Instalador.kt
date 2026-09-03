package pessoas

import enums.Habilidade
import enums.Turno
import financeiro.Movimentacao
import java.math.BigDecimal
import java.time.LocalDate

class Instalador(
    nome: String,
    cpf: String,
    idade: Int,
    val salario: BigDecimal = "2000".toBigDecimal(),
    val turno: Turno,
    val habilidade: Habilidade
) : Pessoa(nome, cpf, idade) {
}