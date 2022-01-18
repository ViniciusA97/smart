package learning.micronaut.infrastructure.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import learning.micronaut.domain.Store;

import java.util.List;

@Repository
public interface StoreRepository extends CrudRepository<Store, Long> {
    List<Store> findByTypeStoreId(Long typeStoreId);
}
