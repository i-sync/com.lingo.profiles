function ready(b){
	if(document.addEventListener)document.addEventListener("DOMContentLoaded",b,!1);
	else{
		var a=document.createElement("script");
		document.getElementsByTagName("head")[0].appendChild(a);
		a.defer=!0;
		a.onreadystatechange=function(){
			"complete"==a.readyState&&b();
		}
	}
};

//检测浏览器
var browser = {
    versions: function () {
        var u = navigator.userAgent,
            app = navigator.appVersion;
        return {
            trident: u.indexOf('Trident') > -1,
            presto: u.indexOf('Presto') > -1,
            webKit: u.indexOf('AppleWebKit') > -1,
            gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') == -1,
            mobile: !!u.match(/AppleWebKit.*Mobile.*/) || !!u.match(/AppleWebKit/),
            ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/),
            android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1,
            iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1,
            iPad: u.indexOf('iPad') > -1,
            webApp: u.indexOf('Safari') == -1,
            chrome: u.indexOf('Chrome') > -1
        };
    }(),
    language: (navigator.browserLanguage || navigator.language).toLowerCase()
}

function getClass(tagName, className) {
    if (document.getElementsByClassName) {
        return document.getElementsByClassName(className);
    } else {
        var aEle = tagName.getElementsByTagName('*');
        var aResult = [];
        var re = new RegExp('\\b' + className + '\\b', 'i');

        for (var i = 0; i < aEle.length; i++) {
            if (aEle[i].className.search(re) != -1) {
                aResult.push(aEle[i]);
            }
        }
        return aResult;
    }
}
function fullpages(){
				$('#fullpage').fullpage({
					controlArrowColor:'#666',
					anchors:['page1','page2','page3','page4','page5'],
					css3:true,
					fixedElements:'#header',
					keyboardScrolling:true,
					touchSensitivity:5,
					menu:'#menu',
					navigation:true,
					navigationPosition:'right',
					navigationTooltips:['About','Skills','Works','Education','Experience'],
					showActiveTooltip:true,
					slidesNavigation:true,
					slidesNavPosition:'bottom',
					afterLoad:function(link,index){
						switch(index){
							case 1:
								move('.section1 h1').scale(0.5).end();
								move('.section1 .wrap').set('opacity','1').end();
								break;
							case 2:
							    move('.section2 h1').set('opacity','1').end();
							    move('.section2 .data-skill').set('opacity','1').end();
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
							    
							    break;
							default:
							break;
						}
					},
					onLeave:function(link,index){
						switch(index){
							case 1:
							    move('.section1 h1').scale(1).end();
							    move('.section1 .wrap').set('opacity','0').end();
								break;
							case 2:
							    move('.section2 h1').set('opacity','0').end();
							    move('.section2 .data-skill').set('opacity','0').end();
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							default:
								break;	
						}
					}
				});
	};
/*section3*/
function owlDemo() {
  $("#owl-example").owlCarousel({
    navigation : true
  });
 
}
//section5
function exprience(){
    var oBox =document.getElementById("exprience_box");
    var aItem = getClass(oBox,'exprience_text');
    var oPrev = getClass(oBox,'exprience_prev')[0];
    var oNext = getClass(oBox,'exprience_next')[0];
    var mobileTip =document.getElementById("mobile_tip");
    var iNow = 0;
    var rad = parseInt(Math.random() * aItem.length - 1);
    iNow = rad;
    tab('bounceIn');
    function tab(moveType){
        for(var i=0;i<aItem.length;i++){
            aItem[i].className = 'exprience_text clearfix';
        }
        aItem[iNow].className = 'exprience_text clearfix animated ' + moveType + ' exprience_text_current';
    }
    if(browser.versions.iPhone && window.screen.width <= 768 || document.documentElement.clientWidth <= 768){
        for(var i=0;i<aItem.length;i++){
            aItem[i].onclick = function(){
                iNow++;
                if(iNow == aItem.length){
                    iNow=0;
                }
                mobileTip.style.display = 'none';
                tab('bounceIn');
            }
        }
    }
    else{
        //清除事件
        for(var i=0;i<aItem.length;i++){
            aItem[i].onclick = null;
        }
        //清除提示
        mobileTip.style.display = 'none';
        oPrev.onclick = function(){
            iNow--;
            if(iNow == -1){
                iNow = aItem.length - 1;
            }
            tab('flipInX');
        }
        oNext.onclick = function(){
            iNow++;
            if(iNow == aItem.length){
                iNow = 0;
            }
            tab('flipInX');
        }
    }
};

function load(){
    fullpages();
    if($('#owl-example')){
        owlDemo();
    };
    
    if($('#exprience_box')){
        exprience();
    }
}
//load载入
ready(load);