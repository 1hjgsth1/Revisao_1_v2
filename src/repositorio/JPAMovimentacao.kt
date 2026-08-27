package repositorio

import java.math.BigDecimal
import java.sql.SQLException
import java.time.LocalDateTime

fun salvarMovimentacao(contexto: String, valor: BigDecimal, data: LocalDateTime) {
    val jpa = JPA()

    try {
        jpa.conectar()//abre a conexao com o banco
        val sql = "INSERT INTO moivmentacao " +
                "(valor, data_movimentacao, descricao) " +
                "VALUES (?, ?, ?) "

        val stmt = jpa.c!!.prepareStatement(sql)

        //Preparar as variaveis para o banco
        stmt.setString(1, valor.toString())
        stmt.setString(2, data.toString()) //Ta errado precisa da hora
        stmt.setString(3, contexto)
        stmt.executeUpdate()

        stmt.close()//encerra o placeholder
        jpa.c!!.close()//encerra a conexao com o banco
    } catch (e: SQLException) {
        println("F total parceiro: ${e.printStackTrace()}")
    }

}