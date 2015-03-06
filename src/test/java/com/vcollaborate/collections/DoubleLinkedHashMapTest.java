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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author Christian Sterzl
 * @since 1.0
 *
 */
public class DoubleLinkedHashMapTest {

  private DoubleLinkedHashMap<String, String> dlhm5;
  private DoubleLinkedHashMap<String, String> emptydlhm;

  private static final int POPULATED_MAPSIZE = 5;

  /**
   * Set up a populated {@link DoubleLinkedHashMap} and an empty {@link DoubleLinkedHashMap}.
   */
  @Before
  public void setUp() {
    dlhm5 = new DoubleLinkedHashMap<String, String>();
    dlhm5.put("key1", "value1");
    dlhm5.put("key2", "value2");
    dlhm5.put("key3", "value3");
    dlhm5.put("key4", "value4");
    dlhm5.put("key5", "value5");
    emptydlhm = new DoubleLinkedHashMap<String, String>();
  }

  // private class MockedClass {
  // public void method1(double d) {}
  // }
  //
  // @Test
  // public final void testMockito() {
  // MockedClass d = mock(MockedClass.class);
  // d.method1(3953.28);
  // verify(d, times(1)).method1(2d);
  // }

  /**
   * Test method for
   * {@link ch.sympany.util.DoubleLinkedHashMap#put(java.lang.Object, java.lang.Object)}.
   */
  @Test
  public final void testPut() {
    emptydlhm.put("key", "value");
    assertEquals(emptydlhm.get("key"), "value");

    dlhm5.put("key1", "newvalue1");
    assertEquals(dlhm5.get("key1"), "newvalue1");
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#remove(java.lang.Object)}.
   */
  @Test
  public final void testRemove() {
    dlhm5.remove("key1");
    assertNull(dlhm5.get("key1"));

    // No exception
    emptydlhm.remove("key1");
    assertTrue(true);
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#putAll(java.util.Map)}.
   */
  @Test
  public final void testPutAll() {
    emptydlhm.putAll(dlhm5);
    assertEquals(emptydlhm.get("key1"), "value1");
    assertEquals(emptydlhm.get("key2"), "value2");
    assertEquals(emptydlhm.get("key3"), "value3");
    assertEquals(emptydlhm.get("key4"), "value4");
    assertEquals(emptydlhm.get("key5"), "value5");
    assertEquals(emptydlhm.size(), dlhm5.size());
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#clear()}.
   */
  @Test
  public final void testClear() {
    assertEquals(dlhm5.size(), POPULATED_MAPSIZE);
    dlhm5.clear();
    assertEquals(dlhm5.size(), 0);
    assertNull(dlhm5.get("key1"));
    assertNull(dlhm5.get("key2"));
    assertNull(dlhm5.get("key3"));
    assertNull(dlhm5.get("key4"));
    assertNull(dlhm5.get("key5"));

    assertEquals(emptydlhm.size(), 0);
    emptydlhm.clear();
    assertEquals(emptydlhm.size(), 0);
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#nextKey(java.lang.Object)}.
   */
  @Test
  public final void testNextKey() {
    assertEquals(dlhm5.nextKey("key1"), "key2");
    assertNull(dlhm5.nextKey("key5"));

    assertNull(emptydlhm.nextKey("key1"));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#prevKey(java.lang.Object)}.
   */
  @Test
  public final void testPrevKey() {
    assertEquals("key4", dlhm5.prevKey("key5"));
    assertNull(dlhm5.prevKey("key1"));
    assertNull(emptydlhm.prevKey("key1"));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#getFirst()}.
   */
  @Test
  public final void testGetFirst() {
    assertEquals(dlhm5.getFirst(), "key1");
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#getFirst()}.
   */
  @Test(expected = NoSuchElementException.class)
  public final void testGetFirstFailed() {
    emptydlhm.getFirst();
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#getLast()}.
   */
  @Test
  public final void testGetLast() {
    assertEquals(dlhm5.getLast(), "key5");
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#getLast()}.
   */
  @Test(expected = NoSuchElementException.class)
  public final void testGetLastFailed() {
    emptydlhm.getLast();
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#size()}.
   */
  @Test
  public final void testSize() {
    assertEquals(dlhm5.size(), POPULATED_MAPSIZE);
    assertEquals(emptydlhm.size(), 0);
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#isEmpty()}.
   */
  @Test
  public final void testIsEmpty() {
    assertTrue(emptydlhm.isEmpty());
    assertFalse(dlhm5.isEmpty());
    dlhm5.clear();
    assertTrue(dlhm5.isEmpty());
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#containsKey(java.lang.Object)}.
   */
  @Test
  public final void testContainsKey() {
    assertTrue(dlhm5.containsKey("key1"));
    assertTrue(dlhm5.containsKey("key2"));
    assertTrue(dlhm5.containsKey("key3"));
    assertTrue(dlhm5.containsKey("key4"));
    assertTrue(dlhm5.containsKey("key5"));
    assertFalse(dlhm5.containsKey("key6"));
    assertFalse(emptydlhm.containsKey("key1"));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#containsValue(java.lang.Object)}.
   */
  @Test
  public final void testContainsValue() {
    assertTrue(dlhm5.containsValue("value1"));
    assertTrue(dlhm5.containsValue("value2"));
    assertTrue(dlhm5.containsValue("value3"));
    assertTrue(dlhm5.containsValue("value4"));
    assertTrue(dlhm5.containsValue("value5"));
    assertFalse(dlhm5.containsValue("value6"));
    assertFalse(emptydlhm.containsValue("value1"));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#get(java.lang.Object)}.
   */
  @Test
  public final void testGet() {
    assertEquals(dlhm5.get("key1"), "value1");
    assertEquals(dlhm5.get("key2"), "value2");
    assertNull(dlhm5.get("key6"));
    assertNull(emptydlhm.get("key1"));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#keySet()}.
   */
  @Test
  public final void testKeySet() {
    Set<String> emptyKeys = emptydlhm.keySet();
    assertEquals(emptyKeys.size(), 0);
    assertArrayEquals(new String[] {}, emptyKeys.toArray(new String[] {}));

    Set<String> dlhm5Keys = dlhm5.keySet();
    assertEquals(dlhm5Keys.size(), POPULATED_MAPSIZE);
    assertArrayEquals(new String[] { "key1", "key2", "key3", "key4", "key5" },
        dlhm5Keys.toArray(new String[] {}));

  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#values()}.
   */
  @Test
  public final void testValues() {
    Collection<String> emptyValues = emptydlhm.values();
    assertEquals(emptyValues.size(), 0);
    assertArrayEquals(new String[] {}, emptyValues.toArray(new String[] {}));

    Collection<String> dlhm5Values = dlhm5.values();
    assertEquals(dlhm5Values.size(), POPULATED_MAPSIZE);
    assertArrayEquals(new String[] { "value1", "value2", "value3", "value4", "value5" },
        dlhm5Values.toArray(new String[] {}));
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#entrySet()}.
   */
  @Test
  public final void testEntrySet() {
    Set<Map.Entry<String, String>> emptyEntrySet = emptydlhm.entrySet();
    assertEquals(emptyEntrySet.size(), 0);

    Set<Map.Entry<String, String>> dlhm5EntrySet = dlhm5.entrySet();
    assertEquals(dlhm5EntrySet.size(), POPULATED_MAPSIZE);

    // Is order right
    int count = 1;
    for (Map.Entry<String, String> entry : dlhm5EntrySet) {
      assertEquals(entry.getKey(), "key" + count++);
    }

    assertEquals(count, POPULATED_MAPSIZE + 1);
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#get(int)}.
   */
  @Test
  public final void testGetAt() {
    try {
      emptydlhm.get(0);
      fail();
    } catch (IndexOutOfBoundsException e) {
      assertTrue(true);
    }

    assertEquals(dlhm5.get(0), "key1");
    assertEquals(dlhm5.get(1), "key2");
  }

  /**
   * Test method for {@link ch.sympany.util.DoubleLinkedHashMap#indexOf(Object)}.
   */
  @Test
  public final void testIndexOf() {
    assertEquals(emptydlhm.indexOf("key"), -1);

    assertEquals(dlhm5.indexOf("key1"), 0);
    assertEquals(dlhm5.indexOf("key2"), 1);
    assertEquals(dlhm5.indexOf("nokey"), -1);
  }
}
