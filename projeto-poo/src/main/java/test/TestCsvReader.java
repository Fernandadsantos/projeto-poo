package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Municipio;
import util.CsvReader;

class TestCsvReader {

	@BeforeEach
	void setUp() throws Exception {
		CsvReader csvReader = new CsvReader();
	}

	@Test
	void testLerCSV() {
		Municipio.listarMunicipios();	
	}

}
