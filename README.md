# try-finally

#try-finally的返回值也是java程序猿经常问的一个问题，能够真正回答好的也是少数，最近自己也稍微的研究下
#首先可以看看上面这几个程序的返回值是多少
![程序](https://github.com/huang054/try-finally/blob/master/test.png)
test()方法的返回值为0
test1()方法的返回值为3
test2()方法的返回值为hello world
test3()方法的返回值为hello world demo
为什么差异这么大了，首先我们得搞清楚jvm得内存结构  比如1.8
分为 堆 栈 程序计数器 本地方法 元空间
而我们得程序运行都是在栈里面运行得，return 只是返回栈顶得元素
知道了这些我们可以通过 javac 来把java文件编译成class文件，然后通过javap -c  或者javap -verbose 查看他得字节码
比如test（）方法得字节码为
![程序](https://github.com/huang054/try-finally/blob/master/test1.png)
此处我们可以发现7:ireturn 和 13:ireturn两处返回
相当于把当前i得值压进栈顶，由于13处是catch，本程序没有异常，所以只会执行7得return压进栈顶的元素为0
下面我们来看看test1（）方法
![程序](https://github.com/huang054/try-finally/blob/master/test2.png)
我们可以看到 3  8  11都执行了ireturn，通过程序对比发现为try catch finally 的三处return语句，
由于finally是最后最终执行，所以栈顶的元素肯定是finally的值，所以结果为3
下面我们来看看test2（）
![程序](https://github.com/huang054/try-finally/blob/master/test3.png)
其实和test差不多，所以运行结果也和test（）类似，为什么要举这个例子是为了对比test3
好了现在看看test3（）方法
![程序](https://github.com/huang054/try-finally/blob/master/test4.png)
为什么test3和test2运行结果不一样了，因为StringBuilder是一个对象，他是一个引用，
我们发泄在areturn前面都进行的是pop 和aload指令，pop是从栈顶拿处元素，然后aload是重新载入，我们在47 48 处也发了
pop  aload指定，可以判定，最后在finally语句改变了栈顶元素，所以与test2方法return的值不是一样，
这里我们可以大胆的猜测这是值传递和引用传递的区别，而值传递是不需要pop aload的所以两者有差别
