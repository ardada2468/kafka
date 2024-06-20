/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.kafka.server.share;

import org.apache.kafka.common.Uuid;

import java.util.Objects;

public class ShareSessionKey {
    private final String groupId;
    private final Uuid memberId;

    public ShareSessionKey(String groupId, Uuid memberId) {
        this.groupId = Objects.requireNonNull(groupId);
        this.memberId = Objects.requireNonNull(memberId);
    }

    public Uuid memberId() {
        return memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, memberId);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        else if (obj == null || getClass() != obj.getClass())
            return false;
        else {
            ShareSessionKey that = (ShareSessionKey) obj;
            return groupId.equals(that.groupId) && Objects.equals(memberId, that.memberId);
        }
    }

    public String toString() {
        return "ShareSessionKey(" +
                " groupId=" + groupId +
                ", memberId=" + memberId +
                ")";
    }
}
