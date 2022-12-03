package semana_13;

public class Semana_13 {

    public static void main(String[] args) {
        int [] lista = {1,2,3,4};
        System.out.println(lista);
    }

    public static void intercambiar(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    public static void ordIntercambio(int a[]) {
        int i, j;
        for (i = 0; i < a.length - 1; i++) {
            for (j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    intercambiar(a, i, j);
                }
            }
        }
    }

    public static void ordSeleccion(double a[]) {
        int indiceMenor, i, j, n;
        n = a.length;
        for (i = 0; i < n - 1; i++) {
            indiceMenor = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[indiceMenor]) {
                    indiceMenor = j;
                }
                if (i != indiceMenor) {
                    intercambiar(a, i, indiceMenor);
                }
            }
        }
    }

    public static void ordInsercion(int[] a) {
        int i, j;
        int aux;
        for (i = 1; i < a.length; i++) {
            j = i;
            aux = a[i];
            while (j > 0 && aux < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = aux;
        }
    }

    public static void ordenacionShell(double a[]) {
        int intervalo, i, j, k;
        int n = a.length;
        intervalo = n / 2;
        while (intervalo > 0) {
            for (i = intervalo; i < n; i++) {
                j = i - intervalo;
                while (j >= 0) {
                    k = j + intervalo;
                    if (a[j] <= a[k]) {
                        j = -1; // par de elementos ordenado
                    } else {
                        intercambiar(a, j, j + 1);
                        j -= intervalo;
                    }
                }
            }
            intervalo = intervalo / 2;
        }
    }

    private static void quicksort(double a[], int primero, int ultimo) {
        int i, j, central;
        double pivote;
        central = (primero + ultimo) / 2;
        pivote = a[central];
        i = primero;
        j = ultimo;
        do {
            while (a[i] < pivote) {
                i++;
            }
            while (a[j] > pivote) {
                j--;
            }
            if (i <= j) {
                intercambiar(a, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (primero < j) {
            quicksort(a, primero, j); // mismo proceso con sublista izqda
        }
        if (i < ultimo) {
            quicksort(a, i, ultimo); // mismo proceso con sublista drcha
        }
    }
}
