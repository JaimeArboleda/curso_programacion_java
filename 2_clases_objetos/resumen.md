# Clases y objetos

¿Qué es una clase Java? Debemos verlo como un patrón o un modelo a partir del cual poder generar instancias. Por ejemplo, si queremos hacer un programa que reproduzca canciones, tendríamos clases como Artista, Album o Cancion. A partir de ellas, generaríamos los artistas, albumes y canciones particulares. ¿Qué va dentro de una clase? Fundamentalmente dos cosas: información (o datos, o estado) y comportamiento (o acciones que podemos hacer con ella). 

Veamos un ejemplo con la clase Cancion:

```java
public class Cancion{
    String titulo;
    String estilo;
    int duracion;

    void reproducir(){
        System.out.println("Estoy reproduciendo la cancion llamada " + titulo + " en el estilo " + estilo);
    }
}
```

En la primera parte de la clase hemos definido algunos atributos de la misma, y en la segunda las acciones que podemos hacer con ella. A las acciones las llamamos métodos.

En la definición de la clase indicamos los datos que podemos albergar, pero no el contenido concreto. Por otro lado, el comportamiento puede (y suele) estar influido por el estado o contenido concreto de los atributos.

El otro concepto importante es el de objeto. Un objeto es un ejemplo particular de una clase, en el que hemos dado valores concretos a los atributos. 

Una analogía para entender la diferencia entre clases y objetos es la siguiente: podemos pensar que las clases son categorías o conceptos del pensamiento, y los objetos ejemplos particulares de esas categorías. Así, por ejemplo, existe el concepto *perro* -que sería lo análogo a la clase- y los millones de perros concretos -que serían lo análogo al objeto-. 

# Estructura de un programa en Java

Un programa en Java es un conjunto de clases Java. Cada clase Java está en un fichero .java, y a su vez un fichero .java puede contener varias clases (sólo una de ellas puede ser pública). En esta asignatura por simplicidad usaremos un único fichero .java, pero no es lo habitual. 

Así que en general tendremos un fichero .java donde hay una o varias clases. Y en una de ellas -y sólo en una- debe haber un método con la siguiente signatura: 

```java
public static void main(String[] args){
    ...
}
```

Este es el punto de entrada de todo programa Java. Como no usaremos interfaces gráficas en esta asignatura, interactuaremos con la línea de comandos. args contiene el conjunto de argumentos pasados por línea de comandos. Veamos el proceso de compilar y ejecutar un archivo .java. Supongamos que tenemos un archivo llamado MiClase.java. Entonces, primero haremos: 

```bash
javac MiClase.java
```

Esto compilará el fichero generando varios ficheros .class, que contienen el bytecode o código máquina. 

Y luego:

```bash
java MiClase arg1 arg2...
```

Detrás de MiClase podemos añadir varios argumentos (o ninguno), que se meterían dentro de la lista de args en el método main. 

# Valores y referencias. Paso de argumentos.

Veamos la diferencia entre valor y referencia. Supongamos este código donde definimos dos variables: 

```java
int a = 5;
Perro p = new Perro("Bobby"); 
```

En el primer caso, la variable a contiene directamente el valor que se le ha asignado. En este caso, 5. Esto es por ser un tipo básico (en el tema siguiente veremos todos los tipos básicos existentes). 

En el segundo caso, la variable p, que es de un tipo no básico, no tiene el valor del objeto Perro (de nombre "Bobby"). Tiene una referencia a la región de memoria donde están mapeados los atributos del objeto. En otros lenguajes a este tipo de variables se les llama punteros. Es una "flecha" a una región de memoria. La primera implicación es que, si comparamos dos variables de tipo perro, siempre serán distintas (incluso teniendo todos los campos iguales) salvo que sean en realidad la misma referencia al mismo objeto. 

La segunda implicación tiene que ver con el paso de parámetros en las funciones. Supongamos que tenemos estas dos funciones -métodos-:

```java 
void metodo_1(int a){
    a++;
    return a;
}

void metodo_2(Perro p){
    p.edad++;
    return p
}
```

Los argumentos a las funciones siempre se pasan por valor y no por referencia. Esto es, a la función se le pasa una copia de los argumentos, y no las variables originales. Esto quiere decir que las dos funciones anteriores se comportan de manera diferente: 
* La primera no modificará la a, porque a la función se ha pasado una copia del entero original, y modificar dentro del cuerpo de la función la a no afecta a la variable. 
* La segunda, en cambio, recibe una copia de la referencia de perro. Esto es una copia que apunta a la misma zona de memoria que la variable original. Es decir, el perro no se copia; sólo se copia su dirección. Por tanto, la modificación que sucede dentro sí afecta al perro original. 