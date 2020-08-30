# ExpCalculator
Java编写的数学表达式计算器



## 支持的语法

支持运算符 `+`和`*`

支持括号 `(`和`)`

## 产生式

```
E -> E + T | T
T -> T * F | F
F -> (E) | N
```

其中各单元的含义如下

```
E: expression, 表达式
T: term, 表达式项
F: factor, 因子
N: number, 数字
ε：空字
```

消除左递归

```
E  -> TE'
E' -> +TE' | ε
T  -> FT'
T' -> *FT' | ε
F  -> (E) | N
```

求FIRST集合

```
FIRST(E)  = {(,N}
FIRST(E') = {+,ε}
FIRST(T)  = {(,N}
FIRST(T') = {*,ε}
FIRST(F)  = {(,N}
```

求FOLLOW集合

```
FOLLOW(E)  = {#,)}
FOLLOW(E') = {#,)}
FOLLOW(T)  = {+,#,)}
FOLLOW(T') = {+,#,)}
FOLLOW(F)  = {*,+,#,)}
```



## 扩充巴科斯范式

```
E -> T{+T}
T -> F{*F}
F -> (E) | N
```





 