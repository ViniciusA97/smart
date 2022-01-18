package learning.micronaut.application.service;

import jakarta.inject.Singleton;
import learning.micronaut.application.presentation.ProductRequestDto;
import learning.micronaut.application.presentation.ProductResponseDto;
import learning.micronaut.domain.Product;
import learning.micronaut.infrastructure.repository.ProductRepository;

import java.util.*;

@Singleton
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponseDto createProduct(ProductRequestDto productDto) {

        Product product = Product.fromPresentation(productDto);
        Product newProduct = productRepository.save(product);

        return ProductResponseDto.fromEntity(newProduct);
    }

    @Override
    public ProductResponseDto findProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductResponseDto responseDto = null;
        if (product != null) {
            responseDto = ProductResponseDto.fromEntity(product);
        }
        return responseDto;
    }

    @Override
    public List<ProductResponseDto> findAll() {
        Iterable<Product> all = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<ProductResponseDto>();

        all.forEach(product -> {
            productResponseDtos.add(ProductResponseDto.fromEntity(product));
        });

        return productResponseDtos;
    }

    @Override
    public ProductResponseDto update(ProductRequestDto productDto, Long id) {
        Product product = productRepository.find(id);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());

        return ProductResponseDto.fromEntity(productRepository.save(product));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
