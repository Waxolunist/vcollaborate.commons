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

import java.util.List;

public final class ListUtils {

  private ListUtils() {
  }

  /**
   * Retrieves the element after the given element in the list.
   * 
   * @return the element after {@code element} or null if there is no element.
   */
  public static final <E> E nextElement(final List<E> list, final E element) {
    return nextElement(list, element, null);
  }

  public static final <E> E nextElement(final List<E> list, final E element, final E defaultValue) {
    int nextIndex = list.indexOf(element) + 1;
    if (list.size() > nextIndex) {
      return list.get(nextIndex);
    }
    return defaultValue;
  }

  public static final <E> E prevElement(final List<E> list, final E element) {
    return prevElement(list, element, null);
  }

  public static final <E> E prevElement(final List<E> list, final E element, final E defaultValue) {
    int prevIndex = list.indexOf(element) - 1;
    if (prevIndex >= 0) {
      return list.get(prevIndex);
    }
    return defaultValue;
  }

}
