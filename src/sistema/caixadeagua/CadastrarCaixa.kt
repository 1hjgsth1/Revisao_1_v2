package sistema.caixadeagua

import enums.Cor
import enums.Material
import produto.CaixaDaAgua
import repositorio.JPA

fun cadastrarNovaCaixa() {
    println("Digite a marca: ")
    val marca = readln()

    println("Digite o modelo: ")
    val modelo = readln()

    println("Digite a largura: ")
    val largura = readln().toDouble()
    println("Digite a altura: ")
    val altura = readln().toDouble()
    println("Digite a profundidade: ")
    val profundidade = readln().toDouble()
    //A dimensão é a combinação das 3 variaveis acima
    val dimensao = mutableListOf<Double>(largura, altura, profundidade)

    println("Escolha a cor: ")
    Cor.entries.forEach { cor ->
        println("[${cor.ordinal}] ${cor.name}")
    }
    println("Número da cor: ")
    val cor = readln().toInt()

    println("Escolha a o material: ")
    Material.entries.forEach { material ->
        println("[${material.ordinal}] ${material.name}")
    }
    println("Número do material: ")
    val material = readln().toInt()

    println("Escolha o formato: ")
    val formato = readln()

    println("Qual é o preço: ")
    val preco = readln().toBigDecimal()

    val conexao = JPA()//Cria a variável de conexão com o banco
    conexao.salvar( //Chama a função salvar
        CaixaDaAgua(
            marca = marca,
            material = Material.entries[material],
            modelo = modelo,
            dimensao = dimensao,
            cor = Cor.entries[cor],
            formato = formato,
            preco = preco

        )
    )
}