# Encapsulación y diseño

En una aplicación Java compleja usaremos un gran número de clases. Para gestionarlas, las clases se suelen repartir en *paquetes*. Si hacemos la analogía con la organización de archivos o documentos en un ordenador, las clases serían los archivos concretos y los paquetes las carpetas. Podemos anidar paquetes de la misma manera que anidamos carpetas. 

Cuando en un fichero .java queremos usar una clase no definida en dicho fichero, usaremos un import con la ruta al paquete donde se encuentra dicha clase. 

Por ejemplo, supongamos que las siguientes clases: Persona, en un paquete persona, y Empresa y PruebaEmpresa, ambas en un paquete empresa. Supongamos que la Empresa se compone de personas, por lo que en la clase Empresa importaremos la clase Persona. En este ejemplo tendríamos la siguiente estructura de carpetas:

```
proyecto
│
└───empresa
│   │   Empresa.java
│   │   PruebaEmpresa.java
│   │
└───persona
    │   Persona.java
```

Y las siguientes líneas de código: 

```java
//En Empresa.java
package empresa;
import persona.Persona;
...
```

```java
//En PruebaEmpresa.java
package empresa;
import persona.Persona;
import empresa.Empresa;
...
```

```java
//En Persona.java
package persona;
...
```
Nota: a partir de Java 9 también hay módulos, pero no los usaremos en la asignatura. 

# Modificadores

Veamos los modificadores que podemos usar sobre clases, métodos y atributos. 

## Modificadores de acceso

### Clases

Sólo hay dos: 
* public: la clase es accesible para otras clases.
* default (si no se pone nada, se aplica éste): la clase sólo es accesible para las clases del mismo paquete. 

### Métodos, atributos y constructores

Hay cuatro:
* public: el código (método o atributo) es accesible para otras clases.
* private: el código (método o atributo) es accesible en la propia clase.
* default: el código (método o atributo) es accesible para las clases del mismo paquete. 
* protected: el código (método o atributo) es accesible para las clases del mismo paquete y para las subclases que la extiendan.

Para entender la diferencia entre los dos últimos, supongamos este ejemplo con dos paquetes:

```
proyecto
└───persona
│   │   Persona.java
└───empleado
    │   Empleado.java
```
Y supongamos que Empleado extiende a Persona (en el siguiente capítulo veremos herencia). En este caso, 
* Empleado podrá acceder a los atributos y métodos protected de Persona.
* Empleado no podrá acceder a los atributos y métodos default de Persona.

Los atributos private se usan por encapsulación: al hacerlos private y sólo dejar acceso a ellos (si acaso) mediante getters y setters, proporcionamos maneras de controlar la forma en que se asigna o se recupera el valor de los atributos. Sobre todo, permite modificar el código sin afectar a otras clases que ya estén haciendo uso de getters y setters.

## Otros modificadores

### Clases

Hay dos modificadores:
* final, que indica que la clase no puede ser extendida (no se pueden definir subclases).
* abstract, que indica que la clase no puede ser instanciada (para crear instancias de la misma, es necesario definir primero subclases que no sean abstractas).

### Métodos, atributos y constructores

Los principales son (hay otros que no veremos): 
* final, que indica que estos atributos o métodos no pueden ser modificados -atributos- o sobreescritos -métodos- por subclases. Un atributo final es a todos los efectos una constante. En el caso de atributos lo más normal es definirlos como static final, ya que son constantes y no tiene sentido que no sean statics. 
* static, que indica que son atributos o métodos de la clase y no de las instancias. En el caso de métodos, sólo pueden hacer uso de atributos static. 
* abstract, que sólo es aplicable a métodos de clases abstractas. Estos métodos no tienen cuperpo y se definen así para especificar que las subclases no abstractas tienen que proporcionar una implementación. También es importante para el funcionamiento correcto del polimorfismo. 

Nota: final también puede aplicarse a variables definidas dentro de un método, con el mismo significado (constantes).

Nota 2: una variable final se puede inicializar de manera condicional, siempre que su valor, una vez asignado, no cambie nunca. Por ejemplo, esto es válido: 

```java
final int DIAS_FEBRERO;
if (bisiesto) {
    DIAS_FEBRERO = 29;
} else {
    DIAS_FEBRERO = 28;
}
// A partir de aquí, si se intentara cambiar el valor de DIAS_FEBRERO habría una excepción. 
```

# Documentación

La manera más adecuada de documentar es usando JavaDoc, que es el estándar para documentar clases y métodos. Permite generar de manera automática páginas web estáticas que representan la estructura del código y las dependencias. Es muy útil en proyectos grandes. 

Ejemplo de documentación de un método:

```java
 /**
  * Inserta un título en la clase descripción y devuelve el id.
  * Al ser el título obligatorio, si es nulo o vacío se lanzará
  * una excepción.
  *
  * @param titulo El nuevo título de la descripción.
  * @return El identificador dado al título
  * @throws IllegalArgumentException Si titulo es null, está vacío o contiene sólo espacios.

  */
 public int setTitulo (String titulo) throws IllegalArgumentException {...}
```

Otros identificadores importantes son: 
* @author
* @see
* @deprecated

# Referencias

* [Java Modifiers](https://www.w3schools.com/java/java_modifiers.asp)
* [Java Encapsulation](https://www.w3schools.com/java/java_encapsulation.asp)
* [Java Packages](https://www.w3schools.com/java/java_packages.asp)
* [Java Packages and workspaces](https://www3.ntu.edu.sg/home/ehchua/programming/java/J9c_PackageClasspath.html)
* [Java Doc](https://es.wikipedia.org/wiki/Javadoc)