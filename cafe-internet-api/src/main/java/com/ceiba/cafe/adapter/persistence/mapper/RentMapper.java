package com.ceiba.cafe.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.cafe.adapter.persistence.entity.RentJpaEntity;
import com.ceiba.cafe.domain.Rent;

@Component
public class RentMapper {

	public Rent mapToDomainEntity(RentJpaEntity rent) {
		return Rent.withId(rent.getId()
				, rent.getIdClient()
				, rent.getIdComputer()
				, rent.getStartTime()
				, rent.getEndTime()
			);
	}

	public RentJpaEntity mapToJpaEntity(Rent rent) {
		return new RentJpaEntity(
				rent.getId() == null? null : rent.getId()
				, rent.getClientId()
				, rent.getComputerId()
				, rent.getStart()
				, rent.getEnd()
			);
	}
}
