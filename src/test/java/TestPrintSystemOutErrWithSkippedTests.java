/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class TestPrintSystemOutErrWithSkippedTests {

  private static void printMethodNameInStandardOutErr() {
    String msg = "Hello I am method " + Thread.currentThread().getStackTrace()[2].getMethodName();
    System.out.println(msg);
    System.err.println(msg);
  }

  @BeforeClass public static void setupClass() {
    printMethodNameInStandardOutErr();
  }

  @Before public void setupTest() {
    printMethodNameInStandardOutErr();
  }

  @After public void tearTest() {
    printMethodNameInStandardOutErr();
  }

  @AfterClass public static void tearClass() {
    printMethodNameInStandardOutErr();
  }

  @Ignore @Test public void testWithIgnore() {
    printMethodNameInStandardOutErr();
  }

  @Test public void testWithAssumeBeforePrint() {
    Assume.assumeTrue("Skip with assume", false);
    printMethodNameInStandardOutErr();
  }

  @Test public void testWithAssumeAfterPrint() {
    printMethodNameInStandardOutErr();
    Assume.assumeTrue("Skip with assume", false);
  }

  @Test public void testWithSuccess() {
    printMethodNameInStandardOutErr();
  }

}