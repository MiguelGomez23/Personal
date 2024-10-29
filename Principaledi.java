import java.util.LinkedList;
import java.util.Scanner;

public class Principaledi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodosedi m = new Metodosedi();
        int opt = 0;
        LinkedList<prestamosediseño> lista = new LinkedList<>();
        boolean bandera = true;
        while (bandera) {
            System.out.println("Ingrese la opcion");
            System.out.println("1: LLenar lista");
            System.out.println("2: Mostrar Lista");
            System.out.println("3: Importar Archivo");
            System.out.println("4: Exportar Archivo");
            System.out.println("5: Buscar por serial");
            if (sc.hasNextInt()) {
                opt = sc.nextInt();
                switch (opt) {
                    case 1:
                        lista = m.LlenarLista(lista);
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
                        Metodosedi b = new Metodosedi();
                        String CedulaBuscar = "";
                        System.out.println("Ingrese la cedula que desea buscar");
                        CedulaBuscar = sc.next();
                        prestamosediseño result = b.Buscar(lista, CedulaBuscar);

                        if (result == null) {
                            System.out.println("El registro no existe");
                        } else {
                            System.out.println("Cedula: " + " " + result.getCedula());
                            System.out.println("Nombre: " + " " + result.getNombre());
                            System.out.println("Apellido: " + " " + result.getApellido());
                            System.out.println("Telefono: " + " " + result.getTelefono());
                            System.out.println("Modalidad de estudio: " + " " + result.getModalidadEstudio());
                            System.out.println("cantidad de Asignaturas: " + " " + result.getCantidadAsignaturas());
                            System.out.println("Serial: " + " " + result.getSerial());
                            System.out.println("------------------------------- \n");
                        }
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción de 1 a 5.");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero.");
                sc.next();
            }
        }
        sc.close();
    }
}
