package org.example.collection.advance

import org.example.BootExampleUtils
import org.example.dto.Mall
import org.example.dto.Store
import org.example.exception.BootExampleException
import spock.lang.Specification
import spock.lang.Unroll
import testutils.ProductUtilsForTests
import testutils.StoreUtilsForTests

class CollectionsAdvanceExampleTest extends Specification {

    CollectionsAdvanceExample sut = []

    @Unroll
    def "Method getTheMostAvailableProductFromStore should return #expected and no thrown exception"() {

        when:
        Store store = StoreUtilsForTests.createStoreWithRandomName(productIndex)
        def result = sut.getTheMostAvailableProductFromStore(store)

        then:
        noExceptionThrown()
        result == expected

        where:
        productIndex | expected
        0            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.VIDEO_GAME)
        2            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.COMPUTER)
        3            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.BIKE)
        4            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.BOOK)
        5            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.CAR)
        6            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.KNIFE)
        7            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.MIRROR)
        8            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.BIKE)
        9            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.FLOWER)
    }

    @Unroll
    def "Method getTheMostAvailableProductFromStore should thrown BootExampleException with message: #expectExceptionMessage"() {

        when:
        Store store = StoreUtilsForTests.createStoreWithRandomName(productIndex)
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
        List<Store> stores = StoreUtilsForTests.createStoresWithRandomNames(productIndexs as Integer[])
        Mall mall = new Mall(stores)
        def result = sut.getTheMostAvailableProductFromMall(mall)

        then:
        noExceptionThrown()
        result == expected

        where:
        productIndexs                  | expected
        [3]                            | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.BIKE)
        [2, 3]                         | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.COMPUTER)
        [0, 1, 5, 2]                   | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.CAR)
        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] | ProductUtilsForTests.createSingleProduct(ProductUtilsForTests.MIRROR)
    }

    @Unroll
    def "Method getTheMostAvailableProductFromMall should thrown BootExampleException with message: #expectExceptionMessage"() {

        when:
        List<Store> stores = StoreUtilsForTests.createStoresWithRandomNames(productIndexs as Integer[])
        Mall mall = new Mall(stores)
        sut.getTheMostAvailableProductFromMall(mall)

        then:
        def ex = thrown(BootExampleException)
        ex.getMessage() == expectExceptionMessage

        where:
        productIndexs               | expectExceptionMessage
        [-1]                        | BootExampleUtils.NO_PRODUCT_FOUND
        [0, 1, 2, 3, 4, 5, 6, 7, 8] | BootExampleUtils.MORE_THAN_ONE_PRODUCT_FOUND
    }
}
