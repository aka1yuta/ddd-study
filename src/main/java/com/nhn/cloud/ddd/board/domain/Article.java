package com.nhn.cloud.ddd.board.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name = "article")
@SecondaryTable(
    name = "article_content",
    pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @AttributeOverrides({
        @AttributeOverride(
            name = "content",
            column = @Column(table = "article_content", name = "content")),
        @AttributeOverride(
            name = "contentType",
            column = @Column(table = "article_content", name = "content_type"))
    })
    @Embedded
    private ArticleContent content;

    protected Article() {
    }
}
