package com.paperspring.app;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "book")
public class Book {
    @Id
    private Integer id;
    private String title;
    private String author;
    private Integer pageCount;
}
