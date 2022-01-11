package transform.hello;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;

import transform.base.BaseTransform;

/**
 * Created by zxb in 2021/3/20
 */
public class HelloTransform extends BaseTransform {
    @Override
    public ClassVisitor getClassVisitor(ClassWriter classWriter) {
        return new HelloClassVisitor(classWriter);
    }

    @Override
    public boolean isNeedTraceClass(File file) {
        def name = file.getName()
        if (!name.endsWith(".class")
        || name.startsWith("R.class")
                || name.startsWith('R$')){
            return false
        }
        return true;
    }

    @Override
    public String getName() {
        return "LifeTransform";
    }
}
