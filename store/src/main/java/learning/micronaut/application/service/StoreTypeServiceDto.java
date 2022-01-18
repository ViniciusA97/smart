package learning.micronaut.application.service;

import jakarta.inject.Singleton;
import learning.micronaut.application.presentation.TypeStoreDto;
import learning.micronaut.domain.TypeStore;
import learning.micronaut.infrastructure.repository.StoreTypeRepository;

@Singleton
public class StoreTypeServiceDto implements StoreTypeService {

    private final StoreTypeRepository storeTypeRepository;

    public StoreTypeServiceDto(StoreTypeRepository storeTypeRepository) {
        this.storeTypeRepository = storeTypeRepository;
    }

    @Override
    public TypeStoreDto create(TypeStoreDto typeStoreDto) {
        TypeStore typeStore = TypeStore.fromPresentation(typeStoreDto);
        return typeStoreDto.fromEntity(storeTypeRepository.save(typeStore));
    }
}
