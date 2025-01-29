package org.skypro.skyshop1.service;
import org.skypro.skyshop1.model.search.SearchResult;
import org.springframework.stereotype.Service;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public Set<SearchResult> search(String search) {
        Set<SearchResult> searchResults = storageService.getSearchableCollection().stream()
                .filter(searchlist -> searchlist.getSearchTerm().toLowerCase().replace(" ", "")
                        .contains(search.toLowerCase().replace(" ", "")))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toSet());
        return searchResults;
    }
}
