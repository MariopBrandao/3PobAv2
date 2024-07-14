public class GerenciadorCliente {

    private ConexaoBD conexaoBD;

    public GerenciadorCliente(ConexaoBD conexaoBD) {
        this.conexaoBD = conexaoBD;
    }

    public void inserirCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getCep());
            statement.executeUpdate();
        }
    }

    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, cpf = ?, email = ?, endereco = ?, cep = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getEndereco());
            statement.setString(5, cliente.getCep());
            statement.setInt(6, cliente.getId());
            statement.executeUpdate();
        }
    }

    public void excluirCliente(int idCliente) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idCliente);
            statement.executeUpdate();
        }
    }

    public List<Cliente> listarClientes() throws SQLException {
        String sql = "SELECT * FROM clientes";
        List<Cliente> clientes = new ArrayList<>();
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpf = resultSet.getString("cpf");
                String email = resultSet.getString("email");
                String endereco = resultSet.getString("endereco");
                String cep = resultSet.getString("cep");
                clientes.add(new Cliente(id, nome, cpf, email, endereco, cep));
            }
        }
        return clientes;
    }
}
