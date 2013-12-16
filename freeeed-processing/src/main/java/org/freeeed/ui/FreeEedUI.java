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
package org.freeeed.ui;

import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.freeeed.main.ParameterProcessing;
import org.freeeed.main.PlatformUtil;
import org.freeeed.main.SHMcloudException;
import org.freeeed.main.SHMcloudMain;
import org.freeeed.main.Version;
import org.freeeed.main.VersionUpdate;
import org.freeeed.main.WindowsReduce;
import org.freeeed.review.HiveAnalyzer;
import org.freeeed.services.Project;
import org.freeeed.services.Review;
import org.freeeed.services.Settings;
import org.freeeed.services.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mark
 */
public class FreeEedUI extends javax.swing.JFrame {

    private static final Logger logger = LoggerFactory.getLogger(FreeEedUI.class);
    private static FreeEedUI instance;

    public static FreeEedUI getInstance() {
        return instance;
    }
    private String settingsFile;

    /**
     * Creates new form Main
     */
    public FreeEedUI() {
        initComponents();
        manualMenuItem.setText("FreeEed" + ParameterProcessing.TM + " manual");
        showHistory();
        System.out.println(Version.getVersionAndBuild());
        // TODO warning: leaking this in the constructor - review and correct if needed 
        instance = this;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Settings.setSettingsFile(settingsFile);
        Settings.load();

        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuItemNewProject = new javax.swing.JMenuItem();
        menuItemOpenProject = new javax.swing.JMenuItem();
        menuOpenRecent = new javax.swing.JMenu();
        menuItemExit = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuItemProjectOptions = new javax.swing.JMenuItem();
        processMenu = new javax.swing.JMenu();
        stageMenuItem = new javax.swing.JMenuItem();
        processMenuItem = new javax.swing.JMenuItem();
        processSeparator = new javax.swing.JPopupMenu.Separator();
        ecProcessMenuItem = new javax.swing.JMenuItem();
        historyMenuItem = new javax.swing.JMenuItem();
        reviewMenu = new javax.swing.JMenu();
        menuItemOutputFolder = new javax.swing.JMenuItem();
        menuItemOpenSolar = new javax.swing.JMenuItem();
        menuItemLoadIntoHive = new javax.swing.JMenuItem();
        ec2Menu = new javax.swing.JMenu();
        programSettingsMenuItem = new javax.swing.JMenuItem();
        s3SetupMenuItem = new javax.swing.JMenuItem();
        ec2SetupMenuItem = new javax.swing.JMenuItem();
        clusterMenuItem = new javax.swing.JMenuItem();
        multClusterMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        manualMenuItem = new javax.swing.JMenuItem();
        featureRequestMenuItem = new javax.swing.JMenuItem();
        updateMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FreeEed - Graphical User Interface");

        fileMenu.setText("Project");

        menuItemNewProject.setText("New");
        menuItemNewProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNewProjectActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemNewProject);

        menuItemOpenProject.setText("Open");
        menuItemOpenProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenProjectActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemOpenProject);

        menuOpenRecent.setText("Open recent");
        fileMenu.add(menuOpenRecent);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        fileMenu.add(menuItemExit);

        mainMenu.add(fileMenu);

        editMenu.setText("Edit");

        menuItemProjectOptions.setText("Project options");
        menuItemProjectOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemProjectOptionsActionPerformed(evt);
            }
        });
        editMenu.add(menuItemProjectOptions);

        mainMenu.add(editMenu);

        processMenu.setText("Process");

        stageMenuItem.setText("Stage");
        stageMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stageMenuItemActionPerformed(evt);
            }
        });
        processMenu.add(stageMenuItem);

        processMenuItem.setText("Process locally");
        processMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processMenuItemActionPerformed(evt);
            }
        });
        processMenu.add(processMenuItem);
        processMenu.add(processSeparator);

        ecProcessMenuItem.setText("Process on Amazon");
        ecProcessMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecProcessMenuItemActionPerformed(evt);
            }
        });
        processMenu.add(ecProcessMenuItem);

        historyMenuItem.setText("History");
        historyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyMenuItemActionPerformed(evt);
            }
        });
        processMenu.add(historyMenuItem);

        mainMenu.add(processMenu);

        reviewMenu.setText("Review");

        menuItemOutputFolder.setText("Open output folder");
        menuItemOutputFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOutputFolderActionPerformed(evt);
            }
        });
        reviewMenu.add(menuItemOutputFolder);

        menuItemOpenSolar.setText("Search with Solr");
        menuItemOpenSolar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOpenSolarActionPerformed(evt);
            }
        });
        reviewMenu.add(menuItemOpenSolar);

        menuItemLoadIntoHive.setText("Load into Hive");
        menuItemLoadIntoHive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoadIntoHiveActionPerformed(evt);
            }
        });
        reviewMenu.add(menuItemLoadIntoHive);

        mainMenu.add(reviewMenu);

        ec2Menu.setText("Settings");

        programSettingsMenuItem.setText("Program settings");
        programSettingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programSettingsMenuItemActionPerformed(evt);
            }
        });
        ec2Menu.add(programSettingsMenuItem);

        s3SetupMenuItem.setText("S3 settings");
        s3SetupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s3SetupMenuItemActionPerformed(evt);
            }
        });
        ec2Menu.add(s3SetupMenuItem);

        ec2SetupMenuItem.setText("EC2 settings");
        ec2SetupMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ec2SetupMenuItemActionPerformed(evt);
            }
        });
        ec2Menu.add(ec2SetupMenuItem);

        clusterMenuItem.setText("EC2 cluster control");
        clusterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clusterMenuItemActionPerformed(evt);
            }
        });
        ec2Menu.add(clusterMenuItem);

        multClusterMenuItem.setText("Training cluster control");
        multClusterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multClusterMenuItemActionPerformed(evt);
            }
        });
        ec2Menu.add(multClusterMenuItem);

        mainMenu.add(ec2Menu);

        helpMenu.setText("Help");

        manualMenuItem.setText("SHMcloud manual");
        manualMenuItem.setToolTipText("A browser window will open");
        manualMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(manualMenuItem);

        featureRequestMenuItem.setText("Feature suggestion");
        featureRequestMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureRequestMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(featureRequestMenuItem);

        updateMenuItem.setText("Check for update");
        updateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(updateMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        mainMenu.add(helpMenu);

        setJMenuBar(mainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new AboutDialog(this, true).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        exitApp();
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemOpenProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenProjectActionPerformed
        openProject();
    }//GEN-LAST:event_menuItemOpenProjectActionPerformed

	private void menuItemNewProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNewProjectActionPerformed
            openNewProject();
	}//GEN-LAST:event_menuItemNewProjectActionPerformed

	private void stageMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stageMenuItemActionPerformed
            stageProject();
	}//GEN-LAST:event_stageMenuItemActionPerformed

	private void processMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processMenuItemActionPerformed
            try {
                Project.getProject().setEnvironment(Project.ENV_LOCAL);
                runProcessing();
            } catch (SHMcloudException e) {
                JOptionPane.showMessageDialog(this, "There were some problems with processing, \""
                        + e.getMessage() + "\n"
                        + "please check console output");
            }
	}//GEN-LAST:event_processMenuItemActionPerformed

	private void historyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyMenuItemActionPerformed
            showHistory();
	}//GEN-LAST:event_historyMenuItemActionPerformed

	private void menuItemOutputFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOutputFolderActionPerformed
            openOutputFolder();
	}//GEN-LAST:event_menuItemOutputFolderActionPerformed

    private void featureRequestMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureRequestMenuItemActionPerformed
        new FeatureRequestDialog(this, true).setVisible(true);
    }//GEN-LAST:event_featureRequestMenuItemActionPerformed

    private void menuItemLoadIntoHiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoadIntoHiveActionPerformed
        loadIntoHive();
    }//GEN-LAST:event_menuItemLoadIntoHiveActionPerformed

    private void s3SetupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s3SetupMenuItemActionPerformed
        S3SetupUI ui = new S3SetupUI(this, true);
        ui.setVisible(true);
    }//GEN-LAST:event_s3SetupMenuItemActionPerformed

    private void ec2SetupMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ec2SetupMenuItemActionPerformed
        EC2SetupUI ui = new EC2SetupUI(this, true);
        ui.setVisible(true);
    }//GEN-LAST:event_ec2SetupMenuItemActionPerformed

    private void clusterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clusterMenuItemActionPerformed
        ClusterControlUI ui = new ClusterControlUI(this, false);
        ui.setVisible(true);
    }//GEN-LAST:event_clusterMenuItemActionPerformed

    private void ecProcessMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecProcessMenuItemActionPerformed
        EC2ProcessUI ui = new EC2ProcessUI(this, false);
        ui.setVisible(true);
    }//GEN-LAST:event_ecProcessMenuItemActionPerformed

    private void manualMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualMenuItemActionPerformed
        openManual();
    }//GEN-LAST:event_manualMenuItemActionPerformed

    private void updateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMenuItemActionPerformed
        checkForUpdate();
    }//GEN-LAST:event_updateMenuItemActionPerformed

    private void menuItemProjectOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemProjectOptionsActionPerformed
        showProcessingOptions();
    }//GEN-LAST:event_menuItemProjectOptionsActionPerformed

    private void menuItemOpenSolarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOpenSolarActionPerformed
        openSolr();
    }//GEN-LAST:event_menuItemOpenSolarActionPerformed

    private void programSettingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programSettingsMenuItemActionPerformed
        openProgramSettings();
    }//GEN-LAST:event_programSettingsMenuItemActionPerformed

    private void multClusterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multClusterMenuItemActionPerformed
    }//GEN-LAST:event_multClusterMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        final String[] programArgs = args;

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FreeEedUI ui = new FreeEedUI();

                if (programArgs.length > 0) {
                    ui.settingsFile = programArgs[0];
                }

                ui.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem clusterMenuItem;
    private javax.swing.JMenu ec2Menu;
    private javax.swing.JMenuItem ec2SetupMenuItem;
    private javax.swing.JMenuItem ecProcessMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem featureRequestMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem historyMenuItem;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JMenuItem manualMenuItem;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLoadIntoHive;
    private javax.swing.JMenuItem menuItemNewProject;
    private javax.swing.JMenuItem menuItemOpenProject;
    private javax.swing.JMenuItem menuItemOpenSolar;
    private javax.swing.JMenuItem menuItemOutputFolder;
    private javax.swing.JMenuItem menuItemProjectOptions;
    private javax.swing.JMenu menuOpenRecent;
    private javax.swing.JMenuItem multClusterMenuItem;
    private javax.swing.JMenu processMenu;
    private javax.swing.JMenuItem processMenuItem;
    private javax.swing.JPopupMenu.Separator processSeparator;
    private javax.swing.JMenuItem programSettingsMenuItem;
    private javax.swing.JMenu reviewMenu;
    private javax.swing.JMenuItem s3SetupMenuItem;
    private javax.swing.JMenuItem stageMenuItem;
    private javax.swing.JMenuItem updateMenuItem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setVisible(boolean b) {
        if (b) {
            myInitComponents();
        }
        super.setVisible(b);
    }

    private void myInitComponents() {
        addWindowListener(new FrameListener());
        setBounds(64, 40, 640, 400);
        setTitle(ParameterProcessing.APP_NAME + ParameterProcessing.TM + " - Hadoop e-Discovery, Search and Analytics Platform");
        setupRecentProjectMenu();
    }

    private void exitApp() {
        if (!isExitAllowed()) {
            return;
        }
        Settings.getSettings().save();
        // TODO verify - is that a standard way to exit? What is the user clicks on "X", how do we disallow
        setVisible(false);
        System.exit(0);
    }

    private boolean isExitAllowed() {
        return true;
    }

    private void openProject() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            //fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            fileChooser.addChoosableFileFilter(new ProjectFilter());
            File f = null;
            Settings settings = Settings.getSettings();
            if (settings.getCurrentDir() != null) {
                f = new File(settings.getCurrentDir());
            } else {
                try {
                    f = new File(new File(".").getCanonicalPath());
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
            // Set the current directory
            fileChooser.setCurrentDirectory(f);
            fileChooser.setDialogTitle("Select project file");
            fileChooser.showOpenDialog(this);
            File selectedFile = fileChooser.getSelectedFile();
            if (selectedFile == null) {
                return;
            }
            openProject(selectedFile);
            settings.setCurrentDir(selectedFile.getParent());
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public void openProject(File selectedFile) {
        Project project = new Project().loadFromFile(selectedFile);
        Project.setProject(project);
        project.setProjectFilePath(selectedFile.getPath());
        updateTitle(project.getProjectCode() + " " + project.getProjectName());
        logger.trace("Opened project file: " + selectedFile.getPath());
        Settings settings = Settings.getSettings();
        settings.addRecentProject(selectedFile.getPath());
        if (chooseRun(project) == false) {
            return;
        }
        showProcessingOptions();
        //showProjectSettings();

    }

    private class ProjectFilter extends javax.swing.filechooser.FileFilter {

        @Override
        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(".project") || file.isDirectory();
        }

        @Override
        public String getDescription() {
            return "Project files";
        }
    }

    public void updateTitle(String title) {
        if (title != null) {
            setTitle(ParameterProcessing.APP_NAME + ParameterProcessing.TM + " - " + title);
        } else {
            setTitle(ParameterProcessing.APP_NAME + ParameterProcessing.TM);
        }
    }

//    private boolean showProjectSettings() {
//        if (Project.getProject().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Please create or open a project first");
//            return false;
//        }
//        ProjectSettingsUI dialog = new ProjectSettingsUI(this, true);
//        dialog.setLocationRelativeTo(this);
//        dialog.setVisible(true);
//        boolean ok = (dialog.getReturnStatus() == ProjectSettingsUI.RET_OK);
//        return ok;
//    }
    private boolean showProcessingOptions() {
        if (Project.getProject().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please create or open a project first");
            return false;
        }
        ProcessingParametersUI dialog = new ProcessingParametersUI(this, true);
        dialog.setLocationRelativeTo(this);
        dialog.setVisible(true);
        boolean ok = (dialog.getReturnStatus() == ProcessingParametersUI.RET_OK);
        return ok;
    }

    private void openNewProject() {
        Project project = new Project().loadFromFile(new File(ParameterProcessing.DEFAULT_PARAMETER_FILE));
        Project.setProject(project);
        project.generateProjectCode();
        project.setProjectName(project.getNewProjectName());
        updateTitle(project.getProjectCode() + " " + project.getProjectName());
        showProcessingOptions();
    }

    private void stageProject() {
        Project project = Project.getProject();
        if (project.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please create or open a project first");
            return;
        }
        if (project.getRun() == null || project.getRun().isEmpty()) {
            project.setRun();
        }
        try {
            SHMcloudMain.getInstance().runStagePackageInput();
        } catch (Exception e) {
            logger.error("Error staging project", e);
        }
    }

    private void runProcessing() throws SHMcloudException {
        Project project = Project.getProject();
        if (project.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please create or open a project first");
            return;
        }
        SHMcloudMain mainInstance = SHMcloudMain.getInstance();
        if (new File(project.getResultsDir()).exists()) {
            // in most cases, it won't already exist, but just in case
            try {
                Util.deleteDirectory(new File(project.getResultsDir()));
            } catch (Exception e) {
                throw new SHMcloudException(e.getMessage());
            }
        }
        if (PlatformUtil.isWindows()) {
            WindowsReduce.reinit();
        }
        String processWhere = project.getProcessWhere();
        if (processWhere != null) {
            mainInstance.runProcessing(processWhere);
        } else {
            throw new SHMcloudException("No processing option selected.");
        }
    }

    private void showHistory() {
        HistoryUI ui = new HistoryUI();
        ui.setVisible(true);
    }

    private boolean areResultsPresents() {
        try {
            Project project = Project.getProject();
            if (project == null || project.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please open a project first");
                return false;
            }
            boolean success = Review.deliverFiles();
            if (!success) {
                JOptionPane.showMessageDialog(this, "No results yet");
                return false;
            }
        } catch (IOException e) {
            logger.warn("Results present? Problem!", e);
            return false;
        }
        return true;
    }

    private void openOutputFolder() {
        if (!areResultsPresents()) {
            return;
        }
        String resultsFolder = Project.getProject().getResultsDir();
        try {
            // Desktop should work, but it stopped lately in Ubuntu
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(new File(resultsFolder));
            } else {
                if (PlatformUtil.isLinux()) {
                    String command = "nautilus " + resultsFolder;
                    PlatformUtil.runUnixCommand(command);
                } else if (PlatformUtil.isMac()) {
                    String command = "open " + resultsFolder;
                    PlatformUtil.runUnixCommand(command);
                }
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
            if (PlatformUtil.isLinux()) {
                String command = "nautilus " + resultsFolder;
                PlatformUtil.runUnixCommand(command);
            } else if (PlatformUtil.isMac()) {
                String command = "open " + resultsFolder;
                PlatformUtil.runUnixCommand(command);
            }
        }
    }

    class FrameListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            Settings.getSettings().save();
        }
    }

    private void setupRecentProjectMenu() {
        Settings setting = Settings.getSettings();
        List<Project> recentProjects = setting.getRecentProjects();
        for (Properties recentProject : recentProjects) {
            JMenuItem item = new JMenuItem();
            item.setText(recentProject.getProperty(ParameterProcessing.PROJECT_CODE)
                    + " "
                    + recentProject.getProperty(ParameterProcessing.PROJECT_NAME));
            item.setName(recentProject.getProperty(ParameterProcessing.PROJECT_FILE_PATH));
            menuOpenRecent.add(item);
            item.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    JMenuItem item = (JMenuItem) evt.getSource();
                    String filePath = item.getName();
                    if (filePath == null) {
                        return;
                    }
                    File selectedFile = new File(filePath);
                    Settings settings = Settings.getSettings();
                    settings.setCurrentDir(selectedFile.getParent());
                    Project project = new Project().loadFromFile(selectedFile);
                    Project.setProject(project);
                    project.setProjectFilePath(selectedFile.getPath());
                    if (chooseRun(project) == false) {
                        // reset to no project 
                        Project.setProject(new Project());
                        return;
                    }
                    updateTitle(project.getProjectCode() + " " + project.getProjectName());
                    logger.trace("Opened project file: {}", selectedFile.getPath());
                    settings.addRecentProject(selectedFile.getPath());
                    showProcessingOptions();
                }
            });
        }
    }

    private boolean chooseRun(Project project) {
        String runDir = project.getRunsDir();
        File[] files = new File(runDir).listFiles();
        ArrayList<String> runs = new ArrayList<String>();

        String createNew = "Create a new run when staging";
        runs.add(createNew);

        if (files != null) {
            for (File file : files) {
                if (file.getName().startsWith("run")) {
                    runs.add(file.getName());
                }
            }
        }
        if (runs.isEmpty()) {
            return true;
        }

        String run = (String) JOptionPane.showInputDialog(
                null,
                "Please choose run",
                "Project run selection",
                JOptionPane.PLAIN_MESSAGE,
                null,
                (String[]) runs.toArray(new String[0]),
                runs.get(0));
        if (run == null) {
            return false;
        }
        if (run.equals(createNew)) {
            project.setRun("");
        } else {
            project.setRun(run);
        }
        return true;
    }

    private void loadIntoHive() {
        if (!PlatformUtil.isNix()) {
            JOptionPane.showMessageDialog(this, "This option works only in Linux/MacOS");
            return;
        }
        if (!areResultsPresents()) {
            return;
        }
        String resultFile = Project.getProject().getLoadFile();
        if (!new File(resultFile).exists()) {
            JOptionPane.showMessageDialog(this, "Sorry, no results found");
            return;
        }
        new Thread(new HiveAnalyzer(resultFile)).start();
    }

    private void openManual() {
        Settings settings = Settings.getSettings();
        String url = settings.getManualPage();
        UtilUI.openBrowser(this, url);
    }

    private void openProgramSettings() {
        ProgramSettingsUI programSettingsUI = new ProgramSettingsUI(this, true);
        programSettingsUI.setVisible(true);
    }

    private void openSolr() {
        Settings settings = Settings.getSettings();
        String url = settings.getSolrEndpoint() + "/solr/admin";
        UtilUI.openBrowser(this, url);
    }

    private void checkForUpdate() {
        VersionUpdate update = new VersionUpdate();
        if (!update.isNewVersionAvailable()) {
            JOptionPane.showMessageDialog(this, "No update available, your software is up-to-date");
        } else {
            String updateInfo = update.getUpdateInfo();
            String question = "Would you like to update your software,\n"
                    + "to start using the following new features:\n"
                    + updateInfo;
            int ret = JOptionPane.showConfirmDialog(this,
                    question);
            if (ret != JOptionPane.OK_OPTION) {
                return;
            }
            downloadUpdateJar();
        }
    }

    private void downloadUpdateJar() {
        new Thread(new Downloader()).start();
        JOptionPane.showMessageDialog(this, "Download has started.\n"
                + "The software will update next time you run it.");
    }

    class Downloader implements Runnable {

        @Override
        public void run() {
            VersionUpdate versionUpdate = new VersionUpdate();
            versionUpdate.downloadUpdateJar();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    JOptionPane.showMessageDialog(null, "Download of the new version has completed.\n"
                            + "The software will update next time you run it.");
                }
            });

        }
    }
}
