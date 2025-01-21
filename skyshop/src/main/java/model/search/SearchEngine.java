package org.skypro.skyshop.searchEngine;

import org.skypro.skyshop.notFoundAndSedrch.Searchable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.AbstractMap;
import java.util.stream.Collectors;

import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

public class SearchEngine {
    private Set<Searchable> searchableObjects = new TreeSet<>(new SearchableComparator());

    public void add(Searchable searchable) {
        searchableObjects.add(searchable);
    }

    public Map<String, Searchable> search(String searchTerm) {
        return searchableObjects.stream()
                .filter(obj -> obj != null && obj.getSearchTerm().contains(searchTerm))
                .collect(Collectors.toMap(Searchable::getObjectName, obj -> obj, (existing, replacement) -> existing, TreeMap::new));
    }

    public List<Searchable> findMostSuitable(String search) {
        Supplier<TreeSet<Searchable>> supplier = () -> new TreeSet<>((o1, o2) -> o1.getObjectName().compareTo(o2.getObjectName()));

        TreeSet<Searchable> suitableResults = searchableObjects.stream()
                .filter(obj -> obj != null)
                .map(obj -> {
                    String searchTerm = obj.getSearchTerm();
                    int count = 0;
                    int fromIndex = 0;

                    while ((fromIndex = searchTerm.indexOf(search, fromIndex)) != -1) {
                        count++;
                        fromIndex += search.length();
                    }

                    return new AbstractMap.SimpleEntry<>(obj, count);
                })
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.toList()))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .orElse(new ArrayList<>())
                .stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(supplier));

        return new ArrayList<>(suitableResults);
        public Set<Searchable> search(String searchTerm) {
            Set<Searchable> results = new TreeSet<>(new SearchableComparator());

            for (Searchable obj : searchableObjects) {
                if (obj != null && obj.getSearchTerm().contains(searchTerm)) {
                    results.add(obj);
                }
            }

            return results;
        }

        public Set<Searchable> findMostSuitable(String search) {
            Set<Searchable> suitableResults = new TreeSet<>(new SearchableComparator());

            int maxCount = 0;
            for (Searchable obj : searchableObjects) {
                if (obj != null) {
                    String searchTerm = obj.getSearchTerm();
                    int count = 0;
                    int fromIndex = 0;
                    while ((fromIndex = searchTerm.indexOf(search, fromIndex)) != -1) {
                        count++;
                        fromIndex += search.length();
                    }
                    if (count > maxCount) {
                        maxCount = count;
                        suitableResults.clear();
                        suitableResults.add(obj);
                    } else if (count == maxCount) {
                        suitableResults.add(obj);
                    }
                }
            }
            return suitableResults;
        }
    }
