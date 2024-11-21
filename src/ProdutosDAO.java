import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class ProdutosDAO {

    public boolean salvarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos (nome, valor) VALUES (?, ?)";
        try (Connection conn = new conectaDAO().connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getValor());

            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;  // Retorna true se o produto foi salvo com sucesso

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar produto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
