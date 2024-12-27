package csd230.lecture_jpa_practical_example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findFirstByName(String name);
    List<Product> findAllByName(String name);

}
