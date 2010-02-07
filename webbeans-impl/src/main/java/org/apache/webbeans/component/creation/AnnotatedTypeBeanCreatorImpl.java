/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.webbeans.component.creation;

import org.apache.webbeans.component.ManagedBean;
import org.apache.webbeans.util.WebBeansAnnotatedTypeUtil;
import org.apache.webbeans.util.WebBeansUtil;

public class AnnotatedTypeBeanCreatorImpl<T> extends ManagedBeanCreatorImpl<T>
{

    public AnnotatedTypeBeanCreatorImpl(ManagedBean<T> managedBean)
    {
        super(managedBean);
        setMetaDataProvider(MetaDataProvider.THIRDPARTY);
    }

    /* (non-Javadoc)
     * @see org.apache.webbeans.component.creation.ManagedBeanCreatorImpl#checkCreateConditions()
     */
    @Override
    public void checkCreateConditions()
    {
        WebBeansAnnotatedTypeUtil.checkManagedBeanCondition(getAnnotatedType());
        WebBeansUtil.checkGenericType(getBean());
    }
    
    

}