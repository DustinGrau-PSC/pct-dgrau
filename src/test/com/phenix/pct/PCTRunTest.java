/**
 * Copyright 2005-2023 Riverside Software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.phenix.pct;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.taskdefs.condition.Os;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Class for testing PCTRun task
 * 
 * @author <a href="mailto:justus_phenix@users.sourceforge.net">Gilles QUERRET </a>
 */
public class PCTRunTest extends BuildFileTestNg {

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test1() {
        configureProject("PCTRun/test1/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test2() {
        configureProject("PCTRun/test2/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test3() {
        configureProject("PCTRun/test3/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test4() {
        File f = new File("nofile.p");
        assertFalse(f.exists());

        configureProject("PCTRun/test4/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test5() {
        configureProject("PCTRun/test5/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test6() {
        configureProject("PCTRun/test6/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test7() {
        configureProject("PCTRun/test7/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test8() {
        configureProject("PCTRun/test8/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test9() {
        configureProject("PCTRun/test9/build.xml");
        expectLog("test1", "Hello PCT");
        expectLog("test2", "Hello");
    }

    @Test(groups = {"v11"})
    public void test10() {
        configureProject("PCTRun/test10/build.xml");
        expectLog("test1", "01/01/2060");
        expectLog("test2", "01/01/1960");
    }

    @Test(groups = {"v11"})
    public void test11() {
        configureProject("PCTRun/test11/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test12() {
        configureProject("PCTRun/test12/build.xml");
        expectLog("test1", "123.456");
        expectLog("test2", "123,456");
        expectLog("test3", "123,456");
        expectLog("test4", "123.456");
    }

    @Test(groups = {"v11"})
    public void test13() {
        configureProject("PCTRun/test13/build.xml");
        expectLog("test1", "This is dir1");
        expectLog("test2", "This is dir2");
    }

    @Test(groups = {"v11", "win"})
    public void test14() {
        // Sous Windows uniquement
        configureProject("PCTRun/test14/build.xml");
        expectLog("test1", "-prop1=prop1 -prop2=prop2 -prop3='prop3'");
        expectLog("test2", "-prop1=prop1 -prop2=prop2 -prop3=prop3");
        expectLog("test3", "-prop1=prop1 -prop2=prop2 -prop3=prop 3");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test15() {
        configureProject("PCTRun/test15/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test16() {
        configureProject("PCTRun/test16/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test16/subdir/Output.txt");
        assertTrue(f.exists());
    }

    @Test(groups = {"v11"})
    public void test17() {
        configureProject("PCTRun/test17/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test17/src/subdir2/Output.txt");
        assertTrue(f.exists());
    }

    @Test(groups = {"v11"})
    public void test18() {
        configureProject("PCTRun/test18/build.xml");
        expectLog("test", "utf-8");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test19() {
        configureProject("PCTRun/test19/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test20() {
        configureProject("PCTRun/test20/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test21() {
        configureProject("PCTRun/test21/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test21/sandbox/profiler.out");
        assertTrue(f.exists());
    }

    @Test(groups = {"v11"})
    public void test22() {
        configureProject("PCTRun/test22/build.xml");
        expectLog("test", "Message with spaces");
    }

    @Test(groups = {"v11"})
    public void test23() {
        configureProject("PCTRun/test23/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test23/temp dir/test.txt");
        assertTrue(f.exists());
    }

    @Test(groups = {"v11"})
    public void test24() {
        configureProject("PCTRun/test24/build.xml");
        expectLog("test", "TEST");
    }

    @Test(groups = {"v11"})
    public void test25() {
        configureProject("PCTRun/test25/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test26() {
        configureProject("PCTRun/test26/build.xml");
        executeTarget("test");
        executeTarget("test2");
        expectBuildException("test3", "Should fail");
    }

    @Test(groups = {"v11"})
    public void test27() {
        configureProject("PCTRun/test27/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test28() {
        configureProject("PCTRun/test28/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test29() {
        configureProject("PCTRun/test29/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test30() {
        configureProject("PCTRun/test30/build.xml");
        expectBuildException("test1", "Shouldn't work");
        executeTarget("test2");
    }

    @Test(groups = {"v11"})
    public void test31() {
        configureProject("PCTRun/test31/build.xml");
        expectBuildException("test1", "Shouldn't work");
        executeTarget("test2");
    }

    @Test(groups = {"v11"})
    public void test32() {
        configureProject("PCTRun/test32/build.xml");
        assertPropertyUnset("myResult");
        executeTarget("test1");
        assertPropertyEquals("myResult", "0");

        assertPropertyUnset("myNewResult");
        executeTarget("test2");
        assertPropertyEquals("myNewResult", "17");
    }

    @Test(groups = {"v11"})
    public void test33() {
        configureProject("PCTRun/test33/build.xml");
        expectBuildException("test1", "No output parameter defined");

        assertPropertyUnset("firstParam");
        executeTarget("test2");
        assertPropertyEquals("firstParam", "PCT");
    }

    @Test(groups = {"v11"})
    public void test34() {
        configureProject("PCTRun/test34/build.xml");
        assertPropertyUnset("firstParam");
        assertPropertyUnset("secondParam");
        assertPropertyUnset("thirdParam");
        assertPropertyUnset("fourthParam");

        executeTarget("test");
        assertPropertyEquals("firstParam", "PCT1");
        assertPropertyEquals("secondParam", "PCT2");
        assertPropertyEquals("thirdParam", "PCT3");
        assertPropertyEquals("fourthParam", "PCT4");
    }

    @Test(groups = {"v11"})
    public void test35() {
        configureProject("PCTRun/test35/build.xml");
        executeTarget("test1");
        expectBuildException("test2", "Not in propath");
    }

    @Test(groups = {"v11"})
    public void test36() {
        configureProject("PCTRun/test36/build.xml");
        executeTarget("base");
        expectBuildException("test1", "Incorrect alias");
        executeTarget("test2");
        executeTarget("test3");
        executeTarget("test4");
        executeTarget("test5");
        expectBuildException("test6", "No alias defined");
    }

    @Test(groups = {"v11"})
    public void test37() {
        configureProject("PCTRun/test37/build.xml");
        expectLog("test1", "Result : 123");
        expectLog("test2", "Result : 1");
        expectLog("test3", "Result : 1");
    }

    @Test(groups = {"v11"})
    public void test38() {
        configureProject("PCTRun/test38/build.xml");
        expectLog("test1", "Result : A1B2C3");
        expectLog("test2", "Result : 123 -- 456 -- ABC");
    }

    @Test(groups = {"v11", "win"})
    public void test39() {
        configureProject("PCTRun/test39/build.xml");
        expectLog("test1", "Result : UTF 8 ±÷");
        expectLog("test2", "Result : 8859-1 ±÷");
        expectLog("test3", "Result : Big5 ±÷");
        expectLog("test4", "Result : 1252 ±÷");
        expectLog("test5", "Result : UTF 8 ±÷");
    }

    @Test(groups = {"v11"})
    public void test40() {
        configureProject("PCTRun/test40/build.xml");

        File f1 = new File("PCTRun/test40/profiler1/profiler.out");
        executeTarget("test1");
        assertFalse(f1.exists());

        File f2 = new File("PCTRun/test40/profiler2/profiler.out");
        executeTarget("test2");
        assertTrue(f2.exists());

        executeTarget("test3");
        File f3 = new File("PCTRun/test40/profiler3");
        assertEquals(f3.list().length, 1);

        expectBuildException("test4", "OutputDir and OutputFile");

        File f5 = new File("PCTRun/test40/profiler5/profiler.out");
        executeTarget("test5");
        assertTrue(f5.exists());

        executeTarget("test6");
        File f6 = new File("PCTRun/test40/profiler6");
        assertEquals(f6.list().length, 3);
    }

    @Test(groups = {"v11"})
    public void test41() {
        configureProject("PCTRun/test41/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test42() {
        configureProject("PCTRun/test42/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"}, expectedExceptions = BuildException.class)
    public void test43() {
        configureProject("PCTRun/test43/build.xml");
        executeTarget("test");
    }

    @Test(groups = {"v11"})
    public void test44() {
        configureProject("PCTRun/test44/build.xml");
        executeTarget("test1");
        assertTrue(new File("PCTRun/test44/Logger1.init.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger1.beforeRun.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger1.log.Log1.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger1.log.Log2.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger1.afterRun.0.txt").exists());

        expectBuildException("test2", "Test has to fail");
        assertTrue(new File("PCTRun/test44/Logger2.init.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger2.beforeRun.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger2.log.Log1.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger2.log.Log2.txt").exists());
        assertTrue(new File("PCTRun/test44/Logger2.afterRun.1.txt").exists());
    }

    @Test(groups = {"v11"})
    public void test45() {
        configureProject("PCTRun/test45/build.xml");
        executeTarget("test1");

        // Message has to be displayed on both Unix and Windows
        executeTarget("test2");
        boolean unableToFindMessage = false;
        boolean iniFileIgnored = false;
        for (String str : getLogBuffer()) {
            if (str.startsWith("Unable to find INI file"))
                unableToFindMessage = true;
            if (str.startsWith("iniFile attribute is ignored"))
                iniFileIgnored = true;
        }
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            assertTrue(unableToFindMessage, "Expected message not found");
        } else {
            assertTrue(iniFileIgnored, "Expected message not found");
        }

        boolean unableToFindMessage2 = false;
        executeTarget("test3");
        for (String str : getLogBuffer()) {
            if (str.startsWith("Unable to find INI file"))
                unableToFindMessage2 = true;
        }
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
            assertTrue(unableToFindMessage2);
        } else {
            assertFalse(unableToFindMessage2);
        }
    }

    @Test(groups = {"v11"})
    public void test47() {
        configureProject("PCTRun/test47/build.xml");
        executeTarget("init");
        expectLog("test1", "Hello1");
        expectLog("test2", "Hello2");
    }

    @Test(groups = {"v11"})
    public void test48() {
        configureProject("PCTRun/test48/build.xml");
        executeTarget("test1");
        expectBuildException("test2", "Invalid env variable");
    }

    @Test(groups = {"v11"})
    public void test49() {
        configureProject("PCTRun/test49/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test49/profiler");
        assertEquals(f.listFiles().length, 4);
    }

    @Test(groups = {"v11"})
    public void test50() {
        configureProject("PCTRun/test50/build.xml");
        executeTarget("init");

        executeTarget("testrr1");
        expectBuildException("testrr2", "Runtime client");
        expectBuildException("testrr3", "Runtime client");

        executeTarget("testrx1");
        executeTarget("testrx2");
        expectBuildException("testrr3", "Encrypted compiler client");

        executeTarget("testrg1");
        executeTarget("testrg2");
        executeTarget("testrg3");
    }

    @Test(groups = {"v11"})
    public void test51() {
        configureProject("PCTRun/test51/build.xml");
        executeTarget("test");
        File f = new File("PCTRun/test51/profiler dir/");
        assertEquals(f.listFiles().length, 1);
        executeTarget("test2");
        assertEquals(f.listFiles().length, 2);
    }

    @Test(groups = {"v11"})
    public void test52() {
        configureProject("PCTRun/test52/build.xml");
        expectLog("test1", "----");
        expectLog("test2", "-- --");
        expectLog("test3", "--xx--");
    }

    @Test(groups = {"v11"})
    public void test53() {
        final String USER_PASSPHRASE = "User#234";
        configureProject("PCTRun/test53/build.xml");
        executeTarget("init");
        expectBuildException("test1", "No passphrase");
        assertFalse(searchInList(getLogBuffer(), USER_PASSPHRASE));
        assertFalse(searchInFile(new File("test1.txt"), USER_PASSPHRASE));
        if (System.getProperty("os.name").toLowerCase().startsWith("win")) {
            executeTarget("test4-win");
            assertFalse(searchInList(getLogBuffer(), USER_PASSPHRASE));
            assertFalse(searchInFile(new File("test4.txt"), USER_PASSPHRASE));
            expectBuildException("test5-win", "Wrong command line passphrase");
            assertFalse(searchInList(getLogBuffer(), USER_PASSPHRASE));
            assertFalse(searchInFile(new File("test5.txt"), USER_PASSPHRASE));
        } else {
            executeTarget("test4-unix");
            assertFalse(searchInList(getLogBuffer(), USER_PASSPHRASE));
            assertFalse(searchInFile(new File("test4.txt"), USER_PASSPHRASE));
            expectBuildException("test5-unix", "Wrong command line passphrase");
            assertFalse(searchInList(getLogBuffer(), USER_PASSPHRASE));
            assertFalse(searchInFile(new File("test5.txt"), USER_PASSPHRASE));
        }
    }

    @Test(groups = {"v12", "win"})
    public void test54() {
        // Only work with 12.7+
        DLCVersion version = DLCVersion.getObject(new File(System.getProperty("DLC")));
        if ((version.getMajorVersion() == 12) && (version.getMinorVersion() <= 6))
            return;

        configureProject("PCTRun/test54/build.xml");
        expectLog("test1", ".Net version: 4.0.30319.42000");
        expectLog("test2", ".Net version: 6.0.21");
    }

    @Test(groups = {"v11"})
    public void test55() {
        configureProject("PCTRun/test55/build.xml");
        executeTarget("test");
        assertTrue(searchInList(getLogBuffer(), "hello"));
        expectBuildException("test2", "Failure");
        assertTrue(searchInList(getLogBuffer(), "hello2"));
        expectBuildException("test3", "Failure");
        assertTrue(searchInList(getLogBuffer(), "(15304)"));
        expectBuildException("test4", "Failure");
        assertTrue(searchInList(getLogBuffer(), "hello4"));
        expectBuildException("test5", "Failure");
        assertTrue(searchInList(getLogBuffer(), "(15285)"));
        expectBuildException("test6", "Failure");
        assertTrue(searchInList(getLogBuffer(), "(15285)"));
        expectBuildException("test7", "Failure");
        assertTrue(searchInList(getLogBuffer(), "(247)"));
        assertTrue(searchInList(getLogBuffer(), "(15285)"));
        executeTarget("test8");
        assertTrue(searchInList(getLogBuffer(), "hello"));
        executeTarget("test9");
        assertTrue(searchInList(getLogBuffer(), "ABC"));
    }

}
