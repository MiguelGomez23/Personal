import java.util.Scanner;

public class Tableta {

    String Serial;
    String Marca;
    float Tamano;
    float Precio;
    String Almacenamiento;
    float Peso;

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public float getTamano() {
        return Tamano;
    }

    public void setTamano(float tamano) {
        Tamano = tamano;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float precio) {
        Precio = precio;
    }

    public String getAlmacenamiento() {
        return Almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        Almacenamiento = almacenamiento;
    }

    public float getPeso() {
        return Peso;
    }

    public void setPeso(float peso) {
        Peso = peso;
    }

    public void Seleccionartamaño() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el tamaño");
        while (!sc.hasNextFloat()) {
            System.out.println("Opcion no valida, por favor ingrese un tamaño válido");
            sc.next();
        }
        System.out.println("El tamaño de su tableta es: " + Tamano);
        System.out.println();
    }

    public void SeleccionarPrecio() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el precio");
        while (!sc.hasNextFloat()) {
            System.out.println("Opcion no valida, por favor ingrese un precio válido");
            sc.next(); // Descartar entrada inválida
        }
        System.out.println("El precio de su tableta es: " + Precio);
        System.out.println();
    }

    public void SeleccionarAlmacenamiento() {

        Scanner scanner = new Scanner(System.in);

        int opt = 0;
        do {
            System.out.println("Seleccione el almacenamiento que desea");
            System.out.println("1. 256 GB");
            System.out.println("2. 512 GB");
            System.out.println("3. 1 TB");
            System.out.println();
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
                switch (opt) {
                    case 1:
                        Almacenamiento = "256 GB";
                        break;
                    case 2:
                        Almacenamiento = "512 GB";
                        break;
                    case 3:
                        Almacenamiento = "1 TB";
                        break;
                    default:
                        System.out.println("Opción inválida,por favor eliga una opción de 1 a 3\n");
                        break;
                }
            } else {
                System.out.println("Por favor, ingrese un número entero.\n");
                scanner.next();
            }
        } while (opt < 1 || opt > 3);

        // scanner.close();
        System.out.println("Almacenamiento seleccionado: " + Almacenamiento);
    }

    public void SeleccionarMarca() {

        Scanner scanner = new Scanner(System.in);

        int opt = 0;
        do {
            System.out.println("Seleccione la marca que desea:");
            System.out.println("1. Acer");
            System.out.println("2. Dell");
            System.out.println("3. Asus");
            System.out.println();
            if (scanner.hasNextInt()) {
                opt = scanner.nextInt();
                switch (opt) {
                    case 1:
                        Marca = "Acer";
                        break;
                    case 2:
                        Marca = "Dell";
                        break;
                    case 3:
                        Marca = "Asus";
                        break;
                    default:
                        System.out.println("Opción inválida, por favor ingrese del 1 al 3");
                        break;
                }
            } else {
                System.out.println("Ingrese un número entero");
                scanner.next();
            }
        } while (opt < 1 || opt > 3);

        System.out.println("Marca seleccionada: " + Marca);
        System.out.println();
    }
}