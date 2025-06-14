# Trabalho Final - Sistema de Cadastro de Clientes

Este repositório contém o projeto desenvolvido como **Trabalho Final da disciplina de Programação de Aplicativos** do curso de Desenvolvimento de Sistemas, no SENAI. O objetivo é consolidar os conhecimentos adquiridos ao longo do curso, até o presente momento. Construindo uma aplicação completa de **CRUD** em **Java**, com **Swing**, **Hibernate** e **MySQL**.

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
    <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/"><code>src/main/java</code></a>: Contém todo o código‑fonte Java do sistema
    <ul>
      <li>
        <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/Main.java"><code>Main.java</code></a>: Classe de inicialização da aplicação
      </li>
	<br>
      <li>
        <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/model/"> <code>model/</code></a>: Pacote de armazenamento de entidades
        <ul>
          <li>
            <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/model/Cliente.java"><code>Cliente.java</code></a>: Entidade que representa o cliente no banco de dados
          </li>
        </ul>
      </li>
	<br>
      <li>
        <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/dao/"> <code>dao/</code></a>: Pacote de acesso a dados
        <ul>
          <li>
            <a = href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/java/dao/ClienteDAO.java"> <code>ClienteDAO.java</code> </a>: Responsável pelas operações CRUD de cliente
          </li>
        </ul>
      </li>
	<br>
    </ul>
  </li>
  <li>
    <a href ="https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/resources/"><code>src/main/resources</code></a>: Arquivos de configuração do projeto
    <ul>
      <li>
        <a href = "https://github.com/gabrielsenai-hub/TCD/blob/main/TCD/src/main/resources/hibernate.cfg.xml"> <code>hibernate.cfg.xml</code></a>: Definições de conexão e mapeamento do Hibernate
      </li>
    </ul>
  </li>
</ul>

---

## Configuração do Banco de Dados

1. Instale o **MySQL Workbench**.
2. [Baixe](https://drive.google.com/file/d/1AJ3VKyzebuCLdL-Li0rcSTVlnPjp0TRc/view?usp=drive_link) e rode o script sql no MySQL Connections.
3. Atualize o hibernate.cfg.xml com o seus dados de usuario e senha, assim como a url JDBC(não é preciso se o IP do localhost for o mesmo).


