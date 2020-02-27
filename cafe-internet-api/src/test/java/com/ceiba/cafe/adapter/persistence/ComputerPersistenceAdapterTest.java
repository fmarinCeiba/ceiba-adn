package com.ceiba.cafe.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ceiba.cafe.adapter.persistence.mapper.ComputerMapper;
import com.ceiba.cafe.domain.Computer;

@DataJpaTest
@Import({ ComputerPersistenceAdapter.class, ComputerMapper.class })
public class ComputerPersistenceAdapterTest {
	@Autowired
	private ComputerPersistenceAdapter adapterUnderTest;

	@Test
	void getComputer() {
		Computer computer = adapterUnderTest.getById(1L);

		assertThat(computer.getName()).isEqualTo("Normal1");
	}

	@Test
	void newComputer() {
		Computer jose = Computer.withoutId("Gamer1", 1L, 2L, "192.168.100.110", "fe80::e554:b521:ee60:e1c9#9",
				"cuarto 1");

		Long idGamer1 = adapterUnderTest.newComputer(jose);

		Computer c = adapterUnderTest.getById(idGamer1);

		assertThat(c.getName()).isEqualTo("Gamer1");
	}

	@Test
	void updateComputer() {
		Computer computer = adapterUnderTest.getById(1L);

		computer = Computer.withId(computer.getId(), "Gamer1", 1L, 2L, "192.168.100.110", "fe80::e554:b521:ee60:e1c9#9",
				"cuarto 1");

		adapterUnderTest.update(computer);

		Computer c = adapterUnderTest.getById(computer.getId());

		assertThat(c.getName()).isEqualTo("Gamer1");
	}
}
