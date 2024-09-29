package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Municipio;
import util.CsvUtil;

class TestCsvReader {

	@BeforeEach
	void setUp() throws Exception {
		CsvUtil csvReader = new CsvUtil();
	}

	@Test
	void testLerCSV() {
		Municipio.listarMunicipios();	
	}

}
