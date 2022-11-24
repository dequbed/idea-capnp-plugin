package space.dequbed.idea.plugin.capnp.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static space.dequbed.idea.plugin.capnp.psi.CapnpTypes.*;

%%

%{
  public _CapnpLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _CapnpLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

COMMENT=#[^\n]*\n?
IDENTIFIER_LITERAL=[a-zA-Z_][a-zA-Z0-9_]*
STRING_LITERAL=('(\\.|[^'\n])*')|(\"(\\.|[^\"\n])*\")
DECIMAL_DIGIT=[0-9]
DECIMAL_NONZERO=[1-9]
HEX_DIGIT=[0-9A-Fa-f]
OCTAL_DIGIT=[0-7]

%%
<YYINITIAL> {
  {WHITE_SPACE}             { return WHITE_SPACE; }

  "using"                   { return USING; }
  "struct"                  { return STRUCT; }
  "enum"                    { return ENUM; }
  "interface"               { return INTERFACE; }
  "annotation"              { return ANNOTATION; }
  "import"                  { return IMPORT; }
  "const"                   { return CONST; }

  {COMMENT}                 { return COMMENT; }
  {IDENTIFIER_LITERAL}      { return IDENTIFIER_LITERAL; }
  {STRING_LITERAL}          { return STRING_LITERAL; }
  {DECIMAL_DIGIT}           { return DECIMAL_DIGIT; }
  {DECIMAL_NONZERO}         { return DECIMAL_NONZERO; }
  {HEX_DIGIT}               { return HEX_DIGIT; }
  {OCTAL_DIGIT}             { return OCTAL_DIGIT; }

}

[^] { return BAD_CHARACTER; }
