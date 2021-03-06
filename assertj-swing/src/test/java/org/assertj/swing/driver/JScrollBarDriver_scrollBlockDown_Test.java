/*
 * Created on Feb 24, 2008
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
package org.assertj.swing.driver;

import org.junit.Test;

/**
 * Tests for {@link JScrollBarDriver#scrollBlockDown(javax.swing.JScrollBar)}.
 * 
 * @author Alex Ruiz
 */
public class JScrollBarDriver_scrollBlockDown_Test extends JScrollBarDriver_TestCase {
  @Test
  public void should_Scroll_Block_Down() {
    showWindow();
    driver.scrollBlockDown(scrollBar);
    assertThatScrollBarValueIs(40);
  }

  @Test
  public void should_Throw_Error_If_JScrollBar_Is_Disabled() {
    disableScrollBar();
    thrown.expectIllegalStateIsDisabledComponent();
    driver.scrollBlockDown(scrollBar);
  }

  @Test
  public void should_Throw_Error_If_JScrollBar_Is_Not_Showing_On_The_Screen() {
    thrown.expectIllegalStateIsNotShowingComponent();
    driver.scrollBlockDown(scrollBar);
  }
}
