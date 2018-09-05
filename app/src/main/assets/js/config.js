var http = 'http://jd.zyeo.net';
var paths = 'http://jd.zyeo.net/attachs/';
//var https = 'http://zhihui.zyeo.net';
var images_paths;

var //获取城市排序
	cityLisSorttUrl = http + '/index.php/app/index/px_city',
	//注册 验证码
	code = http + '/index.php/App/passport/code',
	//注册普通用户
	register = http + '	/index.php/App/passport/register',
	//登陆
	login = http + '	/index.php/App/passport/login',
	//忘记密码s
	forget = http + '/index.php/app/passport/forget',
	//忘记密码 修改密码
	set_passport = http + '/index.php/app/passport/set_passport',
	//经纪人根据上级城市id--获取下级
	area = http + '/index.php/app/index/xiaji',
	//提交资料
	user_data = http + '/index.php/App/passport/user_data',
	//上传图片
	upimg = http + '/index.php/App/index/upimg',
	/*******用户个人中心*********/
	//普通用户个人资料
	ziliao = http + '/index.php/app/user/ziliao',
	//修改普通用户个人资料
	edit_zl = http + '/index.php/app/user/edit_zl',
	//修改手机号 步骤1
	change_mobile = http + '/index.php/app/passport/change_mobile',
	//绑定新手机号 步骤2
	new_mobile = http + '/index.php/app/passport/new_mobile',
	//普通用户消息列表
	xiaoxi = http + '/index.php/app/user/xiaoxi',
	//普通用户消息列表详情
	xx_detail = http + '/index.php/app/user/xx_detail',
	//普通用户卖房列表
	llists = http + '/index.php/app/sellhouse/lists',
	//普通用户卖房列表删除
	del_house = http + '/index.php/app/sellhouse/del_house',
	//普通用户卖房小区获取列表
	xiaoqu = http + '/index.php/app/index/xiaoqu',
	//普通用户卖房3：分类id 4卖房 3出租 6卖房--写字楼 7卖房--商铺	8卖房--工业厂房 10出租--工业厂房 12出租--写字楼 13出租--商铺
	sselect = http + '/index.php/app/index/sselect',
	select = http + '/index.php/app/index/select',
	//普通用户委托拍卖 参与拍卖
	my_wtbidder = http + '/index.php/app/bidder/my_wtbidder',
	//普通用户委托拍卖 保证金
	bidder_bond = http + '/index.php/app/bidder/bidder_bond',
	//普通用户委托拍卖 我的提醒
	bidder_tx = http + '/index.php/app/bidder/bidder_tx',
	//普通用户委托拍卖 已拍下
	my_mallbidder = http + '/index.php/app/bidder/my_mallbidder',
	//普通用户委托拍卖 我的拍卖 1审核中 2进行中 3已拍卖 4流拍
	my_bidder = http + '/index.php/app/bidder/my_bidder',
	//普通用户其他委托--买房|求租--列表 	1买房 4求租
	qtwt = http + '/index.php/app/user/qtwt',
	//普通用户其他委托--办证|贷款 --列表 	5委托办证 6委托贷款
	wdaikuan = http + '/index.php/app/user/wdaikuan',
	//普通用户委托卖房|出租---列表 2卖房 3出租
	wtsell = http + '/index.php/app/user/wtsell',
	//需求大厅-- 买房|求租--详情
	mall_detail = http + '/index.php/app/demand/mall_detail',
	//需求大厅--卖房|出租--详情
	phose_detail = http + '/index.php/app/demand/phose_detail',
	//需求大厅--办证|贷款--详情
	daikuan_detail = http + '/index.php/app/demand/daikuan_detail',
	//首页 城市切换
	qhcity = http + '/index.php/app/index/qhcity',
	//获取省 
	province = http + '/index.php/app/index/province',
	//根据上级城市id--获取下级
	xiaji = http + '/index.php/app/index/xiaji',
	//	委托买房--发布
	wsell = http + '/index.php/app/sellhouse/wmall_fabu',
	//委托卖房|出租---发布
	wsell_fabu = http + '/index.php/app/sellhouse/wsell_fabu',
	//委托卖房|出租---发布
	qzu = http + '/index.php/app/sellhouse/qzu',
	//委托卖房|委托办证|委托贷款---发布
	wpermit_fabu = http + '/index.php/app/sellhouse/wpermit_fabu',
	//卖房-二手房 
	esfabu = http + '/index.php/app/sellhouse/esfabu',
	//卖房 6：写字楼 7：商铺 8：工业厂房
	sell_residence = http + '/index.php/app/sellhouse/fabu',
	//个人中心 问答列表
	my_question = http + '/index.php/app/question/my_question',
	//问答删除
	del_question = http + '/index.php/app/question/del_question',
	//问答发布
	wenda_fabu = http + '/index.php/app/question/fabu',
	//问答详情
	wenda_detail = http + '	/index.php/app/question/detail',
	//个人中心收藏列表 新房.
	newhouse_collect = http + '/index.php/app/user/newhouse_collect',
	//我的收藏--二手房|租房
	life_cang = http + '/index.php/app/user/life_cang',
	//我的收藏--商铺写字楼
	building = http + '/index.php/app/user/building',
	//我的收藏--工业厂房
	plant_collect = http + '/index.php/app/user/plant_collect',
	//我的收藏--家居|装修
	shop_collect = http + '/index.php/app/user/shop_collect',
	//看房记录
	mybm = http + '/index.php/app/user/mybm',
	//首页内容
	indexs = http + '/index.php/app/index/index',
	//新房
	newhouse = http + '/index.php/app/indexnewhouse/newhouse',
	//新房详情
	newhouse_detail = http + '/index.php/app/indexnewhouse/newhouse_detail',
	//新房评论列表
	comment = http + '/index.php/app/indexnewhouse/comment',
	//新房评论
	add_comment = http + '/index.php/app/indexnewhouse/add_comment',
	//新房获取优惠
	discount = http + '/index.php/app/indexnewhouse/discount',
	//收藏
	collect = http + '/index.php/app/index/collect',
	//取消收藏
	del_collect = http + '/index.php/app/user/del_collect',
	//二手房列表
	ershou_lists = http + '/index.php/app/house/index',
	//二手房详情
	ershou_detail = http + '/index.php/app/house/mall_detail',
	//房源举报
	report = http + '/index.php/app/index/report',
	//家居列表
	jiaju_lists = http + '/index.php/app/home/jiaju',
	//家居装修详情 
	jiaju_detail = http + '/index.php/app/home/detail',
	//装修列表 
	zhuangxiu_lists = http + '/index.php/app/home/zhuangxiu',
	//	家居--详情--旗舰店
	jiaju_shop = http + '/index.php/app/home/jiaju_shop',
	//装修banner
	zhuang_banners = http + '/index.php/app/home/adv',
	//装修估价
	guji = http + '/index.php/app/home/guji',
	//委托竞买 1新房 2二手房 3商铺写字楼 4工业厂房
	bidder_list = http + '/index.php/app/bidder/bidder_list',
	//竞买详情
	bidder_detail = http + '	/index.php/app/bidder/bidder_detail',
	//拍卖-竞拍
	cj_bidder = http + '/index.php/app/bidder/cj_bidder',
	//首页免费看房列表
	index_view_list = http + '/index.php/app/indexnewhouse/view_list',
	//首页免费看房详情
	view_detail = http + '/index.php/app/indexnewhouse/view_detail',
	//首页免费看房报名
	view_bm = http + '/index.php/app/indexnewhouse/view_bm',
	//首页	需求大厅--卖房|出租
	index_phouse = http + '/index.php/app/demand/phouse',
	//首页	需求大厅--买房|求租
	index_mall = http + '/index.php/app/demand/mall',
	// 需求大厅--办证|贷款
	index_daikuan = http + '	/index.php/app/demand/daikuan',
	//需求大厅--接单
	index_jiedan = http + '/index.php/app/demand/jiedan',
	//需求大厅-- 买房|求租--详情
	mall_detail = http + '/index.php/app/demand/mall_detail',
	//需求大厅--卖房|出租--详情
	phose_detail = http + '/index.php/app/demand/phose_detail',
	//	需求大厅--办证|贷款--详情
	daikuan_detail = http + '/index.php/app/demand/daikuan_detail',
	//首页	活动优惠|刚需房
	activity = http + '/index.php/app/index/activity';
	//首页 问答
	index_wenda = http + '/index.php/app/question/index',
	//房产问题--回答加载
	wenda_answer = http + '/index.php/app/question/answer',
	//问答 回答
	sub_answer = http + '/index.php/app/question/sub_answer',
	//房贷计算
	jisuan = http + '/index.php/mobile/index/shuifei.html',
	//房价趋势
	zoushi = http + '/index.php/app/index/zoushi';
//ajax
function request(URL, type, formdata, succCallback, errCallback) {
	$.ajax({
		type: "post",
		url: URL,
		data: formdata,
		dataType: 'json',
		headers: {
			Accept: "application/json; charset=utf-8"
		},
		beforeSend: function(XMLHttpRequest) {
			var lists = '<div class="loading_images hide"><img src="images/ajax-loader-overlay.gif"/></div>';
			$("body").append(lists);
			$(".loading_images").show();
		},
		success: function(res) {
			$(".loading_images").hide();
			succCallback(res);
		},
		errCallback: function(err) {
			$(".loading_images").hide();
			errCallback(err)
		}
	});
}

//上传图片
function uploadImg(inputId, url, successFun, errorFun) {
	console.log(inputId)
	var img = inputId.files[0];
	// 判断是否图片
	if(!img) {
		mui.toast("上传的文件不是图片，请重新选择")
		return;
	}
	//判断格式
	if(!inputId.value.match(/.jpg|.gif|.png|.bmp/i)) {
		mui.toast("上传的图片格式不正确，请重新选择");
		return;
	}

	var reader = new FileReader();
	reader.readAsDataURL(img);
	reader.onload = function(e) {
		var data = new FormData();
		data.append('file', img);
		// ajax 上传图片
		$.ajax({
			url: url,
			type: 'POST',
			data: data,
			contentType: false,
			processData: false,
			beforeSend: function(XMLHttpRequest) {
				var lists = '<div class="loading_images hide"><img src="images/ajax-loader-overlay.gif"/></div>';
				$("body").append(lists);
				$(".loading_images").show();
			},
			success: function(args) {
				$(".loading_images").hide();
				var data = JSON.parse(args);
				successFun ? successFun(data) : '';
			},

			fail: function() {
				mui.toast("上传的图片失败");
			}
		})
	} // reader onload end
}
//url截取
function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if(r != null) return unescape(r[2]);
	return null;
};

function timestampToTime(timestamp) {
	var date = new Date(timestamp * 1000); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
	Y = date.getFullYear() + '-';
	M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
	D = date.getDate() + ' ';
	// h = date.getHours() + ':';
	// m = date.getMinutes() + ':';
	// s = date.getSeconds();
	return Y + M + D;
}

//首页获取定位
function getCity() {
	var map, geolocation;
	//加载地图，调用浏览器定位服务  
	map = new AMap.Map('container', {
		resizeEnable: true
	});
	map.plugin('AMap.Geolocation', function() {
		geolocation = new AMap.Geolocation({
			enableHighAccuracy: true, //是否使用高精度定位，默认:true  
			timeout: 10000, //超过10秒后停止定位，默认：无穷大  
			buttonOffset: new AMap.Pixel(10, 20), //定位按钮与设置的停靠位置的偏移量，默认：Pixel(10, 20)  
			zoomToAccuracy: true, //定位成功后调整地图视野范围使定位位置及精度范围视野内可见，默认：false  
			buttonPosition: 'RB'
		});
		map.addControl(geolocation);
		geolocation.getCurrentPosition();
		AMap.event.addListener(geolocation, 'complete', onComplete); //返回定位信息  
		AMap.event.addListener(geolocation, 'error', onError); //返回定位出错信息  
	});
	//解析定位结果  
	function onComplete(data) {
		console.log(data)
		console.log(data.addressComponent.city);
		//市
		$.cookie("city_name", data.addressComponent.city);
		$(".city_span").text(data.addressComponent.city);
		//区
		$.cookie("qu_name", data.addressComponent.district);

	}
	//解析定位错误信息  
	function onError(data) {
		mui.toast("获取位置失败");
	}
}

//a标签href跳转
		mui('.a-href').on('tap', 'a', function() {
			window.top.location.href = this.href;
		});
		
