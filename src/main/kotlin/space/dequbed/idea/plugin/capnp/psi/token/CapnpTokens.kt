package space.dequbed.idea.plugin.capnp.psi.token

import com.intellij.psi.tree.IElementType

object CapnpTokens {
    private val types: MutableMap<String, IElementType> = mutableMapOf()

    private fun put(element: IElementType): IElementType {
        return put(element.toString(), element)
    }

    private fun put(name: String, element: IElementType): IElementType {
        return types.getOrPut(name) {
            element
        }
    }

    fun get(token: String): IElementType {
        return types[token] ?: throw AssertionError("Unknown token type: $token")
    }

    @JvmField
    val ASSIGN = put(CapnpToken("="))
    @JvmField
    val COLON = put(CapnpToken(":"))
    @JvmField
    val SEMI = put(CapnpToken(";"))
    @JvmField
    val DOT = put(CapnpToken("."))
    @JvmField
    val COMMA = put(CapnpToken(","))
    @JvmField
    val AT = put(CapnpToken("@"))
    @JvmField
    val DOLLAR = put(CapnpToken("$"))

    @JvmField
    val LBRACE = put(CapnpToken("{"))
    @JvmField
    val RBRACE = put(CapnpToken("}"))
    @JvmField
    val LPAREN = put(CapnpToken("("))
    @JvmField
    val RPAREN = put(CapnpToken(")"))
    @JvmField
    val LBRAK = put(CapnpToken("["))
    @JvmField
    val RBRAK = put(CapnpToken("]"))

    @JvmField
    val ARROW = put(CapnpToken("->"))

    @JvmField
    val COMMENT = put(CapnpCommentToken("COMMENT"))

    @JvmField
    val SYMBOL = put(CapnpToken("SYMBOL"))

    @JvmField
    val IDENTIFIER_LITERAL = put("IDENTIFIER_LITERAL", CapnpToken("identifier"))
    @JvmField
    val TYPE_LITERAL = put("TYPE_LITERAL", CapnpToken("type"))

    @JvmField
    val STRING_LITERAL = put("STRING_LITERAL", CapnpToken("string"))
    @JvmField
    val INTEGER_LITERAL = put("INTEGER_LITERAL", CapnpToken("integer"))
    @JvmField
    val FLOAT_LITERAL = put("FLOAT_LITERAL", CapnpToken("float"))

    @JvmField
    val STRUCT = put(CapnpKeywordToken("struct"))
    @JvmField
    val ENUM = put(CapnpKeywordToken("enum"))
    @JvmField
    val UNION = put(CapnpKeywordToken("union"))
    @JvmField
    val GROUP = put(CapnpKeywordToken("group"))
    @JvmField
    val INTERFACE = put(CapnpKeywordToken("interface"))
    @JvmField
    val EXTENDS = put(CapnpKeywordToken("extends"))
    @JvmField
    val USING = put(CapnpKeywordToken("using"))
    @JvmField
    val IMPORT = put(CapnpKeywordToken("import"))
    @JvmField
    val ANNOTATION = put(CapnpKeywordToken("annotation"))
    @JvmField
    val CONST = put(CapnpKeywordToken("const"))
}