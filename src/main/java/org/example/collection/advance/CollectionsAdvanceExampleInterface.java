package org.example.collection.advance;

import org.example.dto.Mall;
import org.example.dto.Product;
import org.example.dto.Store;

public interface CollectionsAdvanceExampleInterface {

    /**
     * Metoda ma zwrocic jeden konkretny produkt ktory jest najliczniejszy w jednym sklepie. Warunek dodatkowy: Jezeli beda dwa produkty o
     * takiej samej liczbie to nalezy rzucic wyjatek {@link org.example.exception.BootExampleException} z parametrem {@link
     * org.example.BootExampleUtils#MORE_THAN_ONE_PRODUCT_FOUND} w przypadku blednych wszystkich danych ten sam typ wyjatku z parametrem
     * {@link org.example.BootExampleUtils#NO_PRODUCT_FOUND}
     */
    Product getTheMostAvailableProductFromStore(Store store);

    /**
     * Metoda ma zwrocic jeden konkretny produkt ktory jest najliczniejszy w calym centrum handlowym. Warunek dodatkowy: Jezeli beda dwa
     * produkty o takiej samej liczbie to nalezy rzucic wyjatek {@link org.example.exception.BootExampleException} z parametrem {@link
     * org.example.BootExampleUtils#MORE_THAN_ONE_PRODUCT_FOUND} w przypadku blednych wszystkich danych ten sam typ wyjatku z parametrem
     * {@link org.example.BootExampleUtils#NO_PRODUCT_FOUND}
     */
    Product getTheMostAvailableProductFromMall(Mall mall);
}