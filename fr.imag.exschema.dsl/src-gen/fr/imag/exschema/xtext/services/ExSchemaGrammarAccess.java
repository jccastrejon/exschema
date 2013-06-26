/*
* generated by Xtext
*/

package fr.imag.exschema.xtext.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;

import org.eclipse.xtext.common.services.TerminalsGrammarAccess;

@Singleton
public class ExSchemaGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class SchemaElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Schema");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group cGroup_0 = (Group)cGroup.eContents().get(0);
		private final Keyword cLeftSquareBracketKeyword_0_0 = (Keyword)cGroup_0.eContents().get(0);
		private final Assignment cAttributesAssignment_0_1 = (Assignment)cGroup_0.eContents().get(1);
		private final RuleCall cAttributesAttributeParserRuleCall_0_1_0 = (RuleCall)cAttributesAssignment_0_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_0_2 = (Keyword)cGroup_0.eContents().get(2);
		private final Assignment cEntitiesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cEntitiesEntityParserRuleCall_1_0 = (RuleCall)cEntitiesAssignment_1.eContents().get(0);
		
		//Schema:
		//	("[" attributes+=Attribute* "]")? entities+=Entity*;
		public ParserRule getRule() { return rule; }

		//("[" attributes+=Attribute* "]")? entities+=Entity*
		public Group getGroup() { return cGroup; }

		//("[" attributes+=Attribute* "]")?
		public Group getGroup_0() { return cGroup_0; }

		//"["
		public Keyword getLeftSquareBracketKeyword_0_0() { return cLeftSquareBracketKeyword_0_0; }

		//attributes+=Attribute*
		public Assignment getAttributesAssignment_0_1() { return cAttributesAssignment_0_1; }

		//Attribute
		public RuleCall getAttributesAttributeParserRuleCall_0_1_0() { return cAttributesAttributeParserRuleCall_0_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_0_2() { return cRightSquareBracketKeyword_0_2; }

		//entities+=Entity*
		public Assignment getEntitiesAssignment_1() { return cEntitiesAssignment_1; }

		//Entity
		public RuleCall getEntitiesEntityParserRuleCall_1_0() { return cEntitiesEntityParserRuleCall_1_0; }
	}

	public class EntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Entity");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSet_ParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cStruct_ParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cRelationship_ParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Entity:
		//	Set_ | Struct_ | Relationship_;
		public ParserRule getRule() { return rule; }

		//Set_ | Struct_ | Relationship_
		public Alternatives getAlternatives() { return cAlternatives; }

		//Set_
		public RuleCall getSet_ParserRuleCall_0() { return cSet_ParserRuleCall_0; }

		//Struct_
		public RuleCall getStruct_ParserRuleCall_1() { return cStruct_ParserRuleCall_1; }

		//Relationship_
		public RuleCall getRelationship_ParserRuleCall_2() { return cRelationship_ParserRuleCall_2; }
	}

	public class Set_Elements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Set_");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cSetKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cAttributesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cAttributesAttributeParserRuleCall_2_1_0 = (RuleCall)cAttributesAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cEntitiesAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cEntitiesEntityParserRuleCall_3_1_0 = (RuleCall)cEntitiesAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//Set_:
		//	"Set" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?;
		public ParserRule getRule() { return rule; }

		//"Set" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?
		public Group getGroup() { return cGroup; }

		//"Set"
		public Keyword getSetKeyword_0() { return cSetKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("[" attributes+=Attribute* "]")?
		public Group getGroup_2() { return cGroup_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_0() { return cLeftSquareBracketKeyword_2_0; }

		//attributes+=Attribute*
		public Assignment getAttributesAssignment_2_1() { return cAttributesAssignment_2_1; }

		//Attribute
		public RuleCall getAttributesAttributeParserRuleCall_2_1_0() { return cAttributesAttributeParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_2() { return cRightSquareBracketKeyword_2_2; }

		//("{" entities+=Entity* "}")?
		public Group getGroup_3() { return cGroup_3; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_0() { return cLeftCurlyBracketKeyword_3_0; }

		//entities+=Entity*
		public Assignment getEntitiesAssignment_3_1() { return cEntitiesAssignment_3_1; }

		//Entity
		public RuleCall getEntitiesEntityParserRuleCall_3_1_0() { return cEntitiesEntityParserRuleCall_3_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
	}

	public class Struct_Elements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Struct_");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cStructKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cAttributesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cAttributesAttributeParserRuleCall_2_1_0 = (RuleCall)cAttributesAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cEntitiesAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cEntitiesEntityParserRuleCall_3_1_0 = (RuleCall)cEntitiesAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		
		//Struct_:
		//	"Struct" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?;
		public ParserRule getRule() { return rule; }

		//"Struct" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?
		public Group getGroup() { return cGroup; }

		//"Struct"
		public Keyword getStructKeyword_0() { return cStructKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("[" attributes+=Attribute* "]")?
		public Group getGroup_2() { return cGroup_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_0() { return cLeftSquareBracketKeyword_2_0; }

		//attributes+=Attribute*
		public Assignment getAttributesAssignment_2_1() { return cAttributesAssignment_2_1; }

		//Attribute
		public RuleCall getAttributesAttributeParserRuleCall_2_1_0() { return cAttributesAttributeParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_2() { return cRightSquareBracketKeyword_2_2; }

		//("{" entities+=Entity* "}")?
		public Group getGroup_3() { return cGroup_3; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_0() { return cLeftCurlyBracketKeyword_3_0; }

		//entities+=Entity*
		public Assignment getEntitiesAssignment_3_1() { return cEntitiesAssignment_3_1; }

		//Entity
		public RuleCall getEntitiesEntityParserRuleCall_3_1_0() { return cEntitiesEntityParserRuleCall_3_1_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_2() { return cRightCurlyBracketKeyword_3_2; }
	}

	public class Relationship_Elements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Relationship_");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cRelationshipKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameIDTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Keyword cLeftSquareBracketKeyword_2_0 = (Keyword)cGroup_2.eContents().get(0);
		private final Assignment cAttributesAssignment_2_1 = (Assignment)cGroup_2.eContents().get(1);
		private final RuleCall cAttributesAttributeParserRuleCall_2_1_0 = (RuleCall)cAttributesAssignment_2_1.eContents().get(0);
		private final Keyword cRightSquareBracketKeyword_2_2 = (Keyword)cGroup_2.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cLeftCurlyBracketKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Keyword cStartKeyword_3_1 = (Keyword)cGroup_3.eContents().get(1);
		private final Keyword cEqualsSignKeyword_3_2 = (Keyword)cGroup_3.eContents().get(2);
		private final Assignment cStartAssignment_3_3 = (Assignment)cGroup_3.eContents().get(3);
		private final RuleCall cStartEntityParserRuleCall_3_3_0 = (RuleCall)cStartAssignment_3_3.eContents().get(0);
		private final Keyword cEndKeyword_3_4 = (Keyword)cGroup_3.eContents().get(4);
		private final Keyword cEqualsSignKeyword_3_5 = (Keyword)cGroup_3.eContents().get(5);
		private final Assignment cEndAssignment_3_6 = (Assignment)cGroup_3.eContents().get(6);
		private final RuleCall cEndEntityParserRuleCall_3_6_0 = (RuleCall)cEndAssignment_3_6.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3_7 = (Keyword)cGroup_3.eContents().get(7);
		
		//Relationship_:
		//	"Relationship" name=ID ("[" attributes+=Attribute* "]")? ("{" "start" "=" start=Entity "end" "=" end=Entity "}")?;
		public ParserRule getRule() { return rule; }

		//"Relationship" name=ID ("[" attributes+=Attribute* "]")? ("{" "start" "=" start=Entity "end" "=" end=Entity "}")?
		public Group getGroup() { return cGroup; }

		//"Relationship"
		public Keyword getRelationshipKeyword_0() { return cRelationshipKeyword_0; }

		//name=ID
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_1_0() { return cNameIDTerminalRuleCall_1_0; }

		//("[" attributes+=Attribute* "]")?
		public Group getGroup_2() { return cGroup_2; }

		//"["
		public Keyword getLeftSquareBracketKeyword_2_0() { return cLeftSquareBracketKeyword_2_0; }

		//attributes+=Attribute*
		public Assignment getAttributesAssignment_2_1() { return cAttributesAssignment_2_1; }

		//Attribute
		public RuleCall getAttributesAttributeParserRuleCall_2_1_0() { return cAttributesAttributeParserRuleCall_2_1_0; }

		//"]"
		public Keyword getRightSquareBracketKeyword_2_2() { return cRightSquareBracketKeyword_2_2; }

		//("{" "start" "=" start=Entity "end" "=" end=Entity "}")?
		public Group getGroup_3() { return cGroup_3; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_3_0() { return cLeftCurlyBracketKeyword_3_0; }

		//"start"
		public Keyword getStartKeyword_3_1() { return cStartKeyword_3_1; }

		//"="
		public Keyword getEqualsSignKeyword_3_2() { return cEqualsSignKeyword_3_2; }

		//start=Entity
		public Assignment getStartAssignment_3_3() { return cStartAssignment_3_3; }

		//Entity
		public RuleCall getStartEntityParserRuleCall_3_3_0() { return cStartEntityParserRuleCall_3_3_0; }

		//"end"
		public Keyword getEndKeyword_3_4() { return cEndKeyword_3_4; }

		//"="
		public Keyword getEqualsSignKeyword_3_5() { return cEqualsSignKeyword_3_5; }

		//end=Entity
		public Assignment getEndAssignment_3_6() { return cEndAssignment_3_6; }

		//Entity
		public RuleCall getEndEntityParserRuleCall_3_6_0() { return cEndEntityParserRuleCall_3_6_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3_7() { return cRightCurlyBracketKeyword_3_7; }
	}

	public class AttributeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Attribute");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Keyword cEqualsSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cValueAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cValueSTRINGTerminalRuleCall_2_0 = (RuleCall)cValueAssignment_2.eContents().get(0);
		
		//Attribute:
		//	name=ID "=" value=STRING;
		public ParserRule getRule() { return rule; }

		//name=ID "=" value=STRING
		public Group getGroup() { return cGroup; }

		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }

		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }

		//"="
		public Keyword getEqualsSignKeyword_1() { return cEqualsSignKeyword_1; }

		//value=STRING
		public Assignment getValueAssignment_2() { return cValueAssignment_2; }

		//STRING
		public RuleCall getValueSTRINGTerminalRuleCall_2_0() { return cValueSTRINGTerminalRuleCall_2_0; }
	}
	
	
	private SchemaElements pSchema;
	private EntityElements pEntity;
	private Set_Elements pSet_;
	private Struct_Elements pStruct_;
	private Relationship_Elements pRelationship_;
	private AttributeElements pAttribute;
	
	private final Grammar grammar;

	private TerminalsGrammarAccess gaTerminals;

	@Inject
	public ExSchemaGrammarAccess(GrammarProvider grammarProvider,
		TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("fr.imag.exschema.xtext.ExSchema".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Schema:
	//	("[" attributes+=Attribute* "]")? entities+=Entity*;
	public SchemaElements getSchemaAccess() {
		return (pSchema != null) ? pSchema : (pSchema = new SchemaElements());
	}
	
	public ParserRule getSchemaRule() {
		return getSchemaAccess().getRule();
	}

	//Entity:
	//	Set_ | Struct_ | Relationship_;
	public EntityElements getEntityAccess() {
		return (pEntity != null) ? pEntity : (pEntity = new EntityElements());
	}
	
	public ParserRule getEntityRule() {
		return getEntityAccess().getRule();
	}

	//Set_:
	//	"Set" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?;
	public Set_Elements getSet_Access() {
		return (pSet_ != null) ? pSet_ : (pSet_ = new Set_Elements());
	}
	
	public ParserRule getSet_Rule() {
		return getSet_Access().getRule();
	}

	//Struct_:
	//	"Struct" name=ID ("[" attributes+=Attribute* "]")? ("{" entities+=Entity* "}")?;
	public Struct_Elements getStruct_Access() {
		return (pStruct_ != null) ? pStruct_ : (pStruct_ = new Struct_Elements());
	}
	
	public ParserRule getStruct_Rule() {
		return getStruct_Access().getRule();
	}

	//Relationship_:
	//	"Relationship" name=ID ("[" attributes+=Attribute* "]")? ("{" "start" "=" start=Entity "end" "=" end=Entity "}")?;
	public Relationship_Elements getRelationship_Access() {
		return (pRelationship_ != null) ? pRelationship_ : (pRelationship_ = new Relationship_Elements());
	}
	
	public ParserRule getRelationship_Rule() {
		return getRelationship_Access().getRule();
	}

	//Attribute:
	//	name=ID "=" value=STRING;
	public AttributeElements getAttributeAccess() {
		return (pAttribute != null) ? pAttribute : (pAttribute = new AttributeElements());
	}
	
	public ParserRule getAttributeRule() {
		return getAttributeAccess().getRule();
	}

	//terminal ID:
	//	"^"? ("a".."z" | "A".."Z" | "_") ("a".."z" | "A".."Z" | "_" | "0".."9")*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	} 

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"" | "\'" ("\\" ("b" | "t" |
	//	"n" | "f" | "r" | "u" | "\"" | "\'" | "\\") | !("\\" | "\'"))* "\'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	} 

	//terminal ML_COMMENT:
	//	"/ *"->"* /";
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	} 

	//terminal SL_COMMENT:
	//	"//" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	} 
}
