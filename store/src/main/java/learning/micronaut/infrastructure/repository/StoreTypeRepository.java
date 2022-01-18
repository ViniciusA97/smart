package learning.micronaut.infrastructure.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import learning.micronaut.domain.TypeStore;

@Repository
public interface StoreTypeRepository extends CrudRepository<TypeStore, Long> {
}
