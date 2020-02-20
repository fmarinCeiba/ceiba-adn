package com.ceiba.cafe.adapter.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cafe.app.command.RentCommand;
import com.ceiba.cafe.app.port.in.CalculateRentUseCase;
import com.ceiba.cafe.app.port.in.CreateRentUseCase;
import com.ceiba.cafe.app.port.in.FindRentUseCase;
import com.ceiba.cafe.app.port.in.UpdateRentUseCase;
import com.ceiba.cafe.common.WebAdapter;
import com.ceiba.cafe.domain.Rent;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequestMapping("cafe-api/rent")
@RequiredArgsConstructor
public class RentController {
	private final CreateRentUseCase newRent;
	private final FindRentUseCase fndRent;
	private final UpdateRentUseCase updRent;
	private final CalculateRentUseCase calRent;

	@PutMapping
	public ResponseEntity<Long> create(@RequestBody RentCommand rent) throws Exception {
		return new ResponseEntity<>(newRent.create(rent), HttpStatus.CREATED);
	}

	@GetMapping("/{rentId}")
	public ResponseEntity<List<Rent>> getRent(@PathVariable("rentId") Long rentId) throws Exception {
		return new ResponseEntity<>(fndRent.find(rentId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Rent>> getRents() throws Exception {
		return new ResponseEntity<>(fndRent.find(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Boolean> update(@RequestBody RentCommand rent) throws Exception {
		return new ResponseEntity<>(updRent.update(rent), HttpStatus.OK);
	}

	@GetMapping("/time/{computerId}/{amount}")
	public ResponseEntity<Long> getTime(@PathVariable("computerId") Long computerId,
			@PathVariable("amount") Long amount) throws Exception {
		return new ResponseEntity<>(calRent.time(computerId, amount), HttpStatus.OK);
	}

	@GetMapping("/amount/{computerId}/{time}")
	public ResponseEntity<Long> getAmount(@PathVariable("computerId") Long computerId, @PathVariable("time") Long time)
			throws Exception {
		return new ResponseEntity<>(calRent.amount(computerId, time), HttpStatus.OK);
	}
}
