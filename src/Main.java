// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;

/*
CASO EN EL QUE ES MUTANTE
                        {{"A","C","C","A","G","A"},
                        {"A","A","A","G","A","T"},
                        {"T","A","G","A","T","A"},
                        {"A","G","A","T","A","G"},
                        {"T","A","T","A","A","A"},
                        {"A","G","A","A","C","A"} };;
CASO EN EL QUE NO ES MUTANTE
                    {{"A","T","G","C","G","A"},
                     {"C","A","G","T","G","C"},
                     {"T","T","A","T","T","T"},
                     {"A","G","A","C","G","G"},
                     {"G","C","G","T","C","A"},
                     {"T","C","A","C","T","G"}}
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1.Cargar ADN  2.Salir");
            System.out.println("Ingrese la opción que desee realizar ");
            String option = scanner.next();

            if (option.equals("1")) {
                System.out.println("Carga de ADN");
                String adn[][] = new String[6][6];
                String adn_charged[][] = new String[6][6];
                adn_charged = funciones.cargar_adn(adn);
                boolean resp;
                resp = funciones.is_mutant(adn_charged);
                System.out.println(resp);

                if (resp){
                    System.out.println("El adn ingresado pertenece a un mutante");
                }else{
                    System.out.println("El adn ingresado pertenece a un mutante");
                }
            } else if (option.equals("2")) {
                System.out.println("FIN DE INGRESOS");
                break;
            }else {
                System.out.println("Ingrese una opcion valida");
            }

        }
    }
}