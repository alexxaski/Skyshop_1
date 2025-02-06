package org.skypro.skyshop1.test;

import org.skypro.skyshop1.model.search.Searchable;
import org.skypro.skyshop1.service.SearchService;
import org.skypro.skyshop1.service.StorageService;
import org.testng.annotations.Test;
import org.skypro.skyshop1.exception.NoSuchProductException;
import org.skypro.skyshop1.model.product.SimpleProduct;
import org.skypro.skyshop1.model.search.SearchResult;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SearchServiceTest {



        @Test
        public void testSearch_NoObjectsInStorageService() {
            StorageService storageService = Mockito.mock(StorageService.class);
            when(storageService.getSearchableCollection()).thenReturn(new HashSet<>());

            SearchService searchService = new SearchService(storageService);
            Set<SearchResult> searchResults = searchService.search("Творог");

            assertEquals(0, searchResults.size());
        }

        @Test
        public void testSearch_NoMatchingObjectsInStorageService() {
            StorageService storageService = Mockito.mock(StorageService.class);
            Set<SimpleProduct> products = new HashSet<>();
            products.add(new SimpleProduct(UUID.randomUUID(), "Сметана", 100));

            // Преобразуем Set<SimpleProduct> в Set<Searchable>
            Set<Searchable> searchableProducts = new HashSet<>(products);
            when(storageService.getSearchableCollection()).thenReturn(searchableProducts);

            SearchService searchService = new SearchService(storageService);
            Set<SearchResult> searchResults = searchService.search("Творог");

            assertEquals(0, searchResults.size());
        }

        @Test
        public void testSearch_MatchingObjectInStorageService() {
            StorageService storageService = Mockito.mock(StorageService.class);
            Set<SimpleProduct> products = new HashSet<>();
            products.add(new SimpleProduct(UUID.randomUUID(), "Творог", 120));


            Set<Searchable> searchableProducts = new HashSet<>(products);
            when(storageService.getSearchableCollection()).thenReturn(searchableProducts);

            SearchService searchService = new SearchService(storageService);
            Set<SearchResult> searchResults = searchService.search("Творог");

            assertEquals(1, searchResults.size());

        }

        @Test
        public void testSearch_ExceptionHandling() {
            SearchService searchService = new SearchService(new MockStorageService());

            String searchTerm = "NonExistentTerm";
            Set<SearchResult> searchResults = searchService.search(searchTerm);

            assertTrue(searchResults.isEmpty(), "Search result should be empty for non-existent term");
        }

    private static class MockStorageService extends StorageService {
        @Override
        public Set<Searchable> getSearchableCollection() {

            return new HashSet<>();
        }
    }
}
