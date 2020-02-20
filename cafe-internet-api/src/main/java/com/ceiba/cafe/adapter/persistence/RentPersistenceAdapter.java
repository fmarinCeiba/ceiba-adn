package com.ceiba.cafe.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cafe.adapter.persistence.entity.RentJpaEntity;
import com.ceiba.cafe.adapter.persistence.exception.NotFoundRentException;
import com.ceiba.cafe.adapter.persistence.mapper.RentMapper;
import com.ceiba.cafe.adapter.persistence.repo.RentRepository;
import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.common.PersistenceAdapter;
import com.ceiba.cafe.domain.Rent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class RentPersistenceAdapter implements RentPort {
	private static final String NOT_FOUND_RENT = "Renta no encontrada";
	private final RentRepository repository;
	private final RentMapper mapper;

	@Override
	public Long newRent(Rent rent) {
		RentJpaEntity rentJpa = mapper.mapToJpaEntity(rent);
		rentJpa = repository.save(rentJpa);
		return rentJpa.getId();
	}

	@Override
	public Rent getById(Long rentId) {
		RentJpaEntity rent = repository.findById(rentId)
				.orElseThrow(() -> new NotFoundRentException(RentPersistenceAdapter.NOT_FOUND_RENT));
		return mapper.mapToDomainEntity(rent);
	}

	@Override
	public List<Rent> getList() {
		List<RentJpaEntity> rents = repository.findAll();
		List<Rent> resp = new ArrayList<>();
		rents.forEach(r -> resp.add(mapper.mapToDomainEntity(r)));
		return resp;
	}

	@Override
	public void update(Rent rent) {
		RentJpaEntity categoryJpa = mapper.mapToJpaEntity(rent);
		repository.save(categoryJpa);

	}

}
