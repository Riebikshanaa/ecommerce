package com.cg.ecom.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.cg.ecom.model.Category;
import com.cg.ecom.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>, PagingAndSortingRepository<Product, Long>

{
	Optional<Product>findByproductId(long productId) ;
	public List<Product> findByCategory(Category category);

	public Page<Product> findByCategory(Category category, Pageable paging);
}