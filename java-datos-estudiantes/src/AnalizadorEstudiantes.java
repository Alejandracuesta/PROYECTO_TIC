import java.io.*;
import java.util.*;

public class AnalizadorEstudiantes {
    public static void main(String[] args) {
        String archivo = "data/estudiantes.csv";
        List<Double> notas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // Saltar cabecera

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    double nota = Double.parseDouble(partes[1]);
                    notas.add(nota);
                }
            }

            double suma = notas.stream().mapToDouble(n -> n).sum();
            double media = suma / notas.size();
            double max = Collections.max(notas);
            double min = Collections.min(notas);

            System.out.printf("Total estudiantes: %d%n", notas.size());
            System.out.printf("Nota media: %.2f%n", media);
            System.out.printf("Nota máxima: %.2f%n", max);
            System.out.printf("Nota mínima: %.2f%n", min);

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
