/*
 * generated by Xtext
 */
package fr.imag.exschema.xtext.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import fr.imag.exschema.xtext.ui.internal.ExSchemaActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class ExSchemaExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return ExSchemaActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return ExSchemaActivator.getInstance().getInjector(ExSchemaActivator.FR_IMAG_EXSCHEMA_XTEXT_EXSCHEMA);
	}
	
}
