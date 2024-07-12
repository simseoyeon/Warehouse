//입출고 등록 유효성 검사
function registInout(){
	const form = document.inoutForm;
	const p_code = form.p_code.value;//제품코드
	const t_cnt = form.t_cnt.value; //수량
	const t_date = form.t_date.value; //거래일자
	const c_code = form.c_code.value; //거래처
	
	if (p_code == "") {
		window.alert("제품코드가 입력되지 않았습니다!");
		form.p_code.focus();
		return;
	}
	if (t_cnt == "") {
		window.alert("수량이 입력되지 않았습니다!");
		form.p_code.focus();
		return;
	}
	if (t_date == "") {
		window.alert("거래일자가 입력되지 않았습니다!");
		form.t_date.focus();
		return;
	}
	if (c_code  == "") {
		window.alert("거래처를 선택하세요!");
		form.c_code.focus();
		return;
	}
	
	window.alert("입출고등록이 정상적으로 등록되었습니다.");
	form.submit();
}


//입출고 등록 다시쓰기
function resetInout(){
	const form = document.inoutForm;
	window.alert("정보를 지우고 처음부터 다시 입력 합니다.")
	inoutForm.reset();
	inoutForm.p_code.focus();
}