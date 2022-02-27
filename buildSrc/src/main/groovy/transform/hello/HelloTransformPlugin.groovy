package transform.hello;

import com.android.build.api.transform.Transform
import com.android.build.gradle.internal.PluginInitializer;
import org.gradle.api.Project;

import transform.base.BaseTransformPlugin;

/**
 * Created by zxb in 2021/3/20
 */
class HelloTransformPlugin extends BaseTransformPlugin {
    @Override
     Transform getCustomTransform(Project project) {

        ////在方法中插入Hello
        return new HelloTransform();
    }


}
