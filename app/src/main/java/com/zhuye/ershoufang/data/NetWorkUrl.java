package com.zhuye.ershoufang.data;

/**
 * Created by Administrator on 2018/1/2.
 */

public class NetWorkUrl {
    public static final String SUCCESS = "200";
    public static final String ERROR = "201";
    public static final String Invalidate = "288";//token失效
    public static final String WEIXIN_APP_ID = "wxd5adc715f0b00d71";
    public static final String WEIXIN_APP_SECRET = "5097145cb4866edc1aacf0ba6bb5937b";
    public static final String QQ_APP_ID = "1106578310";

//    bd532c5a248f63f2e14ebe67364d01da 微信签名
//    public static final String ERROR = "202";


//    public static final String BASE =
//            "http://192.168.1.42/jdhouse/";

//
    public static final String BASE =
            "http://www.jdfcw.com/";

//    public static final String BASE =
//            "http://jd.zyeo.net/";

    public static final int NETWORKERROR = 50078;
    public static final int SELECECODE = 50000;
    public static final int JIEDANCODE = 50001;
    public static final int FANGWULEIXING = 14598;
    public static final int FUKUANFANGS = 50002;
    public static final int GONGCHANGYFCODE = 51002;
    public static final int ZHUANGTAICODE = 50415;
    public static final int HANGYECODE = 50414;
    public static final int SHANGOUZHUANGTAI = 50014;
    public static final int SUOZAICODE = 50114;
    public static final int FUKUANCODE = 54014;
    public static final int YAFUCODE = 50015;
    public static final int CHUZUFANGSHI = 50004;
    public static final int ZHUANGXIUXINGK = 50003;
    public static final int FANGWULEIXINGCODE = 50010;
    public static final String LOGIN = "";
    public static final String REGEIST = "index.php/App/passport/register";
    public static final String GET_CODE = "index.php/App/passport/code";
    public static final String IMAGEURL =BASE + "attachs/";

    public static final String DEFAULTIMAGEURL =IMAGEURL + "/default.jpg";
    // 个人中心--资料编辑
    public static final String EDIT_ZL = "index.php/app/user/edit_zl";
    public static final String ZILIAO = "index.php/app/user/ziliao";

    public static final String MODIFY_PASS = "index.php/app/user/modify_pass";
    //绑定手机号
    public static final String BIND_MOBILE = "index.php/app/user/bind_mobile";
    // public static final String BIND_MOBILE = "/index.php/app/user/bind_mobile";
    public static final String MY_QUESTION = "index.php/app/question/my_question";
    public static final String QUESTIONFABU = "index.php/app/question/fabu";
    public static final String DEL_QUESTION = "index.php/app/question/del_question";


    //房产问答  房产问答--详情
    public static final String QUESTIONDETAIL = "index.php/app/question/detail";
    //问答模块  房产问答
    public static final String QUESTIONINDEX= "index.php/app/question/index";
    //房产问题--回答加载
    public static final String ANSWER= "index.php/app/question/answer";
    //提交回答
    public static final String SUB_ANSWER= "index.php/app/question/sub_answer";


    //登录注册  忘记密码
    public static final String FORGET = "index.php/app/passport/forget";
    // 忘记密码--修改密码
    public static final String SET_PASSPORT = "index.php/app/passport/set_passport";
    //三方登录
    public static final String THIRD_LOGINT = "index.php/app/passport/third_login";
    public static final String AREA = "index.php/app/index/area";



    // 个人中心  卖房模块
    public static final String SELLHOUSELISTS = "index.php/app/sellhouse/lists";
    // 城市--四级
    public static final String SIJICITY = "index.php/app/index/city";
    // 多图片上传--返回上传图片地址
    public static final String IMG = "index.php/app/Sellhouse/img";
    // 租房|卖房-发布|编辑--单选-多选内容
    public static final String SELECT = "index.php/app/index/select";
    // 发布（二手房、商铺、工厂、写字楼）
    public static final String FABU = "index.php/app/sellhouse/fabu";
    // 编辑--展示
    public static final String VIEW = "index.php/app/sellhouse/view";

    // 发布（二手房、商铺、工厂、写字楼）
    public static final String ESFABU = "index.php/app/sellhouse/esfabu";

    // 发布（租房）
    public static final String CZFABU = "index.php/app/lease/czfabu";

    // 发布（租房）
    public static final String ESVIEW = "index.php/app/sellhouse/esview";

    // 编辑（二手房）-提交
    public static final String ESEDIT = "index.php/app/sellhouse/esedit";

    // 编辑（二手房、商铺、工厂、写字楼）
    public static final String EDIT = "index.php/app/sellhouse/edit";
    // 编辑（二手房、商铺、工厂、写字楼）
    public static final String DEL_HOUSE = "index.php/app/sellhouse/del_house";

    // 编辑（二手房、商铺、工厂、写字楼）
    public static final String PROVINCE = "index.php/app/index/province";


    // 编辑（二手房、商铺、工厂、写字楼）
    public static final String XIAJI = "index.php/app/index/xiaji";

    // 个人中心  出租

    // 编辑（二手房、商铺、工厂、写字楼）
    public static final String CHUZUFABU = "index.php/app/lease/fabu";

    // 列表
    public static final String CHUZULISTS= "index.php/app/lease/lists";




    //个人中心 委托卖房|出租---列表
    public static final String WTSELL= "index.php/app/user/wtsell";
    //个人中心 委托卖房|出租---列表
    public static final String QTWT= "index.php/app/user/qtwt";
    //个人中心 委托卖房|出租---列表
    public static final String WDAIKUAN= "index.php/app/user/wdaikuan";



    //个人中心  拍卖  新增拍卖
    public static final String BIDDER_FABU= "index.php/app/bidder/fabu";
    //个人中心  拍卖  我的拍卖
    public static final String MY_BIDDER= "index.php/app/bidder/my_bidder";
    //个人中心  拍卖  流拍编辑--展示
    public static final String EDIT_VIEW= "index.php/app/bidder/edit_view";
    //个人中心  拍卖  我的拍卖
    public static final String SUB_EDIT= "index.php/app/bidder/sub_edit";
    //个人中心  拍卖  	委托拍卖-参与拍卖
    public static final String MY_WTBIDDER= "index.php/app/bidder/my_wtbidder";
    //个人中心  拍卖  委托拍卖--保证金
    public static final String BIDDER_BOND= "index.php/app/bidder/bidder_bond";
    //个人中心  拍卖  委托拍卖--我的提醒
    public static final String BIDDER_TX= "index.php/app/bidder/bidder_tx";
    //个人中心  拍卖  委托拍卖--已拍下
    public static final String MY_MALLBIDDER= "index.php/app/bidder/my_mallbidder";


    //个人中心  拍卖  小区选择
    public static final String XIAOQU= "index.php/app/index/xiaoqu";





    //主页   发布   委托买房--发布
    public static final String WMALL_FABU= "index.php/app/sellhouse/wmall_fabu";
    //主页   发布   委托求租----发布
    public static final String QZU= "index.php/app/sellhouse/qzu";
    //主页   发布   委托求租----委托办证|委托贷款--发布
    public static final String WPERMIT_FABU= "index.php/app/sellhouse/wpermit_fabu";
    //主页   发布   委托卖房|出租---发布
    public static final String WSELL_FABU= "index.php/app/sellhouse/wsell_fabu";

    //需求大厅--卖房|求租
    public static final String MALL= "index.php/app/demand/mall";

    //需求大厅--卖房|出租
    public static final String PHOUSE= "index.php/app/demand/phouse";

    //主页   发布   需求大厅-- 买房|求租--详情
    public static final String MALL_DETAIL= "index.php/app/demand/mall_detail";
    //主页   发布   需求大厅--卖房|出租--详情
    public static final String PHOSE_DETAIL= "index.php/app/demand/phose_detail";
    //主页   发布   需求大厅--办证|贷款--详情
    public static final String DAIKUAN_DETAIL= "index.php/app/demand/daikuan_detail";

    //主页   发布   需求大厅--办证|贷款
    public static final String DAIKUAN= "index.php/app/demand/daikuan";

    //个人中心  经纪人  经纪人资料
    public static final String DATA= "index.php/app/agent/data";
    //个人中心  经纪人资料--提交
    public static final String SUB_DATA= "index.php/app/agent/sub_data";
    //个人中心  经纪人  设置
    public static final String JINJIRENSE= "index.php/app/agent/set/token";
    //个人中心  经纪人  设置编辑--提交
    public static final String SUB_SET= "index.php/app/agent/sub_set";
//    //个人中心  经纪人  设置编辑--提交
//    public static final String SUB_SET= "index.php/app/agent/sub_set";

        //个人中心  经纪人  设置--身份认证
    public static final String RENZHENG= "index.php/app/agent/renzheng";
    //个人中心  经纪人  更换绑定手机号--步骤1
    public static final String CHANGE_MOBILE= "index.php/app/passport/change_mobile";

    //个人中心  经纪人  更换绑定手机号--步骤1
    public static final String NEW_MOBILE= "index.php/app/passport/new_mobile";

    //首页  定位返回定位id
    public static final String DINGWEI= "index.php/app/index/dingwei";
    //首页  二手房|租房
    public static final String INDEX= "index.php/app/house/index";
    //首页  二手房|租房
    public static final String BIDDER_LIST= "index.php/app/bidder/bidder_list";
    //首页  二手房|租房
    public static final String BIDDER_DETAIL= "index.php/app/bidder/bidder_detail";
    //首页 拍卖--设置提醒
    public static final String REMIND= "index.php/app/bidder/remind";
    //首页 拍卖--拍卖-竞拍
    public static final String CJ_BIDDER= "index.php/app/bidder/cj_bidder";


    //首页 首页
    public static final String HOMEINDEX= "index.php/app/index/index";
    //首页 活动优惠|刚需房
    public static final String ACTIVITY= "index.php/app/index/activity";

    //首页 新房-列表||商铺写字楼--商铺新盘、写字楼新盘
    public static final String INDEXNEWHOUSE= "index.php/app/indexnewhouse/newhouse";

    //首页 首页--经纪人列表
    public static final String AGENT_LIST= "index.php/app/agent/agent_list";

    //首页 首页--经纪人列表
    public static final String NEWHOUSE_DETAIL= "index.php/app/indexnewhouse/newhouse_detail";

    //首页 获取单个--多选
    public static final String SSELECT= "index.php/app/index/sselect";


    //首页 装修--列表
    public static final String ZHUANGXIU= "index.php/app/home/zhuangxiu";
    //首页 装修--列表
    public static final String JIAJU= "index.php/app/home/jiaju";
    //首页 家居--详情
    public static final String DETAIL= "index.php/app/home/detail";
    //首页 家居--详情
    public static final String JIAJU_SHOP= "index.php/app/home/jiaju_shop";
    //首页 家具商-产品--详情
    public static final String PRO_DETAIL= "index.php/app/home/pro_detail";

    //首页 免费看房-列表
    public static final String VIEW_LIST= "index.php/app/indexnewhouse/view_list";
    //首页 新房-列表
    public static final String NEWHOUSE= "index.php/app/indexnewhouse/newhouse";
    //首页 新房-列表
    public static final String VIEW_BM= "index.php/app/indexnewhouse/view_bm";
    //首页 新房-列表
    public static final String VIEW_DETAIL= "index.php/app/indexnewhouse/view_detail";

    //首页 找小区
    public static final String FIND_XIAOQU= "index.php/app/index/find_xiaoqu";



    //个人中心  家具商  设置编辑--提交
    public static final String JIAJULISTS= "index.php/app/home/lists";
    //个人中心  家具商  产品--编辑展示
    public static final String JIAJUVIEW= "index.php/app/home/view";
    //个人中心  家具商  发布产品
    public static final String JIAJUFABU= "index.php/app/home/fabu";
    //个人中心  家具商  产品--编辑提交
    public static final String JIAJUEDIT= "index.php/app/home/edit";
    //个人中心  家具商  产品--删除
    public static final String JIAJUDELETE= "index.php/app/home/delete";

    //个人中心  家居商|装修商资料
    public static final String MESSAGE= "index.php/app/home/message";

    //个人中心  房产商  个人信息
    public static final String FANGCHANDATA= "index.php/app/newhouse/data";
    //个人中心  楼盘--发布
    public static final String NEWHOUSEFABU= "index.php/app/newhouse/fabu";
    //个人中心  楼盘--列表
    public static final String NEWHOUSE_LIST= "index.php/app/newhouse/newhouse_list";
    //个人中心  免费看房--列表
    public static final String MIANVIEW_LIST= "index.php/app/newhouse/view_list";
    //个人中心  免费看房--发布
    public static final String VIEW_FABU= "index.php/app/newhouse/view_fabu";

    //个人中心  免费看房--获取楼盘
    public static final String VIEW_LOUPAN= "index.php/app/newhouse/view_loupan";
    //个人中心  楼盘--编辑--展示
    public static final String NEWHOUSE_EDIT= "index.php/app/newhouse/newhouse_edit";
    //个人中心 楼盘--编辑--提交
    public static final String NEWHOUSE_SUB= "index.php/app/newhouse/newhouse_sub";
    //个人中心 免费看房  楼盘--编辑--展示
    public static final String HVIEW_VIEW= "index.php/app/newhouse/hview_view";
    //个人中心 免费看房  免费看房-编辑--提交
    public static final String VIEW_SUB= "index.php/app/newhouse/view_sub";

    //个人中心 置顶卷--列表
    public static final String JUAN= "index.php/app/home/juan";

    //个人中心 置顶卷--列表
    public static final String COLLECT= "index.php/app/index/collect";

    //个人中心 估价
    public static final String GUJI= "index.php/app/home/guji";

    //个人中心 收藏--新房
    public static final String NEWHOUSE_COLLECT= "index.php/app/user/newhouse_collect";

    //个人中心 我的收藏--二手房|租房
    public static final String LIFE_CANG= "index.php/app/user/life_cang";


    //个人中心 我的收藏--商铺写字楼
    public static final String BUILDING= "index.php/app/user/building";

    //个人中心 我的收藏--家居|装修
    public static final String SHOP_COLLECT= "index.php/app/user/shop_collect";


    //个人中心 取消收藏
    public static final String DEL_COLLECT= "index.php/app/user/del_collect";

    //个人中心 我的收藏--工业厂房
    public static final String PLANT_COLLECT= "index.php/app/user/plant_collect";


    //个人中心 免费看房
    public static final String MYBM= "index.php/app/user/mybm";


    //个人中心地图--根据定位城市获取房源总数（卖房|租房）
    public static final String MAPLIFE_COUNT= "index.php/app/index/maplife_count";


    //地图--根据定位城市获取下级新房总数
    public static final String MAPNEWHOUSE_COUNT= "index.php/app/index/mapnewhouse_count";

    //地图--需求大厅--接单
    public static final String JIEDAN= "index.php/app/demand/jiedan";

    //个人中心 免费看房
    public static final String QHCITY= "index.php/app/index/qhcity";


    //个人中心 消息--列表
    public static final String XIAOXI= "index.php/app/user/xiaoxi";
    //个人中心 消息--详情
    public static final String XX_DETAIL= "index.php/app/user/xx_detail";


    //首页 工业厂房--列表
    public static final String PLANT_LIST= "index.php/app/house/plant_list";

    //首页 热门搜索词语
    public static final String CIYU= "index.php/app/index/ciyu";


    //首页 新房--优惠领取
    public static final String DISCOUNT= "index.php/app/indexnewhouse/discount";


    //首页 聊天--根据用户id获取昵称|头像
    public static final String MSG= "index.php/app/index/msg";

    //首页 分享
    public static final String SHARE= "index.php/app/map/share";

    //首页 地图--二手房|租房
    public static final String HOUSE_MAP= "index.php/app/map/house_map";

    //首页 地图找房--二手房|租房 根据经纬度获取房源
    public static final String MAPHOUSE= "index.php/app/map/maphouse";


    //首页 地图--获取新房
    public static final String MAP_NEWHOUSE= "index.php/app/map/map_newhouse";

    //首页 地图找房--根据经纬度获取新房列表
    public static final String MAPNEWHOUSE= "index.php/app/map/mapnewhouse";
//    public static final int

    //首页 编辑--展示（写字楼|商铺|产房）
    public static final String LEASEVIEW= "index.php/app/lease/view";


    //首页  编辑（商铺、工厂、写字楼）--提交f
    public static final String LEASEEDIT= "index.php/app/lease/edit";

    //首页  编辑（商铺、工厂、写字楼）--提交
    public static final String CZVIEW= "index.php/app/lease/czview";

    //首页  编辑（商铺、工厂、写字楼）--提交
    public static final String CZEDIT= "index.php/app/lease/czedit";

    //首页  资料编辑
    public static final String SUB_MESSAGE= "index.php/app/home/sub_message";


    //首页  装修商--查看
    public static final String ZX_VIEW= "index.php/app/home/zx_view";

    //首页  装修商--购买查看
    public static final String SUB_VIEW= "index.php/app/home/sub_view";
    //首页  装修商--购买查看
    public static final String VIEW_LOG= "index.php/app/home/view_log";

    //首页  装修商列表--广告
    public static final String ADV= "index.php/app/home/adv";

    //首页  方厂商个人信息--编辑
    public static final String DATA_SUB= "index.php/app/newhouse/data_sub";



    //首页  根据城市id--查找城市名
    public static final String CITYNAME= "index.php/app/index/cityname";

    //首页  根据城市id--查找城市名
    public static final String VIEW_PART= "index.php/app/newhouse/view_part";

    //首页  根据下级--获取上级城市id以及名称
    public static final String P_CITYT= "index.php/app/index/p_cityt";


    //首页  查看卷--购买--支付宝
    public static final String ALIPAYVIEW= "index.php/app/alipay/view";

    //首页  竞拍--缴纳保证金--支付宝
    public static final String ALIPAYBOND= "index.php/app/alipay/bond";

    //首页  房源置顶--支付宝  支付后重新请求第一页的数据？
    public static final String ZHIDING= "index.php/app/alipay/zhiding";


    //首页  经纪人--详情
    public static final String AGENT_DETAIL= "index.php/app/agent/agent_detail";


    //首页  经纪人--详情
    public static final String XIALA= "index.php/app/agent/xiala";

    //首页
    public static final String SHIXIAO= "index.php/app/index/shixiao";

}
