package learning.micronaut.application.resources;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import learning.micronaut.application.presentation.ProductRequestDto;
import learning.micronaut.application.presentation.ProductResponseDto;
import learning.micronaut.application.service.ProductService;

import java.util.List;

@Controller("/product")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @Get
    public List<ProductResponseDto> findAll() {
        return productService.findAll();
    }

    @Get(uri = "/{id}")
    public ProductResponseDto findById(Long id) {
        return productService.findProduct(id);
    }

    @Post(consumes = MediaType.APPLICATION_JSON)
    public ProductResponseDto create(@Body ProductRequestDto productRequestDto) {
        return productService.createProduct(productRequestDto);
    }

    @Put("/{id}")
    public ProductResponseDto update(@Body ProductRequestDto productRequestDto, Long id) {
        return productService.update(productRequestDto, id);
    }

    @Delete("/{id}")
    public void delete(Long id) {
        productService.delete(id);
    }

}
