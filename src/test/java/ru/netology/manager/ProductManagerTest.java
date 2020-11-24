package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book book1 = new Book(1, "Book name", 100, "Author1");
    private Book book2 = new Book(2, "Book name", 200, "Author2");
    private Book book3 = new Book(3, "Third book", 300, "Author3");
    private Smartphone smartphone1 = new Smartphone(1, "Smartphone name", 100, "Manufacturer1");
    private Smartphone smartphone2 = new Smartphone(2, "Smartphone name", 200, "Manufacturer2");
    private Smartphone smartphone3 = new Smartphone(3, "Smartphone3", 300, "Manufacturer3");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test
    void shouldFindBookByAuthorIfExist() {
        String text = "Author1";

        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBookByNameIfExistTwoProduct() {
        String text = "Book name";

        Product[] expected = new Product[]{book1, book2};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookIfNotExist() {
        String text = "Not exist";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneIfExistOneProduct() {
        String text = "Smartphone3";

        Product[] expected = new Product[]{smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphoneIfExistTwoProduct() {
        String text = "Manufacturer2";

        Product[] expected = new Product[]{smartphone2, smartphone3};
        Product[] actual = manager.searchBy(text);
        assertArrayEquals(expected, actual);
    }

}