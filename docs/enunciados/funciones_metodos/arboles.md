Hacer una clase Nodo y una clase Arbol. 

La clase Arbol se caracterizará por un nodo raíz. 

La clase Nodo tendrá uno o ningún nodo padre (cuando es raíz no hay padre) y cero o varios hijos (cuando es hoja no hay hijos).

La clase nodo tendrá dos atributos extra: 
* Nombre.
* Peso. 

La clase Árbol tendrá dos métodos recursivos:
* calcularProfundidad, que calcula la profundidad del árbol. 
* calcularCaminoOptimo, que calcula el camino de la raíz a alguna de las hojas que tenga una suma de pesos menor. 

Y también un método no recursivo toString() que escribirá el árbol en formato plano usando dos espacios para representar los cambios de nivel. Para cada nodo se pondrá el nombre y entre paréntesis el peso. 