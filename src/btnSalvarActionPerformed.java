void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          // Método acionado quando o botão "Salvar" é clicado
    // Captura os valores dos campos de texto
    String nomeProduto = txtNomeProduto.getText();  // Nome do produto
    String descricaoProduto = txtDescricaoProduto.getText();  // Descrição do produto
    String valorProdutoText = txtValorProduto.getText();  // Valor do produto (como String)
    
    // Verifica se o valor do produto é válido e converte para o tipo adequado
    try {
        // Tentando converter o valor para double (caso o produto tenha valores decimais)
        double valorProduto = Double.parseDouble(valorProdutoText); // Conversão de String para double
        
        // Cria o objeto ProdutoDTO com os dados capturados
        ProdutosDTO produto = new ProdutosDTO();
        produto.setNome(nomeProduto);  // Atribui o nome
        produto.setDescricao(descricaoProduto);  // Atribui a descrição
        produto.setValor(valorProduto);  // Atribui o valor do produto
        
        // Por padrão, o status do produto será "Disponível"
        produto.setStatus("Disponível");  // Ajuste de status para "Disponível"
        
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
