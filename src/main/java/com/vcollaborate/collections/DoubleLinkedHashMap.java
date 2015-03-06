/*
 * Copyright (C) 2012-2015 Christian Sterzl <christian.sterzl@gmail.com>
 *
 * This file is part of V-Collaborate Commons.
 *
 * V-Collaborate Commons is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * V-Collaborate Commons is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with V-Collaborate Commons.  If not, see <http://www.gnu.org/licenses/>.
 */
        
package com.vcollaborate.collections;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Ordered HashMap which can be traversed back and forth.
 * <p>
 * This methods are provided additional to the default Map methods:
 * <ul>
 * <li>{@link DoubleLinkedHashMap#getFirst()}
 * <li>{@link DoubleLinkedHashMap#getLast()}
 * <li>{@link DoubleLinkedHashMap#nextKey(Object)}
 * <li>{@link DoubleLinkedHashMap#prevKey(Object)}
 * </ul>
 *
 * @param <K>
 *          the type of keys maintained by this map
 * @param <V>
 *          the type of mapped values
 *
 * @author Christian Sterzl
 * @since 1.0
 */
public class DoubleLinkedHashMap<K, V> implements Map<K, V> {

  private LinkedList<K> keyList = new LinkedList<K>();

  private LinkedHashMap<K, V> backingMap = new LinkedHashMap<K, V>();

  /**
   * {@inheritDoc}
   */
  @Override
  public V put(final K key, final V value) {
    this.keyList.add(key);
    return this.backingMap.put(key, value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public V remove(final Object key) {
    this.keyList.remove(key);
    return this.backingMap.remove(key);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void putAll(final Map<? extends K, ? extends V> m) {
    for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
      this.put(entry.getKey(), entry.getValue());
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void clear() {
    this.keyList.clear();
    this.backingMap.clear();
  }

  /**
   * Traverse once forward.
   *
   * @param key
   *          the key to start traversing
   * @return the next key or null if key is the last
   */
  public K nextKey(final K key) {
    return ListUtils.nextElement(this.keyList, key);
  }

  /**
   * Traverse once backward.
   *
   * @param key
   *          the key to start traversing
   * @return the previous key or null if key is the first
   */
  public K prevKey(final K key) {
    return ListUtils.prevElement(this.keyList, key);
  }

  /**
   *
   * @return the first inserted key or null if this list is empty
   *
   * @see LinkedList#getFirst()
   */
  public K getFirst() {
    return keyList.getFirst();
  }

  /**
   *
   * @return the last inserted key or null if this list is empty
   *
   * @see LinkedList#getLast()
   */
  public K getLast() {
    return keyList.getLast();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int size() {
    return this.backingMap.size();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isEmpty() {
    return this.backingMap.isEmpty();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean containsKey(final Object key) {
    return this.backingMap.containsKey(key);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean containsValue(final Object value) {
    return this.backingMap.containsValue(value);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public V get(final Object key) {
    return this.backingMap.get(key);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<K> keySet() {
    return this.backingMap.keySet();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<V> values() {
    return this.backingMap.values();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<java.util.Map.Entry<K, V>> entrySet() {
    return this.backingMap.entrySet();
  }

  /**
   * 
   * @param index
   *          index of the key
   * @return the key at the specified position
   * @see LinkedList#get(int)
   */
  public K get(final int index) {
    return this.keyList.get(index);
  }

  /**
   * 
   * @param key
   *          a key of this map
   * @return the index this key is set
   * @see LinkedList#indexOf(Object)
   */
  public int indexOf(final Object key) {
    return this.keyList.indexOf(key);
  }

}
