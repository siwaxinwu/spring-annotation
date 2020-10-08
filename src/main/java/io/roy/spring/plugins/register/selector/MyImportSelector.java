package io.roy.spring.plugins.register.selector;

import io.roy.spring.plugins.register.bean.Role;
import io.roy.spring.plugins.register.bean.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.function.Predicate;

/**
 * description：
 * author：dingyawu
 * date：created in 16:27 2020/8/6
 * history:
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值为需要导入到容器中的bean的全类名数组
     * AnnotationMetadata：当前标注@Import注解的类的所有注解信息
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{
                User.class.getName(), Role.class.getName()
        };
    }
}
