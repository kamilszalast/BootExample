package org.example.collection.advance


import org.example.dto.Mall
import org.example.dto.Product
import org.example.dto.Store
import spock.lang.Specification
import spock.lang.Unroll
import testutils.ProductUtils
import testutils.StoreUtils

class CollectionsAdvanceExampleTest extends Specification {

    CollectionsAdvanceExample sut = []

    @Unroll
    def "getTheMostAvailableProduct"() {

        when:
        List<Store> stores = StoreUtils.createStoresWithRandomNames(productIndexs as Integer[])
        Mall mall = createMall(stores)
        def result = sut.getTheMostAvailableProductFromMall(mall)

        then:
        result == expected

        where:
        productIndexs      | expected
        [0]                | ProductUtils.createSingleProduct(ProductUtils.VIDEO_GAME)
        [-1]               | ProductUtils.createSingleProduct(ProductUtils.VIDEO_GAME)
        [1, 2]             | ProductUtils.createSingleProduct(ProductUtils.FLOWER)
        [0, 1, 5, 2, 3, 7] | ProductUtils.createSingleProduct(ProductUtils.CAR)
        [6, 9, 8]          | ProductUtils.createSingleProduct(ProductUtils.BIKE)
    }


    Store createStore(List<Product> products, String storeName) {
        return new Store(products, storeName)
    }

    Mall createMall(List<Store> stores) {
        return new Mall(stores)
    }
}
