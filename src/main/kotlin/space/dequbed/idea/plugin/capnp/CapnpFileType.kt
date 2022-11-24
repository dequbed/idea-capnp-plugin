package space.dequbed.idea.plugin.capnp

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class CapnpFileType : LanguageFileType(CapnpLanguage) {
    companion object {
        val INSTANCE = CapnpFileType()
    }

    override fun getName(): String {
        return CapnpLanguage.id
    }

    override fun getDescription(): String {
        return "Cap'n Proto"
    }

    override fun getDefaultExtension(): String {
        return "capnp"
    }

    override fun getIcon(): Icon? {
        return null
    }
}