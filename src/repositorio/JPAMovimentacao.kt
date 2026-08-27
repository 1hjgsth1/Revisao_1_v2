package repositorio

import java.sql.SQLException

fun salvarMovimentacao() {
    val jpa = JPA()

    try {
        jpa.conectar()//abre a conexao com o banco
        val sql = "INSERT INTO moivmentacao " +
                "(valor, data_movimentacao, descricao) " +
                "VALUES (?, ?, ?) "

        val stmt = jpa.c!!.prepareStatement(sql)

        //preparar lista para double precision
        val doublePrecision = jpa.c!!.createArrayOf("float8", a.dimensao.toTypedArray())
        //o typedArray() converte o array para um tipo de dado legivel para o POSTGRESQL

        //Preparar as variaveis para o banco
        stmt.setString(1, a.marca)
        stmt.setString(2, a.modelo)
        stmt.setArray(3, doublePrecision)
        stmt.setString(4, a.cor.name)
        stmt.setString(5, a.material.name)
        stmt.setString(6, a.formato)
        stmt.setString(7, a.preco.toString())
        stmt.executeUpdate()

        stmt.close()//encerra o placeholder
        jpa.c!!.close()//encerra a conexao com o banco
    } catch (e: SQLException) {
        println("F total parceiro: ${e.printStackTrace()}")
    }

}