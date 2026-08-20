package pessoas

import financeiro.Banco
import java.math.BigDecimal
import java.time.LocalDate

open class Pessoa(
    val nome: String = "Nome da pessoa",
    val cpf: String = "CPF da .Pessoas.Pessoa",
    val idade: Int = 1
) {
    open fun receberConta(valor: BigDecimal, conta: Pessoa): Banco {
        return Banco(
            dinheiro = valor,
            pessoa = conta,
            dataMovimentacao = LocalDate.now()
        )
    }
}