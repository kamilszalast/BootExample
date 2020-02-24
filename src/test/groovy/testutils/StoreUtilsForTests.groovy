package testutils


import org.example.dto.Store
import spock.lang.Specification

class StoreUtilsForTests extends Specification {

    public static final String ZABKA = "Zabka"
    public static final String BIEDRONA = "Biedrona"
    public static final String TESCO = "Tesco"
    public static final String IKEA = "Ikea"
    public static final String CASTORAMA = "Castorama"


    private static List<String> getStoreNames() {
        return Arrays.asList(ZABKA, BIEDRONA, TESCO, IKEA, CASTORAMA) as List<String>
    }

    private static String getRandomStoreName() {
        Random random = new Random()
        List<String> storeNames = getStoreNames()
        return storeNames.get(random.nextInt(storeNames.size() - 1))
    }

    static Store createStoreWithRandomName(int productsIndex) {
        return isValidIndex(productsIndex) ? new Store(ProductUtilsForTests.getProducts(productsIndex), getRandomStoreName()) : null
    }

    static List<Store> createStoresWithRandomNames(Integer... productsIndex) {
        return Arrays.stream(productsIndex)
                .map({ index -> createStoreWithRandomName(index) })
                .collect()
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < 10
    }
}
