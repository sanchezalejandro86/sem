package org.example.sem;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SEM {

    public static Map<Integer, Integer> process(int [] numbers){
        Stack<Integer> s = new Stack<Integer>();
        Map<Integer, Integer> result = new HashMap<>();

        int element, next;

        /* agrega el primer elemento a la pila */
        s.push(numbers[0]);

        // se itera el resto del array
        for (int i = 1; i < numbers.length; i++) {
            next = numbers[i];

            if (s.isEmpty() == false) {
                // Si la pila no está vacía, extrear un elemento de la pila
                element = s.pop();

                /* Si el elemento extraido es más chico que "next", entonces se imprime el par y se continua
                extrayendo mientras los elementos sean más chicos y la pila no esté vacía */
                while (element < next) {
                    result.put(element, next);

                    if (s.isEmpty() == true)
                        break;
                    element = s.pop();
                }

                /* Si el elemento es más grande que "next", entonces regresar el elemento a la pila */
                if (element > next)
                    s.push(element);
            }

            /* agregar "next" a la pila para encontrar el siguiente más grande para este */
            s.push(next);
        }

        /* Luego de iterar sobre el array, los elementos restantes en la pila no tienen siguiente elemento mayor
           por lo que se imprime -1 para ellos */
        while (s.isEmpty() == false)
        {
            element = s.pop();
            next = -1;
            result.put(element, next);
        }

        return result;
    }

    public static void main(String []args){
        int[] arr1 = new int[]{4, 5, 2, 25};
        Map<Integer, Integer> result1 = SEM.process(arr1);
        printResults(arr1, result1);

        int[] arr2 = new int[]{13, 7, 6, 12};
        Map<Integer, Integer> result2 = SEM.process(arr2);
        printResults(arr2, result2);
    }

    private static void printResults(int[] numbers, Map<Integer, Integer> results){
        System.out.println("Elemento\t\tSEM");
        for (int i=0; i<numbers.length; i++) {
            System.out.println(numbers[i] + "\t\t-->\t" + results.get(numbers[i]));
        }
        System.out.println("================================");
    }
}
