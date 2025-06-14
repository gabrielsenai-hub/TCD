package dao;

import model.Cliente;               // Importa o modelo Cliente para usar nas operações
import org.hibernate.Session;       // Representa conexão com o banco via Hibernate
import org.hibernate.SessionFactory; // Fábrica de sessões Hibernate
import org.hibernate.Transaction;    // Controle de transações (commit/rollback)
import org.hibernate.cfg.Configuration; // Configuração do Hibernate

import java.util.List;               // Lista de clientes para o método listar

public class ClienteDAO {


    // SessionFactory estático, criado na inicialização da classe
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Método que configura e retorna a SessionFactory
    private static SessionFactory buildSessionFactory() {
        try {
            // Carrega configurações do arquivo hibernate.cfg.xml e constrói a fábrica
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Erro ao criar SessionFactory: " + ex);
            // Se falhar, lança erro de inicialização
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Método estático para acessar a SessionFactory em outros pontos
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Busca um Cliente pelo seu ID.
     * @param id identificador do Cliente
     * @return objeto Cliente se encontrado, ou null caso contrário
     */
    public Cliente buscarCliente(int id){
        Session s = getSessionFactory().openSession(); // Abre uma sessão
        Cliente encontrado = s.get(Cliente.class, id); // Busca usando chave primária
        s.close(); // Fecha a sessão
        return encontrado; // Retorna nulo ou cliente
    }

    /**
     * Persiste um novo Cliente no banco.
     * @param c objeto Cliente a ser salvo
     */
    public void salvar(Cliente c) {
        Session session = null;
        Transaction tx = null;

        try {
            session = getSessionFactory().openSession(); // Abre sessão
            tx = session.beginTransaction();            // Inicia transação
            session.save(c);                            // Executa INSERT
            tx.commit();                                // Confirma transação
        } catch (Exception e) {
            // Se houver erro, faz rollback da transação
            if (tx != null && tx.getStatus().canRollback()) {
                tx.rollback();
            }
        } finally {
            // Garante fechamento da sessão
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    /**
     * Retorna lista de todos os Clientes no banco.
     * @return List<Cliente>
     */
    public List<Cliente> listar() {
        // Try-with-resources fecha a sessão automaticamente
        try (Session session = getSessionFactory().openSession()) {
            // HQL: consulta todos os objetos Cliente
            return session.createQuery("FROM Cliente", Cliente.class).list();
        } finally {
            System.out.println("Operação finalizada!"); // Mensagem de feedback
        }
    }

    /**
     * Atualiza dados de um Cliente existente.
     * @param cliente objeto Cliente com ID e novos valores
     */
    public void atualizar(Cliente cliente) {
        Session s = getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction(); // Inicia transação
            s.update(cliente);         // Executa UPDATE
            tx.commit();               // Confirma mudanças
        } catch (Exception ex) {
            if (tx != null) tx.rollback(); // Se erro, rollback
            throw ex;                       // Propaga exceção
        } finally {
            s.close(); // Fecha sessão
            System.out.println("Operação finalizada!");
        }
    }

    /**
     * Deleta um Cliente pelo ID.
     * @param id identificador do Cliente
     * @return string vazia se sucesso, ou null se não encontrado
     */
    public String deletar(int id) {
        Transaction tx;

        // Try-with-resources garante fechamento da sessão
        try (Session s = getSessionFactory().openSession()) {
            tx = s.beginTransaction();               // Inicia transação
            Cliente aDeletar = s.get(Cliente.class, id); // Busca o cliente

            if (aDeletar != null) {
                s.delete(aDeletar);                 // Executa DELETE
                tx.commit();                        // Confirma deleção
                return "";                       // Retorna não-nulo para sucesso
            } else {
                return null;                       // Indica que não encontrou cliente
            }
        } catch (Exception e) {
            throw new RuntimeException(e);          // Propaga erro de runtime
        }
    }
}
