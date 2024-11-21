void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                         
    // Captura os valores dos campos de texto
    String nomeProduto = txtNomeProduto.getText();
    String descricaoProduto = txtDescricaoProduto.getText();
    String valorProdutoText = txtValorProduto.getText(); // Campo de texto para o valor do produto
    
    // Verifica se o valor do produto é válido e converte para o tipo adequado
    try {
        // Tentando converter o valor para double (caso o produto tenha valores decimais)
        double valorProduto = Double.parseDouble(valorProdutoText); // Certifique-se de que o campo espera um double
        
        // Cria o objeto ProdutoDTO com os dados capturados
        ProdutosDTO produto = new ProdutosDTO();
        produto.setNome(nomeProduto);
        produto.setDescricao(descricaoProduto);
        produto.setValor(valorProduto); // Armazenando o valor como double
        
        // Salva o produto no banco de dados
        if (produtoDAO.salvarProduto(produto)) {
            // Exibe uma mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            
            // Limpa os campos após o cadastro
            txtNomeProduto.setText("");
            txtDescricaoProduto.setText("");
            txtValorProduto.setText("");
        } else {
            // Exibe uma mensagem de erro se o cadastro falhar
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto.");
        }
    } catch (NumberFormatException e) {
        // Caso o valor do produto não seja um número válido
        JOptionPane.showMessageDialog(null, "Por favor, insira um valor válido para o produto.");
    }
}
