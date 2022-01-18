package learning.micronaut.application.presentation;

import learning.micronaut.domain.StatusStore;
import learning.micronaut.domain.Store;
import learning.micronaut.domain.TypeStore;

public class StoreResponseDto {

    private long id;

    private String name;

    private TypeStoreDto typeStore;

    private String description;

    private String cnpj;

    private String  address;

    private StatusStore statusStore;


    public StoreResponseDto(long id, String name, TypeStoreDto typeStore, String description, String cnpj, String address, StatusStore statusStore) {
        this.id = id;
        this.name = name;
        this.typeStore = typeStore;
        this.description = description;
        this.cnpj = cnpj;
        this.address = address;
        this.statusStore = statusStore;
    }

    public StoreResponseDto() {
    }

    public static StoreResponseDto fromEntity(Store store) {
        return new StoreResponseDto(
                store.getId(),
                store.getName(),
                TypeStoreDto.fromEntity(store.getTypeStore()),
                store.getDescription(),
                store.getCnpj(),
                store.getAddress(),
                store.getStatusStore()
        );
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeStoreDto getTypeStore() {
        return typeStore;
    }

    public void setTypeStore(TypeStoreDto typeStore) {
        this.typeStore = typeStore;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusStore getStatusStore() {
        return statusStore;
    }

    public void setStatusStore(StatusStore statusStore) {
        this.statusStore = statusStore;
    }
}
