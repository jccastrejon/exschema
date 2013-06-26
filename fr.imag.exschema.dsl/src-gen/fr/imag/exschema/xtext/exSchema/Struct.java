/**
 */
package fr.imag.exschema.xtext.exSchema;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Struct</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.imag.exschema.xtext.exSchema.Struct#getEntities <em>Entities</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getStruct()
 * @model
 * @generated
 */
public interface Struct extends Entity
{
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
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getStruct_Entities()
   * @model containment="true"
   * @generated
   */
  EList<Entity> getEntities();

} // Struct
