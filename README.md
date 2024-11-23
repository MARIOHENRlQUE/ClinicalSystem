# Sistema de Saúde Ocupacional (SisSO)

## Descrição

O Sistema de Saúde Ocupacional (SisSO) é uma aplicação em Java desenvolvida para gerenciar exames médicos, funcionários e laudos de uma empresa. O sistema utiliza uma interface gráfica construída com Swing e permite a realização de diversas operações, como cadastro de exames, cadastro de funcionários, geração de relatórios e cálculo de custos da empresa.

## Requisitos

### Funcionais
1. **Cadastro de Exame Clínico:**
   - Permitir o cadastro de exames clínicos.
   - Armazenar os exames na propriedade `exames` da classe `BaseDados`.
   - Solicitar os dados do exame ao usuário.

2. **Cadastro de Exame Especial:**
   - Permitir o cadastro de exames especiais.
   - Armazenar os exames na propriedade `exames` da classe `BaseDados`.
   - Solicitar os dados do exame ao usuário.

3. **Impressão de Menu:**
   - Imprimir um menu no console com opções de cadastro de exame clínico, exame especial, e sair do sistema.

4. **Execução do Menu:**
   - Executar a opção escolhida pelo usuário no menu.
   - Chamar os métodos de cadastro conforme a escolha do usuário.
   - Interromper o sistema caso o usuário escolha a opção de sair do sistema.

5. **Cadastro de Funcionário:**
   - Permitir o cadastro de funcionários.
   - Armazenar os dados do funcionário na propriedade `funcionarios` da classe `BaseDados`.

6. **Cadastro de Laudo:**
   - Permitir o cadastro de laudos de exames realizados por funcionários.
   - Armazenar os dados do laudo na propriedade `laudos` da classe `BaseDados`.

7. **Interpretação de Laudos:**
   - Interpretar os laudos de exames clínicos e especiais.
   - Criar um método `isAlterado` para interpretar o resultado do exame conforme especificado.

8. **Exibição de Laudos Alterados:**
   - Permitir a exibição de todos os laudos alterados.

9. **Impressão de Dados:**
   - Seguir a estrutura especificada para impressão dos dados de um funcionário e de um laudo.
   - Utilizar uma interface para a impressão dos dados.

10. **Impressão de Relatórios:**
    - Imprimir relatórios de laudos ou funcionários conforme a escolha do usuário.

11. **Busca de Exame por CID:**
    - Permitir a busca de exames por CID.
    - Lançar uma exceção `ExameNaoEncontradoException` caso o exame não seja encontrado.

12. **Cálculo de Custos:**
    - Calcular os custos com salários de funcionários e exames especiais.

13. **Armazenamento de Dados:**
    - Permitir o armazenamento dos dados em um arquivo.
    - Permitir a recuperação dos dados armazenados.

14. **Interface Gráfica (Swing):**
    - Utilizar a biblioteca Swing para a construção da interface gráfica.
    - A interface não deve ser via prompt de comando.

### Não Funcionais
1. **Usabilidade:** O sistema deve ser fácil de usar, com uma interface clara e intuitiva.
2. **Desempenho:** O sistema deve responder rapidamente às entradas do usuário.
3. **Manutenibilidade:** O código deve ser modular e bem documentado para facilitar a manutenção.
4. **Confiabilidade:** O sistema deve lidar com entradas inválidas sem encerrar inesperadamente.
5. **Segurança:** Os dados devem ser protegidos contra acesso não autorizado.

## Estrutura do Projeto


## Como Executar

1. Clone o repositório para a sua máquina local.
2. Compile os arquivos Java utilizando um compilador como `javac`.
3. Execute a classe principal `SisSOInterface` para iniciar a aplicação gráfica.

### Exemplo de Execução

Para compilar:

javac -d bin src/*.java


Para executar:
java -cp bin SisSOInterface


## Funcionalidades

- **Cadastro de Exame Clínico e Especial:** Permite ao usuário cadastrar exames clínicos e especiais, que são armazenados na base de dados.
- **Cadastro de Funcionário:** Permite ao usuário cadastrar funcionários na base de dados.
- **Cadastro de Laudo:** Permite ao usuário cadastrar laudos de exames realizados pelos funcionários.
- **Geração de Relatórios:** Gera relatórios de exames, funcionários e laudos cadastrados.
- **Cálculo de Custos:** Calcula os custos totais com salários de funcionários e exames especiais.
- **Armazenamento e Recuperação de Dados:** Permite salvar os dados em um arquivo binário e recuperá-los posteriormente.

## Contato

Para mais informações, entre em contato pelo e-mail: [seuemail@exemplo.com](mailto:seuemail@exemplo.com).


