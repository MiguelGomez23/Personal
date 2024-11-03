import java.util.LinkedList;
import java.util.Scanner;

public class Metodoseing {
    public LinkedList<prestamoseingenieria> LLenarLista(LinkedList<prestamoseingenieria> lista) {
        // LinkedList<prestamoseingenieria> lista = new LinkedList<>();
        boolean bandera = true;
        Metodoseing m = new Metodoseing();

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

            // System.out.println("Ingrese el serial");
            // String serial = sc.nextLine();
            // a.setSerial(serial);
            // System.out.println("\n");

            lista.add(a);
            bandera = false;

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

    public LinkedList<prestamoseingenieria> ExportarArchivo(LinkedList<prestamoseingenieria> lista) {
        ExportarArchivoeing e = new ExportarArchivoeing();
        e.exportarArchivo(lista);
        return lista;
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

    public prestamoseingenieria BuscarNombre(LinkedList<prestamoseingenieria> lista, String nombre) {
        for (prestamoseingenieria ing : lista) {
            // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
            if (ing.getNombre().equalsIgnoreCase(nombre)) {
                return ing;
            }
        }
        return null; // Retorna null si no se encuentra el objeto
    }

    public LinkedList<prestamoseingenieria> ModificarNombre(String nombre, LinkedList<prestamoseingenieria> listaeing) {
        Metodoseing BN = new Metodoseing();
        Scanner sc = new Scanner(System.in);

        // Buscar el objeto con el nombre proporcionado
        prestamoseingenieria buscarNombre = BN.BuscarNombre(listaeing, nombre);

        if (buscarNombre != null) { // Verifica si se encontró el objeto
            System.out.println("Registro encontrado:");
            System.out.println();
            System.out.println("Nombre actual: " + buscarNombre.getNombre());
            System.out.println();

            // Solicitar nuevo nombre al usuario
            System.out.println("Ingrese el nuevo nombre:");
            String nuevoNombre = sc.nextLine();
            System.out.println();

            // Actualizar el nombre del objeto encontrado
            buscarNombre.setNombre(nuevoNombre);
            System.out.println("Nombre modificado correctamente a: " + buscarNombre.getNombre());
            System.out.println();
        } else {
            System.out.println("Registro no encontrado.");
            System.out.println();
        }

        return listaeing;
    }

    //
    //
    //

    public prestamoseingenieria BuscarApellido(LinkedList<prestamoseingenieria> lista, String apellido) {
        for (prestamoseingenieria ing : lista) {
            // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
            if (ing.getApellido().equalsIgnoreCase(apellido)) {
                return ing;
            }
        }
        return null; // Retorna null si no se encuentra el objeto
    }

    public LinkedList<prestamoseingenieria> ModificarApellido(String apellido,
            LinkedList<prestamoseingenieria> listaeing) {
        Metodoseing BA = new Metodoseing();
        Scanner sc = new Scanner(System.in);

        // Buscar el objeto con el nombre proporcionado
        prestamoseingenieria buscarApellido = BA.BuscarApellido(listaeing, apellido);

        if (buscarApellido != null) { // Verifica si se encontró el objeto
            System.out.println("Registro encontrado:");
            System.out.println();
            System.out.println("Apellido actual: " + buscarApellido.getApellido());
            System.out.println();

            // Solicitar nuevo nombre al usuario
            System.out.println("Ingrese el nuevo apellido:");
            String nuevoApellido = sc.nextLine();
            System.out.println();

            // Actualizar el nombre del objeto encontrado
            buscarApellido.setApellido(nuevoApellido);
            System.out.println("Apellido modificado correctamente a: " + buscarApellido.getApellido());
            System.out.println();
        } else {
            System.out.println("Registro no encontrado.");
            System.out.println();
        }

        return listaeing;
    }

    //
    //
    //
    public prestamoseingenieria BuscarTelefono(LinkedList<prestamoseingenieria> lista, String Telefono) {
        for (prestamoseingenieria ing : lista) {
            // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
            if (ing.getTelefono().equalsIgnoreCase(Telefono)) {
                return ing;
            }
        }
        return null; // Retorna null si no se encuentra el objeto
    }

    public LinkedList<prestamoseingenieria> ModificarTelefono(String Telefono,
            LinkedList<prestamoseingenieria> listaeing) {
        Metodoseing BT = new Metodoseing();
        Scanner sc = new Scanner(System.in);

        // Buscar el objeto con el Telefono proporcionado
        prestamoseingenieria buscarTelefono = BT.BuscarTelefono(listaeing, Telefono);

        if (buscarTelefono != null) { // Verifica si se encontró el objeto
            System.out.println("Registro encontrado:");
            System.out.println();
            System.out.println("Telefono actual: " + buscarTelefono.getTelefono());
            System.out.println();

            // Solicitar nuevo Telefono al usuario
            System.out.println("Ingrese el nuevo Telefono:");
            String nuevoTelefono = sc.nextLine();
            System.out.println();

            // Actualizar el Telefono del objeto encontrado
            buscarTelefono.setTelefono(nuevoTelefono);
            System.out.println("Telefono modificado correctamente a: " + buscarTelefono.getTelefono());
            System.out.println();
        } else {
            System.out.println("Registro no encontrado.");
            System.out.println();
        }

        return listaeing;
    }

    //
    //
    //

    public prestamoseingenieria BuscarNumSemestre(LinkedList<prestamoseingenieria> lista, int NumSemestre) {
        for (prestamoseingenieria ing : lista) {
            // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
            if (ing.getNumSemestre() == NumSemestre)   {
                return ing;
            }
        }
        return null; // Retorna null si no se encuentra el objeto
    }
    
    public LinkedList<prestamoseingenieria> ModificarNumSemestre(int NumSemestre, LinkedList<prestamoseingenieria> listaeing) {
        Metodoseing BNS = new Metodoseing();
        Scanner sc = new Scanner(System.in);
        
        // Buscar el objeto con el NumSemestre proporcionado
        prestamoseingenieria buscarNumSemestre = BNS.BuscarNumSemestre(listaeing, NumSemestre);
        
        if (buscarNumSemestre != null) { // Verifica si se encontró el objeto
            System.out.println("Registro encontrado:");
            System.out.println();
            System.out.println("Numero de semestre actual: " + buscarNumSemestre.getNumSemestre());
            System.out.println();
            
            // Solicitar nuevo NumSemestre al usuario
            System.out.println("Ingrese el nuevo Numero de semestre:");
            int nuevoNumSemestre = sc.nextInt();
            System.out.println();
            
            // Actualizar el NumSemestre del objeto encontrado
            buscarNumSemestre.setNumSemestre(nuevoNumSemestre);
            System.out.println("Numero de semestre modificado correctamente a: " + buscarNumSemestre.getNumSemestre());
            System.out.println();
        } else {
            System.out.println("Registro no encontrado.");
            System.out.println();
        }
        
        return listaeing;
    } 

    //
    //
    //

    public prestamoseingenieria BuscarPromedio(LinkedList<prestamoseingenieria> lista, Float promedio) {
        for (prestamoseingenieria ing : lista) {
            // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
            if (Float.compare(ing.getPromedio(), promedio) == 0) {
                return ing;
            }
        }
        return null; // Retorna null si no se encuentra el objeto
    }
    
    public LinkedList<prestamoseingenieria> ModificarPromedio(Float Promedio, LinkedList<prestamoseingenieria> listaeing) {
        Metodoseing BN = new Metodoseing();
        Scanner sc = new Scanner(System.in);
        
        // Buscar el objeto con el Promedio proporcionado
        prestamoseingenieria buscarPromedio = BN.BuscarPromedio(listaeing, Promedio);
        
        if (buscarPromedio != null) { // Verifica si se encontró el objeto
            System.out.println("Registro encontrado:");
            System.out.println();
            System.out.println("Promedio actual: " + buscarPromedio.getPromedio());
            System.out.println();
            
            // Solicitar nuevo Promedio al usuario
            System.out.println("Ingrese el nuevo Promedio:");
            Float nuevoPromedio = sc.nextFloat();
            System.out.println();
            
            // Actualizar el Promedio del objeto encontrado
            buscarPromedio.setPromedio(nuevoPromedio);
            System.out.println("Promedio modificado correctamente a: " + buscarPromedio.getPromedio());
            System.out.println();
        } else {
            System.out.println("Registro no encontrado.");
            System.out.println();
        }
        
        return listaeing;
    }

    //
    // //
    // //

    // public prestamoseingenieria BuscarSerial(LinkedList<prestamoseingenieria> lista, String Serial) {
    //     for (prestamoseingenieria ing : lista) {
    //         // Usa equalsIgnoreCase para ignorar diferencias en mayúsculas y minúsculas
    //         if (ing.getSerial().equalsIgnoreCase(Serial)) {
    //             return ing;
    //         }
    //     }
    //     return null; // Retorna null si no se encuentra el objeto
    // }
    
    // public LinkedList<prestamoseingenieria> ModificarSerial(String Serial,
    //         LinkedList<prestamoseingenieria> listaeing) {
    //     Metodoseing BT = new Metodoseing();
    //     Scanner sc = new Scanner(System.in);
    
    //     // Buscar el objeto con el Serial proporcionado
    //     prestamoseingenieria buscarSerial = BT.BuscarSerial(listaeing, Serial);
    
    //     if (buscarSerial != null) { // Verifica si se encontró el objeto
    //         System.out.println("Registro encontrado:");
    //         System.out.println();
    //         System.out.println("Serial actual: " + buscarSerial.getSerial());
    //         System.out.println();
    
    //         // Solicitar nuevo Serial al usuario
    //         System.out.println("Ingrese el nuevo Serial:");
    //         String nuevoSerial = sc.nextLine();
    //         System.out.println();
    
    //         // Actualizar el Serial del objeto encontrado
    //         buscarSerial.setSerial(nuevoSerial);
    //         System.out.println("Serial modificado correctamente a: " + buscarSerial.getSerial());
    //         System.out.println();
    //     } else {
    //         System.out.println("Registro no encontrado.");
    //         System.out.println();
    //     }
    
    //     return listaeing;
    // }
}
