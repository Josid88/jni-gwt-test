package net.josid.gdx.jnigwttest.desktop.jni;

import com.badlogic.gdx.jnigen.*;
import com.badlogic.gdx.jnigen.BuildTarget.TargetOs;


public class GdxTransformBuilder {

    public static void main(String[] args) throws Exception {
        String cFlags = ""; // Use this to enable debug
        //String cFlags = " -DNDEBUG";
        String[] headerDirs = { "gdx/include" };
        String[] cIncludes = { "gdx/src/*.c" };

        BuildTarget win32 = BuildTarget.newDefaultTarget(TargetOs.Windows, false);
        win32.compilerPrefix = "";
        win32.headerDirs = headerDirs;
        win32.cIncludes = cIncludes;
        win32.cFlags += cFlags + " -std=c99";

        BuildTarget win64 = BuildTarget.newDefaultTarget(TargetOs.Windows, true);
        win64.headerDirs = headerDirs;
        win64.cIncludes = cIncludes;
        win64.cFlags += cFlags + " -std=c99";

        new NativeCodeGenerator().generate("src/main/java", "target/classes", "jni");
        new AntScriptGenerator().generate(new BuildConfig("gdx-transform"), win32, win64);

        BuildExecutor.executeAnt("jni/build-windows32.xml", "-v", "-Drelease=true", "clean", "postcompile");
        BuildExecutor.executeAnt("jni/build-windows64.xml", "-v", "-Drelease=true", "clean", "postcompile");

        BuildExecutor.executeAnt("jni/build.xml", "-v", "pack-natives");
    }

}
