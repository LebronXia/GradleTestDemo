package transform.fastClick

import com.android.build.api.transform.Transform
import org.gradle.api.Project
import transform.base.BaseTransformPlugin

class FastClickTransformPlugin extends BaseTransformPlugin {

    @Override
    Transform getCustomTransform(Project project) {
        return new FastClickTransform()
    }
}
