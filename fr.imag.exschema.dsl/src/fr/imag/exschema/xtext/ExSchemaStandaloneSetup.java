
package fr.imag.exschema.xtext;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class ExSchemaStandaloneSetup extends ExSchemaStandaloneSetupGenerated{

	public static void doSetup() {
		new ExSchemaStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

