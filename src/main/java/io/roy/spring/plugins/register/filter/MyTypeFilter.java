package io.roy.spring.plugins.register.filter;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * description：自定义@componentScan的过滤规则
 * author：dingyawu
 * date：created in 20:25 2020/8/5
 * history:
 */
public class MyTypeFilter implements TypeFilter {
    /**
     * metadataReader：读取到的当前正在扫描的类的信息
     * metadataReaderFactory：可以获取到其他任务类的信息
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类注解的信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //获取当前正在扫描的类的信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //获取当前类的资源信息，例如：类的路径等信息
        Resource resource = metadataReader.getResource();
        //获取当前正在扫描的类名
        String className = classMetadata.getClassName();
        //打印当前正在扫描的类名
        System.out.println("-----> " + className);
        return className.contains("person");
    }
}
