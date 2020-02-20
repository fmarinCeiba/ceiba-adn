package com.ceiba.cafe.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cafe.adapter.persistence.entity.StatusJpaEntity;
import com.ceiba.cafe.adapter.persistence.exception.NotFoundStatusException;
import com.ceiba.cafe.adapter.persistence.mapper.StatusMapper;
import com.ceiba.cafe.adapter.persistence.repo.StatusRepository;
import com.ceiba.cafe.app.port.out.StatusPort;
import com.ceiba.cafe.common.PersistenceAdapter;
import com.ceiba.cafe.domain.Status;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class StatusPersistenceAdapter implements StatusPort {
	private static final String NOT_FOUND_STATUS = "Status no encontrado";
	private final StatusRepository repository;
	private final StatusMapper mapper;

	@Override
	public Status getById(Long statusId) {
		StatusJpaEntity status = repository.findById(statusId)
				.orElseThrow(() -> new NotFoundStatusException(StatusPersistenceAdapter.NOT_FOUND_STATUS));
		return mapper.mapToDomainEntity(status);
	}

	@Override
	public List<Status> getList() {
		List<StatusJpaEntity> statuses = repository.findAll();
		List<Status> resp = new ArrayList<>();
		statuses.forEach(s -> resp.add(mapper.mapToDomainEntity(s)));
		return resp;
	}

}
