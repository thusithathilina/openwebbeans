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
package org.apache.webbeans.spi.plugins;

/**
 * OpenWebBeans plugin point for Web Containers.
 * Currently there is no default implementation
 * for this plugin. Each web container that wants 
 * to support OpenWebBeans, implements this plugin
 * and register it via META-INF/services/org.apache.webbeans.plugins.OpenWebBeansWebPlugin
 * @version $Rev$ $Date$
 *
 * @deprecated we don't like the sessionId in any map anymore as this changes _way_ too often
 */
public interface OpenWebBeansWebPlugin extends OpenWebBeansPlugin
{
    String currentSessionId();
}
