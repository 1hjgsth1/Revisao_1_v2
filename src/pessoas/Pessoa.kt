package pessoas

import financeiro.Movimentacao
import java.math.BigDecimal
import java.time.LocalDate

open class Pessoa(
    val nome: String = "Nome da pessoa",
    val cpf: String = "CPF da .Pessoas.Pessoa",
    val idade: Int = 1
) {
    open fun receberConta(valor: BigDecimal, conta: Pessoa): Movimentacao {
        return Movimentacao(
            dinheiro = valor,
            pessoa = conta,
            dataMovimentacao = LocalDate.now()
        )
    }
}