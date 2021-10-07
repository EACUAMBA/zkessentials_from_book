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


