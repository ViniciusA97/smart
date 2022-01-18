package learning.micronaut.application.service;


import learning.micronaut.application.presentation.StoreRequestDto;
import learning.micronaut.application.presentation.StoreResponseDto;

import java.util.List;

public interface StoreService {

    StoreResponseDto getStoreById(Long idStore);
    List<StoreResponseDto> getAllStores();
    List<StoreResponseDto> getAllStoreByType(Long idTypeStore);
    StoreResponseDto createStore(StoreRequestDto store);
    StoreResponseDto updateStore(StoreRequestDto store, Long id);
    void deleteStore(Long id);

}
