import soot.Scene
import soot.options.Options

object Runner {

    private const val ClassName = "Playground"
    private const val ClassPath = "build/classes/java/main"


    @JvmStatic
    fun main(args: Array<String>) {
        Options.v().parse(arrayOf("-cp", ClassPath, "-pp", ClassName))
        Scene.v().run {
            loadNecessaryClasses()
            val klass = loadClassAndSupport(ClassName)
            klass.setApplicationClass()
            val body = klass.methods.first { it.name == "main" }.retrieveActiveBody()
            body.units.forEach(::println)

        }
    }
}