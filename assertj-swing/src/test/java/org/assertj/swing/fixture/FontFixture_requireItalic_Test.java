/*
 * Created on Apr 16, 2008
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
 * Copyright @2008-2013 the original author or authors.
 */
package org.assertj.swing.fixture;

import org.junit.Test;

/**
 * Tests for {@link FontFixture#requireItalic()}.
 * 
 * @author Yvonne Wang
 * @author Alex Ruiz
 */
public class FontFixture_requireItalic_Test extends FontFixture_TestCase {
  @Test
  public void should_Pass_If_Font_Is_Italic() {
    FontFixture fixture = new FontFixture(italicFont());
    fixture.requireItalic();
  }

  @Test
  public void should_Fail_If_Font_Is_Not_Italic() {
    thrown.expect(AssertionError.class);
    thrown.expectMessage("[italic] expected:<[tru]e> but was:<[fals]e>");
    fixture().requireItalic();
  }

  @Test
  public void should_Fail_Showing_Description_If_Font_Is_Not_Italic() {
    thrown.expect(AssertionError.class);
    thrown.expectMessage("[test - italic] expected:<[tru]e> but was:<[fals]e>");
    FontFixture fixture = new FontFixture(font(), "test");
    fixture.requireItalic();
  }
}
