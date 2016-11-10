# 目录

[TOC]

------



# 0.模板信息

| 传入参数    | 传出参数    | 网址地址 |
| ------- | ------- | ---- |
| 名称(参数名) | 名称(参数名) | 网址   |

举例：

| 传入参数                 | 传出参数                        | 网址地址              |
| -------------------- | --------------------------- | ----------------- |
| 用户名(username string) | 是否已经被注册(isRegister boolean) | /user/hasUsername |



#1.木材计算模块(Web版本)

/calculate

## 1.1 计算木材单位材积

| 传入参数                       | 传出参数                   | 网址地址             |
| -------------------------- | ---------------------- | ---------------- |
| 木材检尺长(米) (length double)   | 材积(立方米)(volume double) | /volumeCalculate |
| 木材检尺径(厘米)(diameter double) | 错误信息(error int)        |                  |
| 木材品种(typeCode int)         |                        |                  |

requestBody:

```json
{
  "length": 1.3,
  "diameter": 15,
  "typeCode": 104
}
```
responseBody

```json
{
  "volume": 0.041,
  "error": 0
}
```
## 1.2 计算检尺类木材总材积

| 传入参数                         | 传出参数                    | 网址地址                 |
| ---------------------------- | ----------------------- | -------------------- |
| 1总木材(woodBaseList)->woodBase | 材积(立方米) (volume double) | /unitVolumeCalculate |
|                              | 错误信息(error int)         |                      |
woodBase(List element):

| 数据                          |
| --------------------------- |
| 木材检尺长(米) (length double)    |
| 木材检尺径(厘米) (diameter double) |
| 木材品种(typeCode int)          |
| 当前木材根数(num int)             |

requestBody:

```json
{
  "woodBaseList":[
    {"length": 1.3,"diameter": 15,"typeCode": 104,"num":10},
	{"length": 1.3,"diameter": 18,"typeCode": 104,"num":6},
	{"length": 1.3,"diameter": 19,"typeCode": 104,"num":8}
  ]
}
```


responseBody

```json
{
  "volume": 0.0489,
  "error": 0
}
```
## 1.3 设置木材默认价格（需要登录）

| 传入参数                               | 传出参数                 | 网址地址             |
| ---------------------------------- | -------------------- | ---------------- |
| 木材检尺长(米) (length double)           | 错误信息 (volume double) | /setDefaultPrice |
| 木材检尺径区间最大值(厘米)(maxDiameter double) |                      |                  |
| 木材检尺径区间最小值(厘米)(minDiameter double) |                      |                  |
| 木材品种(typeCode int)                 |                      |                  |
| 默认价格(defaultPrice double)          |                      |                  |

requestBody:

```json
{
  "length": 1.3,
  "minDiameter": 15,
  "maxDiameter": 45,
  "defaultPrice": 550.00
}
```
responseBody:

```json
{
 "error": 0
}
```
## 1.4 计算检尺类木材总价格

| 传入参数                | 传出参数                              | 网址地址          |
| ------------------- | --------------------------------- | ------------- |
| 总木材(woodList)->wood | 木材分类账单(woodBilList)->woodBillElem | /SumCalculate |
|                     | 检尺类计算总价(priceSum double)          |               |
|                     | 错误信息(error int)                   |               |
wood (list element)

| 数据                               |
| -------------------------------- |
| 木材检尺长(米) (length double)         |
| 木材检尺径(厘米) (diameter double)      |
| 木材品种(typeCode int)               |
| 当前木材根数(num int)                  |
| 【可选】当前木材单位价格(price double)       |
| 【可选】提价理由(priceUpReason string)   |
| 【可选】降价理由(priceDownReason string) |

woodBillElem (list element)

| 数据                           |
| ---------------------------- |
| 木材检尺长(米) (length double)     |
| 木材检尺径(厘米) (diameter double)  |
| 木材品种(typeCode int)           |
| 当前木材根数(num int)              |
| 当前木材单位价格(price double)       |
| 提价理由(priceUpReason string)   |
| 降价理由(priceDownReason string) |
| 当前节点总价(priceSumNode double)  |

requestBody:

```json
{
  "woodList":[
 	{"length":1.3,"diameter":15,"typeCode":104,"num":10,"price":560.00,"priceUpReason":"质量高"},
	{"length":1.3,"diameter":18,"typeCode":104,"num":6,"price":460.00,"priceDownReason":"腐烂"},
	{"length": 1.3,"diameter": 19,"typeCode": 104,"num":8}
  ]
}
```


 responseBody:

```json
{
  "woodBillList":[
	{"length":1.3,"diameter":15,"typeCode":104,"num":10,"price":560.00,"priceUpReason":"质量高","priceSumNode": 780.67},
	{"length":1.3,"diameter":18,"typeCode":104,"num":6,"price":460.00,"priceDownReason":"腐烂","priceSumNode": 580.77},
	{"length": 1.3,"diameter": 19,"typeCode": 104,"num":8}
  ],
 "priceSum": 1261.44,
 "error": 0
}
```
## 1.5 获取木材的默认价格(需要登录)

| 传入参数                        | 传出参数                              | 网址地址          |
| --------------------------- | --------------------------------- | ------------- |
| 木材检尺长(米) (length double)    | 默认价格(元/立方米) (defaultPrice double) | /defaultPrice |
| 木材检尺径(厘米) (diameter double) | 错误信息(error int)                   |               |
| 木材品种(typeCode int)          |                                   |               |

requestBody:

```json
{
  "length": 1.3,
  "diameter": 15,
  "typeCode": 104
}
```
responseBody

```json
{
  "defaultPrice": 800,
  "error": 0
}
```
## 1.6 保存一个木材计算账单（需要登录）

| 传入参数                                     | 传出参数            | 网站地址     |
| ---------------------------------------- | --------------- | -------- |
| 总检尺类木材（woodCheckList）woodCheckElem       | 错误信息(error int) | /saveAll |
| 总称重类木材（woodWeightList）woodWeightElem     |                 |          |
| 总半估值类木材（woodHalfEstimatList）woodHalfEstimateElem |                 |          |
| 总完全估值类木材（woodFullEstimateList）woodFullEstimateElem |                 |          |
| 【可选】附加奖金/罚金(rewardAndPunish double)      |                 |          |
| 【可选】附加奖金理由(rewardReason string)          |                 |          |
| 【可选】附加罚金理由(punishReason string)          |                 |          |

woodCheckElem (list element)

| 数据                               |
| -------------------------------- |
| 木材检尺长(米) (length double)         |
| 木材检尺径(厘米) (diameter double)      |
| 木材品种(typeCode int)               |
| 当前木材根数(num int)                  |
| 【可选】当前木材单位价格(price double)       |
| 【可选】提价理由(priceUpReason string)   |
| 【可选】降价理由(priceDownReason string) |

woodWeightElem (list element)

| 数据                               |
| -------------------------------- |
| 车皮质量(千克)(tare double)            |
| 总重(千克)(weight double)            |
| 【可选】当前木材单位价格(price double)       |
| 【可选】提价理由(priceUpReason string)   |
| 【可选】降价理由(priceDownReason string) |

woodHalfEstimateElem

| 数据                               |
| -------------------------------- |
| 【根径胸径二选一】根径(rootDiameter double) |
| 【根径胸径二选一】胸径(DBH double)          |
| 木材品种(typeCode int)               |
| 【可选】估值单价(price double)           |
| 【可选】提价理由(priceUpReason string)   |
| 【可选】降价理由(priceDownReason string) |

woodFullEstimateElem

| 数据                               |
| -------------------------------- |
| 木材品种(typeCode int)               |
| 估值材积(volume double)              |
| 【可选】估值价格(price double)           |
| 【可选】提价理由(priceUpReason string)   |
| 【可选】降价理由(priceDownReason string) |

requestBody

```json
{
  "woodCheckList":[
    {"length":1.3,"diameter":33,"typeCode":111,"num":12},
    {"length":1.3,"diameter":33,"typeCode":111,"num":12,"price":580.00,"priceUpReason":"质量比较好"}
  ],
  "woodWeightList":[
    {"tare":5600,"weight":7800},
	{"tare":5600,"weight":7800,"price":5780.00,"priceDownReason":"水分超标"}
  ],
  "woodFullEstimateList":[
    {"typeCode":111,"volume":60},
    {"typeCode":111,"volume":60,"price":788}
  ],
  "woodHalfEstimateList":[
    {"rootDiameter":45,"typeCode":123},
    {"GBH":35,"typeCode":24,"price":560.00,"priceDownReason":"水分超标"}
  ]
}
```



## 1.7 设置称重类木材单价（需要登录）



## 1.8 获取称重类木材总价格（需要登录）

## 1.9 核查总价格

## 1.10 获取当前卖方列表（需要登录）

## 1.11 增加卖方（需要登录）

#2 用户模块(web模块)
/usr
## 2.1 登录

| 传入参数                          | 传出参数               | 网址     |
| ----------------------------- | ------------------ | ------ |
| 登录名（邮箱或手机号）(loginName string) | 错误信息(error string) | /login |
| 密码(password  string)          | 密钥(token:string)   |        |
| 是否记住登录(remember boolean)     |                    |        |



## 2.2 注册

## 2.3 发送注册验证邮件

## 2.4 发送注册验证短信

## 2.5 发送找回密码验证邮件

## 2.6 发送找回密码验证短信

## 2.7 找回密码

## 2.8 退出

## 2.9 发送修改邮箱/手机验证短信

## 2.10 发送修改邮箱/手机验证邮件

## 2.11 查询密保

#3 财务数据（web模块）
/finance
## 3.1 月报表

## 3.2 年报表

## 3.3 筛选

## 3.4 导出指定的EXCEL

## 3.5 导出PDF文件

#4 数据分析（web模块）
/data
## 4.1 获取市场价格表

## 4.2 木材价格变动曲线

## 4.3 木材质量变动曲线

## 4.4 收购量变动曲线

## 4.5 木材品种和收购方式变动曲线

## 4.6 卖方饼状图

# 5. 木材计算模块（mobile模块）

/mobile/calculate

## 5.1 计算木材单位材积

## 5.2 计算木材总材积

## 5.3 设置木材默认价格（需要登录）

## 5.4 计算检尺类木材总价格

## 5.5 获取木材的默认价格（需要登录）

## 5.6 保存一个木材计算账单

## 5.7 设置称重类木材单价（需要登录）

## 5.8 获取称重类木材单价（需要登录）

## 5.9 核查总价格

## 5.10 获取当前卖方列表（需要登录）

## 5.11 增加卖方

# 6 用户模块(mobile模块)

/mobile/usr

## 6.1 登录

## 6.2 注册

## 6.3 发送注册验证邮件

## 6.4 发送注册验证短信

## 6.5 发送找回密码验证邮件

## 6.6 发送找回密码验证短信

## 6.7 找回密码

## 6.8 退出

## 6.9 发送修改邮箱/手机验证短信

## 6.10 发送修改邮箱/手机验证邮件

## 6.11 查询密保

# 7 财务数据（mobile模块）

/mobile/finance

## 7.1 月报表

## 7.2 年报表

## 7.3 筛选

## 7.4 导出指定的EXCEL

## 7.5 导出PDF文件

# 8 数据分析（mobile模块）

/mobile/data

## 8.1 获取市场价格表

## 8.2 木材价格变动曲线

## 8.3 木材质量变动曲线

## 8.4 收购量变动曲线

## 8.5 木材品种和收购方式变动曲线

## 8.6 卖方饼状图