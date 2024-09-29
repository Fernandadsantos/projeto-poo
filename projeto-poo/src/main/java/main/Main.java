package main;

import model.Municipio;
import util.CsvReader;

public class Main {

	public static void main(String[] args) {
		
		CsvReader csvReader = new CsvReader();
		csvReader.lerCSV();
		
		Municipio.listarMunicipios();
	}

}
