var currentPage = 'bookentry';

function showPage(page) {
    $('#'+currentPage).hide();
    $('#'+page).show();
    currentPage = page;
}

$(document).ready(function() {
    $('div[role=page]').hide();
    showPage(currentPage);

    $('#savebtn').off().on('click',function() {
		var b = {
			title: $('#title').val(),
			author: $('#author').val(),
			isbn: $('#isbn').val()
		};
		
		$.ajax({
			url: '/BookstoreExample/service/book',
			type: "POST",
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: JSON.stringify(b),
			success: function(data){
				$('#bookId').val(data.id);
				$('+summary').val(data.author+ ': '+data.title);
				showPage('bookconfirm');
			},
    	});
	});
	
    $('#backbtn').off().on('click',function() {
        showPage('bookentry');
    });
});