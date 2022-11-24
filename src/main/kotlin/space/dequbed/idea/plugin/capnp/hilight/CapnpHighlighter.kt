package space.dequbed.idea.plugin.capnp.hilight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import space.dequbed.idea.plugin.capnp.lexer.CapnpLexer
import space.dequbed.idea.plugin.capnp.psi.token.CapnpTokens

class CapnpHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return CapnpHighlightLexer(CapnpLexer())
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(attributesMap[tokenType])
    }

    companion object {
        val ASSIGN = TextAttributesKey.createTextAttributesKey(
            "CAPNP_ASSIGN", DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val COLON = TextAttributesKey.createTextAttributesKey(
            "CAPNP_COLON", DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        val SEMI = TextAttributesKey.createTextAttributesKey(
            "CAPNP_SEMI", DefaultLanguageHighlighterColors.SEMICOLON
        )
        val DOT = TextAttributesKey.createTextAttributesKey(
            "CAPNP_DOT", DefaultLanguageHighlighterColors.DOT
        )
        val COMMA = TextAttributesKey.createTextAttributesKey(
            "CAPNP_COMMA", DefaultLanguageHighlighterColors.COMMA
        )

        val LBRACE = TextAttributesKey.createTextAttributesKey(
            "CAPNP_LBRACE", DefaultLanguageHighlighterColors.BRACES
        )
        val RBRACE = TextAttributesKey.createTextAttributesKey(
            "CAPNP_RBRACE", DefaultLanguageHighlighterColors.BRACES
        )
        val LPAREN = TextAttributesKey.createTextAttributesKey(
            "CAPNP_LPAREN", DefaultLanguageHighlighterColors.PARENTHESES
        )
        val RPAREN = TextAttributesKey.createTextAttributesKey(
            "CAPNP_RPAREN", DefaultLanguageHighlighterColors.PARENTHESES
        )
        val LBRAK = TextAttributesKey.createTextAttributesKey(
            "CAPNP_LBRAK", DefaultLanguageHighlighterColors.BRACKETS
        )
        val RBRAK = TextAttributesKey.createTextAttributesKey(
            "CAPNP_RBRAK", DefaultLanguageHighlighterColors.BRACKETS
        )

        val ARROW = TextAttributesKey.createTextAttributesKey(
            "CAPNP_ARROW", DefaultLanguageHighlighterColors.OPERATION_SIGN
        )

        val COMMENT = TextAttributesKey.createTextAttributesKey(
            "CAPNP_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT
        )

        val IDENTIFIER = TextAttributesKey.createTextAttributesKey(
            "CAPNP_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER
        )

        val TYPE = TextAttributesKey.createTextAttributesKey(
            "CAPNP_TYPE", DefaultLanguageHighlighterColors.LABEL
        )

        val STRING = TextAttributesKey.createTextAttributesKey(
            "CAPNP_STRING", DefaultLanguageHighlighterColors.STRING
        )
        val INTEGER = TextAttributesKey.createTextAttributesKey(
            "CAPNP_INTEGER", DefaultLanguageHighlighterColors.NUMBER
        )
        val FLOAT = TextAttributesKey.createTextAttributesKey(
            "CAPNP_FLOAT", DefaultLanguageHighlighterColors.NUMBER
        )

        val STRUCT = TextAttributesKey.createTextAttributesKey(
            "CAPNP_STRUCT", DefaultLanguageHighlighterColors.KEYWORD
        )
        val ENUM = TextAttributesKey.createTextAttributesKey(
            "CAPNP_ENUM", DefaultLanguageHighlighterColors.KEYWORD
        )
        val UNION = TextAttributesKey.createTextAttributesKey(
            "CAPNP_UNION", DefaultLanguageHighlighterColors.KEYWORD
        )
        val GROUP = TextAttributesKey.createTextAttributesKey(
            "CAPNP_GROUP", DefaultLanguageHighlighterColors.KEYWORD
        )
        val INTERFACE = TextAttributesKey.createTextAttributesKey(
            "CAPNP_INTERFACE", DefaultLanguageHighlighterColors.KEYWORD
        )
        val EXTENDS = TextAttributesKey.createTextAttributesKey(
            "CAPNP_EXTENDS", DefaultLanguageHighlighterColors.KEYWORD
        )
        val USING = TextAttributesKey.createTextAttributesKey(
            "CAPNP_USING", DefaultLanguageHighlighterColors.KEYWORD
        )
        val IMPORT = TextAttributesKey.createTextAttributesKey(
            "CAPNP_IMPORT", DefaultLanguageHighlighterColors.KEYWORD
        )
        val ANNOTATION = TextAttributesKey.createTextAttributesKey(
            "CAPNP_ANNOTATION", DefaultLanguageHighlighterColors.KEYWORD
        )

        val attributesMap = mapOf(
            CapnpTokens.ASSIGN to ASSIGN,
            CapnpTokens.COLON to COLON,
            CapnpTokens.SEMI to SEMI,
            CapnpTokens.DOT to DOT,
            CapnpTokens.COMMA to COMMA,

            CapnpTokens.LBRACE to LBRACE,
            CapnpTokens.RBRACE to RBRACE,
            CapnpTokens.LPAREN to LPAREN,
            CapnpTokens.RPAREN to RPAREN,
            CapnpTokens.LBRAK to LBRAK,
            CapnpTokens.RBRAK to RBRAK,

            CapnpTokens.ARROW to ARROW,

            CapnpTokens.COMMENT to COMMENT,

            CapnpTokens.IDENTIFIER_LITERAL to IDENTIFIER,

            CapnpTokens.TYPE_LITERAL to TYPE,

            CapnpTokens.STRING_LITERAL to STRING,
            CapnpTokens.INTEGER_LITERAL to INTEGER,
            CapnpTokens.FLOAT_LITERAL to FLOAT,

            CapnpTokens.STRUCT to STRUCT,
            CapnpTokens.ENUM to ENUM,
            CapnpTokens.UNION to UNION,
            CapnpTokens.GROUP to GROUP,
            CapnpTokens.INTERFACE to INTERFACE,
            CapnpTokens.EXTENDS to EXTENDS,
            CapnpTokens.USING to USING,
            CapnpTokens.IMPORT to IMPORT,
            CapnpTokens.ANNOTATION to ANNOTATION,
        )
    }
}