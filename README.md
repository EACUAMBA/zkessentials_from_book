# Minhas praticas usando o livro ZK Essentials 9.5.0

## O que é o ZK Framework?

<div style="text-align: center; display: flex; justify-content: center">

![alt text](./logo.png?raw=true)

</div>

**ZK Framework é um framework frontend  Java, que permite a criação de telas programaticamente ou usando um ficheio meio que HTML mas com tags do proprio framework, ficheiros *.zul*.**

### Farei uma breve descrição do elementos que eu for a usar

##### A tag Border Layout Define o tipo de leyout que vai ser utilizado para organizar os elementos dentro dessa tag. O Layout Border usa o sistema de organização em localização onde temos as localizações (noth, west, center, east, south) onde represemtam note - canto superior, este - canto lado esquerdo, center - centro da tela, east - canto a direita e south - no rodapé, abaixo; Note que se não especificar um tamanho o center vai ocupar todo o espaço disponível. Para definir as localizações usamos as tags <pre>  &#60;south>, &#60;west>, &#60;center>, &#60;east>, &#60;south></pre>Note que você pode definir comprimento(width) e altura(height) para esses elementos para eles não variarem em cada navegador.

<pre>
   	&#60;borderlayout&#62;
   	    Outros elementos
   	&#60;/borderlayout&#62;
</pre>
<br>

##### As propriedades vflex e hflex definem o tamanho da flexibilidade vertical e horizontal de um componente. Quando colocamos 1 queremos que o elemento ocupe todos os espaço restante 100%.
<pre>
   	&#60;tag vflex="1" hflex="1" /&#62;
</pre>

##### A propriedade collapsible permite tornar um elemento colapsado ou minimizado o seu tamanho, quuando colocas true podes ajustar o tamanho.
<pre>
   	&#60;tag collapsible="true" /&#62;
</pre>

##### A propriedade splittable quando colocada true permite ajustar o comprimento (width) de um elemento.
<pre>
   	&#60;tag splittable="true" /&#62;
</pre>

##### A propriedade minsize permite definir um comprimento minimmo que o elemento pode atingir.
<pre>
   	&#60;tag width="500px" minsize="200px" /&#62;
</pre>

##### A propriedade autoscroll quando colocada como true define que o elemento deverá ter um scroll se o seu conteudo exceder o tamanho do elemento (container, contentor).
<pre>
   	&#60;tag width="500px" height="200px" autoscroll="true" /&#62;
</pre>

##### A propriedade spacing define um espaço entre os filhos do elemento.
<pre>
   	&#60;tag spacing="20px"&#62;
   	    Elementos filho
   	&#60;/tag&#62;
</pre>

##### A propriedade sclass define para nos um selector css class, podemos adicionar nossas modificações posteriormente.
<pre>
   	&#60;tag sclass="nomedaclassecss"/tag&#62;
</pre>

##### O elemento &#60;hbox> serve para arrumar os elementos em uma linha horizontal, o seu atributo *align* serve para definir o alinhamento vertical dos elementos filhos dele
<pre>
   	&#60;hbox align="center"&#62;
   	    Elemento alinhado no centro verticalmente em uma linha hbox.
   	&#60;/hbox&#62;
</pre>

##### O atributo pack serve para definir o alinhamento horizontal dos elementos dentro de uma (x|v)box.
<pre>
   	&#60;hbox align="center" pack="end"&#62;
   	    Elemento alinhado no centro verticalmente e no fim da box, no cando direito.
   	&#60;/hbox&#62;
</pre>

##### O elemento &#60;a> serve para criar um link como um elemento padrão HTML o ancora, usamos o atributo href para especificar o link (target link).
<pre>
   	&#60;a href="caminhodolink"&#62;
   	    elemento que ao ser clicado levará o utilizador ao link.
   	&#60;/a&#62;
</pre>

##### O elemento &#60;image> similar ao elemento &#60;img> do HTML serve para exibir imagens.
<pre>
   	&#60;img src="caminhodaimagem_starts_from_WEB-INF_directory"&#62;
</pre>

##### O elemento &#60;grid>, ele serve bem para agrupar os elementos em matrix/tabela, ele possui uma estrutura de colunas e linhas, devemos definir as colunas e depois as linhas sendo que o numero de elemntos na linha deverá ser igual ao numero de colunas, olha aí : 
<pre>
&#60;grid&#62;
    &#60;columns&#62;
        &#60;column width="50px"/&#62; 	    
        &#60;column/&#62; 	    
    &#60;/columns&#62;
    &#60;rows&#62;
        &#60;row&#62;
            &#60;label value="Coluna 1"&#62;
            &#60;label value="Coluna 2"&#62;
        &#60;/row&#62;
        &#60;row&#62;
            &#60;label value="Coluna 1 da linha 2"&#62;
            &#60;label value="Coluna 2 da linha 2"&#62;
        &#60;/row&#62;
    &#60;/rows&#62;         	
&#60;/grid&#62;
</pre>
*Nota que dentro de um elemento rows ou columns so pode ser row ou column respectivamente.*


##### O elemento &#60;vbox> serve para arrumar os elementos em uma linha verticalmente, o seu atributo *align* serve para definir o alinhamento vertical dos elementos filhos dele
<pre>
   	&#60;hbox align="center"&#62;
   	    Elemento alinhado no centro verticalmente em uma linha hbox.
   	&#60;/hbox&#62;
</pre>

##### Podemos usar EL expressions, para chamar instancias implicitas disponiveis no nosso ambiente como o desktop
<pre>
   	&#60;hbox align="center"&#62;
   	    esta é uma variavel implicita ${desktop.webApp.version}
   	&#60;/hbox&#62;
</pre>

##### Para adicionar uma outra página .zul, podemos usar o elemento &#60;apply> ele serve para adicionar Elementos dom dentro de outros sem o css do primeiro afetar o segundo ele cria uma sombra desses elementos que adicionamos.
<pre>
   	&#60;apply templateUri="/pagina.zul"&#62;
</pre>
*infelizmente esse elemento está disponível apenas para o pacote PE e EE do ZKoss então vamos usar o elemento **&#60;include src"/pagina.zul">***

##### Podemos definir estilos css para os elementos usando um elemento dentro do elemento &#60;zk>, o elemento &#60;style> ou podemos puxar um ficheiro css externo com as nossas propriedades. olha as duas formas.
<pre>
    &#60;?link type="text/css" rel="stylesheet" href="path"?>
    &#60;zk&#62;
        &#60;style&#62; 
            .classe{
                background: red;
            }   
        &#60;/style&#62;
    &#60;/zk&#62; 
</pre>

##### Podemos tratar eventos como clique e etc usando zscript, definindo um ouvinte de eventos, desse jeito podemos inserir codigo seja JS, Java, e entre outros, dentro da tag &#60;zcritp> podemos definir uma outra tag chamadas &#60;![CDATA[ codigo vem aqui ]]> que serve para definir codigo que devera ser interpretado fazendo parte do XML, ele é como um comentario mas que faz parta do xml. Veja como:
<pre>
    &#60;zcript&#62;
        &#60;![CDATA[ 
            //Codigo Java
            void ouvidorEvento(String nome){
                java.lang.System.out.println("Imprima - Java no ZK! Parabens " + nome) 
            }  
        ]]&#62;
    &#60;/zcript&#62; 
</pre>
*Este codigo deverá estar dentro da tag &#60;zk>*

##### Após definir o ouvidor de eventos precisamos dizer ao elemento que ele deverá acionar o metodo quando algo acontecer, vamos definir que o elemento ao ser clicado ele deverá acionar o nosso ouvidorEvento(), assim o method vai imprimir na tela o texto.
<pre>
    &#60;zcript&#62;
        &#60;tag onClick='ouvirEvento("Edilson");'&#62; 
               Conteudo da tag.      
        &#60;/tag&#62;
    &#60;/zcript&#62; 
</pre>
Dentro do CDATA podemos chamar variaveis Java que estão impicitas sem precisar especificar com EL expressions.
- Aconselha-se a não se usar o zscript;
- Zscript é lento;
- Não podemos definir breakpoints no zscript;
- Por padrão ele é Java;

### MVC no ZK
##### Como funciona o padrão MVC no ZK? No ZK temos as views representadas pelos ficheiros .zul e temos os Controllers (org.zkoss.zk.ui.util.Composer) represetnado por classes javas normais com metodos que normalmante são metodos que respondem a eventos, e por fim temos o model que é onde o codigo de negocios fica, onde colocamos as regras. quando um evento é disparado temos na tag um no que amara o elemnto ao metodos no controller certo. Olha a imagem.
![alt text](./mvc_flow.jpg?raw=true)

##### Para criar controller
Para criar um Controller devemos criar uma classe normar e herdar de **org.zkoss.zk.ui.select.SelectorComposer** dentro do &#60;x> devemos definir que o component que vai ser entregue será um component (**org.zkoss.zk.ui.Component**) padrão.

Depois disso devemos dizer a nosso view que elá sera manipulada pelo controller X, para fazer isso devemos inserir em um atributo **apply="nomedaclasseabsoluto"** no elemento (Assim os elementos estão ligados). Ex:
<pre>
&#60;tag apply="com.mafurrasoft.dev.controller.PaginaXController"&#62;
&#60;/tag&#62;
</pre>

##### Como amarar um componente na view (.zul) com a variavel no controller Composer?

Para fazer isso deves dizer ao controller que ele é um SelectorComposer(Component), assim o nosso controller passa a permitir esse tipo de anotação **(@Wire)**, vamos ver um exemplo:
 <pre>
 Na view
 
 &#60;tag id="tabela" apply="com.mafurrasoft.dev.controller.PaginaXController"&#62;
 &#60;/tag&#62;
 
 No controller que é um SelectorComposer&#60;que recebe Component>
 
 @Wire
 private Grid tabela;
 </pre>
 
 ##### Como realizar acções antes da view aparecer?
 Para isso devemos subescrever um metodo chamado doAfterCompose(Component comp).
 Esse componente será adicionado pelo proprio ZK não precisamos mecher nisso, então vamos entender melhor.
 Quando esse componente que tem o apply e for inicializada, o controller que tiver o emtodo doAfterCompose(Component comp) vai vai ser executado antes do compoenente ser criado, assim podemos adicionar elemenos dinamicamente antes do carregamento.
 Não esquecá que deves chamar o metodos do pai, com super.doAfterComposer();
 
 O metodo doAfterComposer executa depois da view instanciar os componentes mas antes deles aparecerem na tela. Usamos esse method porque queremos trabalha com os componentes instanciados mas queremos mexer neles antes de aparecerem na tela.
 
 <pre>
    public void doAfterComposer(Component comp){
        super.doAfterComposer();
        //Teu codigo antes do compoonente ser composto na tela.
    }
 </pre>
 
 ##### Eventos e Ouvidores de Eventos
 No ZK temos Eventos e Ouvidores de Eventos, um evento (org.zkoss.zk.event.Event) é uma abstração de uma atividade do utilizados do sistema, ela pode ser clique, mouse por cima e etc, esse vento quando ocorro o navegador envia ele para o servidor, e no servidor se tivermos um ouvidor de evento com os mesmo nome e o mesmo tipo de dado ele vai ser executado, por exemplo, se clicarmos em um botao vamos disparar um evento de clique, um onClique Event, esse evento será enviado directamente para o navegador e se esse botao tiver algum ouvidor de evento registrado esse ouvidor vai ser executado.
 
 Os eventos são um dos recursos mais poderosos do ZK, podemos remover, mover, alterar o comportamento adicionar um novo componente apenas com um evento.
 
 ##### Como criar um evento programaticamente?
 Para criar um componente programaticamente devemos:
 - Criar uma instancia desse compoenente, (ComponenteXYZ compxyz= new ComponenteXYZ());
 - Personalizar as propriedades do componente (compxyz.setLabel("Luis"));
 - Anexar esse componente a um outro usando o appendChild(Componente), (rowz.appendChild(compxyz));
 
 Desse jeito podemos ter o componente na nossa tela.
 
 ##### Como adicionar eventos programaticamnete a um elemento?
 Primeiro para isso devemos criar um objeto do tipo EventListener<Event> que implementa o SerializableEventListener, podemos sar classes anonimas e fazer a declaracao e a implementacao do metodo na mesma linha.
 
 Apos termos a nossa classe anonima devera implementar o method onEvent e escrevemos nesse metodo a nossa regra de negocio ou o que queremos que aconteca quando o evento ser disparado.
 
 Entao a logica é a seguinte, Ter um objecto EventListener que implementa o SeriazableEventListener e depois implementar o method onEvent com a regra d e negocio ou chamamento para um method mais especifico e por fim dizer ao componente que ele agora vai chamar o ouvidor de eventos X quando o evento Y for acionado.
 
 <pre>
    Componente.addEventListener(Events.ON_CLICK, nossoListener);
 </pre>
 
 Agora vamos ver como funciona no padrão MVVM;
 
 #### Padrão MVVM (Model - View - ViewModel)
 O padrao MVVM é muito semelhante ao MVC porem tem umas diferenças sutis, no caso do MVVM a View faz a mesma coisa que no MVC, o Model faz a mesma coisa que no MVC e o ModelView quase como o Controller porem temos uma pequena diferenca, o ViewModel não conhece a view, a view model é independente da view isso diminui a dependencia entre eles. vmaos ver na pratica.
 
 ##### Como chamar uma ViewModel apartir da View Para usar seus dados?
 Para fazer isso devemos definir na view um atributo chamado viewModel, este atributo recebe uma notacao @id('idreferencia') que é o nome que vamos usar para chamar esse objecto neste contexto da view e tambem vamos usar @init('caminhoabsolutodaclasseviewmodel') esta notacao vai instancial ua nossa view model, por isso nossa view model deve ser um POJO (Plain Old Java Object) porque sera instanciado sem nada no construtor. apos isso vamos usar o nome que demos no @id para chamar essa instancia e os metodos dela. vamos ver :
 
 <pre>
    &#60;grid viewModel="@id('produto') @init('com.mafurrasoft.dev.viewmodel.ProdutoViewModel')">
 </pre>
 *Agora podemos chamar produto que aponta para uma instancia de produtoViewModel, assim temos acesso ao metodos e podemos acessar as propriedades*
 
 Mas ainda falta, devemos criar uma model que aponta para a colecao de produtos, para conseguirmos iterar sobre ele, para isso usamo o atributo model no mesmo elemento que usamos o atributo viewModel, mas logo depois, detro do model vamos definir uma notacao @load(produto.produtoActivosRegistradosHoje), imagina que temos um metodos chamado getProdutoActivosRegistradosHoje no nosso viewModel, como esse é um get ele vai logo identificar o metodo certo e teremos uma variavel model que aponta para uma colecao de produtos, ess colocao deve ser uma lista de instancias.
 
  <pre>
     &#60;grid viewModel="@id('produto') @init('com.mafurrasoft.dev.viewmodel.ProdutoViewModel')" model="@load(produto.produtosActivosRegistradosHoje)">
  </pre>
  *Agora temos uma variavel model que aponta para uma colecao de produtos.*
  
  Para iterar sobre essa coecao devemos fazer um template, esse template é como os dados serão arrumas a cada iteracao da colecao. para fazer o temmplate usamos o elemento template que tem umatributo name é qu o nome do model que queremos iterar nele, agora podemos criar a estrutura normal e definar onde cada variavelvai estar,, para chamar um valor no objeto iterando, usamo a palavra each dentro da notacao @load(each.propriedadedomodel) agora podemos trabalhar bem.
<pre>
    &#60;grid viewModel="@id('produto') @init('com.mafurrasoft.dev.viewmodel.ProdutoViewModel')" model="@load(produto.produtosActivosRegistradosHoje)">
        ...
        &#60;template name="model">
            &#60;row>
                &#60;label value="@load(each.designacao)">
                &#60;image src="@load(each.caminho)">   
            &#60;/row>
        &#60;/template>
    &#60;/grid>
</pre> 

Como podemos adicionar e manipular eventos?
Para isso devemos usar o command que é usado na viewModel, Command é um metodo da viewModel que manipula alga na view, se um metodo tem essa anotacao significa que pode manipular lago na view, como remover e adicionar dados na lista.

O sistema de ligacao de dados suporata lisgar enventos tambem, podemos fazer com que um evento chame um comando na viewModel e ate entregar daos para esse comando.

para fazer isso devemos no elemento que queremos que seja o pivo devemos adicionar o atributo do evento que qqueremos tratar e depois inserir uma anotacao @commmand('nome_do_metodo_command', variavel = each), assim estamos a dizr ao elemeno qeu se tiver um evento x ele deverá procurar um comando, metodo com a anotacao comand com o nomes nome_do_metodo_command e atribuir ao parametro como argumento o objecto, model each (na verdade é mapear o objeto).

<pre>
     &#60;row onClick="@command('adicionarNoCarrinho', produto=each)" >
  </pre>

no nosso viewModel devemos então criar o metodo @Command e dar o mesmo nome que demos no @command do elemento, por fim devemos definir que ele vai fazer a aligacao do parametro que eu entregei para o mesmo tipo que eu espero no parametro, para isso usamos a notacao @BindingParam("nome_do_argumento"). Olha como ficará:
<pre>
     @Commmand
     public void adicionarNoCarrinho(@BindingParam("produto") Produto produto){
        ...
     }
</pre>
*Note que o nome do argumento pode ser diferente do nome do bindingParam*

**Agora sim já sabe como relacionar com MVVM.**

#### Novos elementos e atributos ;)
&#60;window> - este componente é usado para agrupar outros componentes, ele tem uma carasterirticas ser iDSpace o que significa que dentro dele temos outro espaço de IDs podemos repitir os IDs  de dentro fora dele.

Ele aceita uma tag chamada caption que cria meio que um titulo essa caption aceita label(rotulo) e imagens, vamos ver eles em funcionamento:

<pre>
    &#60;window>
        &#60;caption label="Rotulo do window" src="caminho_da_imagen"/>
    &#60;/window>
</pre>

&#60;vlayout> e &#60;hlayout> - Estes elemento sao semelhantes que o vbox e o hbox porem com uma diferença eles são mais leves e não possuem atributos como align, pack e splitter.

atributo hflex ou vflex com o valor min, serve para limitar o componente a não exceder o tamanho do espaço onde está, apenas conter os dados.

O elemento cell é usaod dentro de row, hbox, vbox para nos dar um amir controllo sobre o alinhamento, expansao das colunas e linhas e do comprimento de uma linha individual.

##### Para fazer input de dados
Para fazer input de dados temos varios elementos, mas os mais usados são: campo de texto (textbox) e data(datebox), veja um exemplo:
<pre>
    &#60;textfield id="nome"/>
    &#60;datebox id="dataNascimento">
</pre>

Podemos tambem definir regras para os dados, assim o usuario não vai inserir dados invalidos.

Olha como :  

<pre>
    &#60;textfield id="nome" contraint="no empty: Preencha o campo desgraça!"/>
    &#60;datebox id="dataNascimento" constraint="no future: Essa é mesmo sua data?">
</pre> 
 
 Para carregar dados nos compoenetes podemos usar o metodo que vimos antes o .doAfterCompose(Component comp);
 
 Para manipular os elementos da view podemos usar o @wire para obter os as instancias.
 
 ##### Novo elemento ListBox
É com componente usado para criar caixas de listas que podem ser multi selecionavei ou nao, usando mold="select", estas lista podem ocupar tota tela se não definirmos um molde, elas tem uma aparencia como a tabela.
<pre>
    &#60;listbox mold="select">
</pre>



Para definir um item como selecionado programaticamete usamos o metodo .addToSellection(item ou items) que serão marcados como selecionados.

##### Uma breve explicação sobre Component, Model e Template

Os componentes Zk foram feitos para aceitar diferentes tipos de objectos model que contem dados para serem rederizados, os componentes que recebem esses dados vão rederizar de acordo com o template que foi definindo no elemento &#60;template>. 

*Esse tipo de abordagem contribui para a teoria da responsabilidade unica, onde nos mantemos a reusabilidade dos dados e do componente quando separamos aimplementacao do componente com os dados, podedendo assim usar os mesmos dados com outros componentes apenas trocando a implementacao neles*

##### Para isso devemos criar priemrio um molde de dados
Podemos usar o molde ListModelList&#60;TIpodeDado>, de pois podemos coloca-la dentro de uma listbox com o metodo setModel(); Olha como fica:
<pre>
    ListModelList&#60;String> paises = new ListModelList&#60;String>(UtilService.getListaDePaises());
    paisesListBox.setModel(paises);
</pre>

Depois devemos definir um template para o model que vamos enviar, definindo como os dados seráqo apresentados no listbox, nesse template definimos o nome dele que será molde porque é o que enviamos do controller para a listbox e depois podemos especificar onde cada daos vai estar usando EL Expression ${each};
<pre>
    &#60;listbox id="paisesListBox" model="select" width="500px">
        &#60;template name="model">
            &#60;listitem label="${each}">
        &#60;/template>
    &#60;/listbox>
</pre>
-Devemos definir o atributo name do template como model, porque assim estamos dizendo ao template que aquele é um molde para ele trabalhar nele;
- Podemos acessar cada item da iteracao do molde usando ${each.propriedade}, que acessa variaveis implicitas.
*listitem é um elemnto filho de lisbox, representa um item do listbox e nos vamos repitir o lisitem ate o numero de iteracoes terminar.*

##### Como adicionar dados aos componentes?
A maior parte dos componente permite que sejam adicionadaos dados dinamicamente usando o metodo .setValue(dados);

#### Outra forma de definir um ouvidor de evento


 





