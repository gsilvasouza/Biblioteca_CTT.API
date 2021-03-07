## Biblioteca_CTT.API

### Detalhes do sistema

Queremos criar um sistema para fazer o gerenciamento de uma biblioteca.

O sistema precisa receber o cpf do cliente e o codigo do livro para reservar um livro.

Uma análise do que precisamos cadastrar: 

#### Categoria
```json
{
  "categoria": "Fantasia"
}
```

#### Livro
```json
{
  "titulo": "A ida dos que não foram",
  "autor": "Se foi",
  "categoria": "Fantasia",
  "disponibilidade": true
}
```

#### Cliente
```json
{
  "titulo": "A ida dos que não foram",
  "autor": "Se foi",
  "categoria": "Fantasia",
  "disponibilidade": true
}
```
Dessa forma poderemo criar um registro de reserva de livro:
- Passando o numero de CPF do cliente e o codigo de registro do livro.
```json
{
  "CPF": "123.456.082-11",
  "codigo" : "1234"
}
```
### Pesquisas específicas 
Para facilitar pesquisas por todos os livros que possuam atributos especificos, como: <br>
-Categoria <br>
-Autor <br>
-Titulo


