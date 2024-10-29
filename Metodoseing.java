import java.util.LinkedList;
import java.util.Scanner;

public class Metodoseing {
    public LinkedList<prestamoseingenieria> LLenarLista(LinkedList<prestamoseingenieria> lista) {
        // LinkedList<prestamoseingenieria> lista = new LinkedList<>();
        boolean bandera = true;
        Metodoseing m = new Metodoseing();
        int opt = 0;
        Scanner sc = new Scanner(System.in);
        while (bandera) {
            // new prestamoseingenieria();
            System.out.println("Ingrese la cedula");
            String cedula = sc.nextLine();

            prestamoseingenieria a = m.Buscar(lista, cedula);
            if (a != null && a.getCedula() != null) {
                System.out.println("El registro ya existe, por favor ingrese otra cedula");
                continue; // Continuamos con el ciclo en lugar de romperlo
            }

            a = new prestamoseingenieria();
            a.setCedula(cedula);
            System.out.println("\n");

            System.out.println("Ingrese el nombre");
            String nombre = sc.nextLine();
            a.setNombre(nombre);
            System.out.println("\n");

            System.out.println("Ingrese el apellido");
            String apellido = sc.nextLine();
            a.setApellido(apellido);
            System.out.println("\n");

            System.out.println("Ingrese el telefono");
            String telefono = sc.nextLine();
            a.setTelefono(telefono);
            System.out.println("\n");

            System.out.println("Ingrese el numero de semestre");
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
                sc.next(); // Descartar entrada inválida
            }
            int numsemestre = sc.nextInt();
            a.setNumSemestre(numsemestre);
            System.out.println("\n");

            System.out.println("Ingrese el promedio");
            while (!sc.hasNextFloat()) {
                System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
                sc.next(); // Descartar entrada inválida
            }
            float promedio = sc.nextFloat();
            a.setPromedio(promedio);
            System.out.println(promedio);
            sc.nextLine();
            System.out.println("\n");

            System.out.println("Ingrese el serial");
            String serial = sc.nextLine();
            a.setSerial(serial);
            System.out.println("\n");

            lista.add(a);

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

    public void MostrarLista(LinkedList<prestamoseingenieria> lista) {
        for (prestamoseingenieria prestamoseingenieria : lista) {
            System.out.println("Cedula: " + " " + prestamoseingenieria.getCedula());
            System.out.println("Nombre: " + " " + prestamoseingenieria.getNombre());
            System.out.println("Apellido: " + " " + prestamoseingenieria.getApellido());
            System.out.println("Telefono: " + " " + prestamoseingenieria.getTelefono());
            System.out.println("Numero de semestre: " + " " + prestamoseingenieria.getNumSemestre());
            System.out.println("Promedio: " + " " + prestamoseingenieria.getPromedio());
            System.out.println("Serial: " + " " + prestamoseingenieria.getSerial());

            System.out.println("------------------------------- \n");

        }
    }

    public void ExportarArchivo(LinkedList<prestamoseingenieria> lista) {
        ExportarArchivoeing e = new ExportarArchivoeing();
        e.exportarArchivo(lista);
    }

    public LinkedList<prestamoseingenieria> ImportarArchivo() {
        ImportarArchivoTxteing i = new ImportarArchivoTxteing();
        LinkedList<prestamoseingenieria> lista = i.leerArchivo("prestamoseingenieriaes");
        return lista;
    }

    public prestamoseingenieria Buscar(LinkedList<prestamoseingenieria> lista, String cedula) {
        for (prestamoseingenieria ing : lista) {
            if (ing.getCedula().equals(cedula)) {
                return ing; // Retorna el objeto encontrado
            }
        }
        return null; // Retorna null si no se encuentra
    }
}
