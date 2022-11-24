package space.dequbed.idea.plugin.capnp.hilight

import com.intellij.lexer.DelegateLexer
import space.dequbed.idea.plugin.capnp.lexer.CapnpLexer

class CapnpHighlightLexer(delegate: CapnpLexer) : DelegateLexer(delegate) {
}
