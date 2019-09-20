package com.xgames178.XCore.Utils;

/**
 * Created by jpdante on 05/05/2017.
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class NautHashMap<KeyType, ValueType>
{
    private HashMap<KeyType, ValueType> hashMap = new HashMap<KeyType, ValueType>();

    public boolean containsKey(KeyType key)
    {
        return hashMap.containsKey(key);
    }

    public boolean containsValue(ValueType key)
    {
        return hashMap.containsValue(key);
    }

    public Set<Entry<KeyType, ValueType>> entrySet()
    {
        return hashMap.entrySet();
    }

    public Set<KeyType> keySet()
    {
        return hashMap.keySet();
    }

    public Collection<ValueType> values()
    {
        return hashMap.values();
    }

    public ValueType get(KeyType key)
    {
        return hashMap.get(key);
    }

    public ValueType remove(KeyType key)
    {
        return hashMap.remove(key);
    }

    public ValueType put(KeyType key, ValueType value)
    {
        return hashMap.put(key, value);
    }

    public void clear()
    {
        hashMap.clear();
    }

    public int size()
    {
        return hashMap.size();
    }

    public boolean isEmpty()
    {
        return hashMap.isEmpty();
    }
}

