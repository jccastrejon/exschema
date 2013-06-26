package fr.imag.exschema.xtext.serializer;

import com.google.inject.Inject;
import fr.imag.exschema.xtext.services.ExSchemaGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class ExSchemaSyntacticSequencer extends AbstractSyntacticSequencer {

	protected ExSchemaGrammarAccess grammarAccess;
	protected AbstractElementAlias match_Relationship___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q;
	protected AbstractElementAlias match_Schema___LeftSquareBracketKeyword_0_0_RightSquareBracketKeyword_0_2__q;
	protected AbstractElementAlias match_Set___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	protected AbstractElementAlias match_Set___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q;
	protected AbstractElementAlias match_Struct___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q;
	protected AbstractElementAlias match_Struct___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (ExSchemaGrammarAccess) access;
		match_Relationship___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRelationshipAccess().getLeftSquareBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getRelationshipAccess().getRightSquareBracketKeyword_2_2()));
		match_Schema___LeftSquareBracketKeyword_0_0_RightSquareBracketKeyword_0_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0()), new TokenAlias(false, false, grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2()));
		match_Set___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSetAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getSetAccess().getRightCurlyBracketKeyword_3_2()));
		match_Set___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSetAccess().getLeftSquareBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getSetAccess().getRightSquareBracketKeyword_2_2()));
		match_Struct___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStructAccess().getLeftCurlyBracketKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getStructAccess().getRightCurlyBracketKeyword_3_2()));
		match_Struct___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getStructAccess().getLeftSquareBracketKeyword_2_0()), new TokenAlias(false, false, grammarAccess.getStructAccess().getRightSquareBracketKeyword_2_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_Relationship___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q.equals(syntax))
				emit_Relationship___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Schema___LeftSquareBracketKeyword_0_0_RightSquareBracketKeyword_0_2__q.equals(syntax))
				emit_Schema___LeftSquareBracketKeyword_0_0_RightSquareBracketKeyword_0_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Set___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_Set___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Set___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q.equals(syntax))
				emit_Set___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Struct___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q.equals(syntax))
				emit_Struct___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_Struct___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q.equals(syntax))
				emit_Struct___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_Relationship___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_Schema___LeftSquareBracketKeyword_0_0_RightSquareBracketKeyword_0_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_Set___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_Set___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('{' '}')?
	 */
	protected void emit_Struct___LeftCurlyBracketKeyword_3_0_RightCurlyBracketKeyword_3_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('[' ']')?
	 */
	protected void emit_Struct___LeftSquareBracketKeyword_2_0_RightSquareBracketKeyword_2_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
