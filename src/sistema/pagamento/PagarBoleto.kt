package sistema.pagamento

import repositorio.salvarMovimentacao
import java.time.LocalDate
import java.time.LocalDateTime

fun pagar(){
    println("Digite o contexto: ")
    val contexto = readln()  //FAZER UM ENUM NO LUGAR DESSA VAL
    println("Digite um valor: ")
    val valor = readln().toBigDecimal() //Precisa validar
    val data = LocalDate.now() //pega o dia e a hora atual
    salvarMovimentacao(contexto, valor, data)
}