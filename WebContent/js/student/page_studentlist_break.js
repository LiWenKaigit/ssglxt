$(function(){
	get_ListBreakecaseInformationByPageAndSearch();
})

function get_ListBreakecaseInformationByPageAndSearch(){
	$
	.post(
			'/ssglxt/Break/Break_getBreakListBysearchPage',
			{'breakVO.break_studentId':$('#input_PoliceSearchText').val(),"breakVO.currPage" : "1"},
			function(xhr) {
				var data_list = xhr.ssglxt_breakList;
				var str = '';
				for (var len = 0; len < data_list.length; len++) {
					
					str += '<tr>';
					str += '<td>'
						+ '<input  type="checkbox" class="checkbox_select" value="'
						+ data_list[len].break_id
						+ '" >'
						+ '</td>';
					str += '<td>' + (len + 1) + '</td>';// 序号
					str += '<td>' + data_list[len].break_studentId//学号
							+ '</td>';
					str += '<td>' + data_list[len].break_studentId//姓名
					+ '</td>';
					str += '<td>' + data_list[len].break_time//违规时间
					+ '</td>';
					str += '<td>' + data_list[len].break_reason//违规情况
					+ '</td>';
					
					str += '<td>'
						+ '<i id="'
						+ data_list[len].break_id
						+ '" data-toggle="modal" data-target="#updateBreak" onclick=getBreak("'+data_list[len].break_id+'") class="fa fa-pencil-square-o role_one" aria-hidden="true"></i>'
						+ '</td>';
						str += '</tr>';
					
				}
				// 加载案件列表到表格中
				$('.onestudentbreakcase_table_info tbody').html(str); // 操作点击事件
			}, 'json')
}