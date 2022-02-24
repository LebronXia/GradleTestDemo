package transform.hello

import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.FieldVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.commons.AdviceAdapter

//在方法中插入Hello
class HelloClassVisitor extends ClassVisitor{

    HelloClassVisitor(ClassVisitor classVisitor) {
        super(Opcodes.ASM7, classVisitor)
    }

    @Override
    MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        def methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions)

        return new HelloMethodVisitor(api, methodVisitor, access, name, descriptor)
    }

    @java.lang.Override
    FieldVisitor visitField(int access, java.lang.String name, java.lang.String descriptor, java.lang.String signature, java.lang.Object value) {

        return super.visitField(access, name, descriptor, signature, value)

    }

    class HelloMethodVisitor extends AdviceAdapter{

        /**
         * Constructs a new {@link AdviceAdapter}.
         *
         * @param api the ASM API version implemented by this visitor. Must be one of {@link
         *     Opcodes#ASM4}, {@link Opcodes#ASM5}, {@link Opcodes#ASM6} or {@link Opcodes#ASM7}.
         * @param methodVisitor the method visitor to which this adapter delegates calls.
         * @param access the method's access flags (see {@link Opcodes}).
         * @param name the method's name.
         * @param descriptor the method's descriptor (see {@link Type Type}).
         */
        protected HelloMethodVisitor(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
            super(api, methodVisitor, access, name, descriptor)
        }

        @Override
        protected void onMethodEnter() {
            super.onMethodEnter()
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;")
            mv.visitLdcInsn("Hello world");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false)
        }

        @java.lang.Override
        void visitCode() {
            super.visitCode()
            //方法开始

        }

        @java.lang.Override
        void visitInsn(int opcode) {
            super.visitInsn(opcode)
            //RETURN 之前

        }

        @java.lang.Override
        void visitEnd() {
            super.visitEnd()
        }
    }
}