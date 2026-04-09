#language:pt
@trello
Funcionalidade: Gerenciamento de cards no Trello

    Cenario: Criar card com sucesso
        Dado que tenha um payload valido da API do Trello
        Quando envio uma requisicao do tipo POST para criar card
        Entao valido que recebo status 200
        E valido que o campo "name" seja "Card Automacao"
        E valido que o campo "id" nao seja nulo

    Cenario: Editar card com sucesso
        Quando envio uma requisicao do tipo PUT para editar card
        Entao valido que recebo status 200
        E valido que o campo "name" seja "Card Automacao Editado"

    Cenario: Excluir card com sucesso
        Quando envio uma requisicao do tipo DELETE para excluir card
        Entao valido que recebo status 200

        #Cenarios De Erro
    Cenario: Criar card com token invalido
        Dado que tenha um payload com campo "token" com o valor "invalido"
        Quando envio uma requisicao do tipo POST para criar card
        Entao valido que recebo status 401
        E valido que o campo "token" seja "invalido"

    Cenario: Criar card com token excluido
        Dado que tenha um payload com campo "token" excluido
        Quando envio uma requisicao do tipo POST para criar card
        Entao valido que recebo status 401

    Cenario: Criar card com key invalido
        Dado que tenha um payload com campo "key" com o valor "invalido"
        Quando envio uma requisicao do tipo POST para criar card
        Entao valido que recebo status 401
        E valido que o campo "key" seja "invalido"

    Cenario: Criar card com key excluido
        Dado que tenha um payload com campo "key" excluido
        Quando envio uma requisicao do tipo POST para criar card
        Entao valido que recebo status 401