/*
 * Copyright © 2018 Martin Trummer (martin.trummer@tmtron.com)
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
package com.tmtron.enums.processor;

import org.junit.Test;

public class TestMappers4DuplicateEnums extends AnnotationProcessorTest {

    /**
     * Test if we can put the @EnumMappers annotation handles duplicate enums gracefully.
     * <p>
     * Did not work in V1.0.1. See <a href="https://github.com/tmtron/enum-mapper/issues/3">
     * issue #3 "duplicate enums in @EnumMappers should be ignored"</a>
     * </p>
     */
    @Test
    public void test() {
        assertAboutEnumsProcessing(getJfoResource("DuplicateEnums_Source.java"))
                .compilesWithoutWarnings()
                .and()
                .generatesSources(
                        getJfoResource("BoolEnum_MapperFull.java"),
                        getJfoResource("ColorEnum_MapperFull.java"));
    }

}
