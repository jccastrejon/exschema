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
   * Returns the value of the '<em><b>Start</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start</em>' containment reference.
   * @see #setStart(Entity)
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getRelationship__Start()
   * @model containment="true"
   * @generated
   */
  Entity getStart();

  /**
   * Sets the value of the '{@link fr.imag.exschema.xtext.exSchema.Relationship_#getStart <em>Start</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start</em>' containment reference.
   * @see #getStart()
   * @generated
   */
  void setStart(Entity value);

  /**
   * Returns the value of the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End</em>' containment reference.
   * @see #setEnd(Entity)
   * @see fr.imag.exschema.xtext.exSchema.ExSchemaPackage#getRelationship__End()
   * @model containment="true"
   * @generated
   */
  Entity getEnd();

  /**
   * Sets the value of the '{@link fr.imag.exschema.xtext.exSchema.Relationship_#getEnd <em>End</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End</em>' containment reference.
   * @see #getEnd()
   * @generated
   */
  void setEnd(Entity value);

} // Relationship_
