public class Main {
    public static void main(String[] args) {
        // Inicializando a tela de cadastro como a primeira tela do projeto
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroVIEW().setVisible(true);
            }
        });
    }
}
