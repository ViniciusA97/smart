package learning.micronaut.application.resource;

import io.micronaut.http.annotation.*;
import learning.micronaut.application.presentation.StoreRequestDto;
import learning.micronaut.application.presentation.StoreResponseDto;
import learning.micronaut.application.service.StoreService;
import java.util.List;

@Controller("/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @Get
    public List<StoreResponseDto> findAll(){
        return storeService.getAllStores();
    }

    @Get("/{id}")
    public StoreResponseDto getById(Long id){
        return storeService.getStoreById(id);
    }

    @Post
    public StoreResponseDto create(@Body StoreRequestDto storeRequestDto){
        return storeService.createStore(storeRequestDto);
    }

    @Put("/{id}")
    public StoreResponseDto update(@Body StoreRequestDto storeRequestDto, Long id){
        return storeService.updateStore(storeRequestDto, id);
    }

    @Delete("/{id}")
    public void delete(Long id){
        storeService.deleteStore(id);
    }

}
