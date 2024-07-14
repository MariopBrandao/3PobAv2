public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;

    // Construtor
    public Cliente(int id, String nome, String cpf, String email, String endereco, String cep) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.endereco = endereco;
        this.cep = cep;
    }

    // Getters e setters
    // ...

    // Métodos de Validação de Dados
    public boolean validarNome() {
        // Implementar validação de nome (letras, espaços, acentos, tamanho máximo)
        // Exemplo:
        return nome != null && nome.matches("[A-Za-zÀ-Öà-öçÇ]+( [A-Za-zÀ-Öà-öçÇ]+)*");
    }

    public boolean validarCpf() {
        // Implementar validação de CPF (formato, duplicidade)
        // Exemplo:
        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        int somaDigito1 = 0;
        int somaDigito2 = 0;
        int digito1;
        int digito2;

        for (int i = 0; i < cpf.length(); i++) {
            char digit = cpf.charAt(i);
            if (!Character.isDigit(digit)) {
                return false;
            }

            int numero = Integer.parseInt(String.valueOf(digit));

            if (i < 9) {
                somaDigito1 += numero * (10 - i);
            } else {
                somaDigito2 += numero * (i + 1);
            }
        }

        digito1 = (somaDigito1 % 11) == 0 ? 0 : (11 - (somaDigito1 % 11));
        somaDigito2 += digito1;
        digito2 = (somaDigito2 % 11) == 0 ? 0 : (11 - (somaDigito2 % 11));

        return cpf.charAt(9) == Character.forDigit(digito1, 10) && cpf.charAt(10) == Character.forDigit(digito2, 10);
    }

    public boolean validarEmail() {
        // Implementar validação de email (formato)
        // Exemplo:
        return email != null && email.matches("[\\w\\.-]+@[\\w\\.-]+\\.[\\w]{2,6}");
    }

    public boolean validarEndereco() {
        // Implementar validação de endereço (caracteres permitidos, tamanho máximo)
        // Exemplo:
        return endereco != null && endereco.matches("[A-Za-z0-9À-Öà-öçÇ ,.-]+( [A-Za-z0-9À-Öà-öçÇ ,.-]+)*");
    }

    public boolean validarCep() {
        // Implementar validação de CEP (formato)
        // Exemplo:
        return cep != null && cep.matches("\\d{8}");
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
