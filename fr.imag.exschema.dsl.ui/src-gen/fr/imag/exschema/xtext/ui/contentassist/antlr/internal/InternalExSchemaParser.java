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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExSchemaParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'Set'", "'{'", "'}'", "'Struct'", "'Relationship'", "'start'", "'='", "'end'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalExSchemaParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExSchemaParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExSchemaParser.tokenNames; }
    public String getGrammarFileName() { return "../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g"; }


     
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




    // $ANTLR start "entryRuleSchema"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:60:1: entryRuleSchema : ruleSchema EOF ;
    public final void entryRuleSchema() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:61:1: ( ruleSchema EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:62:1: ruleSchema EOF
            {
             before(grammarAccess.getSchemaRule()); 
            pushFollow(FOLLOW_ruleSchema_in_entryRuleSchema61);
            ruleSchema();

            state._fsp--;

             after(grammarAccess.getSchemaRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSchema68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:69:1: ruleSchema : ( ( rule__Schema__Group__0 ) ) ;
    public final void ruleSchema() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:73:2: ( ( ( rule__Schema__Group__0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:74:1: ( ( rule__Schema__Group__0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:74:1: ( ( rule__Schema__Group__0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:75:1: ( rule__Schema__Group__0 )
            {
             before(grammarAccess.getSchemaAccess().getGroup()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:76:1: ( rule__Schema__Group__0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:76:2: rule__Schema__Group__0
            {
            pushFollow(FOLLOW_rule__Schema__Group__0_in_ruleSchema94);
            rule__Schema__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSchemaAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleEntity"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:88:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:89:1: ( ruleEntity EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:90:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity121);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity128); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:97:1: ruleEntity : ( ( rule__Entity__Alternatives ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:101:2: ( ( ( rule__Entity__Alternatives ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:102:1: ( ( rule__Entity__Alternatives ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:102:1: ( ( rule__Entity__Alternatives ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:103:1: ( rule__Entity__Alternatives )
            {
             before(grammarAccess.getEntityAccess().getAlternatives()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:104:1: ( rule__Entity__Alternatives )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:104:2: rule__Entity__Alternatives
            {
            pushFollow(FOLLOW_rule__Entity__Alternatives_in_ruleEntity154);
            rule__Entity__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEntityAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSet_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:116:1: entryRuleSet_ : ruleSet_ EOF ;
    public final void entryRuleSet_() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:117:1: ( ruleSet_ EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:118:1: ruleSet_ EOF
            {
             before(grammarAccess.getSet_Rule()); 
            pushFollow(FOLLOW_ruleSet__in_entryRuleSet_181);
            ruleSet_();

            state._fsp--;

             after(grammarAccess.getSet_Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSet_188); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSet_"


    // $ANTLR start "ruleSet_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:125:1: ruleSet_ : ( ( rule__Set___Group__0 ) ) ;
    public final void ruleSet_() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:129:2: ( ( ( rule__Set___Group__0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:130:1: ( ( rule__Set___Group__0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:130:1: ( ( rule__Set___Group__0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:131:1: ( rule__Set___Group__0 )
            {
             before(grammarAccess.getSet_Access().getGroup()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:132:1: ( rule__Set___Group__0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:132:2: rule__Set___Group__0
            {
            pushFollow(FOLLOW_rule__Set___Group__0_in_ruleSet_214);
            rule__Set___Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSet_Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSet_"


    // $ANTLR start "entryRuleStruct_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:144:1: entryRuleStruct_ : ruleStruct_ EOF ;
    public final void entryRuleStruct_() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:145:1: ( ruleStruct_ EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:146:1: ruleStruct_ EOF
            {
             before(grammarAccess.getStruct_Rule()); 
            pushFollow(FOLLOW_ruleStruct__in_entryRuleStruct_241);
            ruleStruct_();

            state._fsp--;

             after(grammarAccess.getStruct_Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStruct_248); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStruct_"


    // $ANTLR start "ruleStruct_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:153:1: ruleStruct_ : ( ( rule__Struct___Group__0 ) ) ;
    public final void ruleStruct_() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:157:2: ( ( ( rule__Struct___Group__0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:158:1: ( ( rule__Struct___Group__0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:158:1: ( ( rule__Struct___Group__0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:159:1: ( rule__Struct___Group__0 )
            {
             before(grammarAccess.getStruct_Access().getGroup()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:160:1: ( rule__Struct___Group__0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:160:2: rule__Struct___Group__0
            {
            pushFollow(FOLLOW_rule__Struct___Group__0_in_ruleStruct_274);
            rule__Struct___Group__0();

            state._fsp--;


            }

             after(grammarAccess.getStruct_Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStruct_"


    // $ANTLR start "entryRuleRelationship_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:172:1: entryRuleRelationship_ : ruleRelationship_ EOF ;
    public final void entryRuleRelationship_() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:173:1: ( ruleRelationship_ EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:174:1: ruleRelationship_ EOF
            {
             before(grammarAccess.getRelationship_Rule()); 
            pushFollow(FOLLOW_ruleRelationship__in_entryRuleRelationship_301);
            ruleRelationship_();

            state._fsp--;

             after(grammarAccess.getRelationship_Rule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationship_308); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRelationship_"


    // $ANTLR start "ruleRelationship_"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:181:1: ruleRelationship_ : ( ( rule__Relationship___Group__0 ) ) ;
    public final void ruleRelationship_() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:185:2: ( ( ( rule__Relationship___Group__0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:186:1: ( ( rule__Relationship___Group__0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:186:1: ( ( rule__Relationship___Group__0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:187:1: ( rule__Relationship___Group__0 )
            {
             before(grammarAccess.getRelationship_Access().getGroup()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:188:1: ( rule__Relationship___Group__0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:188:2: rule__Relationship___Group__0
            {
            pushFollow(FOLLOW_rule__Relationship___Group__0_in_ruleRelationship_334);
            rule__Relationship___Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRelationship_Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelationship_"


    // $ANTLR start "entryRuleAttribute"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:200:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:201:1: ( ruleAttribute EOF )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:202:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute361);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute368); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:209:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:213:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:214:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:214:1: ( ( rule__Attribute__Group__0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:215:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:216:1: ( rule__Attribute__Group__0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:216:2: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_rule__Attribute__Group__0_in_ruleAttribute394);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "rule__Entity__Alternatives"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:228:1: rule__Entity__Alternatives : ( ( ruleSet_ ) | ( ruleStruct_ ) | ( ruleRelationship_ ) );
    public final void rule__Entity__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:232:1: ( ( ruleSet_ ) | ( ruleStruct_ ) | ( ruleRelationship_ ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt1=1;
                }
                break;
            case 16:
                {
                alt1=2;
                }
                break;
            case 17:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:233:1: ( ruleSet_ )
                    {
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:233:1: ( ruleSet_ )
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:234:1: ruleSet_
                    {
                     before(grammarAccess.getEntityAccess().getSet_ParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSet__in_rule__Entity__Alternatives430);
                    ruleSet_();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getSet_ParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:239:6: ( ruleStruct_ )
                    {
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:239:6: ( ruleStruct_ )
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:240:1: ruleStruct_
                    {
                     before(grammarAccess.getEntityAccess().getStruct_ParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleStruct__in_rule__Entity__Alternatives447);
                    ruleStruct_();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getStruct_ParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:245:6: ( ruleRelationship_ )
                    {
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:245:6: ( ruleRelationship_ )
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:246:1: ruleRelationship_
                    {
                     before(grammarAccess.getEntityAccess().getRelationship_ParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleRelationship__in_rule__Entity__Alternatives464);
                    ruleRelationship_();

                    state._fsp--;

                     after(grammarAccess.getEntityAccess().getRelationship_ParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Entity__Alternatives"


    // $ANTLR start "rule__Schema__Group__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:258:1: rule__Schema__Group__0 : rule__Schema__Group__0__Impl rule__Schema__Group__1 ;
    public final void rule__Schema__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:262:1: ( rule__Schema__Group__0__Impl rule__Schema__Group__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:263:2: rule__Schema__Group__0__Impl rule__Schema__Group__1
            {
            pushFollow(FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0494);
            rule__Schema__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0497);
            rule__Schema__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0"


    // $ANTLR start "rule__Schema__Group__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:270:1: rule__Schema__Group__0__Impl : ( ( rule__Schema__Group_0__0 )? ) ;
    public final void rule__Schema__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:274:1: ( ( ( rule__Schema__Group_0__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:275:1: ( ( rule__Schema__Group_0__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:275:1: ( ( rule__Schema__Group_0__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:276:1: ( rule__Schema__Group_0__0 )?
            {
             before(grammarAccess.getSchemaAccess().getGroup_0()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:277:1: ( rule__Schema__Group_0__0 )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:277:2: rule__Schema__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__Schema__Group_0__0_in_rule__Schema__Group__0__Impl524);
                    rule__Schema__Group_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSchemaAccess().getGroup_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__0__Impl"


    // $ANTLR start "rule__Schema__Group__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:287:1: rule__Schema__Group__1 : rule__Schema__Group__1__Impl ;
    public final void rule__Schema__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:291:1: ( rule__Schema__Group__1__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:292:2: rule__Schema__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1555);
            rule__Schema__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1"


    // $ANTLR start "rule__Schema__Group__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:298:1: rule__Schema__Group__1__Impl : ( ( rule__Schema__EntitiesAssignment_1 )* ) ;
    public final void rule__Schema__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:302:1: ( ( ( rule__Schema__EntitiesAssignment_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:303:1: ( ( rule__Schema__EntitiesAssignment_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:303:1: ( ( rule__Schema__EntitiesAssignment_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:304:1: ( rule__Schema__EntitiesAssignment_1 )*
            {
             before(grammarAccess.getSchemaAccess().getEntitiesAssignment_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:305:1: ( rule__Schema__EntitiesAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13||(LA3_0>=16 && LA3_0<=17)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:305:2: rule__Schema__EntitiesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Schema__EntitiesAssignment_1_in_rule__Schema__Group__1__Impl582);
            	    rule__Schema__EntitiesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getEntitiesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group__1__Impl"


    // $ANTLR start "rule__Schema__Group_0__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:319:1: rule__Schema__Group_0__0 : rule__Schema__Group_0__0__Impl rule__Schema__Group_0__1 ;
    public final void rule__Schema__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:323:1: ( rule__Schema__Group_0__0__Impl rule__Schema__Group_0__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:324:2: rule__Schema__Group_0__0__Impl rule__Schema__Group_0__1
            {
            pushFollow(FOLLOW_rule__Schema__Group_0__0__Impl_in_rule__Schema__Group_0__0617);
            rule__Schema__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Schema__Group_0__1_in_rule__Schema__Group_0__0620);
            rule__Schema__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__0"


    // $ANTLR start "rule__Schema__Group_0__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:331:1: rule__Schema__Group_0__0__Impl : ( '[' ) ;
    public final void rule__Schema__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:335:1: ( ( '[' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:336:1: ( '[' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:336:1: ( '[' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:337:1: '['
            {
             before(grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0()); 
            match(input,11,FOLLOW_11_in_rule__Schema__Group_0__0__Impl648); 
             after(grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__0__Impl"


    // $ANTLR start "rule__Schema__Group_0__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:350:1: rule__Schema__Group_0__1 : rule__Schema__Group_0__1__Impl rule__Schema__Group_0__2 ;
    public final void rule__Schema__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:354:1: ( rule__Schema__Group_0__1__Impl rule__Schema__Group_0__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:355:2: rule__Schema__Group_0__1__Impl rule__Schema__Group_0__2
            {
            pushFollow(FOLLOW_rule__Schema__Group_0__1__Impl_in_rule__Schema__Group_0__1679);
            rule__Schema__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Schema__Group_0__2_in_rule__Schema__Group_0__1682);
            rule__Schema__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__1"


    // $ANTLR start "rule__Schema__Group_0__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:362:1: rule__Schema__Group_0__1__Impl : ( ( rule__Schema__AttributesAssignment_0_1 )* ) ;
    public final void rule__Schema__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:366:1: ( ( ( rule__Schema__AttributesAssignment_0_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:367:1: ( ( rule__Schema__AttributesAssignment_0_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:367:1: ( ( rule__Schema__AttributesAssignment_0_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:368:1: ( rule__Schema__AttributesAssignment_0_1 )*
            {
             before(grammarAccess.getSchemaAccess().getAttributesAssignment_0_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:369:1: ( rule__Schema__AttributesAssignment_0_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==RULE_ID) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:369:2: rule__Schema__AttributesAssignment_0_1
            	    {
            	    pushFollow(FOLLOW_rule__Schema__AttributesAssignment_0_1_in_rule__Schema__Group_0__1__Impl709);
            	    rule__Schema__AttributesAssignment_0_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getSchemaAccess().getAttributesAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__1__Impl"


    // $ANTLR start "rule__Schema__Group_0__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:379:1: rule__Schema__Group_0__2 : rule__Schema__Group_0__2__Impl ;
    public final void rule__Schema__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:383:1: ( rule__Schema__Group_0__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:384:2: rule__Schema__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__Schema__Group_0__2__Impl_in_rule__Schema__Group_0__2740);
            rule__Schema__Group_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__2"


    // $ANTLR start "rule__Schema__Group_0__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:390:1: rule__Schema__Group_0__2__Impl : ( ']' ) ;
    public final void rule__Schema__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:394:1: ( ( ']' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:395:1: ( ']' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:395:1: ( ']' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:396:1: ']'
            {
             before(grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2()); 
            match(input,12,FOLLOW_12_in_rule__Schema__Group_0__2__Impl768); 
             after(grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__Group_0__2__Impl"


    // $ANTLR start "rule__Set___Group__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:415:1: rule__Set___Group__0 : rule__Set___Group__0__Impl rule__Set___Group__1 ;
    public final void rule__Set___Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:419:1: ( rule__Set___Group__0__Impl rule__Set___Group__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:420:2: rule__Set___Group__0__Impl rule__Set___Group__1
            {
            pushFollow(FOLLOW_rule__Set___Group__0__Impl_in_rule__Set___Group__0805);
            rule__Set___Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group__1_in_rule__Set___Group__0808);
            rule__Set___Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__0"


    // $ANTLR start "rule__Set___Group__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:427:1: rule__Set___Group__0__Impl : ( 'Set' ) ;
    public final void rule__Set___Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:431:1: ( ( 'Set' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:432:1: ( 'Set' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:432:1: ( 'Set' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:433:1: 'Set'
            {
             before(grammarAccess.getSet_Access().getSetKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Set___Group__0__Impl836); 
             after(grammarAccess.getSet_Access().getSetKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__0__Impl"


    // $ANTLR start "rule__Set___Group__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:446:1: rule__Set___Group__1 : rule__Set___Group__1__Impl rule__Set___Group__2 ;
    public final void rule__Set___Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:450:1: ( rule__Set___Group__1__Impl rule__Set___Group__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:451:2: rule__Set___Group__1__Impl rule__Set___Group__2
            {
            pushFollow(FOLLOW_rule__Set___Group__1__Impl_in_rule__Set___Group__1867);
            rule__Set___Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group__2_in_rule__Set___Group__1870);
            rule__Set___Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__1"


    // $ANTLR start "rule__Set___Group__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:458:1: rule__Set___Group__1__Impl : ( ( rule__Set___NameAssignment_1 ) ) ;
    public final void rule__Set___Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:462:1: ( ( ( rule__Set___NameAssignment_1 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:463:1: ( ( rule__Set___NameAssignment_1 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:463:1: ( ( rule__Set___NameAssignment_1 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:464:1: ( rule__Set___NameAssignment_1 )
            {
             before(grammarAccess.getSet_Access().getNameAssignment_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:465:1: ( rule__Set___NameAssignment_1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:465:2: rule__Set___NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Set___NameAssignment_1_in_rule__Set___Group__1__Impl897);
            rule__Set___NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSet_Access().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__1__Impl"


    // $ANTLR start "rule__Set___Group__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:475:1: rule__Set___Group__2 : rule__Set___Group__2__Impl rule__Set___Group__3 ;
    public final void rule__Set___Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:479:1: ( rule__Set___Group__2__Impl rule__Set___Group__3 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:480:2: rule__Set___Group__2__Impl rule__Set___Group__3
            {
            pushFollow(FOLLOW_rule__Set___Group__2__Impl_in_rule__Set___Group__2927);
            rule__Set___Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group__3_in_rule__Set___Group__2930);
            rule__Set___Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__2"


    // $ANTLR start "rule__Set___Group__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:487:1: rule__Set___Group__2__Impl : ( ( rule__Set___Group_2__0 )? ) ;
    public final void rule__Set___Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:491:1: ( ( ( rule__Set___Group_2__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:492:1: ( ( rule__Set___Group_2__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:492:1: ( ( rule__Set___Group_2__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:493:1: ( rule__Set___Group_2__0 )?
            {
             before(grammarAccess.getSet_Access().getGroup_2()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:494:1: ( rule__Set___Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:494:2: rule__Set___Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Set___Group_2__0_in_rule__Set___Group__2__Impl957);
                    rule__Set___Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSet_Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__2__Impl"


    // $ANTLR start "rule__Set___Group__3"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:504:1: rule__Set___Group__3 : rule__Set___Group__3__Impl ;
    public final void rule__Set___Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:508:1: ( rule__Set___Group__3__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:509:2: rule__Set___Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Set___Group__3__Impl_in_rule__Set___Group__3988);
            rule__Set___Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__3"


    // $ANTLR start "rule__Set___Group__3__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:515:1: rule__Set___Group__3__Impl : ( ( rule__Set___Group_3__0 )? ) ;
    public final void rule__Set___Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:519:1: ( ( ( rule__Set___Group_3__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:520:1: ( ( rule__Set___Group_3__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:520:1: ( ( rule__Set___Group_3__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:521:1: ( rule__Set___Group_3__0 )?
            {
             before(grammarAccess.getSet_Access().getGroup_3()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:522:1: ( rule__Set___Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==14) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:522:2: rule__Set___Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Set___Group_3__0_in_rule__Set___Group__3__Impl1015);
                    rule__Set___Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSet_Access().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group__3__Impl"


    // $ANTLR start "rule__Set___Group_2__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:540:1: rule__Set___Group_2__0 : rule__Set___Group_2__0__Impl rule__Set___Group_2__1 ;
    public final void rule__Set___Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:544:1: ( rule__Set___Group_2__0__Impl rule__Set___Group_2__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:545:2: rule__Set___Group_2__0__Impl rule__Set___Group_2__1
            {
            pushFollow(FOLLOW_rule__Set___Group_2__0__Impl_in_rule__Set___Group_2__01054);
            rule__Set___Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group_2__1_in_rule__Set___Group_2__01057);
            rule__Set___Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__0"


    // $ANTLR start "rule__Set___Group_2__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:552:1: rule__Set___Group_2__0__Impl : ( '[' ) ;
    public final void rule__Set___Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:556:1: ( ( '[' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:557:1: ( '[' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:557:1: ( '[' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:558:1: '['
            {
             before(grammarAccess.getSet_Access().getLeftSquareBracketKeyword_2_0()); 
            match(input,11,FOLLOW_11_in_rule__Set___Group_2__0__Impl1085); 
             after(grammarAccess.getSet_Access().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__0__Impl"


    // $ANTLR start "rule__Set___Group_2__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:571:1: rule__Set___Group_2__1 : rule__Set___Group_2__1__Impl rule__Set___Group_2__2 ;
    public final void rule__Set___Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:575:1: ( rule__Set___Group_2__1__Impl rule__Set___Group_2__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:576:2: rule__Set___Group_2__1__Impl rule__Set___Group_2__2
            {
            pushFollow(FOLLOW_rule__Set___Group_2__1__Impl_in_rule__Set___Group_2__11116);
            rule__Set___Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group_2__2_in_rule__Set___Group_2__11119);
            rule__Set___Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__1"


    // $ANTLR start "rule__Set___Group_2__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:583:1: rule__Set___Group_2__1__Impl : ( ( rule__Set___AttributesAssignment_2_1 )* ) ;
    public final void rule__Set___Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:587:1: ( ( ( rule__Set___AttributesAssignment_2_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:588:1: ( ( rule__Set___AttributesAssignment_2_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:588:1: ( ( rule__Set___AttributesAssignment_2_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:589:1: ( rule__Set___AttributesAssignment_2_1 )*
            {
             before(grammarAccess.getSet_Access().getAttributesAssignment_2_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:590:1: ( rule__Set___AttributesAssignment_2_1 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ID) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:590:2: rule__Set___AttributesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Set___AttributesAssignment_2_1_in_rule__Set___Group_2__1__Impl1146);
            	    rule__Set___AttributesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

             after(grammarAccess.getSet_Access().getAttributesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__1__Impl"


    // $ANTLR start "rule__Set___Group_2__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:600:1: rule__Set___Group_2__2 : rule__Set___Group_2__2__Impl ;
    public final void rule__Set___Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:604:1: ( rule__Set___Group_2__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:605:2: rule__Set___Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Set___Group_2__2__Impl_in_rule__Set___Group_2__21177);
            rule__Set___Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__2"


    // $ANTLR start "rule__Set___Group_2__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:611:1: rule__Set___Group_2__2__Impl : ( ']' ) ;
    public final void rule__Set___Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:615:1: ( ( ']' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:616:1: ( ']' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:616:1: ( ']' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:617:1: ']'
            {
             before(grammarAccess.getSet_Access().getRightSquareBracketKeyword_2_2()); 
            match(input,12,FOLLOW_12_in_rule__Set___Group_2__2__Impl1205); 
             after(grammarAccess.getSet_Access().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_2__2__Impl"


    // $ANTLR start "rule__Set___Group_3__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:636:1: rule__Set___Group_3__0 : rule__Set___Group_3__0__Impl rule__Set___Group_3__1 ;
    public final void rule__Set___Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:640:1: ( rule__Set___Group_3__0__Impl rule__Set___Group_3__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:641:2: rule__Set___Group_3__0__Impl rule__Set___Group_3__1
            {
            pushFollow(FOLLOW_rule__Set___Group_3__0__Impl_in_rule__Set___Group_3__01242);
            rule__Set___Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group_3__1_in_rule__Set___Group_3__01245);
            rule__Set___Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__0"


    // $ANTLR start "rule__Set___Group_3__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:648:1: rule__Set___Group_3__0__Impl : ( '{' ) ;
    public final void rule__Set___Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:652:1: ( ( '{' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:653:1: ( '{' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:653:1: ( '{' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:654:1: '{'
            {
             before(grammarAccess.getSet_Access().getLeftCurlyBracketKeyword_3_0()); 
            match(input,14,FOLLOW_14_in_rule__Set___Group_3__0__Impl1273); 
             after(grammarAccess.getSet_Access().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__0__Impl"


    // $ANTLR start "rule__Set___Group_3__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:667:1: rule__Set___Group_3__1 : rule__Set___Group_3__1__Impl rule__Set___Group_3__2 ;
    public final void rule__Set___Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:671:1: ( rule__Set___Group_3__1__Impl rule__Set___Group_3__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:672:2: rule__Set___Group_3__1__Impl rule__Set___Group_3__2
            {
            pushFollow(FOLLOW_rule__Set___Group_3__1__Impl_in_rule__Set___Group_3__11304);
            rule__Set___Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Set___Group_3__2_in_rule__Set___Group_3__11307);
            rule__Set___Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__1"


    // $ANTLR start "rule__Set___Group_3__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:679:1: rule__Set___Group_3__1__Impl : ( ( rule__Set___EntitiesAssignment_3_1 )* ) ;
    public final void rule__Set___Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:683:1: ( ( ( rule__Set___EntitiesAssignment_3_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:684:1: ( ( rule__Set___EntitiesAssignment_3_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:684:1: ( ( rule__Set___EntitiesAssignment_3_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:685:1: ( rule__Set___EntitiesAssignment_3_1 )*
            {
             before(grammarAccess.getSet_Access().getEntitiesAssignment_3_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:686:1: ( rule__Set___EntitiesAssignment_3_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==13||(LA8_0>=16 && LA8_0<=17)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:686:2: rule__Set___EntitiesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__Set___EntitiesAssignment_3_1_in_rule__Set___Group_3__1__Impl1334);
            	    rule__Set___EntitiesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getSet_Access().getEntitiesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__1__Impl"


    // $ANTLR start "rule__Set___Group_3__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:696:1: rule__Set___Group_3__2 : rule__Set___Group_3__2__Impl ;
    public final void rule__Set___Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:700:1: ( rule__Set___Group_3__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:701:2: rule__Set___Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Set___Group_3__2__Impl_in_rule__Set___Group_3__21365);
            rule__Set___Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__2"


    // $ANTLR start "rule__Set___Group_3__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:707:1: rule__Set___Group_3__2__Impl : ( '}' ) ;
    public final void rule__Set___Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:711:1: ( ( '}' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:712:1: ( '}' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:712:1: ( '}' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:713:1: '}'
            {
             before(grammarAccess.getSet_Access().getRightCurlyBracketKeyword_3_2()); 
            match(input,15,FOLLOW_15_in_rule__Set___Group_3__2__Impl1393); 
             after(grammarAccess.getSet_Access().getRightCurlyBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___Group_3__2__Impl"


    // $ANTLR start "rule__Struct___Group__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:732:1: rule__Struct___Group__0 : rule__Struct___Group__0__Impl rule__Struct___Group__1 ;
    public final void rule__Struct___Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:736:1: ( rule__Struct___Group__0__Impl rule__Struct___Group__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:737:2: rule__Struct___Group__0__Impl rule__Struct___Group__1
            {
            pushFollow(FOLLOW_rule__Struct___Group__0__Impl_in_rule__Struct___Group__01430);
            rule__Struct___Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group__1_in_rule__Struct___Group__01433);
            rule__Struct___Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__0"


    // $ANTLR start "rule__Struct___Group__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:744:1: rule__Struct___Group__0__Impl : ( 'Struct' ) ;
    public final void rule__Struct___Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:748:1: ( ( 'Struct' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:749:1: ( 'Struct' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:749:1: ( 'Struct' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:750:1: 'Struct'
            {
             before(grammarAccess.getStruct_Access().getStructKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Struct___Group__0__Impl1461); 
             after(grammarAccess.getStruct_Access().getStructKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__0__Impl"


    // $ANTLR start "rule__Struct___Group__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:763:1: rule__Struct___Group__1 : rule__Struct___Group__1__Impl rule__Struct___Group__2 ;
    public final void rule__Struct___Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:767:1: ( rule__Struct___Group__1__Impl rule__Struct___Group__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:768:2: rule__Struct___Group__1__Impl rule__Struct___Group__2
            {
            pushFollow(FOLLOW_rule__Struct___Group__1__Impl_in_rule__Struct___Group__11492);
            rule__Struct___Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group__2_in_rule__Struct___Group__11495);
            rule__Struct___Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__1"


    // $ANTLR start "rule__Struct___Group__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:775:1: rule__Struct___Group__1__Impl : ( ( rule__Struct___NameAssignment_1 ) ) ;
    public final void rule__Struct___Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:779:1: ( ( ( rule__Struct___NameAssignment_1 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:780:1: ( ( rule__Struct___NameAssignment_1 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:780:1: ( ( rule__Struct___NameAssignment_1 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:781:1: ( rule__Struct___NameAssignment_1 )
            {
             before(grammarAccess.getStruct_Access().getNameAssignment_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:782:1: ( rule__Struct___NameAssignment_1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:782:2: rule__Struct___NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Struct___NameAssignment_1_in_rule__Struct___Group__1__Impl1522);
            rule__Struct___NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getStruct_Access().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__1__Impl"


    // $ANTLR start "rule__Struct___Group__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:792:1: rule__Struct___Group__2 : rule__Struct___Group__2__Impl rule__Struct___Group__3 ;
    public final void rule__Struct___Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:796:1: ( rule__Struct___Group__2__Impl rule__Struct___Group__3 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:797:2: rule__Struct___Group__2__Impl rule__Struct___Group__3
            {
            pushFollow(FOLLOW_rule__Struct___Group__2__Impl_in_rule__Struct___Group__21552);
            rule__Struct___Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group__3_in_rule__Struct___Group__21555);
            rule__Struct___Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__2"


    // $ANTLR start "rule__Struct___Group__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:804:1: rule__Struct___Group__2__Impl : ( ( rule__Struct___Group_2__0 )? ) ;
    public final void rule__Struct___Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:808:1: ( ( ( rule__Struct___Group_2__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:809:1: ( ( rule__Struct___Group_2__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:809:1: ( ( rule__Struct___Group_2__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:810:1: ( rule__Struct___Group_2__0 )?
            {
             before(grammarAccess.getStruct_Access().getGroup_2()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:811:1: ( rule__Struct___Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==11) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:811:2: rule__Struct___Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Struct___Group_2__0_in_rule__Struct___Group__2__Impl1582);
                    rule__Struct___Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStruct_Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__2__Impl"


    // $ANTLR start "rule__Struct___Group__3"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:821:1: rule__Struct___Group__3 : rule__Struct___Group__3__Impl ;
    public final void rule__Struct___Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:825:1: ( rule__Struct___Group__3__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:826:2: rule__Struct___Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Struct___Group__3__Impl_in_rule__Struct___Group__31613);
            rule__Struct___Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__3"


    // $ANTLR start "rule__Struct___Group__3__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:832:1: rule__Struct___Group__3__Impl : ( ( rule__Struct___Group_3__0 )? ) ;
    public final void rule__Struct___Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:836:1: ( ( ( rule__Struct___Group_3__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:837:1: ( ( rule__Struct___Group_3__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:837:1: ( ( rule__Struct___Group_3__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:838:1: ( rule__Struct___Group_3__0 )?
            {
             before(grammarAccess.getStruct_Access().getGroup_3()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:839:1: ( rule__Struct___Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==14) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:839:2: rule__Struct___Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Struct___Group_3__0_in_rule__Struct___Group__3__Impl1640);
                    rule__Struct___Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getStruct_Access().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group__3__Impl"


    // $ANTLR start "rule__Struct___Group_2__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:857:1: rule__Struct___Group_2__0 : rule__Struct___Group_2__0__Impl rule__Struct___Group_2__1 ;
    public final void rule__Struct___Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:861:1: ( rule__Struct___Group_2__0__Impl rule__Struct___Group_2__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:862:2: rule__Struct___Group_2__0__Impl rule__Struct___Group_2__1
            {
            pushFollow(FOLLOW_rule__Struct___Group_2__0__Impl_in_rule__Struct___Group_2__01679);
            rule__Struct___Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group_2__1_in_rule__Struct___Group_2__01682);
            rule__Struct___Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__0"


    // $ANTLR start "rule__Struct___Group_2__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:869:1: rule__Struct___Group_2__0__Impl : ( '[' ) ;
    public final void rule__Struct___Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:873:1: ( ( '[' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:874:1: ( '[' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:874:1: ( '[' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:875:1: '['
            {
             before(grammarAccess.getStruct_Access().getLeftSquareBracketKeyword_2_0()); 
            match(input,11,FOLLOW_11_in_rule__Struct___Group_2__0__Impl1710); 
             after(grammarAccess.getStruct_Access().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__0__Impl"


    // $ANTLR start "rule__Struct___Group_2__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:888:1: rule__Struct___Group_2__1 : rule__Struct___Group_2__1__Impl rule__Struct___Group_2__2 ;
    public final void rule__Struct___Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:892:1: ( rule__Struct___Group_2__1__Impl rule__Struct___Group_2__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:893:2: rule__Struct___Group_2__1__Impl rule__Struct___Group_2__2
            {
            pushFollow(FOLLOW_rule__Struct___Group_2__1__Impl_in_rule__Struct___Group_2__11741);
            rule__Struct___Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group_2__2_in_rule__Struct___Group_2__11744);
            rule__Struct___Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__1"


    // $ANTLR start "rule__Struct___Group_2__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:900:1: rule__Struct___Group_2__1__Impl : ( ( rule__Struct___AttributesAssignment_2_1 )* ) ;
    public final void rule__Struct___Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:904:1: ( ( ( rule__Struct___AttributesAssignment_2_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:905:1: ( ( rule__Struct___AttributesAssignment_2_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:905:1: ( ( rule__Struct___AttributesAssignment_2_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:906:1: ( rule__Struct___AttributesAssignment_2_1 )*
            {
             before(grammarAccess.getStruct_Access().getAttributesAssignment_2_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:907:1: ( rule__Struct___AttributesAssignment_2_1 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:907:2: rule__Struct___AttributesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Struct___AttributesAssignment_2_1_in_rule__Struct___Group_2__1__Impl1771);
            	    rule__Struct___AttributesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getStruct_Access().getAttributesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__1__Impl"


    // $ANTLR start "rule__Struct___Group_2__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:917:1: rule__Struct___Group_2__2 : rule__Struct___Group_2__2__Impl ;
    public final void rule__Struct___Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:921:1: ( rule__Struct___Group_2__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:922:2: rule__Struct___Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Struct___Group_2__2__Impl_in_rule__Struct___Group_2__21802);
            rule__Struct___Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__2"


    // $ANTLR start "rule__Struct___Group_2__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:928:1: rule__Struct___Group_2__2__Impl : ( ']' ) ;
    public final void rule__Struct___Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:932:1: ( ( ']' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:933:1: ( ']' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:933:1: ( ']' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:934:1: ']'
            {
             before(grammarAccess.getStruct_Access().getRightSquareBracketKeyword_2_2()); 
            match(input,12,FOLLOW_12_in_rule__Struct___Group_2__2__Impl1830); 
             after(grammarAccess.getStruct_Access().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_2__2__Impl"


    // $ANTLR start "rule__Struct___Group_3__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:953:1: rule__Struct___Group_3__0 : rule__Struct___Group_3__0__Impl rule__Struct___Group_3__1 ;
    public final void rule__Struct___Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:957:1: ( rule__Struct___Group_3__0__Impl rule__Struct___Group_3__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:958:2: rule__Struct___Group_3__0__Impl rule__Struct___Group_3__1
            {
            pushFollow(FOLLOW_rule__Struct___Group_3__0__Impl_in_rule__Struct___Group_3__01867);
            rule__Struct___Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group_3__1_in_rule__Struct___Group_3__01870);
            rule__Struct___Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__0"


    // $ANTLR start "rule__Struct___Group_3__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:965:1: rule__Struct___Group_3__0__Impl : ( '{' ) ;
    public final void rule__Struct___Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:969:1: ( ( '{' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:970:1: ( '{' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:970:1: ( '{' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:971:1: '{'
            {
             before(grammarAccess.getStruct_Access().getLeftCurlyBracketKeyword_3_0()); 
            match(input,14,FOLLOW_14_in_rule__Struct___Group_3__0__Impl1898); 
             after(grammarAccess.getStruct_Access().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__0__Impl"


    // $ANTLR start "rule__Struct___Group_3__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:984:1: rule__Struct___Group_3__1 : rule__Struct___Group_3__1__Impl rule__Struct___Group_3__2 ;
    public final void rule__Struct___Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:988:1: ( rule__Struct___Group_3__1__Impl rule__Struct___Group_3__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:989:2: rule__Struct___Group_3__1__Impl rule__Struct___Group_3__2
            {
            pushFollow(FOLLOW_rule__Struct___Group_3__1__Impl_in_rule__Struct___Group_3__11929);
            rule__Struct___Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Struct___Group_3__2_in_rule__Struct___Group_3__11932);
            rule__Struct___Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__1"


    // $ANTLR start "rule__Struct___Group_3__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:996:1: rule__Struct___Group_3__1__Impl : ( ( rule__Struct___EntitiesAssignment_3_1 )* ) ;
    public final void rule__Struct___Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1000:1: ( ( ( rule__Struct___EntitiesAssignment_3_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1001:1: ( ( rule__Struct___EntitiesAssignment_3_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1001:1: ( ( rule__Struct___EntitiesAssignment_3_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1002:1: ( rule__Struct___EntitiesAssignment_3_1 )*
            {
             before(grammarAccess.getStruct_Access().getEntitiesAssignment_3_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1003:1: ( rule__Struct___EntitiesAssignment_3_1 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==13||(LA12_0>=16 && LA12_0<=17)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1003:2: rule__Struct___EntitiesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__Struct___EntitiesAssignment_3_1_in_rule__Struct___Group_3__1__Impl1959);
            	    rule__Struct___EntitiesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getStruct_Access().getEntitiesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__1__Impl"


    // $ANTLR start "rule__Struct___Group_3__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1013:1: rule__Struct___Group_3__2 : rule__Struct___Group_3__2__Impl ;
    public final void rule__Struct___Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1017:1: ( rule__Struct___Group_3__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1018:2: rule__Struct___Group_3__2__Impl
            {
            pushFollow(FOLLOW_rule__Struct___Group_3__2__Impl_in_rule__Struct___Group_3__21990);
            rule__Struct___Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__2"


    // $ANTLR start "rule__Struct___Group_3__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1024:1: rule__Struct___Group_3__2__Impl : ( '}' ) ;
    public final void rule__Struct___Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1028:1: ( ( '}' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1029:1: ( '}' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1029:1: ( '}' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1030:1: '}'
            {
             before(grammarAccess.getStruct_Access().getRightCurlyBracketKeyword_3_2()); 
            match(input,15,FOLLOW_15_in_rule__Struct___Group_3__2__Impl2018); 
             after(grammarAccess.getStruct_Access().getRightCurlyBracketKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___Group_3__2__Impl"


    // $ANTLR start "rule__Relationship___Group__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1049:1: rule__Relationship___Group__0 : rule__Relationship___Group__0__Impl rule__Relationship___Group__1 ;
    public final void rule__Relationship___Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1053:1: ( rule__Relationship___Group__0__Impl rule__Relationship___Group__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1054:2: rule__Relationship___Group__0__Impl rule__Relationship___Group__1
            {
            pushFollow(FOLLOW_rule__Relationship___Group__0__Impl_in_rule__Relationship___Group__02055);
            rule__Relationship___Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group__1_in_rule__Relationship___Group__02058);
            rule__Relationship___Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__0"


    // $ANTLR start "rule__Relationship___Group__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1061:1: rule__Relationship___Group__0__Impl : ( 'Relationship' ) ;
    public final void rule__Relationship___Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1065:1: ( ( 'Relationship' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1066:1: ( 'Relationship' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1066:1: ( 'Relationship' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1067:1: 'Relationship'
            {
             before(grammarAccess.getRelationship_Access().getRelationshipKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Relationship___Group__0__Impl2086); 
             after(grammarAccess.getRelationship_Access().getRelationshipKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__0__Impl"


    // $ANTLR start "rule__Relationship___Group__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1080:1: rule__Relationship___Group__1 : rule__Relationship___Group__1__Impl rule__Relationship___Group__2 ;
    public final void rule__Relationship___Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1084:1: ( rule__Relationship___Group__1__Impl rule__Relationship___Group__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1085:2: rule__Relationship___Group__1__Impl rule__Relationship___Group__2
            {
            pushFollow(FOLLOW_rule__Relationship___Group__1__Impl_in_rule__Relationship___Group__12117);
            rule__Relationship___Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group__2_in_rule__Relationship___Group__12120);
            rule__Relationship___Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__1"


    // $ANTLR start "rule__Relationship___Group__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1092:1: rule__Relationship___Group__1__Impl : ( ( rule__Relationship___NameAssignment_1 ) ) ;
    public final void rule__Relationship___Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1096:1: ( ( ( rule__Relationship___NameAssignment_1 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1097:1: ( ( rule__Relationship___NameAssignment_1 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1097:1: ( ( rule__Relationship___NameAssignment_1 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1098:1: ( rule__Relationship___NameAssignment_1 )
            {
             before(grammarAccess.getRelationship_Access().getNameAssignment_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1099:1: ( rule__Relationship___NameAssignment_1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1099:2: rule__Relationship___NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Relationship___NameAssignment_1_in_rule__Relationship___Group__1__Impl2147);
            rule__Relationship___NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRelationship_Access().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__1__Impl"


    // $ANTLR start "rule__Relationship___Group__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1109:1: rule__Relationship___Group__2 : rule__Relationship___Group__2__Impl rule__Relationship___Group__3 ;
    public final void rule__Relationship___Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1113:1: ( rule__Relationship___Group__2__Impl rule__Relationship___Group__3 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1114:2: rule__Relationship___Group__2__Impl rule__Relationship___Group__3
            {
            pushFollow(FOLLOW_rule__Relationship___Group__2__Impl_in_rule__Relationship___Group__22177);
            rule__Relationship___Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group__3_in_rule__Relationship___Group__22180);
            rule__Relationship___Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__2"


    // $ANTLR start "rule__Relationship___Group__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1121:1: rule__Relationship___Group__2__Impl : ( ( rule__Relationship___Group_2__0 )? ) ;
    public final void rule__Relationship___Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1125:1: ( ( ( rule__Relationship___Group_2__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1126:1: ( ( rule__Relationship___Group_2__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1126:1: ( ( rule__Relationship___Group_2__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1127:1: ( rule__Relationship___Group_2__0 )?
            {
             before(grammarAccess.getRelationship_Access().getGroup_2()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1128:1: ( rule__Relationship___Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==11) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1128:2: rule__Relationship___Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Relationship___Group_2__0_in_rule__Relationship___Group__2__Impl2207);
                    rule__Relationship___Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelationship_Access().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__2__Impl"


    // $ANTLR start "rule__Relationship___Group__3"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1138:1: rule__Relationship___Group__3 : rule__Relationship___Group__3__Impl ;
    public final void rule__Relationship___Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1142:1: ( rule__Relationship___Group__3__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1143:2: rule__Relationship___Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Relationship___Group__3__Impl_in_rule__Relationship___Group__32238);
            rule__Relationship___Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__3"


    // $ANTLR start "rule__Relationship___Group__3__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1149:1: rule__Relationship___Group__3__Impl : ( ( rule__Relationship___Group_3__0 )? ) ;
    public final void rule__Relationship___Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1153:1: ( ( ( rule__Relationship___Group_3__0 )? ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1154:1: ( ( rule__Relationship___Group_3__0 )? )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1154:1: ( ( rule__Relationship___Group_3__0 )? )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1155:1: ( rule__Relationship___Group_3__0 )?
            {
             before(grammarAccess.getRelationship_Access().getGroup_3()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1156:1: ( rule__Relationship___Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==14) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1156:2: rule__Relationship___Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Relationship___Group_3__0_in_rule__Relationship___Group__3__Impl2265);
                    rule__Relationship___Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRelationship_Access().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group__3__Impl"


    // $ANTLR start "rule__Relationship___Group_2__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1174:1: rule__Relationship___Group_2__0 : rule__Relationship___Group_2__0__Impl rule__Relationship___Group_2__1 ;
    public final void rule__Relationship___Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1178:1: ( rule__Relationship___Group_2__0__Impl rule__Relationship___Group_2__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1179:2: rule__Relationship___Group_2__0__Impl rule__Relationship___Group_2__1
            {
            pushFollow(FOLLOW_rule__Relationship___Group_2__0__Impl_in_rule__Relationship___Group_2__02304);
            rule__Relationship___Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_2__1_in_rule__Relationship___Group_2__02307);
            rule__Relationship___Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__0"


    // $ANTLR start "rule__Relationship___Group_2__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1186:1: rule__Relationship___Group_2__0__Impl : ( '[' ) ;
    public final void rule__Relationship___Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1190:1: ( ( '[' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1191:1: ( '[' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1191:1: ( '[' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1192:1: '['
            {
             before(grammarAccess.getRelationship_Access().getLeftSquareBracketKeyword_2_0()); 
            match(input,11,FOLLOW_11_in_rule__Relationship___Group_2__0__Impl2335); 
             after(grammarAccess.getRelationship_Access().getLeftSquareBracketKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__0__Impl"


    // $ANTLR start "rule__Relationship___Group_2__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1205:1: rule__Relationship___Group_2__1 : rule__Relationship___Group_2__1__Impl rule__Relationship___Group_2__2 ;
    public final void rule__Relationship___Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1209:1: ( rule__Relationship___Group_2__1__Impl rule__Relationship___Group_2__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1210:2: rule__Relationship___Group_2__1__Impl rule__Relationship___Group_2__2
            {
            pushFollow(FOLLOW_rule__Relationship___Group_2__1__Impl_in_rule__Relationship___Group_2__12366);
            rule__Relationship___Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_2__2_in_rule__Relationship___Group_2__12369);
            rule__Relationship___Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__1"


    // $ANTLR start "rule__Relationship___Group_2__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1217:1: rule__Relationship___Group_2__1__Impl : ( ( rule__Relationship___AttributesAssignment_2_1 )* ) ;
    public final void rule__Relationship___Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1221:1: ( ( ( rule__Relationship___AttributesAssignment_2_1 )* ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1222:1: ( ( rule__Relationship___AttributesAssignment_2_1 )* )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1222:1: ( ( rule__Relationship___AttributesAssignment_2_1 )* )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1223:1: ( rule__Relationship___AttributesAssignment_2_1 )*
            {
             before(grammarAccess.getRelationship_Access().getAttributesAssignment_2_1()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1224:1: ( rule__Relationship___AttributesAssignment_2_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1224:2: rule__Relationship___AttributesAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__Relationship___AttributesAssignment_2_1_in_rule__Relationship___Group_2__1__Impl2396);
            	    rule__Relationship___AttributesAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getRelationship_Access().getAttributesAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__1__Impl"


    // $ANTLR start "rule__Relationship___Group_2__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1234:1: rule__Relationship___Group_2__2 : rule__Relationship___Group_2__2__Impl ;
    public final void rule__Relationship___Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1238:1: ( rule__Relationship___Group_2__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1239:2: rule__Relationship___Group_2__2__Impl
            {
            pushFollow(FOLLOW_rule__Relationship___Group_2__2__Impl_in_rule__Relationship___Group_2__22427);
            rule__Relationship___Group_2__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__2"


    // $ANTLR start "rule__Relationship___Group_2__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1245:1: rule__Relationship___Group_2__2__Impl : ( ']' ) ;
    public final void rule__Relationship___Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1249:1: ( ( ']' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1250:1: ( ']' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1250:1: ( ']' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1251:1: ']'
            {
             before(grammarAccess.getRelationship_Access().getRightSquareBracketKeyword_2_2()); 
            match(input,12,FOLLOW_12_in_rule__Relationship___Group_2__2__Impl2455); 
             after(grammarAccess.getRelationship_Access().getRightSquareBracketKeyword_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_2__2__Impl"


    // $ANTLR start "rule__Relationship___Group_3__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1270:1: rule__Relationship___Group_3__0 : rule__Relationship___Group_3__0__Impl rule__Relationship___Group_3__1 ;
    public final void rule__Relationship___Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1274:1: ( rule__Relationship___Group_3__0__Impl rule__Relationship___Group_3__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1275:2: rule__Relationship___Group_3__0__Impl rule__Relationship___Group_3__1
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__0__Impl_in_rule__Relationship___Group_3__02492);
            rule__Relationship___Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__1_in_rule__Relationship___Group_3__02495);
            rule__Relationship___Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__0"


    // $ANTLR start "rule__Relationship___Group_3__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1282:1: rule__Relationship___Group_3__0__Impl : ( '{' ) ;
    public final void rule__Relationship___Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1286:1: ( ( '{' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1287:1: ( '{' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1287:1: ( '{' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1288:1: '{'
            {
             before(grammarAccess.getRelationship_Access().getLeftCurlyBracketKeyword_3_0()); 
            match(input,14,FOLLOW_14_in_rule__Relationship___Group_3__0__Impl2523); 
             after(grammarAccess.getRelationship_Access().getLeftCurlyBracketKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__0__Impl"


    // $ANTLR start "rule__Relationship___Group_3__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1301:1: rule__Relationship___Group_3__1 : rule__Relationship___Group_3__1__Impl rule__Relationship___Group_3__2 ;
    public final void rule__Relationship___Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1305:1: ( rule__Relationship___Group_3__1__Impl rule__Relationship___Group_3__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1306:2: rule__Relationship___Group_3__1__Impl rule__Relationship___Group_3__2
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__1__Impl_in_rule__Relationship___Group_3__12554);
            rule__Relationship___Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__2_in_rule__Relationship___Group_3__12557);
            rule__Relationship___Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__1"


    // $ANTLR start "rule__Relationship___Group_3__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1313:1: rule__Relationship___Group_3__1__Impl : ( 'start' ) ;
    public final void rule__Relationship___Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1317:1: ( ( 'start' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1318:1: ( 'start' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1318:1: ( 'start' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1319:1: 'start'
            {
             before(grammarAccess.getRelationship_Access().getStartKeyword_3_1()); 
            match(input,18,FOLLOW_18_in_rule__Relationship___Group_3__1__Impl2585); 
             after(grammarAccess.getRelationship_Access().getStartKeyword_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__1__Impl"


    // $ANTLR start "rule__Relationship___Group_3__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1332:1: rule__Relationship___Group_3__2 : rule__Relationship___Group_3__2__Impl rule__Relationship___Group_3__3 ;
    public final void rule__Relationship___Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1336:1: ( rule__Relationship___Group_3__2__Impl rule__Relationship___Group_3__3 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1337:2: rule__Relationship___Group_3__2__Impl rule__Relationship___Group_3__3
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__2__Impl_in_rule__Relationship___Group_3__22616);
            rule__Relationship___Group_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__3_in_rule__Relationship___Group_3__22619);
            rule__Relationship___Group_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__2"


    // $ANTLR start "rule__Relationship___Group_3__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1344:1: rule__Relationship___Group_3__2__Impl : ( '=' ) ;
    public final void rule__Relationship___Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1348:1: ( ( '=' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1349:1: ( '=' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1349:1: ( '=' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1350:1: '='
            {
             before(grammarAccess.getRelationship_Access().getEqualsSignKeyword_3_2()); 
            match(input,19,FOLLOW_19_in_rule__Relationship___Group_3__2__Impl2647); 
             after(grammarAccess.getRelationship_Access().getEqualsSignKeyword_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__2__Impl"


    // $ANTLR start "rule__Relationship___Group_3__3"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1363:1: rule__Relationship___Group_3__3 : rule__Relationship___Group_3__3__Impl rule__Relationship___Group_3__4 ;
    public final void rule__Relationship___Group_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1367:1: ( rule__Relationship___Group_3__3__Impl rule__Relationship___Group_3__4 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1368:2: rule__Relationship___Group_3__3__Impl rule__Relationship___Group_3__4
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__3__Impl_in_rule__Relationship___Group_3__32678);
            rule__Relationship___Group_3__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__4_in_rule__Relationship___Group_3__32681);
            rule__Relationship___Group_3__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__3"


    // $ANTLR start "rule__Relationship___Group_3__3__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1375:1: rule__Relationship___Group_3__3__Impl : ( ( rule__Relationship___StartAssignment_3_3 ) ) ;
    public final void rule__Relationship___Group_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1379:1: ( ( ( rule__Relationship___StartAssignment_3_3 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1380:1: ( ( rule__Relationship___StartAssignment_3_3 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1380:1: ( ( rule__Relationship___StartAssignment_3_3 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1381:1: ( rule__Relationship___StartAssignment_3_3 )
            {
             before(grammarAccess.getRelationship_Access().getStartAssignment_3_3()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1382:1: ( rule__Relationship___StartAssignment_3_3 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1382:2: rule__Relationship___StartAssignment_3_3
            {
            pushFollow(FOLLOW_rule__Relationship___StartAssignment_3_3_in_rule__Relationship___Group_3__3__Impl2708);
            rule__Relationship___StartAssignment_3_3();

            state._fsp--;


            }

             after(grammarAccess.getRelationship_Access().getStartAssignment_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__3__Impl"


    // $ANTLR start "rule__Relationship___Group_3__4"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1392:1: rule__Relationship___Group_3__4 : rule__Relationship___Group_3__4__Impl rule__Relationship___Group_3__5 ;
    public final void rule__Relationship___Group_3__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1396:1: ( rule__Relationship___Group_3__4__Impl rule__Relationship___Group_3__5 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1397:2: rule__Relationship___Group_3__4__Impl rule__Relationship___Group_3__5
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__4__Impl_in_rule__Relationship___Group_3__42738);
            rule__Relationship___Group_3__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__5_in_rule__Relationship___Group_3__42741);
            rule__Relationship___Group_3__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__4"


    // $ANTLR start "rule__Relationship___Group_3__4__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1404:1: rule__Relationship___Group_3__4__Impl : ( 'end' ) ;
    public final void rule__Relationship___Group_3__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1408:1: ( ( 'end' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1409:1: ( 'end' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1409:1: ( 'end' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1410:1: 'end'
            {
             before(grammarAccess.getRelationship_Access().getEndKeyword_3_4()); 
            match(input,20,FOLLOW_20_in_rule__Relationship___Group_3__4__Impl2769); 
             after(grammarAccess.getRelationship_Access().getEndKeyword_3_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__4__Impl"


    // $ANTLR start "rule__Relationship___Group_3__5"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1423:1: rule__Relationship___Group_3__5 : rule__Relationship___Group_3__5__Impl rule__Relationship___Group_3__6 ;
    public final void rule__Relationship___Group_3__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1427:1: ( rule__Relationship___Group_3__5__Impl rule__Relationship___Group_3__6 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1428:2: rule__Relationship___Group_3__5__Impl rule__Relationship___Group_3__6
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__5__Impl_in_rule__Relationship___Group_3__52800);
            rule__Relationship___Group_3__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__6_in_rule__Relationship___Group_3__52803);
            rule__Relationship___Group_3__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__5"


    // $ANTLR start "rule__Relationship___Group_3__5__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1435:1: rule__Relationship___Group_3__5__Impl : ( '=' ) ;
    public final void rule__Relationship___Group_3__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1439:1: ( ( '=' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1440:1: ( '=' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1440:1: ( '=' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1441:1: '='
            {
             before(grammarAccess.getRelationship_Access().getEqualsSignKeyword_3_5()); 
            match(input,19,FOLLOW_19_in_rule__Relationship___Group_3__5__Impl2831); 
             after(grammarAccess.getRelationship_Access().getEqualsSignKeyword_3_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__5__Impl"


    // $ANTLR start "rule__Relationship___Group_3__6"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1454:1: rule__Relationship___Group_3__6 : rule__Relationship___Group_3__6__Impl rule__Relationship___Group_3__7 ;
    public final void rule__Relationship___Group_3__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1458:1: ( rule__Relationship___Group_3__6__Impl rule__Relationship___Group_3__7 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1459:2: rule__Relationship___Group_3__6__Impl rule__Relationship___Group_3__7
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__6__Impl_in_rule__Relationship___Group_3__62862);
            rule__Relationship___Group_3__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Relationship___Group_3__7_in_rule__Relationship___Group_3__62865);
            rule__Relationship___Group_3__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__6"


    // $ANTLR start "rule__Relationship___Group_3__6__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1466:1: rule__Relationship___Group_3__6__Impl : ( ( rule__Relationship___EndAssignment_3_6 ) ) ;
    public final void rule__Relationship___Group_3__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1470:1: ( ( ( rule__Relationship___EndAssignment_3_6 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1471:1: ( ( rule__Relationship___EndAssignment_3_6 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1471:1: ( ( rule__Relationship___EndAssignment_3_6 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1472:1: ( rule__Relationship___EndAssignment_3_6 )
            {
             before(grammarAccess.getRelationship_Access().getEndAssignment_3_6()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1473:1: ( rule__Relationship___EndAssignment_3_6 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1473:2: rule__Relationship___EndAssignment_3_6
            {
            pushFollow(FOLLOW_rule__Relationship___EndAssignment_3_6_in_rule__Relationship___Group_3__6__Impl2892);
            rule__Relationship___EndAssignment_3_6();

            state._fsp--;


            }

             after(grammarAccess.getRelationship_Access().getEndAssignment_3_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__6__Impl"


    // $ANTLR start "rule__Relationship___Group_3__7"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1483:1: rule__Relationship___Group_3__7 : rule__Relationship___Group_3__7__Impl ;
    public final void rule__Relationship___Group_3__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1487:1: ( rule__Relationship___Group_3__7__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1488:2: rule__Relationship___Group_3__7__Impl
            {
            pushFollow(FOLLOW_rule__Relationship___Group_3__7__Impl_in_rule__Relationship___Group_3__72922);
            rule__Relationship___Group_3__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__7"


    // $ANTLR start "rule__Relationship___Group_3__7__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1494:1: rule__Relationship___Group_3__7__Impl : ( '}' ) ;
    public final void rule__Relationship___Group_3__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1498:1: ( ( '}' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1499:1: ( '}' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1499:1: ( '}' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1500:1: '}'
            {
             before(grammarAccess.getRelationship_Access().getRightCurlyBracketKeyword_3_7()); 
            match(input,15,FOLLOW_15_in_rule__Relationship___Group_3__7__Impl2950); 
             after(grammarAccess.getRelationship_Access().getRightCurlyBracketKeyword_3_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___Group_3__7__Impl"


    // $ANTLR start "rule__Attribute__Group__0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1529:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1533:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1534:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02997);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__03000);
            rule__Attribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1541:1: rule__Attribute__Group__0__Impl : ( ( rule__Attribute__NameAssignment_0 ) ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1545:1: ( ( ( rule__Attribute__NameAssignment_0 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1546:1: ( ( rule__Attribute__NameAssignment_0 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1546:1: ( ( rule__Attribute__NameAssignment_0 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1547:1: ( rule__Attribute__NameAssignment_0 )
            {
             before(grammarAccess.getAttributeAccess().getNameAssignment_0()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1548:1: ( rule__Attribute__NameAssignment_0 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1548:2: rule__Attribute__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl3027);
            rule__Attribute__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1558:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1562:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1563:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__13057);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__13060);
            rule__Attribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1570:1: rule__Attribute__Group__1__Impl : ( '=' ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1574:1: ( ( '=' ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1575:1: ( '=' )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1575:1: ( '=' )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1576:1: '='
            {
             before(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 
            match(input,19,FOLLOW_19_in_rule__Attribute__Group__1__Impl3088); 
             after(grammarAccess.getAttributeAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1589:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1593:1: ( rule__Attribute__Group__2__Impl )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1594:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__23119);
            rule__Attribute__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1600:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__ValueAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1604:1: ( ( ( rule__Attribute__ValueAssignment_2 ) ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1605:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1605:1: ( ( rule__Attribute__ValueAssignment_2 ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1606:1: ( rule__Attribute__ValueAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getValueAssignment_2()); 
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1607:1: ( rule__Attribute__ValueAssignment_2 )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1607:2: rule__Attribute__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl3146);
            rule__Attribute__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Schema__AttributesAssignment_0_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1624:1: rule__Schema__AttributesAssignment_0_1 : ( ruleAttribute ) ;
    public final void rule__Schema__AttributesAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1628:1: ( ( ruleAttribute ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1629:1: ( ruleAttribute )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1629:1: ( ruleAttribute )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1630:1: ruleAttribute
            {
             before(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_ruleAttribute_in_rule__Schema__AttributesAssignment_0_13187);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__AttributesAssignment_0_1"


    // $ANTLR start "rule__Schema__EntitiesAssignment_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1639:1: rule__Schema__EntitiesAssignment_1 : ( ruleEntity ) ;
    public final void rule__Schema__EntitiesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1643:1: ( ( ruleEntity ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1644:1: ( ruleEntity )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1644:1: ( ruleEntity )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1645:1: ruleEntity
            {
             before(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEntity_in_rule__Schema__EntitiesAssignment_13218);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Schema__EntitiesAssignment_1"


    // $ANTLR start "rule__Set___NameAssignment_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1654:1: rule__Set___NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Set___NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1658:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1659:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1659:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1660:1: RULE_ID
            {
             before(grammarAccess.getSet_Access().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Set___NameAssignment_13249); 
             after(grammarAccess.getSet_Access().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___NameAssignment_1"


    // $ANTLR start "rule__Set___AttributesAssignment_2_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1669:1: rule__Set___AttributesAssignment_2_1 : ( ruleAttribute ) ;
    public final void rule__Set___AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1673:1: ( ( ruleAttribute ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1674:1: ( ruleAttribute )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1674:1: ( ruleAttribute )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1675:1: ruleAttribute
            {
             before(grammarAccess.getSet_Access().getAttributesAttributeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleAttribute_in_rule__Set___AttributesAssignment_2_13280);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getSet_Access().getAttributesAttributeParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___AttributesAssignment_2_1"


    // $ANTLR start "rule__Set___EntitiesAssignment_3_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1684:1: rule__Set___EntitiesAssignment_3_1 : ( ruleEntity ) ;
    public final void rule__Set___EntitiesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1688:1: ( ( ruleEntity ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1689:1: ( ruleEntity )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1689:1: ( ruleEntity )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1690:1: ruleEntity
            {
             before(grammarAccess.getSet_Access().getEntitiesEntityParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEntity_in_rule__Set___EntitiesAssignment_3_13311);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getSet_Access().getEntitiesEntityParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Set___EntitiesAssignment_3_1"


    // $ANTLR start "rule__Struct___NameAssignment_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1699:1: rule__Struct___NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Struct___NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1703:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1704:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1704:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1705:1: RULE_ID
            {
             before(grammarAccess.getStruct_Access().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Struct___NameAssignment_13342); 
             after(grammarAccess.getStruct_Access().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___NameAssignment_1"


    // $ANTLR start "rule__Struct___AttributesAssignment_2_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1714:1: rule__Struct___AttributesAssignment_2_1 : ( ruleAttribute ) ;
    public final void rule__Struct___AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1718:1: ( ( ruleAttribute ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1719:1: ( ruleAttribute )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1719:1: ( ruleAttribute )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1720:1: ruleAttribute
            {
             before(grammarAccess.getStruct_Access().getAttributesAttributeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleAttribute_in_rule__Struct___AttributesAssignment_2_13373);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getStruct_Access().getAttributesAttributeParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___AttributesAssignment_2_1"


    // $ANTLR start "rule__Struct___EntitiesAssignment_3_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1729:1: rule__Struct___EntitiesAssignment_3_1 : ( ruleEntity ) ;
    public final void rule__Struct___EntitiesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1733:1: ( ( ruleEntity ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1734:1: ( ruleEntity )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1734:1: ( ruleEntity )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1735:1: ruleEntity
            {
             before(grammarAccess.getStruct_Access().getEntitiesEntityParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleEntity_in_rule__Struct___EntitiesAssignment_3_13404);
            ruleEntity();

            state._fsp--;

             after(grammarAccess.getStruct_Access().getEntitiesEntityParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Struct___EntitiesAssignment_3_1"


    // $ANTLR start "rule__Relationship___NameAssignment_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1744:1: rule__Relationship___NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Relationship___NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1748:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1749:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1749:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1750:1: RULE_ID
            {
             before(grammarAccess.getRelationship_Access().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Relationship___NameAssignment_13435); 
             after(grammarAccess.getRelationship_Access().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___NameAssignment_1"


    // $ANTLR start "rule__Relationship___AttributesAssignment_2_1"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1759:1: rule__Relationship___AttributesAssignment_2_1 : ( ruleAttribute ) ;
    public final void rule__Relationship___AttributesAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1763:1: ( ( ruleAttribute ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1764:1: ( ruleAttribute )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1764:1: ( ruleAttribute )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1765:1: ruleAttribute
            {
             before(grammarAccess.getRelationship_Access().getAttributesAttributeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleAttribute_in_rule__Relationship___AttributesAssignment_2_13466);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getRelationship_Access().getAttributesAttributeParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___AttributesAssignment_2_1"


    // $ANTLR start "rule__Relationship___StartAssignment_3_3"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1774:1: rule__Relationship___StartAssignment_3_3 : ( RULE_ID ) ;
    public final void rule__Relationship___StartAssignment_3_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1778:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1779:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1779:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1780:1: RULE_ID
            {
             before(grammarAccess.getRelationship_Access().getStartIDTerminalRuleCall_3_3_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Relationship___StartAssignment_3_33497); 
             after(grammarAccess.getRelationship_Access().getStartIDTerminalRuleCall_3_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___StartAssignment_3_3"


    // $ANTLR start "rule__Relationship___EndAssignment_3_6"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1789:1: rule__Relationship___EndAssignment_3_6 : ( RULE_ID ) ;
    public final void rule__Relationship___EndAssignment_3_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1793:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1794:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1794:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1795:1: RULE_ID
            {
             before(grammarAccess.getRelationship_Access().getEndIDTerminalRuleCall_3_6_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Relationship___EndAssignment_3_63528); 
             after(grammarAccess.getRelationship_Access().getEndIDTerminalRuleCall_3_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Relationship___EndAssignment_3_6"


    // $ANTLR start "rule__Attribute__NameAssignment_0"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1804:1: rule__Attribute__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Attribute__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1808:1: ( ( RULE_ID ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1809:1: ( RULE_ID )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1809:1: ( RULE_ID )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1810:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_03559); 
             after(grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__NameAssignment_0"


    // $ANTLR start "rule__Attribute__ValueAssignment_2"
    // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1819:1: rule__Attribute__ValueAssignment_2 : ( RULE_STRING ) ;
    public final void rule__Attribute__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1823:1: ( ( RULE_STRING ) )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1824:1: ( RULE_STRING )
            {
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1824:1: ( RULE_STRING )
            // ../fr.imag.exschema.dsl.ui/src-gen/fr/imag/exschema/xtext/ui/contentassist/antlr/internal/InternalExSchema.g:1825:1: RULE_STRING
            {
             before(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_23590); 
             after(grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__ValueAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSchema_in_entryRuleSchema61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSchema68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__Group__0_in_ruleSchema94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Alternatives_in_ruleEntity154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet__in_entryRuleSet_181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSet_188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group__0_in_ruleSet_214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStruct__in_entryRuleStruct_241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStruct_248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group__0_in_ruleStruct_274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationship__in_entryRuleRelationship_301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationship_308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group__0_in_ruleRelationship_334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet__in_rule__Entity__Alternatives430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStruct__in_rule__Entity__Alternatives447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationship__in_rule__Entity__Alternatives464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__Group__0__Impl_in_rule__Schema__Group__0494 = new BitSet(new long[]{0x0000000000032000L});
    public static final BitSet FOLLOW_rule__Schema__Group__1_in_rule__Schema__Group__0497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__0_in_rule__Schema__Group__0__Impl524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__Group__1__Impl_in_rule__Schema__Group__1555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__EntitiesAssignment_1_in_rule__Schema__Group__1__Impl582 = new BitSet(new long[]{0x0000000000032002L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__0__Impl_in_rule__Schema__Group_0__0617 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__1_in_rule__Schema__Group_0__0620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Schema__Group_0__0__Impl648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__1__Impl_in_rule__Schema__Group_0__1679 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__2_in_rule__Schema__Group_0__1682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Schema__AttributesAssignment_0_1_in_rule__Schema__Group_0__1__Impl709 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Schema__Group_0__2__Impl_in_rule__Schema__Group_0__2740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Schema__Group_0__2__Impl768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group__0__Impl_in_rule__Set___Group__0805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Set___Group__1_in_rule__Set___Group__0808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Set___Group__0__Impl836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group__1__Impl_in_rule__Set___Group__1867 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Set___Group__2_in_rule__Set___Group__1870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___NameAssignment_1_in_rule__Set___Group__1__Impl897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group__2__Impl_in_rule__Set___Group__2927 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Set___Group__3_in_rule__Set___Group__2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_2__0_in_rule__Set___Group__2__Impl957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group__3__Impl_in_rule__Set___Group__3988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_3__0_in_rule__Set___Group__3__Impl1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_2__0__Impl_in_rule__Set___Group_2__01054 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Set___Group_2__1_in_rule__Set___Group_2__01057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Set___Group_2__0__Impl1085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_2__1__Impl_in_rule__Set___Group_2__11116 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Set___Group_2__2_in_rule__Set___Group_2__11119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___AttributesAssignment_2_1_in_rule__Set___Group_2__1__Impl1146 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Set___Group_2__2__Impl_in_rule__Set___Group_2__21177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Set___Group_2__2__Impl1205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_3__0__Impl_in_rule__Set___Group_3__01242 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_rule__Set___Group_3__1_in_rule__Set___Group_3__01245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Set___Group_3__0__Impl1273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___Group_3__1__Impl_in_rule__Set___Group_3__11304 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_rule__Set___Group_3__2_in_rule__Set___Group_3__11307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Set___EntitiesAssignment_3_1_in_rule__Set___Group_3__1__Impl1334 = new BitSet(new long[]{0x0000000000032002L});
    public static final BitSet FOLLOW_rule__Set___Group_3__2__Impl_in_rule__Set___Group_3__21365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Set___Group_3__2__Impl1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group__0__Impl_in_rule__Struct___Group__01430 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Struct___Group__1_in_rule__Struct___Group__01433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Struct___Group__0__Impl1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group__1__Impl_in_rule__Struct___Group__11492 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Struct___Group__2_in_rule__Struct___Group__11495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___NameAssignment_1_in_rule__Struct___Group__1__Impl1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group__2__Impl_in_rule__Struct___Group__21552 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Struct___Group__3_in_rule__Struct___Group__21555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__0_in_rule__Struct___Group__2__Impl1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group__3__Impl_in_rule__Struct___Group__31613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__0_in_rule__Struct___Group__3__Impl1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__0__Impl_in_rule__Struct___Group_2__01679 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__1_in_rule__Struct___Group_2__01682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Struct___Group_2__0__Impl1710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__1__Impl_in_rule__Struct___Group_2__11741 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__2_in_rule__Struct___Group_2__11744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___AttributesAssignment_2_1_in_rule__Struct___Group_2__1__Impl1771 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Struct___Group_2__2__Impl_in_rule__Struct___Group_2__21802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Struct___Group_2__2__Impl1830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__0__Impl_in_rule__Struct___Group_3__01867 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__1_in_rule__Struct___Group_3__01870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Struct___Group_3__0__Impl1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__1__Impl_in_rule__Struct___Group_3__11929 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__2_in_rule__Struct___Group_3__11932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Struct___EntitiesAssignment_3_1_in_rule__Struct___Group_3__1__Impl1959 = new BitSet(new long[]{0x0000000000032002L});
    public static final BitSet FOLLOW_rule__Struct___Group_3__2__Impl_in_rule__Struct___Group_3__21990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Struct___Group_3__2__Impl2018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group__0__Impl_in_rule__Relationship___Group__02055 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Relationship___Group__1_in_rule__Relationship___Group__02058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Relationship___Group__0__Impl2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group__1__Impl_in_rule__Relationship___Group__12117 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Relationship___Group__2_in_rule__Relationship___Group__12120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___NameAssignment_1_in_rule__Relationship___Group__1__Impl2147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group__2__Impl_in_rule__Relationship___Group__22177 = new BitSet(new long[]{0x0000000000004800L});
    public static final BitSet FOLLOW_rule__Relationship___Group__3_in_rule__Relationship___Group__22180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__0_in_rule__Relationship___Group__2__Impl2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group__3__Impl_in_rule__Relationship___Group__32238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__0_in_rule__Relationship___Group__3__Impl2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__0__Impl_in_rule__Relationship___Group_2__02304 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__1_in_rule__Relationship___Group_2__02307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__Relationship___Group_2__0__Impl2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__1__Impl_in_rule__Relationship___Group_2__12366 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__2_in_rule__Relationship___Group_2__12369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___AttributesAssignment_2_1_in_rule__Relationship___Group_2__1__Impl2396 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Relationship___Group_2__2__Impl_in_rule__Relationship___Group_2__22427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__Relationship___Group_2__2__Impl2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__0__Impl_in_rule__Relationship___Group_3__02492 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__1_in_rule__Relationship___Group_3__02495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Relationship___Group_3__0__Impl2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__1__Impl_in_rule__Relationship___Group_3__12554 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__2_in_rule__Relationship___Group_3__12557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Relationship___Group_3__1__Impl2585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__2__Impl_in_rule__Relationship___Group_3__22616 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__3_in_rule__Relationship___Group_3__22619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Relationship___Group_3__2__Impl2647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__3__Impl_in_rule__Relationship___Group_3__32678 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__4_in_rule__Relationship___Group_3__32681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___StartAssignment_3_3_in_rule__Relationship___Group_3__3__Impl2708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__4__Impl_in_rule__Relationship___Group_3__42738 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__5_in_rule__Relationship___Group_3__42741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Relationship___Group_3__4__Impl2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__5__Impl_in_rule__Relationship___Group_3__52800 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__6_in_rule__Relationship___Group_3__52803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Relationship___Group_3__5__Impl2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__6__Impl_in_rule__Relationship___Group_3__62862 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__7_in_rule__Relationship___Group_3__62865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___EndAssignment_3_6_in_rule__Relationship___Group_3__6__Impl2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Relationship___Group_3__7__Impl_in_rule__Relationship___Group_3__72922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Relationship___Group_3__7__Impl2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__02997 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__03000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__NameAssignment_0_in_rule__Attribute__Group__0__Impl3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__13057 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__13060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Attribute__Group__1__Impl3088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__23119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Attribute__ValueAssignment_2_in_rule__Attribute__Group__2__Impl3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_rule__Schema__AttributesAssignment_0_13187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Schema__EntitiesAssignment_13218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Set___NameAssignment_13249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_rule__Set___AttributesAssignment_2_13280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Set___EntitiesAssignment_3_13311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Struct___NameAssignment_13342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_rule__Struct___AttributesAssignment_2_13373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Struct___EntitiesAssignment_3_13404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Relationship___NameAssignment_13435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_rule__Relationship___AttributesAssignment_2_13466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Relationship___StartAssignment_3_33497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Relationship___EndAssignment_3_63528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__NameAssignment_03559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Attribute__ValueAssignment_23590 = new BitSet(new long[]{0x0000000000000002L});

}