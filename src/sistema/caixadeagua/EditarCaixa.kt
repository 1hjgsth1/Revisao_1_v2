package sistema.caixadeagua

import enums.Cor
import enums.Material
import produto.CaixaDaAgua
import repositorio.JPA

fun editarCaixa() {
    val jpa = JPA()
    jpa.listar()

    println("Digite uma caixa que deseja editar: ")
    val id = readln().toInt()

    println("Digite a NOVA marca: ")
    val marca = readln()

    println("Digite o NOVO modelo: ")
    val modelo = readln()

    println("Digite o NOVO formato: ")
    val formato = readln()

    println("Digite a NOVA largura: ")
    val largura = readln().toDouble()

    println("Digite a NOVA profundidade: ")
    val profundidade = readln().toDouble()

    println("Digite a NOVA altura: ")
    val altura = readln().toDouble()
    val dimensao = mutableListOf(largura, altura, profundidade)

    println("Escolha a cor: ")
    Cor.entries.forEach { cor ->
        println("[${cor.ordinal}] ${cor.name}")
    }
    println("Número da cor NOVA: ")
    val cor = readln().toInt()

    println("Escolha a o material: ")
    Material.entries.forEach { material ->
        println("[${material.ordinal}] ${material.name}")
    }
    println("Número do material NOVO: ")
    val material = readln().toInt()

    println("Digite o NOVO preço: ")
    val preco = readln().toBigDecimal()

    jpa.editar(
        CaixaDaAgua(
            marca = marca,
            modelo = modelo,
            formato = formato,
            dimensao = dimensao,
            preco = preco,
            cor = Cor.entries[cor],
            material = Material.entries[material]
        ),
        id
    )
}