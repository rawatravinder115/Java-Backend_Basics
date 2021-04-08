package com.example.DemoJPA4.DemoJPA4.Repository;

import com.example.DemoJPA4.DemoJPA4.Models.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {
}
