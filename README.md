# pac4j-extends

## oauth-gitee

Gitee OAuth2.0 的 pac4j 客户端实现。

- `1.0.0` 版本，编译 JDK 为 `11`，依赖的 `pac4j` 版本为 `5.7.0`

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

- `0.0.8` 版本，编译 JDK 为 `8`，依赖的 `pac4j` 版本为 `4.5.7`

依赖包引用：

```xml
<dependency>
    <groupId>fun.mortnon.pac4j</groupId>
    <artifactId>oauth-gitee</artifactId>
    <version>0.0.8</version>
</dependency>
```

java 代码：

```java
GiteeClient giteeClient = new GiteeClient("key", "secret");
```
