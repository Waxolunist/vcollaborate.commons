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

package com.vcollaborate.arrays;

import java.util.Arrays;

public final class ArrayUtils {

  /**
   * Filters the given array.
   * 
   * @return array with all items fulfilling {@code predicate}.
   */
  public static final long[] filter(final long[] unfiltered, final LongPredicate predicate) {
    long[] filtered = filter(unfiltered, unfiltered.length, predicate);
    return Arrays.copyOf(filtered, filtered.length);
  }

  /**
   * The same as {@link #filter(long[], LongPredicate)} but with predefined length of the returned
   * array, thus less memory will be allocated.
   */
  public static final long[] filter(final long[] unfiltered, final int filteredLength,
      final LongPredicate predicate) {
    long[] filtered = new long[filteredLength];
    int idx = 0;
    for (long unfiltereditem : unfiltered) {
      if (predicate.apply(unfiltereditem)) {
        filtered[idx++] = unfiltereditem;
      }
    }

    return filtered;
  }

}
