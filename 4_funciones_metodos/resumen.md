# Funciones y métodos

Los métodos o funciones contienen todo el código que es ejecutado por la JVM. Aunque no lo hemos hecho explícito hasta ahora, en Java se cumplen las siguientes propiedades: 
* Todas las sentencias (donde sentencia es una línea de código que hace algo, como cambiar el valor de una variable, invocar a un método, ejecutar un bucle o una condición lógica, etc.) se ejecutan dentro de métodos. Por tanto, en sentencias no incluimos la definición de clases, la definición de atributos de clases, y los imports, que es lo único que quedaría "fuera" de los métodos.
* Todos los métodos pertenencen a una clase. No es posible definir un método que no esté atado a una determinada clase. Esto es un contraste con otros lenguajes donde hay métodos (de clase) y funciones generales. En Java no. Tampoco es posible escribir métodos dentro de métodos. 

Algunos métodos especiales que suelen definirse en muchas clases son: 
* Constructor o constructores. 
* Getters y setters para los atributos. 
* Equals para comparar dos objetos de la clase. 
* ToString. 

# Partes de un método

Un método se compone de cabecera y cuerpo. La cabecera es la primera línea donde definimos los modificadores (public, private, static... que ya veremos...), el tipo devuelto, si lanza o no excepciones y los argumentos de entrada con sus tipos. El cuerpo es el conjunto de sentencias del método. 

La cabecera determina la signatura, que viene definida por:

* Nombre del método.
* Número de argumentos del método.
* Orden en el que se declaran los argumentos en cada método.
* Tipo de dato de cada argumento.

Pero no tiene en cuenta:

* El tipo de retorno, en el caso de que exista.
* El modificador de acceso.
* Los nombres dados a los argumentos. 

La signatura sirve para que Java determine qué metodo de la clase es el que se pretende ejecutar, ya que una clase puede tener varios métodos con el mismo nombre y diferente signatura. 

Por ejemplo, dado:

```java
public int miMetodo(int x, double y){
    ...
}
```

La signatura sería "miMetodo(int, double)".

Nota: si desde un método queremos llamar a otro método del mismo objeto, usaremos la palabra reservada "this" para referirnos a la instancia actual que está ejecutando el método. Por ejemplo imaginemos que tenemos dos métodos, a y b y queremos que a llame a b, haremos así:

```java
public int a(int x){
    return this.b(x) * 7;
}

public int b(int x){
    return x + 1;
}
```

# Visibilidad

Dentro de un método se tiene acceso a:
* Los atributos del objeto (salvo si el método es estático, que ya veremos).
* Los argumentos de la función (pasados por valor, como ya dijimos, de manera que se dispone de copias en el caso de tipos primitivos y de referencias a los objetos en caso de tipos no primitivos).
* Las variables que definamos dentro del método. Si definimos variables dentro de un subgrupo de sentencias (por ejemplo, en un bucle for), estas variables "morirán" al terminar el bloque.

# Referencias

* [Java Methods](https://www.w3schools.com/java/java_methods.asp)
* [Java Method Parameters](https://www.w3schools.com/java/java_methods_param.asp)
* [Java Method Overloading](https://www.w3schools.com/java/java_methods_overloading.asp)
* [Java Scope](https://www.w3schools.com/java/java_scope.asp)
* [Java Recursion](https://www.w3schools.com/java/java_recursion.asp)