import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutosDAO {

    // Método para salvar o produto no banco de dados
    public boolean salvarProduto(ProdutosDTO produto) {
        boolean sucesso = false;

        // Conecta ao banco de dados
        try (Connection conn = new conectaDAO().connectDB()) {
            // SQL de inserção no banco de dados
            String sql = "INSERT INTO produtos (nome, descricao, valor, status) VALUES (?, ?, ?, ?)";

            // Prepara o comando SQL
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setString(2, produto.getDescricao());
                stmt.setDouble(3, produto.getValor());
                stmt.setString(4, produto.getStatus());

                // Executa a atualização no banco
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected > 0) {
                    sucesso = true;  // Produto inserido com sucesso
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sucesso;
    }

    // Adicione outros métodos de consulta ou manipulação, se necessário
}
