import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        // Cria uma instância do ClienteDAO, que gerencia operações no banco de dados para clientes
        ClienteDAO clienteDAO = new ClienteDAO();

// Cria um objeto cliente vazio, que será usado para receber dados e salvar
        Cliente cliente = new Cliente();

// Cria a janela principal do programa com título
        JFrame janela = new JFrame("Gerenciador de Clientes - MySql & Java");

// Define o tamanho da janela (largura 400px, altura 300px)
        janela.setSize(400, 300);

// Define que ao fechar a janela principal o programa será encerrado
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Define o layout da janela como null, ou seja, layout absoluto (posição dos componentes será manual)
        janela.setLayout(null);

// Cria um botão para "Cadastrar novo cliente"
        JButton cadastrar = new JButton("Cadastrar novo cliente");
// Define posição (x=100, y=20) e tamanho (largura=180, altura=30) do botão
        cadastrar.setBounds(100, 20, 180, 30);
// Adiciona o botão à janela principal
        janela.add(cadastrar);

// Cria botão para listar clientes
        JButton listar = new JButton("Listar todos os clientes");
        listar.setBounds(100, 70, 180, 30);
        janela.add(listar);

// Botão para atualizar cliente
        JButton atualizar = new JButton("Atualizar cliente");
        atualizar.setBounds(100, 120, 180, 30);
        janela.add(atualizar);

// Botão para excluir cliente
        JButton excluir = new JButton("Excluir cliente");
        excluir.setBounds(100, 170, 180, 30);
        janela.add(excluir);

// Adiciona ação ao botão "cadastrar" para abrir a janela de cadastro ao ser clicado
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Cria uma nova janela para cadastro de cliente
                JFrame janelaCadastro = new JFrame("Cadastro");
                janelaCadastro.setSize(400, 300); // Define tamanho da janela de cadastro
                janelaCadastro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // Fecha somente essa janela quando clicada no fechar (não encerra o programa todo)
                janelaCadastro.setLayout(null); // Layout absoluto para esta janela

                // Cria campo de texto para nome
                JTextField campoNome = new JTextField();
                campoNome.setBounds(150, 20, 200, 30); // Posição e tamanho do campo

                // Cria campo de texto para email
                JTextField campoEmail = new JTextField();
                campoEmail.setBounds(150, 70, 200, 30);

                // Cria campo de texto para telefone
                JTextField campoTelefone = new JTextField();
                campoTelefone.setBounds(150, 120, 200, 30);

                // Cria rótulo para "Nome:"
                JLabel rotuloNome = new JLabel("Nome:");
                rotuloNome.setBounds(20, 20, 100, 30);

                // Rótulo para "Email:"
                JLabel rotuloEmail = new JLabel("Email:");
                rotuloEmail.setBounds(20, 70, 100, 30);

                // Rótulo para "Telefone:"
                JLabel rotuloTelefone = new JLabel("Telefone:");
                rotuloTelefone.setBounds(20, 120, 100, 30);

                // Cria botão para confirmar o cadastro
                JButton botaoCadastrar = new JButton("Cadastrar");
                botaoCadastrar.setBounds(120, 180, 150, 30);

                // Adiciona um KeyListener ao campoNome para validar entrada de caracteres:
                // permite somente letras, espaço e teclas de apagar (backspace e delete)
                campoNome.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        // Se o caractere digitado não for letra, espaço, backspace ou delete, ignora (consume) o evento
                        if (!Character.isLetter(c) && c != ' ' && c != '\b' && c != 127) {
                            e.consume();
                        }
                    }
                });

                // Adiciona KeyListener ao campoTelefone para aceitar só números e teclas de apagar
                campoTelefone.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        // Se o caractere não for dígito nem backspace ou delete, ignora o evento
                        if (!Character.isDigit(c) && c != '\b' && c != 127) {
                            e.consume();
                        }
                    }
                });


                // Adiciona um ouvinte de ação ao botão "botaoCadastrar"
                // Isso significa que quando esse botão for clicado, o código dentro do método actionPerformed será executado
                botaoCadastrar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Captura o texto inserido nos campos de nome, email e telefone, removendo espaços em branco nas extremidades
                        String nome = campoNome.getText().trim();
                        String email = campoEmail.getText().trim();
                        String telefone = campoTelefone.getText().trim();

                        // Verifica se o campo nome está vazio
                        if (nome.isEmpty()) {
                            // Exibe uma mensagem de erro e encerra a execução do botão
                            JOptionPane.showMessageDialog(janelaCadastro, "O campo nome não pode estar vazio!");
                            return;
                        }

                        // Verifica se o campo email está vazio
                        if (email.isEmpty()) {
                            JOptionPane.showMessageDialog(janelaCadastro, "O campo email não pode estar vazio!");
                            return;
                        }
                        // Verifica se o email contém os caracteres "@" e "."
                        else if (!email.contains("@") || !email.contains(".")) {

                            // Se não contém "@", exibe a mensagem apropriada
                            if (!email.contains("@")) {
                                JOptionPane.showMessageDialog(janelaCadastro, "O campo email não está na sintaxe correta, o '@' está faltante!");
                            }
                            // Se contém "@", mas não contém ".", exibe outra mensagem
                            else {
                                JOptionPane.showMessageDialog(janelaCadastro, "O campo email não está na sintaxe correta, o '.' está faltante!");
                            }
                            return;
                        }

                        // Verifica se o campo telefone está vazio
                        if (telefone.isEmpty()) {
                            JOptionPane.showMessageDialog(janelaCadastro, "O campo telefone não pode estar vazio!");
                            return;
                        }
                        // Verifica se o telefone possui exatamente 11 caracteres (ex: DDD + 9 dígitos)
                        else if (!(telefone.length() == 11)) {
                            JOptionPane.showMessageDialog(janelaCadastro, "O campo telefone não tem caracteres o suficiente!");
                            return;
                        }

                        // Define os dados no objeto cliente com os valores capturados dos campos
                        cliente.setNome(campoNome.getText());
                        cliente.setEmail(campoEmail.getText());
                        cliente.setTelefone(campoTelefone.getText());

                        // Chama o método salvar do DAO para persistir o cliente no banco de dados
                        clienteDAO.salvar(cliente);

                        // Mostra uma mensagem de sucesso
                        JOptionPane.showMessageDialog(janelaCadastro, "Cadastro realizado com sucesso!");

                        // Fecha a janela de cadastro após salvar
                        janelaCadastro.dispose();
                    }
                });

                // Adiciona os componentes visuais (rótulos, campos de texto e botão) à janela de cadastro
                janelaCadastro.add(rotuloNome);
                janelaCadastro.add(campoNome);
                janelaCadastro.add(rotuloEmail);
                janelaCadastro.add(campoEmail);
                janelaCadastro.add(rotuloTelefone);
                janelaCadastro.add(campoTelefone);
                janelaCadastro.add(botaoCadastrar);

                // Torna a janela de cadastro visível
                janelaCadastro.setVisible(true);
            }
        });
        // Adiciona um "ouvinte" (listener) ao botão chamado 'listar'.
        // Esse listener vai reagir a ações — neste caso, cliques.
        listar.addActionListener(new ActionListener() {

            // Sobrescreve o método actionPerformed, que é chamado quando o botão é clicado.
            @Override
            public void actionPerformed(ActionEvent e) {

                // Exibe uma janela de mensagem (caixa de diálogo) com os dados retornados
                // pelo método listar() do objeto clienteDAO.
                // Esse método retorna uma lista de clientes no banco de dados.
                JOptionPane.showMessageDialog(null, clienteDAO.listar());
            }
        });


        // Adiciona um ActionListener ao botão "atualizar" para abrir a tela de autenticação
        atualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Cria uma nova janela para autenticação antes de atualizar o cliente
                JFrame autenticacao = new JFrame("Autenticação");
                autenticacao.setSize(400, 300); // Define tamanho da janela
                autenticacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // Fecha só essa janela ao clicar no fechar
                autenticacao.setLayout(null); // Layout absoluto

                // Cria botão para buscar cliente pelo ID
                JButton buscaId = new JButton("Buscar cliente");
                buscaId.setBounds(80, 150, 250, 30);

                // Campo de texto para o usuário digitar o ID do cliente que quer alterar
                JTextField textoId = new JTextField();
                textoId.setBounds(80, 120, 250, 30);

                // Rótulo explicando o que digitar
                JLabel buscarTxt = new JLabel("Insira o id do cliente a ser alterado:");
                buscarTxt.setBounds(80, 90, 250, 30);

                // Validação para o campo textoId: aceita apenas números, backspace e delete
                textoId.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if (!Character.isDigit(c) && c != '\b' && c != 127) {
                            e.consume(); // Ignora caracteres inválidos
                        }
                    }
                });

                // Quando o botão "Buscar cliente" for clicado
                buscaId.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Obtém o texto digitado no campo e remove espaços
                        String texto = textoId.getText().trim();

                        // Se o campo estiver vazio, exibe erro e interrompe a execução
                        if (texto.isEmpty()) {
                            JOptionPane.showMessageDialog(autenticacao, "O campo não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return; // Sai do método aqui
                        }

                        try {
                            // Tenta converter o texto para número inteiro (id)
                            int id = Integer.parseInt(texto);

                            // Se o cliente com o ID informado existir no banco
                            if (clienteDAO.buscarCliente(id) != null) {
                                // Fecha a janela de autenticação
                                autenticacao.dispose();

                                // Cria a janela para atualização dos dados do cliente
                                JFrame janelaAtualizacao = new JFrame("Atualização");
                                janelaAtualizacao.setSize(400, 300);
                                janelaAtualizacao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                janelaAtualizacao.setLayout(null); // Layout absoluto

                                // Botões para escolher qual dado deseja alterar
                                JButton nome = new JButton("Nome");
                                nome.setBounds(100, 50, 180, 30);

                                JButton email = new JButton("Email");
                                email.setBounds(100, 100, 180, 30);

                                JButton telefone = new JButton("Telefone");
                                telefone.setBounds(100, 150, 180, 30);

                                JButton tudo = new JButton("Todos os dados");
                                tudo.setBounds(100, 200, 180, 30);

                                // Rótulo que explica a ação da janela de atualização
                                JLabel rotuloEscolha = new JLabel("O que deseja alterar?");
                                rotuloEscolha.setBounds(100, 15, 180, 30);

                                // Botão para atualizar o nome do cliente
                                nome.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Fecha a janela principal de atualização para abrir a específica
                                        janelaAtualizacao.dispose();

                                        // Busca o cliente pelo id informado previamente
                                        Cliente aAtualizar = clienteDAO.buscarCliente(id);

                                        // Cria uma nova janela para atualizar o nome
                                        JFrame frameNome = new JFrame("Atualizar Nome");
                                        frameNome.setSize(350, 160);
                                        frameNome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        frameNome.setLayout(null);

                                        // Rótulo indicando o campo de texto para o novo nome
                                        JLabel novoNome = new JLabel("Novo nome: ");
                                        novoNome.setBounds(20, 20, 100, 30);

                                        // Campo de texto para digitar o novo nome
                                        JTextField txtNovoNome = new JTextField();
                                        txtNovoNome.setBounds(120, 20, 200, 30);

                                        // Validação: permite apenas letras, espaços, backspace e delete no campo nome
                                        txtNovoNome.addKeyListener(new KeyAdapter() {
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                char c = e.getKeyChar();
                                                if (!Character.isLetter(c) && c != ' ' && c != '\b' && c != 127) {
                                                    e.consume(); // Ignora caracteres inválidos
                                                }
                                            }
                                        });

                                        // Botão para confirmar a atualização do nome
                                        JButton btnConfirmarNome = new JButton("Confirmar");
                                        btnConfirmarNome.setBounds(110, 80, 120, 30);
                                        btnConfirmarNome.addActionListener(e2 -> {
                                            String newNome = txtNovoNome.getText().trim();
                                            // Verifica se o campo nome não está vazio
                                            if (newNome.isEmpty()) {
                                                JOptionPane.showMessageDialog(frameNome, "Nome não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                return; // Para execução se inválido
                                            }

                                            // Atualiza o nome do cliente no objeto e no banco via DAO
                                            aAtualizar.setId(id);
                                            aAtualizar.setNome(txtNovoNome.getText());
                                            clienteDAO.atualizar(aAtualizar);

                                            // Mostra mensagem de sucesso e fecha a janela de atualização
                                            JOptionPane.showMessageDialog(frameNome, "Nome atualizado com sucesso!");
                                            frameNome.dispose();
                                        });

                                        // Adiciona os componentes na janela
                                        frameNome.add(novoNome);
                                        frameNome.add(txtNovoNome);
                                        frameNome.add(btnConfirmarNome);

                                        // Torna a janela visível
                                        frameNome.setVisible(true);
                                    }
                                });

                                // Botão para atualizar o email do cliente
                                email.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        janelaAtualizacao.dispose();

                                        Cliente aAtualizar = clienteDAO.buscarCliente(id);
                                        JFrame frameEmail = new JFrame("Atualizar Email");
                                        frameEmail.setSize(350, 160);
                                        frameEmail.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        frameEmail.setLayout(null);

                                        JLabel novoNome = new JLabel("Novo email: ");
                                        novoNome.setBounds(20, 20, 100, 30);

                                        JTextField txtNovoEmail = new JTextField();
                                        txtNovoEmail.setBounds(120, 20, 200, 30);

                                        JButton btnConfirmarEmail = new JButton("Confirmar");
                                        btnConfirmarEmail.setBounds(110, 80, 120, 30);
                                        btnConfirmarEmail.addActionListener(e2 -> {
                                            String newEmail = txtNovoEmail.getText().trim();

                                            // Validação: campo não pode estar vazio
                                            if (newEmail.isEmpty()) {
                                                JOptionPane.showMessageDialog(frameEmail, "Email não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                return;
                                            }
                                            // Validação básica de sintaxe do email
                                            else if (!newEmail.contains("@") || !newEmail.contains(".")) {
                                                if (!newEmail.contains("@")) {
                                                    JOptionPane.showMessageDialog(frameEmail, "O campo email não está na sintaxe correta, o '@' está faltante!");
                                                } else {
                                                    JOptionPane.showMessageDialog(frameEmail, "O campo email não está na sintaxe correta, o '.' está faltante!");
                                                }
                                                return;
                                            }

                                            // Atualiza o email do cliente e salva no banco
                                            aAtualizar.setId(id);
                                            aAtualizar.setEmail(txtNovoEmail.getText());
                                            clienteDAO.atualizar(aAtualizar);

                                            JOptionPane.showMessageDialog(frameEmail, "Email atualizado com sucesso!");
                                            frameEmail.dispose();
                                        });

                                        frameEmail.add(novoNome);
                                        frameEmail.add(txtNovoEmail);
                                        frameEmail.add(btnConfirmarEmail);
                                        frameEmail.setVisible(true);
                                    }
                                });

                                // Botão para atualizar o telefone do cliente
                                telefone.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        janelaAtualizacao.dispose();

                                        Cliente aAtualizar = clienteDAO.buscarCliente(id);
                                        JFrame frameTelefone = new JFrame("Atualizar Telefone");
                                        frameTelefone.setSize(350, 160);
                                        frameTelefone.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        frameTelefone.setLayout(null);

                                        JLabel novoTelefone = new JLabel("Novo telefone: ");
                                        novoTelefone.setBounds(20, 20, 100, 30);

                                        JTextField txtNovoTelefone = new JTextField();
                                        txtNovoTelefone.setBounds(120, 20, 200, 30);

                                        // Validação para aceitar somente dígitos no telefone
                                        txtNovoTelefone.addKeyListener(new KeyAdapter() {
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                char c = e.getKeyChar();
                                                if (!Character.isDigit(c) && c != '\b' && c != 127) {
                                                    e.consume();
                                                }
                                            }
                                        });

                                        JButton btnConfirmarTelefone = new JButton("Confirmar");
                                        btnConfirmarTelefone.setBounds(110, 80, 120, 30);
                                        btnConfirmarTelefone.addActionListener(e2 -> {
                                            String newTelefone = txtNovoTelefone.getText().trim();

                                            // Valida se o telefone não está vazio
                                            if (newTelefone.isEmpty()) {
                                                JOptionPane.showMessageDialog(frameTelefone, "Telefone não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                                                return;
                                            }
                                            // Valida se o telefone tem exatamente 11 caracteres (ex: DDD + número)
                                            else if (!(newTelefone.length() == 11)) {
                                                JOptionPane.showMessageDialog(janelaAtualizacao, "O campo telefone não tem caracteres o suficiente!");
                                                return;
                                            }

                                            // Atualiza o telefone do cliente e salva no banco
                                            aAtualizar.setId(id);
                                            aAtualizar.setTelefone(txtNovoTelefone.getText());
                                            clienteDAO.atualizar(aAtualizar);

                                            JOptionPane.showMessageDialog(frameTelefone, "Telefone atualizado com sucesso!");
                                            frameTelefone.dispose();
                                        });

                                        frameTelefone.add(novoTelefone);
                                        frameTelefone.add(txtNovoTelefone);
                                        frameTelefone.add(btnConfirmarTelefone);
                                        frameTelefone.setVisible(true);
                                    }
                                });

                                tudo.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        // Fecha a janela anterior para abrir a de edição completa
                                        janelaAtualizacao.dispose();

                                        // Cria a nova janela para mudar todos os dados do cliente
                                        JFrame mudarTudo = new JFrame("Mudar todos os dados");
                                        mudarTudo.setSize(400, 300);
                                        mudarTudo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                        mudarTudo.setLayout(null); // Layout manual, com posicionamento absoluto

                                        // Cria rótulos para os campos: nome, email e telefone
                                        JLabel rotuloNome = new JLabel("Novo nome:");
                                        rotuloNome.setBounds(30, 30, 100, 30);  // posição e tamanho

                                        JLabel rotuloEmail = new JLabel("Novo e-mail:");
                                        rotuloEmail.setBounds(30, 80, 100, 30);

                                        JLabel rotuloTelefone = new JLabel("Novo telefone:");
                                        rotuloTelefone.setBounds(30, 130, 120, 30);

                                        // Cria campos de texto para entrada dos novos dados
                                        JTextField campoNome = new JTextField();
                                        campoNome.setBounds(150, 30, 200, 30);

                                        JTextField campoEmail = new JTextField();
                                        campoEmail.setBounds(150, 80, 200, 30);

                                        JTextField campoTelefone = new JTextField();
                                        campoTelefone.setBounds(150, 130, 200, 30);

                                        // Botão para confirmar as alterações
                                        JButton confirmar = new JButton("Confirmar");
                                        confirmar.setBounds(120, 190, 150, 30);

                                        // Validação para campo nome: só aceita letras, espaços, backspace e delete
                                        campoNome.addKeyListener(new KeyAdapter() {
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                char c = e.getKeyChar();
                                                if (!Character.isLetter(c) && c != ' ' && c != '\b' && c != 127) {
                                                    e.consume(); // Ignora caracteres inválidos
                                                }
                                            }
                                        });

                                        // Validação para campo telefone: só aceita dígitos, backspace e delete
                                        campoTelefone.addKeyListener(new KeyAdapter() {
                                            @Override
                                            public void keyTyped(KeyEvent e) {
                                                char c = e.getKeyChar();
                                                if (!Character.isDigit(c) && c != '\b' && c != 127) {
                                                    e.consume();
                                                }
                                            }
                                        });

                                        // Ação ao clicar no botão confirmar
                                        confirmar.addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                // Captura e remove espaços extras dos campos
                                                String nome = campoNome.getText().trim();
                                                String email = campoEmail.getText().trim();
                                                String telefone = campoTelefone.getText().trim();

                                                // Validações simples para evitar dados incorretos
                                                if (nome.isEmpty()) {
                                                    JOptionPane.showMessageDialog(janelaAtualizacao, "O campo nome não pode estar vazio!");
                                                    return; // interrompe se inválido
                                                }
                                                if (telefone.isEmpty()) {
                                                    JOptionPane.showMessageDialog(janelaAtualizacao, "O campo telefone não pode estar vazio!");
                                                    return;
                                                } else if (telefone.length() != 11) {
                                                    JOptionPane.showMessageDialog(janelaAtualizacao, "O campo telefone não tem caracteres o suficiente!");
                                                    return;
                                                }
                                                if (email.isEmpty()) {
                                                    JOptionPane.showMessageDialog(janelaAtualizacao, "O campo email não pode estar vazio!");
                                                    return;
                                                } else if (!email.contains("@") || !email.contains(".")) {
                                                    // Mensagem específica conforme falta @ ou .
                                                    if (!email.contains("@")) {
                                                        JOptionPane.showMessageDialog(janelaAtualizacao, "O campo email não está na sintaxe correta, o '@' está faltante!");
                                                    } else {
                                                        JOptionPane.showMessageDialog(janelaAtualizacao, "O campo email não está na sintaxe correta, o '.' está faltante!");
                                                    }
                                                    return;
                                                }

                                                // Atualiza os dados no objeto cliente
                                                cliente.setId(id);  // garante que o cliente correto será atualizado
                                                cliente.setNome(nome);
                                                cliente.setEmail(email);
                                                cliente.setTelefone(telefone);

                                                // Chama o método para atualizar no banco via DAO
                                                clienteDAO.atualizar(cliente);

                                                // Confirma a atualização com mensagem ao usuário
                                                JOptionPane.showMessageDialog(janelaAtualizacao, "Dados atualizados com sucesso!");

                                                // Fecha a janela de edição múltipla
                                                mudarTudo.dispose();
                                            }
                                        });

                                        // Adiciona os componentes na janela
                                        mudarTudo.add(rotuloNome);
                                        mudarTudo.add(campoNome);
                                        mudarTudo.add(rotuloEmail);
                                        mudarTudo.add(campoEmail);
                                        mudarTudo.add(rotuloTelefone);
                                        mudarTudo.add(campoTelefone);
                                        mudarTudo.add(confirmar);

                                        // Exibe a janela para o usuário
                                        mudarTudo.setVisible(true);
                                    }
                                });
                                // Adicionando todos os botões e o rótulo (texto) á janela de atualização
                                janelaAtualizacao.add(rotuloEscolha);
                                janelaAtualizacao.add(nome);
                                janelaAtualizacao.add(email);
                                janelaAtualizacao.add(telefone);
                                janelaAtualizacao.add(tudo);

                                janelaAtualizacao.setVisible(true); // Definindo como visível

                            } else {
                                JOptionPane.showMessageDialog(autenticacao, "Não foi possível encontrar o cliente pelo id fornecido!", "Cliente não encontrado", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (Exception ex) {

                            throw new RuntimeException(ex);

                        }


                    }
                });

                // Adicionando todo o conteudo de autenticação á janela primária
                autenticacao.add(buscarTxt);
                autenticacao.add(textoId);
                autenticacao.add(buscaId);
                autenticacao.setVisible(true); // Deixando visivel


            }
        });

        excluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria uma nova janela para exclusão do cliente
                JFrame janelaExclusao = new JFrame("Exclusão");
                janelaExclusao.setSize(400, 300);
                // Fecha só essa janela quando o usuário clicar no "X"
                janelaExclusao.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // Layout absoluto, onde definimos posição fixa dos componentes
                janelaExclusao.setLayout(null);

                // Rótulo explicando o que o usuário deve fazer
                JLabel rotuloId = new JLabel("Insira o Id do cliente a ser excluído:");
                rotuloId.setBounds(100, 50, 250, 30); // posição e tamanho

                // Campo de texto para o usuário digitar o id do cliente
                JTextField campoId = new JTextField();
                campoId.setBounds(165, 95, 80, 30); // abaixo do rótulo e centralizado

                // Botão que irá disparar a exclusão do cliente
                JButton botaoExcluir = new JButton("Deletar");
                botaoExcluir.setBounds(80, 150, 250, 30);

                // Adiciona um listener para aceitar só dígitos no campo do id
                campoId.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        // se não for dígito, backspace ou delete, ignora a tecla
                        if (!Character.isDigit(c) && c != '\b' && c != 127) {
                            e.consume();
                        }
                    }
                });

                // Listener do botão excluir
                botaoExcluir.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Pega o texto digitado no campo, já sem espaços extras
                        String texto = campoId.getText().trim();

                        // Verifica se o campo está vazio
                        if (texto.isEmpty()) {
                            JOptionPane.showMessageDialog(janelaExclusao, "O campo não pode ficar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return; // sai da execução do método se vazio
                        }

                        try {
                            // Tenta converter o texto para inteiro (id do cliente)
                            int id = Integer.parseInt(texto);
                            // Tenta deletar o cliente via DAO
                            String resultado = clienteDAO.deletar(id);

                            // Se retorno for null, não encontrou o cliente para deletar
                            if (resultado == null) {
                                JOptionPane.showMessageDialog(janelaExclusao, "Não foi possível encontrar o cliente de id: " + id, "Erro de id", JOptionPane.ERROR_MESSAGE);
                                return; // interrompe aqui
                            } else {
                                // Sucesso na exclusão
                                JOptionPane.showMessageDialog(janelaExclusao, "Cliente excluído com sucesso!");
                            }

                        } catch (NumberFormatException ex) {
                            // Caso dê erro ao converter para número (ex: caracteres inválidos)
                            JOptionPane.showMessageDialog(janelaExclusao, "Id inválido! Insira apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        // Fecha a janela de exclusão após o processo
                        janelaExclusao.dispose();
                    }
                });

                // Adiciona os componentes na janela
                janelaExclusao.add(campoId);
                janelaExclusao.add(rotuloId);
                janelaExclusao.add(botaoExcluir);
                // Torna a janela visível para o usuário
                janelaExclusao.setVisible(true);
            }
        });

        janela.setVisible(true); // Deixando a janela principal de manipulação de dados de cliente visível

    }
}