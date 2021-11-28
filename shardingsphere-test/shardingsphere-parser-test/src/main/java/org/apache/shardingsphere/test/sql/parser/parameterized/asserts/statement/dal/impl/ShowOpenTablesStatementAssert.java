/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.test.sql.parser.parameterized.asserts.statement.dal.impl;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.shardingsphere.sql.parser.sql.dialect.statement.mysql.dal.MySQLShowOpenTablesStatement;
import org.apache.shardingsphere.test.sql.parser.parameterized.asserts.SQLCaseAssertContext;
import org.apache.shardingsphere.test.sql.parser.parameterized.asserts.segment.SQLSegmentAssert;
import org.apache.shardingsphere.test.sql.parser.parameterized.asserts.segment.schema.SchemaAssert;
import org.apache.shardingsphere.test.sql.parser.parameterized.asserts.segment.show.ShowFilterAssert;
import org.apache.shardingsphere.test.sql.parser.parameterized.jaxb.cases.domain.statement.dal.ShowOpenTablesStatementTestCase;

/**
 * Show open tables statement assert.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ShowOpenTablesStatementAssert {
    
    /**
     * Assert show open tables statement is correct with expected show procedure code statement test case.
     *
     * @param assertContext assert context
     * @param actual actual show open tables statement
     * @param expected expected show open tables statement test case
     */
    public static void assertIs(final SQLCaseAssertContext assertContext, final MySQLShowOpenTablesStatement actual, final ShowOpenTablesStatementTestCase expected) {
        if (actual.getFromSchema().isPresent()) {
            SchemaAssert.assertIs(assertContext, actual.getFromSchema().get().getSchema(), expected.getFromSchema().getSchema());
            SQLSegmentAssert.assertIs(assertContext, actual.getFromSchema().get(), expected.getFromSchema());
        }
        if (actual.getFilter().isPresent()) {
            ShowFilterAssert.assertIs(assertContext, actual.getFilter().get(), expected.getFilter());
        }
    }
}
