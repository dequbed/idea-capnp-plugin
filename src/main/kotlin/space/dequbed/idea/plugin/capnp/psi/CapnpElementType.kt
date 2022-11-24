package space.dequbed.idea.plugin.capnp.psi

import com.intellij.psi.tree.IElementType
import space.dequbed.idea.plugin.capnp.CapnpLanguage

open class CapnpElementType(name: String) : IElementType(name, CapnpLanguage)