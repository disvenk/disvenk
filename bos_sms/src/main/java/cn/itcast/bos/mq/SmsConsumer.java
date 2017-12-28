package cn.itcast.bos.mq;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Service;

import com.aliyuncs.exceptions.ClientException;

import cn.itcast.bos.utils.SmsUtils;

@Service("smsConsumer")
public class SmsConsumer implements MessageListener {

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;

		// 调用SMS服务发送短信
		try {
			//使用阿里短信功能	
			try {
				SmsUtils.sendSms(mapMessage.getString("telephone"), mapMessage.getString("msg"));
			} catch (ClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//下面是一套动作，既发送了短信有得到了返回值
			// String result =
			// SmsUtils.sendSmsByHTTP(mapMessage.getString("telephone"),
			// mapMessage.getString("msg"));
			String result = "000/xxxx";
			if (result.startsWith("000")) {
				// 发送成功
				System.out.println("发送短信成功,手机号："
						+ mapMessage.getString("telephone") + "，验证码："
						+ mapMessage.getString("msg"));
			} else {
				// 发送失败
				throw new RuntimeException("短信发送失败, 信息码：" + result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
