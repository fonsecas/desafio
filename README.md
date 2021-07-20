# Soluções Apresentadas:

- Mudança na estrutura do projeto, aplicando o conceito de camadas do Clean Architecture (Data, Domain e Presentation)
- Aplicação da arquitetura MVVM na camada presentation
- Utilização do Jetpack Components (View Model, Data Binding, Lifecycle, LiveData)
- Ultilização do Koin para injeção de dependencia
- Criei um Interceptor para cachear as requests feitas pelo Retrofit.
- Refatoração no layout, para reagir melhor com a arquitetura e resposta ao usuario
- Testes unitários na camada de presentation, domain e data. Na camada da presentation os
  testes foram realizados na ViewModel visando garantir que os sinais disparados eram iguais aos esperados.
- Já na camada de domain, os testes foram feitos nos interactors. Essa escolha foi motivada pelo fato deles 
  representarem a regra de negócio da aplicação.
- E por último, na camada do data, os testes foram feitos nos mappers e nos repositorys.
