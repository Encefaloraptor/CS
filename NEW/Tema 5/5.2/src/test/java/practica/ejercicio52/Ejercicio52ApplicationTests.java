package practica.ejercicio52;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Ejercicio52ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void calculatesDaysAcrossMonthsInEitherDateOrder() {
		FormInfo formInfo = formWithDates("2024-01-31", "2024-03-01");

		assertEquals(30, formInfo.diasEntreFechas());
		formInfo.setFecha1(LocalDate.parse("2024-03-01"));
		formInfo.setFecha2(LocalDate.parse("2024-01-31"));
		assertEquals(30, formInfo.diasEntreFechas());
	}

	@Test
	void listsLeapYearsBetweenTheSelectedYears() {
		FormInfo formInfo = formWithDates("2024-12-31", "2019-01-01");

		assertEquals(List.of(2020, 2024), formInfo.añosBisiestos());
	}

	@Test
	void countsOnlySundaysOnJanuaryFirstWithinTheDates() {
		FormInfo formInfo = formWithDates("2017-01-02", "2023-01-01");

		assertEquals(1, formInfo.domingoUnoEnero());
	}

	private FormInfo formWithDates(String firstDate, String secondDate) {
		FormInfo formInfo = new FormInfo();
		formInfo.setFecha1(LocalDate.parse(firstDate));
		formInfo.setFecha2(LocalDate.parse(secondDate));
		return formInfo;
	}
}
