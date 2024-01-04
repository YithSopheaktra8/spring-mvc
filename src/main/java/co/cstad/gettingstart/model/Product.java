package co.cstad.gettingstart.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String slug;
    private Double price;
    private Boolean inStock;
}
