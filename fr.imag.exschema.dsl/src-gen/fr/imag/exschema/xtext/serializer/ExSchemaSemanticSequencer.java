package fr.imag.exschema.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.imag.exschema.xtext.exSchema.Attribute;
import fr.imag.exschema.xtext.exSchema.ExSchemaPackage;
import fr.imag.exschema.xtext.exSchema.Relationship_;
import fr.imag.exschema.xtext.exSchema.Schema;
import fr.imag.exschema.xtext.exSchema.Set_;
import fr.imag.exschema.xtext.exSchema.Struct_;
import fr.imag.exschema.xtext.services.ExSchemaGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class ExSchemaSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ExSchemaGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ExSchemaPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ExSchemaPackage.ATTRIBUTE:
				if(context == grammarAccess.getAttributeRule()) {
					sequence_Attribute(context, (Attribute) semanticObject); 
					return; 
				}
				else break;
			case ExSchemaPackage.RELATIONSHIP_:
				if(context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getRelationship_Rule()) {
					sequence_Relationship_(context, (Relationship_) semanticObject); 
					return; 
				}
				else break;
			case ExSchemaPackage.SCHEMA:
				if(context == grammarAccess.getSchemaRule()) {
					sequence_Schema(context, (Schema) semanticObject); 
					return; 
				}
				else break;
			case ExSchemaPackage.SET_:
				if(context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getSet_Rule()) {
					sequence_Set_(context, (Set_) semanticObject); 
					return; 
				}
				else break;
			case ExSchemaPackage.STRUCT_:
				if(context == grammarAccess.getEntityRule() ||
				   context == grammarAccess.getStruct_Rule()) {
					sequence_Struct_(context, (Struct_) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name=ID value=STRING)
	 */
	protected void sequence_Attribute(EObject context, Attribute semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, ExSchemaPackage.Literals.ATTRIBUTE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExSchemaPackage.Literals.ATTRIBUTE__NAME));
			if(transientValues.isValueTransient(semanticObject, ExSchemaPackage.Literals.ATTRIBUTE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ExSchemaPackage.Literals.ATTRIBUTE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attributes+=Attribute* (start=Entity end=Entity)?)
	 */
	protected void sequence_Relationship_(EObject context, Relationship_ semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (attributes+=Attribute* entities+=Entity*)
	 */
	protected void sequence_Schema(EObject context, Schema semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attributes+=Attribute* entities+=Entity*)
	 */
	protected void sequence_Set_(EObject context, Set_ semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ID attributes+=Attribute* entities+=Entity*)
	 */
	protected void sequence_Struct_(EObject context, Struct_ semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
}
