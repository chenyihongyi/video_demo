微信扫码登录和微信支付demo

1.签名校验地址:https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=20_1

2.微信⽀支付时序图 官⽅方⽂文档：
https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=6_5

3.使⽤用微信扫码完成⽀支付
参考资料料：https://blog.csdn.net/shenfuli/article/details/68923393
https://www.cnblogs.com/lanxiamo/p/6293580.html
二维码知识：https://coolshell.cn/articles/10590.html

4.微信⽀支付扫码回调开发
使⽤用Ngrock本地接收微信回调，并开发回调接⼝口
文档：https://pay.weixin.qq.com/wiki/doc/api/app/app.php?chapter=9_7&index=3
注意点：
回调要⽤用post⽅方式，微信⽂文档没有写回调的通知⽅方式
可以⽤用这个注解 @RequestMapping

5.微信回调处理理之更更新订单状态和幂等性
微信回调通知规则（通知频率为15/15/30/180/1800/1800/1800/1800/3600，单位：秒）
幂等性: 同样的参数和值，不不管调⽤用你的接⼝口多少次，响应结果都和调⽤用⼀一次是⼀一样的
1、校验签名是否正确，防⽌止伪造回调
2、查询订单是否已经更更新
3、若没更更新则更更新订单状态


错误码帮助文档:
https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1