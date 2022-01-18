package learning.micronaut.application.resource;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import learning.micronaut.application.presentation.TypeStoreDto;
import learning.micronaut.application.service.StoreTypeService;

@Controller("/store/type")
public class StoreTypeController{

    private final StoreTypeService storeTypeService;

    public StoreTypeController(StoreTypeService storeTypeService) {
        this.storeTypeService = storeTypeService;
    }

    @Post
    public TypeStoreDto createTypeStore(@Body TypeStoreDto typeStoreDto){
        return storeTypeService.create(typeStoreDto);
    }

}
