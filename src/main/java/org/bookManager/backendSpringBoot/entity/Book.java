package org.bookManager.backendSpringBoot.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Table(name="book")
public class Book {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

}
