/**
 */
package fr.imag.exschema.xtext.exSchema;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.imag.exschema.xtext.exSchema.ExSchemaFactory
 * @model kind="package"
 * @generated
 */
public interface ExSchemaPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "exSchema";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://lig.imag.fr/dsl/ExSchema";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "exSchema";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExSchemaPackage eINSTANCE = fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.SchemaImpl <em>Schema</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.SchemaImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getSchema()
   * @generated
   */
  int SCHEMA = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__ATTRIBUTES = 0;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA__ENTITIES = 1;

  /**
   * The number of structural features of the '<em>Schema</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMA_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.EntityImpl <em>Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.EntityImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getEntity()
   * @generated
   */
  int ENTITY = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__NAME = 0;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY__ATTRIBUTES = 1;

  /**
   * The number of structural features of the '<em>Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTITY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.SetImpl <em>Set</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.SetImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getSet()
   * @generated
   */
  int SET = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__ATTRIBUTES = ENTITY__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET__ENTITIES = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Set</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SET_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.StructImpl <em>Struct</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.StructImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getStruct()
   * @generated
   */
  int STRUCT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT__ATTRIBUTES = ENTITY__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Entities</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT__ENTITIES = ENTITY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Struct</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCT_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.RelationshipImpl <em>Relationship</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.RelationshipImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getRelationship()
   * @generated
   */
  int RELATIONSHIP = 4;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__NAME = ENTITY__NAME;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__ATTRIBUTES = ENTITY__ATTRIBUTES;

  /**
   * The feature id for the '<em><b>Start</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__START = ENTITY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP__END = ENTITY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relationship</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONSHIP_FEATURE_COUNT = ENTITY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.imag.exschema.xtext.exSchema.impl.AttributeImpl <em>Attribute</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.imag.exschema.xtext.exSchema.impl.AttributeImpl
   * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getAttribute()
   * @generated
   */
  int ATTRIBUTE = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Attribute</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ATTRIBUTE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Schema <em>Schema</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Schema</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Schema
   * @generated
   */
  EClass getSchema();

  /**
   * Returns the meta object for the containment reference list '{@link fr.imag.exschema.xtext.exSchema.Schema#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Schema#getAttributes()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_Attributes();

  /**
   * Returns the meta object for the containment reference list '{@link fr.imag.exschema.xtext.exSchema.Schema#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Schema#getEntities()
   * @see #getSchema()
   * @generated
   */
  EReference getSchema_Entities();

  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Entity <em>Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entity</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Entity
   * @generated
   */
  EClass getEntity();

  /**
   * Returns the meta object for the attribute '{@link fr.imag.exschema.xtext.exSchema.Entity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Entity#getName()
   * @see #getEntity()
   * @generated
   */
  EAttribute getEntity_Name();

  /**
   * Returns the meta object for the containment reference list '{@link fr.imag.exschema.xtext.exSchema.Entity#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Entity#getAttributes()
   * @see #getEntity()
   * @generated
   */
  EReference getEntity_Attributes();

  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Set <em>Set</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Set</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Set
   * @generated
   */
  EClass getSet();

  /**
   * Returns the meta object for the containment reference list '{@link fr.imag.exschema.xtext.exSchema.Set#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Set#getEntities()
   * @see #getSet()
   * @generated
   */
  EReference getSet_Entities();

  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Struct <em>Struct</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Struct</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Struct
   * @generated
   */
  EClass getStruct();

  /**
   * Returns the meta object for the containment reference list '{@link fr.imag.exschema.xtext.exSchema.Struct#getEntities <em>Entities</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entities</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Struct#getEntities()
   * @see #getStruct()
   * @generated
   */
  EReference getStruct_Entities();

  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Relationship <em>Relationship</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relationship</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Relationship
   * @generated
   */
  EClass getRelationship();

  /**
   * Returns the meta object for the containment reference '{@link fr.imag.exschema.xtext.exSchema.Relationship#getStart <em>Start</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Start</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Relationship#getStart()
   * @see #getRelationship()
   * @generated
   */
  EReference getRelationship_Start();

  /**
   * Returns the meta object for the containment reference '{@link fr.imag.exschema.xtext.exSchema.Relationship#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>End</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Relationship#getEnd()
   * @see #getRelationship()
   * @generated
   */
  EReference getRelationship_End();

  /**
   * Returns the meta object for class '{@link fr.imag.exschema.xtext.exSchema.Attribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Attribute</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Attribute
   * @generated
   */
  EClass getAttribute();

  /**
   * Returns the meta object for the attribute '{@link fr.imag.exschema.xtext.exSchema.Attribute#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Attribute#getName()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Name();

  /**
   * Returns the meta object for the attribute '{@link fr.imag.exschema.xtext.exSchema.Attribute#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.imag.exschema.xtext.exSchema.Attribute#getValue()
   * @see #getAttribute()
   * @generated
   */
  EAttribute getAttribute_Value();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExSchemaFactory getExSchemaFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.SchemaImpl <em>Schema</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.SchemaImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getSchema()
     * @generated
     */
    EClass SCHEMA = eINSTANCE.getSchema();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__ATTRIBUTES = eINSTANCE.getSchema_Attributes();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCHEMA__ENTITIES = eINSTANCE.getSchema_Entities();

    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.EntityImpl <em>Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.EntityImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getEntity()
     * @generated
     */
    EClass ENTITY = eINSTANCE.getEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTITY__NAME = eINSTANCE.getEntity_Name();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTITY__ATTRIBUTES = eINSTANCE.getEntity_Attributes();

    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.SetImpl <em>Set</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.SetImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getSet()
     * @generated
     */
    EClass SET = eINSTANCE.getSet();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SET__ENTITIES = eINSTANCE.getSet_Entities();

    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.StructImpl <em>Struct</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.StructImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getStruct()
     * @generated
     */
    EClass STRUCT = eINSTANCE.getStruct();

    /**
     * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCT__ENTITIES = eINSTANCE.getStruct_Entities();

    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.RelationshipImpl <em>Relationship</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.RelationshipImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getRelationship()
     * @generated
     */
    EClass RELATIONSHIP = eINSTANCE.getRelationship();

    /**
     * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONSHIP__START = eINSTANCE.getRelationship_Start();

    /**
     * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONSHIP__END = eINSTANCE.getRelationship_End();

    /**
     * The meta object literal for the '{@link fr.imag.exschema.xtext.exSchema.impl.AttributeImpl <em>Attribute</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.imag.exschema.xtext.exSchema.impl.AttributeImpl
     * @see fr.imag.exschema.xtext.exSchema.impl.ExSchemaPackageImpl#getAttribute()
     * @generated
     */
    EClass ATTRIBUTE = eINSTANCE.getAttribute();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__NAME = eINSTANCE.getAttribute_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ATTRIBUTE__VALUE = eINSTANCE.getAttribute_Value();

  }

} //ExSchemaPackage
