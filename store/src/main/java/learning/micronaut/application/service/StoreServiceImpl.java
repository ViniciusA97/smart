package learning.micronaut.application.service;

import jakarta.inject.Singleton;
import learning.micronaut.application.presentation.StoreRequestDto;
import learning.micronaut.application.presentation.StoreResponseDto;
import learning.micronaut.domain.Store;
import learning.micronaut.infrastructure.amqp.Producer;
import learning.micronaut.infrastructure.repository.StoreRepository;
import learning.micronaut.infrastructure.repository.StoreTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class StoreServiceImpl implements StoreService{

    private final StoreRepository storeRepository;
    private final StoreTypeRepository storeTypeRepository;
    private final Producer producer;

    public StoreServiceImpl(StoreRepository storeRepository, StoreTypeRepository storeTypeRepository, Producer producer) {
        this.storeRepository = storeRepository;
        this.storeTypeRepository = storeTypeRepository;
        this.producer = producer;
    }

    @Override
    public StoreResponseDto getStoreById(Long idStore) {
        return StoreResponseDto.fromEntity(storeRepository.findById(idStore).orElseThrow(()-> new RuntimeException("Não foi encontrado a store com este id.")));
    }

    @Override
    public List<StoreResponseDto> getAllStores() {
        return convertToResponse(storeRepository.findAll());
    }

    @Override
    public List<StoreResponseDto> getAllStoreByType(Long idTypeStore) {
        return convertToResponse(storeRepository.findByTypeStoreId(idTypeStore));
    }

    @Override
    public StoreResponseDto createStore(StoreRequestDto store) {
        Store storeToCreate = Store.fromPresentation(store);
        producer.sendStoryUpdates(storeToCreate);
        return StoreResponseDto.fromEntity(storeRepository.save(storeToCreate));
    }

    @Override
    public StoreResponseDto updateStore(StoreRequestDto store, Long id) {

        Store storeToUpdate = storeRepository.findById(id).orElse(null);

        if(storeToUpdate != null){
            storeToUpdate.setName(store.getName());
            storeToUpdate.setStatusStore(store.getStatusStore());
            storeToUpdate.setDescription(store.getDescription());
            storeToUpdate.setAddress(store.getAddress());
            storeToUpdate.setCnpj(store.getCnpj());
            storeToUpdate.setTypeStore(storeTypeRepository.findById(store.getTypeStore().getId()).get());
            return StoreResponseDto.fromEntity(storeRepository.save(storeToUpdate));
        }

        throw new RuntimeException("Fala para realizar o update: Store não existe");
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    private List<StoreResponseDto> convertToResponse(Iterable<Store> stores){
        ArrayList<StoreResponseDto> storesResponse = new ArrayList<StoreResponseDto>();
        stores.forEach(store -> {
            storesResponse.add(StoreResponseDto.fromEntity(store));
        });
        return storesResponse;
    }



}
