package com.ceiba.cafe.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.domain.Rent;

public class FindRentUseCaseTest {
	private final RentPort rentPort = Mockito.mock(RentPort.class);

	private final FindRentUseCase findRent = new FindRentUseCase(rentPort);

	@Test
	void findARent() {
		Long idRent = 1L;

		Rent rent = Rent.withId(idRent, 1L, 1L, true, LocalDateTime.now(), LocalDateTime.now());
		when(rentPort.getById(idRent)).thenReturn(rent);

		Rent rentBD = findRent.find(rent.getId()).get(0);

		assertThat(rentBD).isEqualTo(rent);
	}

	@Test
	void findAllRent() {
		List<Rent> rents = new ArrayList<>();
		rents.add(Rent.withoutId(1L, 1L, true, LocalDateTime.now(), LocalDateTime.now()));
		rents.add(Rent.withoutId(2L, 3L, true, LocalDateTime.now(), LocalDateTime.now()));
		when(rentPort.getList()).thenReturn(rents);

		List<Rent> rentsBD = findRent.find(null);

		assertThat(rents.size()).isEqualTo(rentsBD.size());
		assertThat(rents.get(0).getComputerId()).isEqualTo(1L);
		assertThat(rents.get(1).getComputerId()).isEqualTo(3L);
	}
}
