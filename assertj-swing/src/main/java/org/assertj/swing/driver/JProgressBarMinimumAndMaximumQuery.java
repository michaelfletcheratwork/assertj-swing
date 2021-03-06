/*
 * Created on Dec 4, 2009
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
package org.assertj.swing.driver;

import static org.assertj.core.util.Preconditions.checkNotNull;
import static org.assertj.swing.edt.GuiActionRunner.execute;

import javax.annotation.Nonnull;
import javax.swing.JProgressBar;

import org.assertj.swing.annotation.RunsInEDT;
import org.assertj.swing.edt.GuiQuery;
import org.assertj.swing.util.Pair;

/**
 * Returns the minimum and maximum values of a {@code JProgressBar}. This query is executed in the event dispatch thread
 * (EDT.)
 * 
 * @author Alex Ruiz
 */
final class JProgressBarMinimumAndMaximumQuery {
  @RunsInEDT
  static @Nonnull Pair<Integer, Integer> minimumAndMaximumOf(final @Nonnull JProgressBar progressBar) {
    Pair<Integer, Integer> result = execute(new GuiQuery<Pair<Integer, Integer>>() {
      @Override
      protected Pair<Integer, Integer> executeInEDT() {
        return Pair.of(progressBar.getMinimum(), progressBar.getMaximum());
      }
    });
    return checkNotNull(result);
  }

  private JProgressBarMinimumAndMaximumQuery() {
  }
}
