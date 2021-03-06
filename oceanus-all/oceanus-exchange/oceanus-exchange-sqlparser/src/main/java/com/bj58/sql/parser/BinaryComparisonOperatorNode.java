/**
 * Copyright 2011-2013 FoundationDB, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* The original from which this derives bore the following: */

/*

   Derby - Class org.apache.derby.impl.sql.compile.BinaryComparisonOperatorNode

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package com.bj58.sql.parser;

import com.bj58.sql.StandardException;
import com.bj58.sql.types.ValueClassName;

/**
 * This node is the superclass  for all binary comparison operators, such as =,
 * <>, <, etc.
 *
 */

public abstract class BinaryComparisonOperatorNode extends BinaryOperatorNode
{
    private boolean forQueryRewrite;

    /**
     * Initializer for a BinaryComparisonOperatorNode
     *
     * @param leftOperand The left operand of the comparison
     * @param rightOperand The right operand of the comparison
     * @param operator The name of the operator
     * @param methodName The name of the method to call in the generated class
     */

    public void init(Object leftOperand,
                     Object rightOperand,
                     Object operator,
                     Object methodName) {
        super.init(leftOperand, rightOperand, operator, methodName,
                   ValueClassName.DataValueDescriptor, ValueClassName.DataValueDescriptor);
    }

    /**
     * Fill this node with a deep copy of the given node.
     */
    public void copyFrom(QueryTreeNode node) throws StandardException {
        super.copyFrom(node);

        BinaryComparisonOperatorNode other = (BinaryComparisonOperatorNode)node;
        this.forQueryRewrite = other.forQueryRewrite;
    }

    /**
     * This node was generated as part of a query rewrite. Bypass the
     * normal comparability checks.
     * @param val    true if this was for a query rewrite
     */
    public void setForQueryRewrite(boolean val) {
        forQueryRewrite=val;
    }

    /**
     * Was this node generated in a query rewrite?
     *
     * @return true if it was generated in a query rewrite.
     */
    public boolean isForQueryRewrite() {
        return forQueryRewrite;
    }

}
