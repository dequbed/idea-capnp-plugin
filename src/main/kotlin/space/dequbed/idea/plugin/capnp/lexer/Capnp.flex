package space.dequbed.idea.plugin.capnp.lexer;

import space.dequbed.idea.plugin.capnp.psi.token.CapnpTokens;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;

%%

%public
%class _CapnpLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%state COMMENT

Alpha = [a-zA-Z_]
Upper = [A-Z]
Lower = [a-z]
Digit = [0-9]
NonZeroDigit = [1-9]
HexDigit = [0-9a-fA-F]
OctDigit = [0-7]
Alphanumeric = {Alpha} | {Digit}

Symbol = [!#$%&()*+,-./;:<=>?@\[\\\]\^`{|}~]

WhitespaceNoNewline = [\ \t\r\f\x0b]
NewLine = "\n"
Whitespace = ({WhitespaceNoNewline} | {NewLine})+
LeadingWhitespace = {NewLine} {WhitespaceNoNewline}*

Comment = ("#" [^\n]*)
Comments = {Comment} ({LeadingWhitespace} {Comment})*

SingleQuotedString = \' ([^\\\'\n] | \\[^\n])* (\' | \\)?
DoubleQuotedString = \" ([^\\\"\n] | \\[^\n])* (\" | \\)?
String = {SingleQuotedString} | {DoubleQuotedString}

DecNumber = "0" | {NonZeroDigit} {Digit}*
HexNumber = "0" [xX] {HexDigit}+
OctNumber = "0" {OctDigit}+
Integer = {DecNumber} | {HexNumber} | {OctNumber}
Float = ("." {Digit}+ {Exponent}? | {DecNumber} "." {Digit}* {Exponent}? | {DecNumber} {Exponent})
Exponent = [eE] [-+]? {Digit}+

Identifier = {Lower} {Alphanumeric}*
Type = {Upper} {Alphanumeric}*

%%

<YYINITIAL> {
      {Whitespace} { return TokenType.WHITE_SPACE; }

      "=" { return CapnpTokens.ASSIGN; }

      ":" { return CapnpTokens.COLON; }
      ";" { return CapnpTokens.SEMI; }
      "." { return CapnpTokens.DOT; }
      "," { return CapnpTokens.COMMA; }
      "@" { return CapnpTokens.AT; }
      "$" { return CapnpTokens.DOLLAR; }

      "{" { return CapnpTokens.LBRACE; }
      "}" { return CapnpTokens.RBRACE; }
      "(" { return CapnpTokens.LPAREN; }
      ")" { return CapnpTokens.RPAREN; }
      "[" { return CapnpTokens.LBRAK; }
      "]" { return CapnpTokens.RBRAK; }

      "->" { return CapnpTokens.ARROW; }

      "struct" { return CapnpTokens.STRUCT; }
      "interface" { return CapnpTokens.INTERFACE; }
      "enum" { return CapnpTokens.ENUM; }
      "union" { return CapnpTokens.UNION; }
      "import" { return CapnpTokens.IMPORT; }
      "using" { return CapnpTokens.USING; }
      "annotation" { return CapnpTokens.ANNOTATION; }
      "const" { return CapnpTokens.CONST; }
      "extends" { return CapnpTokens.EXTENDS; }
      "group" { return CapnpTokens.GROUP; }

      {Identifier} { return CapnpTokens.IDENTIFIER_LITERAL; }
      {Type} { return CapnpTokens.TYPE_LITERAL; }

      {String} { return CapnpTokens.STRING_LITERAL; }
      {Integer} { return CapnpTokens.INTEGER_LITERAL; }
      {Float} { return CapnpTokens.FLOAT_LITERAL; }

      "#" {
          yypushback(1);
          yybegin(COMMENT);
      }

      {Symbol} { return CapnpTokens.SYMBOL; }
      [^] { return TokenType.BAD_CHARACTER; }
}

<COMMENT> {
    {Comments} { yybegin(YYINITIAL); return CapnpTokens.COMMENT; }
}