# pac4j-extends

## oauth-gitee

Gitee OAuth2.0 的 pac4j 客户端实现。

- `1.0.0` 编译 JDK 为 JDK 11。

依赖包引用：

```xml
<dependency>
    <groupId>fun.mortnon.pac4j</groupId>
    <artifactId>oauth-gitee</artifactId>
    <version>1.0.0</version>
</dependency>
```

java 代码：

```java
GiteeClient giteeClient = new GiteeClient("key", "secret");
```
