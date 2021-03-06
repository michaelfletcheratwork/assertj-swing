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
 * Tests for {@link JComboBoxDriver#requireNoSelection(javax.swing.JComboBox)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JComboBoxDriver_requireNoSelection_Test extends JComboBoxDriver_TestCase {
  @Test
  public void should_Pass_If_JComboBox_Does_Not_Have_Selection() {
    clearSelection();
    driver.requireNoSelection(comboBox);
  }

  @Test
  public void should_Fail_If_JComboBox_Has_Selection() {
    selectFirstItem();
    thrown.expectAssertionError("property:'selectedIndex'");
    thrown.expectMessageToContain("Expecting no selection, but found:<'first'>");
    driver.requireNoSelection(comboBox);
  }
}
