package space.dequbed.idea.plugin.capnp

import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import space.dequbed.idea.plugin.capnp.lexer.CapnpLexer
import space.dequbed.idea.plugin.capnp.parser.CapnpParser
import space.dequbed.idea.plugin.capnp.psi.CapnpFile
import space.dequbed.idea.plugin.capnp.psi.CapnpTypes
import space.dequbed.idea.plugin.capnp.psi.token.CapnpTokens

class CapnpParserDef : ParserDefinition {
    override fun createLexer(project: Project): Lexer {
        return CapnpLexer()
    }

    override fun createParser(project: Project): PsiParser {
        return CapnpParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return file
    }

    override fun getCommentTokens(): TokenSet {
        return comments
    }

    override fun getStringLiteralElements(): TokenSet {
        return string
    }

    override fun createElement(node: ASTNode): PsiElement {
        return CapnpTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return CapnpFile(viewProvider)
    }

    companion object {
        val comments = TokenSet.create(CapnpTokens.COMMENT)
        val string = TokenSet.create(CapnpTokens.STRING_LITERAL)
        val file = IFileElementType(CapnpLanguage)
    }
}