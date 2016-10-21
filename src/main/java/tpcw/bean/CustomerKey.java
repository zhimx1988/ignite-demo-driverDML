/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tpcw.bean;

import java.io.*;

/**
 * CustomerKey definition.
 *
 * Code generated by Apache Ignite Schema Import utility: 10/09/2016.
 */
public class CustomerKey implements Serializable {
    /** */
    private static final long serialVersionUID = 0L;

    /** Value for cId. */
    private int cId;

    /**
     * Empty constructor.
     */
    public CustomerKey() {
        // No-op.
    }

    /**
     * Full constructor.
     */
    public CustomerKey(
        int cId
    ) {
        this.cId = cId;
    }

    /**
     * Gets cId.
     *
     * @return Value for cId.
     */
    public int getCId() {
        return cId;
    }

    /**
     * Sets cId.
     *
     * @param cId New value for cId.
     */
    public void setCId(int cId) {
        this.cId = cId;
    }

    /** {@inheritDoc} */
    @Override public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof CustomerKey))
            return false;

        CustomerKey that = (CustomerKey)o;

        if (cId != that.cId)
            return false;

        return true;
    }

    /** {@inheritDoc} */
    @Override public int hashCode() {
        int res = cId;

        return res;
    }

    /** {@inheritDoc} */
    @Override public String toString() {
        return "CustomerKey [cId=" + cId +
            "]";
    }
}

