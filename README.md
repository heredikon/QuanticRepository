# Libreria de numeros Complejos

Este repositorio es una libreria de operaciones que se podran realizar con numeros complejos, Vectores y matrices, la primer parte de este son las operaciones basicas
1.  Suma
2.  Producto
3.  Resta
4.  División
5.  Módulo
6.  Conjugado
7.  Conversión entre representaciones polar y cartesiano
8.  Retornar la fase de un número complejo.
9.   Adición de vectores complejos.
10. Inversa de vectores complejos.
11. Multiplicación escalar de vectores complejos.
12. Adición de matrices complejos.
13. Inversa de matrices complejos.
14. Multiplicación escalar de matrices complejas.
15. Matriz transpuesta  
16. Matriz conjugada
17. Matriz adjunta
18. Función para calcular la "acción" de una matriz sobre un vector.
19. Norma de matrices
20. Distancia entrematrices
21. Revisar si es unitaria
22. Revisar si es Hermitian
23. Producto tensor.


## Instrucciones de uso

Para utilizar esta herramienta  se debe clonar el repositorio de github:

    git clone https://github.com/heredikon/QuanticRepository
    
posteriormente debe con la ayuda de un editor (netbeans, eclipse, etc).
para utilizarse en otro programa es necesario importar la calculadora y el objeto de numero complejo.

    import "route"/Basic;
    import "route"/Complex;
## Resultados de tests
![enter image description here](https://lh3.googleusercontent.com/_fA7489_lcdmvN67c06Rk7mgZeDQ80xFReF2hPNlCkn4zza_OMoDnLoAO1tEle9f9-NjtQJ8EC0B "Tests")

### Ejemplos de tests
  ```Java
    public void testDeberiaDividirDosNumeroComplejos1() {
        Complex c1 = new Complex(5, 0);
        Complex c2 = new Complex(0, 2);
        Complex result1 = basic.divide(c1, c2);
        Complex resultToCompare1 = new Complex(0, -2.5);
        assertTrue(resultToCompare1.equals(result1));

        Complex c3 = new Complex(0, 5);
        Complex c4 = new Complex(2, 0);
        Complex result2 = basic.divide(c3, c4);
        Complex resultToCompare2 = new Complex(0, 2.5);
        assertTrue(resultToCompare2.equals(result2));
        
    public void testDeberiaRealizarLaSumaDeMatrices() {
        Complex[][] m1 = {{new Complex(2, 3), new Complex(4, 5)},
			        {new Complex(3, 0), new Complex(1, 5)}};
        Complex[][] m2 = {{new Complex(2, 3), new Complex(4, 5)}, 
			        {new Complex(3, 1), new Complex(1, 5)}};
        Complex[][] result1 = basic.sumM(m1, m2);
        Complex[][] resultToCompare1 = {{new Complex(4, 6), new Complex(8, 10)},
					      {new Complex(6, 1), new Complex(2, 10)}};
        assertTrue(basic.equalsM(result1, resultToCompare1));
 ```


## Autor

Fabian Camilo Bohorquez Heredia

Administrador de empresas

Estudiante de Ingenieria de sistemas

**Escuela Colombiana De Ingenieria Julio Garavito**

