/*
 ***************************************************************************************
 *  Copyright (C) 2006 EsperTech, Inc. All rights reserved.                            *
 *  http://www.espertech.com/esper                                                     *
 *  http://www.espertech.com                                                           *
 *  ---------------------------------------------------------------------------------- *
 *  The software in this package is published under the terms of the GPL license       *
 *  a copy of which has been included with this distribution in the license.txt file.  *
 ***************************************************************************************
 */
package com.espertech.esper.epl.enummethod.eval;

import com.espertech.esper.codegen.base.CodegenClassScope;
import com.espertech.esper.codegen.base.CodegenMethodScope;
import com.espertech.esper.codegen.model.expression.CodegenExpression;
import com.espertech.esper.epl.enummethod.codegen.EnumForgeCodegenParams;
import com.espertech.esper.epl.expression.core.ExprForge;
import com.espertech.esper.event.arr.ObjectArrayEventType;

public class EnumAggregateEventsForge extends EnumAggregateForge {
    public EnumAggregateEventsForge(ExprForge initialization, ExprForge innerExpression, int streamNumLambda, ObjectArrayEventType resultEventType) {
        super(initialization, innerExpression, streamNumLambda, resultEventType);
    }

    public EnumEval getEnumEvaluator() {
        return new EnumAggregateEventsForgeEval(this, initialization.getExprEvaluator(), innerExpression.getExprEvaluator());
    }

    public CodegenExpression codegen(EnumForgeCodegenParams premade, CodegenMethodScope codegenMethodScope, CodegenClassScope codegenClassScope) {
        return EnumAggregateEventsForgeEval.codegen(this, premade, codegenMethodScope, codegenClassScope);
    }
}
