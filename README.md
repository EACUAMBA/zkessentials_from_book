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
 
 ##### COmo criar um evento programaticamente?
 Para criar um componente programaticamente devemos:
 - Criar uma instancia desse compoenente, (ComponenteXYZ compxyz= new ComponenteXYZ());
 - Personalizar as propriedades do componente (compxyz.setLabel("Luis"));
 - Anexar esse componente a um outro usando o appendChild(Componente), (rowz.appendChild(compxyz));
 
 Desse jeito podemos ter o componente na nossa tela.
 
 
 
 
 




