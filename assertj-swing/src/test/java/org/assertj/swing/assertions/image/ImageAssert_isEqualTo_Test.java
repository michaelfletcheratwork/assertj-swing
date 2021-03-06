/*
 * Created on Oct 20, 2010
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
 * Copyright @2010-2011 the original author or authors.
 */
package org.assertj.swing.assertions.image;

import static org.assertj.swing.test.awt.AwtTestData.fivePixelYellowImage;
import static org.mockito.Mockito.verify;

import java.awt.image.BufferedImage;

import org.assertj.swing.assertions.ImageAssert;
import org.assertj.swing.assertions.ImageAssertBaseTest;

/**
 * Tests for <code>{@link ImageAssert#isEqualTo(BufferedImage)}</code>.
 * 
 * @author Yvonne Wang
 */
public class ImageAssert_isEqualTo_Test extends ImageAssertBaseTest {

  private final BufferedImage expected = fivePixelYellowImage();

  @Override
  protected ImageAssert invoke_api_method() {
    return assertions.isEqualTo(expected);
  }

  @Override
  protected void verify_internal_effects() {
    verify(images).assertEqual(getInfo(assertions), getActual(assertions), expected);
  }
}
