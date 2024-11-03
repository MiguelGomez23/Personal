
import java.util.LinkedList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        System.out.println("Prestamos de equipos de la universidad San Juan de Dios");
        System.out.println();
        Scanner sc = new Scanner(System.in);

        Metodosedi objMetodosedi = new Metodosedi();
        Metodoseing objMetodoseing = new Metodoseing();
        Metodostab objMetodostab = new Metodostab();
        Metodoscomp objMetodoscomp = new Metodoscomp();

        LinkedList<Tableta> listatab = new LinkedList<>();
        LinkedList<computadores> listacomp = new LinkedList<>();
        LinkedList<prestamoseingenieria> listaeing = new LinkedList<>();
        LinkedList<prestamosediseño> listaedi = new LinkedList<>();

        listatab = objMetodostab.ImportarArchivo();
        listacomp = objMetodoscomp.ImportarArchivo();

        int opc = 0;
        do {
            System.out.println("Seleccione la opción que desea." +
                    "\n1. Estudiante diseño." +
                    "\n2. Estudiante ingeniería." +
                    "\n3. Ver inventario." +
                    "\n4. Salir");
            System.out.println();
            if (sc.hasNextInt()) {
                opc = sc.nextInt();
                switch (opc) {
                    case 1:
                        int opt = 0;
                        do {
                            System.out.println("Estudiante de diseño");
                            System.out.println("\n1. Solicitar préstamo de equipo." +
                                    "\n2. Modificar préstamo de equipo." +
                                    "\n3. Regresar el equipo." +
                                    "\n4. Buscar equipo." +
                                    "\n5. Volver al menú principal.");
                            System.out.println();
                            if (sc.hasNextInt()) {
                                opt = sc.nextInt();
                                switch (opt) {
                                    case 1:
                                        System.out.println("Solicitar préstamo de equipo.\n");
                                        listaedi = objMetodosedi.ImportarArchivo(listaedi);

                                        Metodosedi objMetodosedib = new Metodosedi();
                                        Tableta tb = new Tableta();
                                        String CedulaBuscard;

                                        System.out.println("Ingrese su cédula");
                                        CedulaBuscard = sc.next();
                                        prestamosediseño resultadi = objMetodosedib.Buscar(listaedi, CedulaBuscard);

                                        System.out.println();

                                        if (resultadi != null) {
                                            System.out
                                                    .println("Ya hay un préstamo activo con esta cédula\n");
                                        } else {
                                            System.out.println(
                                                    "La cédula no tiene préstamo activo, ingrésela de nuevo para continuar el "
                                                            + "proceso del préstamo\n");
                                            listaedi = objMetodosedi.LlenarLista(listaedi);

                                            tb.SeleccionarMarca();
                                            String MarcaBuscar = tb.getMarca();

                                            tb.Seleccionartamaño();
                                            Float TamanoBuscar = tb.getTamano();

                                            tb.SeleccionarPrecio();
                                            Float PrecioBuscar = tb.getPrecio();

                                            tb.SeleccionarAlmacenamiento();
                                            String AlmacenamientoBuscar = tb.getAlmacenamiento();

                                            tb.SeleccionarPeso();
                                            Float PesoBuscar = tb.getPeso();

                                            Tableta tabletaAsignada = null;
                                            String serialAsignado = null; // Variable para almacenar el serial del
                                                                          // computador asignado

                                            // Buscar el computador que coincida con las características
                                            for (Tableta tab : listatab) {
                                                if (tab.getMarca().equalsIgnoreCase(MarcaBuscar) &&
                                                        tab.getTamano() == TamanoBuscar && // Cambiado a equals para
                                                                                           // evitar problemas de
                                                                                           // comparación
                                                        tab.getPrecio() == PrecioBuscar &&
                                                        tab.getAlmacenamiento().equalsIgnoreCase(AlmacenamientoBuscar)
                                                        &&
                                                        tab.getPeso() == PesoBuscar) {
                                                    tabletaAsignada = tab;
                                                    serialAsignado = tab.getSerial(); // Asigna el serial aquí
                                                    break; // Salir del bucle si se encuentra un computador
                                                }
                                            }

                                            // Verificar si se encontró un computador
                                            if (tabletaAsignada != null) {
                                                System.out.println("La tableta asignada es: ");
                                                System.out.println("Serial: " + tabletaAsignada.getSerial());
                                                System.out.println("Marca: " + tabletaAsignada.getMarca());
                                                System.out.println("Tamaño: " + tabletaAsignada.getTamano());
                                                System.out.println("Precio: " + tabletaAsignada.getPrecio());
                                                System.out.println(
                                                        "Almacenamiento: " + tabletaAsignada.getAlmacenamiento());
                                                System.out.println("Peso: " + tabletaAsignada.getPeso());
                                                System.out.println("------------------------------- \n");

                                                // Eliminar el computador de la lista
                                                listatab.remove(tabletaAsignada);

                                                // Actualizar el serial del estudiante
                                                for (prestamosediseño estudiante : listaedi) {
                                                    if (estudiante.getCedula().equals(CedulaBuscard)) {
                                                        estudiante.setSerial(serialAsignado); // Asignar el serial del
                                                                                              // computador al
                                                                                              // estudiante
                                                        System.out.println(
                                                                "El serial de la tableta asignada al estudiante es: "
                                                                        + serialAsignado);
                                                        System.out.println();
                                                        break; // Salir del bucle una vez que se actualiza el estudiante
                                                    }
                                                }

                                                // Exportar lista de estudiantes
                                                objMetodosedi.ExportarArchivo(listaedi);

                                            } else {
                                                System.out.println(
                                                        "No se encontró una tableta que coincida con las características ingresadas.\n");
                                            }
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Modificar préstamo de equipo.\n");
                                        listaedi = objMetodosedi.ImportarArchivo(listaedi);
                                        Metodosedi objmetodos = new Metodosedi();
                                        String SerialBuscar = "";
                                        System.out.println("Ingrese la cédula");
                                        SerialBuscar = sc.next();
                                        System.out.println();
                                        prestamosediseño resulta = objmetodos.Buscar(listaedi, SerialBuscar);

                                        if (resulta == null) {
                                            System.out.println();
                                            System.out.println("El registro no existe");
                                            System.out.println();
                                        } else {
                                            System.out.println("Cédula: " + resulta.getCedula());
                                            System.out.println("Nombre: " + resulta.getNombre());
                                            System.out.println("Apellido: " + resulta.getApellido());
                                            System.out.println("Teléfono: " + resulta.getTelefono());
                                            System.out
                                                    .println("Modalidad de estudio: " + resulta.getModalidadEstudio());
                                            System.out.println(
                                                    "Cantidad de Asignaturas: " + resulta.getCantidadAsignaturas());
                                            System.out.println("Serial: " + resulta.getSerial());
                                            System.out.println("------------------------------- \n");
                                        }
                                        objMetodosedi.ExportarArchivo(listaedi);
                                        break;

                                    case 3:
                                        System.out.println("Regresar el equipo.\n");
                                        listaedi = objMetodosedi.ImportarArchivo(listaedi);

                                        System.out.println("Ingrese la cédula del estudiante:");
                                        String cedulaBuscar = sc.next();
                                        System.out.println();

                                        // Buscar el préstamo correspondiente a la cédula
                                        prestamosediseño prestamoEncontrado = objMetodosedi.Buscar(listaedi,
                                                cedulaBuscar);

                                        if (prestamoEncontrado != null) {
                                            System.out.println("El equipo asignado a esta cédula es:");
                                            // System.out.println("Cédula: " + prestamoEncontrado.getCedula());
                                            System.out.println("Serial: " + prestamoEncontrado.getSerial());
                                            System.out.println("-------------------------------\n");

                                            int Op = 0;
                                            do {
                                                System.out.println("Seleccione una opción:");
                                                System.out.println("1. Devolver el equipo.");
                                                System.out.println("2. Regresar al menú anterior.");
                                                System.out.println();

                                                if (sc.hasNextInt()) {
                                                    Op = sc.nextInt();

                                                    switch (Op) {
                                                        case 1:
                                                            // Buscar el préstamo asociado a la cédula
                                                            prestamosediseño prestamoEncontradob = objMetodosedi
                                                                    .Buscar(listaedi, cedulaBuscar);

                                                            if (prestamoEncontradob != null) {
                                                                // Obtener el serial del préstamo
                                                                String serialTableta = prestamoEncontradob
                                                                        .getSerial();
                                                                Tableta equipoADevolver = null;

                                                                // Ahora buscar el computador en la lista de préstamos
                                                                for (prestamosediseño prestamo : listaedi) {
                                                                    if (prestamo.getSerial().equals(serialTableta)) {
                                                                        // Aquí asumes que puedes crear un nuevo
                                                                        // computador o acceder a uno existente basado
                                                                        // en el serial
                                                                        equipoADevolver = new Tableta(); // o busca
                                                                                                         // en tu
                                                                                                         // estructura
                                                                                                         // actual
                                                                        equipoADevolver.setSerial(serialTableta);
                                                                        // Agregar más atributos si es necesario
                                                                        break;
                                                                    }
                                                                }

                                                                if (equipoADevolver != null) {
                                                                    listaedi.remove(prestamoEncontradob); // Remover el
                                                                    objMetodosedi.ImportarArchivo(listaedi);                                      // préstamo
                                                                    objMetodosedi.ExportarArchivo(listaedi); // Exportar
                                                                                                                 // la
                                                                                                             // lista
                                                                                                             // actualizada
                                                                    listatab.add(equipoADevolver); // Agregar el equipo
                                                                    
                                                                    System.out.println(
                                                                            "El equipo ha sido devuelto al inventario.\n");
                                                                } else {
                                                                    System.out.println(
                                                                            "No se encontró la tableta asociada al préstamo.\n");
                                                                }
                                                            } else {
                                                                System.out.println(
                                                                        "Préstamo no encontrado para esta cédula.\n");
                                                            }
                                                            break;

                                                        case 2:
                                                            System.out.println("Regresando...\n");
                                                            break;

                                                        default:
                                                            System.out.println(
                                                                    "Opción no válida. Por favor, ingrese 1 o 2.\n");
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Por favor, ingrese un número entero.\n");
                                                    sc.next();
                                                }
                                            } while (Op != 1 && Op != 2);
                                        } else {
                                            System.out.println(
                                                    "Cédula no encontrada en el sistema, realice una solicitud.\n");
                                        }
                                        break;
                                    /*
                                     * case 3:
                                     * System.out.println("Regresar el equipo.\n");
                                     * listaedi = objMetodosedi.ImportarArchivo();
                                     * objMetodosedi.ExportarArchivo(listaedi);
                                     * break;
                                     */

                                    case 4:
                                        System.out.println("Buscar equipo");
                                        listatab = objMetodostab.ImportarArchivo();
                                        Metodostab objmetodostab = new Metodostab();
                                        String SerialBuscarb = "";
                                        System.out.println("Ingrese el serial");
                                        SerialBuscarb = sc.next();
                                        Tableta resultab = objmetodostab.Buscar(listatab, SerialBuscarb);

                                        if (resultab == null) {
                                            System.out.println("El registro no existe\n");
                                        } else {
                                            System.out.println("Serial: " + resultab.getSerial());
                                            System.out.println("Marca: " + resultab.getMarca());
                                            System.out.println("Tamaño: " + resultab.getTamano());
                                            System.out.println("Precio: " + resultab.getPrecio());
                                            System.out.println("Almacenamiento: " + resultab.getAlmacenamiento());
                                            System.out.println("Peso: " + resultab.getPeso());
                                            System.out.println("------------------------------- \n");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Regresando al menú principal.\n");
                                        break;

                                    default:
                                        System.out.println("Opción del 1 al 5.\n");
                                        break;
                                }
                            } else {
                                System.out.println("Por favor, ingrese un número entero.\n");
                                sc.next();
                            }
                        } while (opt != 5);
                        break;

                    case 2:
                        int optt = 0;
                        do {
                            System.out.println("Estudiante de ingeniería");
                            System.out.println("\n1. Solicitar préstamo de equipo." +
                                    "\n2. Modificar préstamo de equipo." +
                                    "\n3. Regresar el equipo." +
                                    "\n4. Buscar equipo." +
                                    "\n5. Volver al menú principal.");
                            System.out.println();
                            if (sc.hasNextInt()) {
                                optt = sc.nextInt();
                                switch (optt) {

                                    case 1:
                                        System.out.println("Solicitar préstamo de equipo.\n");
                                        listaeing = objMetodoseing.ImportarArchivo();
                                        Metodoseing objMetodoseingb = new Metodoseing();
                                        computadores cp = new computadores();
                                        String CedulaBuscarb;

                                        System.out.println("Ingrese su cédula");
                                        CedulaBuscarb = sc.next();
                                        prestamoseingenieria resulta = objMetodoseingb.Buscar(listaeing, CedulaBuscarb);
                                        System.out.println();

                                        if (resulta != null) {
                                            System.out
                                                    .println("Ya hay un préstamo activo con esta cédula\n");
                                        } else {
                                            System.out.println(
                                                    "La cédula no tiene préstamo activo, ingrésela de nuevo para continuar el "
                                                            + "proceso del préstamo\n");
                                            listaeing = objMetodoseing.LLenarLista(listaeing);

                                            cp.SeleccionarMarca();
                                            String MarcaBuscar = cp.getMarca();

                                            cp.Seleccionartamaño();
                                            Float TamanoBuscar = cp.getTamano();

                                            cp.SeleccionarPrecio();
                                            Float PrecioBuscar = cp.getPrecio();

                                            cp.SeleccionarSistemaOperativo();
                                            String SOBuscar = cp.getSistemaOperativo();

                                            cp.SeleccionarPr();
                                            String ProcesadorBuscar = cp.getProcesador();

                                            computadores computadorAsignado = null;
                                            String serialAsignado = null; // Variable para almacenar el serial del
                                                                          // computador asignado

                                            // Buscar el computador que coincida con las características
                                            for (computadores comp : listacomp) {
                                                if (comp.getMarca().equalsIgnoreCase(MarcaBuscar) &&
                                                        comp.getTamano() == TamanoBuscar && // Cambiado a equals para
                                                                                            // evitar problemas de
                                                                                            // comparación
                                                        comp.getPrecio() == PrecioBuscar &&
                                                        comp.getSistemaOperativo().equalsIgnoreCase(SOBuscar) &&
                                                        comp.getProcesador().equalsIgnoreCase(ProcesadorBuscar)) {
                                                    computadorAsignado = comp;
                                                    serialAsignado = comp.getSerial(); // Asigna el serial aquí
                                                    break; // Salir del bucle si se encuentra un computador
                                                }
                                            }

                                            // Verificar si se encontró un computador
                                            if (computadorAsignado != null) {
                                                System.out.println("El computador asignado es: ");
                                                System.out.println("Serial: " + computadorAsignado.getSerial());
                                                System.out.println("Marca: " + computadorAsignado.getMarca());
                                                System.out.println("Tamaño: " + computadorAsignado.getTamano());
                                                System.out.println("Precio: " + computadorAsignado.getPrecio());
                                                System.out.println("Sistema operativo: "
                                                        + computadorAsignado.getSistemaOperativo());
                                                System.out.println("Procesador: " + computadorAsignado.getProcesador());
                                                System.out.println("------------------------------- \n");

                                                // Eliminar el computador de la lista
                                                listacomp.remove(computadorAsignado);

                                                // Actualizar el serial del estudiante
                                                for (prestamoseingenieria estudiante : listaeing) {
                                                    if (estudiante.getCedula().equals(CedulaBuscarb)) {
                                                        estudiante.setSerial(serialAsignado); // Asignar el serial del
                                                                                              // computador al
                                                                                              // estudiante
                                                        System.out.println(
                                                                "El serial del computador asignado al estudiante es: "
                                                                        + serialAsignado);
                                                        System.out.println();
                                                        break; // Salir del bucle una vez que se actualiza el estudiante
                                                    }
                                                }

                                                listaeing = objMetodoseing.ExportarArchivo(listaeing);

                                            } else {
                                                System.out.println(
                                                        "No se encontró un computador que coincida con las características ingresadas.\n");
                                            }
                                        }
                                        break;

                                    case 2:
                                        System.out.println("Modificar préstamo de equipo.\n");
                                        listaeing = objMetodoseing.ImportarArchivo();
                                        break;

                                    case 3:
                                        System.out.println("Regresar el equipo.\n");
                                        listaeing = objMetodoseing.ImportarArchivo();

                                        System.out.println("Ingrese la cédula del estudiante:");
                                        String cedulaBuscar = sc.next();
                                        System.out.println();

                                        // Buscar el préstamo correspondiente a la cédula
                                        prestamoseingenieria prestamoEncontrado = objMetodoseing.Buscar(listaeing,
                                                cedulaBuscar);

                                        if (prestamoEncontrado != null) {
                                            System.out.println("Equipo asignado al estudiante:");
                                            System.out.println("Cédula: " + prestamoEncontrado.getCedula());
                                            System.out.println("Nombre: " + prestamoEncontrado.getNombre());
                                            System.out.println("Apellido: " + prestamoEncontrado.getApellido());
                                            System.out.println("-------------------------------\n");

                                            int Op = 0;
                                            do {
                                                System.out.println("Seleccione una opción:");
                                                System.out.println("1. Devolver el equipo.");
                                                System.out.println("2. Regresar al menú anterior.");
                                                System.out.println();

                                                if (sc.hasNextInt()) {
                                                    Op = sc.nextInt();

                                                    switch (Op) {
                                                        case 1:
                                                            // Buscar el préstamo asociado a la cédula
                                                            prestamoseingenieria prestamoEncontradob = objMetodoseing
                                                                    .Buscar(listaeing, cedulaBuscar);

                                                            if (prestamoEncontradob != null) {
                                                                // Obtener el serial del préstamo
                                                                String serialComputador = prestamoEncontradob
                                                                        .getSerial();
                                                                computadores equipoADevolver = null;

                                                                // Ahora buscar el computador en la lista de préstamos
                                                                for (prestamoseingenieria prestamo : listaeing) {
                                                                    if (prestamo.getSerial().equals(serialComputador)) {
                                                                        // Aquí asumes que puedes crear un nuevo
                                                                        // computador o acceder a uno existente basado
                                                                        // en el serial
                                                                        equipoADevolver = new computadores(); // o busca
                                                                                                              // en tu
                                                                                                              // estructura
                                                                                                              // actual
                                                                        equipoADevolver.setSerial(serialComputador);
                                                                        // Agregar más atributos si es necesario
                                                                        break;
                                                                    }
                                                                }

                                                                if (equipoADevolver != null) {
                                                                    listaeing.remove(prestamoEncontradob); // Remover el
                                                                                                           // préstamo
                                                                    objMetodoseing.ExportarArchivo(listaeing); // Exportar
                                                                                                               // la
                                                                                                               // lista
                                                                                                               // actualizada
                                                                    listacomp.add(equipoADevolver); // Agregar el equipo
                                                                                                    // de nuevo al
                                                                                                    // inventario
                                                                    System.out.println(
                                                                            "El equipo ha sido devuelto al inventario.\n");
                                                                } else {
                                                                    System.out.println(
                                                                            "No se encontró el computador asociado al préstamo.\n");
                                                                }
                                                            } else {
                                                                System.out.println(
                                                                        "Préstamo no encontrado para esta cédula.\n");
                                                            }
                                                            break;

                                                        case 2:
                                                            System.out.println("Regresando...\n");
                                                            break;

                                                        default:
                                                            System.out.println(
                                                                    "Opción no válida. Por favor, ingrese 1 o 2.\n");
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Por favor, ingrese un número entero.\n");
                                                    sc.next();
                                                }
                                            } while (Op != 1 && Op != 2);
                                        } else {
                                            System.out.println(
                                                    "Cédula no encontrada en el sistema, realice una solicitud.\n");
                                        }
                                        break;

                                    case 4:
                                        System.out.println("Buscar equipo\n");
                                        listacomp = objMetodoscomp.ImportarArchivo();
                                        Metodoscomp objMetodoscompb = new Metodoscomp();
                                        String SerialBuscarb = "";
                                        System.out.println("Ingrese el serial que desea buscar");
                                        SerialBuscarb = sc.next();
                                        computadores result = objMetodoscompb.Buscar(listacomp, SerialBuscarb);

                                        if (result != null) {

                                            System.out.println();
                                            System.out.println("Serial: " + " " + result.getSerial());
                                            System.out.println("Marca: " + " " + result.getMarca());
                                            System.out.println("Tamaño: " + " " + result.getTamano());
                                            System.out.println("Precio: " + " " + result.getPrecio());
                                            System.out.println(
                                                    "Sistema Operativo: " + " " + result.getSistemaOperativo());
                                            System.out.println("Procesador: " + " " + result.getProcesador());
                                            System.out.println();
                                            System.out.println("------------------------------- \n");
                                        } else {
                                            System.out.println("El registro no existe\n");
                                        }
                                        break;

                                    case 5:
                                        System.out.println("Regresando al menú principal.\n");
                                        break;

                                    default:
                                        System.out.println("Opción no válida, seleccione del 1 al 5.\n");
                                        break;
                                }
                            } else {
                                System.out.println("Por favor, ingrese un número entero.\n");
                                sc.next();
                            }
                        } while (optt != 5);
                        break;

                    case 3:
                        int op = 0;
                        do {
                            System.out.println("Ver inventario");
                            System.out.println("1.Estudiante de diseño, 2. Estudiante de ingenieria, 3.Volver\n");
                            if (sc.hasNextInt()) {
                                op = sc.nextInt();
                                switch (op) {
                                    case 1:
                                        System.out.println();
                                        System.out.println("          TABLETS\n");
                                        System.out.println();
                                        objMetodostab.MostrarLista(listatab);
                                        System.out.println();
                                        break;
                                    case 2:
                                        System.out.println();
                                        System.out.println("          COMPUTADORES\n");
                                        System.out.println();
                                        objMetodoscomp.MostrarLista(listacomp);
                                        System.out.println();
                                        break;
                                    case 3:
                                        System.out.println("Volviendo...\n");
                                        break;
                                    default:
                                        System.out.println("Opción no válida. Por favor, elija una opción de 1 a 3.\n");
                                        break;
                                }
                            } else {
                                System.out.println("Por favor, ingrese un número entero.\n");
                                sc.next();
                            }
                        } while (op != 3);
                        break;

                    case 4:
                        System.out.println("Saliste");
                        sc.close();
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, elija una opción de 1 a 4.\n");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero.\n");
                sc.next();
            }
        } while (opc != 4);
    }
}