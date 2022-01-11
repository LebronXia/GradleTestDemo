package transform.fastClick

import groovyjarjarasm.asm.MethodVisitor
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter

import java.awt.Label

/**
 * Created by zxb in 2021/3/25
 */
class FastMethodVisitor extends AdviceAdapter{

    FastMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor)
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter()
        mv.visitMethodInsn(INVOKEDYNAMIC, "com/example/gradlestudy/FastClickUtil", "isFastDoubleClick", "()Z", false)
        Label label = new Label()
        mv.visitJumpInsn(IFEQ, label)
        mv.visitMethodInsn(RETURN)
        mv.visitLabel(label)
    }
}
