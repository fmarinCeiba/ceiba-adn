package com.ceiba.cafe.adapter.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cafe.app.command.CategoryCommand;
import com.ceiba.cafe.app.port.in.CreateCategoryUseCase;
import com.ceiba.cafe.app.port.in.DeleteCategoryUseCase;
import com.ceiba.cafe.app.port.in.FindCategoryUseCase;
import com.ceiba.cafe.app.port.in.UpdateCategoryUseCase;
import com.ceiba.cafe.common.WebAdapter;
import com.ceiba.cafe.domain.Category;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequestMapping("cafe-api/category")
@RequiredArgsConstructor
public class CategoryController {
	private final CreateCategoryUseCase newCategory;
	private final FindCategoryUseCase fndCategory;
	private final UpdateCategoryUseCase updCategory;
	private final DeleteCategoryUseCase delCategory;

	@PutMapping
	public ResponseEntity<Long> create(@RequestBody CategoryCommand category) throws Exception {
		return new ResponseEntity<>(newCategory.create(category), HttpStatus.CREATED);
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<List<Category>> getCategory(@PathVariable("categoryId") Long categoryId) throws Exception {
		return new ResponseEntity<>(fndCategory.find(categoryId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Category>> getCategories() throws Exception {
		return new ResponseEntity<>(fndCategory.find(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Boolean> update(@RequestBody CategoryCommand category) throws Exception {
		return new ResponseEntity<>(updCategory.update(category), HttpStatus.OK);
	}

	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Boolean> delete(@PathVariable("categoryId") Long categoryId) throws Exception {
		return new ResponseEntity<>(delCategory.delete(categoryId), HttpStatus.OK);
	}
}
