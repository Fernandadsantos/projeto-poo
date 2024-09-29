package util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Municipio;

/**
 * Essa classe permite que o arquivo CSV seja lido e processado corretamente,
 * extraindo apenas os dados necessários: o nome do município e sua média de irradiação anual. 
 * 
 * A cada linha lida, o programa instancia um novo município, adicionando-o à lista de municípios.
 *
 */

public class CsvReader {
	
	private final String caminho = "src/main/java/data/base_irradiacao.csv";

	public void lerCSV() {
	
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			 String linha;
			 
			 while ((linha = br.readLine()) != null) {
				 String[] colunas = linha.split(";");
				 
				 String municipio = colunas[3];
				 String irradiacao = colunas[6];
				 
				 double mediaIrradiacao = Double.parseDouble(irradiacao);
				 int media = (int) mediaIrradiacao;
				 
				 Municipio novoMunicipio = new Municipio(municipio, media);
			 }
		} catch (IOException e) {
			System.out.println("Erro ao ler base CSV de irradiacao: " + e.getMessage());
		}
	}	
}
