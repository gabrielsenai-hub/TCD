# Trabalho Final - Sistema de Cadastro de Clientes

Este repositório contém o projeto desenvolvido como **Trabalho Final da disciplina de Programação de Aplicativos** do SENAI. O objetivo é consolidar os conhecimentos adquiridos ao longo do curso, construindo uma aplicação completa de **CRUD** em **Java**, com **Swing**, **Hibernate** e **MySQL**.

---

## Tecnologias Utilizadas

- **Java SE 23**  
- **Swing** (interface gráfica)  
- **Hibernate 5.6.15.Final** (ORM)  
- **MySQL 8.x** (banco de dados relacional)  
- **Maven** (gerenciamento de dependências)  
- **IDE**: IntelliJ IDEA 

---

## Funcionalidades

- **Criar** registros de clientes (nome, e‑mail, telefone)  
- **Ler** e listar todos os clientes cadastrados  
- **Atualizar** dados de um cliente:
  - Nome  
  - E‑mail  
  - Telefone  
  - Todos os dados juntos  
- **Deletar** clientes pelo ID  
- Validações de entrada:
  - Nome: apenas letras e espaços  
  - E‑mail: sintaxe mínima com `@` e `.`  
  - Telefone: exatamente 11 dígitos numéricos  

---

## Estrutura do Projeto

<ul>
  <li>
    <code>src/main/java</code>: Contém todo o código‑fonte Java do sistema
    <ul>
      <li>
        <code>Main.java</code>: Classe de inicialização da aplicação
      </li>
	<br>
      <li>
        <code>model/</code>: Pacote de armazenamento de entidades
        <ul>
          <li>
            <code>Cliente.java</code>: Entidade que representa o cliente no banco de dados
          </li>
        </ul>
      </li>
	<br>
      <li>
        <code>dao/</code>: Pacote de acesso a dados
        <ul>
          <li>
            <code>ClienteDAO.java</code>: Responsável pelas operações CRUD de cliente
          </li>
        </ul>
      </li>
	<br>
    </ul>
  </li>
  <li>
    <code>src/main/resources</code>: Arquivos de configuração do projeto
    <ul>
      <li>
        <code>hibernate.cfg.xml</code>: Definições de conexão e mapeamento do Hibernate
      </li>
    </ul>
  </li>
</ul>

## Configuração do Banco de Dados

1. Instale o **MySQL Workbench**.
2. [Baixe](https://drive.google.com/file/d/1AJ3VKyzebuCLdL-Li0rcSTVlnPjp0TRc/view?usp=drive_link) e rode o script sql no MySQL Connections.
3. Atualize o hibernate.cfg.xml com o seus dados de usuario e senha, assim como a url JDBC(não é preciso se o IP do localhost for o mesmo).


