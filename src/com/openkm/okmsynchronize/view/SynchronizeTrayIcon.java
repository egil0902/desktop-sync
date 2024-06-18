/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openkm.okmsynchronize.view;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.border.TitledBorder;

/**
 *
 * @author abujosa
 */
public class SynchronizeTrayIcon extends TrayIcon {
    
    private JPopupMenu trayMenu;
    private JMenuItem menuItemExit;
    private JMenuItem menuItemAbout;
    private JMenuItem menuItemShowDesktop;
    

    public SynchronizeTrayIcon(Image image) {
        super(image);
        
        initComponents();
    }

    public SynchronizeTrayIcon(Image image, String string) {
        super(image, string);
        
        initComponents();
    }

    public SynchronizeTrayIcon(Image image, String string, PopupMenu pm) {
        super(image, string, pm);
        
        initComponents();
    }
       
    private void initComponents() {
        trayMenu = new JPopupMenu("Menú de Sincronización");

        menuItemShowDesktop = new JMenuItem("Mostrar Escritorio");
        menuItemExit = new JMenuItem("Salir");
        menuItemAbout = new JMenuItem("Acerca de");

        trayMenu.add(new JPopupMenu.Separator());
        trayMenu.add(menuItemShowDesktop);
        trayMenu.add(new JPopupMenu.Separator());
        trayMenu.add(menuItemAbout);
        trayMenu.add(menuItemExit);

        trayMenu.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createRaisedSoftBevelBorder(),
            "Menú del Escritorio",
            TitledBorder.CENTER,
            TitledBorder.DEFAULT_POSITION
        ));
        trayMenu.setPopupSize(200, 100);

        SystemTray systemTray = SystemTray.getSystemTray();
        setImageAutoSize(true);
        try {
            systemTray.add(this);
        } catch (AWTException awte) {
            awte.printStackTrace();
        }
    }

    
    public void addtrayMenuItemsListener(ActionListener l) {        
        menuItemShowDesktop.addActionListener(l);
        menuItemExit.addActionListener(l);
        menuItemAbout.addActionListener(l);
    }
    
    public void addTrayIconMouseListener(MouseListener l) {
        addMouseListener(l);        
    }
    
    
    public void showTrayIconMenu(int x, int y) {

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        trayMenu.setDoubleBuffered(true);
        trayMenu.setLocation(x - 10, y - 120);
        trayMenu.setInvoker(trayMenu);
        trayMenu.setVisible(true);
    }
    
    
    
}
