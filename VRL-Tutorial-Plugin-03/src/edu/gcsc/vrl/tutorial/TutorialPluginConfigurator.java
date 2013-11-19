/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.gcsc.vrl.tutorial;

import eu.mihosoft.vrl.system.InitPluginAPI;
import eu.mihosoft.vrl.system.PluginAPI;
import eu.mihosoft.vrl.system.PluginDependency;
import eu.mihosoft.vrl.system.PluginIdentifier;
import eu.mihosoft.vrl.system.VMessage;
import eu.mihosoft.vrl.system.VPluginAPI;
import eu.mihosoft.vrl.system.VPluginConfigurator;
import eu.mihosoft.vrl.system.VRL;
import eu.mihosoft.vrl.visual.ActionDelegator;
import eu.mihosoft.vrl.visual.VAction;
import java.awt.event.ActionEvent;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class TutorialPluginConfigurator extends VPluginConfigurator {

    public TutorialPluginConfigurator() {
        //specify the plugin name and version
        setIdentifier(new PluginIdentifier("Tutorial-Plugin03", "0.1"));

        // optionally allow other plugins to use the api of this plugin
        // you can specify packages that shall be
        // exported by using the exportPackage() method:
        //
        // exportPackage("com.your.package");
        // describe the plugin
        setDescription("Explains how to add custom menu actions");

        // copyright info
        setCopyrightInfo("Sample-Plugin",
                "(c) Your Name",
                "www.you.com", "License Name", "License Text...");

        // specify dependencies
//        addDependency(new PluginDependency("VRL", "0.4.0", "0.4.0"));
    }

    @Override
    public void register(PluginAPI api) {

        // register plugin with canvas
        if (api instanceof VPluginAPI) {
            final VPluginAPI vapi = (VPluginAPI) api;

            // Register visual components:
            //
            // Here you can add additional components,
            // type representations, styles etc.
            //
            // ** NOTE **
            //
            // To ensure compatibility with future versions of VRL,
            // you should only use the vapi or api object for registration.
            // If you directly use the canvas or its properties, please make
            // sure that you specify the VRL versions you are compatible with
            // in the constructor of this plugin configurator because the
            // internal api is likely to change.
            //
            // examples:
            //
            // vapi.addComponent(MyComponent.class);
            // vapi.addTypeRepresentation(MyType.class);

            // register custom menu actions
            vapi.addAction(new VAction("Tutorial03") {

                @Override
                public void actionPerformed(ActionEvent e, Object owner) {
                    System.out.println("Tool Menu");
                    VMessage.info("Tutorial Plugin 03", "Tool Menu clicked!");
                }
            }, ActionDelegator.TOOL_MENU);
            
            vapi.addAction(new VAction("Tutorial03") {

                @Override
                public void actionPerformed(ActionEvent e, Object owner) {
                    System.out.println("Window Menu");
                    VMessage.info("Tutorial Plugin 03", "Window Menu clicked!");
                }
            }, ActionDelegator.WINDOW_MENU);
        }
    }

    @Override
    public void unregister(PluginAPI api) {
        // nothing to unregister
    }

    @Override
    public void init(InitPluginAPI iApi) {
        // nothing to init
    }
}
