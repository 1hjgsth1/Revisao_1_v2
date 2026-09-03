package sistema.pagamento

import financeiro.Movimentacao
import repositorio.CRUDMovimentacao
import java.time.LocalDate

fun pagar() {
    println("Digite o contexto: ")
    val contexto = readln()  //FAZER UM ENUM NO LUGAR DESSA VAL
    println("Digite um valor: ")
    val valor = readln().toBigDecimal() //Precisa validar
    val data = LocalDate.now() //pega o dia e a hora atual
    val movimenatacao = CRUDMovimentacao()
    movimenatacao.salvar(
        Movimentacao(contexto = contexto, valor = valor, dataMovimentacao = data),
    )
}