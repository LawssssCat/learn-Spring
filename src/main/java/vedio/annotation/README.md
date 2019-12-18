**在 classpath 中扫描组件**：

+ @Component:基本注解
+ @Respository:持久层
+ @Service:服务层
+ @Controller:表现层


`<context:component-scan>`
- base-package
- resource-pattern

`<context:component-scan 
    base-package="con........baens" 
    resource-pattern=".../*.class">`

- `<contextinclude-filter>` -  子节点表示要**包含**的目标类
- `<contextexclude-filter>` -  排除