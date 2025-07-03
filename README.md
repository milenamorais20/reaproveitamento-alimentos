# 🏋️‍♀️ Sistema de reaproveitamento de alimento

Esse é um sistema de reaproveitamento de alimento direcionado para familias carentes e/ou institutos de caridade onde é realizado o cadastro. Quando o prazo de validade dos alimentos chega à 10 dias do vencimento, um email é enviado para as pessoas/instituições cadastradas às 8 horas da manhã com todos produtos perto do vencimento.

Atualmente, o projeto ainda está em uma fase inicial e possui uma estrutura simples. No entanto, meu objetivo é evoluí-lo gradualmente, adicionando novas funcionalidades e complexidade à medida que continuo praticando e aprofundando meus conhecimentos.


## ⚠️ Atenção!!

- Esse projeto faz uso do Postgres como banco de dados, ou seja, é a dependencia desse banco que está configurada nele.
- Caso você deseje fazer o uso do Postgres, será necessário criar um banco de dados para o projeto. 
  - Após a criação do mesmo, é preciso adicionar a url, o username e o password do banco de dados no arquivo application.yml. 
  - No arquivo application.yml esta descrito quais as informações necessárias e onde inseri-lás.
- Caso você opte por fazer uso de outro tipo de banco de dados, pesquise qual é a dependência da mesma e adicione-a no pom.xml do arquivo, substituindo onde está a do postgres.

## 🚀 Funcionalidades

- ✅ **Tabelas de Usuário, Produto e Retirada**
  Essas tabelas interagem entre si de modo a complementar as informçãoes necessárias para o usuário

- ✅ **Scheduler**  
  É uma dependência que permite programar uma ação para se repetir em período fixo de tempo. No caso desse proejeto, ela envia um email para todos usuários todos os dias as 08 da amnahã.

- ✅ **Mail**  
  É a classe que possui toda a estrutura do email.

## 🛠️ Tecnologias Utilizadas

Este projeto foi desenvolvido com as seguintes tecnologias:

- [JDK 21](https://www.oracle.com/java/technologies/javase/jdk21-archive-downloads.html) - Linguagem de programação
- [Spring](https://start.spring.io/) - API RESt
- [Postgres](https://www.postgresql.org/download/) - Banco de dados
- [Swagger](http://localhost:8080/swagger-ui.html) - Interface visual para projetar, construir, documentar e consumir APIs RESTful.

## 📦 Instalação

### Pré-requisitos

Antes de começar, você precisará ter instalado:

- Git
- IDE - Utilizei a [Intellij](https://www.jetbrains.com/idea/)
- JDK 21
- Banco de dados da sua preferencia
- **opcional**: uma REST Cliente de sua preferência

### Passo a passo

```bash
# Clone este repositório
git clone https://github.com/milenamorais20/reaproveitamento-alimentos

# Instale as dependências
npm install  # ou pip install -r requirements.txt

# Inicie a aplicação
npm run dev  # ou outro comando específico
```
## Autor

| [Milena Morais](https://github.com/seu-usuario)          |
| -------------------------------------------------------  |
| 📧[milenamoraistech@gmail.com](mailto:milenamoraistech@gmail.com)  |

## 🤝 Contribuições
Contribuições são bem-vindas! Para contribuir:

- Fork este repositório

- Crie uma branch: git checkout -b minha-feature

- Commit suas mudanças: git commit -m 'feat: minha nova feature'

- Faça push: git push origin minha-feature

- Abra um Pull Request
