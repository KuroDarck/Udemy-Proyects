package org.mano;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MasterMind3_0 {
    //Variable personal
    public static final AtomicInteger index = new AtomicInteger(0);
    // Para llevar adelante este proyecto deberás utilizar los siguientes tipos que te damos ya declarados
    // (ten presente que ahora aparecerán tipos nuevos):
    public final static int MAX_INTENTOS = 10;
    public final static int LARGO_CODIGO = 4;
    public final static char PRIMERA_LETRA = 'A';
    public final static char ULTIMA_LETRA = 'H';

    /**
     * Representa a un código y las notas que éste ha recibido.
     */
    public record TRegistroNota(char[] codigo, AtomicInteger b, AtomicInteger r) {
    }

    /**
     * Es un arreglo con tope
     */
    public record THistoria(TRegistroNota[] info, AtomicInteger tope) {
    }

    /**
     * Esta función es con la que la CPU <b>Adivina</b> o genera el código
     *
     * @return char[4]
     */
    public static char[] generarCodigo() {
        Random rand = new Random();
        int numeroGenerado;
        char[] codigoGenerado = new char[LARGO_CODIGO];
        for (int i = 0; i < LARGO_CODIGO; i++) {
            numeroGenerado = rand.nextInt(((int) ULTIMA_LETRA - (int) PRIMERA_LETRA) + 1) + (int) (PRIMERA_LETRA); //Generar código aleatorio
            codigoGenerado[i] = (char) numeroGenerado;
        }
        return codigoGenerado;
    }

    /**
     * Lee dos notas a la vez: B y R y retorna TRUE si son correctas o FALSE si no lo son.
     * En caso de que las notas no sean correctas B y R quedan con el valor 0.
     * El fin de línea es consumido.
     * Para verificar que las notas sean correctas se contempla lo siguiente:
     * 1: Son valores enteros
     * 2: Están entre 0 y LARGO_CODIGO
     * 3: La suma de B+R no puede ser mayor que LARGO_CODIGO
     * 4: Si B=(LARGO_CODIGO-1) y R>=1 las notas están mal.
     * Asigna a la variable errorMessage uno de estos dos mensajes según el caso:
     * 1 y 2: 'ERROR: Ingresa solo dos numeros enteros entre 0 y [LARGO_CODIGO] separados por un
     * espacio en blanco.'
     * 3 y 4: 'ERROR: Las notas no son correctas, por favor verifica los valores.'
     *
     * @param b
     * @param r
     * @param errorMessage
     * @return TRUE OR FALSE
     */
    public static boolean leerNotas(AtomicInteger b, AtomicInteger r, StringBuilder errorMessage) {

        if ((b.get() > LARGO_CODIGO || r.get() > LARGO_CODIGO || b.get() < 0 || r.get() < 0) || (b.get() != b.intValue() || r.get() != r.intValue())) {
            errorMessage.append("ERROR: Ingresa solo dos numeros enteros entre 0 y");
            errorMessage.append(LARGO_CODIGO);
            errorMessage.append("separados por un espacio en blanco.");
            r.set(0);
            b.set(0);
            return false;
        }

        if (((b.get() + r.get()) > 4) || (b.get() == (LARGO_CODIGO - 1) && r.get() == 1)) {
            errorMessage.append("ERROR: Las notas no son correctas, por favor verifica los valores.");
            r.set(0);
            b.set(0);
            return false;
        }

        return true;
    }

    /*Imprime el código en la salida. Deja el cursor justo al final.*/
    public static void imprimirCodigo(char[] codigo) {
        for (char c : codigo) {
            System.out.print(c + " ");
        }
        System.out.print(">>  ");
    }

    /**
     * Genera el codigo siguiente al actual en forma circular y lo retorna. Por ejemplo:
     * <ul><li>AAAA --> AAAB</li>
     * <li>ABCH --> ABDA (En este caso H es la letra más grande admitida)</li>
     * <li>HHHH --> AAAA</li></ul>
     *
     * @param codigo El código a partir del cual se generará el siguiente.
     * @return El código siguiente a partir de <b>codigo</b>
     */
    public static char[] siguienteCodigo(char[] codigo) {
        char[] codigoSiguiente = new char[LARGO_CODIGO];

        // Primer bucle: trata la circularidad al principio y al final
        for (int i = 0; i < LARGO_CODIGO; i++) {
            if (codigo[i] == ULTIMA_LETRA) {
                codigoSiguiente[i] = PRIMERA_LETRA;
            } else if (codigo[i] == PRIMERA_LETRA) {
                codigoSiguiente[i] = ULTIMA_LETRA;
            } else {
                codigoSiguiente[i] = codigo[i];
            }
        }

        // Segundo bucle: maneja la lógica para las letras que no son ni la primera ni la última
        for (int i = 0; i < LARGO_CODIGO; i++) {
            if (codigo[i] != PRIMERA_LETRA && codigo[i] != ULTIMA_LETRA) {
                codigoSiguiente[i] = (char) (codigo[i] + 1);
            }
        }
        return codigoSiguiente;
    }


    /**
     * Crea una historia vacía y la retorna como valor.
     *
     * @return El objeto THistoria inicializado para hacer uso de ella en el juego.
     */
    public static THistoria crearHistoria(int iniciarEn) {
        return new THistoria(new TRegistroNota[MAX_INTENTOS], new AtomicInteger(iniciarEn));
    }

    /**
     * Retorna TRUE si la historia está vacía, FALSE en caso contrario.
     *
     * @param h La historia de la cual se desea saber si es vacía o no.
     * @return TRUE or FALSE
     */
    public static boolean esHistoriaVacia(THistoria h) {
        return h.tope.get() == 0;
    }

    /**
     * Guarda en la historia un nuevo código con sus respectivas notas asociadas.
     * Los parámetros <b>buenos</b> y <b>regulares</b> no serán agregados a <b>h</b>,
     * sino que se guardarán copias de ellos.
     *
     * @param h         La historia en la cual se guardarán las notas.
     * @param codigo    El código que se guardará en la historia.
     * @param buenos    El valor de buenos a guardar.
     * @param regulares El valor de regulares a guardar.
     */
    public static void guardarNota(THistoria h, char[] codigo, AtomicInteger buenos, AtomicInteger regulares) {
        int current = index.getAndIncrement();
        TRegistroNota nota = new TRegistroNota(codigo.clone(), new AtomicInteger(buenos.get()), new AtomicInteger(regulares.get()));
        if (current <= h.tope.get() - 1) {
            h.info[current] = nota;
        }
    }

    /**
     * Calcula las notas de <b>codAdivinador</b> en función de <b>codPensador</b>. Asigna los
     * buenos y los regulares a los argumentos con el mismo nombre.
     *
     * @param codAdivinador El código del adivinador. Se asume que es un código correcto.
     * @param codPensador   El código del pensador. Se asume que es un código correcto.
     * @param buenos        El cálculo de buenos será asignado a este parámetro.
     * @param regulares     El cálculo de regulares será asignado a este parámetro.
     */
    public static void calcularNota(char[] codAdivinador, char[] codPensador, AtomicInteger buenos, AtomicInteger regulares) {
        boolean[] comparado = new boolean[]{false, false, false, false};
        buenos.set(0);
        regulares.set(0);
        //Bucle comparador de código del CPU con la entrada del usuario
        for (int i = 0; i <= LARGO_CODIGO - 1; i++) {
            for (int j = 0; j <= LARGO_CODIGO - 1; j++) {
                if (!comparado[j] && codAdivinador[j] == codPensador[i]) {
                    if (j == i) {
                        buenos.set(buenos.get() + 1);
                    } else {
                        regulares.set(regulares.get() + 1);
                    }
                    comparado[j] = true;// Bandera que evita que una letra sea comparada más de una vez
                    break;  //Rompe el bucle interno una vez que se encuentra una coincidencia
                }
            }
        }
    }

    /**
     * Retorna TRUE si el código pasado como argumento es apropiado para postular al
     * pensador o FALSE si no lo es. Para ello se compara el código con todos los códigos
     * guardados en la historia evaluando sus notas. Si estas notas coinciden entonces
     * el código es adecuado, si un caso falla entonces ya no lo será.
     *
     * @param c El código a ser evaluado como posibilidad de adivinación
     * @param h La historia que se tomará en cuenta para evaluar el código
     * @return TRUE si el código es adecuado, FALSE si no lo es.
     */
    public static boolean esAdecuado(char[] c, THistoria h) {
        AtomicInteger bueno = new AtomicInteger(0);
        AtomicInteger regular = new AtomicInteger(0);

        int siEs = 0;
        char[] comparar;
        for (int i = 0; i < h.tope.get() - 1 && h.info[i] != null; i++) {
                comparar = h.info[i].codigo.clone();
                calcularNota(c, comparar, bueno, regular);
                if (bueno.get() == h.info[i].b.get() && regular.get() == h.info[i].r.get()) {
                    siEs++;
                } else {
                    return false;
                }
        }
        System.out.println(Arrays.stream(h.info).filter(Objects::nonNull).count()+" "+siEs);
        return siEs ==Arrays.stream(h.info).filter(Objects::nonNull).count();
    }

    // aquí termina los tipos que te ofrecen ya declarados
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                            MasterMind V3.0");
        System.out.println("    El CPU dispone de 10 intentos para adivinar el código.");
        System.out.println("            Debe calificar el código de 4 letras del CPU");
        System.out.println("----------------------------------------------------------------\n");

        // Crear historia y contadores
        THistoria h = crearHistoria(10);
        AtomicInteger buenos = new AtomicInteger(0);
        AtomicInteger regulares = new AtomicInteger(0);


        char[] codigo = new char[]{'A', 'B', 'C', 'D'};
        char[] buf = generarCodigo();
        System.out.println("Codigo original: "+Arrays.toString(codigo));


        calcularNota(buf,codigo,buenos,regulares);
        System.out.println("El código es: "+ Arrays.toString(buf) +"Nota: -> B:"+buenos.get()+" R: "+regulares.get());
        guardarNota(h, buf, buenos,regulares);

        System.out.println("El nuebo codigo a probar es:"+ Arrays.toString(siguienteCodigo(buf)));

        if (!(esAdecuado(siguienteCodigo(buf), h))) {
            System.out.println("No es Adecuado: "+ Arrays.toString(siguienteCodigo(buf)));
        } else {
            System.out.println("Es Adecuado: "+Arrays.toString(siguienteCodigo(buf)));
        }

    }
}



