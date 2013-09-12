/**
 */
package fr.imag.exschema.xtext.exSchema.impl;

import fr.imag.exschema.xtext.exSchema.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExSchemaFactoryImpl extends EFactoryImpl implements ExSchemaFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ExSchemaFactory init()
  {
    try
    {
      ExSchemaFactory theExSchemaFactory = (ExSchemaFactory)EPackage.Registry.INSTANCE.getEFactory(ExSchemaPackage.eNS_URI);
      if (theExSchemaFactory != null)
      {
        return theExSchemaFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ExSchemaFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExSchemaFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ExSchemaPackage.SCHEMA: return createSchema();
      case ExSchemaPackage.ENTITY: return createEntity();
      case ExSchemaPackage.SET_: return createSet_();
      case ExSchemaPackage.STRUCT_: return createStruct_();
      case ExSchemaPackage.RELATIONSHIP_: return createRelationship_();
      case ExSchemaPackage.ATTRIBUTE: return createAttribute();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Schema createSchema()
  {
    SchemaImpl schema = new SchemaImpl();
    return schema;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entity createEntity()
  {
    EntityImpl entity = new EntityImpl();
    return entity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Set_ createSet_()
  {
    Set_Impl set_ = new Set_Impl();
    return set_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Struct_ createStruct_()
  {
    Struct_Impl struct_ = new Struct_Impl();
    return struct_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Relationship_ createRelationship_()
  {
    Relationship_Impl relationship_ = new Relationship_Impl();
    return relationship_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExSchemaPackage getExSchemaPackage()
  {
    return (ExSchemaPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ExSchemaPackage getPackage()
  {
    return ExSchemaPackage.eINSTANCE;
  }

} //ExSchemaFactoryImpl
