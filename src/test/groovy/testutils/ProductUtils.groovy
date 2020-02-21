package testutils

import org.example.dto.Product

class ProductUtils {

    public static final String CHOCOLATE = "Chocolate"
    public static final String JUICE = "Juice"
    public static final String VIDEO_GAME = "Video game"
    public static final String BIKE = "Bike"
    public static final String CAR = "Car"
    public static final String COMPUTER = "Computer"
    public static final String MIRROR = "Mirror"
    public static final String BOOK = "Book"
    public static final String KNIFE = "Knife"
    public static final String FLOWER = "Flower"

    static List<Product> getProducts(int index) {
        return isValidIndex(index) ? getPreparedListOfProductLists().get(index) : Collections.emptyList() as List<Product>
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index <= getPreparedListOfProductLists().size()
    }

    private static List<List<Product>> getPreparedListOfProductLists() {
        List<List<Product>> listOfProductLists = new ArrayList<>()
        listOfProductLists.add(createProducts(CHOCOLATE, BIKE, MIRROR, BOOK, CAR, KNIFE, VIDEO_GAME, CHOCOLATE, JUICE, VIDEO_GAME, BIKE, CAR, COMPUTER, CAR, BIKE, MIRROR, KNIFE, VIDEO_GAME, VIDEO_GAME))
        listOfProductLists.add(createProducts(VIDEO_GAME, null, CAR, BOOK, KNIFE, MIRROR, CAR, JUICE, BIKE, null, JUICE, CHOCOLATE, COMPUTER, null, BIKE, MIRROR, FLOWER))
        listOfProductLists.add(createProducts(FLOWER, BIKE, CAR, COMPUTER, JUICE, VIDEO_GAME, KNIFE, MIRROR, FLOWER, COMPUTER, BOOK, KNIFE, MIRROR, BOOK, CAR, COMPUTER))
        listOfProductLists.add(createProducts(FLOWER, MIRROR, KNIFE, CHOCOLATE, KNIFE, COMPUTER, CAR, BIKE, BOOK, JUICE, BIKE, CAR, COMPUTER, MIRROR, BIKE, CAR, COMPUTER, BIKE, CHOCOLATE))
        listOfProductLists.add(createProducts(BOOK, MIRROR, VIDEO_GAME, FLOWER, BOOK, COMPUTER, MIRROR, BOOK, BOOK, FLOWER, CAR, COMPUTER, MIRROR, CAR, FLOWER))
        listOfProductLists.add(createProducts(CAR, MIRROR, VIDEO_GAME, CHOCOLATE, BIKE, CAR, COMPUTER, MIRROR, BOOK, CAR, BIKE, COMPUTER, CAR, CHOCOLATE, JUICE, VIDEO_GAME))
        listOfProductLists.add(createProducts(KNIFE, FLOWER, KNIFE, CAR, COMPUTER, KNIFE, CHOCOLATE, BIKE, CAR, MIRROR, BOOK, COMPUTER, CAR, KNIFE, VIDEO_GAME, JUICE, CHOCOLATE, BIKE))
        listOfProductLists.add(createProducts(FLOWER, FLOWER, MIRROR, MIRROR, BIKE, CAR, COMPUTER, MIRROR, BOOK, KNIFE, CAR, COMPUTER))
        listOfProductLists.add(createProducts(MIRROR, BOOK, COMPUTER, KNIFE, CAR, KNIFE, VIDEO_GAME, CHOCOLATE, BIKE, CAR, BIKE, COMPUTER, VIDEO_GAME, BIKE))
        listOfProductLists.add(createProducts(CHOCOLATE, FLOWER, COMPUTER, BIKE, CHOCOLATE, MIRROR, CAR, MIRROR, BOOK, FLOWER, FLOWER, FLOWER))
        return listOfProductLists
    }

    private static List<Product> createProducts(String... names) {
        return Arrays.stream(names)
                .map({ name -> createSingleProduct(name) })
                .collect()
    }

    static Product createSingleProduct(String name) {
        return Objects.nonNull(name) ? new Product(name) : null
    }
}
