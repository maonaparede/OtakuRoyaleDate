# OtakuRoyaleDate
Um template desenvolvido como desafio de criar uma visual novel.

O código pode ser alterado Livremente, mas o principal para uma visual novel já está codado.

1 - Como começar?

Abra o diretório "res" , abra o diretório "raw". Existe um arquivo com o nome "all_rotes.json".

Esse Arquivo tem essa estrutura:
{
  "allRotas" : [
     "R.raw.cena1",
    "R.raw.cena2",
    "R.raw.cena3"
  ]
} 

Cada cena que será computada está nesse arquivo, então sua cena deve estar aqui para ser usada no jogo.
 "R.raw." representa o caminho do arquivo da cena, o que vem depois é o nome da cena. 
 
 
 A cena é um arquivo Json que tem a seguinte estrutura:
 
           "rotas":[

              {
                "id": "1a",
                "imgP": "Pedro.png",
                "imgCene": "background_2.jpg",
                "nameP": "Pedro",
                "said": "Eu sou Pedro",
                "button": [
                  {
                    "name": "Olá Pedro!",
                    "id": "2a"
                  },
                  {
                    "name": "Não me Importo!",
                    "id": "3a"
                  }
                ]
              } 
            ]
          }

"id" é a chave única da cena
"imgP" é a imagem do personagem
"imgCene" é a imagem de Fundo
"nameP" é o nome do personagem
"said" é a fala do Personagem

Dentro da tag "button" temos uma lista, que será mostrada como botões de escolha para o usuário.
O número que você pode colocar de opções é ilimitado, mas recomendo colocar no máximo 5.

No exemplo acima temos 2 opções, que estão entre colchetes separados por vígula.
"name" é o texto que aparecerá nos botões de opção
"id" se refere a chave única da próxima cena que o botão irá iniciar.

