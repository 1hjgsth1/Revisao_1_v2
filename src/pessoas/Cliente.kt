package pessoas

import java.math.BigDecimal

class Cliente(
    nomeCliente: String,
    cpfCliente: String,
    idadeCliente: Int,
    var dividasAbertas: Boolean,
    var parcelasAPagar: MutableList<Double>
) : Pessoa(
    nome = nomeCliente,
    cpf = cpfCliente,
    idade = idadeCliente
) {

    fun receberConta(dinheiro: BigDecimal = BigDecimal.ZERO): BigDecimal {
        return dinheiro
    }
}