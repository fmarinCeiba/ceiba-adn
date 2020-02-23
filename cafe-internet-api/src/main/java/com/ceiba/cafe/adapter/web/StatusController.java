package com.ceiba.cafe.adapter.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cafe.app.port.in.FindStatusUseCase;
import com.ceiba.cafe.common.WebAdapter;
import com.ceiba.cafe.domain.Status;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequestMapping("cafe-api/status")
@RequiredArgsConstructor
public class StatusController {

	private final FindStatusUseCase findStatus;

	@GetMapping("/{statusId}")
	public ResponseEntity<List<Status>> getStatus(@PathVariable("statusId") Long statusId) {
		return new ResponseEntity<>(findStatus.find(statusId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Status>> getStatuses() {
		return new ResponseEntity<>(findStatus.find(null), HttpStatus.OK);
	}
}
