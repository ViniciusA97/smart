package learning.micronaut.application.presentation;

import learning.micronaut.domain.TypeStore;

public class TypeStoreDto {

    private long id;
    private String type;

    public TypeStoreDto(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public TypeStoreDto() {
    }

    public static TypeStoreDto fromEntity(TypeStore typeStore) {
        return new TypeStoreDto(typeStore.getId(), typeStore.getType());
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
