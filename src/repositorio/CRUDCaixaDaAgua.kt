package repositorio

import produto.CaixaDaAgua
import java.sql.SQLException

class CRUDCaixaDaAgua(

) : InterfaceJPA<CaixaDaAgua>, ConexaoPostgres() {

    override fun salvar(item: CaixaDaAgua) {
        println("Salvando...")
        try {
            conectar()//abre a conexao com o banco
            val sql = "INSERT INTO caixa_da_agua " +
                    "(marca, modelo, dimensao, cor, material, formato, preco) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?) "

            val stmt = c!!.prepareStatement(sql)

            //preparar lista para double precision
            val doublePrecision = c!!.createArrayOf("float8", item.dimensao.toTypedArray())
            //o typedArray() converte o array para um tipo de dado legivel para o POSTGRESQL

            //Preparar as variaveis para o banco
            stmt.setString(1, item.marca)
            stmt.setString(2, item.modelo)
            stmt.setArray(3, doublePrecision)
            stmt.setString(4, item.cor.name)
            stmt.setString(5, item.material.name)
            stmt.setString(6, item.formato)
            stmt.setString(7, item.preco.toString())
            stmt.executeUpdate()

            stmt.close()//encerra o placeholder
            c!!.close()//encerra a conexao com o banco
        } catch (e: SQLException) {
            println("F total parceiro: ${e.printStackTrace()}")
        }
    } //FIM SALVAR

    override fun listar() {
        try {
            conectar()
            val stmt = c!!.createStatement()
            val sql = "SELECT * FROM caixa_da_agua"
            //Esses metadados vem em forma de Lista, ResultSet
            val metadados = stmt.executeQuery(sql)
            val resultado = metadados.metaData //Metadados do banco
            val tamanhoTabela = resultado.columnCount //Tamanho da tabela em colunas
            println("Tamanho da tabela: $tamanhoTabela")

            while (metadados.next()) {
                for (i in 1..tamanhoTabela) {
                    //nome da coluna
                    val nomeColuna = resultado.getColumnName(i)
                    //dado que esta nessa coluna
                    val valorColuna = metadados.getString(i)
                    println("$nomeColuna -> $valorColuna")
                }//fim for
                println("---------------------------------------------------------------")

            }//fim while

            stmt.close()
            c!!.close()
        } catch (e: SQLException) {
            println("F total parceiro: ${e.printStackTrace()}")
        }
    } //FIM LISTAR

    override fun editar(item: CaixaDaAgua, id: Int) {
        try {
            conectar()
            val sql =
                "UPDATE caixa_da_agua SET " + "preco = ?, marca = ?, modelo = ?, formato = ?, dimensao = ?, cor = ?, material = ? WHERE id = ?"
            //COntinuar a lógica para os outros itens

            val stmt = c!!.prepareStatement(sql)
            stmt.setString(1, item.preco.toString())
            stmt.setString(2, item.marca)
            stmt.setString(3, item.modelo)
            stmt.setString(4, item.formato)
            stmt.setInt(5, id)
            stmt.setArray(6, c!!.createArrayOf("float8", item.dimensao.toTypedArray()))
            stmt.setString(7, item.cor.name)
            stmt.setString(8, item.material.name)
            stmt.executeUpdate() //Faz as alteraç~oes e manda para o banco

            stmt.close()
            c!!.close()

        } catch (e: SQLException) {
            println(e.printStackTrace())
        }
    }//FIM EDITAR

    override fun excluir(id: Int) {
        try {
            conectar()

            val sql = "DELETE FROM caixa_da_agua WHERE id = ?"
            val stmt = c!!.prepareStatement(sql)
            stmt.setInt(1, id)
            stmt.executeUpdate()

            c!!.close()

        } catch (e: SQLException) {
            println(e.printStackTrace())
        }

    }
}//FIM DA CLASSE