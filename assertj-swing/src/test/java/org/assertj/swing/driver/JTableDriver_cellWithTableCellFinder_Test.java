/*
 * Created on Feb 25, 2008
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.data.TableCell.row;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.swing.data.TableCell;
import org.assertj.swing.data.TableCellFinder;
import org.junit.Test;

/**
 * Tests for {@link JTableDriver#cell(javax.swing.JTable, org.assertj.swing.data.TableCellFinder)}.
 * 
 * @author Alex Ruiz
 * @author Yvonne Wang
 */
public class JTableDriver_cellWithTableCellFinder_Test extends JTableDriver_TestCase {
  private TableCellFinder cellFinder;

  @Override
  void extraSetUp() {
    cellFinder = mock(TableCellFinder.class);
  }

  @Test
  public void should_Use_TableCellFinder_To_Find_A_Cell() {
    TableCell cell = row(0).column(0);
    when(cellFinder.findCell(table, driver.cellReader())).thenReturn(cell);
    TableCell found = driver.cell(table, cellFinder);
    assertThat(found).isSameAs(cell);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void should_Throw_Error_If_Indices_In_Found_Cell_Are_Out_Of_Bounds() {
    TableCell cell = row(-1).column(0);
    when(cellFinder.findCell(table, driver.cellReader())).thenReturn(cell);
    driver.cell(table, cellFinder);
  }
}
