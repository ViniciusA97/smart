package learning.micronaut.application.service;

import learning.micronaut.application.presentation.ProductRequestDto;
import learning.micronaut.application.presentation.ProductResponseDto;
import learning.micronaut.domain.Product;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productDto);

    ProductResponseDto findProduct(Long id);

    List<ProductResponseDto> findAll();

    ProductResponseDto update(ProductRequestDto productDto, Long id);

    void delete(Long id);

}
