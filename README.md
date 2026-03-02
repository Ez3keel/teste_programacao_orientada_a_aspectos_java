#  API de Produtos com Medição de Tempo

Projeto desenvolvido com Spring Boot para demonstrar:

- Arquitetura em camadas (Controller, Service, Repository)
- Persistência com Spring Data JPA
- Banco de dados H2 em memória
- Medição de tempo de execução utilizando abordagem funcional com Supplier
- Organização profissional de projeto backend

---

##  Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven

---

##  Estrutura do Projeto

com.exemplo.produto  
│  
├── controller → Camada de entrada (REST API)  
├── service → Regras de negócio  
├── repository → Acesso ao banco de dados  
├── model → Entidades JPA  
└── util → Classe utilitária para medição de tempo  

---

##  Objetivo do Projeto

Demonstrar como medir o tempo de execução de métodos da camada de serviço utilizando uma abordagem reutilizável com programação funcional (Supplier), evitando repetição de código.

---

## Funcionamento da Medição de Tempo

Foi criada uma classe utilitária:

```java
public class TempoUtil {

    public static <T> T medir(Supplier<T> funcao) {

        long inicio = System.currentTimeMillis();
        T resultado = funcao.get();
        long fim = System.currentTimeMillis();

        System.out.println("Tempo execução: " + (fim - inicio) + " ms");

        return resultado;
    }
}
```

No Service:

```java
public Produto salvarProduto(Produto produto){

    return TempoUtil.medir(() -> {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return repository.save(produto);
    });
}
```
 Endpoint Disponível
Criar Produto

POST /produtos

Exemplo de Body:
{
  "nome": "Notebook",
  "preco": 3500
}
 Console Esperado

Ao executar a requisição, o console exibirá:

Tempo execução: 1002 ms
🗄 Banco de Dados

O projeto utiliza H2 em memória.

Console H2 disponível em:

http://localhost:8080/h2-console

Configurações padrão:

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: (vazio)

## Conceitos Aplicados

Injeção de Dependência

Separação de Responsabilidades

Arquitetura em Camadas

Programação Funcional com Supplier

Boas práticas de tratamento de InterruptedException

## Como Executar

Clonar o repositório

Executar o projeto via IntelliJ ou:

mvn spring-boot:run

Testar via Postman ou Insomnia

Autor

Ezequiel Gonçalves
Desenvolvedor Backend 



