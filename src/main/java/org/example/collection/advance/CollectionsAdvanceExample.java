package org.example.collection.advance;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.example.BootExampleUtils;
import org.example.dto.Mall;
import org.example.dto.Product;
import org.example.dto.Store;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsAdvanceExample implements CollectionsAdvanceExampleInterface {

    @Override
    public Product getTheMostAvailableProductFromStore(Store store) {
            return store.getProducts().stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .get();


    }

    @Override
    public Product getTheMostAvailableProductFromMall(Mall mall) {
        return null;
    }
}
