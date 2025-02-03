package org.skypro.skyshop1.model.article;
import java.util.Objects;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop1.model.search.Searchable;

public class Article implements Searchable {


    private final UUID id;
    private final String title;
    private final String texst;

    public Article(UUID id, String title, String texst) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.texst = texst;
    }


    public String getTitle() {
        return this.title;
    }

    public String getTexst() {
        return this.texst;
    }

    public String toString() {
        return title + "\n" + texst;
    }

    @Override @JsonIgnore
    public String getSearchTerm() {
        return title + texst;
    }

    @Override @JsonIgnore
    public String getObjName() {
        return this.title;
    }

    @Override @JsonIgnore
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public UUID getID() {
        return this.id;
    }


}