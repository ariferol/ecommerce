package tr.org.ecommerce.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "categories")
public class CategoryJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String name;
    private String description;

    @Column(name = "parent_category_id")
    private UUID parentCategoryId;

    @ManyToMany(mappedBy = "categories")
    private List<ProductEntity> products;
}
