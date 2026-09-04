package util

import java.math.BigDecimal

fun lerTextoObrigatorio(mensagem: String): String {
    while (true) {
        print(mensagem)
        val texto = readlnOrNull()?.trim()

        if (!texto.isNullOrBlank()) {
            return texto
        }

        println("O campo não pode ficar vazio.")
    }
}

fun lerDecimalPositivo(mensagem: String): Double {
    while (true) {
        print(mensagem)

        val numero = readlnOrNull()
            ?.trim()
            ?.replace(',', '.')
            ?.toDoubleOrNull()

        if (numero != null && numero > 0) {
            return numero
        }

        println("Digite um número positivo válido.")
    }
}

fun lerDinheiroPositivo(mensagem: String): BigDecimal {
    while (true) {
        print(mensagem)

        val valor = readlnOrNull()
            ?.trim()
            ?.replace(',', '.')
            ?.toBigDecimalOrNull()

        if (valor != null && valor > BigDecimal.ZERO) {
            return valor
        }

        println("Digite um valor monetário positivo.")
    }
}

fun lerOpcao(
    mensagem: String,
    ultimoIndice: Int
): Int {
    while (true) {
        print(mensagem)
        val opcao = readlnOrNull()?.trim()?.toIntOrNull()

        if (opcao != null && opcao in 0..ultimoIndice) {
            return opcao
        }

        println("Escolha uma opção válida.")
    }
}

fun lerInteiroPositivo(mensagem: String): Int {
    while (true) {
        print(mensagem)
        val numero = readlnOrNull()?.trim()?.toIntOrNull()

        if (numero != null && numero > 0) {
            return numero
        }

        println("Digite um número inteiro positivo.")
    }
}