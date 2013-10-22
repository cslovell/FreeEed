/*
 *
 * Copyright SHMsoft, Inc. 
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package org.freeeed.main;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

import org.freeeed.main.PlatformUtil;
import org.freeeed.main.SHMcloudMain;
import org.freeeed.main.WindowsReduce;
import org.freeeed.services.FreeEedUtil;
import org.freeeed.services.Project;
import org.junit.*;


public class FreeEedSmallTest {

    public FreeEedSmallTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testMain() {
        System.out.println("testMain");
        String[] args = new String[2];
        args[0] = "-param_file";
        args[1] = "small_test.project";        
        // delete output, so that the test should run
        Project project = new Project().loadFromFile(new File(args[1]));        
        Project.setProject(project);
        try {
            if (new File(project.getOutputDir()).exists()) {
                Files.deleteRecursively(new File(project.getOutputDir()));
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        if (PlatformUtil.getPlatform() == PlatformUtil.PLATFORM.WINDOWS) {
            WindowsReduce.reinit();
        }
        SHMcloudMain.main(args);
        // TODO - do more tests        
        String outputSuccess = project.getResultsDir() + "/_SUCCESS";
        assertTrue(new File(outputSuccess).exists());
        String metadataFile = project.getResultsDir() + File.separator;
        if (PlatformUtil.getPlatform() == PlatformUtil.PLATFORM.WINDOWS) {
            metadataFile += "metadata.txt";
        } else {
            metadataFile += "part-r-00000";
        }
        assertTrue(new File(metadataFile).exists());
        try {
            //int resultCount = Files.readLines(new File(metadataFile), Charset.defaultCharset()).size();
            int resultCount = FreeEedUtil.countLines(metadataFile);            
            System.out.println("resultCount = " + resultCount);
            // TODO find out the reason for Windows/Linux difference
            if (PlatformUtil.getPlatform() == PlatformUtil.PLATFORM.WINDOWS) {
                assertTrue("resultCount == 11", resultCount == 11);
            } else {
                assertTrue("resultCount == 11", resultCount == 11);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
