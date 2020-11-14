# OtakuRoyaleDate
Um template desenvolvido como desafio de criar uma visual novel.

O código pode ser alterado Livremente, mas o principal para uma visual novel já está codado.

1 - Como começar?

Abra o diretório "res" , abra o diretório "raw". Existe um arquivo com o nome "all_rotes.json".

Esse Arquivo tem essa estrutura:

	{
		"allRotas" : [
			 "R.raw.rota1",
			"R.raw.rota2",
			"R.raw.rota3"
		]
	} 

Cada Rota que será computada está nesse arquivo, as cenas estão dentro da rota, então sua cena deve estar lá para ser usada no jogo.
 "R.raw." representa o caminho do arquivo da rota, o que vem depois é o nome da rota. 
 
 
 A rota é um arquivo Json que tem a seguinte estrutura (Essa rota só tem uma cena, envolta por colchetes):
 
 	{
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

"id" é a chave única da cena.

"imgP" é a imagem do personagem.

"imgCene" é a imagem de Fundo.

"nameP" é o nome do personagem.

"said" é a fala do Personagem.

Dentro da tag "button" temos uma lista, que será mostrada como botões de escolha para o usuário.
O número que você pode colocar de opções é ilimitado, mas recomendo colocar no máximo 5.

No exemplo acima temos 2 opções, que estão entre colchetes separados por vígula.

	"name" é o texto que aparecerá nos botões de opção
	"id" se refere a chave única da próxima cena que o botão irá iniciar.
	
	
Entendeu mais ou menos? Mexa com o exemplo mude alguns textos de fala e opção no template!


2 - Criando uma rota nova

Crie um arquivo Json dentro de "raw" e coloque um nome, copie e cole o exemplo de estrutura acima. Pronto
Agora adicione a sua rota no arquivo "all_rotes.json". Pronto. Ficaria assim

	        {
			"allRotas" : [
				 "R.raw.rota1",
				"R.raw.rota2",
				"R.raw.rota3",
				"R.raw.nomeDaSuaRota"
			]
		} 


3 - adicionando imagens

Para adicionar imagens abra o diretório "assets", lá haverão 2 pastas, "characters" e "background"
"characters" é para personagens. ( Recomendação: personagem recortado e fundo transparente)
"background" é para fundo de cena. (Recomendação: imagem resolução menos de 2k)

Copie e cole sua imagem para lá. Renomeie a imagem para ficar mais fácil de lembrar o nome. Pronto.

Agora você pode substituir em uma cena para ver como ficou. 

	"imgP": "Joao.png",
         "imgCene": "background_escola.jpg",
	 
Essas são as tags da cena que correspondem respectivamente, a imagem do personagem e a do plano de fundo.



4 - Prefixos de Id Especiais

No campo button dentro de uma cena.

	"button": [
			  {
			    "name": "Final Imagem!",
			    "id": "@i"
			  },
			  {
			    "name": "Final vídeo!",
			    "id": "@v"
			  },
			  {
			    "name": "VAi pros créditos do game!",
			    "id": "@qualquercoisa"
			  }
			]
			
 Podem haver 3 tipos de prefixos de Id e todas elas no final vão ir para a tela de Créditos:
 
 "@i" que vai direcionar para uma tela que só possui uma imagem.
 
 "@v" que vai direcionar para uma tela que só possui um player de vídeo.
 
 "@x" ou @ e qualquer caracter , que irá direcionar para a tela de créditos do game.
 
 
 A tela de imagem carrega a imagem da tag "imgCene" ou seja essa imagem vai ter que estar na pasta de background.
 
 A tela de vídeo pega o nome do vídeo da tag "imgCene" e pega o vídeo na pasta "raw" e carrega no player.(Não recomendo usar vídeos, sujeito a mudanças).
 
 	{
	 	"rotas":[

		      {
			"id": "@i22",
			"imgP": " ",
			"imgCene": "pedro_triste.jpg",
			"nameP": " ",
			"said": "Pedro ficou triste mudou de escola e vocês nunca mais se viram - fim",
			"button": [
			  {
			    "name": " ",
			    "id": " "
			  }
			]
		      } 
		    ]
		  }
		  
Em qualquer dos prefixos essa estrutura será padrão. "said" será a mensagem que aparecerá um pouca antes da tela dos créditos,
é um bom lugar para colocar o que acontceu com o seu personagem e finalizar a história de uma maneira divertida.



Erros Comuns do Usuário	:

	A imagem de fundo ou do Personagem não aparece, solução:
		Verifique se o nome e a extensão da imagem estão corretos, use copiar e colar se preciso.
		
	Depois que eu clico no Botão a cena não muda, solução:
		Você provavelmente digitou o id que está dentro do botão errado, de novo,  use copiar e colar se preciso.
		
		
		

	
