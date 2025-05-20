package tr.org.ecommerce.adapter.in.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tr.org.ecommerce.adapter.out.persistence.mapper.CategoryMapper;
import tr.org.ecommerce.application.service.spec.CategoryAppService;
import tr.org.ecommerce.domain.model.category.dto.CategoryDto;
import tr.org.ecommerce.domain.model.category.Category;
import tr.org.ecommerce.domain.model.common.ID;
import tr.org.ecommerce.domain.port.in.rest.CategoryRestAPI;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryController implements CategoryRestAPI {

    @Autowired
    private CategoryAppService categoryAppService;

    @PostMapping
    @Override
    public ResponseEntity<CategoryDto> registerCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryAppService.create(categoryDto);
        URI location = URI.create("/categories/" + category.getId().id());
        return ResponseEntity.created(location)
                .body(CategoryMapper.mapToCategoryDto(category));
    }


    @GetMapping
    @Override
    public ResponseEntity<List<CategoryDto>> listCategories() {
        /**
         * SORU: Map leme burada CategoryController da mı olmalı? Yoksa Application layer da mı olmalı? Yada hiç bir business logic yoksa,
         * persistence layer ın out portunda db den veriyi çekerken jpa entity listesini doğrudan dto ya mı çevirmeliyim?
         * */
        List<Category> categories = categoryAppService.listCategories();
        return ResponseEntity.ok(CategoryMapper.mapToDtoList(categories));
    }

    @PutMapping("/{id}")

    @Override
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") String categoryId, @RequestBody CategoryDto dto) {
        Category updated = categoryAppService.updateCategory(ID.of(categoryId), dto);
        return ResponseEntity.ok(CategoryMapper.mapToCategoryDto(updated));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String categoryId) {
        boolean deleted = categoryAppService.deleteCategory(ID.of(categoryId));
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{categoryId}/products/{productId}")
    @Override
    public ResponseEntity<Void> addProductToCategory(@PathVariable String categoryId, @PathVariable String productId) {
        boolean successful = categoryAppService.addProductToCategory(ID.of(categoryId), ID.of(productId));
        if (successful) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
