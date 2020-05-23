package com.example.springbootJunitMockito.repository;

import com.example.springbootJunitMockito.model.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WidgetRepository extends CrudRepository<Widget,Long> {
    @Query(value = "SELECT w FROM Widget w WHERE w.name LIKE ?1")
    List<Widget> findWidgetsWithNameLike(String name);
}
