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


## form 包

前段传来的 表单 用一个类来接收下 '

***@NotEmpty(message = "购物车不能为空")*** 不能为空
![](https://github.com/Francis11h/order/blob/master/src/image/6.png)


## 自定义异常

![](https://github.com/Francis11h/order/blob/master/src/image/7.png)


## 表单验证
@Valid OrderForm orderForm,
                       BindingResult bindingResult 这个存结果
![](https://github.com/Francis11h/order/blob/master/src/image/8.png)



## converter 

引入 google 工具 Gson
![](https://github.com/Francis11h/order/blob/master/src/image/9.png)

OrderDTO orderDTO = OrderForm2orderDTOConverter.convert(orderForm);
![](https://github.com/Francis11h/order/blob/master/src/image/10.png)

![](https://github.com/Francis11h/order/blob/master/src/image/11.png)


## 部分写完的 controller


![](https://github.com/Francis11h/order/blob/master/src/image/12.png)


## postman  测试 

![](https://github.com/Francis11h/order/blob/master/src/image/13.png)
