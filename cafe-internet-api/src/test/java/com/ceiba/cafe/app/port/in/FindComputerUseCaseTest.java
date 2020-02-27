package com.ceiba.cafe.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.domain.Computer;

public class FindComputerUseCaseTest {
	private final ComputerPort computerPort = Mockito.mock(ComputerPort.class);

	private final FindComputerUseCase findComputer = new FindComputerUseCase(computerPort);

	@Test
	void findComputersAvailables() {
		Long idComputer = 1L;
		Long idStatus = 2L;// ocupado

		List<Computer> computers = new ArrayList<>();
		computers.add(Computer.withId(idComputer, "Gamer1", 1L, 1L, "192.168.100.110", "fe80::e554:b521:ee60:e1c9#9",
				"cuarto 1"));
		computers.add(Computer.withId(idComputer + 1, "Edicion1", 2L, 3L, "192.168.100.210",
				"fe80::e554:b521:ee60:e1c9", "cuarto 2"));
		when(computerPort.getByStatusId(idStatus)).thenReturn(computers);

		List<Computer> computersBD = findComputer.find(idStatus);

		assertThat(computersBD.size()).isEqualTo(computers.size());
		assertThat(computersBD.get(0).getName()).isEqualTo("Gamer1");
	}

	@Test
	void findAllComputer() {
		List<Computer> computers = new ArrayList<>();
		computers.add(Computer.withoutId("Normal1", 1L, 1L, "192.168.100.10", "fe80::e554:b521:ee60:e1c9%9",
				"frente al servidor"));
		computers.add(
				Computer.withoutId("Gamer1", 1L, 2L, "192.168.100.110", "fe80::e554:b521:ee60:e1c9#9", "cuarto 1"));
		computers.add(
				Computer.withoutId("Edicion1", 1L, 3L, "192.168.100.210", "fe80::e554:b521:ee60:e1c9", "cuarto 2"));
		when(computerPort.getList()).thenReturn(computers);

		List<Computer> computersBD = findComputer.find(null);

		assertThat(computers.size()).isEqualTo(computersBD.size());
		assertThat(computersBD.get(0).getName()).isEqualTo("Normal1");
		assertThat(computersBD.get(1).getName()).isEqualTo("Gamer1");
		assertThat(computersBD.get(2).getName()).isEqualTo("Edicion1");
	}
}
