package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private Book book = new Book(1, "Book name", 100, "Author1");

    @Test
    public void shouldNameIfExist() {
        String text = "Book name";
        assertTrue(book.matches(text));
    }
@Test
public void shouldNameIfNotExist() {
    String text = "Book name not exist";
    assertFalse(book.matches(text));
}
    public void shouldAuthorIfExists() {
        String text = "Author1";
        assertTrue(book.matches(text));
    }

}