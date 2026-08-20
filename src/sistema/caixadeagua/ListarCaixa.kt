package sistema.caixadeagua

import produto.CaixaDaAgua
import java.text.NumberFormat
import java.util.Locale

fun listarCaixa() {
    val formatador = NumberFormat.getCurrencyInstance(Locale.of("pt", "br"))
    //var caixaDaAgua : List<CaixaDaAgua> = listOf()
    /*listaDeTeste.forEach { c ->
        println("------------------------------")
        println("Modelo: ${c.modelo}")
        println("Marca: ${c.marca}")
        println("Dimensão: ${c.dimensao}")
        println("Cor: ${c.cor}")
        println("Formato: ${c.formato}")
        println("Material: ${c.material}")
        println("Preço: ${formatador.format(c.preco)}")
    }*/
}