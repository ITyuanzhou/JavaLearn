单例模式四大原则：
1.构造私有
2.以静态方法或者枚举返回实例
3.确保实例只有一个，尤其是多线程环境
4.确保反序列化时不会重新构建对象

最好考虑懒加载问题（节约空间）
