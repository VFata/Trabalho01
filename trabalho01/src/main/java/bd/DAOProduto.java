/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author diego
 */
public class DAOProduto {
    
    //Insere um produto no banco de dados "produto"
    public static void inserir(Produto produto) throws Exception {
        //Monta a string de inserção de um produto no BD,
        //utilizando os dados do produtos passados como parâmetro
        String sql = "INSERT INTO produtos (nome, descricao, precoVenda, precoCompra, categoria, imagem, dataCriacao) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement statement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = SQLConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            statement = connection.prepareStatement(sql,  Statement.RETURN_GENERATED_KEYS);
            //Configura os parâmetros do "PreparedStatement"
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getPrecoVenda());
            statement.setDouble(4, produto.getPrecoCompra());
            statement.setInt(5, produto.getCategoria());
            statement.setString(6, produto.getImagem());
            statement.setTimestamp(7, new Timestamp(System.currentTimeMillis()) );
                        
            //Executa o comando no banco de dados
            statement.executeUpdate();
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                  int idNovo = generatedKeys.getInt(1);
                  produto.setId(idNovo);
                  // System.out.println("***** ID NOVO CADASTRADO: " + String.valueOf(idNovo));
                }

              }
            connection.commit();
            
            
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }

    //Realiza a atualização dos dados de um produto, com ID e dados
    //fornecidos como parâmetro através de um objeto da classe "Produto"
    public static void atualizar(Produto produto) throws Exception {
        if (produto != null && produto.getId() != null && produto.getId() > 0) {
            //Monta a string de atualização do produto no BD, utilizando
            //prepared statement
            String sql = "UPDATE produtos SET nome=?, descricao=?, precoVenda=?, precoCompra=?, categoria=?, imagem=? "
                    + "WHERE (id=?)";
            //Conexão para abertura e fechamento
            Connection connection = null;
            //Statement para obtenção através da conexão, execução de
            //comandos SQL e fechamentos
            PreparedStatement statement = null;
            try {
                //Abre uma conexão com o banco de dados
                connection = SQLConnectionUtils.getConnection();
                //Cria um statement para execução de instruções SQL
                statement = connection.prepareStatement(sql);
                //Configura os parâmetros do "PreparedStatement"
                
            statement.setInt(7, produto.getId());
            statement.setString(1, produto.getNome());
            statement.setString(2, produto.getDescricao());
            statement.setDouble(3, produto.getPrecoVenda());
            statement.setDouble(4, produto.getPrecoCompra());
            statement.setInt(5, produto.getCategoria());
            statement.setString(6, produto.getImagem());              

                //Executa o comando no banco de dados
                statement.execute();
            } finally {
                //Se o statement ainda estiver aberto, realiza seu fechamento
                if (statement != null && !statement.isClosed()) {
                    statement.close();
                }
                //Se a conexão ainda estiver aberta, realiza seu fechamento
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
        }
    }
    
    //Realiza a exclusão de um produto no banco de dados, com ID fornecido
    //como parâmetro.
    public static void excluir(Integer id) throws Exception {
        if (id != null && id > 0) {
            //Monta a string de atualização do produto no BD, utilizando
            //prepared statement
            String sql = "DELETE FROM produtos WHERE id=? ";
            //Conexão para abertura e fechamento
            Connection connection = null;
            //Statement para obtenção através da conexão, execução de
            //comandos SQL e fechamentos
            PreparedStatement preparedStatement = null;
            try {
                //Abre uma conexão com o banco de dados
                connection = SQLConnectionUtils.getConnection();
                //Cria um statement para execução de instruções SQL
                preparedStatement = connection.prepareStatement(sql);
                //Configura os parâmetros do "PreparedStatement"
                preparedStatement.setInt(1, id);

                //Executa o comando no banco de dados
                preparedStatement.execute();
            } finally {
                //Se o statement ainda estiver aberto, realiza seu fechamento
                if (preparedStatement != null && !preparedStatement.isClosed()) {
                    preparedStatement.close();
                }
                //Se a conexão ainda estiver aberta, realiza seu fechamento
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            }
        }
    }

    //Lista todos os produtos
    public static List<Produto> listar() throws Exception {
        //Monta a string de listagem de produtos no banco, considerando
        //apenas a coluna de ativação de produtos ("enabled")
        String sql = "SELECT * FROM produtos";        
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = SQLConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao"));
                produto.setCategoria(result.getInt("categoria"));
                produto.setImagem(result.getString("imagem"));
                produto.setPrecoCompra(result.getDouble("precoCompra"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(result.getTimestamp("dataCriacao").getTime());
                produto.setDataCriacao(gc);
                
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Procura um produto no banco de dados, de acordo com o nome
    //ou com o sobrenome, passado como parâmetro
    public static List<Produto> procurar(String valor)
            throws Exception {
        //Monta a string de consulta de produtos no banco, utilizando
        //o valor passado como parâmetro para busca nas colunas de
        //nome ou sobrenome (através do "LIKE" e ignorando minúsculas
        //ou maiúsculas, através do "UPPER" aplicado à coluna e ao
        //parâmetro). Além disso, também considera apenas os elementos
        //que possuem a coluna de ativação de produtos configurada com
        //o valor correto ("deletado" com "false")
        String sql = "SELECT * FROM produtos WHERE (UPPER(nome) LIKE UPPER(?))";
        //Lista de produtos de resultado
        List<Produto> listaProdutos = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = SQLConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, "%" + valor + "%");
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<>();
                }
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao"));
                produto.setCategoria(result.getInt("categoria"));
                produto.setImagem(result.getString("imagem"));
                produto.setPrecoCompra(result.getDouble("precoCompra"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(result.getTimestamp("dataCriacao").getTime());
                produto.setDataCriacao(gc);
                
                //Adiciona a instância na lista
                listaProdutos.add(produto);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de produtos do banco de dados
        return listaProdutos;
    }

    //Obtém um produto da lista
    public static Produto obter(Integer id) throws Exception {
        //Compõe uma String de consulta que considera apenas o produto
        //com o ID informado e que esteja ativo ("deletado" com "false")
        String sql = "SELECT * FROM produtos WHERE (id=?)";

        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = SQLConnectionUtils.getConnection();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, id);
            
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            
            //Verifica se há pelo menos um resultado
            if (result.next()) {                
                //Cria uma instância de Produto e popula com os valores do BD
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setDescricao(result.getString("descricao"));
                produto.setCategoria(result.getInt("categoria"));
                produto.setImagem(result.getString("imagem"));
                produto.setPrecoCompra(result.getDouble("precoCompra"));
                produto.setPrecoVenda(result.getDouble("precoVenda"));
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(result.getTimestamp("dataCriacao").getTime());
                produto.setDataCriacao(gc);
                
                //Retorna o resultado
                return produto;
            }            
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }

        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        return null;
    }

}
