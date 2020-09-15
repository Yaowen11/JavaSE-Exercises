package think.seventeen;

import se.generic.generator.Pair;
import think.fifteen.genericinterface.Generator;

import java.util.LinkedHashMap;

/**
 * @author z
 **/
public class MapData<K, V> extends LinkedHashMap<K, V> {
    public MapData(Generator<Pair<K,V>> generator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> pair = generator.next();
            put(pair.key, pair.value);
        }
    }
    public MapData(Generator<K> kGenerator, Generator<V> vGenerator, int quantity) {
        for (int i = 0; i < quantity; i++) {
            put(kGenerator.next(), vGenerator.next());
        }
    }

}
