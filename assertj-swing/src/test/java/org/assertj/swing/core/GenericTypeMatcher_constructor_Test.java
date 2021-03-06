/*
 * Created on Jul 29, 2009
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2009-2013 the original author or authors.
 */
package org.assertj.swing.core;

import javax.annotation.Nonnull;
import javax.swing.JButton;

import org.junit.Test;

/**
 * Tests for {@link GenericTypeMatcher#GenericTypeMatcher(Class)}.
 * 
 * @author Alex Ruiz
 */
public class GenericTypeMatcher_constructor_Test {
  @Test(expected = NullPointerException.class)
  public void should_Throw_Error_If_Supported_Type_Is_Null() {
    new GenericTypeMatcher<JButton>(null) {
      @Override
      protected boolean isMatching(@Nonnull JButton component) {
        return true;
      }
    };
  }
}
