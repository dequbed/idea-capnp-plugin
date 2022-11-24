package space.dequbed.idea.plugin.capnp.psi

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiFile
import space.dequbed.idea.plugin.capnp.CapnpFileType
import space.dequbed.idea.plugin.capnp.CapnpLanguage

class CapnpFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, CapnpLanguage) {
    override fun getFileType(): FileType {
        return CapnpFileType.INSTANCE
    }

    override fun toString(): String {
        return "Cap'n Proto File"
    }
}
