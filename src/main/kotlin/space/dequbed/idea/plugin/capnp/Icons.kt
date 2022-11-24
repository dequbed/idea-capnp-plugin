package space.dequbed.idea.plugin.capnp

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object Icons {
    private fun loadIcon(name: String): Icon {
        return IconLoader.getIcon("/space/dequbed/idea/plugin/capnp/icon/$name", Icons::class.java)
    }
    val FILE: Icon = loadIcon("capnp_file.svg")
}