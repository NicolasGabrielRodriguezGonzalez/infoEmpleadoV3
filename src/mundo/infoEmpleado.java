package mundo;

public class infoEmpleado {
    private String nombre;
    private String direccion;
    private String telefono;
    private double salarioActual;
    private int numero;
    private String nivelEstrato;

    public infoEmpleado(String nombre, String direccion, String telefono, double salarioActual, int numero) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salarioActual = salarioActual;
        this.numero = numero;  // Cambiado de "estrato" a "numero"
        this.nivelEstrato = determinarNivelEstrato(numero);
    }

    private String determinarNivelEstrato(int numero) {
        switch (numero) {
            case 1: return "Bajo Bajo";
            case 2: return "Bajo Medio";
            case 3: return "Bajo Alto";
            case 4: return "Medio Bajo";
            case 5: return "Medio";
            case 6: return "Medio Alto";
            default: return "Desconocido";
        }
    }

    public void incrementarSalario() {
        this.salarioActual *= 1.06;
        if (numero == 1) {
            this.salarioActual *= 1.06; // Nivel 1: 6% extra
        } else if (numero == 2) {
            this.salarioActual *= 1.05; // Nivel 2: 5% extra
        } else if (numero == 3) {
            this.salarioActual *= 1.04; // Nivel 3: 4% extra
        } else if (numero == 4) {
            this.salarioActual *= 1.03; // Nivel 4: 3% extra
        } else if (numero == 5) {
            this.salarioActual *= 1.02; // Nivel 5: 2% extra
        } else if (numero == 6) {
            this.salarioActual *= 1.01; // Nivel 6: 1% extra
        } else {
            System.out.println("Nivel de estrato inválido");
        }
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre + "\n" +
               "Dirección: " + direccion + "\n" +
               "Teléfono: " + telefono + "\n" +
               "Salario Actual: " + salarioActual + "\n" +
               "Estrato: " + numero + " (" + nivelEstrato + ")";
    }
}
