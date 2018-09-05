package com.zhuye.ershoufang.bean;

public class AliPayBean {
    /**
     * data : app_id=2018012001993837&biz_content=%7B%22body%22%3A%22%E5%BB%BA%E5%BE%B7%E6%88%BF%E4%BA%A7%22%2C%22subject%22%3A+%22%E8%B4%AD%E4%B9%B0%E6%9F%A5%E7%9C%8B%E5%8D%B7%22%2C%22out_trade_no%22%3A+%2249%22%2C%22timeout_express%22%3A+%2290m%22%2C%22total_amount%22%3A+%220.01%22%2C%22seller_id%22%3A+%222088821832760313%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&method=alipay.trade.app.pay¬ify_url=http%3A%2F%2F%2A%2A%2A%2Findex.php%2Fapp%2Falipay%2Fview_back&sign_type=RSA2×tamp=2018-06-05+14%3A31%3A30&version=1.0&sign=XZM8nd95NOCpaWgidBkLBvsKIXs4Ke0oMBKHhjUKi2FcVSL2FDK84nQUVRn6tXpG95VeHIOFRuJx%2BvdWWg3QER54H%2FpzZnfpD3kwyC9eFtra0G3P4zEALD1pIlVFYp9K6B%2FzSaZpLIjbptkZAZFftcoO21wXophanKbQ86bLron0r87ym0U056FCaaRj1QXMlFiZjzYcUpPA6lIii1ews6zGpetnkP6jJtAMVe2oPnmr5U2wwJ%2BJ1zPZrtXN7aMpfJv6%2BkadJ%2BMqsJJym3JedsZ7Tb%2BqAXptvO0U37cXGTDT%2Bi91dQI98mi6YJSUOcNPwuKbDQgrSKe9RncbsMYCjA%3D%3D
     * message :
     * code : 200
     */

    private String data;
    private String message;
    private String code;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
