import java.net.URI;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import javax.tools.SimpleJavaFileObject;

public class CodeRunner {
    
    private static String DIR;

    JavaCompiler compiler;
    
    public CodeRunner() {
        compiler = ToolProvider.getSystemJavaCompiler();
        CodeRunner.class.getClassLoader();
        CodeRunner.DIR = ClassLoader.getSystemResource(".").getPath();
    }
    
    public boolean runCode(String code, int i) {
        JavaFileObject playerCode = new JavaSourceFromString("StayWithUs" + i, code);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(playerCode);
        
        CompilationTask task = compiler.getTask(null, null, null, Arrays.asList(new String[] { "-d", DIR}), null, compilationUnits);
        
        boolean compilationSuccess = task.call();
        
        if (compilationSuccess) {
            try {
                Class.forName("StayWithUs" + i).getDeclaredMethod("run", String.class).invoke(null, "WhiteMorning");
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }
}

class JavaSourceFromString extends SimpleJavaFileObject {
    private final String code;
    
    public JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.code = code;
    }
    
    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }
}
