package org.skypro.skyshop1.controller.model.search;

import java.util.UUID;

public interface Searchable {

    String getSearchTerm();
    String getContentType();
    String getObjectName();
    UUID getID();
    default String getStringRepresentation() {
        return getObjectName() + " — " + getContentType();
    }

    String texst();

    UUID getId();

    Object getName();
}
