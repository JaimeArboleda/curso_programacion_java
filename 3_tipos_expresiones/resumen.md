# Tipos y expresiones

Como ya hemos dicho, toda variable está definida con un tipo, que puede ser o bien primitivo o bien una clase.

## Clasificación de tipos

En primer lugar, clasificamos entre primitivos y no primitivos. 

### Tipos primitivos

Algunas características son: 
* Están predefinidos en Java. 
* Una variable de tipo primitivo siempre tiene un valor (incluso cuando no se da explícitamente un valor, hay un valor por defecto; por ejemplo, un entero tiene por defecto el valor 0).
* Los nombres de estos tipos empiezan por letras minúsculas (a diferencia de los no primitivos).
* El tamaño del tipo depende del tipo en sí, porque la variable almacena directamente el contenido, y no una referencia. Se almacenan en la pila (stack). 

Veamos ahora los tipos primitivos existentes: 

|Tipo | Tamaño | Descripción |
|-|-|-|
|byte | 1 byte | Almacena números enteros entre -128 y 127.|
|short | 2 bytes | Almacena números enteros entre -32768 to 32767.|
|int | 4 bytes | Almacena números enteros entre -2147483648 to 2147483647.|
|long | 8 bytes | Almacena números enteros entre -9223372036854775808 to 9223372036854775807. |
|float | 4 bytes | Almacena números decimales, hasta 6-7 dígitos. Apenas se usa. |
|double | 8 bytes | Almacena números decimales, hasta 15 dígitos.  |
| boolean | 1 bit | Almacena un valor lógico, verdadero o falso. |
| char | 2 bytes | Almacena un carácter de texto ASCII. |

#### Operaciones con tipos primitivos

Los operadores más importantes son: 
* Operadores lógicos, para *boolean*: 
  * &&, que es el AND lógico.
  * ||, que es el OR lógico.
  * !, que es el NOT lógico.
* Operadores de aritmética entera, para *byte*, *short*, *int*, *long*:
  * +, -, *, /, con los significados usuales (ojo, / es el cociente en la división entera). 
  * %, que es el resto de la división entera. 
  * Comparadores: ==, !=, <, >, <=, >=.
  * Suma/resta y asignación: ++, --.
* Operadores de aritmética real, para *float*, *double*:
  * +, -, *, /, con los significados usuales (ojo, / es el cociente con decimales). 
  * Comparadores: ==, !=, <, >, <=, >=.
  * Suma/resta y asignación: ++, --.
  * Otros operadores matemáticos usando la clase Math. Por ejemplo, la potencia con Math.pow(a, b)...

Es importante tener en cuenta varios aspectos: 
* Conversiones de tipos (casting):
  * Implícitas: las hace Java automáticamente cuando hay discrepancia de tipos. Se usa el menor tipo superior compatible. Por ejemplo, 3/4.0 dará como resultado una división decimal, no entera (el 3 se convierte a double implícitamente). 
  * Explícitas: se pone entre paréntesis el tipo que se quiere convertir. Por ejemplo, 3/((int) 4.0) si queremos una división entera. Las conversiones explícitas se pueden aplicar también a tipos no primitivos, pero en ese caso se pueden producir errores en tiempo de ejecución. 
* Overflow y underflow. Si una variable tiene un tipo "pequeño" e intentamos asignarle un valor más grande, se produce un desbordamiento y el valor pasará a ser negativo. Ejemplo: si a un byte b con valor b=127 le aplicamos b++, b pasará a tener el valor -128. 

Nota: para definir un char usamos comillas simples, 'a'. Con comillas dobles estaríamos definiendo un String.
Nota 2: para definir un boolean, usaremos true, false.
Nota 3: caracteres especiales: '\n' (salto de línea), '\t' (tabulador)...

### Tipos no primitivos.

Los tipos no primitivos incluyen entre otros: 
* Clases predefinidas en Java (como String u otras más específicas).
* Clases definidas por el programador. 
* Arrays. 
* Enums.

A diferencia de los tipos primitivos, pueden no tener un valor (en ese caso, el valor sería null). No contienen el valor en sí, sino la referencia a donde está almacenado el valor. Se almacenan en el montón (heap).

La clase String contiene métodos útiles como length(). A diferencia de otros lenguajes, los caracteres de un string no pueden ser accedidos con corchetes. Si queremos obtener el caracter de una posición dada, u obtener un substring, haremos charAt() o substring().

Los enums son clases especiales que sirven para definir grupos de constantes (definidas con mayúsculas). Ejemplo: 

```java
enum Nivel {
  BAJO,
  MEDIO,
  ALTO
}

Nivel var = Nivel.BAJO;
```

Sirven para modelar objetos que sólo pueden tomar un número finito de valores. 

Los arrays son vectores de tipo fijo y longitud fija. Se pueden definir también arrays multidimensionales (vectores de vectores; vectores de vectores de vectores...). Pero siempre de tipo fijo y longitud fija (para arrays más flexibles está la clase ArrayList que veremos en el último capítulo).

Los elementos de un array sí pueden extraerse con corchetes. Por ejemplo, si a es un array bidimensional, a[0][1] sería la posición segunda del primer vector (se empieza en 0).

El tipo de un array puede ser tanto primitivo como no primitivo. 

Ejemplo: 

```java
//Dos maneras equivalentes de inicializar un array bidimensional de enteros
int[][] vec = new int[2][2];
vec[0][0] = 1;
vec[0][1] = 1;
vec[1][0] = 2;
vec[1][1] = 3; 

//Segunda manera
int[][] vec = {{1, 1}, {2, 3}};

```

