package org.skypro.skyshop1.controller.model.article;
import java.util.UUID;
import org.skypro.skyshop1.controller.model.search.Searchable;


public class Article implements Searchable {

    private UUID id;
    private String title;
    private String texst;

    public Article(UUID id, String title, String texst) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.texst = texst;
    }


    @Override
    public String getSearchTerm() {
        return title + " " + texst;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getObjectName() {
        return title;
    }

    @Override
    public UUID getID() {
        return this.id;
    }

    @Override
    public String texst() {
        return this.texst;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public Object getName() {
        return this.getName();
    }

    public String getTitle() {

        return this.title;
    }

    public String getTexst() {
        return this.texst();
    }

}


