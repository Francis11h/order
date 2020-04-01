# order
microservice

## 配置

![注解一定得加](https://github.com/Francis11h/order/blob/master/src/image/1.png)


## controller
先列出目标
![](https://github.com/Francis11h/order/blob/master/src/image/2.png)




## DTO

由于 create 要用到 两者 orderMaster orderDetail
create(orderMaster, orderDetail);
所以 可以用 一个 新的对象 把两者关联起来 然后 方便 其在本project中的使用
dto data transfer object 数据传输对象
入参是 orderdto 返回也是
OrderDTO create(OrderDTO orderDTO)

![](https://github.com/Francis11h/order/blob/master/src/image/3.png)


## service
![](https://github.com/Francis11h/order/blob/master/src/image/5.png)


## 生成随机ID

随机数 + 当前时间 System.currentTimeMillis() 
同时 synchronized 防止同时访问

![](https://github.com/Francis11h/order/blob/master/src/image/4.png)






