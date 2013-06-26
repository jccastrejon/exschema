/*
* generated by Xtext
*/
grammar InternalExSchema;

options {
	superClass=AbstractInternalContentAssistParser;
	
}

@lexer::header {
package fr.imag.exschema.xtext.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

@parser::header {
package fr.imag.exschema.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import fr.imag.exschema.xtext.services.ExSchemaGrammarAccess;

}

@parser::members {
 
 	private ExSchemaGrammarAccess grammarAccess;
 	
    public void setGrammarAccess(ExSchemaGrammarAccess grammarAccess) {
    	this.grammarAccess = grammarAccess;
    }
    
    @Override
    protected Grammar getGrammar() {
    	return grammarAccess.getGrammar();
    }
    
    @Override
    protected String getValueForTokenName(String tokenName) {
    	return tokenName;
    }

}




// Entry rule entryRuleSchema
entryRuleSchema 
:
{ before(grammarAccess.getSchemaRule()); }
	 ruleSchema
{ after(grammarAccess.getSchemaRule()); } 
	 EOF 
;

// Rule Schema
ruleSchema
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSchemaAccess().getGroup()); }
(rule__Schema__Group__0)
{ after(grammarAccess.getSchemaAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleEntity
entryRuleEntity 
:
{ before(grammarAccess.getEntityRule()); }
	 ruleEntity
{ after(grammarAccess.getEntityRule()); } 
	 EOF 
;

// Rule Entity
ruleEntity
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getEntityAccess().getAlternatives()); }
(rule__Entity__Alternatives)
{ after(grammarAccess.getEntityAccess().getAlternatives()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleSet
entryRuleSet 
:
{ before(grammarAccess.getSetRule()); }
	 ruleSet
{ after(grammarAccess.getSetRule()); } 
	 EOF 
;

// Rule Set
ruleSet
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getSetAccess().getGroup()); }
(rule__Set__Group__0)
{ after(grammarAccess.getSetAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleStruct
entryRuleStruct 
:
{ before(grammarAccess.getStructRule()); }
	 ruleStruct
{ after(grammarAccess.getStructRule()); } 
	 EOF 
;

// Rule Struct
ruleStruct
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getStructAccess().getGroup()); }
(rule__Struct__Group__0)
{ after(grammarAccess.getStructAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleRelationship
entryRuleRelationship 
:
{ before(grammarAccess.getRelationshipRule()); }
	 ruleRelationship
{ after(grammarAccess.getRelationshipRule()); } 
	 EOF 
;

// Rule Relationship
ruleRelationship
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getRelationshipAccess().getGroup()); }
(rule__Relationship__Group__0)
{ after(grammarAccess.getRelationshipAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}



// Entry rule entryRuleAttribute
entryRuleAttribute 
:
{ before(grammarAccess.getAttributeRule()); }
	 ruleAttribute
{ after(grammarAccess.getAttributeRule()); } 
	 EOF 
;

// Rule Attribute
ruleAttribute
    @init {
		int stackSize = keepStackSize();
    }
	:
(
{ before(grammarAccess.getAttributeAccess().getGroup()); }
(rule__Attribute__Group__0)
{ after(grammarAccess.getAttributeAccess().getGroup()); }
)

;
finally {
	restoreStackSize(stackSize);
}




rule__Entity__Alternatives
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getEntityAccess().getSetParserRuleCall_0()); }
	ruleSet
{ after(grammarAccess.getEntityAccess().getSetParserRuleCall_0()); }
)

    |(
{ before(grammarAccess.getEntityAccess().getStructParserRuleCall_1()); }
	ruleStruct
{ after(grammarAccess.getEntityAccess().getStructParserRuleCall_1()); }
)

    |(
{ before(grammarAccess.getEntityAccess().getRelationshipParserRuleCall_2()); }
	ruleRelationship
{ after(grammarAccess.getEntityAccess().getRelationshipParserRuleCall_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}



rule__Schema__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Schema__Group__0__Impl
	rule__Schema__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getGroup_0()); }
(rule__Schema__Group_0__0)?
{ after(grammarAccess.getSchemaAccess().getGroup_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Schema__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Schema__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getEntitiesAssignment_1()); }
(rule__Schema__EntitiesAssignment_1)*
{ after(grammarAccess.getSchemaAccess().getEntitiesAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}






rule__Schema__Group_0__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Schema__Group_0__0__Impl
	rule__Schema__Group_0__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__Group_0__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0()); }

	'[' 

{ after(grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Schema__Group_0__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Schema__Group_0__1__Impl
	rule__Schema__Group_0__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__Group_0__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getAttributesAssignment_0_1()); }
(rule__Schema__AttributesAssignment_0_1)*
{ after(grammarAccess.getSchemaAccess().getAttributesAssignment_0_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Schema__Group_0__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Schema__Group_0__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__Group_0__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2()); }

	']' 

{ after(grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Set__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group__0__Impl
	rule__Set__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getSetKeyword_0()); }

	'Set' 

{ after(grammarAccess.getSetAccess().getSetKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group__1__Impl
	rule__Set__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getNameAssignment_1()); }
(rule__Set__NameAssignment_1)
{ after(grammarAccess.getSetAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group__2__Impl
	rule__Set__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getGroup_2()); }
(rule__Set__Group_2__0)?
{ after(grammarAccess.getSetAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getGroup_3()); }
(rule__Set__Group_3__0)?
{ after(grammarAccess.getSetAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Set__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_2__0__Impl
	rule__Set__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getLeftSquareBracketKeyword_2_0()); }

	'[' 

{ after(grammarAccess.getSetAccess().getLeftSquareBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_2__1__Impl
	rule__Set__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getAttributesAssignment_2_1()); }
(rule__Set__AttributesAssignment_2_1)*
{ after(grammarAccess.getSetAccess().getAttributesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getRightSquareBracketKeyword_2_2()); }

	']' 

{ after(grammarAccess.getSetAccess().getRightSquareBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Set__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_3__0__Impl
	rule__Set__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getLeftCurlyBracketKeyword_3_0()); }

	'{' 

{ after(grammarAccess.getSetAccess().getLeftCurlyBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_3__1__Impl
	rule__Set__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getEntitiesAssignment_3_1()); }
(rule__Set__EntitiesAssignment_3_1)*
{ after(grammarAccess.getSetAccess().getEntitiesAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Set__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Set__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Set__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getRightCurlyBracketKeyword_3_2()); }

	'}' 

{ after(grammarAccess.getSetAccess().getRightCurlyBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Struct__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group__0__Impl
	rule__Struct__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getStructKeyword_0()); }

	'Struct' 

{ after(grammarAccess.getStructAccess().getStructKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group__1__Impl
	rule__Struct__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getNameAssignment_1()); }
(rule__Struct__NameAssignment_1)
{ after(grammarAccess.getStructAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group__2__Impl
	rule__Struct__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getGroup_2()); }
(rule__Struct__Group_2__0)?
{ after(grammarAccess.getStructAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getGroup_3()); }
(rule__Struct__Group_3__0)?
{ after(grammarAccess.getStructAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Struct__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_2__0__Impl
	rule__Struct__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getLeftSquareBracketKeyword_2_0()); }

	'[' 

{ after(grammarAccess.getStructAccess().getLeftSquareBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_2__1__Impl
	rule__Struct__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getAttributesAssignment_2_1()); }
(rule__Struct__AttributesAssignment_2_1)*
{ after(grammarAccess.getStructAccess().getAttributesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getRightSquareBracketKeyword_2_2()); }

	']' 

{ after(grammarAccess.getStructAccess().getRightSquareBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Struct__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_3__0__Impl
	rule__Struct__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getLeftCurlyBracketKeyword_3_0()); }

	'{' 

{ after(grammarAccess.getStructAccess().getLeftCurlyBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_3__1__Impl
	rule__Struct__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getEntitiesAssignment_3_1()); }
(rule__Struct__EntitiesAssignment_3_1)*
{ after(grammarAccess.getStructAccess().getEntitiesAssignment_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Struct__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Struct__Group_3__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getRightCurlyBracketKeyword_3_2()); }

	'}' 

{ after(grammarAccess.getStructAccess().getRightCurlyBracketKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Relationship__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group__0__Impl
	rule__Relationship__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getRelationshipKeyword_0()); }

	'Relationship' 

{ after(grammarAccess.getRelationshipAccess().getRelationshipKeyword_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group__1__Impl
	rule__Relationship__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getNameAssignment_1()); }
(rule__Relationship__NameAssignment_1)
{ after(grammarAccess.getRelationshipAccess().getNameAssignment_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group__2__Impl
	rule__Relationship__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getGroup_2()); }
(rule__Relationship__Group_2__0)?
{ after(grammarAccess.getRelationshipAccess().getGroup_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getGroup_3()); }
(rule__Relationship__Group_3__0)?
{ after(grammarAccess.getRelationshipAccess().getGroup_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}










rule__Relationship__Group_2__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_2__0__Impl
	rule__Relationship__Group_2__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_2__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getLeftSquareBracketKeyword_2_0()); }

	'[' 

{ after(grammarAccess.getRelationshipAccess().getLeftSquareBracketKeyword_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_2__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_2__1__Impl
	rule__Relationship__Group_2__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_2__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getAttributesAssignment_2_1()); }
(rule__Relationship__AttributesAssignment_2_1)*
{ after(grammarAccess.getRelationshipAccess().getAttributesAssignment_2_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_2__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_2__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_2__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getRightSquareBracketKeyword_2_2()); }

	']' 

{ after(grammarAccess.getRelationshipAccess().getRightSquareBracketKeyword_2_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}








rule__Relationship__Group_3__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__0__Impl
	rule__Relationship__Group_3__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getLeftCurlyBracketKeyword_3_0()); }

	'{' 

{ after(grammarAccess.getRelationshipAccess().getLeftCurlyBracketKeyword_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__1__Impl
	rule__Relationship__Group_3__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getStartKeyword_3_1()); }

	'start' 

{ after(grammarAccess.getRelationshipAccess().getStartKeyword_3_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__2__Impl
	rule__Relationship__Group_3__3
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_2()); }

	'=' 

{ after(grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__3
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__3__Impl
	rule__Relationship__Group_3__4
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__3__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getStartAssignment_3_3()); }
(rule__Relationship__StartAssignment_3_3)
{ after(grammarAccess.getRelationshipAccess().getStartAssignment_3_3()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__4
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__4__Impl
	rule__Relationship__Group_3__5
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__4__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getEndKeyword_3_4()); }

	'end' 

{ after(grammarAccess.getRelationshipAccess().getEndKeyword_3_4()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__5
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__5__Impl
	rule__Relationship__Group_3__6
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__5__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_5()); }

	'=' 

{ after(grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_5()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__6
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__6__Impl
	rule__Relationship__Group_3__7
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__6__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getEndAssignment_3_6()); }
(rule__Relationship__EndAssignment_3_6)
{ after(grammarAccess.getRelationshipAccess().getEndAssignment_3_6()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Relationship__Group_3__7
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Relationship__Group_3__7__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__Group_3__7__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getRightCurlyBracketKeyword_3_7()); }

	'}' 

{ after(grammarAccess.getRelationshipAccess().getRightCurlyBracketKeyword_3_7()); }
)

;
finally {
	restoreStackSize(stackSize);
}


















rule__Attribute__Group__0
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__0__Impl
	rule__Attribute__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__0__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getNameAssignment_0()); }
(rule__Attribute__NameAssignment_0)
{ after(grammarAccess.getAttributeAccess().getNameAssignment_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attribute__Group__1
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__1__Impl
	rule__Attribute__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__1__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); }

	'=' 

{ after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); }
)

;
finally {
	restoreStackSize(stackSize);
}


rule__Attribute__Group__2
    @init {
		int stackSize = keepStackSize();
    }
:
	rule__Attribute__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__Group__2__Impl
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getValueAssignment_2()); }
(rule__Attribute__ValueAssignment_2)
{ after(grammarAccess.getAttributeAccess().getValueAssignment_2()); }
)

;
finally {
	restoreStackSize(stackSize);
}









rule__Schema__AttributesAssignment_0_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); }
	ruleAttribute{ after(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Schema__EntitiesAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); }
	ruleEntity{ after(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Set__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getSetAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Set__AttributesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
	ruleAttribute{ after(grammarAccess.getSetAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Set__EntitiesAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getSetAccess().getEntitiesEntityParserRuleCall_3_1_0()); }
	ruleEntity{ after(grammarAccess.getSetAccess().getEntitiesEntityParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getStructAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__AttributesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
	ruleAttribute{ after(grammarAccess.getStructAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Struct__EntitiesAssignment_3_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getStructAccess().getEntitiesEntityParserRuleCall_3_1_0()); }
	ruleEntity{ after(grammarAccess.getStructAccess().getEntitiesEntityParserRuleCall_3_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__NameAssignment_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
	RULE_ID{ after(grammarAccess.getRelationshipAccess().getNameIDTerminalRuleCall_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__AttributesAssignment_2_1
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
	ruleAttribute{ after(grammarAccess.getRelationshipAccess().getAttributesAttributeParserRuleCall_2_1_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__StartAssignment_3_3
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getStartEntityParserRuleCall_3_3_0()); }
	ruleEntity{ after(grammarAccess.getRelationshipAccess().getStartEntityParserRuleCall_3_3_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Relationship__EndAssignment_3_6
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getRelationshipAccess().getEndEntityParserRuleCall_3_6_0()); }
	ruleEntity{ after(grammarAccess.getRelationshipAccess().getEndEntityParserRuleCall_3_6_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__NameAssignment_0
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); }
	RULE_ID{ after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}

rule__Attribute__ValueAssignment_2
    @init {
		int stackSize = keepStackSize();
    }
:
(
{ before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); }
	RULE_STRING{ after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); }
)

;
finally {
	restoreStackSize(stackSize);
}


RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


