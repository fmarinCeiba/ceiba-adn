package com.ceiba.cafe.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ceiba.cafe.adapter.persistence.mapper.RentMapper;
import com.ceiba.cafe.domain.Rent;

@DataJpaTest
@Import({ RentPersistenceAdapter.class, RentMapper.class })
public class RentPersistenceAdapterTest {
	@Autowired
	private RentPersistenceAdapter adapterUnderTest;

	@Test
	void getRent() {
		Rent rent = adapterUnderTest.getById(1L);

		assertThat(rent.getClientId()).isEqualTo(1L);
	}

	@Test
	void getRents() {
		List<Rent> rents = adapterUnderTest.getList();

		assertThat(rents).hasSize(1);
		assertThat(rents.get(0).getClientId()).isEqualTo(1L);
	}

	@Test
	void newRent() {
		Rent jose = Rent.withoutId(1L, 1L, true, LocalDateTime.now(), LocalDateTime.now());

		Long idRent = adapterUnderTest.newRent(jose);

		Rent c = adapterUnderTest.getById(idRent);

		assertThat(c.getClientId()).isEqualTo(1L);
	}

	@Test
	void updateRent() {
		Rent rent = adapterUnderTest.getById(1L);

		rent = Rent.withId(rent.getId(), 2L, 1L, true, LocalDateTime.now(), LocalDateTime.now());

		adapterUnderTest.update(rent);

		Rent r = adapterUnderTest.getById(rent.getId());

		assertThat(r.getClientId()).isEqualTo(2L);
	}
}
