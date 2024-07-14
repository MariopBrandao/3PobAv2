public class GerenciadorCliente {

    private ConexaoBD conexaoBD;

    public GerenciadorCliente(ConexaoBD conexaoBD) {
        this.conexaoBD = conexaoBD;
    }

    public void incluirCliente(Cliente cliente) throws Exception {
        // Validar dados do cliente
        if (!cliente.validarNome() ||
