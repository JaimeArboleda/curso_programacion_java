# Sentencias

Aunque ya hemos usado todas estas sentencias en los temas anteriores (si no, no habría sido posible programar) vamos a recapitular las principales.

## Bucles

Los tipos de bucles existentes son: 
* while(condicion), que se ejecuta tantas veces como la condición sea cierta. 
* for(inicializacion; condicion; actualizacion), que se ejecuta tantas veces como la condición sea cierta. En el bucle for podemos incluir, en la actualización, varias sentencias separadas por comas. 
* do...while, que es similar a while pero que garantiza que al menos se ejecuta una vez, independientemente de la condición. Es raramente usado. 

## Condiciones lógicas

Hemos visto ya el bloque if...else, que puede anidarse. También existe un switch...case que resulta útil cuando una variable puede tomar un número finito de valores y queremos hacer algo para cada valor o rango de valores. Sintaxis: 

```java
switch(expresion) {
  case x:
    // code block
    break;
  case y:
    // code block
    break;
  default:
    // code block
}
```
Si no ponemos breaks, al darse una de las condiciones, las siguientes también se ejecutan! 

## Excepciones

Las excepciones se producen cuando algo ha ido mal. Algunos ejemplos son: cuando se pasa un argumento incorrecto a una función, cuando se hace una operación no definida (como dividir por cero), cuando se intenta acceder a atributos de un objeto usando una referencia que es null, cuando se hace un cast que no es válido, etc. 

Lo ideal es controlar las excepciones para evitar que el programa tenga una salida imprevista (que "pete").

Lo que necesitamos saber es que: 
* Las excepciones son objetos de la clase Exception (o de alguna subclase; ya veremos lo que significa esto).
* Para lanzar una excepción usaremos throw, que interrumpe la ejecución de un método y lanza la excepción (podemos entender la excepción como si fuera la salida "no estándar" cuando hay un error).
* En la definición de un método que puede lanzar excepciones debemos añadir esta información en la cabecera con la palabra clave throws (ojo, no [todas](https://stackoverflow.com/questions/11589302/why-is-throws-exception-necessary-when-calling-a-function) las excepciones hay que declararlas). 
* Cuando ejecutamos una sentencia que puede lanzar excepciones, la envolvemos con try (que contiene el bloque "peligroso") y catch (que contiene el código que se ejecuta cuando se produce el problema).

Veamos un ejemplo completo: 

```java
public class Main {
  static void checkAge(int age) throws ArithmeticException {
    if (age < 18) {
      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
    }
    else {
      System.out.println("Access granted - You are old enough!");
    }
  }

  public static void main(String[] args) {
    try {
        checkAge(15); // Set age to 15 (which is below 18...)
    } catch (Exception e) {
        System.out.println("Something went wrong");
    }
    // do stuff...
  }
}
```

# Referencias

* [Java Conditions](https://www.w3schools.com/java/java_conditions.asp)
* [Java Switch](https://www.w3schools.com/java/java_switch.asp)
* [Java While loop](https://www.w3schools.com/java/java_while_loop.asp)
* [Java For loop](https://www.w3schools.com/java/java_for_loop.asp)
* [Java Break](https://www.w3schools.com/java/java_break.asp)
* [Java for loop in arrays](https://www.w3schools.com/java/java_arrays_loop.asp)
* [Java Exceptions](https://www.w3schools.com/java/java_try_catch.asp)
* [Java Throws](https://www.w3schools.com/java/ref_keyword_throws.asp)
* [Java Exceptions Oracle tutorial](https://docs.oracle.com/javase/tutorial/essential/exceptions/definition.html)