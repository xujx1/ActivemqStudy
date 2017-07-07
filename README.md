# ActivemqStudy
消息中间件Activemq学习


#消息头(Header)属性
消息头				分配方式			描述
JMSDestination		自动				消息发送的目的地：主要是指Queue和Topic。
JMSDeliveryMode		自动				传送模式有两种模式：持久模式和非持久模式。一条持久性的消息应该被传送“一次仅仅一次”，这就意味者如果JMS提供者出现故障，该消息并不会丢失，它会在服务器恢复之后再次传递。一条非持久的消息最多会传送一次，这意味这服务器出现故障，该消息将永远丢失。
JMSExpiration		自动				消息过期时间，等于Destination 的send 方法中的timeToLive值加上发送时刻的GMT 时间值。如timeToLive 值等于零，则JMSExpiration 被设为零，表示该消息永不过期。如果发送后，在消息过期时间之后消息还没有被发送到目的地，则该消息被清除。
JMSPriority 		自动				消息优先级，从0-9 十个级别，0-4 是普通消息，5-9 是加急消息。JMS 不要求JMS Provider 严格按照这十个优先级发送消息，但必须保证加急消息要先于普通消息到达。默认是4级。
JMSMessageID 		自动				唯一识别每个消息的标识，由JMS Provider 产生。
JMSTimestamp 		自动				一个JMS Provider在调用send()方法时自动设置的。它是消息被发送和消费者实际接收的时间差。
JMSCorrelationID 	开发者设置  		用来连接到另外一个消息，典型的应用是在回复消息中连接到原消息。在大多数情况下，JMSCorrelationID用于将一条消息标记为对JMSMessageID标示的上一条消息的应答，不过，JMSCorrelationID可以是任何值，不仅仅是JMSMessageID。
JMSTimestamp 		自动				一个消息被提交给JMSProvider 到消息被发出的时间。
JMSReplyTo			开发者设置		提供本消息回复消息的目的地址。
JMSType				开发者设置		消息类型的识别符。
JMSRedelivered		自动				如果一个客户端收到一个设置了JMSRedelivered属性的消息，则表示可能客户端曾经在早些时候收到过该消息，但并没有签收(acknowledged)。如果该消息被重新传送，JMSRedelivered=true反之，JMSRedelivered = false。

#消息体(Body)
JMS API 定义了5 种消息体格式，也叫消息类型，可以使用不同形式发送接收数据并可以兼容现有的消息格式，下面描述这5 种类型：

消息类型					    消息体
TextMessage 				java.lang.String 对象，如xml 文件内容。
MapMessage 					名/值对的集合，名是String 对象，值类型可以是Java 任何基本类型。
BytesMessage 				字节流
StreamMessage 				Java 中的输入输出流。
ObjectMessage  				Java 中的可序列化对象。


#消息的确认
如果会话是事务性的，那么消息确认自动由commit 处理，且恢复自动由rollback 处理。如果会话不是事务性的，有三个确认选择，且手工处理恢复。

DUPS_OK_ACKNOWLEDGE——这个选项告诉会话懒惰确认消息的传递。如果JMS 失败，这很可能造成传递重复消息，因此这个选项只用于可以忍受重复消息的消费者。它的好处是减少了会话为防止重复所要做的工作。

AUTO_ ACKNOWLEDGE——使用这个选项，当消息被成功地从调用接收返回或处理消息的MessageListener 成功返回时，会话自动确认客户端的消息接收。

CLIENT_ ACKNOWLEDGE——使用这个选项，客户端通过调用消息的acknowledge 方法来确认消息。确认一个被消费的消息会自动确认被该会话转发的所有消息。
当使用CLIENT_ ACKNOWLEDGE 模式时，客户端可以在处理它们时产生大量未确认消息。
JMS 提供商应当为管理员提供限制客户端超量运行的途径，以便客户端不会造成资源耗尽并保证当它们使用的资源被临时阻塞时造成失败。
会话的recover 方法用于停止一个会话然后使用第一个未确认消息来重新启动它。事实上，会话的被转发消息序列被重新设置到最后一个确认消息之后。
现在转发的消息序列可以与起初转发的消息序列不同，因为消息到期和收到更高优先级的消息。会话必须设置消息的redelivered 标记，表示它是由于恢复而被重新转发。