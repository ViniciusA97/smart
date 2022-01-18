package learning.micronaut.application.service;

import learning.micronaut.application.presentation.TypeStoreDto;

public interface StoreTypeService {

    TypeStoreDto create(TypeStoreDto typeStoreDto);
}
