package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lenDiff = s2.getObjectName().length() - s1.getObjectName().length();
        if (lenDiff != 0) {
            return lenDiff;
        } else {
            return s1.getObjectName().compareTo(s2.getObjectName());
        }
    }
}
