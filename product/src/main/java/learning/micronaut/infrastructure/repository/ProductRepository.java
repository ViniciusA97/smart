package learning.micronaut.infrastructure.repository;


import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import learning.micronaut.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Executable
    Product find(Long id);
}
