package transform.fastClick;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;

/**
 * Created by zxb in 2021/3/24
 */
public class FastClickClassVisitor extends ClassVisitor {

    public FastClickClassVisitor(int i, ClassVisitor classVisitor) {
        super(i, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        def methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions);
        if (name == "onClick" && descript == "(Landroid/view/View)V"){
            return new FastMethodVisitor(api, methodVisitor, access, name, descriptor)
        } else {
            return methodVisitor;
        }

    }
}
