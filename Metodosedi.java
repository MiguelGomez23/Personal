import java.util.LinkedList;
import java.util.Scanner;

public class Metodosedi {
    public LinkedList<prestamosediseño> LlenarLista(LinkedList<prestamosediseño> lista) {
        boolean bandera = true;
        Metodosedi objMetodos = new Metodosedi();
        int opt = 0;
        Scanner sc = new Scanner(System.in);

        while (bandera) {
            System.out.println("Ingrese el Cedula");
            String Cedula = sc.nextLine();

            // Verificamos si ya existe
            prestamosediseño objPrestamosediseño = objMetodos.Buscar(lista, Cedula);
            if (objPrestamosediseño != null && objPrestamosediseño.getCedula() != null) {
                System.out.println("El registro ya existe, por favor ingrese otra Cedula");
                continue; // Continuamos con el ciclo en lugar de romperlo
            }

            // Creamos una nueva instancia solo si el Cedula no existe
            objPrestamosediseño = new prestamosediseño();
            objPrestamosediseño.setCedula(Cedula);
            System.out.println("\n");
            
            System.out.println("Ingrese el nombre");
            String nombre = sc.nextLine();
            objPrestamosediseño.setNombre(nombre);
            System.out.println("\n");

            System.out.println("Ingrese el apellido");
            String apellido = sc.nextLine();
            objPrestamosediseño.setApellido(apellido);
            System.out.println("\n");

            System.out.println("Ingrese el telefono");
            String telefono = sc.nextLine();
            objPrestamosediseño.setTelefono(telefono);
            System.out.println("\n");

            System.out.println("Ingrese el modalidad de estudio");
            String modalidaddeestudio = sc.nextLine();
            objPrestamosediseño.setModalidadEstudio(modalidaddeestudio);
            System.out.println("\n");

            System.out.println("Ingrese la cantidad de asignaturas");
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
                sc.next(); // Descartar entrada inválida
            }
            int cantidadasignaturas = sc.nextInt();
            objPrestamosediseño.setCantidadAsignaturas(cantidadasignaturas);
            System.out.println("\n");

            // System.out.println("Ingrese el serial");
            // String serial = sc.next();
            // objPrestamosediseño.setSerial(serial);
            // System.out.println("\n");

            // Agregar a la lista
            lista.add(objPrestamosediseño);

            // Preguntar si desea continuar
            System.out.println("Desea continuar 1: Si, 2: No");
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida, por favor ingrese un número válido");
                sc.next(); // Descartar entrada inválida
            }
            opt = sc.nextInt();
            System.out.println("\n");

            if (opt == 2) {
                bandera = false; // Finalizamos el ciclo
            }
        }
        return lista;
    }

    public void MostrarLista(LinkedList<prestamosediseño> lista) {
        for (prestamosediseño prestamosediseño : lista) {
            System.out.println("Cedula: " + " " + prestamosediseño.getCedula());
            System.out.println("Nombre: " + " " + prestamosediseño.getNombre());
            System.out.println("Apellido: " + " " + prestamosediseño.getApellido());
            System.out.println("Telefono: " + " " + prestamosediseño.getTelefono());
            System.out.println("Modalidad de estudio: " + " " + prestamosediseño.getModalidadEstudio());
            System.out.println("Cantidad de asignaturas: " + " " + prestamosediseño.getCantidadAsignaturas());
            System.out.println("Serial: " + " " + prestamosediseño.getSerial());

            System.out.println("------------------------------- \n");

        }
    }

    public void ExportarArchivo(LinkedList<prestamosediseño> lista) {
        ExportarArchivoedi e = new ExportarArchivoedi();
        e.exportarArchivo(lista);
    }

    public LinkedList<prestamosediseño> ImportarArchivo() {
        ImportarArchivoTxtedi i = new ImportarArchivoTxtedi();
        LinkedList<prestamosediseño> lista = i.leerArchivo("prestamosediseñoes");
        return lista;
    }

    public prestamosediseño Buscar(LinkedList<prestamosediseño> lista, String Cedula) {
        for (prestamosediseño comp : lista) {
            if (comp.getCedula().equals(Cedula)) {
                return comp; // Retorna el objeto encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }

}
