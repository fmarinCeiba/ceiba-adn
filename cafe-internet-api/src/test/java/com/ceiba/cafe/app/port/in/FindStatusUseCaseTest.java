package com.ceiba.cafe.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.in.FindStatusUseCase;
import com.ceiba.cafe.app.port.out.StatusPort;
import com.ceiba.cafe.domain.Status;

public class FindStatusUseCaseTest {
	private final StatusPort statusPort = Mockito.mock(StatusPort.class);

	private final FindStatusUseCase findStatus = new FindStatusUseCase(statusPort);

	@Test
	void findAnStatus() {
		Long idStatus = 1L;

		Status status = Status.withId(idStatus, "libre");
		when(statusPort.getById(idStatus)).thenReturn(status);

		Status statusBD = findStatus.find(status.getId()).get(0);

		assertThat(statusBD).isEqualTo(status);
	}

	@Test
	void findAllStatuses() {
		List<Status> statuses = new ArrayList<>();
		statuses.add(Status.withoutId("libre"));
		statuses.add(Status.withoutId("ocupado"));
		when(statusPort.getList()).thenReturn(statuses);

		List<Status> statusesBD = findStatus.find(null);

		assertThat(statuses.size()).isEqualTo(statusesBD.size());
		assertThat(statusesBD.get(0).getDescription()).isEqualTo("libre");
		assertThat(statusesBD.get(1).getDescription()).isEqualTo("ocupado");
	}
}
