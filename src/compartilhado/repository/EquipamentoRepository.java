package compartilhado.repository;
 
import java.io.*;
import java.util.List;
import moduloEmpresa.modelEmpresa.Fabricante;
import moduloEmpresa.modelEmpresa.PlacaSolar;
import moduloEmpresa.modelEmpresa.Inversor;
/**
 *
 * @author Fernanda
 */

public class EquipamentoRepository {

    private static String CSV_FILE;
    
    public EquipamentoRepository(String path){
        this.CSV_FILE = path;
    }
 
    public static void salvarPlacaSolarCSV(List<PlacaSolar> placas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSV_FILE))) {
             
            bw.write("Fabricante,valor");
            bw.newLine();
 
            for (PlacaSolar placa : placas) {
                String linha = String.format("%s,%f,%d",
                        placa.getFabricante(),
                        placa.getValor(),
                        placa.getCapacidade());
                bw.write(linha);
                bw.newLine();
            }
 
        } catch (IOException e) {
             throw new IOException("Erro ao salvar os equipamentos no arquivo CSV: " + e.getMessage(), e);
        }
    }
 
    public static void carregarPlacasCSV() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String linha;
            boolean primeiraLinha = true;
 
            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) { 
                    primeiraLinha = false;
                    continue;
                }
 
                String[] dados = linha.split(","); 
 
                if (dados.length == 3) {
                    Fabricante fabricante = new Fabricante(dados[0]); 
                    
                    new PlacaSolar(fabricante, Double.parseDouble(dados[1]), Integer.parseInt(dados[2]));
                }
            }
 
        } catch (IOException e) { 
            throw new IOException("Erro ao carregar os clientes do arquivo CSV: " + e.getMessage(), e);
        }
    }
}
 
