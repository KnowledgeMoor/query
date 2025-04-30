# API de Consulta de Notas Fiscais

Este sistema oferece uma API RESTful para consultar informações sobre notas fiscais e produtos vendidos. A aplicação permite buscar notas fiscais por ID, listar itens vendidos com ou sem desconto, obter produtos ordenados por valor unitário, identificar produtos mais vendidos, entre outras consultas relevantes.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.3.3**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória)
- **Lombok** (redução de boilerplate)
- **Swagger/OpenAPI** (documentação da API)
- **Maven** (gerenciamento de dependências)

## 📁 Estrutura do Projeto

```
br.edu.iftm.query
├── controller
│   └── NotaFiscalController.java
├── domain
│   └── NotaFiscal.java
├── dto
│   └── NotaFiscalDTO.java
├── repository
│   └── NotaFiscalRepository.java
├── service
│   ├── NotaFiscalService.java
│   └── exceptions
│       └── NaoAcheiException.java
│   └── util
│       └── Converter.java
```

## 💾 Modelo de Dados

A entidade principal do sistema é a `NotaFiscal`, que representa um item de uma nota fiscal com os seguintes atributos:

| Atributo    | Tipo   | Descrição                             |
|-------------|--------|---------------------------------------|
| id          | Long   | ID único do registro                  |
| id_nf       | Long   | Identificador da nota fiscal          |
| id_item     | Long   | Identificador do item na nota fiscal  |
| cod_prod    | Long   | Código do produto                     |
| valor_unit  | Double | Valor unitário do produto             |
| quantidade  | int    | Quantidade de itens                   |
| desconto    | int    | Valor do desconto aplicado            |

## 🔌 Endpoints da API

### Consultas de Notas Fiscais

| Método | Endpoint                                 | Descrição                                                  |
|--------|------------------------------------------|-------------------------------------------------------------|
| GET    | `/notaFiscal/findById/{id}`              | Busca uma nota fiscal pelo ID                               |
| GET    | `/notaFiscal/itemsSoldWithoutDiscount`   | Lista todos os itens vendidos sem desconto                  |
| GET    | `/notaFiscal/itemsSoldWithDiscount`      | Lista todos os itens vendidos com desconto                  |
| GET    | `/notaFiscal/itemsOrderByValorUnitDesc`  | Lista itens ordenados pelo valor unitário (decrescente)     |
| GET    | `/notaFiscal/topSellingProduct`          | Retorna o produto mais vendido                              |
| GET    | `/notaFiscal/nfWithMoreThan10UnitsSold`  | Lista notas fiscais com mais de 10 unidades vendidas        |
| GET    | `/notaFiscal/totalNFValueGreaterThan500OrderByDesc` | Retorna notas fiscais com valor total maior que R$500 |

## ⚙️ Como Executar

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/KnowledgeMoor/nota-fiscal-api.git
   cd query
   ```

2. Compile o projeto:
   ```bash
   mvn clean install
   ```

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```


## 📚 Documentação da API

A documentação da API está disponível através do Swagger UI, que pode ser acessado após iniciar a aplicação:

```
http://localhost:8080/swagger-ui/index.html
```

## 🧪 Exemplos de Uso

### Buscar Nota Fiscal por ID
```
GET http://localhost:8080/notaFiscal/findById/100
```

### Listar Itens Vendidos Sem Desconto
```
GET http://localhost:8080/notaFiscal/itemsSoldWithoutDiscount
```

### Listar Itens Vendidos Com Desconto
```
GET http://localhost:8080/notaFiscal/itemsSoldWithDiscount
```

### Listar Itens Ordenados por Valor Unitário (Decrescente)
```
GET http://localhost:8080/notaFiscal/itemsOrderByValorUnitDesc
```

### Buscar Produto Mais Vendido
```
GET http://localhost:8080/notaFiscal/topSellingProduct
```

### Listar Notas Fiscais com Mais de 10 Unidades Vendidas
```
GET http://localhost:8080/notaFiscal/nfWithMoreThan10UnitsSold
```

### Listar Notas Fiscais com Valor Total Maior que R$500
```
GET http://localhost:8080/notaFiscal/totalNFValueGreaterThan500OrderByDesc
```
