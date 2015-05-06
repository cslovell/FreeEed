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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JOptionPane;

import org.freeeed.main.ActionStaging;

import java.awt.EventQueue;
import org.freeeed.services.Settings;

/**
 *
 * @author ivanl
 */
public class StagingProgressUI extends javax.swing.JDialog {

    private boolean stagingFinished = false;
    private long total = 1;
    private long currentSize = 0;
    private final ActionStaging staging;
    private Thread stagingThread;

    /**
     * Creates new form StagingProgressUI
     * @param parent
     * @param modal
     */
    public StagingProgressUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        myInitComponents();

        staging = new ActionStaging(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();
        operationLabel = new javax.swing.JLabel();
        fileLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        straightThroughCheck = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Staging");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Staging")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(operationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(operationLabel)
                .addGap(15, 15, 15)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(fileLabel)
                .addContainerGap())
        );

        okButton.setText("Ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        straightThroughCheck.setText("Continue with local processing after staging");
        straightThroughCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                straightThroughCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(straightThroughCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton)
                    .addComponent(straightThroughCheck))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cancelStaging();
    }//GEN-LAST:event_formWindowClosing

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose();
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cancelStaging();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void straightThroughCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_straightThroughCheckActionPerformed
        setStraightThroughProcessing();
    }//GEN-LAST:event_straightThroughCheckActionPerformed

    @Override
    public void setVisible(boolean b) {
        if (b) {
            startStaging();
            centerWindow(this);
        }

        super.setVisible(b);
    }

    private void cancelStaging() {
        if (!stagingFinished) {
            int confirm = JOptionPane.showConfirmDialog(this, "Please confirm cancel staging");
            if (confirm == JOptionPane.OK_OPTION) {
                staging.setInterrupted(true);
                try {
                    stagingThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace(System.out);
                }

                doClose();
            }
        }
    }

    private void doClose() {
        setVisible(false);
        dispose();
    }

    private void myInitComponents() {
        okButton.setEnabled(false);
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        straightThroughCheck.setSelected(Settings.getSettings().isStraightThroughProcessing());
    }

    public void setStagingFinished() {
        this.stagingFinished = true;
    }

    /**
     * Callback for progress update
     *
     */
    public void setDownloadingState() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                operationLabel.setText("Downloading...");
            }
        });
    }

    /**
     * Callback for progress update
     *
     */
    public void setPackagingState() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                operationLabel.setText("Packaging...");
            }
        });
    }

    /**
     * Callback for progress update
     *
     */
    public void setPreparingState() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                operationLabel.setText("Preparing...");
            }
        });
    }

    /**
     * Callback for progress update
     *
     */
    public synchronized void setDone() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                operationLabel.setText("Done");
                stagingFinished = true;
                okButton.setEnabled(true);
            }
        });

    }

    /**
     * Callback for progress update
     *
     */
    public void setTotalSize(long total) {
        this.total = total;
    }

    public void resetCurrentSize() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                currentSize = 0;
                progressBar.setValue(0);
            }
        });
    }

    /**
     * Callback for progress update
     *
     * @param fileName
     */
    public void updateProcessingFile(final String fileName) {
        final String displayName = (fileName.length() <= 72)
                ? fileName
                : "..." + fileName.substring(fileName.length() - 72);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                fileLabel.setText(displayName);
            }
        });
    }

    /**
     * Callback for progress update
     *
     * @param size of files copied so far
     */
    public void updateProgress(long size) {
        if (size > 0) {
            currentSize += size;
            final long value = currentSize * 100 / total;
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    progressBar.setValue((int) value);
                }
            });
        }
    }

    /**
     * Callback for progress update
     *
     */
    public void startStaging() {
        stagingThread = new Thread(staging);
        stagingThread.start();
    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    private void setStraightThroughProcessing() {
        boolean b = straightThroughCheck.isSelected();
        Settings.getSettings().setStraighThroughProcessing(b);
        Settings.getSettings().save();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel operationLabel;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JCheckBox straightThroughCheck;
    // End of variables declaration//GEN-END:variables
}
