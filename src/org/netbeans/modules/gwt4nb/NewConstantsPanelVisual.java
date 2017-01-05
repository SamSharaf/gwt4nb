/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 */
package org.netbeans.modules.gwt4nb;

import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * New interface extends Constants.
 *
 * @author  Tomasz.Slota@Sun.COM
 * @author see https://github.com/gwt4nb/gwt4nb/
 */
public class NewConstantsPanelVisual extends javax.swing.JPanel {
    public static final long serialVersionUID = 1;

    private NewConstantsPanel controller;
    
    /** 
     * -
     *
     * @param controller controller for this panel
     */
    public NewConstantsPanelVisual(NewConstantsPanel controller) {
        this.controller = controller;
        initComponents();
        
        txtInterfaceName.getDocument().addDocumentListener(new ChangeListener());
        
        SwingUtilities.invokeLater(new Runnable(){ // Avoid endless loop
            public void run() {
                update();
            }
        });
    }

    /**
     * Returns the name of the interface (without package)
     *
     * @return interface name like "MyConstants"
     */
    public String getInterfaceName(){
        return txtInterfaceName.getText();
    }
    
    private void update(){
        txtProperties.setText(txtInterfaceName.getText() + 
                ".properties"); // NOI18N
        controller.fireChangeEvent();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblServiceName = new javax.swing.JLabel();
        txtInterfaceName = new javax.swing.JTextField();
        lblLocalIFace = new javax.swing.JLabel();
        txtProperties = new javax.swing.JTextField();

        setName(org.openide.util.NbBundle.getMessage(NewConstantsPanelVisual.class, "panelNameConstants")); // NOI18N

        lblServiceName.setText(org.openide.util.NbBundle.getMessage(NewConstantsPanelVisual.class, "NewConstantsPanelVisual.lblServiceName.text")); // NOI18N

        txtInterfaceName.setText(org.openide.util.NbBundle.getMessage(NewConstantsPanelVisual.class, "NewConstantsPanelVisual.txtInterfaceName.text")); // NOI18N

        lblLocalIFace.setText(org.openide.util.NbBundle.getMessage(NewConstantsPanelVisual.class, "NewConstantsPanelVisual.lblLocalIFace.text")); // NOI18N

        txtProperties.setEditable(false);
        txtProperties.setText(org.openide.util.NbBundle.getMessage(NewConstantsPanelVisual.class, "NewConstantsPanelVisual.txtProperties.text")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblLocalIFace)
                    .add(lblServiceName))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(txtInterfaceName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                    .add(txtProperties, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblServiceName)
                    .add(txtInterfaceName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblLocalIFace)
                    .add(txtProperties, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(223, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblLocalIFace;
    private javax.swing.JLabel lblServiceName;
    private javax.swing.JTextField txtInterfaceName;
    private javax.swing.JTextField txtProperties;
    // End of variables declaration//GEN-END:variables
    
    private class ChangeListener implements DocumentListener{
        public void insertUpdate(DocumentEvent arg0) {
            update();
        }
        
        public void removeUpdate(DocumentEvent arg0) {
            update();
        }
        
        public void changedUpdate(DocumentEvent arg0) {
            update();
        }
    }
}