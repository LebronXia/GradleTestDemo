package com.xiamu.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class MyPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        System.out.println("hello gradle plugin!");

        //将Extension注册给Plugin
        def extension = project.extensions.create("custom", CustomExtension)
        //定义一个任务
        project.task('CustomPluginTaskC') {
            doLast {
                println "接收外部参数：${extension.extensionArgs}"
            }
        }
    }
}