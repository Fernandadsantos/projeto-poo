package compartilhado.util;
import compartilhado.database.Database;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import moduloEmpresa.modelEmpresa.Municipio;

/**
 * Essa classe permite que o arquivo CSV seja lido e processado corretamente,
 * extraindo apenas os dados necessários: o nome do município e sua média de irradiação anual. 
 * 
 * A cada linha lida, o programa instancia um novo município, adicionando-o à lista de municípios.
 *
 */

public class CsvUtil {
	
            private final static String caminho = "/compartilhado/data/base_irradiacao.csv";

            public static void lerCSV() {
                Path path = Paths.get(caminho);

                try (InputStream is = CsvUtil.class.getResourceAsStream(caminho);
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
			 String linha;
			 
			 while ((linha = br.readLine()) != null) {
				 String[] colunas = linha.split(";");
				 
				 String municipio = colunas[3];
				 String irradiacao = colunas[6];
				 
				 double mediaIrradiacao = Double.parseDouble(irradiacao);
				 int media = (int) mediaIrradiacao;
				 
				 Municipio novoMunicipio = new Municipio(municipio, media);
                                 Database.adicionarElemento(novoMunicipio, Database.TipoLista.MUNICIPIO);
			 }
		} catch (IOException e) {
			System.out.println("Erro ao ler base CSV de irradiacao: " + e.getMessage());
		}
	}	
}
