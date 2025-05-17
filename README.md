# Eight Booleans

What's better than boolean?

Answer for you. Eight booleans.

![img.png](img.png)

```java
import module dev.mccue.eightbooleans;

import java.io.IO;

void main() {
    var bools = EightBooleans.allTrue();

    IO.println(bools.get(0));
    IO.println(bools.getSecond());
    
    bools = bools.set(0, false).setFifth(false);
    
    IO.println(bools.get(0));
    IO.println(bools.getFifth());
}
```

```xml
<dependency>
    <groupId>dev.mccue</groupId>
    <artifactId>eightbooleans</artifactId>
    <version>2025.05.17</version>
</dependency>
```