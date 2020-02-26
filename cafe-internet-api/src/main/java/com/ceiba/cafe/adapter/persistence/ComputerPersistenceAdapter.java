package com.ceiba.cafe.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cafe.adapter.persistence.entity.ComputerJpaEntity;
import com.ceiba.cafe.adapter.persistence.exception.NotFoundComputerException;
import com.ceiba.cafe.adapter.persistence.mapper.ComputerMapper;
import com.ceiba.cafe.adapter.persistence.repo.ComputerRepository;
import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.PersistenceAdapter;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class ComputerPersistenceAdapter implements ComputerPort {
	private static final String NOT_FOUND_COMPUTER = "Computador no encontrado";
	private final ComputerRepository repository;
	private final ComputerMapper mapper;

	@Override
	public Long newComputer(Computer computer) {
		ComputerJpaEntity computerJpa = mapper.mapToJpaEntity(computer);
		computerJpa = repository.save(computerJpa);
		return computerJpa.getId();
	}

	@Override
	public Computer getById(Long computerId) {
		ComputerJpaEntity computer = repository.findById(computerId)
				.orElseThrow(() -> new NotFoundComputerException(ComputerPersistenceAdapter.NOT_FOUND_COMPUTER));
		return mapper.mapToDomainEntity(computer);
	}

	@Override
	public List<Computer> getList() {
		List<ComputerJpaEntity> computers = repository.findAll();
		List<Computer> resp = new ArrayList<>();
		computers.forEach(c -> resp.add(mapper.mapToDomainEntity(c)));
		return resp;
	}

	@Override
	public List<Computer> getByStatusId(Long statusId) {
		List<ComputerJpaEntity> computers = repository.findByIdStatus(statusId);
		List<Computer> resp = new ArrayList<>();
		computers.forEach(c -> resp.add(mapper.mapToDomainEntity(c)));
		return resp;
	}

	@Override
	public void update(Computer computer) {
		ComputerJpaEntity categoryJpa = mapper.mapToJpaEntity(computer);
		repository.save(categoryJpa);

	}

	@Override
	public void delete(Long computerId) {
		ComputerJpaEntity computer = repository.findById(computerId)
				.orElseThrow(() -> new NotFoundComputerException(ComputerPersistenceAdapter.NOT_FOUND_COMPUTER));
		repository.delete(computer);

	}

}
