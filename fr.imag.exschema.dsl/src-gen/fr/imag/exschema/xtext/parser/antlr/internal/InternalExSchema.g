/*
* generated by Xtext
*/
grammar InternalExSchema;

options {
	superClass=AbstractInternalAntlrParser;
	
}

@lexer::header {
package fr.imag.exschema.xtext.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package fr.imag.exschema.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.imag.exschema.xtext.services.ExSchemaGrammarAccess;

}

@parser::members {

 	private ExSchemaGrammarAccess grammarAccess;
 	
    public InternalExSchemaParser(TokenStream input, ExSchemaGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Schema";	
   	}
   	
   	@Override
   	protected ExSchemaGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleSchema
entryRuleSchema returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSchemaRule()); }
	 iv_ruleSchema=ruleSchema 
	 { $current=$iv_ruleSchema.current; } 
	 EOF 
;

// Rule Schema
ruleSchema returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='[' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
	    }
		lv_attributes_1_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSchemaRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_1_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_2=']' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2());
    }
)?(
(
		{ 
	        newCompositeNode(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); 
	    }
		lv_entities_3_0=ruleEntity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSchemaRule());
	        }
       		add(
       			$current, 
       			"entities",
        		lv_entities_3_0, 
        		"Entity");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;





// Entry rule entryRuleEntity
entryRuleEntity returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEntityRule()); }
	 iv_ruleEntity=ruleEntity 
	 { $current=$iv_ruleEntity.current; } 
	 EOF 
;

// Rule Entity
ruleEntity returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getEntityAccess().getSetParserRuleCall_0()); 
    }
    this_Set_0=ruleSet
    { 
        $current = $this_Set_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEntityAccess().getStructParserRuleCall_1()); 
    }
    this_Struct_1=ruleStruct
    { 
        $current = $this_Struct_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
    { 
        newCompositeNode(grammarAccess.getEntityAccess().getRelationshipParserRuleCall_2()); 
    }
    this_Relationship_2=ruleRelationship
    { 
        $current = $this_Relationship_2.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleSet
entryRuleSet returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getSetRule()); }
	 iv_ruleSet=ruleSet 
	 { $current=$iv_ruleSet.current; } 
	 EOF 
;

// Rule Set
ruleSet returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Set' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getSetAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getSetRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSetAccess().getLeftSquareBracketKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSetAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
	    }
		lv_attributes_3_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSetRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_3_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getSetAccess().getRightSquareBracketKeyword_2_2());
    }
)?(	otherlv_5='{' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getSetAccess().getLeftCurlyBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSetAccess().getEntitiesEntityParserRuleCall_3_1_0()); 
	    }
		lv_entities_6_0=ruleEntity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSetRule());
	        }
       		add(
       			$current, 
       			"entities",
        		lv_entities_6_0, 
        		"Entity");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getSetAccess().getRightCurlyBracketKeyword_3_2());
    }
)?)
;





// Entry rule entryRuleStruct
entryRuleStruct returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getStructRule()); }
	 iv_ruleStruct=ruleStruct 
	 { $current=$iv_ruleStruct.current; } 
	 EOF 
;

// Rule Struct
ruleStruct returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Struct' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getStructAccess().getStructKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getStructAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getStructRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getStructAccess().getLeftSquareBracketKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStructAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
	    }
		lv_attributes_3_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStructRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_3_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getStructAccess().getRightSquareBracketKeyword_2_2());
    }
)?(	otherlv_5='{' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getStructAccess().getLeftCurlyBracketKeyword_3_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getStructAccess().getEntitiesEntityParserRuleCall_3_1_0()); 
	    }
		lv_entities_6_0=ruleEntity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getStructRule());
	        }
       		add(
       			$current, 
       			"entities",
        		lv_entities_6_0, 
        		"Entity");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_7='}' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getStructAccess().getRightCurlyBracketKeyword_3_2());
    }
)?)
;





// Entry rule entryRuleRelationship
entryRuleRelationship returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getRelationshipRule()); }
	 iv_ruleRelationship=ruleRelationship 
	 { $current=$iv_ruleRelationship.current; } 
	 EOF 
;

// Rule Relationship
ruleRelationship returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='Relationship' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getRelationshipAccess().getRelationshipKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getRelationshipAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getRelationshipRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)(	otherlv_2='[' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getRelationshipAccess().getLeftSquareBracketKeyword_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRelationshipAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
	    }
		lv_attributes_3_0=ruleAttribute		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRelationshipRule());
	        }
       		add(
       			$current, 
       			"attributes",
        		lv_attributes_3_0, 
        		"Attribute");
	        afterParserOrEnumRuleCall();
	    }

)
)*	otherlv_4=']' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getRelationshipAccess().getRightSquareBracketKeyword_2_2());
    }
)?(	otherlv_5='{' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getRelationshipAccess().getLeftCurlyBracketKeyword_3_0());
    }
	otherlv_6='start' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getRelationshipAccess().getStartKeyword_3_1());
    }
	otherlv_7='=' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_2());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRelationshipAccess().getStartEntityParserRuleCall_3_3_0()); 
	    }
		lv_start_8_0=ruleEntity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRelationshipRule());
	        }
       		set(
       			$current, 
       			"start",
        		lv_start_8_0, 
        		"Entity");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_9='end' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getRelationshipAccess().getEndKeyword_3_4());
    }
	otherlv_10='=' 
    {
    	newLeafNode(otherlv_10, grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_5());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getRelationshipAccess().getEndEntityParserRuleCall_3_6_0()); 
	    }
		lv_end_11_0=ruleEntity		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getRelationshipRule());
	        }
       		set(
       			$current, 
       			"end",
        		lv_end_11_0, 
        		"Entity");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_12='}' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getRelationshipAccess().getRightCurlyBracketKeyword_3_7());
    }
)?)
;





// Entry rule entryRuleAttribute
entryRuleAttribute returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getAttributeRule()); }
	 iv_ruleAttribute=ruleAttribute 
	 { $current=$iv_ruleAttribute.current; } 
	 EOF 
;

// Rule Attribute
ruleAttribute returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		lv_name_0_0=RULE_ID
		{
			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_0_0, 
        		"ID");
	    }

)
)	otherlv_1='=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1());
    }
(
(
		lv_value_2_0=RULE_STRING
		{
			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getAttributeRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"value",
        		lv_value_2_0, 
        		"STRING");
	    }

)
))
;





RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


