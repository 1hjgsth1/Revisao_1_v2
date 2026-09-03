package repositorio

import financeiro.Movimentacao
import java.sql.SQLException

class CRUDMovimentacao() : InterfaceJPA<Movimentacao>, ConexaoPostgres() {
    override fun salvar(item: Movimentacao) {

        try {
            conectar()//abre a conexao com o banco
            val sql = "INSERT INTO moivmentacao " +
                    "(valor, data_movimentacao, descricao) " +
                    "VALUES (?, ?, ?) "

            val stmt = c!!.prepareStatement(sql)

            //Preparar as variaveis para o banco
            stmt.setString(1, item.valor.toString())
            stmt.setDate(2, java.sql.Date.valueOf(item.dataMovimentacao))
            stmt.setString(3, item.contexto)
            stmt.executeUpdate()

            stmt.close()//encerra o placeholder
            c!!.close()//encerra a conexao com o banco
        } catch (e: SQLException) {
            println("F total parceiro: ${e.printStackTrace()}")
        }

    }

    override fun editar(item: Movimentacao, id: Int) {}//Não será implementado
    override fun excluir(id: Int) {}//Não será implementado
    override fun listar() {
        try {
            conectar()
            val stmt = c!!.createStatement()
            val sql = "SELECT * FROM movimentacao"
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
            println(e.message)
        }
    }
}