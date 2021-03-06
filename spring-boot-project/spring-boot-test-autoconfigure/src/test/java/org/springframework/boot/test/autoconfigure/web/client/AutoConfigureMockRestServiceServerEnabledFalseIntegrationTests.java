/*
 * Copyright 2012-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.test.autoconfigure.web.client;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.MockServerRestTemplateCustomizer;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link AutoConfigureMockRestServiceServer} with {@code enabled=false}.
 *
 * @author Phillip Webb
 */
@RunWith(SpringRunner.class)
@RestClientTest
@AutoConfigureMockRestServiceServer(enabled = false)
public class AutoConfigureMockRestServiceServerEnabledFalseIntegrationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void mockServerRestTemplateCustomizerShouldNotBeRegistered() throws Exception {
		this.applicationContext.getBean(MockServerRestTemplateCustomizer.class);
	}

}
