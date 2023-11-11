import java.util.Scanner;
public class funciones {

    public static String [][] cargar_adn(String[][] adn){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            System.out.println("FILA " +(i+1));
            for (int j = 0; j < 6; j++) {
                while (true){
                    System.out.println("Ingrese la letra a cargar(A.C,G,T)");
                    String letra = scanner.next().toUpperCase();
                    if (letra.equals("A") | letra.equals("C") | letra.equals("G") | letra.equals("T")){
                        adn[i][j] = letra;
                        break;
                    }else{
                        System.out.println("Debe ingresar una de estas letras (A.C,G,T)");
                    }
                }
            }

        }
        return adn;
    }
    public static boolean is_mutant(String[][] adn){
        int coincidence_mutant = 0;
        int coincidence;

        //Buscar de forma horizontal
        for (int i = 0; i < 6; i++) {
            coincidence = 0;
            for (int j = 0; j < 5; j++) {
                if(adn[i][j].equals(adn[i][j+1])){
                    coincidence += 1;
                } else if (coincidence < 3) {
                    coincidence = 0;
                }
            }
            if (coincidence >= 3){
                coincidence_mutant += 1;
            }
        }

        //Buscar de manera vertical
        for (int j = 0; j < 6; j++) {
            coincidence = 0;
            for (int i = 0; i < 5; i++) {
                if (adn[i][j].equals(adn[i+1][j])){
                    coincidence += 1;
                }else if (coincidence < 3){
                    coincidence = 0;
                }
            }
            if (coincidence >= 3){
                coincidence_mutant += 1;
            }
        }

        //Buscar de manera diagonal
        int x = 0;
        coincidence = 0;

        for (int j = 0; j < (adn.length-1); j++) {
            if (adn[x][j].equals(adn[x+1][j+1]) & (coincidence != 4)){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            x += 1;
        }
        if (coincidence >= 3){
            coincidence_mutant += 1;
        }

        //Buscar diagonal inferior 1
        x = 1;
        coincidence =0;
        for (int j = 0; j < 4; j++) {
            if(adn[x][j].equals(adn[x+1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            x+=1;
        }
        if (coincidence >=4){
            coincidence_mutant += 1;
        }

        //Buscar diagonal inferior 2
        x = 2;
        coincidence = 0;
        for (int j = 0; j < 3; j++) {
            if (adn[x][j].equals(adn[x+1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            x += 1;
        }
        if (coincidence >=3){
            coincidence_mutant += 1;
        }
        
        //Buscar diagonal superior 1
        int j = 1;
        coincidence = 0;
        for (int i = 0; i < 4; i++) {
            if (adn[i][j].equals(adn[i+1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            j += 1;
        }
        if (coincidence >=3){
            coincidence_mutant += 1;
        }

        //Buscar diagonal superior 2
        j = 2;
        coincidence = 0;
        for (int i = 0; i < 3; i++) {
            if (adn[i][j].equals(adn[i+1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            j += 1;
        }
        if (coincidence >=3){
            coincidence_mutant += 1;
        }

        //Buscar diagonal inversa
        coincidence = 0;
        for (int i = 0; i < 5; i++) {
            coincidence = 0;
            for (j = 0; j < 5; j++) {
                if(i+j == 6-1){
                    if (adn[i][j].equals(adn[i-1][j-1])) {
                        coincidence += 1;
                    } else if (coincidence < 3) {
                        coincidence = 0;
                    }
                }
            }
            if (coincidence >= 3){
                coincidence_mutant += 1;
            }
        }

        //Buscar diagonal inversa superior 1
        coincidence = 0;
        x = 4;
        for (j = 0; j < 4; j++) {
            if (adn[x][j].equals(adn[x-1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            x -= 1;
        }
        if (coincidence >= 3){
            coincidence_mutant += 1;
        }

        //Buscar diagonal inversa superior 2
        coincidence = 0;
        x = 3;
        for (j = 0; j < 3; j++) {
            if (adn[x][j].equals(adn[x-1][j+1])){
                coincidence += 1;
            } else if (coincidence < 3) {
                coincidence = 0;
            }
            x -= 1;
        }
        if (coincidence >= 3){
            coincidence_mutant += 1;
        }


        if (coincidence_mutant >= 2){
            return true;
        }else {
            return false;
        }
    }
}
