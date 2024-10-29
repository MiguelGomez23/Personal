import java.util.LinkedList;
import java.util.Scanner;

public class Metodostab {
    public LinkedList<Tableta> LlenarLista(LinkedList<Tableta> lista) {
        boolean bandera = true;
        Metodostab m = new Metodostab();
        int opt = 0;
        Scanner sc = new Scanner(System.in);

        while (bandera) {
            System.out.println("Ingrese el serial");
            String serial = sc.nextLine();

            Tableta a = m.Buscar(lista, serial);
            if (a != null && a.getSerial() != null) {
                System.out.println("El registro ya existe, por favor ingrese otro serial");
                continue;
            }

            a = new Tableta();
            a.setSerial(serial);
            System.out.println("\n");

            System.out.println("Ingrese la marca");
            String marca = sc.nextLine();
            a.setMarca(marca);
            System.out.println("\n");

            System.out.println("Ingrese el tamaño");
            while (!sc.hasNextFloat()) {
                System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
                sc.next();
            }
            float tamano = sc.nextFloat();
            a.setTamano(tamano);
            System.out.println(tamano);
            sc.nextLine();
            System.out.println("\n");

            System.out.println("Ingrese el precio");
            while (!sc.hasNextFloat()) {
                System.out.println("Opcion no valida, por favor ingrese un precio válido");
                sc.next();
            }
            float precio = sc.nextFloat();
            a.setPrecio(precio);
            System.out.println(precio);
            sc.nextLine();
            System.out.println("\n");

            System.out.println("Ingrese el almacenamiento");
            String almacenamiento = sc.nextLine();
            a.setAlmacenamiento(almacenamiento);
            System.out.println("\n");

            System.out.println("Ingrese el tamaño");
            while (!sc.hasNextFloat()) {
                System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
                sc.next();
            }
            float peso = sc.nextFloat();
            a.setPeso(peso);
            System.out.println(peso);
            sc.nextLine();
            System.out.println("\n");

            lista.add(a);

            System.out.println("Desea continuar 1: Si, 2: No");
            while (!sc.hasNextInt()) {
                System.out.println("Opcion no valida, por favor ingrese un número válido");
                sc.next();
            }
            opt = sc.nextInt();
            System.out.println("\n");

            if (opt == 2) {
                bandera = false;
            }
        }
        return lista;

    }

    public void MostrarLista(LinkedList<Tableta> lista) {
        for (Tableta computadores : lista) {
            System.out.println("Serial: " + " " + computadores.getSerial());
            System.out.println("Marca: " + " " + computadores.getMarca());
            System.out.println("Tamaño: " + " " + computadores.getPeso());
            System.out.println("Precio: " + " " + computadores.getPrecio());
            System.out.println("Almacenamiento: " + " " + computadores.getAlmacenamiento());
            System.out.println("Peso: " + " " + computadores.getPeso());

            System.out.println("------------------------------- \n");

        }
    }

    public void ExportarArchivo(LinkedList<Tableta> lista) {
        ExportarArchivotab e = new ExportarArchivotab();
        e.exportarArchivo(lista);
    }

    public LinkedList<Tableta> ImportarArchivo() {
        ImportarArchivoTxttab i = new ImportarArchivoTxttab();
        LinkedList<Tableta> lista = i.leerArchivo("tabletaes");
        return lista;
    }

    public Tableta Buscar(LinkedList<Tableta> lista, String serial) {
        for (Tableta comp : lista) {
            if (comp.getSerial().equals(serial)) {
                return comp;
            }
        }
        return null;
    }

}
