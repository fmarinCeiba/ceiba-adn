package com.ceiba.cafe.adapter.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rent")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Long idClient;
	@Column
	private Long idComputer;
	@Column
	private Boolean active;
	@Column
	private LocalDateTime startTime;
	@Column
	private LocalDateTime endTime;

}
