package learning.micronaut.domain;

import learning.micronaut.application.presentation.TypeStoreDto;

import javax.persistence.*;

@Table
@Entity(name = "T_STORETYPE")
public class TypeStore {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ID_STORE_TYPE")
    @SequenceGenerator(name = "SEQUENCE_ID_STORE_TYPE", sequenceName = "S_ID_STORE_TYPE", allocationSize = 1)
    private long id;

    @Column(name = "TYPE")
    private String type;

    public TypeStore(long id, String type) {
        this.id = id;
        this.type = type;
    }

    public TypeStore() {
    }

    public static TypeStore fromPresentation(TypeStoreDto typeStoreDto){
        return new TypeStore(
                typeStoreDto.getId(),
                typeStoreDto.getType()
        );
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
