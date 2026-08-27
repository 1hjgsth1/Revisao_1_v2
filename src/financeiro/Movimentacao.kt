package financeiro

import java.math.BigDecimal
import java.time.LocalDate

class Movimentacao(
    val valor: BigDecimal,
    val dataMovimentacao: LocalDate,
    //val pessoa: Pessoa //Precisa fazer depois
){
    fun movimentar(valor: BigDecimal, data: String): Movimentacao {
        //Salvar no banco
    }
}

