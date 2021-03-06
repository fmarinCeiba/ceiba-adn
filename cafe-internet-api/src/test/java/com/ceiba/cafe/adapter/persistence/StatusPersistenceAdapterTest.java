package com.ceiba.cafe.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ceiba.cafe.adapter.persistence.mapper.StatusMapper;
import com.ceiba.cafe.domain.Status;

@DataJpaTest
@Import({ StatusPersistenceAdapter.class, StatusMapper.class })
public class StatusPersistenceAdapterTest {
	@Autowired
	private StatusPersistenceAdapter adapterUnderTest;

	@Test
	void getStatus() {
		Status status = adapterUnderTest.getById(1L);

		assertThat(status.getDescription()).isEqualTo("libre");
	}

	@Test
	void getStatuses() {
		List<Status> statues = adapterUnderTest.getList();

		assertThat(statues).hasSize(8);
		assertThat(statues.get(0).getDescription()).isEqualTo("libre");
	}

}
