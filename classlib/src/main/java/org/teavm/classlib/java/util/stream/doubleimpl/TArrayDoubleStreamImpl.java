/*
 *  Copyright 2017 Alexey Andreev.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.teavm.classlib.java.util.stream.doubleimpl;

import java.util.function.DoublePredicate;

public class TArrayDoubleStreamImpl extends TSimpleDoubleStreamImpl {
    private double[] array;
    private int index;
    private int end;
    private int size;

    public TArrayDoubleStreamImpl(double[] array, int start, int end) {
        this.array = array;
        index = start;
        this.end = end;
        size = end - start;
    }

    @Override
    public boolean next(DoublePredicate consumer) {
        while (index < end) {
            if (!consumer.test(array[index++])) {
                break;
            }
        }
        return index < end;
    }

    @Override
    protected int estimateSize() {
        return size;
    }

    @Override
    public long count() {
        return size;
    }
}
