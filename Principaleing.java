import java.util.LinkedList;
import java.util.Scanner;

public class Principaleing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodoseing m = new Metodoseing();
        int opt = 0;
        LinkedList<prestamoseingenieria> lista = new LinkedList<>();
        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingrese  la opcion");
            System.out.println("1: LLenar lista");
            System.out.println("2: Mostrar Lista");
            System.out.println("3: Importar Archivo");
            System.out.println("4: Exportar Archivo");
            System.out.println("5: Buscar por cedula");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    lista = m.LLenarLista(lista);
                    break;
                case 2:
                    m.MostrarLista(lista);
                    break;
                case 3:
                    lista = m.ImportarArchivo();
                    break;
                case 4:
                    m.ExportarArchivo(lista);
                    break;
                case 5:
                    Metodoseing b = new Metodoseing();
                    String CedulaBuscar = "";
                    System.out.println("Ingrese la cedula que desea buscar");
                    CedulaBuscar = sc.next();
                    prestamoseingenieria result = b.Buscar(lista, CedulaBuscar);

                    if (result == null) {
                        System.out.println("El registro no existe");
                    } else {
                        System.out.println("Cedula: " + " " + result.getCedula());
                        System.out.println("Nombre: " + " " + result.getNombre());
                        System.out.println("Apellido: " + " " + result.getApellido());
                        System.out.println("Telefono: " + " " + result.getTelefono());
                        System.out.println("Numero de semestre: " + " " + result.getNumSemestre());
                        System.out.println("Promedio: " + " " + result.getPromedio());
                        System.out.println("Serial: " + " " + result.getSerial());
                        System.out.println("------------------------------- \n");
                    }
                    break;

                default:
                    bandera = false;
                    break;
            }
        }
        sc.close();
    }
}