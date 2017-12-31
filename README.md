# Avalia-o-do-Instituto-Transire-de-Tec.-BioTec.-do-Amazonas-ITBAM

Tecnologias Utilizadas.
1 linguagem java (jdk 7).
2 Framework hibernate e Hibernate validator.
3 JPA  para gerar as tabelas do banco de dados (relacionamento ManytoOne).
4 Framework Web java, JSF para o back-and(Pois é mais Rapida a Configuração).
5 Framework bootstrap para o front-end.
6. Banco de dados mysql para armazenamento de dados.
7. framewrok Junit para Teste Unitarios na classe ProdutoBean.
8. ferramenta Selenium IDE para teste de integração.
9. Componente Primefaces para Armazenamento da imagem do Produto.
10. Servidor JBOSS AS 7 para Rodar a aplicação
11. IDE Netbens para construir o projeto.
12. repositorio git para controle de versões do java.

Instruções do Projeto.
O projeto foi construindo utlizando netbens e java 7 e servidor de aplicação jboss.
Para rodar basta ter esse servidor configurado ao banco de dados mysql.
O projeto trata de uma loja ficticia de roupas.
No projeto a uma tela de menu inicial onde a a opção de ler sobre a loja ficticia.
Cadastrar o produto e listar o produto.
Na tela de Cadastro a campos de texto para pegar as seguintes informações como , nome da peça,
tamanho , quantidade em estoque, Marca,valor, tipo de tecido, imagem da peça de roupa e a filial(já vem do banco através do combo box).
A partir da tela listagem ,apertando o botao, atulizar listagem, mostrar todos os dados do produto e um campo de texto onde pode-se 
pesquisar pelo nome do produto individualmente, e escolher a opção de excluir , alterar dados.
Na tela de alterar dados do produto podem ser alterados.

O projeto esta dividido em pacotes:
pacote bean onde se encontra a classe ProdutoBean.
pacote dao onde estao as ejbs com as classes do crud.
pacote jpautil onde esta uma fabrica de conecxão com jpa com anotaçoes e injeções.
e a classe modelo onde estão os relacionamentos.
a classe estado, cidade e bairro e loja os dados vem do banco de dados para a tela. so a tabela produto que é adicionada ao banco de dados através da tela
o pacote conversor para pegar o nome das lojas e popular no banco de dados.

As pastas do bootstrat(css,fonts,js) é a pasta das telas onde a primeira é a tela menu que chama as outras telas, e a pasta resource onde esta a imagem da loja.






