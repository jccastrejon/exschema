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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExSchemaParser extends AbstractInternalAntlrParser {
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
    public String getGrammarFileName() { return "../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g"; }



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



    // $ANTLR start "entryRuleSchema"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:67:1: entryRuleSchema returns [EObject current=null] : iv_ruleSchema= ruleSchema EOF ;
    public final EObject entryRuleSchema() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSchema = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:68:2: (iv_ruleSchema= ruleSchema EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:69:2: iv_ruleSchema= ruleSchema EOF
            {
             newCompositeNode(grammarAccess.getSchemaRule()); 
            pushFollow(FOLLOW_ruleSchema_in_entryRuleSchema75);
            iv_ruleSchema=ruleSchema();

            state._fsp--;

             current =iv_ruleSchema; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSchema85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSchema"


    // $ANTLR start "ruleSchema"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:76:1: ruleSchema returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )? ( (lv_entities_3_0= ruleEntity ) )* ) ;
    public final EObject ruleSchema() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_attributes_1_0 = null;

        EObject lv_entities_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:79:28: ( ( (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )? ( (lv_entities_3_0= ruleEntity ) )* ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:80:1: ( (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )? ( (lv_entities_3_0= ruleEntity ) )* )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:80:1: ( (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )? ( (lv_entities_3_0= ruleEntity ) )* )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:80:2: (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )? ( (lv_entities_3_0= ruleEntity ) )*
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:80:2: (otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:80:4: otherlv_0= '[' ( (lv_attributes_1_0= ruleAttribute ) )* otherlv_2= ']'
                    {
                    otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleSchema123); 

                        	newLeafNode(otherlv_0, grammarAccess.getSchemaAccess().getLeftSquareBracketKeyword_0_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:84:1: ( (lv_attributes_1_0= ruleAttribute ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==RULE_ID) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:85:1: (lv_attributes_1_0= ruleAttribute )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:85:1: (lv_attributes_1_0= ruleAttribute )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:86:3: lv_attributes_1_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSchemaAccess().getAttributesAttributeParserRuleCall_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleSchema144);
                    	    lv_attributes_1_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSchemaRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_1_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleSchema157); 

                        	newLeafNode(otherlv_2, grammarAccess.getSchemaAccess().getRightSquareBracketKeyword_0_2());
                        

                    }
                    break;

            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:106:3: ( (lv_entities_3_0= ruleEntity ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==13||(LA3_0>=16 && LA3_0<=17)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:107:1: (lv_entities_3_0= ruleEntity )
            	    {
            	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:107:1: (lv_entities_3_0= ruleEntity )
            	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:108:3: lv_entities_3_0= ruleEntity
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSchemaAccess().getEntitiesEntityParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEntity_in_ruleSchema180);
            	    lv_entities_3_0=ruleEntity();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSchemaRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"entities",
            	            		lv_entities_3_0, 
            	            		"Entity");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSchema"


    // $ANTLR start "entryRuleEntity"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:132:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:133:2: (iv_ruleEntity= ruleEntity EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:134:2: iv_ruleEntity= ruleEntity EOF
            {
             newCompositeNode(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity217);
            iv_ruleEntity=ruleEntity();

            state._fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity227); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEntity"


    // $ANTLR start "ruleEntity"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:141:1: ruleEntity returns [EObject current=null] : (this_Set_0= ruleSet | this_Struct_1= ruleStruct | this_Relationship_2= ruleRelationship ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        EObject this_Set_0 = null;

        EObject this_Struct_1 = null;

        EObject this_Relationship_2 = null;


         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:144:28: ( (this_Set_0= ruleSet | this_Struct_1= ruleStruct | this_Relationship_2= ruleRelationship ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:145:1: (this_Set_0= ruleSet | this_Struct_1= ruleStruct | this_Relationship_2= ruleRelationship )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:145:1: (this_Set_0= ruleSet | this_Struct_1= ruleStruct | this_Relationship_2= ruleRelationship )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:146:5: this_Set_0= ruleSet
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getSetParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSet_in_ruleEntity274);
                    this_Set_0=ruleSet();

                    state._fsp--;

                     
                            current = this_Set_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:156:5: this_Struct_1= ruleStruct
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getStructParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStruct_in_ruleEntity301);
                    this_Struct_1=ruleStruct();

                    state._fsp--;

                     
                            current = this_Struct_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:166:5: this_Relationship_2= ruleRelationship
                    {
                     
                            newCompositeNode(grammarAccess.getEntityAccess().getRelationshipParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleRelationship_in_ruleEntity328);
                    this_Relationship_2=ruleRelationship();

                    state._fsp--;

                     
                            current = this_Relationship_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEntity"


    // $ANTLR start "entryRuleSet"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:182:1: entryRuleSet returns [EObject current=null] : iv_ruleSet= ruleSet EOF ;
    public final EObject entryRuleSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSet = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:183:2: (iv_ruleSet= ruleSet EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:184:2: iv_ruleSet= ruleSet EOF
            {
             newCompositeNode(grammarAccess.getSetRule()); 
            pushFollow(FOLLOW_ruleSet_in_entryRuleSet363);
            iv_ruleSet=ruleSet();

            state._fsp--;

             current =iv_ruleSet; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSet373); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSet"


    // $ANTLR start "ruleSet"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:191:1: ruleSet returns [EObject current=null] : (otherlv_0= 'Set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? ) ;
    public final EObject ruleSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_entities_6_0 = null;


         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:194:28: ( (otherlv_0= 'Set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:195:1: (otherlv_0= 'Set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:195:1: (otherlv_0= 'Set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:195:3: otherlv_0= 'Set' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_ruleSet410); 

                	newLeafNode(otherlv_0, grammarAccess.getSetAccess().getSetKeyword_0());
                
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:199:1: ( (lv_name_1_0= RULE_ID ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:200:1: (lv_name_1_0= RULE_ID )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:200:1: (lv_name_1_0= RULE_ID )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:201:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSet427); 

            			newLeafNode(lv_name_1_0, grammarAccess.getSetAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSetRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:217:2: (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==11) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:217:4: otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleSet445); 

                        	newLeafNode(otherlv_2, grammarAccess.getSetAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:221:1: ( (lv_attributes_3_0= ruleAttribute ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:222:1: (lv_attributes_3_0= ruleAttribute )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:222:1: (lv_attributes_3_0= ruleAttribute )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:223:3: lv_attributes_3_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSetAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleSet466);
                    	    lv_attributes_3_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_3_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleSet479); 

                        	newLeafNode(otherlv_4, grammarAccess.getSetAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:243:3: (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==14) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:243:5: otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleSet494); 

                        	newLeafNode(otherlv_5, grammarAccess.getSetAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:247:1: ( (lv_entities_6_0= ruleEntity ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==13||(LA7_0>=16 && LA7_0<=17)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:248:1: (lv_entities_6_0= ruleEntity )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:248:1: (lv_entities_6_0= ruleEntity )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:249:3: lv_entities_6_0= ruleEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSetAccess().getEntitiesEntityParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEntity_in_ruleSet515);
                    	    lv_entities_6_0=ruleEntity();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSetRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"entities",
                    	            		lv_entities_6_0, 
                    	            		"Entity");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleSet528); 

                        	newLeafNode(otherlv_7, grammarAccess.getSetAccess().getRightCurlyBracketKeyword_3_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSet"


    // $ANTLR start "entryRuleStruct"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:277:1: entryRuleStruct returns [EObject current=null] : iv_ruleStruct= ruleStruct EOF ;
    public final EObject entryRuleStruct() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStruct = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:278:2: (iv_ruleStruct= ruleStruct EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:279:2: iv_ruleStruct= ruleStruct EOF
            {
             newCompositeNode(grammarAccess.getStructRule()); 
            pushFollow(FOLLOW_ruleStruct_in_entryRuleStruct566);
            iv_ruleStruct=ruleStruct();

            state._fsp--;

             current =iv_ruleStruct; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStruct576); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStruct"


    // $ANTLR start "ruleStruct"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:286:1: ruleStruct returns [EObject current=null] : (otherlv_0= 'Struct' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? ) ;
    public final EObject ruleStruct() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_entities_6_0 = null;


         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:289:28: ( (otherlv_0= 'Struct' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:290:1: (otherlv_0= 'Struct' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:290:1: (otherlv_0= 'Struct' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )? )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:290:3: otherlv_0= 'Struct' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )?
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleStruct613); 

                	newLeafNode(otherlv_0, grammarAccess.getStructAccess().getStructKeyword_0());
                
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:294:1: ( (lv_name_1_0= RULE_ID ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:295:1: (lv_name_1_0= RULE_ID )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:295:1: (lv_name_1_0= RULE_ID )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:296:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStruct630); 

            			newLeafNode(lv_name_1_0, grammarAccess.getStructAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStructRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:312:2: (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==11) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:312:4: otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleStruct648); 

                        	newLeafNode(otherlv_2, grammarAccess.getStructAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:316:1: ( (lv_attributes_3_0= ruleAttribute ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:317:1: (lv_attributes_3_0= ruleAttribute )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:317:1: (lv_attributes_3_0= ruleAttribute )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:318:3: lv_attributes_3_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStructAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleStruct669);
                    	    lv_attributes_3_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStructRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_3_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleStruct682); 

                        	newLeafNode(otherlv_4, grammarAccess.getStructAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:338:3: (otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==14) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:338:5: otherlv_5= '{' ( (lv_entities_6_0= ruleEntity ) )* otherlv_7= '}'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleStruct697); 

                        	newLeafNode(otherlv_5, grammarAccess.getStructAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:342:1: ( (lv_entities_6_0= ruleEntity ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==13||(LA11_0>=16 && LA11_0<=17)) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:343:1: (lv_entities_6_0= ruleEntity )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:343:1: (lv_entities_6_0= ruleEntity )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:344:3: lv_entities_6_0= ruleEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getStructAccess().getEntitiesEntityParserRuleCall_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleEntity_in_ruleStruct718);
                    	    lv_entities_6_0=ruleEntity();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getStructRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"entities",
                    	            		lv_entities_6_0, 
                    	            		"Entity");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleStruct731); 

                        	newLeafNode(otherlv_7, grammarAccess.getStructAccess().getRightCurlyBracketKeyword_3_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStruct"


    // $ANTLR start "entryRuleRelationship"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:372:1: entryRuleRelationship returns [EObject current=null] : iv_ruleRelationship= ruleRelationship EOF ;
    public final EObject entryRuleRelationship() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationship = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:373:2: (iv_ruleRelationship= ruleRelationship EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:374:2: iv_ruleRelationship= ruleRelationship EOF
            {
             newCompositeNode(grammarAccess.getRelationshipRule()); 
            pushFollow(FOLLOW_ruleRelationship_in_entryRuleRelationship769);
            iv_ruleRelationship=ruleRelationship();

            state._fsp--;

             current =iv_ruleRelationship; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRelationship779); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationship"


    // $ANTLR start "ruleRelationship"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:381:1: ruleRelationship returns [EObject current=null] : (otherlv_0= 'Relationship' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )? ) ;
    public final EObject ruleRelationship() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_attributes_3_0 = null;

        EObject lv_start_8_0 = null;

        EObject lv_end_11_0 = null;


         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:384:28: ( (otherlv_0= 'Relationship' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )? ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:385:1: (otherlv_0= 'Relationship' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )? )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:385:1: (otherlv_0= 'Relationship' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )? )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:385:3: otherlv_0= 'Relationship' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )? (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )?
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleRelationship816); 

                	newLeafNode(otherlv_0, grammarAccess.getRelationshipAccess().getRelationshipKeyword_0());
                
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:389:1: ( (lv_name_1_0= RULE_ID ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:390:1: (lv_name_1_0= RULE_ID )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:390:1: (lv_name_1_0= RULE_ID )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:391:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleRelationship833); 

            			newLeafNode(lv_name_1_0, grammarAccess.getRelationshipAccess().getNameIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getRelationshipRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ID");
            	    

            }


            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:407:2: (otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==11) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:407:4: otherlv_2= '[' ( (lv_attributes_3_0= ruleAttribute ) )* otherlv_4= ']'
                    {
                    otherlv_2=(Token)match(input,11,FOLLOW_11_in_ruleRelationship851); 

                        	newLeafNode(otherlv_2, grammarAccess.getRelationshipAccess().getLeftSquareBracketKeyword_2_0());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:411:1: ( (lv_attributes_3_0= ruleAttribute ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==RULE_ID) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:412:1: (lv_attributes_3_0= ruleAttribute )
                    	    {
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:412:1: (lv_attributes_3_0= ruleAttribute )
                    	    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:413:3: lv_attributes_3_0= ruleAttribute
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRelationshipAccess().getAttributesAttributeParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAttribute_in_ruleRelationship872);
                    	    lv_attributes_3_0=ruleAttribute();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"attributes",
                    	            		lv_attributes_3_0, 
                    	            		"Attribute");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleRelationship885); 

                        	newLeafNode(otherlv_4, grammarAccess.getRelationshipAccess().getRightSquareBracketKeyword_2_2());
                        

                    }
                    break;

            }

            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:433:3: (otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==14) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:433:5: otherlv_5= '{' otherlv_6= 'start' otherlv_7= '=' ( (lv_start_8_0= ruleEntity ) ) otherlv_9= 'end' otherlv_10= '=' ( (lv_end_11_0= ruleEntity ) ) otherlv_12= '}'
                    {
                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleRelationship900); 

                        	newLeafNode(otherlv_5, grammarAccess.getRelationshipAccess().getLeftCurlyBracketKeyword_3_0());
                        
                    otherlv_6=(Token)match(input,18,FOLLOW_18_in_ruleRelationship912); 

                        	newLeafNode(otherlv_6, grammarAccess.getRelationshipAccess().getStartKeyword_3_1());
                        
                    otherlv_7=(Token)match(input,19,FOLLOW_19_in_ruleRelationship924); 

                        	newLeafNode(otherlv_7, grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_2());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:445:1: ( (lv_start_8_0= ruleEntity ) )
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:446:1: (lv_start_8_0= ruleEntity )
                    {
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:446:1: (lv_start_8_0= ruleEntity )
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:447:3: lv_start_8_0= ruleEntity
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationshipAccess().getStartEntityParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEntity_in_ruleRelationship945);
                    lv_start_8_0=ruleEntity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    	        }
                           		set(
                           			current, 
                           			"start",
                            		lv_start_8_0, 
                            		"Entity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_20_in_ruleRelationship957); 

                        	newLeafNode(otherlv_9, grammarAccess.getRelationshipAccess().getEndKeyword_3_4());
                        
                    otherlv_10=(Token)match(input,19,FOLLOW_19_in_ruleRelationship969); 

                        	newLeafNode(otherlv_10, grammarAccess.getRelationshipAccess().getEqualsSignKeyword_3_5());
                        
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:471:1: ( (lv_end_11_0= ruleEntity ) )
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:472:1: (lv_end_11_0= ruleEntity )
                    {
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:472:1: (lv_end_11_0= ruleEntity )
                    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:473:3: lv_end_11_0= ruleEntity
                    {
                     
                    	        newCompositeNode(grammarAccess.getRelationshipAccess().getEndEntityParserRuleCall_3_6_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEntity_in_ruleRelationship990);
                    lv_end_11_0=ruleEntity();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRelationshipRule());
                    	        }
                           		set(
                           			current, 
                           			"end",
                            		lv_end_11_0, 
                            		"Entity");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleRelationship1002); 

                        	newLeafNode(otherlv_12, grammarAccess.getRelationshipAccess().getRightCurlyBracketKeyword_3_7());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationship"


    // $ANTLR start "entryRuleAttribute"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:501:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:502:2: (iv_ruleAttribute= ruleAttribute EOF )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:503:2: iv_ruleAttribute= ruleAttribute EOF
            {
             newCompositeNode(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_ruleAttribute_in_entryRuleAttribute1040);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;

             current =iv_ruleAttribute; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAttribute1050); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:510:1: ruleAttribute returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token lv_value_2_0=null;

         enterRule(); 
            
        try {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:513:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:514:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:514:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:514:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:514:2: ( (lv_name_0_0= RULE_ID ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:515:1: (lv_name_0_0= RULE_ID )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:515:1: (lv_name_0_0= RULE_ID )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:516:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleAttribute1092); 

            			newLeafNode(lv_name_0_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_19_in_ruleAttribute1109); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getEqualsSignKeyword_1());
                
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:536:1: ( (lv_value_2_0= RULE_STRING ) )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:537:1: (lv_value_2_0= RULE_STRING )
            {
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:537:1: (lv_value_2_0= RULE_STRING )
            // ../fr.imag.exschema.dsl/src-gen/fr/imag/exschema/xtext/parser/antlr/internal/InternalExSchema.g:538:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleAttribute1126); 

            			newLeafNode(lv_value_2_0, grammarAccess.getAttributeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttribute"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleSchema_in_entryRuleSchema75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSchema85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleSchema123 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleSchema144 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleSchema157 = new BitSet(new long[]{0x0000000000032002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleSchema180 = new BitSet(new long[]{0x0000000000032002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity217 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet_in_ruleEntity274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStruct_in_ruleEntity301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationship_in_ruleEntity328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSet_in_entryRuleSet363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSet373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleSet410 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSet427 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_11_in_ruleSet445 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleSet466 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleSet479 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleSet494 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleSet515 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_15_in_ruleSet528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStruct_in_entryRuleStruct566 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStruct576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleStruct613 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStruct630 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_11_in_ruleStruct648 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleStruct669 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleStruct682 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleStruct697 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleStruct718 = new BitSet(new long[]{0x000000000003A000L});
    public static final BitSet FOLLOW_15_in_ruleStruct731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRelationship_in_entryRuleRelationship769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRelationship779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleRelationship816 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleRelationship833 = new BitSet(new long[]{0x0000000000004802L});
    public static final BitSet FOLLOW_11_in_ruleRelationship851 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_ruleAttribute_in_ruleRelationship872 = new BitSet(new long[]{0x0000000000001010L});
    public static final BitSet FOLLOW_12_in_ruleRelationship885 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_14_in_ruleRelationship900 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleRelationship912 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRelationship924 = new BitSet(new long[]{0x0000000000032000L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleRelationship945 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleRelationship957 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleRelationship969 = new BitSet(new long[]{0x0000000000032000L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleRelationship990 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleRelationship1002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute1040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAttribute1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleAttribute1092 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleAttribute1109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleAttribute1126 = new BitSet(new long[]{0x0000000000000002L});

}