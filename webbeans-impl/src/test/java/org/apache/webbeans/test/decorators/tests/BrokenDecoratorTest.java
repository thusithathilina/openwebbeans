/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.test.decorators.tests;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.webbeans.exception.WebBeansConfigurationException;
import org.apache.webbeans.test.AbstractUnitTest;
import org.apache.webbeans.test.decorators.broken.BrokenAlternative;
import org.apache.webbeans.test.decorators.broken.FinalMethodDecoratedBean;
import org.apache.webbeans.test.decorators.broken.SomeBrokenDecorated;
import org.apache.webbeans.test.decorators.broken.BrokenName;
import org.apache.webbeans.test.decorators.broken.BrokenScope;
import org.apache.webbeans.test.decorators.broken.ValidDecorator;

import org.junit.Assert;
import org.junit.Test;

public class BrokenDecoratorTest extends AbstractUnitTest
{
    public static final String PACKAGE_NAME = BrokenDecoratorTest.class.getPackage().getName();

    @Test
    public void testWarnings()
    {
        Collection<Class<?>> classes = new ArrayList<Class<?>>();
        classes.add(SomeBrokenDecorated.class);
        classes.add(BrokenScope.class);
        classes.add(BrokenAlternative.class);
        classes.add(BrokenName.class);
        
        Collection<String> xmls = new ArrayList<String>();
        xmls.add(getXmlPath(PACKAGE_NAME, "BrokenDecoratorTest"));

        startContainer(classes, xmls);



        shutDownContainer();
    }

    @Test(expected = WebBeansConfigurationException.class)
    public void testDecoratingFinalMethod() throws Exception
    {
        addDecorator(ValidDecorator.class);

        startContainer(FinalMethodDecoratedBean.class);

        Assert.fail("this point should not get reached because we had a final method decorated");
    }
}
