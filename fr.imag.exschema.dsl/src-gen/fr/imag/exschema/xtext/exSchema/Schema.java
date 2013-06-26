/**
 */
package fr.imag.exschema.xtext.exSchema;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schema</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.imag.exschema.xtext.exSchema.Schema#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link fr.imag.exschema.xtext.exSchema.Schema#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getSchema()
 * @model
 * @generated
 */
public interface Schema extends EObject
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link fr.imag.exschema.xtext.exSchema.Attribute}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getSchema_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<Attribute> getAttributes();

  /**
   * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
   * The list contents are of type {@link fr.imag.exschema.xtext.exSchema.Entity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entities</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entities</em>' containment reference list.
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getSchema_Entities()
   * @model containment="true"
   * @generated
   */
  EList<Entity> getEntities();

} // Schema
