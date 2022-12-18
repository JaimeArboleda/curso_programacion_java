Tenemos que tener cuidado y compilar las clases de manera ordenada y añadiendo los classpath cuando sea necesario. 

La idea es que para compilar un fichero .java, todas las clases de las que depende tienen que estar compiladas y visibles para el compilador. El compilador utilizará el classpath como base para buscar todos los demás paquetes. 

Es un proceso complejo que se vuelve inviable en cuanto el proyecto crece en complejidad. Para esto existen herramientas como maven. 

Estos comandos deben ejecutarse en la carpeta 1_PAQUETES:

```bash
javac -d classes src/persona/Persona.java
javac -d classes -cp classes src/Empresa/Empresa.java
java -cp classes empresa/PruebaEmpresa
```

Explicación: 
* Como estamos ejecutando los comandos de javac y java en la carpeta 1_PAQUETES, esa es la que tiene por defecto el classpath. 
* En el primer comando, no necesitamos especificar el classpath porque no hay dependencias. Sólo indicamos dónde deben guardarse los ficheros de bytecode .class. Observa que se guardan de manera jerárquica, preservando la estructura de carpetas. 
* En el segundo comando necesitamos especificar el classpath. 
* En el tercer comando, para ejecutar, también necesitamos especificar el classpath, pues de lo contrario no encontrará los ficheros. Otra opción sería irnos a la carpeta classes y ejecutarlo desde ahí. 