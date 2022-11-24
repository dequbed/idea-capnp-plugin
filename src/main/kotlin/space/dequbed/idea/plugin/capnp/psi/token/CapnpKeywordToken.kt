package space.dequbed.idea.plugin.capnp.psi.token

import com.intellij.psi.tree.IElementType
import space.dequbed.idea.plugin.capnp.CapnpLanguage

open class CapnpKeywordToken(name: String) : IElementType(name, CapnpLanguage)
