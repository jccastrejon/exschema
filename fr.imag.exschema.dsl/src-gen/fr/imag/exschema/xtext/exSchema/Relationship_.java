/**
 */
package fr.imag.exschema.xtext.exSchema;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relationship </b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.imag.exschema.xtext.exSchema.Relationship_#getStart <em>Start</em>}</li>
 *   <li>{@link fr.imag.exschema.xtext.exSchema.Relationship_#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getRelationship_()
 * @model
 * @generated
 */
public interface Relationship_ extends Entity
{
  /**
   * Returns the value of the '<em><b>Start</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' attribute.
   * @see #setStart(String)
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getRelationship__Start()
   * @model
   * @generated
   */
  String getStart();

  /**
   * Sets the value of the '{@link fr.imag.exschema.xtext.exSchema.Relationship_#getStart <em>Start</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' attribute.
   * @see #getStart()
   * @generated
   */
  void setStart(String value);

  /**
   * Returns the value of the '<em><b>End</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' attribute.
   * @see #setEnd(String)
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getRelationship__End()
   * @model
   * @generated
   */
  String getEnd();

  /**
   * Sets the value of the '{@link fr.imag.exschema.xtext.exSchema.Relationship_#getEnd <em>End</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' attribute.
   * @see #getEnd()
   * @generated
   */
  void setEnd(String value);

} // Relationship_
