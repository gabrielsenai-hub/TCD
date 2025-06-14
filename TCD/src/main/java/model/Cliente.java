package model;

import javax.persistence.*; // Importa anotações JPA para mapeamento objeto-relacional

@Entity // Indica que esta classe é uma entidade gerenciada pelo JPA
public class Cliente {

    @Id // Marca o campo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define que o banco gera o valor automaticamente
    @Column(name = "id_cliente") // Mapeia para a coluna "id_cliente" na tabela
    private Integer id; // Identificador único do cliente

    @Column(nullable = false, length = 20) // Coluna não pode ser nula e tem tamanho máximo de 20 caracteres
    private String nome; // Nome do cliente

    @Column(nullable = false, length = 50) // Coluna não pode ser nula e tem tamanho máximo de 50 caracteres
    private String email; // Email do cliente

    @Column(nullable = false, length = 15) // Coluna não pode ser nula e tem tamanho máximo de 15 caracteres
    private String telefone; // Telefone do cliente

    // Construtor completo (usado para instanciar com todos os campos)
    public Cliente(Integer id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    // Construtor padrão (necessário para o JPA)
    public Cliente() {
    }

    // Retorna o ID do cliente
    public Integer getId() {
        return id;
    }

    // Define o ID do cliente (geralmente usado internamente)
    public void setId(Integer id) {
        this.id = id;
    }

    // Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Define o nome do cliente
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o email do cliente
    public String getEmail() {
        return email;
    }

    // Define o email do cliente
    public void setEmail(String email) {
        this.email = email;
    }

    // Retorna o telefone do cliente
    public String getTelefone() {
        return telefone;
    }

    // Define o telefone do cliente
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        // Monta uma representação em texto formatada do cliente
        return "\n\t--Cliente--\n" +
                "\nId: " + id +
                "\nNome: " + nome +
                "\nEmail: " + email +
                "\nTelefone: " + telefone;
    }
}
