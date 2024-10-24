package com.myapp.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;




@Entity
@Table(name = "product_category")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @lombok.NonNull
    private Long id;

    @Column(name = "category_name")
    @lombok.NonNull
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
//   solution for recursion reference
//   SOL2:
    @JsonManagedReference
    @JsonIgnore
    private List<Product> products;
}
