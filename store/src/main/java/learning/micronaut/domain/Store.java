package learning.micronaut.domain;

import learning.micronaut.application.presentation.StoreRequestDto;

import javax.persistence.*;

@Entity
@Table(name = "T_STORE")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ID_STORE")
    @SequenceGenerator(name = "SEQUENCE_ID_STORE", sequenceName = "S_ID_STORE", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_typestore", referencedColumnName = "id")
    private TypeStore typeStore;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "ADDRESS")
    private String  address;

    @Column(name = "STATUSSTORE")
    @Enumerated(EnumType.STRING)
    private StatusStore statusStore;

    public Store(Long id, String name, TypeStore typeStore, String description, String cnpj, String address, StatusStore statusStore) {
        this.id = id;
        this.name = name;
        this.typeStore = typeStore;
        this.description = description;
        this.cnpj = cnpj;
        this.address = address;
        this.statusStore = statusStore;
    }
    public Store(String name, TypeStore typeStore, String description, String cnpj, String address, StatusStore statusStore) {
        this.name = name;
        this.typeStore = typeStore;
        this.description = description;
        this.cnpj = cnpj;
        this.address = address;
        this.statusStore = statusStore;
    }

    public Store() {
    }

    public static Store fromPresentation(StoreRequestDto store) {
        return new Store(
                store.getName(),
                TypeStore.fromPresentation(store.getTypeStore()),
                store.getDescription(),
                store.getCnpj(),
                store.getAddress(),
                store.getStatusStore()
        );
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeStore getTypeStore() {
        return typeStore;
    }

    public void setTypeStore(TypeStore typeStore) {
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

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeStore=" + typeStore +
                ", description='" + description + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", address='" + address + '\'' +
                ", statusStore=" + statusStore +
                '}';
    }
}
