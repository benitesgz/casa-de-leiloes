import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VendasVIEW extends JFrame {

    private JTable tabelaVendas;
    private ProdutosDAO produtoDAO;

    public VendasVIEW() {
        setTitle("Tela de Vendas");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        produtoDAO = new ProdutosDAO();
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        tabelaVendas = new JTable();
        add(new JScrollPane(tabelaVendas), BorderLayout.CENTER);
        atualizarTabelaVendas();
    }

    private void atualizarTabelaVendas() {
        List<Produto> produtosVendidos = produtoDAO.listarProdutosVendidos();
        String[] columnNames = {"ID", "Nome", "Descrição", "Valor", "Status"};
        Object[][] data = new Object[produtosVendidos.size()][5];

        for (int i = 0; i < produtosVendidos.size(); i++) {
            Produto produto = produtosVendidos.get(i);
            data[i][0] = produto.getId();
            data[i][1] = produto.getNome();
            data[i][2] = produto.getDescricao();
            data[i][3] = produto.getValor();
            data[i][4] = produto.getStatus();
        }

        tabelaVendas.setModel(new DefaultTableModel(data, columnNames));
    }
}
