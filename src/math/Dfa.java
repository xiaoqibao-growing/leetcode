package math;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有穷自动机
 */
public class Dfa {
    private Map<Object, Object> instanceMap = new HashMap<>();

    @SuppressWarnings("unchecked")
    public void init(Collection<String> collection) {
        if (collection == null || collection.size() == 0) {
            return;
        }

        instanceMap = new HashMap<>(collection.size());
        for (String key : collection) {
            char[] keyChar = key.toCharArray();
            int length = keyChar.length;

            Map<Object, Object> currentMap = instanceMap;
            for (int i = 0; i < length; i++) {
                char c = keyChar[i];
                Map<Object, Object> wordMap = (Map<Object, Object>) currentMap.get(c);
                if (wordMap != null) {
                    currentMap = wordMap;
                } else {
                    Map<Object, Object> newMap = new HashMap<>();
                    newMap.put("isEnd", 0);
                    currentMap.put(c, newMap);
                    currentMap = newMap;
                }

                if (i == length - 1) {
                    currentMap.put("isEnd", 1);
                }
            }
        }
    }

    public Map<Object, Object> getInstanceMap() {
        return this.instanceMap;
    }

    public static void main(String[] args) {
        Dfa dfa = new Dfa();
        List<String> list = new ArrayList<>();
        list.add("日本");
        list.add("日本人");
        dfa.init(list);
        System.out.println(dfa.getInstanceMap());
    }
}
