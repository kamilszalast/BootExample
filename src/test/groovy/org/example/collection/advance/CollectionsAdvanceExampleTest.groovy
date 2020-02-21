package org.example.collection.advance

import org.example.BootExampleUtils
import org.example.dto.Mall
import org.example.dto.Store
import org.example.exception.BootExampleException
import spock.lang.Specification
import spock.lang.Unroll
import testutils.ProductUtils
import testutils.StoreUtils

class CollectionsAdvanceExampleTest extends Specification {

    CollectionsAdvanceExample sut = []

    @Unroll
    def "Method getTheMostAvailableProductFromStore should return #expected and no thrown exception"() {

        when:
        Store store = StoreUtils.createStoreWithRandomName(productIndex)
        def result = sut.getTheMostAvailableProductFromStore(store)

        then:
        noExceptionThrown()
        result == expected

        where:
        productIndex | expected
        0            | ProductUtils.createSingleProduct(ProductUtils.VIDEO_GAME)
        2            | ProductUtils.createSingleProduct(ProductUtils.COMPUTER)
        3            | ProductUtils.createSingleProduct(ProductUtils.BIKE)
        4            | ProductUtils.createSingleProduct(ProductUtils.BOOK)
        5            | ProductUtils.createSingleProduct(ProductUtils.CAR)
        6            | ProductUtils.createSingleProduct(ProductUtils.KNIFE)
        7            | ProductUtils.createSingleProduct(ProductUtils.MIRROR)
        8            | ProductUtils.createSingleProduct(ProductUtils.BIKE)
        9            | ProductUtils.createSingleProduct(ProductUtils.FLOWER)
    }

    @Unroll
    def "Method getTheMostAvailableProductFromStore should thrown BootExampleException with message: #expectExceptionMessage"() {

        when:
        Store store = StoreUtils.createStoreWithRandomName(productIndex)
        sut.getTheMostAvailableProductFromStore(store)

        then:
        def ex = thrown(BootExampleException)
        ex.getMessage() == expectExceptionMessage

        where:
        productIndex | expectExceptionMessage
        -1           | BootExampleUtils.NO_PRODUCT_FOUND
        1            | BootExampleUtils.MORE_THAN_ONE_PRODUCT_FOUND
    }

    @Unroll
    def "Method getTheMostAvailableProductFromMall should return #expected and no thrown exception"() {

        when:
        List<Store> stores = StoreUtils.createStoresWithRandomNames(productIndexs as Integer[])
        Mall mall = new Mall(stores)
        def result = sut.getTheMostAvailableProductFromMall(mall)

        then:
        noExceptionThrown()
        result == expected

        where:
        productIndexs                  | expected
        [3]                            | ProductUtils.createSingleProduct(ProductUtils.BIKE)
        [2, 3]                         | ProductUtils.createSingleProduct(ProductUtils.COMPUTER)
        [0, 1, 5, 2]                   | ProductUtils.createSingleProduct(ProductUtils.CAR)
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | ProductUtils.createSingleProduct(ProductUtils.CAR)
    }

    @Unroll
    def "Method getTheMostAvailableProductFromMall should thrown BootExampleException with message: #expectExceptionMessage"() {

        when:
        List<Store> stores = StoreUtils.createStoresWithRandomNames(productIndexs as Integer[])
        Mall mall = new Mall(stores)
        sut.getTheMostAvailableProductFromMall(mall)

        then:
        def ex = thrown(BootExampleException)
        ex.getMessage() == expectExceptionMessage

        where:
        productIndexs | expectExceptionMessage
        [-1]          | BootExampleUtils.NO_PRODUCT_FOUND
        [8, 9]        | BootExampleUtils.MORE_THAN_ONE_PRODUCT_FOUND
    }
}
