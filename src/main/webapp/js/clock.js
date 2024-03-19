/**
 * 시계는 아침부터 똑딱똑딱
 */


window.onload = function() {
	timmer();
}

function timmer() {

	var now = new Date();
	var second = now.getSeconds();
	var hours = now.getHours();
	var minutes = now.getMinutes();
	if (second < 10) {
		second = "0" + second;
	}
	if (hours < 10) {
		hours = "0" + hours;
	}
	if (minutes < 10) {
		minutes = "0" + minutes;
	}
	var nowTime = hours + ":" + minutes + ":" + second;


	document.getElementById("clock").innerHTML = nowTime;
	setTimeout("timmer()", 1000);
}
