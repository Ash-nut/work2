package cn.helloworld1999.work2.util; /**
 *
 *//*


package cn.helloworld1999.community3.util;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.sdk.service.dysmsapi20170525.AsyncClient;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.sdk.service.dysmsapi20170525.models.SendSmsResponse;
import com.google.gson.Gson;
import darabonba.core.client.ClientOverrideConfiguration;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
public class getSMS extends HttpServlet {
    public static String getSMS() throws Exception {

        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                // Please ensure that the environment variables ALIBABA_CLOUD_ACCESS_KEY_ID and ALIBABA_CLOUD_ACCESS_KEY_SECRET are set.
                .accessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                .accessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"))
                //.securityToken(System.getenv("ALIBABA_CLOUD_SECURITY_TOKEN")) // use STS token
                .build());

        // Configure the Client
        AsyncClient client = AsyncClient.builder()
                .region("cn-hangzhou")
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();
        Random random = new Random();
        String ranStr = String.valueOf((int) ((Math.random() * 9 + 1) * Math.pow(10, 5)));
// Parameter settings for API request
        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers("15146878867")
                .signName("学习笔记网站")
                .templateCode("SMS_469015340")
                .templateParam("{\"code\":\"" + ranStr + "\"}")
                .build();

        // Asynchronously get the return value of the API request
        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        // Synchronously get the return value of the API request
        SendSmsResponse respFromAli = response.get();
        SendSmsResponse respSMS = response.get();
        Map<String,Object> map = new HashMap<>();
        System.out.println(new Gson().toJson(respSMS));
        if (new Gson().toJson(respSMS).contains(",\"code\":\"OK\",\"message\":\"OK\",")){
            return ranStr;
        }
        // Finally, close the client
        client.close();
        return "F";
    }

}
*/
